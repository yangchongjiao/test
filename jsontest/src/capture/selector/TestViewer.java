package capture.selector;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TestViewer extends JFrame implements ActionListener{
	
	private static JTextArea text;
	private JScrollPane pane;
	private JButton button;
	private static String defautLocal="";
	
	public TestViewer(){
		super("TextViewer");
		text=new JTextArea();
		text.setEditable(false);
		text.setLineWrap(true);
		pane=new JScrollPane(text);
		getContentPane().add(pane,BorderLayout.CENTER);
		button=new JButton("打开文件");
        getContentPane().add(button,BorderLayout.NORTH);
		button.addActionListener(this);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button){
			JFileChooser fc=new JFileChooser();
			//使用指定目录
			if (defautLocal!=null&&!"".equals(defautLocal)) {
				fc.setCurrentDirectory(new File(defautLocal));
				
			} else {

				fc.setCurrentDirectory(new File("E:/"));
			}
			//fc.showOpenDialog(null);
			char ch[]=new char[1024];
			String str="",s="";
			fc.showOpenDialog(this);
			/*try{
				FileReader fr=new FileReader(fc.getSelectedFile());
				while(fr.read(ch)!=-1){
					s=new String(ch);
					str=str+s;
				}
				text.setText(str);
				System.out.println(str);
				fr.close();
			}catch(IOException ie){
				JOptionPane.showMessageDialog(this,"I/O Error","error",JOptionPane.ERROR_MESSAGE);
			}*/
			
			File f=fc.getSelectedFile();
			
			this.readFileByLines(f);
		}else{
			System.exit(0);
		}
	}
	/**
	   * 以行为单位读取文件，常用于读面向行的格式化文件
	   */
	  public static void readFileByLines(File file) {
	    //File file = new File(file);
	    BufferedReader reader = null;
	    try {
	      System.out.println("以行为单位读取文件内容，一次读一整行：");
	      if (file==null) {
			System.out.println("getfile is："+file);
			return;
		}
	      defautLocal=file.getPath();
	      reader = new BufferedReader(new FileReader(file));
	      String tempString = null;
	      int line = 1;
	      // 一次读入一行，直到读入null为文件结束
	      FileWriter fw = null;
	        try {
	            fw = new FileWriter("d://test.txt",true);
	            
	        } catch (IOException e1) {
	            e1.printStackTrace();
	            System.out.println("写入失败");
	            System.exit(-1);
	        }
	      text.setText("");
	      while ((tempString = reader.readLine()) != null) {
	        // 显示行号
	    	if (tempString.contains("time(ms)>")) {
				
	    		//System.out.println("line " + line + ": " + tempString);
	    		String str = tempString.substring(tempString.indexOf("action="));
	    		text.setText(text.getText()+str+"\n");
	    		System.out.println( str);
	    		String c = str+"\r\n";
	    		 fw.write(c);
			}
	        line++;
	      }
	      reader.close();
	     
          fw.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      if (reader != null) {
	        try {
	          reader.close();
	        } catch (IOException e1) {
	        }
	      }
	    }
	  }
	
	 
	public static void main(String args[]){
		String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		TestViewer tv=new TestViewer();
	}
}
