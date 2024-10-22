package io.github.talelin.latticy.laver.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@TableName("banner")
public class BannerDO {
    //细粒度权限控制 字段权限控制
    //动态SQL 分拆API方案
    //select banner.name banner.id banner.img
    private Long id;

    private String name;

    private String title;

    private String description;

    private String img;

//    private List<BannerItemDO> bannerItems;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    //软删除
    @TableLogic
    private Date deleteTime;
}
