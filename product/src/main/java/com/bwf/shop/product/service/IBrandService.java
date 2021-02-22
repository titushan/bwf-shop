package com.bwf.shop.product.service;

import com.bwf.shop.product.bean.po.Brand;
import com.bwf.shop.product.bean.po.Spu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBrandService {

    List<Brand> getBrandListByCategoryId(Integer cate_id );

    List<Brand> getBrandListBySpuList( List<Spu> spuList);
}
