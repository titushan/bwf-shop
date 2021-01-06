package com.bwf.shop.product.service;

import com.bwf.shop.product.bean.po.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBrandService {

    List<Brand> getBrandListByCategoryId(Integer cate_id );
}
