package com.who.entity;

/**
 * 模拟POJO类.
 *
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
public final class Customer {
    public Customer() {
    }

    public Customer(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(final Integer id, final String name, final Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private Integer id;


    private String name;

    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", age=" + age
                + '}';
    }

}
