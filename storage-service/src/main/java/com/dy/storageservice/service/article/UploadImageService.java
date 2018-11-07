package com.dy.storageservice.service.article;

import com.dy.storageservice.model.ArticleImage;
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
    ArticleImage Upload(MultipartFile file, String type);
}
