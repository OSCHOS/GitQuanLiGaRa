/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageGarage;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Clock;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class LapPhieuSuaChua extends javax.swing.JInternalFrame {
    
    private String header[] = {"id CTSC","id TN", "noi dung", "ten pt", "sl", "ten TC","thanh tien"};
    private DefaultTableModel tblModel = new DefaultTableModel(header, 0);

    /**
     * Creates new form ChiTietSuaChua
     */
    public LapPhieuSuaChua() {
        initComponents();
        loadCBBoxMaTN();
        loadCBBoxPhuTung();
        loadCBBoxTienCong();// day nua, ok
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBoxMaTN = new javax.swing.JComboBox<>();
        jComboBoxPhuTung = new javax.swing.JComboBox<>();
        jComboBoxTienCong = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCTSC = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jtxtPhuTung = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jtxtTienCong = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lập Phiếu Sửa Chữa");

        jLabel1.setText("Nội dung sửa chữa");

        jLabel2.setText("Lượt tiếp nhận");

        jLabel3.setText("Phụ tùng");

        jLabel4.setText("Tiền công");

        jComboBoxMaTN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lượt tiếp nhận" }));
        jComboBoxMaTN.setToolTipText("[mã tiếp nhận,tên kh, biển số, ngày nhận]");
        jComboBoxMaTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaTNActionPerformed(evt);
            }
        });

        jComboBoxPhuTung.setBackground(new java.awt.Color(240, 240, 240));
        jComboBoxPhuTung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "phụ tùng" }));
        jComboBoxPhuTung.setToolTipText("[mã phụ tùng, tên phụ tùng]");

        jComboBoxTienCong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền công" }));
        jComboBoxTienCong.setToolTipText("[mã tiền công, tên tiền công]");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableCTSC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableCTSC);

        jLabel5.setText("Số lượng");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        jSpinner1.setToolTipText("mặc định là 1");
        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSpinner1KeyPressed(evt);
            }
        });

        jtxtPhuTung.setToolTipText("nhập tên PT...");
        jtxtPhuTung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPhuTungActionPerformed(evt);
            }
        });

        jButton2.setText("Tìm PT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Tìm TC");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Dữ liệu nhập có lỗi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jComboBoxMaTN, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtxtPhuTung)
                                            .addComponent(jtxtTienCong, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxPhuTung, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxTienCong, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton1)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(176, 176, 176))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMaTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPhuTung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtPhuTung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTienCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jtxtTienCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";
        
        int indexMaTN = jComboBoxMaTN.getSelectedIndex();
        if(indexMaTN <0) // khong ma nao duoc chon.
            return;
        Vector itemMaTN = (Vector)jComboBoxMaTN.getSelectedItem();
//        String bienso = String.valueOf(itemMaTN.get(2).toString());
//        if(bienso.length()<0){
//            jComboBoxPhuTung.setEnabled(false);
//        }
        
        int indexPT = jComboBoxPhuTung.getSelectedIndex();
        if(indexPT <0) // khong phu tung nao duoc chon.
            return;
        Vector itemPT = (Vector)jComboBoxPhuTung.getSelectedItem();
        
        int indexTC = jComboBoxTienCong.getSelectedIndex();
        if(indexTC <0) // khong ma nao duoc chon.
            return;
        Vector itemTC = (Vector)jComboBoxTienCong.getSelectedItem();
        
        try {
            conn = DriverManager.getConnection(dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "insert into CTSC (idTN,NOIDUNG,idPT,SL,idTC, THANHTIEN) values (?,?,?,?,?,null)   exec thanhtien";
            ps = conn.prepareStatement(sql);         
            
            ps.setInt(1, Integer.parseInt(itemMaTN.get(0).toString()));
            ps.setString(2, (jTextField1.getText()));
            ps.setInt(3, Integer.parseInt(itemPT.get(0).toString()));
            ps.setInt(4, Integer.valueOf(jSpinner1.getValue().toString()));
            ps.setInt(5, Integer.parseInt(itemTC.get(0).toString()));
            // Tạo đối tượng thực thi câu lệnh Select
            
            int ret = ps.executeUpdate();
            if (ret != -1) {
                jLabel6.setText("chi tiet sua chua da duoc them");
            }
            
            jSpinner1.setValue(1);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "LỖI DỮ LIỆU NHẬP!", 1);
                e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage(),"Lỗi",1);
                ex.printStackTrace();
            }
        }
        loadTableCTSC();
