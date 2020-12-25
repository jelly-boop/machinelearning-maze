import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StartPanel extends JFrame implements MouseListener, Runnable {
	JScrollPane scrollPane;
	ImageIcon icon;
	JButton btn = new JButton("��START");
	JButton btn2 = new JButton("HELP��");
	Clip clip;

	public StartPanel() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;

		bgm = new File("music/music.wav"); // ���ÿ��� ���� ������ ������ ��

		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();

		} catch (Exception e1) {
			System.out.println("err : " + e1);
		}

		this.setLayout(new BorderLayout());
		icon = new ImageIcon("img/background.jpg");

		// ��� Panel ������ �������������� ����
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
				super.paintComponent(g);
			}
		};
		background.setLayout(new BorderLayout());

		background.add(btn, BorderLayout.EAST);
		btn.setBackground(Color.gray);
		btn.addMouseListener(this);
		background.add(btn2, BorderLayout.WEST);
		btn2.setBackground(Color.gray);
		btn2.addMouseListener(this);
		
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
	}

	public static void main(String[] args) {
		StartPanel frame = new StartPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(150, 50);
		frame.setSize(1200, 650);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(btn)) {
			this.clip.stop();
			this.dispose();
			MainPanel mainPanel = new MainPanel();
			mainPanel.setVisible(true);
		}else if(e.getSource().equals(btn2)) {
			JOptionPane.showMessageDialog(null, "�� �����ư� �Զ��Ǿ���. �츮�� �� �������� ����Ͽ� ���ε��� ���� �������Ʒ�"
					+ "���Ѵ�..!");
		}
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(btn)) {
			this.btn.setBackground(Color.red);
		}else if(e.getSource().equals(btn2)) {
			this.btn2.setBackground(Color.red);
		}
		
		

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(btn)) {
			this.btn.setBackground(Color.GRAY);
		}else if(e.getSource().equals(btn2)) {
			this.btn2.setBackground(Color.GRAY);
		}

	}

	@Override
	public void run() {

	}
}
