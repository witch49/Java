package ppt12;

import javax.swing.*;
import java.awt.*;

public class PaintJPanelEx extends JFrame {
	Container contentPane;
	
	PaintJPanelEx() {
		setTitle("JPanel PaintComponent 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.add(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				g.drawRect(10, 10, 50, 50);
				g.drawRect(50, 50, 50, 50);
				g.drawRect(90, 90, 50, 50);
			}
		}, BorderLayout.CENTER);
		setSize(250, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PaintJPanelEx();
	}

}
