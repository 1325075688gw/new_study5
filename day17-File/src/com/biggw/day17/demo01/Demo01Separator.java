package com.biggw.day17.demo01;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/8 0008 下午 23:31
 */

/*
 * file:与文件相关
 * directory:与文件夹/目录相关
 * path:路径
 *
 * static String pathSeparator();与系统有关的路径分隔符          Windows是;  Linux是:  (配置环境变量路径)
 * static char pathSeparatorChar();与系统有关的路径分隔符
 *
 *
 * static String separator();与系统有关的名称(文件)分隔符            Windows是\  Linux是/
 * static char separator();与系统有关的名称(文件)分隔符
 *
 * 路径中的反斜杠分割符\,是转义字符,两个\(反斜杠)才代表一个普通的反斜杠   ====> \\ 代表 \
 *
 *
 *
 * public String getAbsolutePath(); 返回此file的绝对路径的字符串
 * public String getPath(); 返回file的路径(原路径是相对的就返回相对的,是绝对的就返回绝对的)
 * public String getName(); 返回此File表示的文件或者目录(最后一级目录)  ::::意思就是返回File最后一个\\后面的东西
 * public long length(); 返回由此file表示的文件的长度(文件的大小:以字节表示)
 *
 * public boolean exists():判断file表示的文件或者目录存在与否
 * public boolean isDirectory():判断file是不是目录
 * public boolean isFile():判断file是不是文件
 *
 *
 * public boolean createNewFile(); 当且仅当该名称的文件不存在时候,创建一个新的空文件(注意:::::是创建文件,而不是文件夹)
 *      当文件不存在时候,创建文件,如果创建成功,返回true
 *      当文件存在的时候,创建文件,则创建失败,返回false
 *
 * public boolean delete();删除由此file表示的文件或者目录  （不走回收站,直接从硬盘删除,需要谨慎）
 *
 * public boolean mkdir();创建单级空文件夹
 * public boolean mkdirs();创建多级空文件夹
 *      只能创建文件夹，不能创建文件
 *      当文件夹不存在时候,创建文件,如果创建成功,返回true
 *      当文件夹存在的时候,创建文件,则创建失败,返回false
 *
 *
 * File类遍历文件夹/文件
 * public String[] list(); 返回一个String数组,里面是File目录中的所有子文件或者目录   【返回的是相对当前项目的路径】
 * public File[] listFiles(); 返回一个File数组,里面是File目录中的所有子文件或者目录  【返回的是绝对路径】
 *
 * 注意：
 *      1.如果路径不存在,会抛出空指针异常
 *      2.【如果路径是一个文件,而不是文件夹,也会抛出空指针异常】
 *
 *
 * 【过滤文件】
 * 创建FileFileter的实现类,重写过滤方法accept(),定义过滤规则
 * 1.会将File数组中的file依次传入accept中,判断过滤规则,返回true,则放入File数组中,返回false,则舍弃
 *
 * File[] files = dir.listFiles(new FileFilter() {
 *           @Override
 *           public boolean accept(File file) {
 *               // 返回false,就不放到Files数组里面去
 *               if (file.isDirectory())
 *                   return true;
 *               else if (file.getName().toLowerCase().endsWith("java"))
 *                   return true;
 *               else
 *                   return false;
 *           }
 *       });
 *
 *
 * */
public class Demo01Separator {
    public static void main(String[] args) throws IOException {
        // 常用
        File file = new File("c:\\");
        File file1 = new File(file, "a.txt");
        System.out.println("file1 = " + file1);

        // 第二种方式
        File file2 = new File("c:\\a.txt");
        System.out.println("file2 = " + file2);

        // 第三种方式
        File file3 = new File("c:\\", "a.txt");
        System.out.println("file3 = " + file3);

        // 不管file4是绝对路径还是相对路径,最后getAbsolutePath()都是绝对路径
        File file4 = new File("a.txt");
        String absolutePath = file4.getAbsolutePath();

        // 表示的其实是,相对于当前项目根目录的文件
        // absolutePath = D:\code\Java\basic_code_new\a.txt
        System.out.println("absolutePath = " + absolutePath);

        File file5 = new File("D:\\code\\Java\\basic_code_new\\a.txt");
        System.out.println("file5 = " + file5);

        // getPath() 获取路径,原路径是绝对就获取绝对路径,原路径是相对路径就获取相对路径
        // println调用的就是toString,toString调用的就是getPath()方法
        File file6 = new File("D:\\code\\Java\\basic_code_new\\a.txt");
        System.out.println("file6.getPath() = " + file6.getPath());
        System.out.println("file6 = " + file6);

        File file7 = new File("d.txt");
        System.out.println("file7.getPath() = " + file7.getPath());
        System.out.println("file7 = " + file7);

        // getName()
        File file8 = new File("D:\\code\\Java\\basic_code_new\\a.txt");
        System.out.println("file8 .getName= " + file8.getName());
        System.out.println("file8 = " + file8); // 调用getPath

        File file9 = new File("D:\\code\\Java\\basic_code_new");
        System.out.println("file9.getName() = " + file9.getName());
        System.out.println("file9 = " + file9); // 调用getPath


        // public long length(); 返回file表示的文件夹的长度(大小，多少个字节)
        // 注意：
        //      1.文件夹是没有大小概念的，不能获取文件夹的大小
        //      2.如果构造方法中给出的路径（文件或者文件夹）不存在,那么length方法返回0


        System.out.println("file9.length() = " + file9.length());


        // public boolean createNewFile();
        // 创建失败，因为该方法只能创建文件，而不能创建对象
        File file10 = new File("day17-File\\src\\com\\biggw\\day17");
        boolean newFile = file10.createNewFile();
        System.out.println("newFile = " + newFile);

        File file11 = new File("day17-File\\src\\com\\biggw\\day17\\a.txt");
        boolean newFile2 = file11.createNewFile();
        System.out.println("newFile2 = " + newFile2);

        // 再次创建会创建失败
        File file12 = new File("day17-File\\src\\com\\biggw\\day17\\a.txt");
        boolean newFile3 = file11.createNewFile();
        System.out.println("newFile3 = " + newFile3);

        // 遍历 String[]  最后一段文件或文件名
        File file13 = new File("day17-File\\src\\com\\biggw\\day17");
        String[] list = file13.list();
        for (String string : list) {
            System.out.println("string = " + string);
        }

        // 遍历 Files[]  绝对路径
        File[] files = file13.listFiles();
        for (File file14 : files) {
            System.out.println("file14 = " + file14);
        }


        // 遍历所有文件
        File file14 = new File("D:\\code\\Java\\basic_code_new\\day16-HanShu\\src\\com\\biggw\\day16");
        getAllFiles(file14);


        // 过滤出所有以.java结尾的文件
        System.out.println("=======================");
        getAllFileEndsWithxxx(file14);


        // 使用匿名内部类 FileFilter
        System.out.println("=======================");
        getAllFiles3(file14);

        // 使用匿名内部类 FileNameFilter
        System.out.println("=======================");
        getAllFiles4(file14);

        // 使用lambda函数
        System.out.println("=======================");
        getAllFiles5(file14);

    }

