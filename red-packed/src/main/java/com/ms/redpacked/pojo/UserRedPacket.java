package com.ms.redpacked.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class UserRedPacket implements Serializable {

	private Long id;
	/**
	 * 红包ID
	 */
	private Long redPacketId;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 钱
	 */
	private Double amount;
	/**
	 * 抢红包的时间
	 */
	private Date grabTime;
	/**
	 * 备注
	 */
	private String remark;
	
	private static final long serialVersionUID = -5617482065991830143L;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRedPacketId() {
		return redPacketId;
	}

	public void setRedPacketId(Long redPacketId) {
		this.redPacketId = redPacketId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getGrabTime() {
		return grabTime;
	}

	public void setGrabTime(Date grabTime) {
		this.grabTime = grabTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}