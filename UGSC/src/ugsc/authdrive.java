/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugsc;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static ugsc.UGSC.oldListRoot;

/**
 *
 * @author ojasd
 */
public class authdrive extends javax.swing.JFrame {

    /**
     * Creates new form authdrive
     */
    public authdrive() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        P1 = new javax.swing.JPanel();
        piclabel = new javax.swing.JLabel();
        L1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        P1.setBackground(new java.awt.Color(51, 51, 51));
        P1.setForeground(new java.awt.Color(255, 255, 255));

        piclabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        piclabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ugsc/Pdrive.gif"))); // NOI18N

        L1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        L1.setForeground(new java.awt.Color(255, 204, 0));
        L1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L1.setText("Please Connect USB Key");
        L1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout P1Layout = new javax.swing.GroupLayout(P1);
        P1.setLayout(P1Layout);
        P1Layout.setHorizontalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P1Layout.createSequentialGroup()
                .addGroup(P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(piclabel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(P1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(L1)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        P1Layout.setVerticalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(piclabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
Thread t;
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        t = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (File.listRoots().length > oldListRoot.length) {
                    System.out.println("new drive detected");
                    authdrive m = new authdrive();
                    oldListRoot = File.listRoots();
                    System.out.println("drive"+oldListRoot[oldListRoot.length-1]+" detected");
                    String path = ""+oldListRoot[oldListRoot.length-1];
                    System.out.println(path);
                    L1.setForeground(Color.ORANGE);
                    String message = "        Drive Detected";
                    slowPrint(message);
                    givePause();
                    L1.setForeground(Color.white);
                    ImageIcon image = new ImageIcon(this.getClass().getResource("loading.gif"));
                    piclabel.setIcon(image);
                    message = "         Authenticating";
                    slowPrint(message);
                    givePause();
                    boolean ans = false;
                    try{
                        ans=certverifier(path);
                    } catch (Exception ex){
                        System.out.println(ex);
                    }
                    if(ans==true){
                       L1.setForeground(Color.CYAN);
                       message = "        Authenticated";
                       slowPrint(message);
                       image = new ImageIcon(this.getClass().getResource("Tick.gif"));
                       piclabel.setIcon(image);
                       givePause();
                       dispose();
                       UI ui = new UI();
                       ui.setVisible(true);
                      
                    }
                    else{
                        L1.setForeground(Color.red);
                       message = "  Authentication Failed";
                       slowPrint(message);
                       image = new ImageIcon(this.getClass().getResource("X.gif"));
                       piclabel.setIcon(image);
                    }
                } else if (File.listRoots().length < oldListRoot.length) {
    System.out.println(oldListRoot[oldListRoot.length-1]+" drive removed");
    System.exit(0);
                    oldListRoot = File.listRoots();
                }
            }
        }
    });
    t.start();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(authdrive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(authdrive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(authdrive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(authdrive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new authdrive().setVisible(true);
            }
        });
}
    public void slowPrint(String message) { 
        L1.setText("");
        L1.setAlignmentX(CENTER_ALIGNMENT);
        L1.setAlignmentY(CENTER_ALIGNMENT);
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            L1.setText(L1.getText() + String.valueOf(message.charAt(i)));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }     
    }
    public void givePause(){
        try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    public boolean certverifier(String path) throws Exception{
            String ss = null;
        File file = new File(path+"\\key.cert");
        var dest = new File(path+"\\key.txt");
        var source = new File(path+"\\key.cert");
        if(file.exists()){
            Files.copy(source.toPath(),dest.toPath());
            File files = new File(path+"\\key.txt");
            Scanner sc = new Scanner(files);
            while (sc.hasNextLine())
                ss=sc.nextLine();
            sc.close();
            files.delete();
            if(ss.contains("ais")){
                return true;
            }
            else{
                return false;
            }
            }
            else{
                return false;
            }   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel L1;
    public static javax.swing.JPanel P1;
    private javax.swing.JLabel piclabel;
    // End of variables declaration//GEN-END:variables
}