    public static void getAllFiles(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            // 文件和文件夹都会打印
            System.out.println("file = " + file);
            if (file.isDirectory()) {
                getAllFiles(file);
            }
        }
    }

    public static void getAllFileEndsWithxxx(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            // 文件和文件夹都会打印
            String name = file.getName();
            // 也可以用 file.getPath()
            // 也可以 file.toString(); 因为toString调用的就是getPath()

            // 忽略大小写
            if (name.toLowerCase().endsWith("java")) {
                System.out.println("file = " + file);
            }
            if (file.isDirectory()) {
                getAllFileEndsWithxxx(file);
            }
        }
    }

    public static void getAllFiles3(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                // 返回false,就不放到Files数组里面去
                if (file.isDirectory())
                    return true;
                else if (file.getName().toLowerCase().endsWith("java"))
                    return true;
                else
                    return false;
            }
        });
        for (File file : files) {
            // 文件和文件夹都会打印,所以不写在这
            // System.out.println("file = " + file);
            if (file.isDirectory()) {
                if (file.getName().toLowerCase().endsWith("java"))
                    System.out.println("file = " + file);
                getAllFiles(file);
            } else {
                System.out.println("file = " + file);
            }
        }
    }

    public static void getAllFiles4(File dir) {
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                // 返回false,就不放到Files数组里面去
                System.out.println("===");
                System.out.println("file = " + file);
                System.out.println("name = " + name);
                System.out.println("===");
                if (new File(file, name).isDirectory() || name.toLowerCase().endsWith("java"))
                    return true;
                else
                    return false;
            }
        });
        for (File file : files) {
            // 文件和文件夹都会打印,所以不写在这
            // System.out.println("file = " + file);
            if (file.isDirectory()) {
                if (file.getName().toLowerCase().endsWith("java"))
                    System.out.println("file = " + file);
                getAllFiles(file);
            } else {
                System.out.println("file = " + file);
            }
        }
    }

    public static void getAllFiles5(File dir) {
        File[] files = dir.listFiles((File file, String name) -> {
            // 返回false,就不放到Files数组里面去
            System.out.println("===");
            System.out.println("file = " + file);
            System.out.println("name = " + name);
            System.out.println("===");
            if (new File(file, name).isDirectory() || name.toLowerCase().endsWith("java"))
                return true;
            else
                return false;
        });
        for (File file : files) {
            // 文件和文件夹都会打印,所以不写在这
            // System.out.println("file = " + file);
            if (file.isDirectory()) {
                if (file.getName().toLowerCase().endsWith("java"))
                    System.out.println("file = " + file);
                getAllFiles(file);
            } else {
                System.out.println("file = " + file);
            }
        }
    }
}

/*
file1 = c:\a.txt
file2 = c:\a.txt
file3 = c:\a.txt
absolutePath = D:\code\Java\basic_code_new\a.txt
file5 = D:\code\Java\basic_code_new\a.txt
file6.getPath() = D:\code\Java\basic_code_new\a.txt
file6 = D:\code\Java\basic_code_new\a.txt
file7.getPath() = d.txt
file7 = d.txt
file8 .getName= a.txt
file8 = D:\code\Java\basic_code_new\a.txt
file9.getName() = basic_code_new
file9 = D:\code\Java\basic_code_new
file9.length() = 8192
newFile = false
newFile2 = false
newFile3 = false
string = a.txt
string = demo01
string = demo02
file14 = day17-File\src\com\biggw\day17\a.txt
file14 = day17-File\src\com\biggw\day17\demo01
file14 = day17-File\src\com\biggw\day17\demo02
 */
