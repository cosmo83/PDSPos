//    PDS oPos  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2014 uniCenta & previous Openbravo POS works
//    http://www.unicenta.com
//
//    This file is part of PDS oPos
//
//    PDS oPos is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   PDS oPos is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with PDS oPos.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.data.gui;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.LocalRes;
import com.openbravo.data.loader.Vectorer;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author JG uniCenta
 */
public class JFind extends JDialog {
    
    private FindInfo m_FindInfo;
    private Vectorer m_vec;
        
    /** Creates new form JFind */
    private JFind(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }
    /** Creates new form JFind */
    private JFind(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
    }
    
    private FindInfo init(FindInfo lastFindInfo) throws BasicException {
        
        initComponents();

        getRootPane().setDefaultButton(jcmdOK);   
   
        // El texto
        m_jFind.setText(lastFindInfo.getText());
        // Pinto la caja
        m_jWhere.removeAllItems();
        for (int i = 0; i < lastFindInfo.getVectorer().getHeaders().length; i++) {
            m_jWhere.addItem(lastFindInfo.getVectorer().getHeaders()[i]);
        }
        m_jWhere.setSelectedIndex(lastFindInfo.getField());
        // El Match
        m_jMatch.removeAllItems();
        m_jMatch.addItem(LocalRes.getIntString("list.startfield"));
        m_jMatch.addItem(LocalRes.getIntString("list.wholefield"));
        m_jMatch.addItem(LocalRes.getIntString("list.anypart"));
        m_jMatch.addItem(LocalRes.getIntString("list.re"));
        m_jMatch.setSelectedIndex(lastFindInfo.getMatch());
        // El case
        m_jMatchCase.setSelected(lastFindInfo.isMatchCase());
        
        m_vec = lastFindInfo.getVectorer();

        m_FindInfo = null;
        
        //show();
        setVisible(true);
        
        return m_FindInfo;
    }
    
    private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window)parent;
        } else {
            return getWindow(parent.getParent());
        }
    }
       
    /**
     *
     * @param parent
     * @param lastFindInfo
     * @return
     * @throws BasicException
     */
    public static FindInfo showMessage(Component parent, FindInfo lastFindInfo) throws BasicException {
         
        Window window = getWindow(parent);      
        
        JFind myMsg;
        if (window instanceof Frame) { 
            myMsg = new JFind((Frame) window, true);
        } else {
            myMsg = new JFind((Dialog) window, true);
        }
        return myMsg.init(lastFindInfo);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        m_jFind = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        m_jWhere = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        m_jMatch = new javax.swing.JComboBox();
        m_jMatchCase = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jcmdOK = new javax.swing.JButton();
        jcmdCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(LocalRes.getIntString("title.find")); // NOI18N
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText(LocalRes.getIntString("label.findwhat")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 100, 25);

        m_jFind.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(m_jFind);
        m_jFind.setBounds(110, 20, 230, 25);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText(LocalRes.getIntString("label.where")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 50, 100, 25);

        m_jWhere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(m_jWhere);
        m_jWhere.setBounds(110, 50, 230, 25);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText(LocalRes.getIntString("label.match")); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 80, 100, 25);

        m_jMatch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(m_jMatch);
        m_jMatch.setBounds(110, 80, 230, 25);

        m_jMatchCase.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jMatchCase.setText(LocalRes.getIntString("label.casesensitive")); // NOI18N
        jPanel1.add(m_jMatchCase);
        m_jMatchCase.setBounds(110, 110, 230, 25);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jcmdOK.setText(LocalRes.getIntString("button.ok")); // NOI18N
        jcmdOK.setMaximumSize(new java.awt.Dimension(65, 33));
        jcmdOK.setMinimumSize(new java.awt.Dimension(65, 33));
        jcmdOK.setPreferredSize(new java.awt.Dimension(65, 33));
        jcmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdOKActionPerformed(evt);
            }
        });
        jPanel2.add(jcmdOK);

        jcmdCancel.setText(LocalRes.getIntString("button.cancel")); // NOI18N
        jcmdCancel.setPreferredSize(new java.awt.Dimension(65, 33));
        jcmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdCancelActionPerformed(evt);
            }
        });
        jPanel2.add(jcmdCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-434)/2, (screenSize.height-222)/2, 434, 222);
    }// </editor-fold>//GEN-END:initComponents

    private void jcmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jcmdCancelActionPerformed

    private void jcmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdOKActionPerformed
        
        m_FindInfo = new FindInfo(m_vec, m_jFind.getText(), m_jWhere.getSelectedIndex(), m_jMatchCase.isSelected(), m_jMatch.getSelectedIndex());
        
        dispose();
        
    }//GEN-LAST:event_jcmdOKActionPerformed
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        //new JFind(new javax.swing.JFrame(), true).show();
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            //UIManager.setLookAndFeel("com.shfarr.ui.plaf.fh.FhLookAndFeel");
//        } catch(Exception ex) {
//        }
//        try {
//            showMessage(new javax.swing.JFrame(), null);
//        } catch (DataException eD) {
//        }
//        System.exit(0);
//    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jcmdCancel;
    private javax.swing.JButton jcmdOK;
    private javax.swing.JTextField m_jFind;
    private javax.swing.JComboBox m_jMatch;
    private javax.swing.JCheckBox m_jMatchCase;
    private javax.swing.JComboBox m_jWhere;
    // End of variables declaration//GEN-END:variables
    
}
