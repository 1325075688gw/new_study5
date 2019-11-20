package com.biggw.day23.CheckZhuJie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author gw
 * @date 2019/11/14 0014 下午 14:08
 */
public class CalcutorTest {
    public static void main(String[] args) throws IOException {

        Calcutor calcutor = new Calcutor();
        Class<? extends Calcutor> aClass = calcutor.getClass();
        Class<Check> checkClass = Check.class;
        Method[] methods = aClass.getMethods();

        int count = 0;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\code\\Java\\basic_code_new\\day23-Junit\\src\\com\\biggw\\day23\\CheckZhuJie\\exception.txt",true));
        for (Method method : methods) {
            if(method.isAnnotationPresent(checkClass)){
                try {
                    method.invoke(calcutor);
                }
                catch (Exception e){
                    count ++;
                    bufferedWriter.write("出现异常的函数: "+method.getName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常的类型: "+e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常出现的原因: " + e.getCause().getMessage());
                    bufferedWriter.newLine();
                }
            }
        }
        bufferedWriter.write("一共出现: "+count+"个异常");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
