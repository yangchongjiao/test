package jsontest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UtilTest {

	public static void main(String[] args) {
		double d=0.6784;
		String str= String.format("%.2f",d);
		System.out.println(str);
		System.out.println("123122   1212313    ".trim());
		
		long a=82831647;
		System.out.println(a/1000/60);
		System.out.println(a/1000/60/60);
		System.out.println(a/1000/60/60/24);
		
		System.out.println(Arrays.asList("商户名称可爱多刘雷|结算日期2014-11-17".split("[|]")));
	}
	
	
}
