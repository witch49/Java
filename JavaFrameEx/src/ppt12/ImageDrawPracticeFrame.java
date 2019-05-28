package ppt12;

import java.awt.*;
import javax.swing.*;

public class ImageDrawPracticeFrame extends JFrame {
	Container contentPane;

	public ImageDrawPracticeFrame() {
		super("이미지 그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new ImageDrawPanel());
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ImageDrawPracticeFrame();
	}

	class ImageDrawPanel extends JPanel {
		ImageIcon imageIcon = new ImageIcon("images/Yoshi.png");
		Image image = imageIcon.getImage();

		public ImageDrawPanel() {
			setLayout(new FlowLayout());
			add(new JButton("Hello"));
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

}
