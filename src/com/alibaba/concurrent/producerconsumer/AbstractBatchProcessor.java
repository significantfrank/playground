package com.alibaba.concurrent.producerconsumer;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * AbstractBatchProcessor
 *
 * This is a framework of Producer and Consumer for parallel batch processing elements
 *
 * 本设计的关键是抽象出两个概念：BatchQueue 和 ElementQueue
 *
 * 使用者需要自己去实现：
 * 1、如何去生产（produceBatch）
 * 2、如何去消费（createConsumer）
 *
 * @author Frank Zhang
 * @date 2018-05-02 11:08 AM
 */
public abstract class AbstractBatchProcessor<E> {

    private static final int DEFAULT_NUM_OF_CONSUMER = 9;
    private static final int DEFAULT_QUEUE_SIZE = 1000;

    /**
     * This is the real consumer for biz logic of consuming element
     */
    protected Consumer<E> realConsumer;

    private BlockingQueue<E> elementQueue;
    private ElementProducer<E> elementProducer;

    private ExecutorService es ;

    public AbstractBatchProcessor(){
        this(DEFAULT_QUEUE_SIZE, DEFAULT_NUM_OF_CONSUMER);
    }

    public AbstractBatchProcessor(int queueSize, int consumerNum){
        elementQueue = new ArrayBlockingQueue<>(queueSize);
        es = Executors.newFixedThreadPool(consumerNum + 1);
        elementProducer = new ElementProducer(elementQueue);

    }

    abstract public Consumer<E> createConsumer();
    abstract public List<E> produceBatch();

    public void start() {
        realConsumer = createConsumer();
        elementProducer.enqueueBatch(produceBatch());
        startProduce();
        startConsume();
    }

    private void startProduce() {
        es.execute(elementProducer);
    }

    private void startConsume() {
        for (int i = 1; i <= DEFAULT_NUM_OF_CONSUMER; ++i) {
            es.execute(new ElementConsumer(elementQueue, realConsumer));
        }
    }

    /**
     * Add elements batch for parallel processing
     *
     * @param batch The batch to be processed
     */
    public void addBatch(List<E> batch){
        elementProducer.enqueueBatch(batch);
    }


    /**
     * The consumer of element queue
     * @param <E> The type of Element
     */
    private static final class ElementConsumer<E> implements Runnable{
        private BlockingQueue<E> elementQueue;
        private Consumer<E> realConsumer;

        public ElementConsumer(BlockingQueue<E> elementQueue, Consumer<E> realConsumer) {
            this.elementQueue = elementQueue;
            this.realConsumer = realConsumer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    realConsumer.accept(elementQueue.take());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    /**
     * The producer of element queue
     * @param <E> The type of Element
     */
    private static final class ElementProducer<E> implements Runnable{
        private static final int DEFAULT_BATCH_QUEUE_SIZE = 10;

        private BlockingQueue <E> elementQueue;
        private BlockingQueue<List<E>> batchQueue = new ArrayBlockingQueue<>(DEFAULT_BATCH_QUEUE_SIZE);

        public ElementProducer(BlockingQueue elementQueue) {
            this.elementQueue = elementQueue;
        }

        @Override
        public void run() {
            try {
                while(true){
                    for(E element : batchQueue.take()){
                        elementQueue.put(element);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void enqueueBatch(List<E> batch) {
            try {
                batchQueue.put(batch);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
