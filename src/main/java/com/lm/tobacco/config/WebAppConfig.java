package com.lm.tobacco.config;

import java.util.List;
import javax.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author liming356
 * @since 2018/9/25/025
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

  /** 在配置文件中配置的文件保存路径 */
  @Value("${img.location}")
  private String location;

  @Bean
  public MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory factory = new MultipartConfigFactory();
    // 文件最大KB,MB
    factory.setMaxFileSize("6MB");
    // 设置总上传数据总大小
    factory.setMaxRequestSize("10MB");
    return factory.createMultipartConfig();
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    super.configureMessageConverters(converters);
    converters.add(new ByteArrayHttpMessageConverter());
  }
}
