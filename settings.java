import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class settings extends JPanel implements ActionListener
{
	double angleRange = 360;
	double depthRange = 100;
	
	JLabel angleTag = new JLabel("Angle: ");
	JLabel depthTag = new JLabel("Iterations: ");
	
	NumberFormat angleFormat;
	NumberFormat depthFormat;
	
	JFormattedTextField angleData;
	JFormattedTextField depthData;
	
	JButton alter;
	
	public double angleVar;
	public int depthVar;
	
	
	public settings()
	{
		tree t = new tree(this);

		
		setUpFormats();
		setPreferredSize(new Dimension(100, 80));
		setBackground(Color.DARK_GRAY);;

		Font font = new Font("Verdana", Font.BOLD, 14);
		angleTag.setFont(font);
		depthTag.setFont(font);
		angleTag.setForeground(Color.white);
		depthTag.setForeground(Color.white);

		
		angleData = new JFormattedTextField(angleFormat);
		angleData.setValue(new Double(angleRange));
		angleData.setColumns(3);
		angleData.addActionListener(new angleListener());

		depthData = new JFormattedTextField(depthFormat);
		depthData.setValue(new Double(depthRange));
		depthData.setColumns(3);
		depthData.addActionListener(new depthListener());
		
		
		alter = new JButton("redraw");
		alter.addActionListener(this);
		
		angleTag.setLabelFor(angleData);
		depthTag.setLabelFor(depthData);
		
		JPanel labelPanel = new JPanel(new GridLayout(0,1));
		labelPanel.add(angleTag);
		labelPanel.add(depthTag);
		labelPanel.setBackground(Color.DARK_GRAY);
		
		JPanel dataPanel = new JPanel(new GridLayout(0,1));
		dataPanel.add(angleData);
		dataPanel.add(depthData);
		dataPanel.setBackground(Color.DARK_GRAY);
		
		JPanel buttonPanel = new JPanel(new GridLayout(0,1));
		buttonPanel.add(alter);
		dataPanel.setBackground(Color.DARK_GRAY);
		
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(labelPanel, BorderLayout.CENTER);
		add(dataPanel, BorderLayout.LINE_END);
		add(buttonPanel, BorderLayout.EAST);
		
		printthing();
	
		
		//depthTag.setFont(font);
		//depthTag.setForeground(Color.white);
		//add(depthTag);
			
	}
	
	

	private void printthing()
	{
		// TODO Auto-generated method stub
		System.out.println("xx " + depthVar);
	}



	private void setUpFormats()
	{
		// TODO Auto-generated method stub
		angleFormat = NumberFormat.getNumberInstance();
		depthFormat = NumberFormat.getNumberInstance();
	}


	public class angleListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0, tree t)
		{
			double angleTemp = Double.valueOf(angleData.getText());
			t.setAngle(angleTemp);	
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			
		}
	}
	
	public class depthListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("redraw"))
			{
				int depthTemp = Integer.valueOf(depthData.getText());
				System.out.println(depthTemp);
				tree.setDepth(depthTemp);
				System.out.println(tree.getDepth() + " rip");
				depthVar = depthTemp;		
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	}
}

