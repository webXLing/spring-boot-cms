package io.github.talelin.latticy.controller.cms;

import io.github.talelin.latticy.model.Banner;
import io.github.talelin.latticy.model.BannerItem;
import io.github.talelin.latticy.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestServiceImpl testService;

    @GetMapping("/bannerall")
    public List<Banner> getAll(){
        List<Banner> test = testService.getAll();
        return test;
    }

    @GetMapping("/banner")
    public List<Banner> getTest(@RequestParam("id") Long id){
        List<Banner> test = testService.getTest(id);
        return test;
    }

    @GetMapping("/banneritem")
    public List<BannerItem> getTest1(@RequestParam("id") Long id){
        List<BannerItem> test = testService.getTest1(id);
        return test;
    }


    @GetMapping("/banneritemfull")
    public List<BannerItem> getBannerItemFull(@RequestParam("id") Long id){
        List<BannerItem> test = testService.getBannerItemFull(id);
        return test;
    }

    @GetMapping("/banneritemfullimg")
    public List<BannerItem> getBannerItemFullimg(@RequestParam("id") Long id){
        List<BannerItem> test = testService.getBannerItemFullimg(id);
        return test;
    }


    /**
     * 插入banner
     */
    @GetMapping("/insetBaner")
    public Long insetBaner(){
        Long aLong = testService.inserBaner();
        return aLong;
    }




}
