package io.github.talelin.latticy.laver.service.impl;

import io.github.talelin.latticy.dto.SpuDTO;
import io.github.talelin.latticy.laver.model.CategoryDO;
import io.github.talelin.latticy.laver.model.SpuDO;
import io.github.talelin.latticy.laver.mapper.SpuMapper;
import io.github.talelin.latticy.laver.model.SpuDetailDO;
import io.github.talelin.latticy.laver.service.CategoryService;
import io.github.talelin.latticy.laver.service.SpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-09-14
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, SpuDO> implements SpuService {
    @Autowired
    private CategoryService categoryService;

    @Override
    public SpuDetailDO getDetail(Integer id) {
        return this.getBaseMapper().getDetail(id);
    }

    @Override
    public void create(SpuDTO dto) {
        SpuDO spuDO = new SpuDO();
        BeanUtils.copyProperties(dto,spuDO);
        CategoryDO categoryDO = categoryService.getCategoryById(dto.getCategoryId());
        spuDO.setRootCategoryId(categoryDO.getParentId());
        this.save(spuDO);
    }
}
