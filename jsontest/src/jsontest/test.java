package jsontest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class test {

	
	public static void main(String[] args) {
		String path="/orderImg/201607/4a76169d2f354ec1babcf30835f547fa.jpg";
		String fullpath="http://106.38.36.134:8083/img/orderImg/201607/4848e419c2664ef48642c0fdcd1e6665.jpg";
		/*if (path!=null&&path.indexOf("orderImg")!=-1) {
			path=path.substring(path.indexOf("orderImg")+"orderImg/".length());
		}
		System.out.println(path);*/
		/*float moneyGrab = 50;
		moneyGrab = (float) (Math.round(moneyGrab * 100)) / 100;
		System.out.println(moneyGrab);
		System.out.println(Math.round(100.68));*/
		/*String a="automatic_validation";
		System.out.println(a.toUpperCase());
		System.out.println(24*60 * 60 * 1000);
		*/
		/*String test="320,";
		System.out.println(test.split(",").length);
		System.out.println(Arrays.asList(test.split(",")));*/
		//System.out.println(convertPrice(8820-0.6));
		System.out.println(convertPrice(-2.11*-1));
		
		System.out.println("bao_Post_Reply_List".toUpperCase());
		String str="M00000";
		System.out.println(str.substring(0,str.length()-"03".length())+"03");
		
		  Date date = new Date();
		  long time = date.getTime();
		  String dateline = time + "";
		  int time2= Integer.parseInt(dateline.substring(0, 10));
		System.out.println(time2);
		System.out.println("2016080321001004230246675685".length());
		System.out.println("201608060720063377".length());
		System.out.println("4000452001201608060720063377".substring(0, 19));
		String[] nums="*123".split("\\"+"*");
		System.out.println("+123".startsWith("+"));
		System.out.println(nums[0]);
		String label ="+";
		System.out.println("123".substring("123".length()-1));
	}
	
	/**
	 * 四舍五入保留小数点后两位
	 * @param price
	 * @return
	 */
	public static float convertPrice(double price) {
		
		return new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
	}
	public String urlutil(String path){
		if (path!=null&&path.indexOf("orderImg")!=-1) {
			path=path.substring(path.indexOf("orderImg")+"orderImg".length());
		}
		return path;
	}
	
	public  void jsontest(){
		
		List<MemberCardView> memberList = new ArrayList<MemberCardView>();
		MemberCardView card=new MemberCardView("1", "令狐飞雪","13120097615", "北京朝阳区三元桥","送餐能手,代买香烟,挑菜专家");
		MemberCardView card2=new MemberCardView("2", "令狐","13120097612", "北京朝阳区三元桥", "送餐能手,代买香烟,挑菜专家");
		NearUserSaidView usersaid=new NearUserSaidView("2", "令狐","0","/uploadfiles/58.png", "0.68", "今天3：30 三元桥谁来大排档？");
		memberList.add(card);
		memberList.add(card2);
		JSONArray json=JSONArray.fromObject(memberList);
		JSONObject jo=new JSONObject();
		JSONObject jo1=JSONObject.fromObject(usersaid);
		jo.put("date", jo1);
		jo.put("status",1);
		jo.put("info","ok");
		
		String jsonstr="{\"success\": false, \"msg\": \"copy(http://106.38.36.134:8081/img/orderImg/201607/1ca0d9991a914be7a31c257b76d3afa2.jpg): failed to open stream: HTTP request failed! HTTP/1.1 404 Not Found\\r\\n\"}";
		JSONObject jsons3=JSONObject.fromObject(jsonstr);
		System.out.println(jsons3.getString("success"));
		System.out.println(jsons3.get("msg"));
	}
}