//        loadCBBoxMaTN();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadTableCTSC(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";

        int index = jComboBoxMaTN.getSelectedIndex();
        if(index <0) // khong kho nao duoc chon.
            return;
        Vector item = (Vector)jComboBoxMaTN.getSelectedItem();
        int idTN = Integer.parseInt(item.get(0).toString());
        
        try {
            conn = DriverManager.getConnection(dbURL);

            
            // Câu lệnh xem dữ liệu
            String sql = "select idctsc, idTN, noidung, tenpt,sl,tentc,thanhtien from CTSC c,phutung p,tiencong t where c.idpt=p.idpt and c.idtc=t.idtc and idtn="+ idTN;
            

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;

            tblModel.setRowCount(0);

            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "CTSC khong co!");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("idctsc"));
                data.add(rs.getString("idtn"));
                data.add(rs.getString("noidung"));
                data.add(rs.getString("tenpt"));
                data.add(rs.getString("sl"));
                data.add(rs.getString("tentc"));
                data.add(rs.getString("thanhtien"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }

            jTableCTSC.setModel(tblModel); // Thêm dữ liệu vào table

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        jButton4.setEnabled(true); 
    }
    private void jComboBoxMaTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMaTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMaTNActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";

        try {
            conn = DriverManager.getConnection(dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select idPT,tenPT from phutung";

            // Nếu tìm kiếm theo title
            if (jtxtPhuTung.getText().length() > 0) {
                sql = sql + " where tenpt like N'%" + jtxtPhuTung.getText() + "%'";
            }

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;

            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Phụ tùng '"+jtxtPhuTung.getText()+"'" + "\t khong co! Nhập lại hoặc tìm trong combobox");
                jtxtPhuTung.setText("");
                return;
            }
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("idpt"));
                data.add(rs.getString("tenpt"));

                // Thêm một dòng vào table model
                cmbModel.addElement(data);
            }

             jComboBoxPhuTung.setModel(cmbModel);
             jtxtPhuTung.setText("");
             jComboBoxPhuTung.setBackground(Color.YELLOW);
             
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";

        try {
            conn = DriverManager.getConnection(dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select idtc,tentc from tiencong";

            // Nếu tìm kiếm theo title
            if (jtxtTienCong.getText().length() > 0) {
                sql = sql + " where tentc like N'%" + jtxtTienCong.getText() + "%'";
            }

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;

            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "'"+jtxtTienCong.getText()+"'" + "\t khong co");
                jtxtTienCong.setText("");
                return;
            }
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("idtc"));
                data.add(rs.getString("tentc"));

                // Thêm một dòng vào table model
                cmbModel.addElement(data);
                jComboBoxTienCong.setBackground(Color.YELLOW);
            }

             jComboBoxTienCong.setModel(cmbModel);
             jtxtTienCong.setText("");
             
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int indexOfSelectedRow = jTableCTSC.getSelectedRow();
        if (indexOfSelectedRow == -1) {
            JOptionPane.showConfirmDialog(this, "phải chọn 1 CTSC để xóa!", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int ret = JOptionPane.showConfirmDialog(this, "Xóa CTSC đã chọn?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }

        int idCTSC = Integer.parseInt(jTableCTSC.getModel().getValueAt(indexOfSelectedRow, 0).toString());

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String deletesql = "Delete From CTSC where idCTSC = ?";
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(deletesql);
            ps.setInt(1, idCTSC);
            ret = ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(this, "This CTSC has been deleted");
            }
            this.loadTableCTSC();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtxtPhuTungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPhuTungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPhuTungActionPerformed

    private void jSpinner1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jSpinner1KeyPressed
    
    private void loadCBBoxTienCong(){
    Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";

        try {
            conn = DriverManager.getConnection(dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select idtc, tentc from tiencong";

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Tiền công khong có sẵn");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("idtc"));
                data.add(rs.getString("tentc"));

                // Thêm một dòng vào table model
                cmbModel.addElement(data);
            }

             jComboBoxTienCong.setModel(cmbModel);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    private void loadCBBoxPhuTung(){
    Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=garaoto;user=sa;password=1";

        try {
            conn = DriverManager.getConnection(dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select idpt, TenPT from Phutung  ";

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
                        if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Phụ tùng khong có sẵn");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("idpt"));
                data.add(rs.getString("tenpt"));

                // Thêm một dòng vào table model
                cmbModel.addElement(data);
            }

             jComboBoxPhuTung.setModel(cmbModel);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void loadCBBoxMaTN(){
    Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=garaoto;user=sa;password=1";

        try {
            conn = DriverManager.getConnection(dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "exec phieuSC";

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Không có lượt tiếp nhận mới!");
                jComboBoxMaTN.setEnabled(false);
                jComboBoxPhuTung.setEnabled(false);
                jComboBoxTienCong.setEnabled(false);
                jtxtPhuTung.setEnabled(false);
                jtxtTienCong.setEnabled(false);
                jTextField1.setEnabled(false);
                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                jButton4.setEnabled(false);
                jSpinner1.setEnabled(false);
                jTableCTSC.setEnabled(false);
                
                
                
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getInt("idtn"));
                data.add(rs.getString("tenkh"));
                data.add(rs.getString("bienso"));
                data.add(rs.getString("ngaynhan"));

                // Thêm một dòng vào table model
                cmbModel.addElement(data);
            }

             jComboBoxMaTN.setModel(cmbModel);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBoxMaTN;
    private javax.swing.JComboBox<String> jComboBoxPhuTung;
    private javax.swing.JComboBox<String> jComboBoxTienCong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableCTSC;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jtxtPhuTung;
    private javax.swing.JTextField jtxtTienCong;
    // End of variables declaration//GEN-END:variables
}
