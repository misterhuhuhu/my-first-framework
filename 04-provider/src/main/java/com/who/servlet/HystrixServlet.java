package com.who.servlet;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import javax.servlet.annotation.WebServlet;


/**
 * 显示HystrixDashboard.
 *
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@WebServlet("/hystrix.stream")
public class HystrixServlet extends HystrixMetricsStreamServlet {
}
