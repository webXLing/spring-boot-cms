package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.CategoryDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-12-09
 */
public interface CategoryMapper extends BaseMapper<CategoryDO> {
     CategoryDO getMyById(Integer id);
}
