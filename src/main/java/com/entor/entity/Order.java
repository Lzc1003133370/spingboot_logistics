package com.entor.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private String orderId;

    /**
     * 订单信息
     */
    private String orderInformation;

    /**
     * 发送人id
     */
    private String senderId;

    /**
     * 1审核通过、0审核未通过、-1异常
     */
    @TableField("Order_state")
    private Integer orderState;

    /**
     * 订单派送时间
     */
    @TableField("order_Send_out_date")
    private Date orderSendOutDate;

    /**
     * 创建时间
     */
    private Date createTime;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(String orderInformation) {
        this.orderInformation = orderInformation;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderSendOutDate() {
        return orderSendOutDate;
    }

    public void setOrderSendOutDate(Date orderSendOutDate) {
        this.orderSendOutDate = orderSendOutDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
        "orderId=" + orderId +
        ", orderInformation=" + orderInformation +
        ", senderId=" + senderId +
        ", orderState=" + orderState +
        ", orderSendOutDate=" + orderSendOutDate +
        ", createTime=" + createTime +
        "}";
    }
}
