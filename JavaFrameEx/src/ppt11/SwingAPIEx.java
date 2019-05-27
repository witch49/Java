package ppt11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SwingAPIEx extends JFrame{
	Container contentPane;
	JLabel la;
	JButton btn1, btn2, btn3, btn4;
	
	SwingAPIEx() {
		setTitle("Swing 공통 메소드 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		btn1 = new JButton("위치와 크기 정보");
		btn1.addActionListener(new MyButtonListener());
		contentPane.add(btn1);
		
		btn2 = new JButton("모양 정보");
		btn2.setOpaque(true);
		btn2.setForeground(Color.MAGENTA);
		btn2.setBackground(Color.YELLOW);
		btn2.setFont(new Font("고딕체", Font.ITALIC, 20));
		btn2.addActionListener(new MyButtonListener());
		contentPane.add(btn2);
		
		btn3 = new JButton("작동하지 않는 버튼");
		btn3.setEnabled(false);
		btn3.addActionListener(new MyButtonListener());
		contentPane.add(btn3);
		
		btn4 = new JButton("숨기기");
		btn4.addActionListener(new MyButtonListener());
		contentPane.add(btn4);
		
		setSize(250, 200);
		setVisible(true);
		
	}
	
	class MyButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == btn1) {
				System.out.println("버튼의 위치와 크기");
				System.out.println("위치 : (" + btn1.getX() + ", " + btn1.getY() + ")");
				System.out.println("크기 : (" + btn1.getWidth() + " x " + btn1.getHeight() + ")");
				JPanel c = (JPanel) btn2.getParent();
				System.out.println("컨텐트팬의 위치와 크기");
				System.out.println("위치 : (" + c.getX() + ", " + c.getY() + ")");
				System.out.println("크기 : (" + c.getWidth() + " x " + c.getHeight() + ")");
			} else if (source == btn2) {
				System.out.println("폰트 : " + btn2.getFont());
				System.out.println("배경색 : " + btn2.getBackground());
				System.out.println("글자색 : " + btn2.getForeground());
			} else {
				if(btn1.isVisible()) {
					btn4.setText("보이기");
					btn1.setVisible(false);
					btn2.setVisible(false);
					btn3.setVisible(false);
				} else {
					btn4.setText("숨기기");
					btn1.setVisible(true);
					btn2.setVisible(true);
					btn3.setVisible(true);
				}
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		new SwingAPIEx();
	}

}
