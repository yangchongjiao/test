package swing;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.management.OperatingSystemMXBean;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JavaCalculator extends JFrame implements ActionListener {

	
	/**
	 * 
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
	
	private final String[] str = {"7","8","9","/","4","5","6","*","1","2","3","-",".","0","=","+"};
	
	JButton[] buttons = new JButton[str.length];
	
	JButton reset = new JButton("CE");
	
	JTextField display = new JTextField("0");
	
	
	
	public JavaCalculator() {
		super("Calculator");
		//Add a panel
		JPanel panel1 = new JPanel(new GridLayout(4,4));
		
		for (int i = 0; i < str.length; i++) {
			buttons[i] = new JButton(str[i]);
			panel1.add(buttons[i]);
		}
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add("Center",display);
		panel2.add("East",reset);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("North", panel2);
		getContentPane().add("Center", panel1);
		for (int i = 0; i < str.length; i++) {
			buttons[i].addActionListener(this);
			display.addActionListener(this);
			reset.addActionListener(this);
		}
		addWindowListener(new WindowCloser());
		 // 定义窗体的宽高
	    int windowsWedth = 300;
	    int windowsHeight = 200;
		setSize(300,200);
		setVisible(true);
		// 得到显示器屏幕的宽高
	    int xw = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int yh = Toolkit.getDefaultToolkit().getScreenSize().height;
	    int w = (xw - windowsWedth) / 2;
	    int h = (yh - windowsHeight) / 2;
	    setLocation(w, h);
		
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		String label = e.getActionCommand();
		if (target == reset) {
			handleReset();
		} else if("0123456789.".indexOf(label)>0) {
			handleNumber(label);
		} else {
			
			handleOperator(label);
		}
	}

	boolean isFirstDigit  = true;
	
	public void handleNumber(String key){
		if (isFirstDigit) {
			display.setText(key);
		} else if((key.equals(".")) && (display.getText().indexOf(".")<0)) {
			display.setText(display.getText()+".");
		} else if(!key.equals(".")){
			display.setText(display.getText() + key);
		}
		isFirstDigit = false;
	}
	
	public void handleReset(){
		display.setText("0");
		isFirstDigit = true;
		operator = "=";
		
	}
	
	double number = 0.0;
	String operator = "=";

	public void handleOperator(String key){
		if(display.getText().endsWith(".")){
			display.setText(display.getText()+"0");
		}
		if (operator.equals("+")) {
			number += Double.valueOf(display.getText());
		} else if(operator.equals("-")) {
			number -= Double.valueOf(display.getText());
		} else if(operator.equals("*")){
			number *= Double.valueOf(display.getText());
		} else if(operator.equals("/")){
			number /= Double.valueOf(display.getText());
		} else if(operator.equals("=")){
			number = Double.valueOf(display.getText());
		}
		if (number%1.0 ==0) {
			display.setText(String.valueOf((int)number));
			
		}else {
			display.setText(String.valueOf(number));
		}
		operator = key;
		isFirstDigit = true;
	}
	public static void main(String[] args){
		new JavaCalculator();
		
	}
}
