package io.github.talelin.latticy.controller.cms;

import io.github.talelin.latticy.model.Banner;
import io.github.talelin.latticy.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestServiceImpl testService;
    @GetMapping("/str")
    public List<Banner> getTest(){
        List<Banner> test = testService.getTest();
        return test;
    }

}
