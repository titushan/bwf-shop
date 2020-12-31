package com.bwf.shop.custom.service;

import com.bwf.shop.custom.bean.po.China;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * China 中国地区资源 业务逻辑层 接口
 * */
public interface IChinaService {

    /**
     * 根据父级地区编号查询下属地区列表
     * @param pid 父级地区编号
     * @return 下属地区列表
     * */
    List<China> getChinaListByPid( Integer pid );
}
