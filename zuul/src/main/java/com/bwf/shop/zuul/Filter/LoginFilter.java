package com.bwf.shop.zuul.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;   // 设定过滤类型 - PRE 路由前过滤
    }

    @Override
    public int filterOrder() {
        return 0;       // 设定过滤顺序 - 数字越小越先执行
    }

    @Override
    public boolean shouldFilter() {
        // 获取当前请求上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 获取当前请求对象
        HttpServletRequest request = requestContext.getRequest();
        // 获取当前请求报文头信息中的token信息
        String token = request.getHeader("Authorization");
        requestContext.addZuulRequestHeader("Authorization",token);

        System.out.println("====> token = " + token);

        // 判断是否有token
        if( token == null || token.isEmpty() ){
            // 拦截
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return false;
        }else{
            // 通过
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(200);
            return true;
        }
    }

    @Override
    public Object run() throws ZuulException {
        return null;    // 过滤通过后要返回值
    }
}
