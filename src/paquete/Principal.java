/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ColombiaWP
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    int id;
    ArrayList<Nodo> marked;
    Graphics g;
    ArrayList<Nodo> nodos;
    ArrayList<Lado> lados;
    int mat[][];

    public Principal() {
        initComponents();
        id = 0; //Para enumerar los nodos.
        g = getGraphics();
        nodos = new ArrayList(); //Aqui se genera A.
        marked = new ArrayList();
        lados = new ArrayList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPPM - Samuel Polo");

        jLabel1.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel1.setText("Generador de Partición Perfecta de Emparejamiento - Samuel Polo");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 630));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        jLabel2.setText("Digite un número para generar un grafo: ");

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar Grafo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reiniciar Grafo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Partición Perfecta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addComponent(jButton4)
                .addGap(36, 36, 36)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private long DistanciaE(Nodo nodo1, Nodo nodo2) {
        int xactual;
        int yactual;
        int x2x1;
        int y2y1;
        int a;
        int b;
        long decu;
        int xpivote = nodo1.getPosx0();
        int ypivote = nodo1.getPosy0();
        xactual = nodo2.getPosx0();
        yactual = nodo2.getPosy0();
        x2x1 = (xactual - xpivote);
        y2y1 = (yactual - ypivote);
        a = (int) (Math.pow(x2x1, 2));
        b = (int) (Math.pow(y2y1, 2));
        decu = ((int) Math.sqrt((a + b)));
        //System.out.println("D EUCLIDIANA: " + decu);
        //System.out.println(Integer.parseInt(nodo1.getEtiqueta()));
        //System.out.println(Integer.parseInt(nodo2.getEtiqueta()));
        mat[nodo1.getId()][nodo2.getId()] = (int) decu;
        mat[nodo2.getId()][nodo1.getId()] = (int) decu;
        return decu;
    }
    
    private int[][] MatrizAdyacencia() {
        int MatrizAd[][] = new int[nodos.size()][nodos.size()];
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.size(); j++) {
                MatrizAd[i][j] = 0;
            }
        }
        for (int i = 0; i < lados.size(); i++) {
            MatrizAd[lados.get(i).getNodo1().getId()][lados.get(i).getNodo2().getId()] = 1;
            MatrizAd[lados.get(i).getNodo2().getId()][lados.get(i).getNodo1().getId()] = 1;
        }
        return MatrizAd;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Generar Grafo
        if (!"".equals(jTextField1.getText())) {
            Random rand = new Random();
            int n = Integer.parseInt(jTextField1.getText());
            mat = new int[n][n];
            int ancho = jPanel1.getSize().width;
            int alto = jPanel1.getSize().height;
            System.out.println("ancho: " + ancho);
            System.out.println("alto: " + alto);
            //CREACIÓN DE NODOS
            for (int i = 0; i < n; i++) {
                int posx0 = rand.nextInt(ancho - 100) + 75;
                int posy0 = rand.nextInt(alto - 50) + 75;
                int posx1 = posx0 - 15; //Posiciones de lado X anterior al centro.
                int posy1 = posy0 - 15; //Posiciones de lado Y anterior al centro.
                if (i == 0) {
                    nodos.add(new Nodo(id, posx0, posy0, posx1, posy1, posx1 + 30, posy1 + 30, false));
                    id++;
                } else {
                    Nodo nodo = new Nodo(id, posx0, posy0, posx1, posy1, posx1 + 30, posy1 + 30, false);
                    id++;
                    //while (VerificaEspacio(n) == false) {
                    //n.setPos(rand.nextInt(ancho - 100) + 50, rand.nextInt(alto - 100) + 50);
                    //}
                    nodos.add(nodo);
                }
            }
            //CREACIÓN DE ARISTAS
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    Lado a = new Lado(nodos.get(i), nodos.get(j), 50);
                    lados.add(a);
                }
            }
            for (int i = 0; i < nodos.size(); i++) {
                g.setColor(Color.RED);
                //g.drawOval(nodos.get(i).getPosx0(), nodos.get(i).getPosy0(), 30, 30);
                nodos.get(i).DibujarVertice(g);
            }
            for (int i = 0; i < lados.size(); i++) {
                g.setColor(Color.BLACK);
                g.drawLine(lados.get(i).getNodo1().getPosx0(), lados.get(i).getNodo1().getPosy0(), lados.get(i).getNodo2().getPosx0(), lados.get(i).getNodo2().getPosy0());
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR! Debe escribir un número.",
                    "Aviso!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel1.getGraphics().clearRect(1, 1, jPanel1.getWidth() - 2, jPanel1.getHeight() - 2);
        id = 0;
        lados.clear();
        nodos.clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ReiniciarGrafo() {
        for (int i = 0; i < lados.size(); i++) {
            g.setColor(Color.BLACK);
            g.drawLine(lados.get(i).getNodo1().getPosx0(), lados.get(i).getNodo1().getPosy0(), lados.get(i).getNodo2().getPosx0(), lados.get(i).getNodo2().getPosy0());
        }
    }
   
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ReiniciarGrafo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Primero detectamos que se exista un perfect matching.
        ReiniciarGrafo();
        /*
        int a[][] = MatrizAdyacencia();
        int b[][] = new int[nodos.size()][nodos.size()];
        //Creación de Matrix de Tutte.
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.size(); j++) {
                if (i < j) {
                    b[i][j] = a[i][j];
                } else {
                    if (i > j) {
                        b[i][j] = -1 * a[j][i];
                    } else {
                        b[i][j] = 0;
                    }
                }
            }
        }
        */
        /*
        System.out.println("MATRIZ DE TUTTE:");
        for (int x = 0; x < b.length; x++) {
            System.out.print("|");
            for (int y = 0; y < b[x].length; y++) {
                System.out.print(b[x][y]);
                if (y != b[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
        */
        int valor = nodos.size();    
        if (valor%2!=0) {
    JOptionPane.showMessageDialog(null, "Error: no existe un emparejamiento perfecto para este grafo. El número de nodos del grafo debe ser par.", 
    "AVISO!", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<Lado> matching = new ArrayList<Lado>();
            //Como existe un perfect matching, se procede a buscar uno.
            int valor1 = 0; //Estos serán los valores de grado de los nodos.
            int valor2 = 0;
            for (int i = 0; i < lados.size(); i++) {
                valor1 = lados.get(i).getNodo1().getValencia();
                valor2 = lados.get(i).getNodo2().getValencia();
                lados.get(i).setVallado(valor1 + valor2);
            }
            Lado buscado = MenorLado(lados);
            matching.add(buscado);
            ArrayList<Lado> copialados = new ArrayList();
            for (int i = 0; i < lados.size(); i++) {
                copialados.add(lados.get(i));
            }
            for (int j = 0; j < lados.size(); j++) {
                if (lados.get(j).getNodo1() == buscado.getNodo1() || lados.get(j).getNodo2() == buscado.getNodo2() || lados.get(j).getNodo1() == buscado.getNodo2() || lados.get(j).getNodo2() == buscado.getNodo1()) {
                    System.out.println("Se ha debido quitar el lado que une a los nodos:  " + lados.get(j).getNodo1().getId() + "," + lados.get(j).getNodo2().getId());
                    copialados.remove(lados.get(j));
                }
            }
            copialados.remove(buscado);
            while (copialados.isEmpty() == false) {
                buscado = MenorLado(copialados);
                matching.add(buscado);
                for (int j = 0; j < lados.size(); j++) {
                    if (lados.get(j).getNodo1() == buscado.getNodo1() || lados.get(j).getNodo2() == buscado.getNodo2() || lados.get(j).getNodo1() == buscado.getNodo2() || lados.get(j).getNodo2() == buscado.getNodo1()) {
                        copialados.remove(lados.get(j));
                        System.out.println("Se ha debido quitar el lado: " + lados.get(j).getPeso());
                    }
                }
                copialados.remove(buscado);
            }
            jPanel1.getGraphics().clearRect(1, 1, jPanel1.getWidth() - 2, jPanel1.getHeight() - 2);
            for (int i = 0; i < nodos.size(); i++) {
                g.setColor(Color.RED);
                nodos.get(i).DibujarVertice(g);
            }
            for (int i = 0; i < matching.size(); i++) {
                g.setColor(Color.YELLOW);
                g.drawLine(matching.get(i).getNodo1().getPosx0(), matching.get(i).getNodo1().getPosy0(), matching.get(i).getNodo2().getPosx0(), matching.get(i).getNodo2().getPosy0());
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private Lado MenorLado(ArrayList<Lado> arreglo) {
        int menor = 9999;
        Lado lmenor = null;
        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).getVallado() < menor) {
                menor = arreglo.get(i).getVallado();
                lmenor = arreglo.get(i);
            }
        }
        return lmenor;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
