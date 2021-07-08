package com.smart.test;

import com.smart.pojo.Result;
import com.smart.util.RestTemplateUtil;
import com.szxysoft.commons.utils.PDFUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    //用户端秘钥
    private static final String CUSTOM_KEY = "customKey";
    //测试环境路径
    private static final String URL = "http://sz.xrdev.cn/inspection/";
    //测试
//    private static final String URL = "https://www.baidu.com/";
    //正式环境路径
//    private static final String URL = "https://jg.amr.sz.gov.cn/jyjc/foodapi/inspection/";

    private static final String URL_SAMPLE_CODE_LIST = URL + "getSampleCodeList";
    private static final String URL_SAMPLE_BY_CODE = URL + "getSampleByCode";
    private static final String URL_DETECTION_ITEMS = URL + "getDetectionItems";
    private static final String URL_SYNC_RESULT = URL + "syncDetectionResult";
    private static final String URL_REPORT_BY_CODE = URL + "getReportByCode";
    @Autowired
    private ApplicationContext applicationContext;

    @org.junit.Test
    public void getSampleCodeList() {
        HashMap<Object, Object> textParams = new HashMap<>();
        textParams.put(CUSTOM_KEY, "000000");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<Object> entity = new HttpEntity<>(textParams, headers);
        RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
        Result SampleCodeResult = restTemplate.postForObject(URL_SAMPLE_CODE_LIST, entity, Result.class);
        System.out.println("结果信息:" + SampleCodeResult.getMessage());
        System.out.println("抽样单号:");
        for (String sampleCode : SampleCodeResult.getData()) {
            System.out.println(sampleCode);
        }
    }

    @org.junit.Test
    public void Test01(){
        String url = applicationContext.getEnvironment().getProperty("client.config.URL");
        String username = applicationContext.getEnvironment().getProperty("client.config.USERNAME");
        String password = applicationContext.getEnvironment().getProperty("client.config.PASSWORD");
        String driver = applicationContext.getEnvironment().getProperty("client.config.DRIVER");
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        System.out.println(driver);

    }
}
