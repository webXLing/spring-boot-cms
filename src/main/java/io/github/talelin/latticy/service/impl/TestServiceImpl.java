package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.mapper.TestMapper;
import io.github.talelin.latticy.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl {

    @Autowired
    private TestMapper testMapper;

    public List<Banner> getTest(){
        return testMapper.getBanner();
    }
}
