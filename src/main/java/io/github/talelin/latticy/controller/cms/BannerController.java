package io.github.talelin.latticy.controller.cms;

import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.banner.UpdateBanner;
import io.github.talelin.latticy.model.Banner;
import io.github.talelin.latticy.service.impl.BannerService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;


    /**
     * 新增 banner
     */
    public CreatedVO createBanner(@RequestBody @Validated UpdateBanner updateBanner){
        Banner banner = new Banner();
        BeanUtils.copyProperties(updateBanner,banner);
        this.bannerService.save(banner);
        return new CreatedVO();
    }

    /**
     * 通过id 获取banner 并且含有banneritem
     */
    @GetMapping("/{id}")
    public BannerWithItemsBO getBannerWithItem(@PathVariable @Positive Long id){
      return   bannerService.getBannerWithItem(id);
    }

    /**
     * 更新banner
     * @param updateBanner
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public UpdatedVO updateBanner(@RequestBody @Validated UpdateBanner updateBanner,
                             @PathVariable @Positive Long id){
        Boolean update = bannerService.update(id, updateBanner);
        return new UpdatedVO();
    }

    /**
     * 删除banner
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public DeletedVO deleteBanner(@PathVariable @Positive Long id){
        int delete = bannerService.delete(id);
        return new DeletedVO();
    }

    @GetMapping("/page")
    public PageResponseVO<Banner> getBanners(@RequestParam(required = false,defaultValue = "0") @Min(0) Integer page,
                           @RequestParam(required = false,defaultValue = "10")
                           @Min(value = 1)
                           @Max(value = 30) Integer count
    ){
        // 从0 开始
        Page<Banner> objectPage = new Page<>(page,count);
        Page<Banner> bannerPage = bannerService.getBaseMapper().selectPage(objectPage,null);
        return new PageResponseVO<>(bannerPage.getTotal(),bannerPage.getRecords(),bannerPage.getCurrent(),bannerPage.getSize());
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
