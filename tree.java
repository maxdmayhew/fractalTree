import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



public class tree extends JPanel implements ActionListener
{
	public settings s;
	public static double angleVar;
	public static int depthVar;
	
	public tree(settings s)
	{
		
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(400, 350));
		
		setAngle(-90);
		
		System.out.println(angleVar + " ok 25");
		
		setDepth(9);
		
		
		
		// if statement here..
		update();
		
	}
	
	private void update()
	{
		
		
		angleVar = getAngle();
		System.out.println("hey there");
		
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
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		System.out.println(angleVar + " lol");
		drawBranch(g, 200, 340, angleVar, depthVar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void setAngle(double x)
	{
		angleVar = x;
	}
	
	public static void setDepth(int x)
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
