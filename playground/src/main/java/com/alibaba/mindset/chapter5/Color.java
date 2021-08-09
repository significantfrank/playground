package com.alibaba.mindset.chapter5;

/**
 * Color
 *
 * @author Frank Zhang
 * @date 2021-08-09 11:01 AM
 */
public interface Color {
    void bePaintedWith(String penType, String name);
}

class Red implements Color{
    @Override
    public void bePaintedWith(String penType, String name) {
        System.out.println(penType + "红色的" + name + ".");
    }
}

class Green implements Color{
    @Override
    public void bePaintedWith(String penType, String name) {
        System.out.println(penType + "绿色的" + name + ".");
    }
}

class White implements Color{
    @Override
    public void bePaintedWith(String penType, String name) {
        System.out.println(penType + "白色的" + name + ".");
    }
}

class Blue implements Color{
    @Override
    public void bePaintedWith(String penType, String name) {
        System.out.println(penType + "蓝色的" + name + ".");
    }
}

class Black implements Color{
    @Override
    public void bePaintedWith(String penType, String name) {
        System.out.println(penType + "黑色的" + name + ".");
    }
}