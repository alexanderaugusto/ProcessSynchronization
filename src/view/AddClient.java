/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import processsynchronization.Client;
import processsynchronization.Product;

/**
 *
 * @author Alexa
 */
public class AddClient extends javax.swing.JInternalFrame {

    Home homeScreen;

    private List<ProductScreen> products = new ArrayList<ProductScreen>();
    private JPanel productsPanel = new JPanel();

    private DefaultListModel clientItemsModel = new DefaultListModel();
    private ArrayList<Product> clientProducts = new ArrayList<Product>();

    private int selectedListIndex;

    /**
     * Creates new form AddClient
     */
    public AddClient(Home homeScreen) {
        initComponents();

        this.homeScreen = homeScreen;

        productsPanel.setBackground(new Color(244, 247, 245));
        productsPanel.setLayout(new GridLayout(3, 4));
        productsPanel.setBorder(new EmptyBorder(5, 10, 5, 5));

        JScrollPane scrollPanel = new JScrollPane(productsPanel);
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);

        renderProducts.add(scrollPanel);
        renderProducts.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.clientItems.setModel(clientItemsModel);

        this.showProducts();
    }

    public void showProducts() {
        for (Product product : this.homeScreen.products) {
            ProductScreen newProduct = new ProductScreen(product, this);
            this.products.add(newProduct);
            this.productsPanel.add(newProduct);
            revalidate();
            repaint();
        }
    }

    public void addProduct(Product product) {
        this.clientProducts.add(product);
        this.clientItemsModel.addElement("  " + product.getName());
    }

    public void deleteProduct(int index) {
        this.clientProducts.remove(index);
        this.clientItemsModel.remove(index);
    }

    public void createClient() {
        ArrayList<Product> clientProductsAux = new ArrayList<Product>(this.clientProducts);
        this.homeScreen.clients.add(new Client(nameInput.getText(), clientProductsAux));
        this.nameInput.setText("");
        this.clientItemsModel.clear();
        this.clientProducts.clear();

        ImageIcon icon = new ImageIcon("src/img/client.png");
        int input = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais algum cliente?", "Mensagem de confirmação:",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);

        if (input == 0) {
            this.clientLabel.setText("Client " + (this.homeScreen.clients.size() + 1));
        } else {
            this.homeScreen.changeScreen(new Attendants(this.homeScreen));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        clientLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        clientItemsScroll = new javax.swing.JScrollPane();
        clientItems = new javax.swing.JList<>();
        addClient = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        renderProducts = new javax.swing.JPanel();
        deleteItem = new javax.swing.JButton();

        setBackground(new java.awt.Color(244, 247, 245));
        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(244, 247, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1015, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(17, 19, 68));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>\n<p><center> Aqui você pode adicionar clientes e fazer compras pra ele.</center></p>\n<p>Recomendamos que adicione pelo menos dois clientes para visualizar a sincronização no atendimento.</p>\n</html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/client.png"))); // NOI18N

        clientLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clientLabel.setForeground(new java.awt.Color(17, 19, 68));
        clientLabel.setText("Cliente 1");

        nameInput.setForeground(new java.awt.Color(17, 19, 68));
        nameInput.setMargin(new java.awt.Insets(2, 10, 2, 2));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(17, 19, 68));
        jLabel4.setText("Nome");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(17, 19, 68));
        jLabel5.setText("Adicione itens ao carrinho do cliente (Clique duplo)");

        clientItemsScroll.setBackground(new java.awt.Color(244, 247, 245));

        clientItems.setBackground(new java.awt.Color(244, 247, 245));
        clientItems.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientItems.setForeground(new java.awt.Color(17, 19, 68));
        clientItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        clientItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                clientItemsValueChanged(evt);
            }
        });
        clientItemsScroll.setViewportView(clientItems);

        addClient.setBackground(new java.awt.Color(96, 113, 150));
        addClient.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addClient.setForeground(new java.awt.Color(244, 247, 245));
        addClient.setText("Adicionar Cliente");
        addClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addClientMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(17, 19, 68));
        jLabel6.setText("Itens comprados pelo cliente:");

        renderProducts.setBackground(new java.awt.Color(244, 247, 245));
        renderProducts.setLayout(new java.awt.BorderLayout());

        deleteItem.setBackground(new java.awt.Color(255, 0, 0));
        deleteItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteItem.setForeground(new java.awt.Color(244, 247, 245));
        deleteItem.setText("Remover");
        deleteItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteItemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameInput)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(renderProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientItemsScroll)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteItem, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(renderProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clientItemsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addClient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        deleteItem.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClientMouseClicked
        this.createClient();
    }//GEN-LAST:event_addClientMouseClicked

    private void clientItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_clientItemsValueChanged
        this.selectedListIndex = clientItems.getSelectedIndex();
        if (this.selectedListIndex != -1) {
            this.deleteItem.setVisible(true);
        }
    }//GEN-LAST:event_clientItemsValueChanged

    private void deleteItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteItemMouseClicked
        this.deleteProduct(this.selectedListIndex);
        this.deleteItem.setVisible(false);
        this.selectedListIndex = -1;
    }//GEN-LAST:event_deleteItemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClient;
    private javax.swing.JList<String> clientItems;
    private javax.swing.JScrollPane clientItemsScroll;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JButton deleteItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JPanel renderProducts;
    // End of variables declaration//GEN-END:variables
}
