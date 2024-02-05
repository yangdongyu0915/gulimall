package com.ydy.gulimall.product;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.ydy.gulimall.product.entity.BrandEntity;
import com.ydy.gulimall.product.service.BrandService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GulimallProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Autowired
    OSSClient ossClient;

    @Test
    public void contextLoads() throws com.aliyuncs.exceptions.ClientException, FileNotFoundException {
//        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
//        String accessKeyId = "LTAI5tPvmSC7C7iE9zkMGmhd";
//        String accessKeySecret = "m9wWtf2G3bpSx9Kx4lBDVJCTiEaHpi";
//        // 填写Bucket名称，例如examplebucket。
//        String bucketName = "gulimall-yangdongyu";
//        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
//        String objectName = "1.jpg";
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeySecret);

        try {
            String url = "C:\\Users\\Administrator\\Desktop\\2ba8397427e1b27bca21ac190f4c3b44.jpg";
            ossClient.putObject("gulimall-yangdongyu", "2.jpg", new FileInputStream(url));
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, " + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered " + "a serious internal problem while trying to communicate with OSS, " + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

}
