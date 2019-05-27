package ppt11;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderChangeEx extends JFrame {
	Container contentPane;
	JLabel colorLabel;
	JSlider[] sl = new JSlider[3];

	SliderChangeEx() {
		setTitle("슬라이더와 ChangeEvent 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		colorLabel = new JLabel(" <<  SLIDER EXAMPLE  >> ");
		for (int i = 0; i < sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					colorLabel.setBackground(new Color(sl[0].getValue(), sl[1].getValue(), sl[2].getValue()));
				}
			});
			contentPane.add(sl[i]);
		}
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.GREEN);
		sl[2].setForeground(Color.BLUE);
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(sl[0].getValue(), sl[1].getValue(), sl[2].getValue()));
		contentPane.add(colorLabel);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SliderChangeEx();
	}

}
