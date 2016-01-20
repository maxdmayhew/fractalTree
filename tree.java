import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



public class tree extends JPanel 
{
	//public settings s;
	public static double angleVar;
	public static int depthVar;
	
	public tree()
	{
		
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(400, 350));
		
		//setAngle(-90);
		
		System.out.println(angleVar + " ok");
		
		//setDepth(9);
		
		setVisible(true);
		
		
	}
	
	
	
	public void drawBranch(Graphics g, int x, int y, double angle, int depth)
	{		
		
		if (depth == 0) return;
			{
				int xCoord = x + (int) (Math.cos(Math.toRadians(angle)) * depth * 3.5);
				int yCoord = y + (int) (Math.sin(Math.toRadians(angle)) * depth * 3.5);
				
				g.drawLine(x, y, xCoord, yCoord);
				
				drawBranch(g, xCoord, yCoord, angle - 30, depth - 1);
				drawBranch(g, xCoord, yCoord, angle + 30, depth - 1);
			}
	}
	
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		System.out.println(getAngle() + " lol " + getAngle());
		drawBranch(g, 200, 340, getAngle(), getDepth());
		
		
	}
	
	
	public void setAngle(double x)
	{
		angleVar = x;
	}
	
	public void setDepth(int x)
	{
		depthVar = x;
	}
	
	public static double getAngle()
	{
		return angleVar;
	}
	
	public static int getDepth()
	{
		return depthVar;
	}
	
	


}
