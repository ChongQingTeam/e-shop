package top.knpf.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Component
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private BServeltRequestIntercepter bServeltRequestIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(this.bServeltRequestIntercepter).excludePathPatterns("/b/login/**").addPathPatterns(
//                "/**");
    }

}
