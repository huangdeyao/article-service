package com.dy.storageservice.service.article.impl;

import com.dy.storageservice.dao.ArticleImageDao;
import com.dy.storageservice.model.ArticleImage;
import com.dy.storageservice.service.article.UploadImageService;
import com.dy.storageservice.utils.COSClientUtils;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: huangdeyao
 * @create: 2018-11-07 17:35
 **/
@Service
public class UploadImageServiceImpl implements UploadImageService {

    private COSClientUtils cosClientUtils;
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String secretId = "AKIDb2FEBBRf4FBsKanokSv98sNcbKmyCYv3";
    private String secretKey = "1mHVTBgy3rPhjU0GGzUiw3vYv4yrhT7M";
    private String bucket = "ap-chengdu";
    private String bucketName = "huangdeyao-1251741670";

    @Autowired
    private ArticleImageDao articleImageDao;

    @Override
    public ArticleImage Upload(MultipartFile file) {

        logger.info("cosClientUtil:" + cosClientUtils);
        /***
         * properties 配置项无法设置在静态类中读取，配置项为常量，这里为了效率，不重复创建对象，设置简单的对象控制
         */
        if (cosClientUtils == null) {
            // 1 初始化用户身份信息(secretId, secretKey)
            COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
            // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
            ClientConfig clientConfig = new ClientConfig(new Region(bucket));
            cosClientUtils = new COSClientUtils(cred, clientConfig, bucketName);
        }
        String name = null;
        String path = "article" + "/";
        try {
            name = cosClientUtils.uploadFile(file, path);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("文件上传失败");
            return null;
        }
        String imgUrl = cosClientUtils.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        String img = split[0];
        ArticleImage aritcleImage = new ArticleImage();
        aritcleImage.setImageUrl(img);
        aritcleImage.setState(0);

        return articleImageDao.save(aritcleImage);
    }
}
