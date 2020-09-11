package com.who.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 静态路由.
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@Component
@Slf4j
public final class StaticZuulFilter extends ZuulFilter {


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
    public Object run() {
        log.info("prefix filter START");
        final var currentContext = RequestContext.getCurrentContext();
        log.info("RequestURI:" + currentContext.getRequest().getRequestURI());
        log.info("etRequestURL:" + currentContext.getRequest().getRequestURL());
        log.info("Response:" + currentContext.getResponse());
        log.info("prefix filter END ");
        return null;
    }
}
