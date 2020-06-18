package cn.edu.tjrac.booksale.config;


import org.jboss.logging.Logger;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class CorsConfiguration extends WebMvcConfigurerAdapter {
    private Logger logger = Logger.getLogger(getClass());

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("*****************************全局跨域配置开始*******************************");
        registry.addMapping("/**")    //匹配了所有的URL
                .allowedHeaders("*")  //允许跨域请求包含任意的头信息
                .allowedMethods("*")  //允许外域发起请求任意HTTP Method
                .allowedOrigins("*"); //允许所有的外域发起跨域请求
    }
}
