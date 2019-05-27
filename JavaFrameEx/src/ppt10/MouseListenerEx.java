package ppt10;

import javax.swing.*;
import java.awt.event.*;

public class MouseListenerEx extends JFrame {
	JLabel la;
	
	MouseListenerEx() {
		setTitle("Mouse event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		setLayout(null);
		contentPane.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				la.setLocation(x, y);
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		la = new JLabel("hello");
		la.setSize(50, 20);
		la.setLocation(30, 30);
		contentPane.add(la);
		
		setSize(200, 200);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new MouseListenerEx();
	}

}
