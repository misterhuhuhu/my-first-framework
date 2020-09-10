package com.who.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;

/**
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer id;

    private String name;

    private Integer age;
}
