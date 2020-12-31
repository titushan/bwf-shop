package com.bwf.shop.custom.mapper;

import com.bwf.shop.custom.bean.po.China;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * China 中国地区 资源 数据访问层 接口
 * */
@Repository
public interface ChinaMapper {

    /**
     * 根据父级地区编号查询下属地区列表
     * @param pid 父级地区编号
     * @return 下属地区列表
     * */
    List<China> getChinaListByPid( @Param("pid") Integer pid );
}
