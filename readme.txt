# Dev 开发环境

eureka-server 服务中心
    url = http://127.0.0.1:9001
          http://127.0.0.1:9002

config 配置中心
    url = http://127.0.0.1:7001/master/{application}-{profile}.properties

zuul 网关
    url = http://127.0.0.1:8080

    反向代理:
        http://127.0.0.1:8080/custom/**  =>  bwf-shop-custom
        http://127.0.0.1:8080/product/**  =>  bwf-shop-product
        http://127.0.0.1:8080/order/**  =>  bwf-shop-order
        http://127.0.0.1:8080/website/**  =>  bwf-shop-website

bwf-shop-custom 客户服务
    url = http://127.0.0.1:8001

bwf-shop-product 商品服务
    url = http://127.0.0.1:8101

bwf-shop-order 订单服务
    url = http://127.0.0.1:8201

bwf-shop-website 站点服务
    url = http://127.0.0.1:8301

# Prod 生产环境