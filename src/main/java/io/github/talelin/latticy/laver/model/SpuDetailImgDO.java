package io.github.talelin.latticy.laver.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.github.talelin.latticy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author generator@TaleLin
 * @since 2020-09-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("spu_detail_img")
public class SpuDetailImgDO extends BaseModel {


    private String img;

    private Integer spuId;

    @TableField(value = "`index`")
    private Integer index;


}
