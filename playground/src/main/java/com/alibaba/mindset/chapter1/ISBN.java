package com.alibaba.mindset.chapter1;

import java.awt.*;

/**
 * ISBN
 *
 * @author Frank Zhang
 * @date 2021-08-02 10:57 PM
 */
public interface ISBN {
    boolean isValid();
    Image generateBarcodeImg();
    String getPublisher();
    ISBN convertToISBN10();
    ISBN convertToISBN13();
}
