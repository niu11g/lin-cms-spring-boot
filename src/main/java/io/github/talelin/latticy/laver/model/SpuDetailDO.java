package io.github.talelin.latticy.laver.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/9/14 11:56 上午
 * @Remark: Spu详细信息关联Sku
 */
//VO类表示直接返回给前端的数据对象 DO表示数据库中查询出来的字段 BO表示自己业务的实体对象
@Data
public class SpuDetailDO extends SpuDO {

    private String categoryName;

    private String sketchSpecName;

    private String defaultSkuName;

    private List<String> bannnerImgs;

    private List<String> detailImgs;

}
