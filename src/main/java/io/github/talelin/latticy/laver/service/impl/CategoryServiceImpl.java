package io.github.talelin.latticy.laver.service.impl;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.laver.model.CategoryDO;
import io.github.talelin.latticy.laver.mapper.CategoryMapper;
import io.github.talelin.latticy.laver.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-09-16
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDO> implements CategoryService {

    @Override
    public CategoryDO getCategoryById(Integer id) {
        CategoryDO categoryDO = this.getById(id);
        if(categoryDO == null){
            throw new NotFoundException(40000);
        }
        return categoryDO;
    }
}
