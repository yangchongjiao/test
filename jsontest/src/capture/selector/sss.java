package capture.selector;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class sss extends JFrame implements ActionListener {
	// ===================================================
	JButton button;
	JTextArea text;
	JTextPane textpane;
	FileInputStream readfile;
	JScrollPane scroll;
	JFileChooser chooser = new JFileChooser();
	JPanel con;

	// ==========================================
	public sss() {
		super("有文件选择器的窗口");
		button = new JButton("打开文件选择器");
		button.addActionListener(this);
		textpane = new JTextPane();
		scroll = new JScrollPane(textpane);
		// setSize( new Dimension(400,400));
		// setVisible(true);
		con = (JPanel) this.getContentPane();
		con.add(button, BorderLayout.NORTH);
		con.add(scroll, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	// ===============================================
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			String s;
			int state = chooser.showOpenDialog(null);
			File file = chooser.getSelectedFile();
			if (file != null && state == JFileChooser.APPROVE_OPTION) {
				try {
					readfile = new FileInputStream(file);
					textpane.read(readfile, this);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	// ====================================
}
