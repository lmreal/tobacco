package com.lm.tobacco.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author liming356
 * @since 2018/9/25/025
 */
public interface SignInService {

    /**
     * 保存签到信息
     * @param multipartFile
     * @param fileName
     * @param address
     * @return
     */
    String signIn(MultipartFile multipartFile, String fileName, String address);
}
