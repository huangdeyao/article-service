package com.dy.storageservice.controllers;

import com.dy.storageservice.controllers.base.BaseController;
import com.dy.storageservice.model.AritcleImage;
import com.dy.storageservice.result.RespCode;
import com.dy.storageservice.result.RespEntity;
import com.dy.storageservice.service.article.UploadImageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * 微信卡卷
 *
 * @author huangdeyao
 * @create 2018-06-18 17:00
 **/
@RestController
@RequestMapping("/api")
public class UploadController extends BaseController {

    @Autowired
    private UploadImageService uploadService;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/poster/upload")
    public RespEntity uploadPoster(@RequestParam("file") MultipartFile file, String type) throws Exception {
        AritcleImage aritcleImage = uploadService.Upload(file, type);
        if (StringUtils.isNotBlank(aritcleImage.getImageUrl())) {
            return new RespEntity(RespCode.SUCCESS, aritcleImage);
        } else {
            return new RespEntity(RespCode.EMPTY, "图片上传失败");
        }
    }
}  