/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GSach;

import java.sql.*;
import java.util.Vector;

/**
 *
 * @author FRAKE THE
 */
public class XLSach {
    public Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java01", "root", "");
            return conn;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public Vector<Vector<String>> getSA(){
        try{
            Vector<Vector<String>> vs = new Vector<Vector<String>>();
            Connection conn = getCon();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbsach");
            while (rs.next()){
                Vector<String> it = new Vector<String>();
                Sach tt = new Sach(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));         
                it.add(String.valueOf(rs.getInt(1)));
                it.add(rs.getString(2));
                it.add(String.valueOf(rs.getInt(3)));
                it.add(String.valueOf(rs.getInt(4)));
                it.add(String.valueOf(tt.Thanhtien()));
                vs.add(it);
            } 
            conn.close();
            return vs;
        } catch (Exception e){
            return null;
        }
    }
    
    public boolean deleteSA(int NamXB){
        try{
            Connection conn = getCon();
            conn.createStatement().execute("DELETE FROM tbsach WHERE NamXB = " + String.valueOf(NamXB));
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
