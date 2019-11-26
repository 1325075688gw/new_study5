package com.biggw.day44.domain;

/**
 * @author gw
 * @date 2019/11/26 0026 下午 13:37
 */
public class Province {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
