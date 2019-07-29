package hello;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JFNotRunning{
	public void Initialize(){
		MoveBall m = new MoveBall();
		JFrame f = new JFrame();
		//JFrame f = m;
		//f.add(m);
		f.setVisible(true);
		f.setSize(600 , 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 Container cp = f.getContentPane();
	      cp.add(m);
	      // or "setContentPane(canvas);"
	 
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Handle the CLOSE button
	      //f.pack();              // Either pack() the components; or setSize()
	      f.setTitle("......");  // "super" JFrame sets the title
	      f.setVisible(true);    // "super" JFrame show
	   }
	
	
	/*public static void main(String args[]){
		 // Run the GUI codes on the Event-Dispatching thread for thread safety
	      SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            new JFNotRunning2(); // Let the constructor do the job
	         }
	      });
	   }*/
	}
class JFNotRunning2{
	public JFNotRunning2(){
	Initialize();
	}

	public void Initialize(){
		int length= 600 , breadth = 400;
		//MoveBall m = new MoveBall();
		DrawCanvas m = new DrawCanvas();
		JFrame f = new JFrame();
		//JFrame f = m;
		//f.add(m);
		f.setVisible(true);
		f.setSize(length , breadth);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Container cp = f.getContentPane();
	      cp.add(m.m_panel);
	      m.m_panel.setBackground(Color.white);
	      // or "setContentPane(canvas);"
	 
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Handle the CLOSE button
	      //f.pack();              // Either pack() the components; or setSize()
	      f.setTitle("......");  // "super" JFrame sets the title
	      f.setVisible(true);    // "super" JFrame show
	      m.Paint();
	   }



 class DrawCanvas  implements ActionListener {
    // Override paintComponent to perform your own painting
    
	 public JPanel m_panel = new JPanel() ;
	 
    /*public void paintComponent(Graphics g) {
       super.paintComponent(g);     // paint parent's background
       setBackground(Color.BLACK);  // set background color for this JPanel

       // Your custom painting codes. For example,
       // Drawing primitive shapes
       g.setColor(Color.YELLOW);    // set the drawing color
       g.drawLine(30, 40, 100, 200);
       g.drawOval(150, 180, 10, 10);
       g.drawRect(200, 210, 20, 30);
       g.setColor(Color.RED);       // change the drawing color
       g.fillOval(300, 310, 30, 50);
       g.fillRect(400, 350, 60, 50);
       // Printing texts
       g.setColor(Color.WHITE);
       g.setFont(new Font("Monospaced", Font.PLAIN, 12));
       g.drawString("Testing custom drawing ...", 10, 20);
    }*/
    Timer t = new Timer(5 , this);
	double x1 = 0 , y1 = 0 , VelX1 = 4 , VelY1 = 2;
	double x2 = 540 , y2 = 340 , VelX2 = 3.16 , VelY2 = 3.16;
	double radius = 60;
	double prevX1 , prevX2 , prevY1 , prevY2 , check;
	int flag = 0;
	public void PaintComponent(Graphics g){
		//super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.RED);
		Ellipse2D circle1 = new Ellipse2D.Double(x1, y1, radius, radius);
		Ellipse2D circle2 = new Ellipse2D.Double(x2, y2, radius, radius);
		g2.fill(circle1);
		g2.fill(circle2);
		t.start();
		
	}
	public void DrawCanvas(){
		m_panel.setBackground(Color.WHITE);
		
	}
	public void Erase()
	{
		Graphics g = m_panel.getGraphics();
		g.setColor(Color.WHITE);
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle1 = new Ellipse2D.Double(x1, y1, radius, radius);
		Ellipse2D circle2 = new Ellipse2D.Double(x2, y2, radius, radius);
		g2.fill(circle1);
		g2.fill(circle2);
		
		//Graphics g =m_panel.getGraphics();
		String str = new StringBuilder().append(String.valueOf(VelX1)).append("|").append(String.valueOf(VelY1)).append(String.valueOf(VelX2)).append(String.valueOf(VelY2)).toString();
		//String.valueOf(VelX1) +","+
		g.drawString(str, 100,100);
	}
	public void Paint()
	{
		Graphics g =m_panel.getGraphics();
		PaintComponent(g);
	}
	private void FixVelocities()
	{
		if (x1 >= 540 || x1 < 0){
			VelX1 = -VelX1;
		}
		if (x2 < 0 || x2 >= 540){
			VelX2 = -VelX2;
		}
		if (y1 >= 540 || y1 < 0){
			VelY1 = -VelY1;
		}
		if ( y2 >= 540 || y2 < 0){
			VelY2 = -VelY2;
		}
		
		
	}
	private void ChangeVelocityNoCollision()
	{
		x1 += VelX1;
		y1 += VelY1;
		x2 += VelX2;
		y2 += VelY2;
	}
	public void NoCollisionPrintFile(double a , double b) {
		PrintWriter writer;
		try {
			
			 writer = new PrintWriter(new BufferedWriter(new FileWriter("d:\\sidhartha.txt", true)));
			 writer.println( a + " - " +b + " - " +x1 +" - " +y1 + " - " +x2 +" - " +y2) ;
			// writer.println(a + " + " +b) ; //Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2));
			 writer.close();
			/*
			writer = new PrintWriter("d:\\sidhartha.txt", "UTF-8");
			writer.println(Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2));
			writer.println(Math.sqrt( VelX1 * VelX1 + VelY1 * VelY1));
			writer.close();
			*/
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public void CollisionPrintFile(double a , double b) {
		PrintWriter writer;
		try {
			
			 writer = new PrintWriter(new BufferedWriter(new FileWriter("d:\\sidhartha.txt", true)));
			 writer.println("collision :" + a + " - " +b + " - " +x1 +" - " +y1 + " - " +x2 +" - " +y2) ; //Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2));
			 writer.close();
			/*
			writer = new PrintWriter("d:\\sidhartha.txt", "UTF-8");
			writer.println(Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2));
			writer.println(Math.sqrt( VelX1 * VelX1 + VelY1 * VelY1));
			writer.close();
			*/
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	private void ChangeVelocityCollision()
	{
		/*
		double a = Math.atan((y2 - y1) / (x2 - x1));
		double a1 = Math.atan((y1 - prevy1c) / (x1 - prevx1c));
		double a2 = Math.atan((y2 - prevy2c) / x2 - prevx2c);
		
		VelX1 = Math.sqrt( VelX1 * VelX1 + VelY1 * VelY1) * Math.cos(2 * a - a1);
		VelY1 = Math.sqrt( VelX1 * VelX1 + VelY1 * VelY1) * Math.sin(2 * a - a1);
		VelX2 = Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2) * Math.cos(2 * a - a2);
		VelY2 = Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2) * Math.sin(2 * a - a2);
		
		x1 += VelX1;
		y1 += VelY1;
		x2 += VelX2;
		y2 += VelY2;
		*/
	}
	public void actionPerformed(ActionEvent e){
		Erase();
		
		FixVelocities();//If the boundary has reached, change the velocities
		
		if ( flag >0 && flag< 10 ) flag++ ;
		else
			flag = 0 ;
		double prevx1c = prevX1;
		double prevy1c = prevY1;
		double prevx2c = prevX2;
		double prevy2c = prevY2;
		
		prevX1 = x1;
		prevX2 = x2;
		prevY1 = y1;
		prevY2 = y2;
		
		
		if ( ( flag != 0 ) ||(Math.sqrt((x2 - x1)*(x2-x1) + (y2 - y1)*(y2 - y1)) > 2 * radius))
		{
			//when there is no coliision
			ChangeVelocityNoCollision();
		//m_panel.repaint();
			
			NoCollisionPrintFile(Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2) , Math.sqrt( VelX1 * VelX1 + VelY1 * VelY1));
		}
		else if(flag == 0){
			//when there is collision
			
			//double check = x1;
			
			double a = Math.atan((y2 - y1) / (x2 - x1));
			double a1 = Math.atan((y1 - prevy1c) / (x1 - prevx1c));
			double a2 = Math.atan((y2 - prevy2c) / x2 - prevx2c);
			
			VelX1 = Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2) * Math.cos(2 * a - a1)*-1;
			VelY1 = Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2) * Math.sin(2 * a - a1);
			
			VelX2 = Math.sqrt( VelX1 * VelX1 + VelY1 * VelY1) * Math.cos(2 * a - a2)*-1;
			VelY2 = Math.sqrt( VelX1 * VelX1 + VelY1 * VelY1) * Math.sin(2 * a - a2);
			
			x1 += VelX1;
			y1 += VelY1;
			x2 += VelX2;
			y2 += VelY2;			
			
			flag ++;
			
			CollisionPrintFile(Math.sqrt( VelX2 * VelX2 + VelY2 * VelY2) , Math.sqrt( VelX1 * VelX1 + VelY1 * VelY1));
		}
		
		
		//if(x1 == (check + 3*VelX1)){
			//flag = 0;
		//}
		
		Paint();
		
		Graphics g =m_panel.getGraphics();
		String str = new StringBuilder().append(String.valueOf(VelX1)).append(String.valueOf(VelY1)).append(String.valueOf(VelX2)).append(String.valueOf(VelY2)).toString();
		//String.valueOf(VelX1) +","+
		g.drawString(str, 100,100);
		//m_panel.repaint();
				
	}
	
 }
 }
	/*public static void main(String[] args) {
	      // Run the GUI codes on the Event-Dispatching thread for thread safety
	      SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            new MoveBall(); // Let the constructor do the job
	         }
	      });
	   }
}*/
