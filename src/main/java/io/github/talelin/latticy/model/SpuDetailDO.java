package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author generator@TaleLin
 * @since 2020-12-05
 */
@Data
/**
 * 其实是vo 不算do
 */
public class SpuDetailDO extends SpuDO {

    /**
     * 关联 category
     */
    private String categoryName;
    /**
     * 某种规格可以直接附加单品图片  可视规格名
     * 关联 spec_key
     */
    private String sketchSpecName;

    private String defaultSkuTitle;

    /**
     * 关联spu_img
     */
    private List<String> spuImgList;

    /**
     * 关联spu_detail_img
     */
    private List<String> detailImgs;

}
