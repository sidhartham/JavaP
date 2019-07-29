package hello;

import java.awt.*;       
import java.awt.event.*; 
import java.awt.geom.Ellipse2D;

import javax.swing.*; 

public class MoveBall extends JPanel implements ActionListener{
	Timer t = new Timer(5 , this);
	int x = 0 , y = 0 , VelX = 2 , VelY = 2;
	
	public void PaintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(x, y, 60, 60);
		g2.fill(circle);
		 g.fillOval(300, 310, 30, 50);
         g.fillRect(400, 350, 60, 50);
         // Printing texts
         g.setColor(Color.WHITE);
         g.setFont(new Font("Monospaced", Font.PLAIN, 12));
         g.drawString("Testing custom drawing ...", 10, 20);
		t.start();
	}
	public void actionPerformed(ActionEvent e){
		if (x >= 540 || x < 0){
			VelX = -VelX;
		}
		if (y >= 340 || y < 0){
			VelY = -VelY;
		}
		x =+ VelX;
		y =+ VelY;
		
		repaint();
				
	}
	public MoveBall(){
		//Graphics G = new Graphics();
		//paintcomponent()
	}
}
