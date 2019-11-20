package com.biggw.day18.demo03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 13:08
 */
public class TryCatchFile {
    public static void main(String[] args) {

        // 提高变量fileWriter的作用域,让finally可以使用
        // 局部变量在定义时候,可以没有值,但是使用的时候必须有值
        //  fileWriter =new FileWriter("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo03");
        //  上面句,如果没有执行成功,fileWriter就为空,fileWriter就会报错
        FileWriter fileWriter = null;
        try {
            fileWriter =new FileWriter("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo03\\a.txt");
            for (int i = 0; i < 5; i++) {
                fileWriter.write("你好:"+i+"\r\n");
            }
            fileWriter.flush();
        }catch (IOException e){
            System.out.println("e = " + e);
        }finally {
            // 对象创建失败,我们就不能fileWriter.close(),否则会NullPointerException
            if (fileWriter != null) {
                try {
                    // fileWriter.close()还会报错,所以要捕捉
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
