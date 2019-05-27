package ppt09;

import javax.swing.*;

public class FrameTest extends JFrame {
	
	public FrameTest() {
		setTitle("하이하이");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 끌 때 백그라운드에서도 삭제하기
		setSize(300, 500);
		setLocation(200, 300);
		setResizable(false);

		setVisible(true);
	}

	public static void main(String[] args) {
		new FrameTest();
	}

}
