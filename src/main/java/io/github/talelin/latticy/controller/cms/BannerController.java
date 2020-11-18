package io.github.talelin.latticy.controller.cms;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/vi/banner")
@Validated
public class BannerController {

    @GetMapping("/page")
    public void getBanners(@RequestParam(required = false,defaultValue = "0") @Min(0) Integer page,
                           @RequestParam(required = false,defaultValue = "10")
                           @Min(value = 1)
                           @Max(value = 30) Integer count
    ){

    }

//    @GetMapping("/page")
//    public void getBanners(@RequestParam(required = false,defaultValue = "0") @Min(0) Integer page,
//                           @RequestParam(required = false,defaultValue = "10")
//                           @Min(value = 1,message = "{xl.page.count.min}")
//                           @Max(value = 1,message = "{xl.page.count.max}") Integer count
//                           ){
//
//    }
}
