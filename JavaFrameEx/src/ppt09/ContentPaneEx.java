package ppt09;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
	ContentPaneEx() {
		setTitle("ContentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane(); // 버튼을 여러개 추가하기 위해서 필요
//		contentPane.setBackground(Color.ORANGE);
		
		// FlowLayout()
//		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
//		contentPane.add(new JButton("add"));
//		contentPane.add(new JButton("sub"));
//		contentPane.add(new JButton("mul"));
//		contentPane.add(new JButton("div"));
//		contentPane.add(new JButton("Calculate"));
		
		// BorderLayout()
//		setLayout(new BorderLayout());
//		contentPane.add(new JButton("add"), BorderLayout.NORTH);
//		contentPane.add(new JButton("sub"), BorderLayout.SOUTH);
//		contentPane.add(new JButton("mul"), BorderLayout.EAST);
//		contentPane.add(new JButton("div"), BorderLayout.WEST);
//		contentPane.add(new JButton("Calculate"), BorderLayout.CENTER);
		
		// GridLayout()
//		GridLayout grid = new GridLayout(4, 2);
//		grid.setVgap(5);	// 두 행의 수직 간격(vGap) :  5px
//		contentPane.setLayout(grid);
//		contentPane.add(new JLabel("이름"));
//		contentPane.add(new JTextField(""));
//		contentPane.add(new JLabel("학번"));
//		contentPane.add(new JTextField(""));
//		contentPane.add(new JLabel("학과"));
//		contentPane.add(new JTextField(""));
//		contentPane.add(new JLabel("과목"));
//		contentPane.add(new JTextField(""));
		
		// 배치관리자 없는 컨테이너
		setLayout(null);
		JLabel la = new JLabel("Hello!");
		la.setLocation(130, 50);
		la.setSize(200, 20);
		contentPane.add(la);
		for(int i=1; i<=9; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i*15, i*15);
			b.setSize(50, 20);
			contentPane.add(b);
		}
		for(int i=10; i<18; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i*15, (18-i)*15);
			b.setSize(50, 20);
			contentPane.add(b);
		}
		
		setSize(350, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ContentPaneEx();
	}
}
