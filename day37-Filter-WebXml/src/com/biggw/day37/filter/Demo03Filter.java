package com.biggw.day37.filter;

import javax.servlet.DispatcherType;
import javax.servlet.annotation.WebFilter;

/**
 * @author gw
 * @date 2019/11/24 0024 下午 13:22
 */

// 默认是 DispatcherType.REQUEST
// 不管转发还是直接访问任何资源，都必须走过滤器
@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class Demo03Filter {

}
