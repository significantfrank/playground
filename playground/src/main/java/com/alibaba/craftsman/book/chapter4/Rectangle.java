package com.alibaba.craftsman.book.chapter4;

/**
 * Rectangle
 *
 * @author Frank Zhang
 * @date 2019-06-19 10:47
 */

public class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area(){
        return width * height;
    }

}

class Square extends Rectangle {

    @Override
    public void setWidth(int width){
        throw new RuntimeException("setWidth is not available for Square");
    }

    @Override
    public void setHeight(int height){
        throw new RuntimeException("setHeight is not available for Square");
    }

    public void setLength(int length){
        this.width = this.height = length;
    }
}
