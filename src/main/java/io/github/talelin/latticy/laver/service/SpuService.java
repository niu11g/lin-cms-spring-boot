package io.github.talelin.latticy.laver.service;

import io.github.talelin.latticy.dto.SpuDTO;
import io.github.talelin.latticy.laver.model.SpuDO;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.laver.model.SpuDetailDO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-09-14
 */
public interface SpuService extends IService<SpuDO> {

     SpuDetailDO getDetail(Integer id);

     void create(SpuDTO spuDTO);

}
