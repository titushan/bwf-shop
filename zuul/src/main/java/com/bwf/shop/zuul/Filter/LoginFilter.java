package com.bwf.shop.zuul.Filter;

import com.bwf.shop.zuul.bean.po.User;
import com.bwf.shop.zuul.mapper.UserMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
@PropertySource("classpath:interceptor.properties")
@ConfigurationProperties(prefix = "bwf")
public class LoginFilter extends ZuulFilter {

    @Resource
    private UserMapper userMapper;
    private String base_url;
    private List<String> interceptor_urls;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;   // 设定过滤类型 - PRE 路由前过滤
    }

    @Override
    public int filterOrder() {
        return 0;      // 设定过滤顺序 - 数字越小越先执行
    }

    @Override
    public boolean shouldFilter() {
        // 获取当前请求上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 获取当前请求对象
        HttpServletRequest request = requestContext.getRequest();

        // 循环拦截列表
        for( String iurl : interceptor_urls ){
            if( request.getRequestURL().toString().startsWith (base_url+iurl) ){
                // 获取当前请求报文头信息中的token信息
                String token = request.getHeader("Authorization");
                System.out.println("====> token = " + token);
                requestContext.addZuulRequestHeader("Authorization",token);
                if( token != null ){
                    User user = userMapper.getUserByToken(token);
                    System.out.println("====> user = " + user.getUser_name());
                    if( user != null ){
                        requestContext.addZuulRequestHeader("user_id",user.getUser_id()+"");
                        requestContext.setSendZuulResponse(true);
                        requestContext.setResponseStatusCode(200);
                        return true;
                    }else{
                        requestContext.setSendZuulResponse(false);
                        requestContext.setResponseStatusCode(401);
                        return false;
                    }
                }else{
                    requestContext.setSendZuulResponse(false);
                    requestContext.setResponseStatusCode(401);
                    return false;
                }
            }
        }
        requestContext.setSendZuulResponse(true);
        requestContext.setResponseStatusCode(200);
        return true;

    }

    @Override
    public Object run() throws ZuulException {
        return null;    // 过滤通过后要返回值
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public List<String> getInterceptor_urls() {
        return interceptor_urls;
    }

    public void setInterceptor_urls(List<String> interceptor_urls) {
        this.interceptor_urls = interceptor_urls;
    }
}
