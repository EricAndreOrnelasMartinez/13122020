package Paquete1;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class VentanaHash extends JFrame{
	ImageIcon fondo = new ImageIcon(".imagenes/fondo1.jpg");
	JPanel panel;
	JButton continueb;
	JLabel fondoL;
	Timer timer;
	public VentanaHash() {
		timer = new Timer();
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.BLACK);
		this.add(panel);
		continueb = new JButton("Continue");
		continueb.setBounds(200, -40, 100, 30);
		continueb.setBorder(new LineBorder(Color.WHITE, 3, false));
		continueb.setBackground(new Color(0,0,0,0));
		continueb.setForeground(Color.WHITE);
		continueb.setEnabled(false);
		continueb.setFocusable(false);
		panel.add(continueb);
		fondoL = new JLabel();
		fondoL.setOpaque(true);
		fondoL.setBounds(0, 0, this.getWidth(), this.getHeight());
		fondoL.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(fondoL);
		MouseListener mose = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				continueb.setVisible(false);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				continueb.setBackground(new Color(255,255,255));
				continueb.setForeground(Color.BLACK);
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				continueb.setBackground(new Color(0,0,0));
				continueb.setForeground(Color.WHITE);
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		continueb.addMouseListener(mose);
		TimerTask time = new TimerTask() {

			@Override
			public void run() {
				if(continueb.getY() < 280) {
					continueb.setLocation(continueb.getX(), continueb.getY() + 1);
				}else {
					continueb.setEnabled(true);
				}
			}
			
		};
		timer.schedule(time, 0, 10);
	}
}
