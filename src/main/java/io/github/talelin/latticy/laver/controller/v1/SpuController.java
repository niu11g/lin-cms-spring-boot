package io.github.talelin.latticy.laver.controller.v1;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.laver.dto.SpuDTO;
import io.github.talelin.latticy.laver.model.SpuDetailDO;
import io.github.talelin.latticy.laver.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.laver.model.SpuDO;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

/**
* @author generator@TaleLin
* @since 2020-09-14
*/
@RestController
@RequestMapping("/v1/spu")
@Validated
public class SpuController {

    @Autowired
    private SpuService spuService;

    @PostMapping("")
    public CreatedVO create(@RequestBody @Validated SpuDTO spuDTO) {
        this.spuService.create(spuDTO);
        return new CreatedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(@PathVariable @Positive(message = "{id.positive}") Integer id) {
        return new UpdatedVO();
    }

    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive(message = "{id.positive}") Integer id) {
        return new DeletedVO();
    }

    @GetMapping("/{id}")
    public SpuDO get(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        return null;
    }

    @GetMapping("/{id}/detail")
    public SpuDetailDO getDetail(@PathVariable(value="id") @Positive Integer id ){
        //单表
        return this.spuService.getDetail(id);
    }

    @GetMapping("/page")
    public PageResponseVO<SpuDO> page(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{page.count.min}")
            @Max(value = 30, message = "{page.count.max}") Integer count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page.number.min}") Integer page
    ) {
        Page<SpuDO> pager = new Page<>(page,count);
        IPage<SpuDO> paging = spuService.getBaseMapper().selectPage(pager,null);
        return PageUtil.build(paging);
    }

}
