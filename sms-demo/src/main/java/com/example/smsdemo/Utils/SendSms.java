package com.example.smsdemo.Utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 发送短信
 * @author qzz
 */
public class SendSms {

    public static void main(String[] args) {

        //自己账号的AccessKey信息
        String accessKeyId="LTAI5tJXaSRk55SK21hmz68J1";
        String accessSecret="noyk2X7MfrLzNIYqjL0XUJPpdBgdIc1";
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        //短信服务的服务接入地址
        request.setSysDomain("dysmsapi.aliyuncs.com");
        //API的版本号
        request.setSysVersion("2017-05-25");
        //API的名称
        request.setSysAction("SendSms");
        //接收短信的手机号码
        request.putQueryParameter("PhoneNumbers", "15720823096");
        //短信签名名称
        request.putQueryParameter("SignName", "阿里云短信测试");
        //短信模板ID
        request.putQueryParameter("TemplateCode", "SMS_154950909");
        //短信模板变量对应的实际值
        request.putQueryParameter("TemplateParam", "{\"code\":\"1111\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
