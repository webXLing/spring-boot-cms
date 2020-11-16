package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    List<Banner> getBanner();
}
