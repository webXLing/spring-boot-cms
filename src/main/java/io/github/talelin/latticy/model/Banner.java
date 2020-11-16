package io.github.talelin.latticy.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Banner {
    private Long id;
    private String name;
    private String description;
    private String title;
    private String img;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
