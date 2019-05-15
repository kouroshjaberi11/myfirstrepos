import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class GUIKourosh implements ActionListener{
		//properties
	JFrame theframe;
	JPanel thepanel;
	
	JLabel P1Round;
	JLabel P1Grand;
	JLabel P2Round;
	JLabel P2Grand;
	JLabel Events;
	
	JButton P1pass;
	JButton P1roll;
	
	JButton P2pass;
	JButton P2roll;
	
	String strP1Round="";
	String strP1Grand="";
	String strP2Round = "";
	String strP2Grand = "";
	
	int intDice1=0;
	int intDice2=0;
	int intCounter=0;
	int intP1Round=0;
	int intP2Round=0;
	int intP1Grand=0;
	int intP2Grand=0;
	
	//methods
	public void actionPerformed(ActionEvent e) {
		if (intCounter%2==0) { //p1
			P2pass.setEnabled(false);
			P2roll.setEnabled(false);
			if (e.getSource() == P1pass) {
				P1pass.setEnabled(false);
				P1roll.setEnabled(false);
				P2pass.setEnabled(true);
				P2roll.setEnabled(true);
			}else if(e.getSource()==P1roll) {
				intDice1 = (int)(Math.random()*6+1);
				intDice2 = (int)(Math.random()*6+1);
				
				if (intDice1==intDice2) {
					Events.setText("You rolled a double: " + intDice1);
					intDice1 = 0;
					intDice2 = 0;
					intP1Round=0;
					intP1Grand=0;
					
					
					intCounter=0;
				}else{
					Events.setText("You rolled a " + intDice1 + " and a " + intDice2);
				}
				strP1Round=P1Round.getText();
				try {
					intP1Round=Integer.parseInt(strP1Round)+intP1Round;
				}catch(NumberFormatException q) {
					intP1Round=0;
				}
				intP1Round = intP1Round + intDice1 + intDice2;
			
				P1Round.setText("Round: " + intP1Round);
			
			}
			try {
				intP1Grand = Integer.parseInt(P1Grand.getText())+ intP1Grand;
			}catch (NumberFormatException w) {
				intP1Grand = 0;
			}
			P1Grand.setText("Grand: " + intP1Grand);
			
		}else { //p2
			P1pass.setEnabled(false);
			P1roll.setEnabled(false);
			if (e.getSource() == P2pass) {
				P2pass.setEnabled(false);
				P2roll.setEnabled(false);
				P1pass.setEnabled(true);
				P1roll.setEnabled(true);
			}else if(e.getSource()==P2roll) {
				intDice1 = (int)(Math.random()*6+1);
				intDice2 = (int)(Math.random()*6+1);
				
				if (intDice1==intDice2) {
					Events.setText("You rolled a double: " + intDice1);
					intDice1 = 0;
					intDice2 = 0;
					intP1Round=0;
					intP1Grand=0;
					
					
					intCounter=0;
				}else {
					Events.setText("You rolled a " + intDice1 + " and a " + intDice2);
				}
				strP2Round=P2Round.getText();
				try {
					intP2Round=Integer.parseInt(strP2Round) +intP2Round;
				}catch(NumberFormatException q) {
					intP2Round=0;
				}
				
			
				P2Round.setText("Round: " + intP2Round);
			
			}
			try {
				intP2Grand = Integer.parseInt(P2Grand.getText())+intP2Grand;
			}catch (NumberFormatException w) {
				intP2Grand = 0;
			}
			P2Grand.setText("Grand: " + intP2Grand);
		}
		if (intP2Grand==100) {
			System.out.println("Player 1 wins");
			//theframe.close();
		}else if(intP1Grand==100) {
			System.out.println("Player 2 wins");
			//theframe.close();
		}
			
	}
	
	//constructor
	public GUIKourosh() {
		theframe=new JFrame("GUIKourosh");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		thepanel = new JPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280,720));
		
		P1pass = new JButton("Pass");
		P1pass.setBounds(0,0,75,75);
		P1pass.addActionListener(this);
		
		P1roll = new JButton("Roll");
		P1roll.setBounds(0,80,75,75);
		P1roll.addActionListener(this);
		
		P2pass = new JButton("Roll");
		P2pass.setBounds(1205,0,75,75);
		P2pass.setEnabled(false);
		P2pass.addActionListener(this);
		
		P2roll = new JButton("Pass");
		P2roll.setBounds(1205,80,75,75);
		P2roll.setEnabled(false);
		P2roll.addActionListener(this);
		
		P1Round = new JLabel("Round: 0");
		P1Round.setBounds(0,170, 100, 10);
		
		P1Grand = new JLabel("Grand: 0");
		P1Grand.setBounds(0,200,100,10);
		
		P2Round = new JLabel("Round: 0");
		P2Round.setBounds(1100,170,100,10);
		
		P2Grand = new JLabel("Grand: 0");
		P2Grand.setBounds(1100,200,100,10);
		
		Events = new JLabel();
		Events.setBounds(400,300,800,10);
		
		thepanel.add(P1pass);
		thepanel.add(P1roll);
		thepanel.add(P2pass);
		thepanel.add(P2roll);
		thepanel.add(P1Round);
		thepanel.add(P1Grand);
		thepanel.add(P2Round);
		thepanel.add(P2Grand);
		thepanel.add(Events);
		
		
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setVisible(true);
	}
	//main
	public static void main (String[] args) {
		new GUIKourosh();
	}
}

//69
//hsdfgihirgierhg 
