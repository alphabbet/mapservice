package com.weiwen.app;

import com.weiwen.util.ToInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;


@SpringBootApplication
@ComponentScan(basePackages = "com.weiwen.controller")
public class Aapp {
    public static void main(String[] args) {
        SpringApplication.run(Aapp.class,args);
        ToInterface to = new ToInterface();
        to.interfaceUtil("http://api.map.baidu.com/geocoder/v2/?address=南京");
        HashMap<String,String> map = new HashMap<String,String>();
        ThreadLocal<?> t = new ThreadLocal<>();
    }
}
