package ppt12;

import javax.swing.*;
import java.awt.*;

public class GraphicsColorFontEx extends JFrame {
	Container contentPane;

	GraphicsColorFontEx() {
		setTitle("Color, Font 사용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.add(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				g.drawString("I Love Java.~~~", 30, 30);
				g.setColor(new Color(255, 0, 0));
				g.setFont(new Font("Arial", Font.ITALIC, 30));
				g.drawString("How much?", 30, 60);
				g.setColor(new Color(0x00ff00ff));
				for (int i = 0; i <= 5; i++) {
					g.setFont(new Font("Jokerman", Font.ITALIC, i * 10));
					g.drawString("This much!!", 30, 60 + i * 60);

				}
			}

		}, BorderLayout.CENTER);
		setSize(350, 450);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GraphicsColorFontEx();
	}

}
