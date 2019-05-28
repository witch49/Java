package ppt12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResizeImageFrame extends JFrame {

	public ResizeImageFrame() {
		super("그래픽 이미지 확대 축소 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new ResizeImagePanel());
		setSize(400, 400);
		setVisible(true);
		getContentPane().requestFocus();
	}

	class ResizeImagePanel extends JPanel {
		ImageIcon imageIcon = new ImageIcon("images/Yoshi.png");
		Image image = imageIcon.getImage();
		int width, height;

		public ResizeImagePanel() {
			width = image.getWidth(this);
			height = image.getHeight(this);
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == '+') {
						width = (int) (width * 1.1);
						height = (int) (height * 1.1);
						repaint();
					} else if (e.getKeyChar() == '-') {
						width = (int) (width * 0.9);
						height = (int) (height * 0.9);
						repaint();
					}
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 10, 10, width, height, this);
		}

	}

	public static void main(String[] args) {
		new ResizeImageFrame();
	}

}
