package com.cherry.webservice.service;

import javax.jws.WebService;

/**
 * @Author : 翁鑫豪
 */

@WebService(name = "DemoService", // 暴露服务名称
        targetNamespace = "http://service.mq.primeton.com"// 命名空间,一般是接口的包名倒序
)
public interface DemoService {

    public String sayHello(String user);


}
