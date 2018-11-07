package com.dy.storageservice.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.Date;

public class COSClientUtils {

    // 存储通名称
    private String bucketName;
    private COSClient cosClient;

    public COSClientUtils(COSCredentials cred, ClientConfig clientConfig, String bucketName) {
        this.bucketName = bucketName;
        cosClient = new COSClient(cred, clientConfig);
    }

    /**
     * 销毁
     */
    public void destory() {
        cosClient.shutdown();
    }

    /**
     * 上传图片
     *
     * @param url
     */
    public void uploadImg2Cos(String url) throws Exception {
        File fileOnServer = new File(url);
        FileInputStream fin;
        try {
            fin = new FileInputStream(fileOnServer);
            String[] split = url.split("/");
            this.uploadFile2Cos(fin, split[split.length - 1]);
        } catch (FileNotFoundException e) {
            throw new Exception("文件上传失败");
        }
    }

    public String uploadFile2(MultipartFile file, String path) throws Exception {
        if (file.getSize() > 50 * 1024 * 1024) {
            throw new Exception("上传文件大小不能超过50M！");
        }
        String originalFilename = file.getOriginalFilename();
        //命名规则  提交文件名称 + 时间戳
        String name = path + "/" + originalFilename;
        return upload(file, name);
    }

    public String uploadFile(MultipartFile file, String path, String type) throws Exception {
        if (file.getSize() > 50 * 1024 * 1024) {
            throw new Exception("上传文件大小不能超过50M！");
        }
        String originalFilename = file.getOriginalFilename();
//        String[] fileName = originalFilename.split("\\.");
        //命名规则  提交文件名称 + 时间戳
        String name = path + DateTimeUtils.getTimeZZZ() + "." + type;
        return upload(file, name);
    }

    private String upload(MultipartFile file, String path) throws Exception {
        try {
            InputStream inputStream = file.getInputStream();
            this.uploadFile2Cos(inputStream, path);
            return path;
        } catch (Exception e) {
            throw new Exception("文件上传失败");
        }
    }

    /**
     * 获得图片路径
     *
     * @param fileUrl
     * @return
     */
    public String getImgUrl(String fileUrl) {
        return getUrl(fileUrl);
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    /**
     * 上传到COS服务器 如果同名文件会覆盖服务器上的
     *
     * @param instream 文件流
     * @param fileName 文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadFile2Cos(InputStream instream, String fileName) {
        String ret = "";
        try {
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
//            PutObjectResult putResult = cOSClient.putObject(bucketName,  fileName, instream, objectMetadata);
            PutObjectResult putResult = cosClient.putObject(bucketName, fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * Description: 判断Cos服务文件上传时文件的contentType
     *
     * @param filenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
                || filenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        if (filenameExtension.equalsIgnoreCase("mp4")) {
            return "video/mpeg4";
        }
        return "image/jpeg";
    }

}