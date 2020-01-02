package com.alibaba.craftsman.book.chapter4;

/**
 * AreaCalculatable
 *
 * @author Frank Zhang
 * @date 2019-06-19 10:53
 */
public interface AreaCalculatable {
    public int area();
}


class Rectangle2 implements AreaCalculatable{
    protected int width;
    protected int height;

    @Override
    public int area() {
        return width * height;
    }
}


class square2 implements AreaCalculatable{
    protected int a;

    @Override
    public int area() {
        return a * a;
    }
}

//Parallelogram