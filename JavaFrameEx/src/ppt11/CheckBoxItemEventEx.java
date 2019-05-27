package ppt11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxItemEventEx extends JFrame {
	Container contentPane;
	JCheckBox[] fruits = new JCheckBox[3];
	String[] names = { "사과", "배", "체리" };
	JLabel sumLabel;
	int sum = 0;

	CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("사과 1000원, 배 1500원, 체리 3000원"));

		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			contentPane.add(fruits[i]);
			fruits[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					int selected = 1;
					if (e.getStateChange() == ItemEvent.SELECTED)
						selected = 1;
					else
						selected = -1;

					if (e.getItem() == fruits[0])
						sum += selected * 1000;
					else if (e.getItem() == fruits[1])
						sum += selected * 1500;
					else
						sum += selected * 3000;

					sumLabel.setText("현재 " + sum + "원 입니다.");
				}
			});
		}
		sumLabel = new JLabel("현재 0원입니다.");
		contentPane.add(sumLabel);
		setSize(250, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new CheckBoxItemEventEx();
	}

}
