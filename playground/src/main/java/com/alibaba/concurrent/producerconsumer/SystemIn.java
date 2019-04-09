package com.alibaba.concurrent.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * SystemIn
 *
 * @author Frank Zhang
 * @date 2018-05-02 3:07 PM
 */
public class SystemIn<String> extends AbstractBatchProcessor {

    public SystemIn(){
        super();
    }

    public SystemIn(int queueSize, int consumerSize){
        super(queueSize, consumerSize);
    }

    @Override
    public Consumer<java.lang.String> createConsumer() {
       return (s) -> {
            System.out.println(Thread.currentThread().getName() + " Consumed message: " + s);
            System.out.println("Hello world Functional programming");
        };
    }

    @Override
    public List<java.lang.String> produceBatch() {
        List<java.lang.String> initialBatch = new ArrayList<java.lang.String>();
        initialBatch.add("dd");
        initialBatch.add("bdfd");
        return initialBatch;
    }
}
