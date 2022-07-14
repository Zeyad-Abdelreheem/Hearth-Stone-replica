package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;

public class startGame extends States implements ActionListener{
	private static final int WIDTH=1280;
	private static final int HEIGHT=960;
	private battleField battle;
	private Hero choice;
	private static BufferedImage img;
	
	public startGame() {
		super();
        draw();
		
	}
	public void draw() {
//		this.createBufferStrategy(1);
//		Graphics g=this.getBufferStrategy().getDrawGraphics();
//		File file=new File("res/Font/backGround.jpg");
//		BufferedImage img=null;
//		try{
//			img=ImageIO.read(file);
//		}catch(Exception e)
//		{
//			JOptionPane.showMessageDialog(null, "An ERROR Occured while loading the background please restart the game");
//			
//		}
//		this.setContentPane(new ImagePanel(img, this));
		
		File file=new File("res/Font/backGround.jpg");
		try{
			img=ImageIO.read(file);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "An ERROR Occured while loading the background please restart the game");
			
		}
	      this.setContentPane(new JPanel() {
	          @Override
	          public void paintComponent(Graphics g) {
	             super.paintComponent(g);
	             g.drawImage(img, 0, 0, null);
	          }
	       });
		this.setLayout(null);
		JPanel textPanel=new JPanel();
		JLabel out=new JLabel();
		out.setIcon(new ImageIcon("res/Font/startScreen .png"));
		out.setVisible(true);
		out.setOpaque(false);
		textPanel.add(out);
		textPanel.setOpaque(false);
		textPanel.setSize(1000, 180);
		textPanel.setLocation(100, 100);
		this.add(textPanel);
		
		
		Button player1=new Button("Hunter");
		player1.setActionCommand("Hunter");
		player1.setLocation(50, 400);
		player1.setSize(210,280);
		player1.setIcon(new ImageIcon("res/Font/Hunter.png"));
		player1.getJLabel().setIcon(new ImageIcon("res/Font/HunterFont.png"));
		player1.getJLabel().setLocation(50,700);
		
		
		Button player2=new Button("Mage");
		player2.setActionCommand("Mage");
		player2.setLocation(290, 400);
		player2.setSize(210,280);
		player2.setIcon(new ImageIcon("res/Font/Mage.jpg"));
		player2.getJLabel().setIcon(new ImageIcon("res/Font/MageFont.png"));
		player2.getJLabel().setLocation(290,700);
		
		
		
		Button player3=new Button("Warlock");
		player3.setActionCommand("Warlock");
		player3.setLocation(530, 400);
		player3.setSize(210,280);
		player3.setIcon(new ImageIcon("res/Font/Warlock.jpg"));
		player3.getJLabel().setIcon(new ImageIcon("res/Font/WarlockFont.png"));
		player3.getJLabel().setLocation(530,700);
		
		
		
		Button player4=new Button("Priest");
		player4.setActionCommand("Priest");
		player4.setLocation(770, 400);
		player4.setSize(210,280);
		player4.setIcon(new ImageIcon("res/Font/Priest.jpg"));
		player4.getJLabel().setIcon(new ImageIcon("res/Font/PriestFont.png"));
		player4.getJLabel().setLocation(770,700);
		
		
		
		Button player5=new Button("Paladin");
		player5.setActionCommand("Paladin");
		player5.setLocation(1010, 400);
		player5.setSize(210,280);
		player5.setIcon(new ImageIcon("res/Font/Paladin.jpg"));
		player5.getJLabel().setIcon(new ImageIcon("res/Font/PaladinFont.png"));
		player5.getJLabel().setLocation(1010,700);
		
		
		this.add(player1);
		this.add(player2);
		this.add(player3);
		this.add(player4);
		this.add(player5);
		
		this.add(player1.getJLabel());
		this.add(player2.getJLabel());
		this.add(player3.getJLabel());
		this.add(player4.getJLabel());
		this.add(player5.getJLabel());
		
		player1.addActionListener(this);
		player2.addActionListener(this);
		player3.addActionListener(this);
		player4.addActionListener(this);
		player5.addActionListener(this);
		
		
		
        this.revalidate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getActionCommand().contentEquals("Hunter"))
		{try {
			choice=new Hunter();
			
		} catch (Throwable e1) {
			
			JOptionPane.showMessageDialog(null, "Some problem occured ! please restart the game");
		    System.exit(0);	
		}
		}
		else
		if(e.getActionCommand().contentEquals("Mage"))
		{try {
			choice=new Mage();
		} catch (Throwable e1) {
			
			JOptionPane.showMessageDialog(null, "Some problem occured ! please restart the game");
		    System.exit(0);	
		}
		}
		else
		if(e.getActionCommand().contentEquals("Warlock"))
		{try {
			choice=new Warlock();
		} catch (Throwable e1) {
			
			JOptionPane.showMessageDialog(null, "Some problem occured ! please restart the game");
		    System.exit(0);	
		}
		}
		else
		if(e.getActionCommand().contentEquals("Paladin"))
		{try {
			choice=new Paladin();
		}catch (Throwable e1) {
			
			JOptionPane.showMessageDialog(null, "Some problem occured ! please restart the game");
		    System.exit(0);	
		}
		}
		else
		if(e.getActionCommand().contentEquals("Priest"))
		{try {
			choice=new Priest();
		} catch (Throwable e1) {
			
			JOptionPane.showMessageDialog(null, "Some problem occured ! please restart the game");
		    System.exit(0);	
		}
		}
		this.setVisible(false);	
	    battle=new battleField(choice);
	    
	}
	public Hero getChoice() {
	    return choice;	
	    }
	}
	
 

