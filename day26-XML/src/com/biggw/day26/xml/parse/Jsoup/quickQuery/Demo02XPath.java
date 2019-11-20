package com.biggw.day26.xml.parse.Jsoup.quickQuery;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author gw
 * @date 2019/11/17 0017 下午 14:57
 */


/*

2. XPath：XPath即为XML路径语言，它是一种用来确定XML（标准通用标记语言的子集）文档中某部分位置的语言
			* 使用Jsoup的Xpath需要额外导入jar包。
			* 查询w3cshool参考手册，使用xpath的语法完成查询

 */
public class Demo02XPath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1.获取student.xml的path
        String path = Demo02XPath.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        // Jsoup 中Document对象不支持XPath语法,所以我们需要根据document对象实例创建一个JXDocument对象
        // （发音） J X Document
        //3.根据document对象，创建JXDocument对象 JXDocument
        JXDocument jxDocument = new JXDocument(document);

        // 4.结合XPath语法查询
        // 4.1 查询所有的student标签
        //            //查询任意位置的标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);
        }

        System.out.println("=============================================");


        // 4.2 查询所有student标签下的name标签
        //            / 查询指定标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("=============================================");


        // 4.3 查询student标签下带有id属性的name标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@hh]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        System.out.println("=============================================");


        // 4.4 查询student标签下带有id属性的name标签 并且id属性值为itcast
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@hh='属性1']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }
    }

}
