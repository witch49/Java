package ppt10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ListenerSample extends JFrame {

	ListenerSample() {
		setTitle("Action event listener 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("Action");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("Action"))
					b.setText("액션");
				else
					b.setText("Action");
			}

		});
		add(btn);
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListenerSample();
	}

}
