package com.lm.tobacco;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author liming39
 * @since 2018.9.21
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAsync
public class TobaccoApplication {

  public static void main(String[] args) {
    SpringApplication.run(TobaccoApplication.class, args);
  }

  @Primary
  @Bean
  public TaskExecutor primaryTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    return executor;
  }

  //    @Bean("executor")
  //    public Executor getExecutor(){
  //        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
  //        executor.setCorePoolSize(5);
  //        executor.setMaxPoolSize(10);
  //        executor.setQueueCapacity(25);
  //        executor.initialize();
  //        return executor;
  //    }
}
