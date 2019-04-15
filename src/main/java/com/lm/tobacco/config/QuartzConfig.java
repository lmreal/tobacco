package com.lm.tobacco.config;

import com.lm.tobacco.task.AgeScheduleTask;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * QuartzConfig
 *
 * @author liming356
 * @since 2018/9/27/027
 */
@Configuration
public class QuartzConfig {

  /**
   * 配置定时任务
   *
   * @param ageScheduleTask
   * @return
   */
  @Bean(name = "firstJobDetail")
  public MethodInvokingJobDetailFactoryBean jobDetail(AgeScheduleTask ageScheduleTask) {
    MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
    // 是否并发执行
    jobDetail.setConcurrent(false);
    // 为需要执行的实体类对应的对象
    jobDetail.setTargetObject(ageScheduleTask);
    // 需要执行的方法
    jobDetail.setTargetMethod("task");
    return jobDetail;
  }

  /**
   * 配置触发器
   *
   * @param firstJobDetail
   * @return
   */
  @Bean(name = "firstTrigger")
  public SimpleTriggerFactoryBean trigger(JobDetail firstJobDetail) {
    SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
    trigger.setJobDetail(firstJobDetail);
    // 设置任务启动延迟
    trigger.setStartDelay(0);
    // 每5秒执行一次
    trigger.setRepeatInterval(1000 * 3600 * 13);
    return trigger;
  }

  /**
   * 配置Scheduler
   *
   * @param firstTrigger
   * @param secondTrigger
   * @return
   */
  @Bean(name = "scheduler")
  public SchedulerFactoryBean schedulerFactory(Trigger firstTrigger, Trigger secondTrigger) {
    SchedulerFactoryBean bean = new SchedulerFactoryBean();
    // 延时启动，应用启动1秒后
    bean.setStartupDelay(1);
    // 注册触发器
    bean.setTriggers(firstTrigger, secondTrigger);
    return bean;
  }
}
