package io.github.talelin.latticy.laver.service.impl;

import io.github.talelin.latticy.laver.model.SpecKeyDO;
import io.github.talelin.latticy.laver.mapper.SpecKeyMapper;
import io.github.talelin.latticy.laver.service.SpecKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-09-16
 */
@Service
public class SpecKeyServiceImpl extends ServiceImpl<SpecKeyMapper, SpecKeyDO> implements SpecKeyService {

    @Override
    public List<SpecKeyDO> getBySpuId(Integer spuId) {

         return this.baseMapper.getBySpuId(spuId);
    }
}
