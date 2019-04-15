package com.lm.tobacco;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

/**
 * @author liming356
 * @since 2018/9/27/027
 */
public class ActivitiTest {

  private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

  /** 部署流程 */
  @Test
  public void deployProcess() {
    RepositoryService repositoryService = processEngine.getRepositoryService();
    DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
    deploymentBuilder.name("请假流程");
    deploymentBuilder.addClasspathResource("processes/VacationRequest.bpmn20.xml");
    Deployment deployment = deploymentBuilder.deploy();

    System.out.println("流程Id:" + deployment.getId());
    System.out.println("流程Name:" + deployment.getName());
    System.out.println("流程定义的数量: " + repositoryService.createProcessDefinitionQuery().count());
  }

  @Test
  public void startProcess() {

    RuntimeService runtimeService = processEngine.getRuntimeService();

    Map<String, Object> variables = new HashMap<>();
    variables.put("employeeName", "张三");
    ProcessInstance processInstance =
        runtimeService.startProcessInstanceByKey("vacationRequest", variables);

    System.out.println(
        "流程实例数："
            + runtimeService.createProcessInstanceQuery().count()
            + " 流程ID："
            + processInstance.getId());

    // employeeSubmitRequest(processInstance.get);
  }

  @Test
  public void currentHandler() {
    List<ProcessInstance> processInstances =
        processEngine
            .getRuntimeService()
            .createProcessInstanceQuery()
            .active()
            .variableValueEquals("employeeName", "张三")
            .list();
    // .variableValueEquals("employeeName", "张三")
    System.out.println(
        "流程实例："
            + processEngine
                .getHistoryService()
                .createHistoricTaskInstanceQuery()
                .processUnfinished()
                .taskAssignee("张三")
                .list()
                .get(0)
                .getDescription());
    System.out.println(
        "流程实例："
            + processEngine
                .getRuntimeService()
                .createProcessInstanceQuery()
                .involvedUser("张三")
                .list()
                .get(0));
    String id =
        processEngine
            .getRuntimeService()
            .createProcessInstanceQuery()
            .involvedUser("张三")
            .list()
            .get(0)
            .getId();
    TaskService taskService = processEngine.getTaskService();
    System.out.println(taskService.createTaskQuery().count());
    for (ProcessInstance p : processInstances) {
      Task task =
          taskService
              .createTaskQuery()
              .active()
              .processInstanceId(p.getProcessInstanceId())
              .list()
              .get(0);
      System.out.println(
          "任务名："
              + task.getName()
              + "  内容："
              + task.getDescription()
              + " 流程当前处理人:"
              + task.getAssignee()
              + task.toString());
    }
  }

  @Test
  public void managerQuery() {
    TaskService taskService = processEngine.getTaskService();
    List<Task> tasks = taskService.createTaskQuery().taskAssignee("李四").list();
    for (Task task : tasks) {
      System.out.println("任务名：" + task.getName() + "  内容：" + task.getDescription());
    }
  }

  @Test
  public void noOK() {
    TaskService taskService = processEngine.getTaskService();
    List<Task> tasks = taskService.createTaskQuery().taskAssignee("李四").list();
    Task task = tasks.get(0);

    Map<String, Object> taskVariables = new HashMap<>();
    taskVariables.put("vacationApproved", "false");
    taskVariables.put("managerMotivation", "时间紧任务重");
    taskService.complete(task.getId(), taskVariables);
  }

  @Test
  public void ok() {
    TaskService taskService = processEngine.getTaskService();
    List<Task> tasks = taskService.createTaskQuery().taskAssignee("李四").list();
    Task task = tasks.get(0);

    Map<String, Object> taskVariables = new HashMap<>();
    taskVariables.put("vacationApproved", "true");
    taskVariables.put("managerMotivation", "勉强同意吧");
    taskService.complete(task.getId(), taskVariables);
  }

  @Test
  public void employeeSubmitRequest() {

    TaskService taskService = processEngine.getTaskService();
    List<Task> tasks = taskService.createTaskQuery().taskAssignee("张三").list();
    Task task = tasks.get(0);
    Map<String, Object> variables = new HashMap<>();
    variables.put("employeeName", "张三");
    variables.put("numberOfDays", new Integer(4));
    variables.put("vacationMotivation", "休息");
    variables.put("managerName", "李四");
    taskService.complete(task.getId(), variables);
  }

  @Test
  public void employeeQuery() {
    TaskService taskService = processEngine.getTaskService();
    List<Task> tasks = taskService.createTaskQuery().taskAssignee("张三").list();
    for (Task task : tasks) {
      System.out.println("任务名：" + task.getName() + "   内容：" + task.getDescription());
    }
  }

  @Test
  public void adjustTask() {
    TaskService taskService = processEngine.getTaskService();
    List<Task> tasks = taskService.createTaskQuery().taskAssignee("张三").list();
    Task task = tasks.get(0);

    Map<String, Object> variables = new HashMap<>();
    variables.put("numberOfDays", new Integer(1));
    variables.put("vacationMotivation", "只休一天行不行");
    variables.put("resendRequest", "true");
    taskService.complete(task.getId(), variables);
  }

  @Test
  public void employeeConfirm() {
    TaskService taskService = processEngine.getTaskService();
    List<Task> tasks = taskService.createTaskQuery().taskAssignee("张三").list();
    Task task = tasks.get(0);

    taskService.complete(task.getId());
  }

  @Test
  public void test() {
    SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance();
    String startDate = sdt.format(calendar.getTime());
    calendar.add(Calendar.DAY_OF_MONTH, 2);
    String endDate = sdt.format(calendar.getTime());
    System.out.println("任务名：" + startDate + "   内容：" + endDate);
  }
}
