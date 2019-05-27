package ppt10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseListenerAllEx extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel la;

	MouseListenerAllEx() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.addMouseListener(new MyMouseListener());
		contentPane.addMouseMotionListener(new MyMouseListener());
		la = new JLabel("No Mouse Event");
		contentPane.add(la);
		setSize(300, 200);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("mouseDragged(" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("mouseMoved(" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("MousePressed(" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("mouseReleased(" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JPanel p = (JPanel) e.getSource();
			p.setBackground(Color.CYAN);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JPanel p = (JPanel) e.getSource();
			p.setBackground(Color.YELLOW);
		}
		
	}

	public static void main(String[] args) {
		new MouseListenerAllEx();
	}

}
