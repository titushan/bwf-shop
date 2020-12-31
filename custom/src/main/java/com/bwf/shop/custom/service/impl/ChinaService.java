package com.bwf.shop.custom.service.impl;

import com.bwf.shop.custom.bean.po.China;
import com.bwf.shop.custom.mapper.ChinaMapper;
import com.bwf.shop.custom.service.IChinaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * China 中国地区资源 业务逻辑层 实现类
 * */
@Service
public class ChinaService implements IChinaService {
    // 依赖的数据访问层
    @Resource
    private ChinaMapper chinaMapper;

    @Override
    public List<China> getChinaListByPid(Integer pid) {
        return chinaMapper.getChinaListByPid(pid);
    }
}
