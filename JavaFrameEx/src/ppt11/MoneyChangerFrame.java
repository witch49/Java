package ppt11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MoneyChangerFrame extends JFrame {
	Container contentPane;
	
	MoneyChangerFrame() {
		setTitle("Money Changer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		// 환산할 금액
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		// 환산할 금액의 이름. JLabel로 출력
		String[] text = {"오만원", "만원", "오천원", "천원", "오백원", "백원", "오십원", "십원", "오원", "일원"};
		// 사용자로부터 금액이 입력될 JTextField
		JTextField source;
		// 환산된 금액의 개수가 출력될 JTextField
		JTextField[] tf = new JTextField[10];
		
		MyPanel() {
			setBackground(Color.PINK);
			setLayout(null);
			
			// 금액 JLabel
			JLabel la = new JLabel("금액");
			la.setHorizontalAlignment(JLabel.RIGHT);
			la.setSize(50, 20);
			la.setLocation(20, 20);
			add(la);
			
			// 금액을 입력하는 JTextField
			source = new JTextField(30);
			source.setSize(100, 20);
			source.setLocation(100, 20);
			add(source);
			
			// 계산 버튼
			JButton calcBtn = new JButton("계산");
			calcBtn.setSize(20, 20);
			calcBtn.setLocation(210, 20);
			add(calcBtn);

			// 계산된 액수별 돈의 개수
			for (int i = 0; i < text.length; i++) {
				la = new JLabel(text[i]);
				la.setHorizontalAlignment(JLabel.RIGHT);
				la.setSize(50, 20);
				la.setLocation(50, 50 + i * 20);
				add(la);
				tf[i] = new JTextField(30);
				tf[i].setHorizontalAlignment(JTextField.CENTER);
				tf[i].setSize(70, 20);
				tf[i].setLocation(120, 50 + i * 20);
				add(tf[i]);
			}
			
			calcBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String str = source.getText();
					if (str.length() == 0)
						return;
					int money = Integer.parseInt(str);
					int res;
					for (int i = 0; i < unit.length; i++) {
						res = money / unit[i]; // unit[i]의 개수 계산
						tf[i].setText(Integer.toString(res));
						if (res > 0)
							money = money % unit[i]; // money 갱신
					}
				}
			});

		}
	}
	
	public static void main(String[] args) {
		new MoneyChangerFrame();
	}

}
