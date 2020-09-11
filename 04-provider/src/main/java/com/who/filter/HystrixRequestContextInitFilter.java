package com.who.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * Hystrix请求缓存.
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@WebFilter("/*")
public final class HystrixRequestContextInitFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain)
            throws IOException, ServletException {
        HystrixRequestContext.initializeContext();
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
