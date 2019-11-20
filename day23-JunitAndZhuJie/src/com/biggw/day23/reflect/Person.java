package com.biggw.day23.reflect;

/**
 * @author gw
 * @date 2019/11/13 0013 下午 14:43
 */
public class Person {
    public String a;
    protected String b;
    String c;
    private String d;

    public Person() {
    }

    public Person(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public Person(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void eat(String name){
        System.out.println("name = " + name);
    }

    public void run(){
        System.out.println("我可以跑得很快");
    }

    @Override
    public String toString() {
        return "Person{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
