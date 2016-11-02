package jsontest;

/**
* @ClassName: NearUserSaidView  
* @Description: 附近人说的话  
* @author ycj 
* @date 2016年7月4日 下午3:27:15  
*
 */
/**  
* @ClassName: NearUserSaidView  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author ycj 
* @date 2016年7月5日 下午12:27:15  
*    
*/  
public class NearUserSaidView {

	private String memberId = "";
	private String nikename = "";
	private String sex = "";
	private String img = "";
	private String distance = "";
	private String randomstatement = "";// 附近人说的的话（在短语数据库表中随机生成）
	public NearUserSaidView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NearUserSaidView(String memberId, String nikename, String sex, String img, String distance,
			String randomstatement) {
		super();
		this.memberId = memberId;
		this.nikename = nikename;
		this.sex = sex;
		this.img = img;
		this.distance = distance;
		this.randomstatement = randomstatement;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getRandomstatement() {
		return randomstatement;
	}
	public void setRandomstatement(String randomstatement) {
		this.randomstatement = randomstatement;
	}
	@Override
	public String toString() {
		return "NearUserSaidView [memberId=" + memberId + ", nikename=" + nikename + ", sex=" + sex + ", img=" + img
				+ ", distance=" + distance + ", randomstatement=" + randomstatement + "]";
	}
	
}
