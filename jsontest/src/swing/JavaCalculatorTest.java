package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jsontest.test;

public class JavaCalculatorTest extends JFrame implements ActionListener {
	/**
	 * 发大   发的撒
	 */
	private static final long serialVersionUID = 1L;

	
	private class WindowCloser extends WindowAdapter{
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}
	
	int i;
	private final String[] str={"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-",  ".", "0", "=", "+", };
	 
	JButton[] buttons = new JButton[str.length];
	
	JButton reset = new JButton("CE");
	
	JTextField display = new JTextField("0");
	
	
	public  JavaCalculatorTest(){
		super("Calculator");
		JPanel panel1 = new JPanel(new GridLayout(4, 4));
		
		for (int i = 0; i < str.length; i++) {
			buttons[i] =  new JButton(str[i]);
			panel1.add(buttons[i]);
		}
		
		JPanel pannel2 = new JPanel(new BorderLayout());
		pannel2.add("Center",display);
		pannel2.add("East",reset);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("North", pannel2);
		getContentPane().add("Center", panel1);
		for (int i = 0; i < str.length; i++) {
			buttons[i].addActionListener(this);
		}
		display.addActionListener(this);
		reset.addActionListener(this);
		addWindowListener(new WindowCloser());
		//定义窗体的宽高
		int windowsWidth = 300;
		int windowsHeight = 200;
		setSize(windowsWidth, windowsHeight);
		//得到显示器屏幕的宽高
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		int xw = screen.width;
		int xh = screen.height;
		int w = (xw-windowsWidth)/2;
		int h = (xh-windowsHeight)/2;
		setLocation(w, h);
		
		
		setVisible(true);
		
	}
	
	
	String text="0";
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		String label = e.getActionCommand();
		if (((!text.contains(label)||text.lastIndexOf("-")==0)&&"+-*/=".contains(label))||!"+-*/=".contains(label)) {
			if (!"+-*/=.".contains(label)||(".".equals(label)&&textEndWithNum(text))) {
				text+=label;
			} else if("+-*/=".contains(label)) {
				if (text.contains("+")&&text.endsWith("+")) {
					text = text.substring(0, text.lastIndexOf("+"))+label;
				}
				else if(text.contains("-")&&text.endsWith("-")){
					text = text.substring(0, text.lastIndexOf("-"))+label;
				}
				else if(text.contains("*")&&text.endsWith("*")){
					text = text.substring(0, text.lastIndexOf("*"))+label;
				}
				else if(text.contains("/")&&text.endsWith("/")){
					text = text.substring(0, text.lastIndexOf("/"))+label;
				}
				else if(text.contains("=")&&text.endsWith("=")){
					text = text.substring(0, text.lastIndexOf("="))+label;
				}
				else  {
					text+=label;
				}
			}
		}
		if (target == reset) {
			text="";
			handleReset();
		} else if("0123456789.".contains(label)){
			
			handleNumber(label);
		} else {
			handleOperator(label);
		}
		System.out.println(text);
	}
	
	boolean isFirstDigit = true;
	public boolean textEndWithNum(String text){
		if ("0123456789".contains(text.substring(text.length()-1))&&!text.contains(".")) {
			return true;
		} else {
			return false;
		}
		
	}
	public boolean hasOperator(String text){
		if (text.contains("+")||text.contains("-")||text.contains("*")||text.contains("/")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public int handleNumber(String key){
		if (isFirstDigit) {
			display.setText(key);
			if (!".".equals(key)) {
				number = Double.valueOf(key);
			}else {
				number = 0;
			}
		} else if(key.equals(".") && display.getText().indexOf(".")<0&&textEndWithNum(text)){
			
			number = Double.valueOf(display.getText());
			display.setText(display.getText()+".");
		} else if(!key.equals(".")) {
			number = Double.valueOf(display.getText()+key);
			display.setText(display.getText()+key);
		}
		isFirstDigit = false;
		return 1;
	}
	
	public int handleReset(){
		display.setText("0"); 
		isFirstDigit = true;
		operator = "=";
		return 1;
	}
	
	double number = 0.0;
	String operator = "=";
	public int handleRsulte(String key){
			String[] numbs=text.split("\\"+key);
			if (text.contains(key)&&!text.endsWith(key)&&!text.startsWith(key)) {
				if ("+".equals(key)) {
					number =Double.valueOf(numbs[0])+Double.valueOf(numbs[1]);
				} 
				else if ("-".equals(key))  {
					number =Double.valueOf(numbs[0])-Double.valueOf(numbs[1]);
				}
				else if ("*".equals(key))  {
					number =Double.valueOf(numbs[0])*Double.valueOf(numbs[1]);
				}
				else if ("/".equals(key))  {
					number =Double.valueOf(numbs[0])/Double.valueOf(numbs[1]);
				}
				else if ("=".equals(key))  {
					number =Double.valueOf(numbs[1]);
				}
				text=String.valueOf(number)+key;
			} else if(text.contains(key)&&!text.endsWith(key)&&text.startsWith(key)&&text.lastIndexOf(key)==0){
				if (text.contains("-")) {
					number =Double.valueOf(text);
				}else {
					number =Double.valueOf(text.substring(1));
				} 
				text=String.valueOf(number)+key;
			} else if(!text.endsWith(key)&&text.startsWith("-")&&hasOperator(text.substring(1))){
			   String text1=text.substring(1);
				
				if (text1.contains("+")) {
					String[] numbs1=text1.split("\\+");
					if (numbs1.length>1) {
						number =Double.valueOf("-"+numbs1[0])+Double.valueOf(numbs1[1]);
					} else {
						number =Double.valueOf("-"+numbs1[0]);
					}
				}
				if (text1.contains("-")) {
					String[] numbs1=text1.split("\\-");
					if (numbs1.length>1) {
						number =Double.valueOf("-"+numbs1[0])-Double.valueOf(numbs1[1]);
					} else {
						number =Double.valueOf("-"+numbs1[0]);
					}
				}
				if (text1.contains("*")) {
					String[] numbs1=text1.split("\\-");
					if (numbs1.length>1) {
						number =Double.valueOf("-"+numbs1[0])*Double.valueOf(numbs1[1]);
					} else {
						number =Double.valueOf("-"+numbs1[0]);
					}
				}
				if (text1.contains("/")) {
					String[] numbs1=text1.split("\\-");
					if (numbs1.length>1) {
						number =Double.valueOf("-"+numbs1[0])/Double.valueOf(numbs1[1]);
					} else {
						number =Double.valueOf("-"+numbs1[0]);
					}
				}
				
				
				text=String.valueOf(number)+key;
			} else if(text.contains(key)&&text.endsWith(key)&&text.startsWith(key)&&text.length()>2&&key.contains("-")){
				number =Double.valueOf(text.substring(0,text.lastIndexOf("-")));
				text=String.valueOf(number)+key;
			} else if(text.contains(key)&&text.endsWith(key)&&text.startsWith(key)&&text.length()==1){
				number =0;
				text=key;
			} else if(text.contains(key)&&text.endsWith(key)&&!text.startsWith(key)&&"=".equals(key)&&(text.contains("+")||(text.contains("-")&&text.lastIndexOf("-")>0)||text.contains("*")||text.contains("/"))){
				
				if (text.contains("+")) {
					String[] numbs1=text.substring(0, text.indexOf("=")).split("\\+");
					if (numbs1.length>1) {
						number =Double.valueOf(numbs1[0])+Double.valueOf(numbs1[1]);
					} else {
						number =Double.valueOf(numbs1[0]);
					}
					
				} 
				else if (text.contains("-"))  {
					String text1=text;
					if (text.startsWith("-")) {
						text1=text.substring(1);
						if (text1.contains("-")) {
							String[] numbs1=text1.substring(0, text1.indexOf("=")).split("\\-");
							if (numbs1.length>1) {
								number =Double.valueOf("-"+numbs1[0])-Double.valueOf(numbs1[1]);
							} else {
								number =Double.valueOf("-"+numbs1[0]);
							}
						} 
						else if (text1.contains("+")){
							String[] numbs1=text1.substring(0, text1.indexOf("=")).split("\\+");
							if (numbs1.length>1) {
								number =Double.valueOf("-"+numbs1[0])+Double.valueOf(numbs1[1]);
							} else {
								number =Double.valueOf("-"+numbs1[0]);
							}
						}
						else if (text1.contains("*")){
							String[] numbs1=text1.substring(0, text1.indexOf("=")).split("\\*");
							if (numbs1.length>1) {
								number =Double.valueOf("-"+numbs1[0])*Double.valueOf(numbs1[1]);
							} else {
								number =Double.valueOf("-"+numbs1[0]);
							}
						}
						else if (text1.contains("/")){
							String[] numbs1=text1.substring(0, text1.indexOf("=")).split("\\/");
							if (numbs1.length>1) {
								if (Double.valueOf(numbs1[1])==0) {
									number =Double.valueOf("-"+numbs1[0])/Double.valueOf(numbs1[1]);
								} else {

									number =Double.valueOf("-"+numbs1[0])/Double.valueOf(numbs1[1]);
								}
							} else {
								number =Double.valueOf("-"+numbs1[0]);
							}
						}
					}else {
						String[] numbs1=text.substring(0, text.indexOf("=")).split("\\-");
						if (numbs1.length>1) {
							number =Double.valueOf(numbs1[0])-Double.valueOf(numbs1[1]);
						} else {
							number =Double.valueOf(numbs1[0]);
						}
					}
					
				}
				else if (text.contains("*"))  {
					String[] numbs1=text.substring(0, text.indexOf("=")).split("\\*");
					if (numbs1.length>1) {
						number =Double.valueOf(numbs1[0])*Double.valueOf(numbs1[1]);
					} else {
						number =Double.valueOf(numbs1[0]);
					}
				}
				else if (text.contains("/"))  {
					String[] numbs1=text.substring(0, text.indexOf("=")).split("\\/");
					if (numbs1.length>1) {
						if (Double.valueOf(numbs1[1])==0) {
							number =Double.valueOf(numbs1[0]);
						}else {
							number =Double.valueOf(numbs1[0])/Double.valueOf(numbs1[1]);
						}
					} else {
						number =Double.valueOf(numbs1[0]);
					}
				}
				text=String.valueOf(number)+key;
			} else if(text.contains(key)&&text.endsWith(key)&&!text.startsWith(key)&&!"=".equals(key)&&text.contains("=")){
				
					String[] numbs1=text.substring(0, text.indexOf(key)).split("\\=");
					if (numbs1.length>1) {
						number =Double.valueOf(numbs1[1]);
					} else {
						number =Double.valueOf(numbs1[0]);
					}
				
					text=String.valueOf(number)+key;
			}
			else if(text.contains(key)&&text.endsWith(key)&&!text.startsWith(key)&&"=".equals(key)){
				
				String[] numbs1=text.substring(0, text.indexOf(key)).split("\\=");
				if (numbs1.length>1) {
					number =Double.valueOf(numbs1[1]);
				} else {
					number =Double.valueOf(numbs1[0]);
				}
			
				text=String.valueOf(number)+key;
			}
			
			return 1;
	}
	
	public int handleOperator(String key){
		operator = key;
		if (display.getText().endsWith(".")) {
			display.setText(display.getText()+"0");
		} 
		double dkey = Double.valueOf(display.getText());
		if (operator.equals("+")) {
			handleRsulte(operator);
		} else if(operator.equals("-")) {
			//number +=dkey;
			handleRsulte(operator);
		} else if(operator.equals("*")){
			//number *=dkey;
			handleRsulte(operator);
		} else if(operator.equals("/")){
			//number /=dkey;
			handleRsulte(operator);
		} else if(operator.equals("=")){
			//number = dkey;
			handleRsulte(operator);
		}
		
		if(number%1.0 == 0){
			display.setText(String.valueOf((int)number));
		}else {
			display.setText(String.valueOf(number));
		}
		isFirstDigit = true;
		return 1;
	}
	
	public static void main(String[] args){
		
		new JavaCalculatorTest();
	}
}
