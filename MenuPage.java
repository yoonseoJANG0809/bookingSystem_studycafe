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
	int limit = 4;	//비밀번호 입력 수 제한


	public MenuPage()
	{
		fmenu = new JFrame("숙명스터디카페 메뉴");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


		fmenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		background = new JLabel("");	//배경화면 설정
		icon = new ImageIcon("img/booksnow.jpg");
		Image img = icon.getImage();
		Image changeIcon = img.getScaledInstance(500, 600, Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(changeIcon);

		background.setIcon(icon2);
		background.setBounds(100, 200, 500, 600);
		contentPane.add(background);

		Map<String, String>stuMap= new HashMap<>();	//map 생성

		font1 = new Font("맑은 고딕", Font.BOLD, 35);	//bt1, bt2, bt3, bt4, name, passwd
		font2 = new Font("맑은 고딕", Font.BOLD, 15);	//text, lnotice, ok버튼, door
		font3 = new Font("serif", Font.BOLD, 35);	//tname. tpass
		font4 = new Font("맑은 고딕", Font.BOLD, 20);	//좌석예약/확인/삭제 버튼

		bt1 = new JButton("좌석 예약");	//좌석에약버튼
		bt1.setFont(font1);
		bt1.setBounds(1040, 200, 200, 50);
		bt1.setForeground(Color.WHITE);
		bt1.setBackground(new Color(0, 0, 100));
		contentPane.add(bt1);

		bt2 = new JButton("예약 조회");	//예약조회버튼
		bt2.setFont(font1);
		bt2.setBounds(1040, 320, 200, 50);
		bt2.setForeground(Color.WHITE);
		bt2.setBackground(new Color(0, 0, 100));
		contentPane.add(bt2);

		bt3 = new JButton("예약 삭제");	//예약삭제버튼
		bt3.setFont(font1);
		bt3.setBounds(1040, 440, 200, 50);
		bt3.setForeground(Color.WHITE);
		bt3.setBackground(new Color(0, 0, 100));
		contentPane.add(bt3);

		bt4 = new JButton("종료");	//종료버튼(시작 페이지로)
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

		name = new JLabel("이름:  ");
		name.setFont(font1);
		passwd = new JLabel("비밀번호:  ");
		passwd.setFont(font1);
		text = new JLabel("4자리 숫자를 입력하세요.");
		text.setFont(font2);

		String regExp = "^[0-9]+$";	//비밀번호 입력 시 숫자만 허용


		for(int i=0; i<8; i++){		//버튼 비활성화, 활성화 변환 위해 앞부분에 생성
			int num = i+1;
			b[i] = new JButton(Integer.toString(num));
			b[i].setBackground(Color.WHITE);
		}

		bt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fmenu.setVisible(false);

				fbook = new JFrame("좌석 예약");
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

				bbt = new JButton("좌석 예약");//좌석에약버튼

				bbt.setFont(font4);
				bbt.setBounds(680, 500, 150, 40);
				contentPane2.add(bbt);

				fbook.add(contentPane2);

				contentPane2.setVisible(true);

				bbt.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(tpass.getText().matches(regExp) && tpass.getText().getBytes().length == limit){	//비밀번호가 숫자로만 이루어져 있고 4자리여야만 버튼 실행
							if(e.getSource().equals(bbt)){
								fseat = new JFrame("좌석 예약");
								pseat = new JPanel();
								
								fseat.setSize(520,450);
								fseat.setVisible(true);

								for(int i=0; i<8; i++)
								{
									int num = i+1;
									b[i].setFont(font4);
									b[i].addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent e){
											fnotice = new JFrame("예약 안내");

											passingname = tname.getText();
											passingpasswd = tpass.getText();

											fnotice.setSize(500, 200);
											fnotice.setVisible(true);

											pnotice = new JPanel();// 버튼이나 라벨이 들어갈 화면을 만듬
											setContentPane(pnotice);
											pnotice.setLayout(null);

											plnotice = new JPanel();

											for(int j=0; j<8; j++) {
												if(e.getSource().equals(b[j])) {
													bnum = Integer.toString(j+1);
													lnotice = new JLabel(passingname+"님.  "+bnum+ "번 예약 완료되었습니다.");
													lnotice.setFont(font2);
													plnotice.add(lnotice);

													b[num-1].setEnabled(false);	//선택한 버튼을 비활성화 처리
													b[num-1].setBackground(Color.gray);	//선택된 버튼은 색상 변경
												}
											}

											ok = new JButton("확인");
											ok.setFont(font2);
											ok.setBounds(200, 70, 100, 25);
											plnotice.setBounds(10, 10, 500, 100);

											pnotice.add(plnotice);
											pnotice.add(ok);

											fnotice.add(pnotice);

											ok.addActionListener(new ActionListener(){
												public void actionPerformed(ActionEvent e) {
													namePasswd = passingname.concat(passingpasswd);	//이름과 비밀번호를 연결해 저장
													
													stuMap.put(namePasswd, bnum);	//map에 이름+비밀번호를 key로, 좌석번호를 value로 저장
													System.out.println("[삽입] "+ passingname + "(" + passingpasswd + "): " + stuMap.get(namePasswd));	//활동 내용 콘솔에 출력
													
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

								door = new JLabel("문");

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
								door.setBackground(Color.BLACK);	//버튼의 배경색을 지정
								door.setForeground(Color.WHITE);	//버튼의 글자색 지정
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
							wrongpass.setText("잘못된 비밀번호 형식입니다.");	//비밀번호의 형식이 틀린 경우 버튼 작동 안하며 잘못된 형식이라는 문자열 출력
						}
					}
				});
			}
		});
		
		bt2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				fmenu.setVisible(false);
				
				fsearch = new JFrame("예약 조회");   
				contentPane3 = new JPanel();
				sbt = new JButton("좌석 조회");

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
							fnotice = new JFrame("예약 조회");

							passingname = tname.getText();
							passingpasswd = tpass.getText();

							fnotice.setSize(500, 200);
							fnotice.setVisible(true);

							pnotice = new JPanel();
							setContentPane(pnotice);
							pnotice.setLayout(null);

							plnotice = new JPanel();

							namePasswd = passingname.concat(passingpasswd);

							System.out.println("[조회] "+ passingname +": " + stuMap.get(namePasswd));	//활동 내용 콘솔에 출력
							
							if(stuMap.containsKey(namePasswd)){	//입력한 이름+비밀번호가 Map에 key로 존재하는 경우
								bnum = (String) stuMap.get(namePasswd);	//입력한 이름+비밀번호가 key인 value(좌석번호) 출력
							} else{
								bnum = "\'예약된 좌석이 없습니다\' ";
							}

							lnotice = new JLabel(passingname+"님이 예약하신 자리는 " + bnum + "입니다.");
							lnotice.setFont(font2);
							plnotice.add(lnotice);

							plnotice.setBounds(10, 10, 500, 100);

							ok = new JButton("확인");
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
							wrongpass.setText("잘못된 비밀번호 형식입니다.");
						}
					}
				});
			}
		});
		
		bt3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				fmenu.setVisible(false);
				
				fdelete = new JFrame("예약 삭제");   
				contentPane4 = new JPanel();
				dbt = new JButton("예약 삭제");

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
							fnotice = new JFrame("예약 삭제");

							passingname = tname.getText();
							passingpasswd = tpass.getText();

							fnotice.setSize(500, 200);
							fnotice.setVisible(true);

							pnotice = new JPanel();
							setContentPane(pnotice);
							pnotice.setLayout(null);

							plnotice = new JPanel();

							namePasswd = passingname.concat(passingpasswd);

							if(stuMap.containsKey(namePasswd)){	//입력한 이름+비밀번호가 Map에 key로 존재하는 경우
								int num = Integer.parseInt(stuMap.get(namePasswd));	//value(좌석번호)를 정수로 변환
								dresult = " 님의 좌석이 삭제되었습니다.";
								System.out.println("[삭제] "+ passingname + "(" + passingpasswd + "): " + stuMap.get(namePasswd));	//활동 내용 콘솔에 출력
								stuMap.remove(namePasswd);	//key가 이름+비밀번호인 key-value쌍 삭제
								b[num-1].setEnabled(true);	//삭제한 좌석번호 활성화
								b[num-1].setBackground(Color.WHITE);

							} else{
								dresult = " 님의 좌석 예약 내역이 없습니다";
							}
							lnotice = new JLabel("[삭제] " + passingname + dresult);

							lnotice.setFont(font2);
							plnotice.add(lnotice);

							plnotice.setBounds(10, 10, 500, 100);

							ok = new JButton("확인");
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
							wrongpass.setText("잘못된 비밀번호 형식입니다.");
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