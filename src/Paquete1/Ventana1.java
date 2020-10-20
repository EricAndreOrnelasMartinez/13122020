package Paquete1;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class Ventana1 extends JFrame{
	ImageIcon fondo = new ImageIcon("fondo.jpg");
	JPanel panel;
	JLabel label;
	VentanaHash vh;
	JFrame fr;
	Timer timer;
	public Ventana1 () {
		fr = this;
		timer = new Timer();
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		this.add(panel);
		label = new JLabel("Aura");
		label.setBounds(150, 170, 200, 80);//x = 150 y = 170
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 80 ));
		panel.add(label);
		TimerTask time = new TimerTask() {
			int f = 0;
			@Override
			public void run() {
				//System.out.println("Runing");
				if(f == 0) {
					f = 1;
				}else if(f == 1) {
					label.setText("aura");
					f = 2;
				}else if(f == 2) {
					label.setLocation(215, 170);
					label.setText("=");
					f = 3;
				}else if(f == 3) {
					label.setLocation(165, 170);
					label.setText("new");
					f = 4;
				}else if(f == 4) {
					label.setBounds(140, 170, 3000, 80);
					label.setText("Aura();");
					f = 5;
				}else if(f == 5) {
					label.setLocation(20, 170);
					label.setFont(new Font("Arial", Font.ITALIC, 50 ));
					label.setText("Happy birthday!!!");
					f = 6;
				}else if(f == 6) {
					vh = new VentanaHash();
					vh.setVisible(true);
					f = 7;
					fr.setVisible(false);
				}
				
			}
			
		};
		timer.schedule(time, 2000, 3000);
	}
}
