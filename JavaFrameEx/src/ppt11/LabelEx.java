package ppt11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LabelEx extends JFrame {
	Container contentPane;
	
	LabelEx() {
		setTitle("레이블 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JLabel textLabel = new JLabel("사랑합니다.");
		ImageIcon heart = new ImageIcon("images/heart.jpg");
		JLabel imageLabel = new JLabel(heart);
		
		ImageIcon tel = new ImageIcon("images/tel.png");
		JLabel label = new JLabel("보고싶으면 전화하세요", tel, SwingConstants.CENTER);
		contentPane.add(textLabel);
		contentPane.add(imageLabel);
		contentPane.add(label);
		
		setSize(550, 650);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new LabelEx();
	}

}
