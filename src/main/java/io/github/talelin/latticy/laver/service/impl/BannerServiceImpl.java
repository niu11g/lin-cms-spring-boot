package io.github.talelin.latticy.laver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.laver.dto.BannerDTO;
import io.github.talelin.latticy.laver.mapper.BannerMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import io.github.talelin.latticy.laver.service.BannerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper,BannerDO> implements BannerService  {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public IPage<BannerDO> getBanners(Page<BannerDO> page) {
        return bannerMapper.selectPage(page,null);

    }

    @Override
    public void update(BannerDTO dto, Long id) {
        BannerDO bannerDO = this.getById(id);
        if(bannerDO == null){
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(dto,bannerDO);
        this.updateById(bannerDO);
    }
}
