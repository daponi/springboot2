package com.atguigu.boot.config;

import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.converter.GuiguMessageConverter;
import com.atguigu.boot.converter.MyAtguiguMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.List;

@SuppressWarnings({"all"})
@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {
    /*第一种开启矩阵变量*/
/*    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        //        // 不移除；后面的内容。矩阵变量功能就可以生效
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }*/

    /*第二种开启矩阵变量，将自定义组件放到容器*/
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 开启举证变量，url以";"分割传递参数
             * @param configurer
             */
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 不移除；后面的内容。矩阵变量功能就可以生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
            /**
             * 自定义格式化内容，pet的属性全部放在一个字段，且以"，"为界限分隔
             * 传统表达式写法
             * @param registry
             */
           /* @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {

                    @Override
                    public Pet convert(String source) {
                        // 啊猫,3
                        if(!StringUtils.isEmpty(source)){
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }*/

            /**
             * 自定义格式化内容，pet的属性全部放在一个字段，且以"，"为界限分隔
             * Lambda表达式写法
             * @param registry
             */
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(String.class,Pet.class,(source)-> {
                        // 啊猫,3
                            Pet pet = new Pet();
                        if(!StringUtils.isEmpty(source)){
                            String[] split = StringUtils.split((String) source,",");
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                        }
                            return pet;
                });
            }

            /**
             * 扩展内容协商策略，不会覆盖默认的10种策略方式，只是扩充
             * @param converters
             */
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new GuiguMessageConverter());
                converters.add(new MyAtguiguMessageConverter());
            }
        };
    }
}
