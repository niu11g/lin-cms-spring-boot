package io.github.talelin.latticy.laver.model;

import io.github.talelin.latticy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author generator@TaleLin
 * @since 2020-09-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("category")
public class CategoryDO extends BaseModel {


    private String name;

    private String description;

    private Integer isRoot;

    private Integer parentId;

    private String img;

    private Integer index;

    private Integer online;

    private Integer level;


}
