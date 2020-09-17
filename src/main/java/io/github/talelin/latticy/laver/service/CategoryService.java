package io.github.talelin.latticy.laver.service;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.laver.model.CategoryDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Locale;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-09-16
 */
public interface CategoryService extends IService<CategoryDO> {

    CategoryDO getCategoryById(Integer id);

}
