package com.hc.demojee.rest.comfig;

import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.Configuration;  
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;  
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;  
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;  
import springfox.documentation.builders.PathSelectors;  
import springfox.documentation.builders.RequestHandlerSelectors;  
import springfox.documentation.service.ApiInfo;  
import springfox.documentation.spi.DocumentationType;  
import springfox.documentation.spring.web.plugins.Docket;  
import springfox.documentation.swagger2.annotations.EnableSwagger2;  


/**
 * 访问地址http://127.0.0.1:8080/rainbowhealth/swagger-ui.html
 * @author 黄诚<cheng.huang@linkedcare.cn>
 *
 * 2017年8月18日 下午7:43:55
 *
 */

@Configuration
@EnableSwagger2
//@EnableWebMvc
//@ComponentScan(basePackages ={"com.ak.swaggerspringmvc.shared.controller", "com.ak.spring3.music"})
public class SwaggerConfig {
    
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("cn.linkedcare.libra.api"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//    
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("领健信息-全科")
//                .description("api文档")
//                .termsOfServiceUrl("http://127.0.0.1:8080/rainbowhealth/swagger-ui.html")
//                .version("1.0")
//                .build();
//    }
}
