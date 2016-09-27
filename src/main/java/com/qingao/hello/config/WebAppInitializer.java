package com.qingao.hello.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by qingao on 16-8-10.
 */
@Configuration
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {MyConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        /*Filter timeFilter = new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
                logger.debug("xFilter init....");
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                    throws IOException, ServletException {
                long startTime = System.currentTimeMillis();
                logger.debug("doing xFilter");
                chain.doFilter(request,response);
                if (request instanceof HttpServletRequest) {
                    String msg = String.format("Finish request : %s ; consumed %dms",
                            ((HttpServletRequest) request).getRequestURL(),(System.currentTimeMillis()-startTime) );
                    logger.debug(msg);
                }
            }

            @Override
            public void destroy() {
                logger.debug("xFilter destroyed");
            }
        };
        //Filter for request
        Filter characterEncodingFilter = new CharacterEncodingFilter("UTF-8",true);
        servletContext.addFilter("encoding-filter", characterEncodingFilter).addMappingForUrlPatterns(null,false,"*//*");
        FilterRegistration.Dynamic dynamic = servletContext.addFilter("xFilter", timeFilter);
        dynamic.addMappingForUrlPatterns(null,false,"*//*");
*/
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter("UTF-8",true),new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
                logger.debug("xFilter init....");
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                    throws IOException, ServletException {
                long startTime = System.currentTimeMillis();
                logger.debug("doing xFilter");
                chain.doFilter(request,response);
                if (request instanceof HttpServletRequest) {
                    String msg = String.format("Finish request : %s ; consumed %dms",
                            ((HttpServletRequest) request).getRequestURL(),(System.currentTimeMillis()-startTime) );
                    logger.debug(msg);
                }
            }

            @Override
            public void destroy() {
                logger.debug("xFilter destroyed");
            }
        }
        };
    }
    /*    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setMultipartConfig(new MultipartConfigElement("/tmp/web/uploads",2*1024*1024,4*1024*1024,0));
    }*/

}
