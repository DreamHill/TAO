package com.matbom.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccessFilter extends ZuulFilter {

    @Override//filterType:过滤器类型，决定了过滤器在哪个周期生效。类型有pre、route、post、error，对应Spring AOP里的前加强、前后加强、后加强、异常处理
    public String filterType() {
        return "pre";
    }

    @Override//filterOrder:过滤器的执行顺序，多个过滤器同时存在时根据这个order来决定先后顺序，越小优先级越高
    public int filterOrder() {
        return 0;
    }

    @Override//shouldFilter:过滤器是否被执行，只有true时才会执行run()里的代码。我们这里除开访问163会放行其他情况都需要进行过滤判断，在生产环境一般是要根据函数条件来判断的。
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        if(request.getRequestURI().equals("/163")) {
//            return false;
//        }else {
//            return true;
//        }
        return false;
    }

    @Override//过滤逻辑
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s AccessFilter request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("accessToken");
        if(null != accessToken && accessToken.equals("123456")) {// 如果请求的参数不为空，且值为chhliu时，则通过
            ctx.setSendZuulResponse(true);// 对该请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
            return null;
        }else{
            ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
            ctx.setResponseStatusCode(401);// 返回错误码
            ctx.setResponseBody("{\"result\":\"用户尚未登录！\"}");// 返回错误内容
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
