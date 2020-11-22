package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.Banner;
import org.springframework.stereotype.Repository;

/**
 * 继承mybatis plus map 增强
 */
@Repository
public interface BannerMapper extends BaseMapper<Banner> {

}
