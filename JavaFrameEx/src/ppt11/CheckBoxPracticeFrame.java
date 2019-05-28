package ppt11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxPracticeFrame extends JFrame {
	Container contentPane;

	CheckBoxPracticeFrame() {
		setTitle("CheckBox Practice Frame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		JCheckBox inactiveBtn = new JCheckBox("버튼 비활성화");
		JCheckBox hideBtn = new JCheckBox("버튼 감추기");
		JButton btn = new JButton("test button");

		inactiveBtn.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					btn.setEnabled(false);
				else
					btn.setEnabled(true);
			}
		});
		hideBtn.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					btn.setVisible(false);
				else
					btn.setVisible(true);
			}
		});

		contentPane.add(inactiveBtn);
		contentPane.add(hideBtn);
		contentPane.add(btn);

		setSize(250, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new CheckBoxPracticeFrame();
	}

}
