/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResortAdministration;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author USER
 */
public class CustomerID extends javax.swing.JFrame {

    /**
     * Creates new form CustomerID
     */
    public CustomerID() {
        initComponents();
        fetchData();
    }
     public void fetchData() {
        try {
            Welcome.jdbc.preparedStatement = Welcome.jdbc.connection
                    .prepareStatement("SELECT * FROM customer_registration WHERE username='" + Welcome.user + "' AND password='" + Welcome.pass + "';");
            Welcome.jdbc.resultSet = Welcome.jdbc.preparedStatement.executeQuery();
            Welcome.jdbc.resultSet.next();
            firstname.setText(Welcome.jdbc.resultSet.getString("firstname"));
            lastname.setText(Welcome.jdbc.resultSet.getString("lastname"));
            address.setText(Welcome.jdbc.resultSet.getString("address"));
            nationality.setText(Welcome.jdbc.resultSet.getString("nationality"));
            email.setText(Welcome.jdbc.resultSet.getString("email"));
            passport.setText(Welcome.jdbc.resultSet.getString("passport"));
            mobile.setText(Welcome.jdbc.resultSet.getString("mobile"));
            phone.setText(Welcome.jdbc.resultSet.getString("phone"));
            username.setText(Welcome.jdbc.resultSet.getString("username"));
            password.setText(Welcome.jdbc.resultSet.getString("password"));
            creditcard.setText(Welcome.jdbc.resultSet.getString("creditcard"));
            cardpin.setText(Welcome.jdbc.resultSet.getString("cardpin"));
            gender.setText(Welcome.jdbc.resultSet.getString("gender"));

        } catch (SQLException ex) {
            Logger.getLogger(CustomerID.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Welcome.jdbc.preparedStatement = Welcome.jdbc.connection
                    .prepareStatement("SELECT picture FROM customer_registration WHERE username='"
                            + Welcome.user + "';");
            Welcome.jdbc.resultSet = Welcome.jdbc.preparedStatement.executeQuery();
            Welcome.jdbc.resultSet.next();
            try {
                BufferedImage im = ImageIO.read(Welcome.jdbc.resultSet.getBinaryStream(1));
                im = linearResizeBi(im, picture.getWidth(), picture.getHeight());
                ImageIcon image1 = new ImageIcon(im);
                picture.setIcon(image1);
                getContentPane().add(picture);
                setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(CustomerID.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerID.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static public BufferedImage linearResizeBi(BufferedImage origin, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        float xScale = (float) width / origin.getWidth();
        float yScale = (float) height / origin.getHeight();
        AffineTransform at = AffineTransform.getScaleInstance(xScale, yScale);
        g.drawRenderedImage(origin, at);
        g.dispose();
        return resizedImage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        componentMoverUtil1 = new com.k33ptoo.utils.ComponentMoverUtil();
        componentResizerUtil1 = new com.k33ptoo.utils.ComponentResizerUtil();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        kButton2 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cardpin = new javax.swing.JLabel();
        picture = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        mobile = new javax.swing.JLabel();
        creditcard = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nationality = new javax.swing.JLabel();
        passport = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 51, 255));
        kGradientPanel1.setkGradientFocus(600);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 102, 255));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1280, 730));

