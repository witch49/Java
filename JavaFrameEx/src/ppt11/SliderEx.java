package ppt11;

import javax.swing.*;
import java.awt.*;

public class SliderEx extends JFrame {
	Container contentPane;
	
	SliderEx() {
		setTitle("슬라이더 만들기 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
		slider.setPaintLabels(true); // 숫자 표시
		slider.setPaintTicks(true); // 눈금 표시
		//slider.setPaintTrack(false);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		
		contentPane.add(slider);
		setSize(300, 100);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new SliderEx();
	}

}
