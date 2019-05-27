package ppt09;

import javax.swing.*;

public class Temp {
	public static void main(String[] args) {
		// same as
		// JFrame jf = new JFrame("하이하이");
		JFrame jf = new JFrame();
		jf.setTitle("하이하이");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 창 끌 때 백그라운드에서도 삭제하기
		jf.setSize(300, 500);
		jf.setLocation(200, 300);
		jf.setResizable(false);
		
		jf.setVisible(true);

	}
}
