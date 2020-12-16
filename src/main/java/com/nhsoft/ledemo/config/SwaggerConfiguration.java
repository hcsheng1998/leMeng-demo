package com.nhsoft.ledemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 11:12
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo()).groupName("hcs");
    }

    public ApiInfo getApiInfo() {

        return new ApiInfo("demo测试项目的api文档",
                "一个详细的api文档",
                "1.0",
                "urn:tos",
                new Contact("hcs", "http://www.baidu.com", "hcsheng@gmail.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
