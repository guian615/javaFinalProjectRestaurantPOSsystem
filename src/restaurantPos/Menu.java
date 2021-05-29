package restaurantPos;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu extends javax.swing.JInternalFrame {
    //private keyword which declares a member's access as private 
    //private classes of String initializing database  username,password,and dbname
    private static final String username = "root";
    private static final String password = "";
    private static final String dbname = "jdbc:mysql://localhost:3306/java";
    
    
    int q, i, ID, deleteItem;
    
    //variables holding a null values
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Menu() throws ClassNotFoundException, SQLException {
        initComponents();
        menuFunction(); //calling the function
        id.setVisible(false); // input field of id was set into setVisible of false

    }

    //function named menuFunction() to check the conditions 
    public void menuFunction() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbname, username, password);
            pst = sqlConn.prepareStatement("select * from product");

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();

            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();

                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("id"));
                    columnData.add(rs.getString("productName"));
                    columnData.add(rs.getString("category"));
                    columnData.add(rs.getString("price"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        manage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        id = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        categoryField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        clearField = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 506));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        manage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manage.setForeground(new java.awt.Color(0, 153, 153));
        manage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manage.setText("Manage Products");
        manage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantPos/img/rsz_4unnamed.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(manage, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 60));

        jPanel2.setBackground(new java.awt.Color(0, 51, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 500));

        id.setEditable(false);
        id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(0, 153, 153));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        nameField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name:");

        categoryField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        categoryField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category:");

        priceField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        priceField.setForeground(new java.awt.Color(0, 153, 153));
        priceField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Price:");

        table.setBackground(new java.awt.Color(0, 153, 153));
        table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Category", "Price"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        add.setBackground(new java.awt.Color(0, 102, 102));
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add Product");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        delete.setBackground(new java.awt.Color(0, 102, 102));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 102, 102));
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        clearField.setBackground(new java.awt.Color(0, 102, 102));
        clearField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearField.setForeground(new java.awt.Color(255, 255, 255));
        clearField.setText("Clear Field");
        clearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PHP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clearField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(clearField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 690, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        //try catch for inserting data into database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbname, username, password);
            pst = sqlConn.prepareStatement("insert into product(productName,category,price)value(?,?,?)");

            pst.setString(1, nameField.getText());
            pst.setString(2, categoryField.getText());
            pst.setFloat(3, Float.parseFloat(priceField.getText()));

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Added");
            menuFunction();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_addMouseClicked


//setting the textfield into empty string once clear button is clicked
    private void clearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldActionPerformed
        id.setText("");
        nameField.setText("");
        categoryField.setText("");
        priceField.setText("");
    }//GEN-LAST:event_clearFieldActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
         //try catch for updating data into database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbname, username, password);
            pst = sqlConn.prepareStatement("update product set productName=?,category=?,price=? where id =?");

            pst.setString(1, nameField.getText());
            pst.setString(2, categoryField.getText());
            pst.setFloat(3, Float.parseFloat(priceField.getText()));
            pst.setInt(4, Integer.parseInt(id.getText()));

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Updated");
            menuFunction();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateMouseClicked
//table on mouseClicked for displayong the data in the text field once clicked
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
      
        DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
        int SelectedRows = table.getSelectedRow();
        id.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        nameField.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        categoryField.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        priceField.setText(RecordTable.getValueAt(SelectedRows, 3).toString());


    }//GEN-LAST:event_tableMouseClicked

    //delete button on mouseClicked
    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
        int SelectedRows = table.getSelectedRow();
        int p = JOptionPane.showConfirmDialog(null,"Do you really want to delete product?","Delete",JOptionPane.YES_NO_OPTION );
        if(p==0){
         
            
        //try catch for deleting data in the table and in database   
        try {

            ID = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());

            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbname, username, password);
            pst = sqlConn.prepareStatement("delete from product where id =?");

            id.requestFocus();
            id.setText("");
            nameField.setText("");
            categoryField.setText("");
            priceField.setText("");

            pst.setInt(1, ID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
            menuFunction();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_deleteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField categoryField;
    private javax.swing.JButton clearField;
    private javax.swing.JButton delete;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manage;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
