package io.github.talelin.latticy.controller.cms;

import io.github.talelin.latticy.model.Banner;
import io.github.talelin.latticy.model.BannerItem;
import io.github.talelin.latticy.service.impl.TestServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


//    @GetMapping("/login")
//    public String defaultLogin() {
//        return "首页";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
//        // 从SecurityUtils里边创建一个 subject
//        Subject subject = SecurityUtils.getSubject();
//        // 在认证提交前准备 token（令牌）
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        // 执行认证登陆
//        try {
//            subject.login(token);
//        } catch (UnknownAccountException uae) {
//            return "未知账户";
//        } catch (IncorrectCredentialsException ice) {
//            return "密码不正确";
//        } catch (LockedAccountException lae) {
//            return "账户已锁定";
//        } catch (ExcessiveAttemptsException eae) {
//            return "用户名或密码错误次数过多";
//        } catch (AuthenticationException ae) {
//            return "用户名或密码不正确！";
//        }
//        if (subject.isAuthenticated()) {
//            return "登录成功";
//        } else {
//            token.clear();
//            return "登录失败";
//        }
//    }





}
