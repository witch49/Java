package ppt11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ButtonImageEx extends JFrame {
	Container contentPane;
	
	ButtonImageEx() {
		setTitle("버튼에 아이콘 달기 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.png");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.png");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.jpg");
		
		JButton btn = new JButton("call~~", normalIcon);
		btn.setRolloverIcon(rolloverIcon);
		btn.setPressedIcon(pressedIcon);
		contentPane.add(btn);
		
		setSize(250, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ButtonImageEx();
	}

}
