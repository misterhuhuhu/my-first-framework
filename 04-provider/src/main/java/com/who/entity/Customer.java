package com.who.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer id;

    private String name;

    private Integer age;
}
