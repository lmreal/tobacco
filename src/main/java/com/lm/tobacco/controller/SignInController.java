package com.lm.tobacco.controller;

import cn.afterturn.easypoi.cache.manager.POICacheManager;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import com.lm.tobacco.service.SignInService;
import com.lm.tobacco.service.VocationRequestServiceImpl;
import com.lm.tobacco.util.ExcelData;
import com.lm.tobacco.util.ExcelUtils;
import com.lm.tobacco.web.socket.ReceiveMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liming356
 * @since 2018/9/21/021
 */
@Controller
public class SignInController {

  private SignInService signInService;
  private Logger logger = LogManager.getLogger(SignInController.class);

  public SignInController(SignInService signInService) {
    this.signInService = signInService;
  }

  @GetMapping(value = "/signIn")
  public String index() {
    return "signIn";
  }

  @PostMapping("/sign")
  @ResponseBody
  public Object signIn(@RequestParam("image") MultipartFile file, String address) {

    // 获取文件名
    String fileName = file.getOriginalFilename();
    logger.info("上传的文件名为：{}", fileName);
    logger.info("信息：{}", address);
    return signInService.signIn(file, fileName, address);
  }

  @GetMapping(value = "/download")
  public void download(HttpServletResponse response) {
    String fileName = "人员签到 - 副本.xlsx";
    try {
      InputStream inputStream = new FileInputStream(new File("E://" + fileName));
      response.setContentType("application/zip");
      OutputStream out = response.getOutputStream();
      response.setHeader(
          "Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "utf-8"));
      int b = 0;
      byte[] buffer = new byte[10000];
      while (b != -1) {
        b = inputStream.read(buffer);
        if (b != -1) {
          out.write(buffer, 0, b);
        }
      }
      inputStream.close();
      out.close();
      out.flush();
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("下载失败");
    }
  }
  /** 07 版本EXCEL预览 */
  @GetMapping("/preview")
  @ResponseBody
  public void toHtmlOf07Base(HttpServletResponse response) throws Exception {
    ExcelToHtmlParams params =
        new ExcelToHtmlParams(
            WorkbookFactory.create(POICacheManager.getFile("E://人员签到 - 副本.xlsx")));
    response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(params).getBytes());
  }

  @GetMapping("/export")
  @ResponseBody
  public void excel(HttpServletResponse response) throws Exception {
    ExcelData data = new ExcelData();
    data.setName("用户信息数据");
    // 添加表头
    List<String> titles = new ArrayList();
    // for(String title: excelInfo.getNames())
    titles.add("姓名");
    titles.add("账户");
    titles.add("部门");
    titles.add("创建人");
    titles.add("伊妹儿");
    data.setTitles(titles);
    // 添加列
    List<List<Object>> rows = new ArrayList();
    List<Object> row = null;

    row = new ArrayList();
    row.add("zs");
    row.add("1");
    row.add("2");
    row.add("3");
    row.add("4");
    rows.add(row);

    data.setRows(rows);

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String fileName = format.format(new Date()) + ".xlsx";
    ExcelUtils.exportExcel(response, fileName, data);
  }

  @GetMapping(value = "/photo")
  public String photo() {
    return "photo";
  }

  @Autowired private VocationRequestServiceImpl vocationRequestService;

  @GetMapping("/act")
  @ResponseBody
  public Object act() {
    vocationRequestService.submitRequest("1", "2", "2018-09-29", "2018-09-30", "rest", "2");
    return vocationRequestService.queryRequest("2");
  }

  @Autowired public SimpMessagingTemplate template;

  /**
   * 广播
   *
   * @param rm
   */
  @MessageMapping("/subscribe")
  public void subscribe(ReceiveMessage rm) {
    System.out.println("/subscribe");
    // 广播使用convertAndSend方法，第一个参数为目的地，和js中订阅的目的地要一致
    template.convertAndSend("/topic/getResponse", rm.getName());
  }

  /**
   * 点对点
   *
   * @param rm
   */
  @MessageMapping("/queue")
  public void queue(ReceiveMessage rm) {
    System.out.println("/queue");

    // 广播使用convertAndSendToUser方法，第一个参数为用户id，此时js中的订阅地址为
    // "/user/" + 用户Id + "/message",其中"/user"是固定的
    template.convertAndSendToUser("zhangsan", "/message", rm.getName());
  }

  @GetMapping("/topic")
  public String topic() {
    return "topic";
  }

  @GetMapping("/queue.html")
  public String queue() {
    return "queue";
  }
}
