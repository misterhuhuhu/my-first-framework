package com.who.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@WebFilter("/*")
public class HystrixRequestContextInitFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext.initializeContext();
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
