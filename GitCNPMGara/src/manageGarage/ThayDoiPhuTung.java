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
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ThayDoiPhuTung extends javax.swing.JInternalFrame {

    private String header[] = {"Mã phụ tùng", "Tên phụ tùng","Giá phụ tùng","Số lượng tồn"};
    private DefaultTableModel tblModel = new DefaultTableModel(header, 0);
/**
     * Creates new form ThayDoiPhuTung
     */
    public ThayDoiPhuTung() {
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

        jLabel1 = new javax.swing.JLabel();
        jtxtTenPhuTung = new javax.swing.JTextField();
        bTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPhuTung = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtxtMaPhuTung = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtGiaMoi = new javax.swing.JTextField();
        bCapNhat = new javax.swing.JButton();
        bXoa = new javax.swing.JButton();
        mStatus = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Thay đổi thông tin phụ tùng");

        jLabel1.setText("Tên phụ tùng");

        bTimKiem.setText("Tìm kiếm");
        bTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTimKiemActionPerformed(evt);
            }
        });

        jtbPhuTung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idPT", "Tên phụ tùng", "Giá", "Số lượng tồn"
            }
        ));
        jScrollPane1.setViewportView(jtbPhuTung);

        jLabel2.setText("Mã phụ tùng");

        jtxtMaPhuTung.setEnabled(false);

        jLabel3.setText("Giá mới");

        bCapNhat.setText("Cập nhật");
        bCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCapNhatActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCapNhat, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtTenPhuTung, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bTimKiem))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(mStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtxtMaPhuTung)
                                        .addComponent(jtxtGiaMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTenPhuTung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bXoa)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtMaPhuTung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtGiaMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(bCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mStatus)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void Search(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";
        
        try {
            conn = DriverManager.getConnection(dbURL);

            // Câu lệnh xem dữ liệu
            String sql = "select * from PHUTUNG ";

            // Nếu tìm kiếm theo title
            if (jtxtTenPhuTung.getText().length() > 0) {
                sql = sql + " where TENPT like N'%" + jtxtTenPhuTung.getText() + "%'";
//                System.out.println("AT 183   "+jtxtTenPhuTung.getText());
            }

            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();

            // Thực thi 
            rs = st.executeQuery(sql);
            Vector data = null;

            tblModel.setRowCount(0);

            // Nếu sách không tồn tại
            if (rs.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(this, "Mã phụ tùng không tồn tại");
                return;
            }

            // Trong khi chưa hết dữ liệu
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("idPT"));
                data.add(rs.getString("TENPT"));
                data.add(rs.getInt("GIAPT"));

                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }

            jtbPhuTung.setModel(tblModel); // Thêm dữ liệu vào table

            jtbPhuTung.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int index = jtbPhuTung.getSelectedRow();
                    if(index >=0 && index < jtbPhuTung.getRowCount()){
                        jtxtMaPhuTung.setText(jtbPhuTung.getValueAt(index, 0).toString());
                        jtxtGiaMoi.setText(jtbPhuTung.getValueAt(index, 2).toString());
                    }
                }
                    
            });
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
    private void bTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTimKiemActionPerformed
        // TODO add your handling code here:
        this.Search();
    }//GEN-LAST:event_bTimKiemActionPerformed

    private void bXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaActionPerformed
        // TODO add your handling code here:
        int indexOfSelectedRow = jtbPhuTung.getSelectedRow();
        if (indexOfSelectedRow == -1) {
            JOptionPane.showConfirmDialog(this, "Vui lòng chọn Phụ tùng để xóa!", "Thông tin", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }

//        int MaPT = Integer.parseInt(jtbPhuTung.getModel().getValueAt(indexOfSelectedRow, 0).toString());//nhập là PT01 mà đòi đổi ra số
// m bạo hành t quá

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String deletesql = "Delete From PHUTUNG where idPT = ?";
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(deletesql);
            ps.setString(1,(String) jtbPhuTung.getValueAt(jtbPhuTung.getSelectedRow(), 0));
            ret = ps.executeUpdate();
            if (ret != -1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
            this.Search();
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

    private void bCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCapNhatActionPerformed
        // TODO add your handling code here:
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }

        String update = "update PHUTUNG set GIAPT = ? where idPT = ?";
        //System.out.println(update);

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GARAOTO;user=sa;password=1";
        
        try {
            conn = DriverManager.getConnection(dbURL);
            ps = conn.prepareStatement(update);

            if(this.jtxtGiaMoi.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Giá mới không được để trống","Thông báo lỗi", 1);
                return;
            }else
            if(Check.checkSb(this.jtxtGiaMoi.getText())==true){
                JOptionPane.showMessageDialog(null, "Giá mới không được có kí tự đặc biệt","Thông báo lỗi",1);
                return;
            }else
            if(Check.checkNum2(this.jtxtGiaMoi.getText())==true){
                JOptionPane.showMessageDialog(null,"Giá mới không được nhập chữ","Thông báo lỗi",1);
                return;
            }
            
            
            ps.setString(2, jtxtMaPhuTung.getText());
            ps.setInt(1, Integer.valueOf(jtxtGiaMoi.getText()));

            ret = ps.executeUpdate();
            if (ret != -1) {
                mStatus.setText("Giá đã được cập nhật");
                jtbPhuTung.setValueAt(jtxtGiaMoi.getText(), jtbPhuTung.getSelectedRow(), 2);
            }
            //this.search();

        } catch (Exception e) {
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
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
   
                                         
                                             

                                            
    }//GEN-LAST:event_bCapNhatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCapNhat;
    private javax.swing.JButton bTimKiem;
    private javax.swing.JButton bXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbPhuTung;
    private javax.swing.JTextField jtxtGiaMoi;
    private javax.swing.JTextField jtxtMaPhuTung;
    private javax.swing.JTextField jtxtTenPhuTung;
    private javax.swing.JLabel mStatus;
    // End of variables declaration//GEN-END:variables
}
