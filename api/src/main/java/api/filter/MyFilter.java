package api.filter;

import api.request.RequestContext;
import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author max.hu  @date 2023/12/01
 **/
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filterConfig: {}", filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("ServletRequest: {}", request);
        log.info("ServletResponse: {}", response);
        log.info("FilterChain: {}", chain);
//        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("filter destroy");
        RequestContext.clear();
    }
}
