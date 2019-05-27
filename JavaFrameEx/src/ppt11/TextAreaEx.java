package ppt11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaEx extends JFrame {
	Container contentPane;

	TextAreaEx() {
		setTitle("텍스트 영역 만들기 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.add(new MyCenterPanel(), BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);

	}

	class MyCenterPanel extends JPanel {
		JTextField tf;
		JButton btn;
		JTextArea ta;

		MyCenterPanel() {
			tf = new JTextField(20);
			btn = new JButton("추가");
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 버튼이 선택되면 ta의 끝에 tf에 입력된 문자열을 추가함
					ta.append(tf.getText() + "\n");
				}
			});
			// 20 x 7 크기에 hello 문자열을 가진 JTextArea 컴포넌트 생성
			ta = new JTextArea("hello\n", 7, 20);
			add(new JLabel("아래 창에 문자열을 입력하고 버튼을 클릭하세요."));
			add(tf);
			add(btn);
			add(new JScrollPane(ta));
		}
	}

	public static void main(String[] args) {
		new TextAreaEx();
	}

}
