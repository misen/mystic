package com.ms.redpacked.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class RedPacket implements Serializable {
	/**
	 * ID
	 */
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 抢的钱
	 */
	private Double amount;
	/**
	 * 时间
	 */
	private Date sendDate;
	/**
	 *
	 */
	private Integer total;
	private Double unitAmount;
	private Integer stock;
	private Integer version;
	private String remark;


}