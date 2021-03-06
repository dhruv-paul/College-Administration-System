
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dhruv Paul
 */
public class Teacher extends javax.swing.JFrame {

    public static String name,userid;
    /**
     * Creates new form Teacher
     */
    public Teacher() {
        initComponents();
    }
    public Teacher(String usern,String nm) {
        try {
            initComponents();
            Ndisplay.setText(""+nm);
            name=nm;
            userid=usern;
            String fulldt="",full,dt="",mon="",y="",hbddt="";
            char temp=' ';
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","cam","project");
            Statement stat = con.createStatement();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            full =cal.getTime().toString();
            for(int i=8;i<=9;i++) {
                temp = full.charAt(i);
                dt += temp;
            }
            fulldt= fulldt+dt+"-";
            for(int i=4;i<=6;i++) {
                temp =  full.charAt(i);
                mon += temp;
            }
            hbddt=fulldt+mon;
            fulldt= fulldt+mon+"-";
            for(int i=24;i<=27;i++) {
                temp =  full.charAt(i);
                y += temp;
            }
            fulldt= fulldt+y;
            ResultSet rs= stat.executeQuery("select * from attendance where loginid='"+userid+"' and adate='"+fulldt+"'");
            if (rs.next()) {
                AttendanceL.setText("YES");
            } else {
                AttendanceL.setText("NO");
            }
            rs = stat.executeQuery("select dob from details where loginid='"+userid+"'");
            if (rs.next()) {
                String dob="",dobc;
                dob=rs.getString(1);
                int m;
                dt="";
                mon="";
                for(int i=8;i<=9;i++) {
                    temp= dob.charAt(i);
                    dt += temp;
                }
                dobc=dt+"-";
                for(int i=5;i<=6;i++) {
                    temp= dob.charAt(i);
                    mon += temp;
                }
                m=Integer.parseInt(mon);
                if (mon.equals("08")) {
                    mon= "Aug";
                } else if (mon.equals("09")) {
                    mon= "Sep";
                } else {
                    switch (m) {
                    case 01 : mon="Jan";
                                break;
                    case 02 :   mon="Feb";
                                break;
                    case 03 :   mon="Mar";
                                break;
                    case 04 :   mon="Apr";
                                break;
                    case 05 :   mon="May";
                                break;
                    case 06 :   mon="Jun";
                                break;
                    case 07 :   mon="Jul";
                                break;
                    case 10 :   mon="Oct";
                                break;
                    case 11 :   mon="Nov";
                                break;
                    case 12 :   mon="Dec";
                                break;
                    }   
                }
                
                if (dobc.equalsIgnoreCase(hbddt)) {
                    Hbd.setText("Happy Birthday !!");
                    Hbd.setVisible(true);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutb = new javax.swing.JButton();
        Checkattendance = new javax.swing.JButton();
        Salary = new javax.swing.JButton();
        Assignments = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Ndisplay = new javax.swing.JLabel();
        Modifyinfo = new javax.swing.JButton();
        Viewstudent = new javax.swing.JButton();
        Changepass = new javax.swing.JButton();
        Makeattendance = new javax.swing.JButton();
        AttendanceL = new javax.swing.JTextField();
        Hbd = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logoutb.setText("Logout");
        logoutb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbActionPerformed(evt);
            }
        });

        Checkattendance.setText("Check Attendance");
        Checkattendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckattendanceActionPerformed(evt);
            }
        });

        Salary.setText("Salary");
        Salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaryActionPerformed(evt);
            }
        });

        Assignments.setText("Assignments");
        Assignments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignmentsActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Welcome ,");

        Ndisplay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Ndisplay.setText("NDispay");

        Modifyinfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Modifyinfo.setText("Modify Info");
        Modifyinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyinfoActionPerformed(evt);
            }
        });

        Viewstudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Viewstudent.setText("View Student");
        Viewstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewstudentActionPerformed(evt);
            }
        });

        Changepass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Changepass.setText("Change Password");
        Changepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangepassActionPerformed(evt);
            }
        });

        Makeattendance.setText("Today's Attendance");
        Makeattendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeattendanceActionPerformed(evt);
            }
        });

        AttendanceL.setText("YES");

        Hbd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Hbd.setForeground(new java.awt.Color(0, 102, 0));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("View Own Profile");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ndisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Changepass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutb)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Makeattendance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AttendanceL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Checkattendance, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Assignments, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Modifyinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Viewstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Hbd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutb)
                    .addComponent(jLabel3)
                    .addComponent(Ndisplay)
                    .addComponent(Changepass))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(Checkattendance)
                        .addGap(18, 18, 18)
                        .addComponent(Salary)
                        .addGap(18, 18, 18)
                        .addComponent(Assignments))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(Modifyinfo)
                        .addGap(18, 18, 18)
                        .addComponent(Viewstudent)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(Hbd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Makeattendance)
                    .addComponent(AttendanceL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbActionPerformed
        JOptionPane.showMessageDialog(this,"You have been successfully logged out");
        Login ob = new Login();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutbActionPerformed

    private void ChangepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangepassActionPerformed
        // TODO add your handling code here:
        Changepassword ob=new Changepassword('t',""+userid,""+name);
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ChangepassActionPerformed

    private void ModifyinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyinfoActionPerformed
        Modifyinfo ob=new Modifyinfo('t',""+userid,""+name);
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ModifyinfoActionPerformed

    private void MakeattendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakeattendanceActionPerformed
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","cam","project");
            Statement stat = con.createStatement();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            String full =cal.getTime().toString();
            String mon="", dd="", yy="",fulldt="";
            char temp= ' ';
            for(int i=4;i<7;i++) {
                temp=full.charAt(i);
                mon += temp;
            }   
            for(int i=8;i<10;i++) {
                temp=full.charAt(i);
                dd += temp;
            }
            for(int i=24;i<=27;i++) {
                temp=full.charAt(i);
                yy += temp;
            }   
            fulldt=dd+"-"+mon+"-"+yy;
            ResultSet rs= stat.executeQuery("select * from attendance where loginid='"+userid+"' and adate='"+fulldt+"'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(this,"Your Attendance Is Already Made");
            } else {
                stat.executeQuery("insert into attendance values('"+userid+"','"+fulldt+"')");
                JOptionPane.showMessageDialog(this,"Today's Attendance Made Successfully");
                AttendanceL.setText("YES");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MakeattendanceActionPerformed

    private void CheckattendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckattendanceActionPerformed
        Viewattendance ob=new Viewattendance('t',""+userid,""+name);
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CheckattendanceActionPerformed

    private void SalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryActionPerformed
        Fullaccountdetails ob=new Fullaccountdetails('t',""+userid,""+name);
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SalaryActionPerformed

    private void ViewstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewstudentActionPerformed
        Viewuser ob=new Viewuser('t',""+userid,""+name);
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ViewstudentActionPerformed

    private void AssignmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignmentsActionPerformed
        Assignments ob=new Assignments('t',""+userid,""+name);
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AssignmentsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Profile ob=new Profile('t',""+userid,""+name);
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Assignments;
    private javax.swing.JTextField AttendanceL;
    private javax.swing.JButton Changepass;
    private javax.swing.JButton Checkattendance;
    private javax.swing.JLabel Hbd;
    private javax.swing.JButton Makeattendance;
    private javax.swing.JButton Modifyinfo;
    private javax.swing.JLabel Ndisplay;
    private javax.swing.JButton Salary;
    private javax.swing.JButton Viewstudent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logoutb;
    // End of variables declaration//GEN-END:variables
}
