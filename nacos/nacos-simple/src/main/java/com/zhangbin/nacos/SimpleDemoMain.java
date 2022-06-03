package com.zhangbin.nacos;


import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * nacos客户端获取配置
 * */
public class SimpleDemoMain {
    public static void main(String[] args) throws NacosException {
        //nacos服务地址
        String serverAddr = "127.0.0.1:8848";
        //dataId
        String dataId = "nacos-simple-demo.yaml";
        //group
        String group ="DEFAULT_GROUP";

        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);

//        获取配置
        ConfigService conf = NacosFactory.createConfigService(properties);
        //dataId,group,超时时间
        String config = conf.getConfig(dataId, group, 5000);
        System.out.println(config);

    }
}
