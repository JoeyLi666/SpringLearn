package cn.lsc.spring_mybatis.demo.controller;

import cn.lsc.spring_mybatis.demo.pojo.TestDao;
import cn.lsc.spring_mybatis.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Controller
@RestController
public class HelloController {

    @Autowired
    private TestService service;


    @PostMapping(value = "/hello")
    public Map<String,Object> getHello( @RequestBody TestDao testDao) {
       return service.getTestMap(testDao);
    }
}
