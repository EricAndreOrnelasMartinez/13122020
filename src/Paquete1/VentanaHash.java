package Paquete1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	JLabel fondoL, hashM, me;
	Timer timer;
	JTextArea t1, t2;
	JScrollPane s1, s2;
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
		hashM = new JLabel("Hash code",SwingConstants.CENTER);
		hashM.setBounds(20, 215, 140, 40);
		hashM.setForeground(Color.WHITE);
		hashM.setVisible(false);
		hashM.setFont(new Font("Arial", Font.ITALIC, 15));
		me  =  new JLabel("Normal Words", SwingConstants.CENTER);
		me.setBounds(340, 215, 140, 40);
		me.setForeground(Color.WHITE);
		me.setFont(new Font("Arial", Font.ITALIC, 15));
		me.setVisible(false);
		panel.add(me);
		//hashM.setBorder(new LineBorder(Color.WHITE));
		panel.add(hashM);
		continueb = new JButton("Continue");
		continueb.setBounds(200, -40, 100, 30);
		continueb.setBorder(new LineBorder(Color.WHITE, 3, false));
		continueb.setBackground(new Color(0,0,0,0));
		continueb.setForeground(Color.WHITE);
		continueb.setEnabled(false);
		continueb.setFocusable(false);
		panel.add(continueb);
		t1 = new JTextArea();
		t1.setBackground(Color.WHITE);
		t1.setForeground(Color.BLACK);
		t1.setFont(new Font("Arial", Font.PLAIN, 18));
		//t1.setBackground(new Color(0,0,0,0));
		//t1.setBounds(30, 270, 100, 150);
		t2 = new JTextArea();
		t2.setBackground(Color.WHITE);
		t2.setFont(new Font("Arial", Font.PLAIN, 18));
		fondoL = new JLabel();
		s1 = new JScrollPane(t1);
		s1.setBounds(20, 250, 140, 200);
		s1.setBorder(new LineBorder(Color.BLACK, 3, false));
		s1.setVisible(false);
		//s1.setBackground(new Color(0,0,0,0));
		panel.add(s1);
		s2 = new JScrollPane(t2);
		s2.setBounds(340, 250, 140, 200);
		s2.setBorder(new LineBorder(Color.BLACK, 3, false));
		s2.setVisible(false);
		//s1.setBackground(new Color(0,0,0,0));
		panel.add(s2);
		fondoL.setOpaque(true);
		fondoL.setBounds(0, 0, this.getWidth(), this.getHeight());
		fondoL.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(fondoL);
		MouseListener mose = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				continueb.setVisible(false);
				s1.setVisible(true);
				s2.setVisible(true);
				me.setVisible(true);
				hashM.setVisible(true);
				
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
		KeyListener kl = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				String res = String.valueOf(arg0.getKeyChar());
				System.out.println(arg0.getKeyChar());
				if(arg0.getKeyChar() != '') {
					t2.append(hash(res));
				}else {
					t2.setText(deleteLast(t2.getText()));
				}
				//t2.append(res);
			}
			
		};
		t1.addKeyListener(kl);
		KeyListener kl2 = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				String res = String.valueOf(arg0.getKeyChar());
				System.out.println(arg0.getKeyChar());
				if(arg0.getKeyChar() != '') {
					t1.append(hashBack(res));
				}else {
					t1.setText(deleteLast(t1.getText()));
				}
				
			}
			
		};
		t2.addKeyListener(kl2);
	}
	public String hash(String x) {
		String r = "";
		if(x.equals("#")) {
			r = "a";
		}else if(x.equals("?")) {
			r = "b";
		}else if(x.equals("+")) {
			r = "c";
		}else if(x.equals("t")) {
			r = "d";
		}else if(x.equals("1")) {
			r = "e";
		}else if(x.equals("n")) {
			r = "f";
		}else if(x.equals("u")) {
			r = "g";
		}else if(x.equals("w")) {
			r = "h";
		}else if(x.equals("p")) {
			r = "i";
		}else if(x.equals("2")) {
			r = "j";
		}else if(x.equals("m")) {
			r = "k";
		}else if(x.equals("o")) {
			r = "n";
		}else if(x.equals("5")) {
			r = "m";
		}else if(x.equals("a")) {
			r = "o";
		}else if(x.equals("c")) {
			r = "p";
		}else if(x.equals("f")) {
			r = "q";
		}else if(x.equals("d")) {
			r = "r";
		}else if(x.equals("l")) {
			r = "s";
		}else if(x.equals("9")) {
			r = "t";
		}else if(x.equals("/")) {
			r = "u";
		}else if(x.equals("$")) {
			r = "v";
		}else if(x.equals("0")) {
			r = "w";
		}else if(x.equals("%")) {
			r = "x";
		}else if(x.equals(")")) {
			r = "y";
		}else if(x.equals("e")) {
			r = "z";
		}else if(x.equals(" ")) {
			r = " ";
		}else if(x.equals("\n")) {
			r = "\n";
		}else if(x.equals("4")) {
			r = "l";
		}else if(x.equals(",")) {
			r = ",";
		}else if(x.equals("¿")) {
			r = "?";
		}else if(x.equals(".")) {
			r = ".";
		}
		return r;
	}
	public String deleteLast(String x) {
		String y = "";
		for(int a = 0; a < x.length() -1; a++) {
			y = y + x.split("")[a];
		}
		return y;
	}
	public String hashBack(String x) {
		String r = "";
		if(x.equals("a")) {
			r = "#";
		}else if(x.equals("b")) {
			r = "?";
		}else if(x.equals("c")) {
			r = "+";
		}else if(x.equals("d")) {
			r = "t";
		}else if(x.equals("e")) {
			r = "1";
		}else if(x.equals("f")) {
			r = "n";
		}else if(x.equals("g")) {
			r = "u";
		}else if(x.equals("h")) {
			r = "w";
		}else if(x.equals("i")) {
			r = "p";
		}else if(x.equals("j")) {
			r = "2";
		}else if(x.equals("k")) {
			r = "m";
		}else if(x.equals("n")) {
			r = "o";
		}else if(x.equals("m")) {
			r = "5";
		}else if(x.equals("o")) {
			r = "a";
		}else if(x.equals("p")) {
			r = "c";
		}else if(x.equals("q")) {
			r = "f";
		}else if(x.equals("r")) {
			r = "d";
		}else if(x.equals("s")) {
			r = "l";
		}else if(x.equals("t")) {
			r = "9";
		}else if(x.equals("u")) {
			r = "/";
		}else if(x.equals("v")) {
			r = "$";
		}else if(x.equals("w")) {
			r = "0";
		}else if(x.equals("x")) {
			r = "%";
		}else if(x.equals("y")) {
			r = ")";
		}else if(x.equals("z")) {
			r = "e";
		}else if(x.equals(" ")) {
			r = " ";
		}else if(x.equals("\n")) {
			r = "\n";
		}else if(x.equals("l")) {
			r = "4";
		}else if(x.equals(",")) {
			r = ",";
		}else if(x.equals("?")) {
			r = "¿";
		}else if(x.equals(".")) {
			r = ".";
		}
		return r;
	}
}
