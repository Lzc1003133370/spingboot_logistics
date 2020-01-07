package com.entor.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
public class StaffRole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 员工角色id
     */
    private String staffRoleId;

    /**
     * 员工id
     */
    private String staffId;

    /**
     * 角色id
     */
    private String roleId;


    public String getStaffRoleId() {
        return staffRoleId;
    }

    public void setStaffRoleId(String staffRoleId) {
        this.staffRoleId = staffRoleId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "StaffRole{" +
        "staffRoleId=" + staffRoleId +
        ", staffId=" + staffId +
        ", roleId=" + roleId +
        "}";
    }
}
