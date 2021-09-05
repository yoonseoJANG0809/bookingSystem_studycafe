import java.awt.*; 
import java.util.*; 
import javax.swing.*;

public class SnowMoving extends JPanel implements Runnable{ 
	private MyCanvas mc = new MyCanvas(); 
	private Image snow = Toolkit.getDefaultToolkit().getImage("img/snow1.png"); 
	private Image snow2 = Toolkit.getDefaultToolkit().getImage("img/snow2.png"); 
	
	private int snowx, snowy;// snow x,y 좌표 
	private Dimension frameSize;

	public SnowMoving() { 
		setLayout(new BorderLayout()); 
		setBackground(Color.white); 
		add(mc); 
	} 
	public void run() { 
		while(true) { 
			// 스레드 0.2초 
			try {Thread.sleep(200);}catch(Exception e) {e.printStackTrace();}
			if(snowy==-10) snowy = 30;
			
			snowy -= 5;
			repaint();
			mc.repaint(); 
		} 
	} 

	class MyCanvas extends Canvas{ 
		public void paint(Graphics g) { 
			g.drawImage(snow, snowx, snowy, 50, 50, this); 
			g.drawImage(snow2, snowx+50, snowy+10, 20, 20, this); 
		} 
	} 
}
 