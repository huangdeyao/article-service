package com.dy.storageservice.service.article;

import com.dy.storageservice.model.AritcleImage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: huangdeyao
 * @create: 2018-11-07 17:35
 **/
public interface UploadImageService {
    /**
     * 上传文件
     *
     * @param file 文件
     * @return
     */
    AritcleImage Upload(MultipartFile file, String type);
}
