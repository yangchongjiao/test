package jsontest;

public class MemberCardView {

	
	
	private String memberId;
	private String nickName ;
	private String tel;
	private String address;
	private String labelname;
	public MemberCardView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberCardView(String memberId, String nickName, String tel, String address, String labelname) {
		super();
		this.memberId = memberId;
		this.nickName = nickName;
		this.tel = tel;
		this.address = address;
		this.labelname = labelname;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLabelname() {
		return labelname;
	}
	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}
	@Override
	public String toString() {
		return "MemberCard [memberId=" + memberId + ", nickName=" + nickName + ", tel=" + tel + ", address=" + address
				+ ", labelname=" + labelname + "]";
	}
	
	



}
