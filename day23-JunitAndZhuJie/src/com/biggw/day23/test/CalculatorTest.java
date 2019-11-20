package com.biggw.day23.test;

import com.biggw.day23.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author gw
 * @date 2019/11/13 0013 上午 10:41
 */
public class CalculatorTest {

    /**
     * 一般用于资源申请,所有测试方法在执行之前都会自动执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * 一般用于资源释放,所有测试方法在执行之后都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close...");
    }

    /**
     * 测试add()方法
     */
    @org.junit.Test
    public void testAdd() {
        // 创建对象
        Calculator calculator = new Calculator();
        // 调用add()方法
        int res = calculator.add(1, 2);
        // 直接输出,但是一般我们不采用这种测试方法
        // System.out.println(res);
        System.out.println("执行testAdd()方法");
        Assert.assertEquals(3, res);
    }

    //未添加注解,则该方法不会执行
    @Test
    public void testSub() {
        Calculator calculator = new Calculator();
        int res = calculator.sub(1, 2);
        System.out.println("执行testSub()方法");
        Assert.assertEquals(-1, res);
    }
}
