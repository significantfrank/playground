package com.alibaba.craftsman.entity;

import lombok.Data;

/**
 * Customer
 *
 * @author Frank Zhang
 * @date 2019-01-13 3:24 PM
 */
@Data
public class Customer {
    private String name;
    private int age;
    private String email;
    private String cellPhone;
    private boolean isDomestic;
}