        kButton2.setText("BACK");
        kButton2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        kButton2.setkBackGroundColor(new java.awt.Color(42, 45, 53));
        kButton2.setkBorderRadius(20);
        kButton2.setkEndColor(new java.awt.Color(89, 255, 120));
        kButton2.setkForeGround(new java.awt.Color(51, 51, 0));
        kButton2.setkHoverColor(new java.awt.Color(255, 255, 102));
        kButton2.setkHoverEndColor(new java.awt.Color(255, 241, 192));
        kButton2.setkHoverForeGround(new java.awt.Color(0, 102, 51));
        kButton2.setkHoverStartColor(new java.awt.Color(255, 255, 102));
        kButton2.setkPressedColor(new java.awt.Color(0, 204, 204));
        kButton2.setkStartColor(new java.awt.Color(240, 241, 192));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setText("CONFIRM");
        kButton3.setFont(new java.awt.Font("Consolas", 1, 40)); // NOI18N
        kButton3.setkBackGroundColor(new java.awt.Color(42, 45, 53));
        kButton3.setkBorderRadius(20);
        kButton3.setkEndColor(new java.awt.Color(89, 255, 120));
        kButton3.setkForeGround(new java.awt.Color(51, 51, 0));
        kButton3.setkHoverColor(new java.awt.Color(255, 255, 102));
        kButton3.setkHoverEndColor(new java.awt.Color(255, 241, 192));
        kButton3.setkHoverForeGround(new java.awt.Color(0, 102, 51));
        kButton3.setkHoverStartColor(new java.awt.Color(255, 255, 102));
        kButton3.setkPressedColor(new java.awt.Color(0, 204, 204));
        kButton3.setkStartColor(new java.awt.Color(240, 241, 192));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel19.setText("CARD PIN          :");

        jLabel20.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel20.setText("E-MAIL              :");

        cardpin.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        cardpin.setText("   ");

        picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ResortAdministration/Images/187803-200.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel22.setText("CREDIT CARD :");

        jLabel23.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel23.setText("GENDER            :");

        firstname.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        firstname.setText("   ");

        lastname.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        lastname.setText("   ");

        address.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        address.setText("   ");

        email.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        email.setText("   ");

        mobile.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        mobile.setText("   ");

        creditcard.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        creditcard.setText("   ");

        gender.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        gender.setText("   ");

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel7.setText("FIRST NAME    :");

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 1, 55)); // NOI18N
        jLabel8.setText("ID CARD");

        nationality.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        nationality.setText("   ");

        passport.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        passport.setText("   ");

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel12.setText("LAST NAME      :");

        phone.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        phone.setText("   ");

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel13.setText("ADDRESS          :");

        jLabel18.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel18.setText("USERNAME      :");

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel14.setText("NATIONALITY :");

        jLabel34.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel34.setText("PASSWORD      :");

        jLabel15.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel15.setText("PASSPORT No. :");

        password.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        password.setText("   ");

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel16.setText("MOBILE No.      :");

        username.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        username.setText("   ");

        jLabel17.setFont(new java.awt.Font("Bodoni MT", 1, 30)); // NOI18N
        jLabel17.setText("PHONE No.        :");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel22))
                                .addGap(2, 2, 2))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23)))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstname)
                    .addComponent(gender)
                    .addComponent(lastname)
                    .addComponent(address)
                    .addComponent(email)
                    .addComponent(mobile)
                    .addComponent(creditcard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)))
                    .addComponent(jLabel18)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passport)
                    .addComponent(nationality)
                    .addComponent(phone)
                    .addComponent(cardpin)
                    .addComponent(username)
                    .addComponent(password))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 500, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(343, 343, 343)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(nationality)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(passport)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(phone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cardpin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(username)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(password))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel34))))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(firstname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lastname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(address)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(email)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mobile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(creditcard)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gender)))))
                .addGap(94, 94, 94)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        CustomerRegistration customerRegistration = new CustomerRegistration();
        customerRegistration.show();
        dispose();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        ResortSlide resortSlide=new ResortSlide();
        resortSlide.show();
        dispose();
    }//GEN-LAST:event_kButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerID().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel cardpin;
    private com.k33ptoo.utils.ComponentMoverUtil componentMoverUtil1;
    private com.k33ptoo.utils.ComponentResizerUtil componentResizerUtil1;
    private javax.swing.JLabel creditcard;
    private javax.swing.JLabel email;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lastname;
    private javax.swing.JLabel mobile;
    private javax.swing.JLabel nationality;
    private javax.swing.JLabel passport;
    private javax.swing.JLabel password;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel picture;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}