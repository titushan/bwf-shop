package com.bwf.shop.product.mapper;

import com.bwf.shop.product.bean.po.Spu;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SpuESRepository extends ElasticsearchRepository<Spu,Long> {
}
