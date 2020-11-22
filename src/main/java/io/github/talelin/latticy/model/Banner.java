package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class Banner implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String title;
    private String img;

    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;


    @JsonIgnore
//    TableLogic 软删除
    @TableLogic
    private Date deleteTime;
}
