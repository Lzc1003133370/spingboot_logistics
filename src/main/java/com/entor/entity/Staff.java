package com.entor.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
public class Staff implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 员工id
     */
    private String staffId;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 员工用户名
     */
    private String staffUsername;

    /**
     * 员工密码
     */
    private String staffPassword;

    /**
     * 员工联系方式
     */
    private String staffPhone;

    /**
     * 工作地址
     */
    private String staffWorkAddress;

    /**
     * 创建时间
     */
    private Date createTime;


    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffWorkAddress() {
        return staffWorkAddress;
    }

    public void setStaffWorkAddress(String staffWorkAddress) {
        this.staffWorkAddress = staffWorkAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Staff{" +
        "staffId=" + staffId +
        ", staffName=" + staffName +
        ", staffUsername=" + staffUsername +
        ", staffPassword=" + staffPassword +
        ", staffPhone=" + staffPhone +
        ", staffWorkAddress=" + staffWorkAddress +
        ", createTime=" + createTime +
        "}";
    }
}
