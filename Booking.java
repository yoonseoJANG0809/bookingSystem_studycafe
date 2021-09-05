import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.border.*;

public class Booking extends JFrame implements ActionListener
{
	ImageIcon icon, icon2;
	JButton startbtn, endbtn;
	JPanel contentPane;
	JLabel label, background;
	JFrame f1;
	Thread rt1, rt2, rt3, rt4;


	public Booking()
	{
		setTitle("�����͵�ī�� ����������");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		SnowMoving snow1 = new SnowMoving();
		SnowMoving snow2 = new SnowMoving();
		SnowMoving2 snow3 = new SnowMoving2();
		SnowMoving2 snow4 = new SnowMoving2();

		snow1.setBounds(480, 570, 70, screenSize.height);
		snow2.setBounds(920, 470, 80, 80);
		snow3.setBounds(480, 490, 30, 70);
		snow4.setBounds(890, 540, 30, 70);

		contentPane.add(snow1);
		contentPane.add(snow2);
		contentPane.add(snow3);
		contentPane.add(snow4);

		rt1 = new Thread(snow1);
		rt2 = new Thread(snow2);
		rt3 = new Thread(snow3);
		rt4 = new Thread(snow4);
		rt1.start();
		rt2.start();
		rt3.start();
		rt4.start();


		background = new JLabel();//���ȭ�� ����
		icon = new ImageIcon("img/mainsnow.png");
		Image img = icon.getImage();
		Image changeIcon = img.getScaledInstance(440, 450, Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(changeIcon);

		background.setIcon(icon2);
		background.setBounds(520, 350, 440, 450);
		contentPane.add(background);
  
		label = new JLabel("���� ���͵� ī��");
		label.setForeground(new Color(0, 0, 100));
		label.setFont(new Font("���� ���", Font.BOLD, 80));
		label.setBounds(450, 230, 1000, 100);
		contentPane.add(label);

		startbtn = new JButton("�ٷΰ���");	//menu �������� �̵�
		startbtn.addActionListener(this);
		startbtn.setFont(new Font("���� ���", Font.BOLD, 30));
		startbtn.setForeground(Color.WHITE);
		startbtn.setBackground(new Color(0, 0, 100));
		startbtn.setBounds(1330, 70, 160, 40);
		contentPane.add(startbtn);

		endbtn = new JButton("���α׷� ����");	//���α׷� ����
		endbtn.addActionListener(this);
		endbtn.setFont(new Font("���� ���", Font.BOLD, 13));
		endbtn.setForeground(Color.WHITE);
		endbtn.setBackground(Color.BLACK);
		endbtn.setBounds(1350, 30, 120, 30);
		contentPane.add(endbtn);

		setSize(screenSize.width, screenSize.height);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		f1 = new MenuPage();

		if(e.getSource().equals(startbtn)){
			setVisible(false);
			f1.setVisible(true);
			f1.setVisible(false);
			System.out.println("================[Ȱ��] �̸�(��й�ȣ): �¼���ȣ================");
			System.out.println();
		}
		if(e.getSource().equals(endbtn)){
			System.exit(0);
		}
	}
}
