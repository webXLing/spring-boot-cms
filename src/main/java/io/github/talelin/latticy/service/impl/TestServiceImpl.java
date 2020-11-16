package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.mapper.TestMapper;
import io.github.talelin.latticy.model.Banner;
import io.github.talelin.latticy.model.BannerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl {

    @Autowired
    private TestMapper testMapper;

    public List<BannerItem> getBannerItemFull(Long id){
        return testMapper.getBannerItemFull(id);
    }

    public List<Banner> getTest(Long id){
        return testMapper.getBanner(id);
    }
    public List<BannerItem> getTest1(Long id){
        return testMapper.getBannerItem(id);
    }

    public List<BannerItem> getBannerItemFullimg(Long id){
        return testMapper.getBannerItemFullimg(id);
    }

}
