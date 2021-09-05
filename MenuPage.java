import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class MenuPage extends JFrame implements ActionListener
{
	ImageIcon icon, icon2, backIcon, backIcon2;
	JButton bt1, bt2, bt3, bt4, bbt, sbt, dbt, ok, back;
	JPanel contentPane, contentPane2, contentPane3, contentPane4, pname, ppass, ptext, 
			pseat, pnotice, plnotice;
	JFrame fmain, fmenu, fbook, fsearch, fdelete, fseat, fnotice;
	JLabel background, name, passwd, text, door, lnotice, wrongpass;
	Font font1, font2, font3, font4;
	String namePasswd, passingname, passingpasswd, bnum, dresult;
	JTextField tname, tpass;
	JButton b[] = new JButton[8];
	int limit = 4;	//��й�ȣ �Է� �� ����


	public MenuPage()
	{
		fmenu = new JFrame("�����͵�ī�� �޴�");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


		fmenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		background = new JLabel("");	//���ȭ�� ����
		icon = new ImageIcon("img/booksnow.jpg");
		Image img = icon.getImage();
		Image changeIcon = img.getScaledInstance(500, 600, Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(changeIcon);

		background.setIcon(icon2);
		background.setBounds(100, 200, 500, 600);
		contentPane.add(background);

		Map<String, String>stuMap= new HashMap<>();	//map ����

		font1 = new Font("���� ���", Font.BOLD, 35);	//bt1, bt2, bt3, bt4, name, passwd
		font2 = new Font("���� ���", Font.BOLD, 15);	//text, lnotice, ok��ư, door
		font3 = new Font("serif", Font.BOLD, 35);	//tname. tpass
		font4 = new Font("���� ���", Font.BOLD, 20);	//�¼�����/Ȯ��/���� ��ư

		bt1 = new JButton("�¼� ����");	//�¼������ư
		bt1.setFont(font1);
		bt1.setBounds(1040, 200, 200, 50);
		bt1.setForeground(Color.WHITE);
		bt1.setBackground(new Color(0, 0, 100));
		contentPane.add(bt1);

		bt2 = new JButton("���� ��ȸ");	//������ȸ��ư
		bt2.setFont(font1);
		bt2.setBounds(1040, 320, 200, 50);
		bt2.setForeground(Color.WHITE);
		bt2.setBackground(new Color(0, 0, 100));
		contentPane.add(bt2);

		bt3 = new JButton("���� ����");	//���������ư
		bt3.setFont(font1);
		bt3.setBounds(1040, 440, 200, 50);
		bt3.setForeground(Color.WHITE);
		bt3.setBackground(new Color(0, 0, 100));
		contentPane.add(bt3);

		bt4 = new JButton("����");	//�����ư(���� ��������)
		bt4.addActionListener(this);
		bt4.setFont(font1);
		bt4.setBounds(1040, 560, 200, 50);
		bt4.setForeground(Color.WHITE);
		bt4.setBackground(new Color(0, 0, 100));
		contentPane.add(bt4);

		backIcon = new ImageIcon("img/back.png");
		Image img2 = backIcon.getImage();
		Image changeIcon2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		backIcon2 = new ImageIcon(changeIcon2);
		back = new JButton("", backIcon2);
		back.setBounds(10, 10, 50, 50);

		name = new JLabel("�̸�:  ");
		name.setFont(font1);
		passwd = new JLabel("��й�ȣ:  ");
		passwd.setFont(font1);
		text = new JLabel("4�ڸ� ���ڸ� �Է��ϼ���.");
		text.setFont(font2);

		String regExp = "^[0-9]+$";	//��й�ȣ �Է� �� ���ڸ� ���


		for(int i=0; i<8; i++){		//��ư ��Ȱ��ȭ, Ȱ��ȭ ��ȯ ���� �պκп� ����
			int num = i+1;
			b[i] = new JButton(Integer.toString(num));
			b[i].setBackground(Color.WHITE);
		}

		bt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fmenu.setVisible(false);

				fbook = new JFrame("�¼� ����");
				fbook.setVisible(true);

				fbook.setSize(screenSize.width, screenSize.height);

				contentPane2 = new JPanel();
				contentPane2.setBackground(Color.WHITE);
				setContentPane(contentPane2);
				contentPane2.setLayout(null);

				pname = new JPanel();
				pname.setBackground(Color.WHITE);
				ppass = new JPanel();
				ppass.setBackground(Color.WHITE);
				ptext = new JPanel();
				ptext.setBackground(Color.WHITE);

				wrongpass = new JLabel();
				wrongpass.setForeground(Color.red);

				pname.add(name);
				ppass.add(passwd);
				ptext.add(text);
				ptext.add(wrongpass);

				tname = new JTextField(22);
				tpass = new JTextField(20);

				tname.setFont(font3);
				tpass.setFont(font3);
				
				pname.add(tname);
				ppass.add(tpass);
				
				pname.setBounds(100, 100, 1000, 100);
				ppass.setBounds(100, 250, 1000, 80);
				ptext.setBounds(100, 320, 400, 35);

				contentPane2.add(pname);
				contentPane2.add(ppass);
				contentPane2.add(ptext);
				contentPane2.add(back);
				back.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						fbook.setVisible(false);
						fmenu.setVisible(true);
					}
				});

				bbt = new JButton("�¼� ����");//�¼������ư

				bbt.setFont(font4);
				bbt.setBounds(680, 500, 150, 40);
				contentPane2.add(bbt);

				fbook.add(contentPane2);

				contentPane2.setVisible(true);

				bbt.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(tpass.getText().matches(regExp) && tpass.getText().getBytes().length == limit){	//��й�ȣ�� ���ڷθ� �̷���� �ְ� 4�ڸ����߸� ��ư ����
							if(e.getSource().equals(bbt)){
								fseat = new JFrame("�¼� ����");
								pseat = new JPanel();
								
								fseat.setSize(520,450);
								fseat.setVisible(true);

								for(int i=0; i<8; i++)
								{
									int num = i+1;
									b[i].setFont(font4);
									b[i].addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent e){
											fnotice = new JFrame("���� �ȳ�");

											passingname = tname.getText();
											passingpasswd = tpass.getText();

											fnotice.setSize(500, 200);
											fnotice.setVisible(true);

											pnotice = new JPanel();// ��ư�̳� ���� �� ȭ���� ����
											setContentPane(pnotice);
											pnotice.setLayout(null);

											plnotice = new JPanel();

											for(int j=0; j<8; j++) {
												if(e.getSource().equals(b[j])) {
													bnum = Integer.toString(j+1);
													lnotice = new JLabel(passingname+"��.  "+bnum+ "�� ���� �Ϸ�Ǿ����ϴ�.");
													lnotice.setFont(font2);
													plnotice.add(lnotice);

													b[num-1].setEnabled(false);	//������ ��ư�� ��Ȱ��ȭ ó��
													b[num-1].setBackground(Color.gray);	//���õ� ��ư�� ���� ����
												}
											}

											ok = new JButton("Ȯ��");
											ok.setFont(font2);
											ok.setBounds(200, 70, 100, 25);
											plnotice.setBounds(10, 10, 500, 100);

											pnotice.add(plnotice);
											pnotice.add(ok);

											fnotice.add(pnotice);

											ok.addActionListener(new ActionListener(){
												public void actionPerformed(ActionEvent e) {
													namePasswd = passingname.concat(passingpasswd);	//�̸��� ��й�ȣ�� ������ ����
													
													stuMap.put(namePasswd, bnum);	//map�� �̸�+��й�ȣ�� key��, �¼���ȣ�� value�� ����
													System.out.println("[����] "+ passingname + "(" + passingpasswd + "): " + stuMap.get(namePasswd));	//Ȱ�� ���� �ֿܼ� ���
													
													fnotice.setVisible(false);
													fbook.setVisible(false);
													fseat.setVisible(false);
													fmenu.setVisible(true);
												}
											});
										}
									});
								}
								pseat.setLayout(null);

								door = new JLabel("��");

								b[0].setBounds(0, 100, 125, 100);
								b[1].setBounds(0, 200, 125, 100);
								b[2].setBounds(0, 300, 125, 100);
								b[3].setBounds(375, 300, 125, 100);
								b[4].setBounds(375, 200, 125, 100);
								b[5].setBounds(375, 100, 125, 100);
								b[6].setBounds(250, 0, 125, 100);
								b[7].setBounds(125, 0, 125, 100);
								door.setBounds(188, 370, 125, 30);
								
								door.setOpaque(true);
								door.setBackground(Color.BLACK);	//��ư�� ������ ����
								door.setForeground(Color.WHITE);	//��ư�� ���ڻ� ����
								door.setFont(font2); 
								door.setHorizontalAlignment(JLabel.CENTER); 

								pseat.add(b[0]);
								pseat.add(b[1]);
								pseat.add(b[2]);
								pseat.add(b[3]);
								pseat.add(b[4]);
								pseat.add(b[5]);
								pseat.add(b[6]);
								pseat.add(b[7]);
								pseat.add(door);

								fseat.add(pseat);
							} else{}
						} else{
							wrongpass.setText("�߸��� ��й�ȣ �����Դϴ�.");	//��й�ȣ�� ������ Ʋ�� ��� ��ư �۵� ���ϸ� �߸��� �����̶�� ���ڿ� ���
						}
					}
				});
			}
		});
		
		bt2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				fmenu.setVisible(false);
				
				fsearch = new JFrame("���� ��ȸ");   
				contentPane3 = new JPanel();
				sbt = new JButton("�¼� ��ȸ");

				fsearch.setSize(screenSize.width, screenSize.height);
				fsearch.setVisible(true);
			   
				contentPane3.setBackground(Color.WHITE);
				setContentPane(contentPane3);
				contentPane3.setLayout(null);

				pname = new JPanel();
				pname.setBackground(Color.WHITE);
				ppass = new JPanel();
				ppass.setBackground(Color.WHITE);
				ptext = new JPanel();
				ptext.setBackground(Color.WHITE);

				pname.add(name);
				ppass.add(passwd);
				ptext.add(text);

				wrongpass = new JLabel();
				wrongpass.setForeground(Color.red);

				tname = new JTextField(22);
				tpass = new JTextField(20);

				tname.setFont(font3);
				tpass.setFont(font3);

				pname.add(tname);
				ppass.add(tpass);
				ptext.add(wrongpass);

				pname.setBounds(100, 100, 1000, 100);
				ppass.setBounds(100, 250, 1000, 80);
				ptext.setBounds(100, 320, 400, 35);

				contentPane3.add(pname);
				contentPane3.add(ppass);
				contentPane3.add(ptext);
				contentPane3.add(back);
				back.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						fsearch.setVisible(false);
						fmenu.setVisible(true);
					}
				});

				sbt.setFont(font4);
				sbt.setBounds(680, 500, 150, 40);
				contentPane3.add(sbt);

				fsearch.add(contentPane3);
						
				sbt.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(tpass.getText().matches(regExp) && tpass.getText().getBytes().length == limit){
							fnotice = new JFrame("���� ��ȸ");

							passingname = tname.getText();
							passingpasswd = tpass.getText();

							fnotice.setSize(500, 200);
							fnotice.setVisible(true);

							pnotice = new JPanel();
							setContentPane(pnotice);
							pnotice.setLayout(null);

							plnotice = new JPanel();

							namePasswd = passingname.concat(passingpasswd);

							System.out.println("[��ȸ] "+ passingname +": " + stuMap.get(namePasswd));	//Ȱ�� ���� �ֿܼ� ���
							
							if(stuMap.containsKey(namePasswd)){	//�Է��� �̸�+��й�ȣ�� Map�� key�� �����ϴ� ���
								bnum = (String) stuMap.get(namePasswd);	//�Է��� �̸�+��й�ȣ�� key�� value(�¼���ȣ) ���
							} else{
								bnum = "\'����� �¼��� �����ϴ�\' ";
							}

							lnotice = new JLabel(passingname+"���� �����Ͻ� �ڸ��� " + bnum + "�Դϴ�.");
							lnotice.setFont(font2);
							plnotice.add(lnotice);

							plnotice.setBounds(10, 10, 500, 100);

							ok = new JButton("Ȯ��");
							ok.setFont(font2);
							ok.setBounds(200, 70, 100, 25);

							pnotice.add(plnotice);
							pnotice.add(ok);

							fnotice.add(pnotice);
							ok.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e) {
									fnotice.setVisible(false);
									fsearch.setVisible(false);
									fmenu.setVisible(true);
								}
							});
						} else{
							wrongpass.setText("�߸��� ��й�ȣ �����Դϴ�.");
						}
					}
				});
			}
		});
		
		bt3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				fmenu.setVisible(false);
				
				fdelete = new JFrame("���� ����");   
				contentPane4 = new JPanel();
				dbt = new JButton("���� ����");

				fdelete.setSize(screenSize.width, screenSize.height);
				fdelete.setVisible(true);
			   
				contentPane4.setBackground(Color.WHITE);
				setContentPane(contentPane4);
				contentPane4.setLayout(null);

				pname = new JPanel();
				pname.setBackground(Color.WHITE);
				ppass = new JPanel();
				ppass.setBackground(Color.WHITE);
				ptext = new JPanel();
				ptext.setBackground(Color.WHITE);

				pname.add(name);
				ppass.add(passwd);
				ptext.add(text);

				wrongpass = new JLabel();
				wrongpass.setForeground(Color.red);

				tname = new JTextField(22);
				tpass = new JTextField(20);

				tname.setFont(font3);
				tpass.setFont(font3);

				pname.add(tname);
				ppass.add(tpass);
				ptext.add(wrongpass);

				pname.setBounds(100, 100, 1000, 100);
				ppass.setBounds(100, 250, 1000, 80);
				ptext.setBounds(100, 320, 400, 35);

				contentPane4.add(pname);
				contentPane4.add(ppass);
				contentPane4.add(ptext);
				contentPane4.add(back);
				back.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						fdelete.setVisible(false);
						fmenu.setVisible(true);
					}
				});

				dbt.setFont(font4);
				dbt.setBounds(680, 500, 150, 40);
				contentPane4.add(dbt);

				fdelete.add(contentPane4);
						
				dbt.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(tpass.getText().matches(regExp) && tpass.getText().getBytes().length == limit){
							fnotice = new JFrame("���� ����");

							passingname = tname.getText();
							passingpasswd = tpass.getText();

							fnotice.setSize(500, 200);
							fnotice.setVisible(true);

							pnotice = new JPanel();
							setContentPane(pnotice);
							pnotice.setLayout(null);

							plnotice = new JPanel();

							namePasswd = passingname.concat(passingpasswd);

							if(stuMap.containsKey(namePasswd)){	//�Է��� �̸�+��й�ȣ�� Map�� key�� �����ϴ� ���
								int num = Integer.parseInt(stuMap.get(namePasswd));	//value(�¼���ȣ)�� ������ ��ȯ
								dresult = " ���� �¼��� �����Ǿ����ϴ�.";
								System.out.println("[����] "+ passingname + "(" + passingpasswd + "): " + stuMap.get(namePasswd));	//Ȱ�� ���� �ֿܼ� ���
								stuMap.remove(namePasswd);	//key�� �̸�+��й�ȣ�� key-value�� ����
								b[num-1].setEnabled(true);	//������ �¼���ȣ Ȱ��ȭ
								b[num-1].setBackground(Color.WHITE);

							} else{
								dresult = " ���� �¼� ���� ������ �����ϴ�";
							}
							lnotice = new JLabel("[����] " + passingname + dresult);

							lnotice.setFont(font2);
							plnotice.add(lnotice);

							plnotice.setBounds(10, 10, 500, 100);

							ok = new JButton("Ȯ��");
							ok.setFont(font2);
							ok.setBounds(200, 70, 100, 25);

							pnotice.add(plnotice);
							pnotice.add(ok);

							fnotice.add(pnotice);
							ok.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e) {
									fnotice.setVisible(false);
									fdelete.setVisible(false);
									fmenu.setVisible(true);
								}
							});
						} else{
							wrongpass.setText("�߸��� ��й�ȣ �����Դϴ�.");
						}
					}
				});
			}
		});
		
		fmenu.add(contentPane);
		fmenu.setSize(screenSize.width, screenSize.height);
		fmenu.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(bt4)){
			fmain = new Booking();
			fmenu.setVisible(false);
			fmain.setVisible(true);
		}
	}
}