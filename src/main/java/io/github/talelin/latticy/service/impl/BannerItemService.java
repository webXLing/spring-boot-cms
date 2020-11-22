package io.github.talelin.latticy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.model.BannerItem;
import org.springframework.stereotype.Service;


/**
 * 继承 ServiceImpl 的目的是不用写一些常用的方法
 */

@Service
public class BannerItemService extends ServiceImpl<BannerItemMapper, BannerItem> {

}
