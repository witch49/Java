package ppt12;

import java.awt.*;
import javax.swing.*;

public class GraphicsDrawImageEx1 extends JFrame {
	Container contentPane;
	
	GraphicsDrawImageEx1() {
		setTitle("drawImage 사용 예제 1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.add(new JPanel() {
			ImageIcon imageIcon = new ImageIcon("images/Yoshi.png");
			Image image = imageIcon.getImage();
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				/* 1. 원래 크기로 이미지 그리기 */
				//g.drawImage(image, 20, 20, this);
				
				/* 2. JPanel 크기로 이미지 그리기 */
				//g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this); 
				// 크기 조정될 때마다 paintComponent() 메소드가 계속 호출됨.
				//System.out.println("test");
				
				/* 3. 이미지의 일부분을 크기 조절하여 그리기 */
				// g.drawImage(image, 30, 30, 200, 200, 30, 30, 150, 150, this);
				
				/* 4. 클리핑 예제 */
				g.setClip(30, 30, 100, 100);
				g.drawImage(image, getWidth(), getHeight(), this);
				g.setColor(Color.BLUE);
				g.setFont(new Font("SanSerif", Font.ITALIC, 20));
				g.drawString("Go Yoshi!", 10, 150);
				
				
			}
		}, BorderLayout.CENTER);
		setSize(310, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GraphicsDrawImageEx1();
	}

}
