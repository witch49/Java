package ppt10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ListenerMouseEx extends JFrame implements MouseListener {

	ListenerMouseEx() {
		setTitle("버튼에 Mouse 이벤트 리스너 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("Mouse event 테스트 버튼");
		btn.setBackground(Color.YELLOW);
		btn.addMouseListener(this);
		add(btn);
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListenerMouseEx();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(Color.BLUE);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// =hover
		JButton btn = (JButton) e.getSource();
		btn.setBackground(Color.RED);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// = hover 떼기
		JButton btn = (JButton) e.getSource();
		btn.setBackground(Color.YELLOW);
	}

}
