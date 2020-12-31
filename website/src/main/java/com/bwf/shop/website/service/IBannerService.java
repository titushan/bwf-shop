package com.bwf.shop.website.service;

import com.bwf.shop.website.bean.po.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Banner 轮播资源 业务逻辑层 接口
 * */
public interface IBannerService {

    /**
     * 根据轮播状态查询轮播列表
     * @param status 轮播状态
     * @return 轮播列表
     * */
    List<Banner> getBannerListByStatus(Byte status );
}
