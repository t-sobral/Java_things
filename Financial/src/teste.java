

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
//import javax.swing.border.Border;

public class teste{
//isto está a servir para testar a possibilidade de ter um GUI para as finanças
    public teste(){
        JFrame frame = new JFrame("Teste");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 200));
        BorderLayout borderLayoutManager = new BorderLayout();
		panel.setLayout(borderLayoutManager);
        
        JLabel label = new JLabel("Choose what you wish to do from a file:");
        panel.add(label, BorderLayout.PAGE_START);
        
        JButton button1 = new JButton("Calculate expenses"); //tentar fazer que o user de input do ficheiro que ele quer ler
        button1.setPreferredSize(new Dimension(200, 200));
        panel.add(button1,BorderLayout.LINE_START);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    firstAction();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton button2 = new JButton("Daily sum");
        button2.setPreferredSize(new Dimension(200, 200));
        panel.add(button2,BorderLayout.CENTER);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    secondAction();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    
        JButton button3 = new JButton("Total cost");
        button3.setPreferredSize(new Dimension(200, 200));
        panel.add(button3, BorderLayout.LINE_END);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    thirdAction();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

















        frame.add(panel);
        frame.setSize(600,600);
        frame.setVisible(true);
    
    }
    //------------------------------------------------------------------------------------------------------

    
    public static void firstAction() throws FileNotFoundException {
        Read leitor = new Read();
        HashMap<String,ArrayList<Float>> storedData = leitor.dataGather("input.csv");
        System.out.println(storedData);
    }

    private static void secondAction() throws FileNotFoundException{
        Read leitor = new Read();
        HashMap<String,ArrayList<Float>> storedData = leitor.dataGather("input.csv");
        leitor.somaDiaria(storedData, "11/3/25");
    }

    private static void thirdAction() throws FileNotFoundException{
        Read leitor = new Read();
        HashMap<String,ArrayList<Float>> storedData = leitor.dataGather("input.csv");
        System.out.println(leitor.custoTotal(storedData));
    }





    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        new teste();
    }
}

