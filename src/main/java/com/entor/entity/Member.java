package com.entor.entity;

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
public class Member implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 会员主键id
     */
    private String memberId;

    /**
     * 会员姓名
     */
    @TableField("Member_name")
    private String memberName;

    /**
     * 会员用户名
     */
    @TableField("Member_username")
    private String memberUsername;

    /**
     * 会员密码
     */
    @TableField("Member_password")
    private String memberPassword;

    /**
     * 会员联系方式
     */
    @TableField("Member_phone")
    private String memberPhone;

    /**
     * 会员地址
     */
    private String memberAddress;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    @Override
    public String toString() {
        return "Member{" +
        "memberId=" + memberId +
        ", memberName=" + memberName +
        ", memberUsername=" + memberUsername +
        ", memberPassword=" + memberPassword +
        ", memberPhone=" + memberPhone +
        ", memberAddress=" + memberAddress +
        "}";
    }
}
