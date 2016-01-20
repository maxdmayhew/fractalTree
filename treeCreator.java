import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class treeCreator extends JFrame implements ActionListener 
{

	public treeCreator() 
	{
		setTitle("merry christmas");
		setLayout(new BorderLayout());
		//add instances of the two other classes and add them...
		settings s = new settings();
		tree t = new tree(s);
		
		add(s, BorderLayout.SOUTH);
		add(t, BorderLayout.NORTH);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String [] args)
	{
		new treeCreator();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
}
