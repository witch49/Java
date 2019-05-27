package ppt11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboActionEx extends JFrame {
	Container contentPane;
	String[] fruits = { "apple", "pear", "cherry" };
	ImageIcon[] images = { new ImageIcon("images/apple.jpg"), new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")
	};
	JLabel imgLabel = new JLabel(images[0]);
	
	ComboActionEx() {
		setTitle("리스트 만들기 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JComboBox strCombo = new JComboBox(fruits);
		strCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
			}
		});
		contentPane.add(strCombo);
		contentPane.add(imgLabel);
		setSize(230, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboActionEx();
	}

}
