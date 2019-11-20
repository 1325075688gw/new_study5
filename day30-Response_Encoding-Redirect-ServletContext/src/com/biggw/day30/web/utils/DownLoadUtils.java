package com.biggw.day30.web.utils;

// import sun.misc.BASE64Encoder; 弃用
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


// 当下载的文件的文件名是中文时候，下载弹出框的名称会出现乱码，我们需借助工具包进行修正

public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            // 弃用
            // BASE64Encoder base64Encoder = new BASE64Encoder();
            // filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";

            // 现在用
            Encoder encoder = Base64.getEncoder();
            filename = "=?utf-8?B?" + encoder.encode(filename.getBytes("utf-8")) + "?=";

        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
