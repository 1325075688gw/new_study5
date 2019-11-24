package com.biggw.day38.proxy;

/**
 * @author gw
 * @date 2019/11/24 0024 下午 15:19
 */

// 联想厂商，可以卖电脑
public class Lenovo implements SaleComputer {
    @Override
    public String sale(String name, double money) {
        System.out.println(name + " 花了：" +money+"元买了一台联想笔记本！");
        return "联想电脑";
    }

    @Override
    public void run(String name) {
        System.out.println(name+"：电脑运行游戏很流畅！");
    }
}
