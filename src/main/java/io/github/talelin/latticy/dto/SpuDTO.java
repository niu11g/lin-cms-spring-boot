package io.github.talelin.latticy.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlNs;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/9/16 3:35 下午
 * @Remark: 商品信息接入接口
 */
@Data
public class SpuDTO {

    @NotBlank
    @Length(min=1,max=128)
    private String title;

    @NotBlank
    @Length(min=1,max = 255)
    private String subtitle;

    @NotBlank
    @Length(min=1,max = 255)
    private String img;

    @Length(min=1,max = 255)
    private String forThemeImg;

    @Positive
    @NotNull
    private Long categoryId;

    @Max(1)
    @Max(0)
    private Integer online;

    @Positive
    private Long sketchSpecId;

    //正整数
    @Positive
    private Long defaultSkuId;

    @NotBlank
    @Length(min=1,max = 20)
    private String price;

    @Length(min=1,max = 20)
    private String discountPrice;

    @Length(min=1,max = 255)
    private String description;

    @Length(min=1,max = 255)
    private String tags;

    private List<Long> specKeyIdList;

    private List<String> spuImgList;

    private List<String> detailImgList;




}
