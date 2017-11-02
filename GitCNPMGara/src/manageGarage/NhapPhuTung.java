/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageGarage;

import Process.Check;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class NhapPhuTung extends javax.swing.JInternalFrame {

    private String header[] = {"idPT", "Tên phụ tùng", "Ngày nhập", "Số lượng nhập"};
    private DefaultTableModel tblModel = new DefaultTableModel(header, 0);
    private int row=0;/**
     * Creates new form NhapPhuTung
     */
    public NhapPhuTung() {
        initComponents();
        loadPTAndFillToCBBox();
        LoadTbl();
    }
    
    private void LoadTbl(){
            Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";

        int index = jComboBoxTenPT.getSelectedIndex();
        if(index <0) // khong kho nao duoc chon.
            return;
        Vector item = (Vector)jComboBoxTenPT.getSelectedItem();
  //      int idTN = Integer.parseInt(item.get(0).toString());
        
        try {
            conn = DriverManager.getConnection(dbURL);

            // măt lặặt duy tăt unikey cho bô. duma
            // Câu lệnh xem dữ liệu
            String sql = "select n.idpt, p.tenpt, n.ngaynhap, n.slnhap from phutung p, nhapphutung n where p.idpt=n.idpt and year(ngaynhap)=year(getdate()) and month(ngaynhap)=month(getdate())and day(ngaynhap)=day(getdate()) ";
            

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;

            tblModel.setRowCount(0);

            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "chua co phu tung duoc nhap trong ngay hom nay!");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("idpt"));
                data.add(rs.getString("tenpt"));
                data.add(rs.getString("ngaynhap"));
                data.add(rs.getString("slnhap"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }

            jTablePT.setModel(tblModel); // Thêm dữ liệu vào table

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
    
    
    private void loadPTAndFillToCBBox(){
    Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";

        try {
            conn = DriverManager.getConnection(dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select idPT,TENPT from PHUTUNG where idpt != 0";
            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;
            DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Phụ tùng không tồn tại");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getInt("idPT"));
                data.add(rs.getString("TENPT"));

                // Thêm một dòng vào table model
                cmbModel.addElement(data);
            }

             jComboBoxTenPT.setModel(cmbModel);

            
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
    
    private void loadTenPTbyPT(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";
        int index = jComboBoxTenPT.getSelectedIndex();
        if(index <0) // khong kho nao duoc chon.
            return;
        Vector item = (Vector)jComboBoxTenPT.getSelectedItem();
        int idPT = Integer.parseInt(item.get(0).toString());
        System.out.println("AT 102: " +idPT);
        int k = 0;
        
        try {
            conn = DriverManager.getConnection(dbURL);

            
            // Câu lệnh xem dữ liệu
            String sql = "select idPT,TENPT from PHUTUNG where idPT = "+ idPT;
            

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;

            tblModel.setRowCount(0);

            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Phụ tùng không tồn tại!");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getInt("idPT"));
                data.add(rs.getString("TENPT"));
//                data.add(rs.getDate("NGAYNHAP"));
//                data.add(rs.getInt("SLNHAP"));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }

            jTablePT.setModel(tblModel); // Thêm dữ liệu vào table

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jComboBoxTenPT = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtxtSoLuongNhap = new javax.swing.JTextField();
        bNhap = new javax.swing.JButton();
        bXoa = new javax.swing.JButton();
        mStatus = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nhập kho");

        jComboBoxTenPT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTenPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTenPTActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên phụ tùng");

        jTablePT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idPT", "Tên phụ tùng", "Ngày nhập", "Số lượng nhập"
            }
        ));
        jScrollPane1.setViewportView(jTablePT);

        jLabel2.setText("Số lượng nhập");

        bNhap.setText("Nhập");
        bNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNhapActionPerformed(evt);
            }
        });
        bNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bNhapKeyPressed(evt);
            }
        });

        bXoa.setText("Xóa");
        bXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaActionPerformed(evt);
            }
        });

        mStatus.setText("Status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxTenPT, 0, 158, Short.MAX_VALUE)
                            .addComponent(jtxtSoLuongNhap))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bNhap))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bXoa)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTenPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNhap))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(bXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mStatus)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTenPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTenPTActionPerformed
        // TODO add your handling code here:
