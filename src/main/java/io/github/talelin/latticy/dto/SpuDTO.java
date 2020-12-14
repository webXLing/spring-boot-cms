package io.github.talelin.latticy.dto;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
public class SpuDTO {
    private String title;
    private String subtitle;
    @Positive
    private Integer categoryId;

//    private Integer rootCategoryId;
    @Max(1)
    @Min(0)
    private Integer online;
    /**
     * 文本型价格，有时候SPU需要展示的是一个范围，或者自定义平均价格
     */
    @NotBlank
    @Length(min = 1,max = 20)
    private String price;
    /**
     * 某种规格可以直接附加单品图片
     */
    private Integer sketchSpecId;
    /**
     * 默认选中的sku
     */
    private Integer defaultSkuId;
    private String img;
    private String discountPrice;
    @Length(min = 1,max = 255)
    private String description;

//    private String tags;

//    private Integer isTest;

//    private String spuThemeImg;
    private String forThemeImg;

    private List<Integer> specKeyIdList;
    private List<String> spuImgList;

    /**
     * 关联spu_detail_img
     */
    private List<String> detailImgs;
}
