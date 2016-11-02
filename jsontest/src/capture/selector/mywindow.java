package capture.selector;

import java.awt.Dimension;
import java.awt.Toolkit;

public class mywindow {
	public static void main(String args[]) {
		Jfilechooser win = new Jfilechooser();
		win.setSize(new Dimension(400, 400));
		//win.pack();
		win.validate();
		win.show();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = win.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		win.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}
}
