package jsontest;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;


public class RedEnvelope implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9073784768918957598L;
	
	private String id;
	private String redId;
	private String publisherMemberId;
	private String money;
	private String publishTime;
	private String updateTime;
	private String totalCount;
	private String grabCount;
	private String lat;
	private String lng;
	private String receivers = "";
	private String content;
	private String address;
	private String overtime; //(0 no , 1 yes )
	private String moneys; //每一份钱数，以逗号分开
	private String hasPaied;//(0 no , 1 yes )
	
	
	//for mongo
	private double[] location;
	
	
	
	public RedEnvelope() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getRedId() {
		return redId;
	}



	public void setRedId(String redId) {
		this.redId = redId;
	}



	public String getPublisherMemberId() {
		return publisherMemberId;
	}



	public void setPublisherMemberId(String publisherMemberId) {
		this.publisherMemberId = publisherMemberId;
	}



	public String getMoney() {
		return money;
	}



	public void setMoney(String money) {
		this.money = money;
	}



	public String getPublishTime() {
		return publishTime;
	}



	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}



	public String getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}



	public String getTotalCount() {
		return totalCount;
	}



	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}



	public String getGrabCount() {
		return grabCount;
	}



	public void setGrabCount(String grabCount) {
		this.grabCount = grabCount;
	}



	public String getLat() {
		return lat;
	}



	public void setLat(String lat) {
		this.lat = lat;
	}



	public String getLng() {
		return lng;
	}



	public void setLng(String lng) {
		this.lng = lng;
	}



	public String getReceivers() {
		return receivers;
	}



	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getOvertime() {
		return overtime;
	}



	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}



	public String getMoneys() {
		return moneys;
	}



	public void setMoneys(String moneys) {
		this.moneys = moneys;
	}



	public String getHasPaied() {
		return hasPaied;
	}



	public void setHasPaied(String hasPaied) {
		this.hasPaied = hasPaied;
	}



	public double[] getLocation() {
		return location;
	}



	public void setLocation(double[] location) {
		this.location = location;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public RedEnvelope(String id, String redId, String publisherMemberId, String money, String publishTime,
			String updateTime, String totalCount, String grabCount, String lat, String lng, String receivers,
			String content, String address, String overtime, String moneys, String hasPaied, double[] location) {
		super();
		this.id = id;
		this.redId = redId;
		this.publisherMemberId = publisherMemberId;
		this.money = money;
		this.publishTime = publishTime;
		this.updateTime = updateTime;
		this.totalCount = totalCount;
		this.grabCount = grabCount;
		this.lat = lat;
		this.lng = lng;
		this.receivers = receivers;
		this.content = content;
		this.address = address;
		this.overtime = overtime;
		this.moneys = moneys;
		this.hasPaied = hasPaied;
		this.location = location;
	}



	@Override
	public String toString() {
		return "RedEnvelope [id=" + id + ", redId=" + redId + ", publisherMemberId=" + publisherMemberId + ", money="
				+ money + ", publishTime=" + publishTime + ", updateTime=" + updateTime + ", totalCount=" + totalCount
				+ ", grabCount=" + grabCount + ", lat=" + lat + ", lng=" + lng + ", receivers=" + receivers
				+ ", content=" + content + ", address=" + address + ", overtime=" + overtime + ", moneys=" + moneys
				+ ", hasPaied=" + hasPaied + ", location=" + Arrays.toString(location) + "]";
	}


	
}
