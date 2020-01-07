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
public class RoleAuth implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色权限主键
     */
    private String roleAuth;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String authId;


    public String getRoleAuth() {
        return roleAuth;
    }

    public void setRoleAuth(String roleAuth) {
        this.roleAuth = roleAuth;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "RoleAuth{" +
        "roleAuth=" + roleAuth +
        ", roleId=" + roleId +
        ", authId=" + authId +
        "}";
    }
}
