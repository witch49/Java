package ppt11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonItemEventEx extends JFrame {
	Container contentPane;
	JRadioButton[] radioBtn = new JRadioButton[3];
	String[] text = {"사과", "배", "체리"};
	ImageIcon[] image = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")
	};
	JLabel imageLabel = new JLabel();

	
	RadioButtonItemEventEx() {
		setTitle("라디오버튼 Item Event 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);

		ButtonGroup btnGroup = new ButtonGroup();
		for (int i = 0; i < radioBtn.length; i++) {
			radioBtn[i] = new JRadioButton(text[i]);
			btnGroup.add(radioBtn[i]);
			panel.add(radioBtn[i]);
			radioBtn[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.DESELECTED)
						return;
					if(radioBtn[0].isSelected())
						imageLabel.setIcon(image[0]);
					else if(radioBtn[1].isSelected())
						imageLabel.setIcon(image[1]);
					else
						imageLabel.setIcon(image[2]);
				}
			});
		}
		//setSelected(true) 호출로 인해 item 이벤트가 발생하며 해당하는 이미지가 출력됨
		radioBtn[2].setSelected(true);
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

		setSize(300, 250);
		setVisible(true);

	}

	public static void main(String[] args) {
		new RadioButtonItemEventEx();
	}

}
