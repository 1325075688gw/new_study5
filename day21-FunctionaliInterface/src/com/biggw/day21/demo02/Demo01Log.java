package com.biggw.day21.demo02;

/**
 * @author gw
 * @date 2019/11/11 0011 下午 21:27
 */
public class Demo01Log {
    public static void main(String[] args) {

        String msg1 = "Hello";
        String msg2 = "Python";
        // 因为输入的level等于2,所以printLog并不会打印任何信息,但是两个字符串白拼接了,造成了资源的浪费
        printLog(2, msg1+msg2);
    }

    private static void printLog(int level, String msg) {
        if(level == 1){
            System.out.println("msg = " + msg);
        }
    }
}
