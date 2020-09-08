package io.github.talelin.latticy.laver.service;

import io.github.talelin.latticy.laver.mapper.BannerMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestSleeveService {

    @Autowired
    private BannerMapper bannerMapper;

    public List<BannerDO> getAllBanners(){
        return this.bannerMapper.getAllBanners();
    }

    public List<BannerDO> getAllBanners2(){
        return this.bannerMapper.getAllBanners2();

    }

    public List<BannerDO> selectList(){
        return this.bannerMapper.selectList(null);
    }

    public long insertBanner(){
        BannerDO bannerDO = new BannerDO();
        bannerDO.setName("测试插入姓名");
        bannerDO.setTitle("请输入标题");

        this.bannerMapper.insertBanner(bannerDO);
        return bannerDO.getId();
    }
}
