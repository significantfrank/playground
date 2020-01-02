package com.alibaba.craftsman.book.chapter6.pipeline;

/**
 * StandardPipeline
 *
 * @author Frank Zhang
 * @date 2019-05-09 12:40
 */
public class StandardPipeline implements Pipeline {
    protected Valve head;
    protected Valve tail;

    public Valve getHead() {
        return head;
    }

    public Valve getTail() {
        return tail;
    }

    public void setTail(Valve v) {
        tail = v;
    }

    public void addValve(Valve v) {
        if (head == null) {
            head = v;
            v.setNext(tail);
        } else {
            Valve current = head;
            while (current != null) {
                if (current.getNext() == tail) {
                    current.setNext(v);
                    v.setNext(tail);
                    break;
                }
                current = current.getNext();
            }
        }
    }

}
