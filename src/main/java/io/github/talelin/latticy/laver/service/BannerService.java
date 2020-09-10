package io.github.talelin.latticy.laver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.laver.bo.BannerWithItemsBO;
import io.github.talelin.latticy.laver.dto.BannerDTO;
import io.github.talelin.latticy.laver.model.BannerDO;

public interface BannerService  {

     IPage<BannerDO> getBanners(Page<BannerDO> page);

     void update(BannerDTO dto,Long id);

     void delete(Long id);

     BannerWithItemsBO getWithItems(Long id);
}
