package io.github.talelin.latticy.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.banner.UpdateBanner;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.Banner;
import io.github.talelin.latticy.model.BannerItem;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 继承 ServiceImpl 的目的是不用写一些常用的方法
 */

@Service
public class BannerService extends ServiceImpl<BannerMapper, Banner> {
    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private BannerItemService bannerItemService;


//    public void getBanner(){
////        bannerMspper.selectPage()
//    }

    /**
     * get banner with banneritem
     */
    public BannerWithItemsBO getBannerWithItem(Long id){
        // 查出id为 的banner
        Banner banner = this.getById(id);
        if(banner == null){
            throw new NotFoundException(20000);
        }
//        bannerItemService.
        QueryWrapper<BannerItem> bannerItemQueryWrapper = new QueryWrapper<>();
//        bannerItemQueryWrapper.eq("banner_id",id);
        bannerItemQueryWrapper.lambda().eq(BannerItem::getBannerId,id);
        List<BannerItem> list = bannerItemService.list(bannerItemQueryWrapper);
        return new BannerWithItemsBO(banner,list);
    }

    /**
     * 更新banner
     * @param id
     * @param updateBanner
     * @return
     */
    public Boolean update(Long id, UpdateBanner updateBanner){
        // 查出id为 的banner
        Banner banner = this.getById(id);
        if(banner == null){
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(updateBanner,banner);
        return this.updateById(banner);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Long id){
        Banner banner = this.getById(id);
        if(banner == null){
            throw new NotFoundException(20000);
        }
        int i = this.getBaseMapper().deleteById(id);
        return i;
    }
}
