package com.bwf.shop.website.service.impl;

import com.bwf.shop.website.bean.po.Banner;
import com.bwf.shop.website.mapper.BannerMapper;
import com.bwf.shop.website.service.IBannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Banner 轮播资源 业务逻辑层 实现类
 * */
@Service
public class BannerService implements IBannerService {

    // 依赖的数据访问层
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> getBannerListByStatus(Byte status) {
        return bannerMapper.getBannerListByStatus(status);
    }
}
