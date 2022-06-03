package com.zhangbin.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:'false'}", autoRefreshed = true)
    private String useLocalCache;

    @RequestMapping(value = "/get", method = GET)
    @ApiOperation(value = "获取对象", notes = "作者：111")
    @ResponseBody
    public String get() {
        return useLocalCache;
    }
}
