package com.lm.tobacco.service;

import com.lm.tobacco.generated.entity.Sign;
import com.lm.tobacco.generated.mapper.SignMapper;
import com.lm.tobacco.util.HashUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liming356
 * @since 2018/9/25/025
 */
@Service
public class SignInServiceImpl implements SignInService {

  /** 在配置文件中配置的文件保存路径 */
  @Value("${img.location}")
  private String path;

  private SignMapper signMapper;

  private Logger logger = LogManager.getLogger(SignInServiceImpl.class);

  // public SignInServiceImpl() {}

  public SignInServiceImpl(SignMapper signMapper) {
    this.signMapper = signMapper;
  }

  @Override
  public String signIn(MultipartFile multipartFile, String fileName, String address) {
    try {
      Sign sign = new Sign();
      sign.setEmplId(1L);
      sign.setAddress(address);
      sign.setPhotoName(saveImage(multipartFile, fileName));
      sign.setDate(new Date());
      signMapper.insert(sign);
    } catch (IOException e) {
      logger.error("签到失败！{}", e);
      return "{\"flag\":\"签到失败！\"}";
    }
    return "{\"flag\":\"签到成功！\"}";
  }

  /**
   * 保存文件，直接以multipartFile形式
   *
   * @param multipartFile
   * @param fileName
   * @return 返回文件名
   * @throws IOException
   */
  private String saveImage(MultipartFile multipartFile, String fileName) throws IOException {
    File file = new File(path);
    if (!file.exists()) {
      file.mkdirs();
    }
    FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
    String name =
        HashUtil.getSHA256Str(fileName) + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    ;
    BufferedOutputStream bos =
        new BufferedOutputStream(new FileOutputStream(path + File.separator + name));
    byte[] bs = new byte[1024];
    int len;
    while ((len = fileInputStream.read(bs)) != -1) {
      bos.write(bs, 0, len);
    }
    bos.flush();
    bos.close();
    return name;
  }

  public void exportSignInData(MultipartFile file) throws IOException {
    String v2003 = "2003";
    String v2007 = "2007";
    String ver = file.getOriginalFilename().endsWith(".xlsx") ? v2007 : v2003;
    Workbook wb = null;
    InputStream input = file.getInputStream();
    if (ver.equals(v2003)) {
      POIFSFileSystem fs = new POIFSFileSystem(input);
      wb = new HSSFWorkbook(fs);
    } else if (ver.equals(v2007)) {
      wb = new XSSFWorkbook(input);
    }
  }
}
