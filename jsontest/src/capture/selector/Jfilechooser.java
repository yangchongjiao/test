
package capture.selector;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Jfilechooser extends JFrame implements ActionListener {
	// ===================================================
	JButton button;
	JTextArea text;
	JTextPane textpane;
	FileInputStream readfile;
	JScrollPane scroll;
	Container con;
	JFileChooser chooser = new JFileChooser();

	// ==========================================
	public Jfilechooser() {
		super("有文件选择器的窗口");
		button = new JButton("打开文件选择器");
		button.addActionListener(this);
		textpane = new JTextPane();
		scroll = new JScrollPane(textpane);
		setSize(new Dimension(400, 400));
		setVisible(true);
		con = getContentPane();
		con.add(button, BorderLayout.NORTH);
		con.add(scroll, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	// ====================================================
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
	// ======================================================
}
