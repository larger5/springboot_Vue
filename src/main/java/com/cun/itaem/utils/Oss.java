package com.cun.itaem.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
/**
 * 把文件保存到阿里云OSS，返回图片访问路径
 * @author linhongcun
 *
 */
public class Oss {

    public static String getUrl(MultipartFile fileupload) throws OSSException, ClientException, IOException {
        String endpoint = "oss-cn-shenzhen.aliyuncs.com";
		// 填自己的帐号
        String accessKeyId = "LTAxxxxxxxxxR";
		// 填自己的帐号
        String accessKeySecret = "VuCGxxxxxxxxxxxxR9QKR";
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 文件桶
        String bucketName = "itaem";
        // 文件名格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        // 该桶中的文件key
        String dateString = sdf.format(new Date()) + ".jpg";// 20180322010634.jpg
        // 上传文件
        ossClient.putObject("itaem", dateString, new ByteArrayInputStream(fileupload.getBytes()));
        // 设置URL过期时间为100年，默认这里是int型，转换为long型即可
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 100);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, dateString, expiration);
        return url.toString();
    }
}