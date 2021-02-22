package com.bwf.shop.product.service.impl;

import com.bwf.shop.product.bean.bo.SpuSearchBo;
import com.bwf.shop.product.bean.po.Spu;
import com.bwf.shop.product.bean.po.SpuAttrValue;
import com.bwf.shop.product.mapper.SpuESRepository;
import com.bwf.shop.product.mapper.SpuMapper;
import com.bwf.shop.product.service.ISpuService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("spuESService")
public class SpuESService implements ISpuService {

    @Resource
    private SpuMapper spuMapper;

    @Resource
    private SpuESRepository spuESRepository;

    @Override
    public List<Spu> getSpuListBySearchBo(SpuSearchBo bo) {
        // 创建 Bool Query对象
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        if( bo.getSpu_name() != null && ( ! bo.getSpu_name().isEmpty() ) ){
            query.must( QueryBuilders.matchQuery("spu_name", bo.getSpu_name() ) );
        }
        if( bo.getSpu_title() != null && ( ! bo.getSpu_title().isEmpty() ) ){
            query.must( QueryBuilders.matchQuery("spu_title", bo.getSpu_title() ) );
        }
        if( bo.getSpu_status() != null && bo.getSpu_status() != -1 ){
            query.must( QueryBuilders.matchQuery("spu_status", bo.getSpu_status() ) );
        }
        if( bo.getSpu_brand_id() != null && (!bo.getSpu_brand_id().equals("-1")) ){
            query.must( QueryBuilders.matchQuery("spu_brand_id", bo.getSpu_brand_id() ) );
        }
        if( bo.getCate_id() != null && bo.getCate_id() != -1 ){
            query.must( QueryBuilders.matchQuery("categoryList.cate_id", bo.getCate_id() ) );
        }
        if( bo.getSpuAttrValueList() != null && bo.getSpuAttrValueList().size() > 0 ) {
            for (Integer v : bo.getSpuAttrValueList()) {
                query.must(QueryBuilders.termQuery("searchList.attrValueList.value_id", v));
            }
        }

        ////////// 将 query查询条件、pageable分页条件、sort排序条件 合并封装 SearchQuery 搜索对象  //////////
        SearchQuery search = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        ////////// 将 SearchQuery搜索对象 发送到 ElasticSearchRepository中 进行对 ElasticSearch搜索引擎 进行 搜索  //////////
        Page<Spu> page = spuESRepository.search(search);
        return page.getContent();
    }

    @Override
    public List<Spu> getPageableSpuListBySearchBo(SpuSearchBo bo) {
        // 创建 Bool Query对象
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        if( bo.getSpu_name() != null && ( ! bo.getSpu_name().isEmpty() ) ){
            query.must( QueryBuilders.matchQuery("spu_name", bo.getSpu_name() ) );
        }
        if( bo.getSpu_title() != null && ( ! bo.getSpu_title().isEmpty() ) ){
            query.must( QueryBuilders.matchQuery("spu_title", bo.getSpu_title() ) );
        }
        if( bo.getSpu_status() != null && bo.getSpu_status() != -1 ){
            query.must( QueryBuilders.matchQuery("spu_status", bo.getSpu_status() ) );
        }
        if( bo.getSpu_brand_id() != null && (!bo.getSpu_brand_id().equals("-1")) ){
            query.must( QueryBuilders.matchQuery("spu_brand_id", bo.getSpu_brand_id() ) );
        }
        if( bo.getCate_id() != null && bo.getCate_id() != -1 ){
            query.must( QueryBuilders.matchQuery("categoryList.cate_id", bo.getCate_id() ) );
        }
        if( bo.getSpuAttrValueList() != null && bo.getSpuAttrValueList().size() > 0 ) {
            for (Integer v : bo.getSpuAttrValueList()) {
                query.must(QueryBuilders.termQuery("searchList.attrValueList.value_id", v));
            }
        }
        ////////// 根据 搜索课程业务模型对象 封装 Pageable分页条件  //////////
        Pageable pageable = PageRequest.of( bo.getStart() / bo.getLength() , bo.getLength() );

        ////////// 根据 搜索课程业务模型对象 封装 Sort排序条件  //////////
        FieldSortBuilder sort = SortBuilders.fieldSort("spu_id").order(SortOrder.ASC);
        ////////// 将 query查询条件、pageable分页条件、sort排序条件 合并封装 SearchQuery 搜索对象  //////////
        SearchQuery search = new NativeSearchQueryBuilder()
                .withQuery(query)
                .withPageable(pageable)
                .withSort(sort)
                .build();

        ////////// 将 SearchQuery搜索对象 发送到 ElasticSearchRepository中 进行对 ElasticSearch搜索引擎 进行 搜索  //////////
        Page<Spu> page = spuESRepository.search(search);
        return page.getContent();
    }

    @Override
    public Long getSpuListSizeBySearchBo(SpuSearchBo bo) {
        // 创建 Bool Query对象
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        if( bo.getSpu_name() != null && ( ! bo.getSpu_name().isEmpty() ) ){
            query.must( QueryBuilders.matchQuery("spu_name", bo.getSpu_name() ) );
        }
        if( bo.getSpu_title() != null && ( ! bo.getSpu_title().isEmpty() ) ){
            query.must( QueryBuilders.matchQuery("spu_title", bo.getSpu_title() ) );
        }
        if( bo.getSpu_status() != null && bo.getSpu_status() != -1 ){
            query.must( QueryBuilders.matchQuery("spu_status", bo.getSpu_status() ) );
        }
        if( bo.getSpu_brand_id() != null && (!bo.getSpu_brand_id().equals("-1") )){
            query.must( QueryBuilders.matchQuery("spu_brand_id", bo.getSpu_status() ) );
        }
        if( bo.getCate_id() != null && bo.getCate_id() != -1 ){
            query.must( QueryBuilders.matchQuery("cate_id", bo.getCate_id() ) );
        }
        for( Integer v : bo.getSpuAttrValueList() ){
            query.must( QueryBuilders.matchQuery("spu.attrKeyList.attrValueList.value_id", v ) );
        }


        ////////// 将 query查询条件、pageable分页条件、sort排序条件 合并封装 SearchQuery 搜索对象  //////////
        SearchQuery search = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();
        Page<Spu> page = spuESRepository.search(search);
        return page.stream().count();
    }

    @Override
    public Spu getSpuById(Long spu_id) {
        return spuESRepository.findById(spu_id).get();
    }
}
