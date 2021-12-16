package com.example.springbootlogback.controller;

import com.example.springbootlogback.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/get")
    public String get(){
        return testService.get("aaa");
    }

    public static void main(String[] args) {
        String a= "{\"rspCode\":\"00000\",\"rspMsg\":\"操作成功\",\"data\":{\"reqContent\":\"{\\\"custOrder\\\":{\\\"orderNo\\\":\\\"OD202112131926042136\\\",\\\"channelId\\\":\\\"100000297\\\",\\\"preHandleFlag\\\":\\\"F\\\",\\\"orderAmount\\\":\\\"0.00\\\",\\\"acceptTime\\\":\\\"20211213192604\\\",\\\"phoneNumber\\\":\\\"18071549206\\\",\\\"orderItemGroup\\\":[{\\\"serviceOfferId\\\":\\\"3010100000\\\",\\\"prodOfferInst\\\":[{\\\"actionCd\\\":\\\"A\\\",\\\"prodOfferCode\\\":\\\"7360110000100294\\\"}],\\\"accNbr\\\":\\\"18071549206\\\"}]}}\",\"rspContent\":\"{\\\"actionCode\\\":\\\"1\\\",\\\"response\\\":{\\\"rspCode\\\":\\\"0000\\\",\\\"rspDesc\\\":\\\"订单提交成功\\\",\\\"rspType\\\":\\\"0\\\"},\\\"rspTime\\\":\\\"20211213193047\\\"}\"}}";
        System.out.println(a);
    }

}
