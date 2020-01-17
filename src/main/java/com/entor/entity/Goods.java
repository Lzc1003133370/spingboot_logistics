package com.entor.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 展成
 * @since 2020-01-17
 */
public class Goods implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 货物id
     */
    private String goodsId;

    /**
     * 货物信息
     */
    private String goodsInformation;

    /**
     * 货物重量
     */
    private String goodsWeight;

    /**
     * 订单id
     */
    private String waybillId;

    /**
     * 发送人id（用户id）
     */
    private String senderId;

    /**
     * 创建时间
     */
    private Date createTime;


    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsInformation() {
        return goodsInformation;
    }

    public void setGoodsInformation(String goodsInformation) {
        this.goodsInformation = goodsInformation;
    }

    public String getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
        "goodsId=" + goodsId +
        ", goodsInformation=" + goodsInformation +
        ", goodsWeight=" + goodsWeight +
        ", waybillId=" + waybillId +
        ", senderId=" + senderId +
        ", createTime=" + createTime +
        "}";
    }
}
