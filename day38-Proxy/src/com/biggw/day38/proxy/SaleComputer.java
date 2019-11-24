package com.biggw.day38.proxy;

/**
 * @author gw
 * @date 2019/11/24 0024 下午 15:21
 */

// 卖电脑接口
public interface SaleComputer {
    // 卖电脑
    public String sale(String name, double money);

    // 运行电脑
    public void run(String name);
}
