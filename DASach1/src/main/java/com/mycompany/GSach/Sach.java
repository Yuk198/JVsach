/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.GSach;

/**
 *
 * @author FRAKE THE
 */
public class Sach extends Tailieu {
    private int NamXB;
    private int GiaB;

    public Sach() {
    	super();
    }

    public Sach(int MaS, String TenS, int NamXB, int GiaB) {
    	super(MaS, TenS);
    	this.NamXB = NamXB;
    	this.GiaB = GiaB;
    }

    public int getNamXB() {
    	return NamXB;
    }

    public void setNamXB(int NamXB) {
    	this.NamXB = NamXB;
    }

    public int getGiaB() {
    	return GiaB;
    }

    public void setGiaB(int GiaB) {
    	this.GiaB = GiaB;
    }
  
    @Override
    public int Thanhtien() {
    	if (NamXB < 2015) {
        	return this.GiaB * 85 / 100;
	} else {
    		return this.GiaB * 95 / 100;
    	}
    }
}
