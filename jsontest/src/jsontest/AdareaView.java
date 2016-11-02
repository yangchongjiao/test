package jsontest;

public class AdareaView {

	private String id;
	private String title;
	private String flag;
	private String link;
	private String starttime;
	private String endtime;
	private String img;
	private String userid;
	private String adlevel;
	private String provinceid;
	private String cityid;
	private String pass;
	private String del;
	private String content;
	private String smlogo;
	private String tel;
	public AdareaView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdareaView(String id, String title, String flag, String link, String starttime, String endtime, String img,
			String userid, String adlevel, String provinceid, String cityid, String pass, String del, String content,
			String smlogo, String tel) {
		super();
		this.id = id;
		this.title = title;
		this.flag = flag;
		this.link = link;
		this.starttime = starttime;
		this.endtime = endtime;
		this.img = img;
		this.userid = userid;
		this.adlevel = adlevel;
		this.provinceid = provinceid;
		this.cityid = cityid;
		this.pass = pass;
		this.del = del;
		this.content = content;
		this.smlogo = smlogo;
		this.tel = tel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAdlevel() {
		return adlevel;
	}
	public void setAdlevel(String adlevel) {
		this.adlevel = adlevel;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSmlogo() {
		return smlogo;
	}
	public void setSmlogo(String smlogo) {
		this.smlogo = smlogo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "AdareaView [id=" + id + ", title=" + title + ", flag=" + flag + ", link=" + link + ", starttime="
				+ starttime + ", endtime=" + endtime + ", img=" + img + ", userid=" + userid + ", adlevel=" + adlevel
				+ ", provinceid=" + provinceid + ", cityid=" + cityid + ", pass=" + pass + ", del=" + del + ", content="
				+ content + ", smlogo=" + smlogo + ", tel=" + tel + "]";
	}
	
}
