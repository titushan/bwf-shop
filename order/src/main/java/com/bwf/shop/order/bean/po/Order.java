package com.bwf.shop.order.bean.po;

import java.sql.Date;

/**
 * 订单
 * */
public class Order {

    private Integer id;                 // 订单id
    private Integer order_user_id;      // 所属用户编号
    private String order_no;            // 订单编号
    private Integer order_status;       // 订单状态 0.已下单 2.已付款 4.已配货 6.已发货 8.已收货 10.已评价 30.退款中 32.已退款 34.退款失败 40.已取消
    private Double order_spuamount;     // 订单商品总金额
    private Double order_expressfee;    // 配送费
    private Double order_totalamount;   // 订单总金额
    private Double order_discountamount;    // 优惠金额
    private Double order_payamount;     // 实付金额
    private Integer order_paymode;      // 支付方式 0.支付宝 1.微信
    private Integer order_payplatform;  // 支付平台 0.pc 1.app 2.小程序 3.手机H5
    private String order_ipaddress;     // 请求付款时设备ip地址
    private String order_paymentno;     // 支付平台的支付单号
    private String order_remark;        // 订单备注
    private Date createtime;            // 订单的创建时间
    private Date updatetime;            // 最后更新时间

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_user_id() {
        return order_user_id;
    }

    public void setOrder_user_id(Integer order_user_id) {
        this.order_user_id = order_user_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Double getOrder_spuamount() {
        return order_spuamount;
    }

    public void setOrder_spuamount(Double order_spuamount) {
        this.order_spuamount = order_spuamount;
    }

    public Double getOrder_expressfee() {
        return order_expressfee;
    }

    public void setOrder_expressfee(Double order_expressfee) {
        this.order_expressfee = order_expressfee;
    }

    public Double getOrder_totalamount() {
        return order_totalamount;
    }

    public void setOrder_totalamount(Double order_totalamount) {
        this.order_totalamount = order_totalamount;
    }

    public Double getOrder_discountamount() {
        return order_discountamount;
    }

    public void setOrder_discountamount(Double order_discountamount) {
        this.order_discountamount = order_discountamount;
    }

    public Double getOrder_payamount() {
        return order_payamount;
    }

    public void setOrder_payamount(Double order_payamount) {
        this.order_payamount = order_payamount;
    }

    public Integer getOrder_paymode() {
        return order_paymode;
    }

    public void setOrder_paymode(Integer order_paymode) {
        this.order_paymode = order_paymode;
    }

    public Integer getOrder_payplatform() {
        return order_payplatform;
    }

    public void setOrder_payplatform(Integer order_payplatform) {
        this.order_payplatform = order_payplatform;
    }

    public String getOrder_ipaddress() {
        return order_ipaddress;
    }

    public void setOrder_ipaddress(String order_ipaddress) {
        this.order_ipaddress = order_ipaddress;
    }

    public String getOrder_paymentno() {
        return order_paymentno;
    }

    public void setOrder_paymentno(String order_paymentno) {
        this.order_paymentno = order_paymentno;
    }

    public String getOrder_remark() {
        return order_remark;
    }

    public void setOrder_remark(String order_remark) {
        this.order_remark = order_remark;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
