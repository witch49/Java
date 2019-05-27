package ppt11;

import javax.swing.*;
import java.awt.*;

public class RadioButtonEx extends JFrame {
	Container contentPane;

	RadioButtonEx() {
		setTitle("라디오버튼 만들기 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");

		// 버튼 그룹 객체 생성
		ButtonGroup btnGroup = new ButtonGroup();
		
		// 라디오버튼 컴포넌트 생성
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton pear = new JRadioButton("배", true);
		JRadioButton cherry = new JRadioButton("체리", cherryIcon);
		
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);
		
		// 라디오 버튼을 버튼 그룹에 삽입
		btnGroup.add(apple);
		btnGroup.add(pear);
		btnGroup.add(cherry);
		
		// 라디오 버튼을 컨테이너에 삽입
		contentPane.add(apple);
		contentPane.add(pear);
		contentPane.add(cherry);

		setSize(400, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RadioButtonEx();
	}

}