//        loadTenPTbyPT();
        
    }//GEN-LAST:event_jComboBoxTenPTActionPerformed

    private void bXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaActionPerformed
        int indexOfSelectedRow = jTablePT.getSelectedRow();
        if (indexOfSelectedRow == -1) {
            JOptionPane.showConfirmDialog(this, "phải chọn 1 CTSC để xóa!", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int ret = JOptionPane.showConfirmDialog(this, "Xóa CTSC đã chọn?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }

        int idpt = Integer.parseInt(jTablePT.getModel().getValueAt(indexOfSelectedRow, 0).toString());
        String ngay = (jTablePT.getModel().getValueAt(indexOfSelectedRow, 2).toString());
        int sl = Integer.parseInt(jTablePT.getModel().getValueAt(indexOfSelectedRow, 3).toString());

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String deletesql = "Delete From nhapphutung  where idPT=? and ngaynhap=? and SLNHAP = ? ";
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(deletesql);
            ps.setInt(1, idpt);
            ps.setString(2, ngay);
            ps.setInt(3, sl);
            
            
            
            ret = ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(this, "This CTSC has been deleted");
            }
            this.loadTenPTbyPT();
            LoadTbl();
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

                             
                                       
    }//GEN-LAST:event_bXoaActionPerformed

    
    
    private void bNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNhapActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO";
        String insert = "INSERT INTO NHAPPHUTUNG (idPT,NGAYNHAP,SLNHAP) VALUES(?,getdate(),?)";
        
        try {
            conn = DriverManager.getConnection(dbURL,"sa","1");
            ps = conn.prepareStatement(insert);
        } catch (SQLException ex) {
            Logger.getLogger(ThemPhuTung.class.getName()).log(Level.SEVERE, "Loi connect", ex);
        }
            
        try {
            if(Check.checkNum(this.jtxtSoLuongNhap.getText())==false){
                JOptionPane.showMessageDialog(null, "Số lượng nhập không hợp lệ","Thông báo lỗi",3);
                return;
            }
            if(Integer.valueOf(this.jtxtSoLuongNhap.getText())<=0){
                JOptionPane.showMessageDialog(null, "Số lượng nhập phải lơn hơn 0","Thông báo lỗi",3);
                return;
            }
           

//            ps.setInt(1,Integer.valueOf(JtxtMaPhuTung.getText()));
            Vector item = (Vector)jComboBoxTenPT.getSelectedItem();
            int idPT = Integer.parseInt(item.get(0).toString());
//            java.util.Date date=new java.util.Date();
//            Date sqlDate=new Date(date.getYear(),date.getMonth(),date.getDate());
            ps.setInt(1, idPT);
 //           ps.setDate(2, sqlDate);
            ps.setString(2, jtxtSoLuongNhap.getText());
            
           
        
            
          
            int ret = ps.executeUpdate();
            mStatus.setText("Nhap so luong thanh cong.");
            LoadTbl();
//            Vector item = (Vector)jComboBoxTenPT.getSelectedItem();
//            jTablePT.setValueAt(Integer.parseInt(item.get(0).toString()),row , 0);
//            jTablePT.setValueAt(item.get(1).toString(), row, 1);
//            jTablePT.setValueAt(sqlDate.toString(), row, 2);
//            jTablePT.setValueAt(Integer.valueOf(jtxtSoLuongNhap.getText()), row, 3);
//            row++;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "LỖI DỮ LIỆU NHẬP!", 1);
                e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex2) {
                ex2.printStackTrace();
                JOptionPane.showMessageDialog(this, ex2.getMessage(), "LỖI DỮ LIỆU NHẬP!", 1);
            }
        }
                                           

                                      
                                        
    }//GEN-LAST:event_bNhapActionPerformed

    private void bNhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bNhapKeyPressed
        // TODO add your handling code here:
         if(this.jtxtSoLuongNhap.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Số lượng không được để trống","Thông báo lỗi", 1);
                return;
            } else
            if(Check.checkSb(this.jtxtSoLuongNhap.getText())==true){
                JOptionPane.showMessageDialog(null, "Số lượng không được có kí tự đặc biệt","Thông báo lỗi",1);
                return;
            }
    }//GEN-LAST:event_bNhapKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNhap;
    private javax.swing.JButton bXoa;
    private javax.swing.JComboBox<String> jComboBoxTenPT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTablePT;
    private javax.swing.JTextField jtxtSoLuongNhap;
    private javax.swing.JLabel mStatus;
    // End of variables declaration//GEN-END:variables
}
