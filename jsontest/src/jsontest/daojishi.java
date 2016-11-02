package jsontest;

public class daojishi {

	public static void main(String[] args) {
		new daojishi().getTime();
		
	}
	private void getTime() {
        long time = 1 * 36000; // 自定义倒计时时间
        long hour = 0;
        long minute = 0;
        long seconds = 0;
 
        while (time >= 0) {
            hour = time / 3600;
            minute = (time - hour * 3600) / 60;
            seconds = time - hour * 3600 - minute * 60;
            /*jl1.setText(hour + "时");
            jl2.setText(minute + "分");
            jl3.setText(seconds + "秒");*/
            System.out.println(hour + "时"+minute + "分"+seconds + "秒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time--;
        }
 
    }
 
}
