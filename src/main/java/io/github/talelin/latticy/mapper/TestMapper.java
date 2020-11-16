package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.Banner;
import io.github.talelin.latticy.model.BannerItem;
import io.github.talelin.latticy.model.BitemImg;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper//指定这是一个操作数据库的mapper
public interface TestMapper  {
    /**
     *  查询所有banner
     * @return
     */
    List<Banner> getBannerAll();
    /**
     * 根据id 查询banner
     * @return
     */
    @Select("select * from `banner` where id=#{id}")
    List<Banner> getBanner(Long id);

    /**
     * 根据id 查询banner_item
     * @return
     */
    @Select("select * from `banner_item` where id=#{id}")
    List<BannerItem> getBannerItem(Long id);

    /**
     * 根据id 查询bitem_img
     * @return
     */
    @Select("SELECT * from bitem_img b WHERE b.item_id = #{id}")
    List<BitemImg> getBitemImg(Long id);

    /**
     * 根据id 查询banner_item 并且获取到其对应的banner  1对1
     */
    @Select("select * from `banner_item` where id=#{id}")
    @Results({
            @Result(property = "myBanner",column = "banner_id",
                    one = @One(select = "io.github.talelin.latticy.mapper.TestMapper.getBanner")
            )
    })
    List<BannerItem> getBannerItemFull(Long id);

    /**
     * 根据id 查询banner_item 并且获取到其对应的banner  1对1
     * 以及imgs 对应的图片 1对多
      */
    @Select("select * from `banner_item` where id=#{id}")
    @Results({
            @Result(property = "myBanner",column = "banner_id",
                    one = @One(select = "io.github.talelin.latticy.mapper.TestMapper.getBanner")),
            @Result(property = "myImgs",column = "id",
                    many = @Many(select = "io.github.talelin.latticy.mapper.TestMapper.getBitemImg"))
    })
    List<BannerItem> getBannerItemFullimg(Long id);


    /**
     * 插入Banner
     */
    Long insetBaner(Banner banner);
}
