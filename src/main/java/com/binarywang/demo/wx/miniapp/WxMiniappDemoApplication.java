package com.binarywang.demo.wx.miniapp;

import cn.binarywang.wx.miniapp.api.WxMaService;
import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binary wang
 */
@RestController
@RequestMapping("/")
@SpringBootApplication
@RequiredArgsConstructor
public class WxMiniappDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxMiniappDemoApplication.class, args);
    }

    private final WxMaService maService;

    @GetMapping("/test")
    public String test() throws WxErrorException {
        return this.maService.getAccessToken();
    }

    @GetMapping("/")
    public String home() {
        return this.maService.getWxMaConfig().getAppid();
    }
}
