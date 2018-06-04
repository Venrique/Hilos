/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import threads.AnimalThread;


/**
 *
 * @author LN710Q
 */
public class Gui extends JFrame{
    private JLabel [] labels;
    public static JButton inicio,reiniciar;
    private String[] nombres = {"canguro","tortuga","dragon"};
    
    public Gui(){
        super("Carrerra de animales");
        initialComponents();
    }
    
    public void initialComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        labels = new JLabel[3];
        inicio = new JButton("Inicio");
        reiniciar = new JButton("Reiniciar");
        Container container = getContentPane();
        
        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
            labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(labels[i]);
        }
        inicio.setBounds(10, 0, 100, 30);
        container.add(inicio);
        reiniciar.setBounds(580,0,100,30);
        container.add(reiniciar);
        reiniciar.setVisible(false);
       
        
        inicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AnimalThread canguro = new AnimalThread("canguro",labels[0].getX(),labels[0].getY(),510,labels[0]);
                AnimalThread tortuga = new AnimalThread("tortuga",labels[1].getX(),labels[1].getY(),510,labels[1]);
                AnimalThread dragon = new AnimalThread("dragon",labels[2].getX(),labels[2].getY(),510,labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
                
                
            }
        });
        
        
        
        reiniciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                reiniciar.setVisible(false);
                labels[0].setBounds(10, 0, 200, 200);
                labels[1].setBounds(10, 230, 200, 200);
                labels[2].setBounds(10, 450, 200, 200);
               
            }
        });
        setSize(700,650);
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Gui().setVisible(true);
            }
        });
    }
    
    public JButton getReiniciar(){
        return reiniciar;
    }
}


