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
 * @since 2020-01-15
 */
public class Waybill implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 运单号
     */
    private String waybillNo;

    /**
     * 发件人姓名
     */
    private String sName;

    /**
     * 发件人手机
     */
    private String sPhone;

    /**
     * 发件人地址
     */
    private String sAddress;

    /**
     * 收件的姓名
     */
    private String rName;

    /**
     * 收件人手机
     */
    private String rPhone;

    /**
     * 收件的地址
     */
    private String rAddress;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;


    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrPhone() {
        return rPhone;
    }

    public void setrPhone(String rPhone) {
        this.rPhone = rPhone;
    }

    public String getrAddress() {
        return rAddress;
    }

    public void setrAddress(String rAddress) {
        this.rAddress = rAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Waybill{" +
        "waybillNo=" + waybillNo +
        ", sName=" + sName +
        ", sPhone=" + sPhone +
        ", sAddress=" + sAddress +
        ", rName=" + rName +
        ", rPhone=" + rPhone +
        ", rAddress=" + rAddress +
        ", createTime=" + createTime +
        "}";
    }
}
