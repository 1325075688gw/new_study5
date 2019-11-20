package com.biggw.day21.demo02;

/**
 * @author gw
 * @date 2019/11/11 0011 下午 21:38
 */

/*
 * lambda:延迟计算
 * lambda:必须要有函数式接口
 * */
public class Demo02LogLambda {
    public static void main(String[] args) {
        String msg1 = "Hello,";
        String msg2 = "Python,";
        String msg3 = "Java,";
        String msg4 = "C++,";
        String msg5 = "C#,";
        String msg6 = "Go.";
        printLog(1, new MessageBuilder() {
            @Override
            public String messageBulider(String... arr) {
                System.out.println("使用匿名内部类");
                String res = "";
                for (String string : arr) {
                    res += string;
                }
                return res;
            }
        }, msg1, msg2);

        printLog(1, (String... arr) -> {
            System.out.println("使用函数式接口编程");
            String res = "";
            for (String string : arr) {
                res += string;
            }
            System.out.println("res = " + res);
            return res;
        },msg1,msg2);
    }

    private static void printLog(int level, MessageBuilder msb, String... arr) {
        if (level == 1) {
            System.out.println("msg: " + msb.messageBulider(arr));
        }
    }
}
interface MessageBuilder {
    public abstract String messageBulider(String... arr);
}
