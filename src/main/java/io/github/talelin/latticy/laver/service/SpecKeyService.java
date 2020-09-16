package io.github.talelin.latticy.laver.service;

import io.github.talelin.latticy.laver.model.SpecKeyDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-09-16
 */
public interface SpecKeyService extends IService<SpecKeyDO> {

    List<SpecKeyDO> getBySpuId(Integer spuId);

}
