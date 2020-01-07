package com.entor.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Driver implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 司机id
     */
    @TableId("Driver_id")
    private String driverId;

    /**
     * 司机姓名
     */
    @TableField("Driver_name")
    private String driverName;

    /**
     * 司机状态（0空闲,1送货）
     */
    @TableField("Driver_free")
    private Integer driverFree;

    /**
     * 司机联系方式
     */
    private String driverPhone;

    /**
     * 创建时间
     */
    private Date createTime;


    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getDriverFree() {
        return driverFree;
    }

    public void setDriverFree(Integer driverFree) {
        this.driverFree = driverFree;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Driver{" +
        "driverId=" + driverId +
        ", driverName=" + driverName +
        ", driverFree=" + driverFree +
        ", driverPhone=" + driverPhone +
        ", createTime=" + createTime +
        "}";
    }
}
