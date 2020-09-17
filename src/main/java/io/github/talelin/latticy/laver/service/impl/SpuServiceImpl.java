package io.github.talelin.latticy.laver.service.impl;

import com.sun.tools.corba.se.idl.InterfaceGen;
import io.github.talelin.latticy.laver.dto.SpuDTO;
import io.github.talelin.latticy.laver.model.*;
import io.github.talelin.latticy.laver.mapper.SpuMapper;
import io.github.talelin.latticy.laver.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-09-14
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, SpuDO> implements SpuService {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SpuImgService spuImgService;

    @Autowired
    private SpuDetailImgService spuDetailImgService;

    @Autowired
    private SpuKeyService spuKeyService;

    @Override
    public SpuDetailDO getDetail(Integer id) {
        return this.getBaseMapper().getDetail(id);
    }

    @Override
    //事务操作分了好几段时得加事务注解 失败一步则都回滚 不操作
    @Transactional
    public void create(SpuDTO dto) {
        SpuDO spuDO = new SpuDO();
//        copyProperties方法必须源数据和目标数据字段值类型也相同才能复制赋值成功
        BeanUtils.copyProperties(dto,spuDO);
        CategoryDO categoryDO = categoryService.getCategoryById(dto.getCategoryId());
        spuDO.setRootCategoryId(categoryDO.getParentId());
        //添加完后会自动返回id字段
        this.save(spuDO);

        List<String> spuImgList = new ArrayList<>();
        if(dto.getSpuImgList() == null){
            spuImgList.add(dto.getImg());
        }else {
            spuImgList = dto.getSpuImgList();
        }
        this.insertSpuImgList(spuImgList,spuDO.getId());

        if(dto.getDetailImgList() != null){
            this.insertSpuDetailImgList(dto.getDetailImgList(),spuDO.getId());
        }
        if(dto.getSpecKeyIdList() != null){
            this.insertSpuKeyList(dto.getSpecKeyIdList(),spuDO.getId());
        }

    }

    public void insertSpuImgList(List<String> spuImgList, Integer spuId){
        List<SpuImgDO> spuImgDOList = spuImgList.stream().map(s->{
            SpuImgDO spuImgDO = new SpuImgDO();
            spuImgDO.setImg(s);
            spuImgDO.setSpuId(spuId);
            return spuImgDO;
        }).collect(Collectors.toList());
        this.spuImgService.saveBatch(spuImgDOList);
    }

    public void insertSpuDetailImgList(List<String> spuDetailImgList,Integer spuId){
        List<SpuDetailImgDO> spuDetailImgDOList = new ArrayList<>();
        for(int i = 0;i<spuDetailImgList.size();i++) {
            SpuDetailImgDO spuDetailImgDO = new SpuDetailImgDO();
            spuDetailImgDO.setImg(spuDetailImgList.get(i))
                    .setSpuId(spuId)
                    .setIndex(i);
            spuDetailImgDOList.add(spuDetailImgDO);
        }
        this.spuDetailImgService.saveBatch(spuDetailImgDOList);
    }

    public void insertSpuKeyList(List<Integer> spuKeyIdList,Integer spuId){
        List<SpuKeyDO> spuKeyDOList = spuKeyIdList.stream()
                .map(sk->{
                    SpuKeyDO spuKeyDO = new SpuKeyDO();
                    spuKeyDO.setSpuId(spuId)
                            .setSpecKeyId(sk);
                    return spuKeyDO;
                }).collect(Collectors.toList());
        this.spuKeyService.saveBatch(spuKeyDOList);
    }

}
