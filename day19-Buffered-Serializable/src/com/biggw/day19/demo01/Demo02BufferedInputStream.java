package com.biggw.day19.demo01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 16:02
 */
public class Demo02BufferedInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo01\\a.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        int len = 0;
        // 用byte数组，进一步提高效率
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, len));
        }
        bufferedInputStream.close();
    }
}
