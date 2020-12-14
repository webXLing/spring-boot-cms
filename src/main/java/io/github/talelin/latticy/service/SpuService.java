package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.SpuDTO;
import io.github.talelin.latticy.model.*;
import io.github.talelin.latticy.mapper.SpuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-12-05
 */
@Service
public class SpuService extends ServiceImpl<SpuMapper, SpuDO>  {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SpuImgService spuImgService;

    @Autowired
    private SpuDetailImgService spuDetailImgService;

    @Autowired
    private SpuKeyService spuKeyService;

    public SpuDetailDO getDerail (Long id){
        return this.getBaseMapper().getDetail(id);
    }

    // 新建 完整的spu
    @Transactional
    public void ceateSpu(SpuDTO spuDTO){
        SpuDO spuDO = new SpuDO();
        BeanUtils.copyProperties(spuDTO,spuDO);
        System.out.println(spuDTO.getCategoryId());
        CategoryDO categoryDO = categoryService.getByCategoryId(spuDTO.getCategoryId());
        System.out.println("categoryDO");
        System.out.println(categoryDO);
        spuDO.setRootCategoryId(categoryDO.getParentId());
        this.save(spuDO);
        System.out.println("err");


//        批量保存spu_img
      List<String> spuImgList = new ArrayList<>();
        System.out.println("spuDTO.getSpuImgList()=="+spuDTO.getSpuImgList());
      if(spuDTO.getSpuImgList()==null){
          spuImgList.add(spuDTO.getImg());
      }else{
          spuImgList = spuDTO.getSpuImgList();
      }
      this.insertSpuImgList(spuImgList,spuDO.getId());

      if(spuDTO.getDetailImgs()!=null){
            this.insetDefaultImg(spuDTO.getDetailImgs(), spuDO.getId());
      }
      if(spuDTO.getSpecKeyIdList()!=null){
          this.insertSpecKeyIdList(spuDTO.getSpecKeyIdList(), spuDO.getId());
      }
    }

    private void insertSpecKeyIdList(List<Integer> list,Long id){
        List<SpuKeyDO> collect = list.stream().map(item -> {
            SpuKeyDO spuKeyDO = new SpuKeyDO();
            spuKeyDO.setSpuId(id.intValue()).setSpecKeyId(item);
            return spuKeyDO;
        }).collect(Collectors.toList());

        this.spuKeyService.saveBatch(collect);
    }

    // 批量插入
    private void insertSpuImgList(List<String> spuImgList,Long id){
        List<SpuImgDO> collect = spuImgList.stream().map(img -> {
            SpuImgDO spuImgDO = new SpuImgDO();
            spuImgDO.setImg(img);
            spuImgDO.setSpuId(id.intValue());
            return spuImgDO;
        }).collect(Collectors.toList());
        this.spuImgService.saveBatch(collect);
    }

    private void  insetDefaultImg(List<String> defaultList,Long id){
        ArrayList<SpuDetailImgDO> spuDetailImgDOS = new ArrayList<>();
        for (int i = 0; i <defaultList.size() ; i++) {
            SpuDetailImgDO spuDetailImgDO = new SpuDetailImgDO();
            spuDetailImgDO.setIndex(i)
                    .setImg(defaultList.get(i))
                    .setSpuId(id.intValue());
            spuDetailImgDOS.add(spuDetailImgDO);
        }
        this.spuDetailImgService.saveBatch(spuDetailImgDOS);

    }


}
