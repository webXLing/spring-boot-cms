package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.model.SpecKeyDO;
import io.github.talelin.latticy.mapper.SpecKeyMapper;
import io.github.talelin.latticy.service.SpecKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-12-06
 */
@Service
public class SpecKeyServiceImpl extends ServiceImpl<SpecKeyMapper, SpecKeyDO> implements SpecKeyService {
    public List<SpecKeyDO> getBySpu(Long id){
        return this.baseMapper.getBySpu(id);
    }
}
