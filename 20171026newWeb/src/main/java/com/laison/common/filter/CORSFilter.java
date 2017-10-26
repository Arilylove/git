package com.laison.common.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CORSFilter implements Filter {

 

    @Override

    public void init(FilterConfig filterConfig) throws ServletException {

 

    }

 

    @Override

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    	  String []  allowDomain= {"http://localhost:80","http://localhost:8080","http://www.laison.com:8080","http://api.laison.com:8080","http://www.laison.com","http://api.laison.com","http://192.168.0.30","http://192.168.0.30:8080"};
          Set<String> allowedOrigins= new HashSet<String>(Arrays.asList(allowDomain));
          String originHeader=((HttpServletRequest) servletRequest).getHeader("Origin");
          if (allowedOrigins.contains(originHeader)){
              ((HttpServletResponse) servletResponse).setHeader("Access-Control-Allow-Origin", originHeader);
              ((HttpServletResponse) servletResponse).setContentType("application/json;charset=UTF-8");
              ((HttpServletResponse) servletResponse).setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE");
              ((HttpServletResponse) servletResponse).setHeader("Access-Control-Max-Age", "3600");
              //表明服务器支持的所有头信息字段
              ((HttpServletResponse) servletResponse).setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
              //如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true;
              ((HttpServletResponse) servletResponse).setHeader("Access-Control-Allow-Credentials", "true"); 
              ((HttpServletResponse) servletResponse).setHeader("XDomainRequestAllowed","1");   
          }
          filterChain.doFilter(servletRequest, servletResponse);

    }

 

    @Override

    public void destroy() {

 

    }

}