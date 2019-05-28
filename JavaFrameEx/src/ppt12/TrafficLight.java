package ppt12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficLight extends JFrame {

	public TrafficLight() {
		add(new MyTrafficLightPane());
		setSize(300, 550);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TrafficLight();
	}

}

class MyTrafficLightPane extends JPanel implements ActionListener {
	boolean flag = false;
	private int lightNo = 0;
	
	public MyTrafficLightPane() {
		setLayout(new BorderLayout());
		JButton btn = new JButton("traffic light turn on");
		btn.addActionListener(this);
		add(btn, BorderLayout.SOUTH);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 100, 100);
		g.drawOval(100, 200, 100, 100);
		g.drawOval(100, 300, 100, 100);
		if (lightNo == 0) {
			g.setColor(Color.RED);
			g.fillOval(100, 100, 100, 100);
		} else if (lightNo == 1) {
			g.setColor(Color.YELLOW);
			g.fillOval(100, 200, 100, 100);
		} else {
			g.setColor(Color.GREEN);
			g.fillOval(100, 300, 100, 100);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (++lightNo >= 3)
			lightNo = 0;
		repaint();
	}
}
