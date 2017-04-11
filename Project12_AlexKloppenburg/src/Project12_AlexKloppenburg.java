/*
 * Project 11
 * Alex Kloppenburg with partner Kevin Le
 * Nov. 8, 2016
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Project11_AlexKloppenburg extends JPanel{
	
	//Can change this constant
	private static final int SIZE = 300;
	
	public static void main(String[] args){
		
		//Title String, can be changed
		JFrame frame = new JFrame("stick man");
		
		//Don't change this
		JPanel panel = new Project11_AlexKloppenburg();
		
		//Can change this
		frame.setSize(SIZE, SIZE);
		
		//Don't change this
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		
		//Do not change
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//Our code goes here
		
		//Draws head, initialized in upper left hand corner
		Ellipse2D.Double head = new Ellipse2D.Double(0,0, 51, 51);
		g2d.setColor(Color.BLACK);
		head.isEmpty();		//Instance method 1
		g2d.draw(head);
		
		//Creates body of length 50 (torso)
		Line2D.Double body = new Line2D.Double(26, 51, 26, 121);
		g2d.setColor(Color.BLACK);
		g2d.draw(body);
		
		//Creates another line of length 30 as part of the "pants"
		Line2D.Double body2 = new Line2D.Double(26, 121, 26, 131);
		g2d.setColor(Color.ORANGE);
		g2d.draw(body2);
		
		//Creates left arm going diagonally up and to the left
		Line2D.Double leftArm = new Line2D.Double(26, 90, 0, 60);
		g2d.setColor(Color.BLACK);
		g2d.getPaint();		//Graphics method 1
		g2d.draw(leftArm);
		
		//Creates right arm going diagonally up and to the right
		Line2D.Double rightArm = new Line2D.Double(26, 90, 55, 60);
		g2d.setColor(Color.BLACK);
		g2d.draw(rightArm);
		
		//Creates left leg going diagonally down and to the left (with red pants
		Line2D.Double leftLeg = new Line2D.Double(26, 131, 0, 160);
		g2d.setColor(Color.ORANGE);
		g2d.draw(leftLeg);
		
		//Creates right leg going diagonally down and to the right (with red pants)
		Line2D.Double rightLeg = new Line2D.Double(26, 131, 55, 160);
		rightLeg.getX1();	//instance method 2
		g2d.setColor(Color.ORANGE);
		g2d.draw(rightLeg);
		
		//Creates two eyes and colors them blue
		Rectangle2D.Double leftEye = new Rectangle2D.Double(15, 17, 5, 5);
		Rectangle2D.Double rightEye = new Rectangle2D.Double(32, 17, 5, 5);
		g2d.setColor(Color.BLUE);
		leftEye.toString();		//Instance method 3
		g2d.fill(leftEye);		//Graphics method 2
		g2d.fill(rightEye);
		
		//Creates a smile upside down and then flips it
		Line2D.Double smile1 = new Line2D.Double(16, 31, 24, 35);
		g2d.translate(2,3);		//Graphics method 3
		Line2D.Double smile2 = new Line2D.Double(24, 35, 32, 31);
		g2d.setColor(Color.BLACK);
		g2d.draw(smile1);
		g2d.draw(smile2);
	}
}
