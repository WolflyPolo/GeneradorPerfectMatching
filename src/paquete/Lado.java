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
public class Lado {
    private Nodo nodo1;
    private Nodo nodo2;
    private int peso;
    private int vallado;

    public int getVallado() {
        return vallado;
    }

    public void setVallado(int vallado) {
        this.vallado = vallado;
    }

    public Lado(Nodo nodo1, Nodo nodo2, int peso) {
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
        this.peso = peso;
    }

    public Lado(Nodo nodo1, Nodo nodo2) {
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
    }
    
    public Nodo getNodo1() {
        return nodo1;
    }

    public void setNodo1(Nodo nodo1) {
        this.nodo1 = nodo1;
    }

    public Nodo getNodo2() {
        return nodo2;
    }

    public void setNodo2(Nodo nodo2) {
        this.nodo2 = nodo2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
   
    
}