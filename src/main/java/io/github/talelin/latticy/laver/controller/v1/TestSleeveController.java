package io.github.talelin.latticy.laver.controller.v1;

import io.github.talelin.latticy.laver.model.BannerDO;
import io.github.talelin.latticy.laver.service.TestSleeveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/test")
public class TestSleeveController {

    @Autowired
    private TestSleeveService testSleeveService;

    @GetMapping("/test1")
    public List<BannerDO> test1(){
        return testSleeveService.getAllBanners();
    }

    @GetMapping("/test3")
    public List<BannerDO> test2(){
        return testSleeveService.getAllBanners2();
    }

    @GetMapping("/test2")
    public long insertBanner(){
        return testSleeveService.insertBanner();
    }

    @GetMapping("/test4 ")
    public List<BannerDO> test4(){
        return testSleeveService.selectList();
    }



}
