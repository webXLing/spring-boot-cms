package io.github.talelin.latticy.model;

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
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
