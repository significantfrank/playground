package com.alibaba.mindset.chapter5;

/**
 * Pen
 *
 * @author Frank Zhang
 * @date 2021-08-09 11:01 AM
 */
public abstract class Pen {
    protected Color color;

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void draw(String name);
}

class SmallPen extends Pen {
    @Override
    public void draw(String name) {
        String penType = "小号笔";
        this.color.bePaintedWith(penType, name);
    }
}

class MiddlePen extends Pen{
    @Override
    public void draw(String name) {
        String penType = "中号笔";
        this.color.bePaintedWith(penType, name);
    }
}

class BigPen extends Pen{
    @Override
    public void draw(String name) {
        String penType = "大号笔";
        this.color.bePaintedWith(penType, name);
    }
}

class Test {
    public static void main(String[] args) {
        Pen smallPen = new SmallPen();
        smallPen.setColor(new Red());
        smallPen.draw("Bridge Pattern");
        smallPen.setColor(new Green());
        smallPen.draw("Bridge Pattern");
    }
}
