/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Gkquiz.java
 *
 * Created on Apr 23, 2015, 6:58:18 PM
 */
/**
 *
 * @author Yasha123
 */
import java.sql.*;
import java.util.*;
public class Gkquiz extends javax.swing.JFrame implements Runnable {

    /** Creates new form Gkquiz */
    int q; 
int res;
Thread t;
public final void questions()
    {
        p1.setValue(0);
    
        lbl1.setText("");
        lbl2.setText(null);
        try
{
    
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gk?user=root&password=");
 PreparedStatement ps=con.prepareStatement("select * from gkquiz where sno="+q);
        ResultSet rs=ps.executeQuery();
     
        while(rs.next())
        {
           lbl1.setText("Q. "+q+rs.getString(2)+"?");
           rbtn1.setText(rs.getString(4));
             rbtn2.setText(rs.getString(5));
               rbtn3.setText(rs.getString(6));
                 rbtn4.setText(rs.getString(7));
     //   System.out.println("Q1. "+rs.getString(2));
        }

}

catch(Exception e)
{
lbl1.setText("There is an error");
}
    }
    public Gkquiz() {
        initComponents();
        q=1;
        res=0;
        Data.zero();
        t=new Thread(this);
    t.start();
        questions();
    }
public void run()
{
while(true)
{
int a=p1.getValue();
p1.setValue(a+10);
if(p1.getValue()==100)
{
//    t.stop();
    Data.change(res);
   new leaderboard1().setVisible(true);// TODO add your handling code here:
this.setVisible(false);

t.stop();

break;
}
try
{
Thread.sleep(1000);
}
catch(Exception e)
{}

}
}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbl1 = new javax.swing.JLabel();
        rbtn1 = new javax.swing.JRadioButton();
        rbtn3 = new javax.swing.JRadioButton();
        rbtn2 = new javax.swing.JRadioButton();
        rbtn4 = new javax.swing.JRadioButton();
        p1 = new javax.swing.JProgressBar();
        btn_submit = new javax.swing.JButton();
        lbl2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(rbtn1);

        buttonGroup1.add(rbtn3);

        buttonGroup1.add(rbtn2);

        buttonGroup1.add(rbtn4);

        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(btn_submit)
                .addContainerGap(369, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                                .addComponent(rbtn2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(rbtn3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                                .addComponent(rbtn4)))
                        .addGap(207, 207, 207))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(426, Short.MAX_VALUE)
                .addComponent(lbl2)
                .addGap(334, 334, 334))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn1)
                    .addComponent(rbtn2))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn4)
                    .addComponent(rbtn3))
                .addGap(36, 36, 36)
                .addComponent(btn_submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl2)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
String choice="";
    if(rbtn1.isSelected())
        choice=rbtn1.getText();
    else if(rbtn2.isSelected())
        choice=rbtn2.getText();
    if(rbtn3.isSelected())
        choice=rbtn3.getText();
    if(rbtn4.isSelected())
        choice=rbtn4.getText();
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gk?user=root&password=");
 PreparedStatement ps=con.prepareStatement("select ans from gkquiz where sno="+q);
        ResultSet rs=ps.executeQuery();
    
        while(rs.next())
        {
        if(choice.equals(rs.getString(1)))
        {
            res++;
        lbl2.setText("Correct answer!!!");
        
        }
        else
        {
        lbl2.setText("Wrong answer!!!!");
        }
        q++;
        if(q==11)
        {
        Data.change(res);
        new leaderboard1().setVisible(true);// TODO add your handling code here:
this.setVisible(false);
        }
        else
            questions();
        
        }
    }
    catch(Exception e)
    {
    lbl1.setText("error");
    }// TODO add your handling code here:
}//GEN-LAST:event_btn_submitActionPerformed

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
            java.util.logging.Logger.getLogger(Gkquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gkquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gkquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gkquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Gkquiz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_submit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JProgressBar p1;
    private javax.swing.JRadioButton rbtn1;
    private javax.swing.JRadioButton rbtn2;
    private javax.swing.JRadioButton rbtn3;
    private javax.swing.JRadioButton rbtn4;
    // End of variables declaration//GEN-END:variables
}
