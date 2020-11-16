package io.github.talelin.latticy.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class BannerItem implements Serializable {
    private Long id;
    private String img;
    private String keyword;
    private Long type;
    private String name;
    private Long bannerId;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;

    /**
     * bannerItem 和banner 是一对一的关系 BannerItem表中没有这个字段
     */
    private Banner myBanner;

    /**
     * bannerItem 和bitem_img 是一对多的关系 BannerItem表中没有这个字段
     */
    private List<BitemImg> myImgs;
}
