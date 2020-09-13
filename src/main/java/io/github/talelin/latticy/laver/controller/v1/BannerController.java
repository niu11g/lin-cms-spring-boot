package io.github.talelin.latticy.laver.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.core.annotation.LoginRequired;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.laver.bo.BannerWithItemsBO;
import io.github.talelin.latticy.laver.dto.BannerDTO;
import io.github.talelin.latticy.laver.model.BannerDO;
import io.github.talelin.latticy.laver.service.BannerService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import net.sf.jsqlparser.statement.create.view.CreateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;


@RequestMapping("/v1/banner")
@RestController
@Validated
public class BannerController {
    @Autowired
    private BannerService bannerService;

    public CreatedVO create(@RequestBody @Validated BannerDTO dto){
        bannerService.create(dto);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated BannerDTO dto,
                       @PathVariable @Positive Long id) {
        bannerService.update(dto, id);
        return new UpdatedVO();

    }

    //@LoginRequired：限制不能直接通过浏览器和PostMan访问,要访问必须携带当前用户的令牌
    //@AdminRequired：如果接口只能管理员访问，必须登陆且分组必须是管理员
    //@GroupRequired：接口保护，分组被分配了这个权限，才能被访问。通常和@PermissionMeta注解一起使用
    //@PermissionMeta(value="删除Banner",module="Banner"):只附加元数据，不被保护
    //@PermissionModule：类注解，提供接口默认module名
    //lin-cms是为每个API分配权限

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id) {
//        bannerService
        bannerService.delete(id);
        return new DeletedVO();

    }

    //required 代表是否必须
    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBanners(@RequestParam(required = false, defaultValue = "0")
                                               @Min(value = 0) Integer page,
                                               @RequestParam(required = false, defaultValue = "10")
                                               @Min(value = 1, message = "{page.count.min}")
                                               @Max(value = 30, message = "{page.count.max}") Integer count) {
        Page<BannerDO> pager = new Page<>(page, count);
        IPage<BannerDO> paging = bannerService.getBanners(pager);
        return new PageResponseVO<BannerDO>((int)paging.getTotal(), paging.getRecords(), (int)paging.getCurrent(), (int)paging.getSize());
    }

    @GetMapping("/{id}")
    @LoginRequired
    public BannerWithItemsBO getWithItems(@PathVariable @Positive Long id){
        return bannerService.getWithItems(id);
    }


}
