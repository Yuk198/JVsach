/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GSach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FRAKE THE
 */
public class GUI_delSA extends JFrame{
    JTable tb;
    
    public GUI_delSA(){
        setTitle("Xoa Sach");
        setSize(550,250);
        setResizable(rootPaneCheckingEnabled);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String[] nxb = {"2019","2020","2021"};
        JComboBox<String> cb = new JComboBox<String>(nxb);
        cb.setBounds(120,20,60,20);
        add(cb);
        
        JButton bt = new JButton("Xoa sach");
        bt.setBounds(20, 60, 100, 20);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JOptionPane pn = new JOptionPane();
                try {
                    XLSach xls = new XLSach();
        //          pn.showMessageDialog(getContentPane(), nxb[cb.getSelectedIndex()]);
                    xls.deleteSA(Integer.parseInt(nxb[cb.getSelectedIndex()]));
                    pn.showMessageDialog(getContentPane(), "Xoa thanh cong");
                    DefaultTableModel md = (DefaultTableModel) tb.getModel();
                    md.setColumnCount(0);
                    setModel(md);
                } catch (Exception ex) {
                    pn.showMessageDialog(getContentPane(), "Xoa khong thanh cong");
                }
            }
	});
	add(bt);

	configTable();
	}

	private void configTable() {
		DefaultTableModel md = new DefaultTableModel();
		setModel(md);
		tb = new JTable(md);

		JScrollPane sr = new JScrollPane(tb);
		sr.setBounds(200, 20, 300, 150);
		add(sr);
	}

	private void setModel(DefaultTableModel md) {
		Vector<String> cols = new Vector<String>();
		cols.add("Ma sach");
		cols.add("Ten sach");
		cols.add("Nam xuat ban");
		cols.add("Gia ban");
                cols.add("Thanh tien");

		md.setDataVector(new XLSach().getSA(), cols);

	}
    
    public static void main(String[] args) {
	new GUI_delSA().setVisible(true);
    }
}
