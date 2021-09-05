import java.awt.*; 
import java.util.*; 
import javax.swing.*;

public class SnowMoving2 extends JPanel implements Runnable{ 
	private MyCanvas mc = new MyCanvas(); 
	private Image snow3 = Toolkit.getDefaultToolkit().getImage("img/snow3.png"); 
	
	private int snowx, snowy;// snow x,y 좌표 
	private Dimension frameSize;

	public SnowMoving2() { 
		setLayout(new BorderLayout()); 
		setBackground(Color.white); 
		add(mc); 
	} 
	public void run() { 
		while(true) { 
			// 스레드 0.18초 
			try {Thread.sleep(180);}catch(Exception e) {e.printStackTrace();}
			if(snowy==-10) snowy = 40;
			
			snowy -= 5;
			repaint();
			mc.repaint(); 
		} 
	} 

	class MyCanvas extends Canvas{ 
		public void paint(Graphics g) { 
			g.drawImage(snow3, snowx, snowy, 30, 30, this); 
		} 
	} 
}
