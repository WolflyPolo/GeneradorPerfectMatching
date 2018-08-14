/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

/**
 *
 * @author ColombiaWP
 */
import java.awt.Color;
import java.awt.Graphics;

public class Nodo {
    private int id; //Número del nodo.
    private int posx0; //Posición del click en X.
    private int posy0; //Posición del click en Y.
    private int posx1; //Posición inicial del diámetro del óvalo pos X.
    private int posy1; //Posición inicial del diámetro del óvalo pos Y.
    private int posx2; //Posición final del diámetro del óvalo pos X.
    private int posy2; //Posición final del diámetro del óvalo pos Y.
    private int valencia;
    private boolean isMarked;

    public int getValencia() {
        return valencia;
    }

    public void setValencia(int valencia) {
        this.valencia = valencia;
    }

    public Nodo(int id, int posx0, int posy0) {
        this.id = id;
        this.posx0 = posx0;
        this.posy0 = posy0;
    }

    
    
    public Nodo(int id, int posx0, int posy0, int posx1, int posy1, int posx2, int posy2, boolean isMarked) {
        this.id = id;
        this.posx0 = posx0;
        this.posy0 = posy0;
        this.posx1 = posx1;
        this.posy1 = posy1;
        this.posx2 = posx2;
        this.posy2 = posy2;
        this.isMarked = isMarked;
    }

    public Nodo(int id, int posx0, int posy0, boolean isMarked) {
        this.id = id;
        this.posx0 = posx0;
        this.posy0 = posy0;
        this.isMarked = isMarked;
    }
    
    public int getPosx0() {
        return posx0;
    }

    public void setPosx0(int posx0) {
        this.posx0 = posx0;
    }

    public int getPosy0() {
        return posy0;
    }

    public void setPosy0(int posy0) {
        this.posy0 = posy0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getPosx1() {
        return posx1;
    }

    public void setPosx1(int posx1) {
        this.posx1 = posx1;
    }

    public int getPosy1() {
        return posy1;
    }

    public void setPosy1(int posy1) {
        this.posy1 = posy1;
    }

    public int getPosx2() {
        return posx2;
    }

    public void setPosx2(int posx2) {
        this.posx2 = posx2;
    }

    public int getPosy2() {
        return posy2;
    }

    public void setPosy2(int posy2) {
        this.posy2 = posy2;
    }

    public boolean isIsMarked() {
        return isMarked;
    }

    public void setIsMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }

    public void DibujarVertice(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(posx1, posy1, 30, 30); //Dibuja el óvalo con centro donde se hizo el click.
        DibujarNumero(g);
    }
    
    public void DibujarNumero(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(id), posx0-2, posy0+2); //Dibuja el id del nodo.
    }
    
    public void CambiaMarcador(){
        if (this.isMarked == true) {
            this.isMarked = false;
        }else {
            this.isMarked = true;
        }
    }
}