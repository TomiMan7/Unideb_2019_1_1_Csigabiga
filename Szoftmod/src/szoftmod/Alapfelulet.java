/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szoftmod;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Evelin
 */
public class Alapfelulet extends JFrame{
    JPanel tarolohely;
    JButton tesztgomb;
    JComboBox lenyilo;
    JComboBox szabadlenyilo;
    JTextArea receptekhelye;
    //FlowLayout flo;
    //GridBagLayout grid;
    GroupLayout gl;
    
    public Alapfelulet(){
       //super("Digitális receptválogatás");
       /*this.setSize(500, 500);
       tarolohely = (JPanel)this.getContentPane();
       flo = new FlowLayout();
       tarolohely.setLayout(flo);
       
       lenyilolista = new JScrollPane();
       gomb = new JButton("ez egy gomb");
       lista = new JComboBox();
       //lista2 = new JList();
       //gorgeto = new JScrollBar();
       
       tarolohely.add(lenyilolista);
       tarolohely.add(gomb);
       tarolohely.add(lista);
       //tarolohely.add(lista2);
       //tarolohely.add(gorgeto);
       super.setVisible(true);*/
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setSize(800,600);
		
	tarolohely = (JPanel)this.getContentPane();

        //JPanel panel = new JPanel();
	gl = new GroupLayout(tarolohely);
	tarolohely.setLayout(gl);
        //GridBagConstraints gbc = new GridBagConstraints();
        //gl.setAutoCreateGaps(true);
        //gl.setAutoCreateContainerGaps(true);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
	tesztgomb = new JButton("Teszt ha valami nem mukodne");
	lenyilo = new JComboBox();
	lenyilo.addItem("Magyaros");
	lenyilo.addItem("Olaszos");

	szabadlenyilo = new JComboBox();
	szabadlenyilo.setEditable(true);

	receptekhelye = new JTextArea(20,20);

        //gbc.gridx = 0;
        //gbc.gridy = 0;
	tarolohely.add(tesztgomb);
        //gbc.gridx= 1;
        //gbc.gridy = 0;
	tarolohely.add(lenyilo);
        /*gbc gridx = 2;
        gbc gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
	tarolohely.add(szabadlenyilo, gbc);
        gbc gridx = 0;
        gbc gridy = 2;
        gbc.gridwidth = 2;
	tarolohely.add(receptekhelye, gbc);*/
        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(tesztgomb).addComponent(lenyilo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(gl.createSequentialGroup().addGroup(gl
                        .createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(szabadlenyilo).addComponent(receptekhelye))));
        gl.setVerticalGroup(
                gl.createSequentialGroup().addComponent(tesztgomb).addComponent(lenyilo).addComponent(szabadlenyilo).addComponent(receptekhelye));

        //this.add(panel);
        //this.pack();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	super.setVisible(true);
       
    }
}
