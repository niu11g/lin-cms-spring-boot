package io.github.talelin.latticy.laver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.laver.bo.BannerWithItemsBO;
import io.github.talelin.latticy.laver.dto.BannerDTO;
import io.github.talelin.latticy.laver.mapper.BannerItemMapper;
import io.github.talelin.latticy.laver.mapper.BannerMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import io.github.talelin.latticy.laver.model.BannerItemDO;
import io.github.talelin.latticy.laver.service.BannerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, BannerDO> implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private BannerItemMapper bannerItemMapper;

    @Override
    public IPage<BannerDO> getBanners(Page<BannerDO> page) {
        return bannerMapper.selectPage(page, null);

    }

    @Override
    public void create(BannerDTO dto){
        BannerDO bannerDO = new BannerDO();
        BeanUtils.copyProperties(dto,bannerDO);
        this.bannerMapper.insertBanner(bannerDO);
    }

    @Override
    public void update(BannerDTO dto, Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(dto, bannerDO);
        this.bannerMapper.updateById(bannerDO);
    }

    @Override
    public void delete(Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException(20000);
        }
        this.bannerMapper.deleteById(id);

    }

    @Override
    public BannerWithItemsBO getWithItems(Long id) {
        BannerDO banner = this.getById(id);
        if (banner == null) {
            throw new NotFoundException(20000);
        }
//        1.QueryWrapper<BannerItemDO> wrapper = new QueryWrapper<>();
//        2.LambdaQueryWrapper<BannerItemDO> wrapper = new QueryWrapper<BannerItemDO>().lambda();
// *       LambdaQueryWrapper<BannerItemDO> wrapper = new LambdaQueryWrapper<>();
        //1.匹配表字段名来查找，修改表字段名后，不易维护
//        wrapper.eq("banner_id",id);
        //2.匹配类属性名来查找，修改属性名后idea会自动编译引用错误，易维护
//        wrapper.lambda().eq(BannerItemDO::getBannerId,id);
// *       wrapper.eq(BannerItemDO::getBannerId,id);
// *       List<BannerItemDO> bannerItems = bannerItemMapper.selectList(wrapper);

        //链式法返回数据
        List<BannerItemDO> bannerItems = new LambdaQueryChainWrapper<>(bannerItemMapper)
                .eq(BannerItemDO::getBannerId, id)
                .list();

        return new BannerWithItemsBO(banner, bannerItems);

    }
}
