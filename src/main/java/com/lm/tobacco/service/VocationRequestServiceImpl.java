package com.lm.tobacco.service;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liming356
 * @since 2018/9/29/029
 */
@Service
public class VocationRequestServiceImpl {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private TaskService taskService;


    /**
     * 提交申请
     * @param id
     * @param numberOfDays
     * @param startDate
     * @param endDate
     * @param motivation
     */
    public void submitRequest(String id, String numberOfDays, String startDate, String endDate, String motivation, String leader) {

        Map<String, Object> variable = new HashMap<>();
        variable.put("employeeName", id);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest", variable);

        System.out.println("流程实例数：" + runtimeService.createProcessInstanceQuery().count() + " 流程ID：" + processInstance.getId());

        List<Task> tasks = taskService.createTaskQuery().active().taskAssignee(id).list();

        Task task = tasks.get(0);

        Map<String, Object> variables = new HashMap<>();
        SimpleDateFormat sdt  = new SimpleDateFormat("yyyy-MM-dd");

        variables.put("employeeName", id);
        variables.put("numberOfDays", numberOfDays);
        variables.put("vacationMotivation", motivation);
        variables.put("startDate", startDate);
        variables.put("endDate", endDate);
        variables.put("managerName", leader);
        taskService.complete(task.getId(), variables);
    }

    /**
     * 申请人查询已提交，未完成的请求
     * @param id
     * @return
     */
    public List<String> queryRequest(String id) {
        List<HistoricTaskInstance> tasks = historyService.createHistoricTaskInstanceQuery().processUnfinished().taskAssignee(id).list();
        List<String> result = new ArrayList<>();
        for (HistoricTaskInstance task : tasks) {
            result.add("任务名：" + task.getName() + "   内容：" + task.getDescription());
        }
        return result;
    }


    /**
     * 每个人查询待办任务
     * @param id
     */
    public void queryTodo(String id) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(id).list();
        for (Task task : tasks) {
            System.out.println("任务名：" + task.getName() + "   内容：" + task.getDescription());
        }
    }

    /**
     * 申请人查询任务进度
     * @param id
     */
    public List<String> queryTaskState(String id) {
        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().involvedUser(id).list();
        List<String> result = new ArrayList<>();
        for (ProcessInstance p : processInstances) {
            Task task = taskService.createTaskQuery().processInstanceId(p.getId()).active().list().get(0);
            result.add("任务名：" + task.getName() + "  内容：" + task.getDescription() + " 流程当前处理人:" + task.getAssignee());
        }
        return result;
    }

    /**
     * 领导处理请求
     * @param id
     * @param is
     * @param reason
     */
    public void handleRequest(String id, String is, String reason) {

        List<Task> tasks = taskService.createTaskQuery().taskAssignee(id).list();
        Task task = tasks.get(0);

        Map<String, Object> taskVariables = new HashMap<>();
        taskVariables.put("vacationApproved", is);
        taskVariables.put("managerMotivation", reason);
        taskService.complete(task.getId(), taskVariables);
    }
}
