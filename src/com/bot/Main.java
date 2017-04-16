package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    public static void createGUI() {
        final JFrame frame = new JFrame("Testframe");
	    frame.setPreferredSize(new Dimension(700,700));
	    JPanel panel = new JPanel(new BorderLayout());
        Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250,700));
        final Panel pointpane   = new Panel();
        pointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

	    JLabel addPointwithCoords = new JLabel("Добавить точку по координатам");
	    addPointwithCoords.setBounds(2,2,300,25);
	    butPanel.add(addPointwithCoords);
	    JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек");
	    addRandomPoints.setBounds(2,50,300,25);
	    butPanel.add(addRandomPoints);
        JLabel X = new JLabel("X:");
        X.setBounds(2,25,15,25);
        butPanel.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45,25,15,25);
        butPanel.add(Y);
        JLabel N = new JLabel("NUM:");
        N.setBounds(2,70,30,25);
        butPanel.add(N);
        final JTextField x = new JTextField();
        x.setBounds(17,25, 25,25);
        butPanel.add(x);
        final JTextField y = new JTextField();
        y.setBounds(60,25, 25,25);
        butPanel.add(y);
        final JTextField n = new JTextField();
        n.setBounds(35,70,25,25);
        butPanel.add(n);
        JLabel addTrianglewithCoords = new JLabel("Добавить треугольник по координатам");
        addTrianglewithCoords.setBounds(2,200,300,25);
        butPanel.add(addTrianglewithCoords);
        JLabel X1 = new JLabel("X:");
        X1.setBounds(2,225,15,25);
        butPanel.add(X1);
        JLabel Y1 = new JLabel("Y:");
        Y1.setBounds(45,225,15,25);
        butPanel.add(Y1);
        JLabel X2 = new JLabel("X:");
        X2.setBounds(2,265,15,25);
        butPanel.add(X2);
        JLabel Y2 = new JLabel("Y:");
        Y2.setBounds(45,265,15,25);
        butPanel.add(Y2);
        JLabel X3 = new JLabel("X:");
        X3.setBounds(2,300,15,25);
        butPanel.add(X3);
        JLabel Y3 = new JLabel("Y:");
        Y3.setBounds(45,300,15,25);
        butPanel.add(Y3);
        final JTextField x1 = new JTextField();
        x1.setBounds(17,225, 25,25);
        butPanel.add(x1);
        final JTextField y1 = new JTextField();
        y1.setBounds(60,225, 25,25);
        butPanel.add(y1);
        final JTextField x2 = new JTextField();
        x2.setBounds(17,265, 25,25);
        butPanel.add(x2);
        final JTextField y2 = new JTextField();
        y2.setBounds(60,265, 25,25);
        butPanel.add(y2);
        final JTextField x3 = new JTextField();
        x3.setBounds(17,300, 25,25);
        butPanel.add(x3);
        final JTextField y3 = new JTextField();
        y3.setBounds(60,300, 25,25);
        butPanel.add(y3);


        JButton button3 = new JButton("Добавить треугольник");
        button3.setBounds(2,340,160,40);
        butPanel.add(button3);




        JButton button1 = new JButton("Добавить точку");
        button1.setBounds(2,100,160,40);
        butPanel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int X = (!x.getText().equals("")?Integer.parseInt(x.getText()):0);
                int Y= (!y.getText().equals("")?Integer.parseInt(y.getText()):0);
                int N = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                if ((X>0)&&(Y>0)) {
                    Point b = new Point(X, Y);
                    points.add(b);
                    b.setBounds(b.x,b.y,b.x+3,b.y+3);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                }
                else {
                    if (N>0){
                        for (int i=0;i<N;i++){
                            Point b = new Point((int)(Math.random()*(frame.getWidth()-250)), (int)(Math.random()*frame.getHeight()));
                            points.add(b);
                            b.setBounds(b.x,b.y,b.x+3,b.y+3);
                            pointpane.add(b);
                            pointpane.revalidate();
                            pointpane.repaint();
                        }
                    }
                }

            }
        });
        JButton button2 = new JButton("очистить");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<points.size();i++){
                    while(points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
            }
        });
        button2.setBounds(2,150,160,40);
        butPanel.add(button2);
        panel.add(pointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
