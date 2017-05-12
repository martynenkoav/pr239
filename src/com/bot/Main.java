package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Triangle> triangles = new ArrayList<Triangle>();

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

        JButton button3 = new JButton("Считывание из файла");
        button3.setBounds(2,200,200,40);
        butPanel.add(button3);
        final JLabel Answer = new JLabel("Ответ:");
        Answer.setBounds(2,350,80,25);
        butPanel.add(Answer);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Scanner in = new Scanner(new File("input.txt"))) {
                    int n = in.nextInt();
                    for (int i = 0 ; i < n; i++) {
                        points.add(new Point(in.nextInt(), in.nextInt()));
                    }
                    in.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                for(int i=0;i<points.size();i++){
                    points.get(i).setBounds(points.get(i).x,points.get(i).y,points.get(i).x+3,points.get(i).y+3);
                    pointpane.add(points.get(i));
                    pointpane.revalidate();
                    pointpane.repaint();
                }
                System.out.println("Считывание из файла");
            }});


        JButton button4 = new JButton("Записывание в файл");
        button4.setBounds(2,250,200,40);
        butPanel.add(button4);
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Записывание в файл");
            }});


        JButton button5 = new JButton("Решение задачи");
        button5.setBounds(2,300,200,40);
        butPanel.add(button5);
        button5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<points.size();i++){
                    Point a=points.get(i);
                    if (a.isRmt()==false) {
                        for (int j=0;j<points.size();j++){
                            for (int k=0;k<points.size();k++){
                                Point b=points.get(j);
                                Point c=points.get(k);
                                Triangle tr=new Triangle(a,b,c);
                                if ((tr.isEquilateral())&&(!tr.isSame())){
                                    a.setRmt(true);
                                    int [] bounds = tr.getTrBounds();
                                    tr.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
                                    pointpane.add(tr);
                                    triangles.add(tr);
                                }
                            }
                        }
                    }
                }
                int cnt=0;
                for(int i=0;i<points.size();i++){
                    Point a=points.get(i);
                    if (a.isRmt()==false){
                        cnt++;
                    }
                }
                pointpane.revalidate();
                pointpane.repaint();
                if (cnt==0){
                    Answer.setText("Ответ:"+"Да");
                } else {
                    Answer.setText("Ответ:"+"Нет");
                }
            }});






        JButton button1 = new JButton("Добавить точку");
        button1.setBounds(2,100,200,40);
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
        JButton button2 = new JButton("Очистить");
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
                for (int i=0;i<triangles.size();i++){
                    while(triangles.size() > 0) {
                        int index = triangles.size() - 1;
                        Triangle triangle = triangles.remove(index);
                        pointpane.remove(triangle);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
                points.clear();
                triangles.clear();
            }
        });
        button2.setBounds(2,150,200,40);
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




