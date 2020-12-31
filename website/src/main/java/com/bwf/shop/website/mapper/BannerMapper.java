package com.bwf.shop.website.mapper;

import com.bwf.shop.website.bean.po.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Banner 轮播资源 数据访问层 接口
 * */
@Repository
public interface BannerMapper {

    /**
     * 根据轮播状态查询轮播列表
     * @param status 轮播状态
     * @return 轮播列表
     * */
    List<Banner> getBannerListByStatus( @Param("status") Byte status );

}
