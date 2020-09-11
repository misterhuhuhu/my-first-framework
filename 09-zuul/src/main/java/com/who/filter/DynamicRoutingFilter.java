package com.who.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;


/**
 * 动态路由.
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@Component
public final class DynamicRoutingFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        final int filterOrder = 2;
        return PRE_DECORATION_FILTER_ORDER + filterOrder;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }


    @Override
    public Object run() {
        //1. 获取Request对象
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        //2. 获取参数，redisKey
        String redisKey = request.getParameter("redisKey");

        final var provider = "provider";
        final var search = "provider";
        //3. 直接判断
        //输入访问http://localhost/v1/provider?redisKey=search
        //实际访问http://localhost/v2/provider/robbin
        if (redisKey != null && provider.equalsIgnoreCase(redisKey)) {
            context.put(FilterConstants.SERVICE_ID_KEY, "provider-v2");
            context.put(FilterConstants.REQUEST_URI_KEY, "/robbin");
        }
        //输入访问http://localhost/v1/provider/version?redisKey=search
        //实际访问http://localhost/consumer/search/1
        if (redisKey != null && search.equalsIgnoreCase(redisKey)) {

            context.put(FilterConstants.SERVICE_ID_KEY, "consumer");
            context.put(FilterConstants.REQUEST_URI_KEY, "/search/1");
        }

        return null;
    }
}
