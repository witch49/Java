package ppt12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsAndMouseDraggingFrame extends JFrame {

	public GraphicsAndMouseDraggingFrame() {
		super("이미지 그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GraphicsPanel());
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GraphicsAndMouseDraggingFrame();
	}

	class GraphicsPanel extends JPanel {
		ImageIcon imageIcon = new ImageIcon("images/Yoshi.png");
		Image image = imageIcon.getImage();
		int ovalX = 100, ovalY = 100;

		public GraphicsPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					ovalX = e.getX();
					ovalY = e.getY();
					repaint();
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(Color.YELLOW);
			g.fillOval(ovalX, ovalY, 20, 20);
		}

	}

}
