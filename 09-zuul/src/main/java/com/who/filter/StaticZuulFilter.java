package com.who.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 静态路由
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@Component
public class StaticZuulFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        // 开启当前过滤器
        return true;
    }

    @Override
    public Object run()  {
        System.out.println("    prefix filter START ");
        final var currentContext = RequestContext.getCurrentContext();
        System.out.println("    RequestURI-> "+currentContext.getRequest().getRequestURI());
        System.out.println("    getRequestURL-> "+currentContext.getRequest().getRequestURL());
        System.out.println("    Response: "+currentContext.getResponse());
        System.out.println("    prefix filter END   ");
        return null;
    }
}
