package io.github.talelin.latticy.laver.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("banner_item")
public class BannerItemDO {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String name;

    private String img;

    private String keyword;

    private Integer type;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    @TableLogic
    private Date deleteTime;

    @TableField("banner_id")
    private Long bannerId;


}
