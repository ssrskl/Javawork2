package com.maoyan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Maoyan
 * @data 2020/3/27 15:20
 * @Version 1.0.0
 */
@WebFilter(filterName = "FristFilter")
public class FristFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("filter被执行了");

        System.out.println("Servlet被拦截");
        //放行
        chain.doFilter(req, resp);

        System.out.println("Servlet被放行");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
