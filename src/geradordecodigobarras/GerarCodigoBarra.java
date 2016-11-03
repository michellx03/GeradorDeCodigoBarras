package geradordecodigobarras;

import UTIL.ManipularImagem;
import beans.ProdutosDao;
import entities.ImagemSelecionada;
import entities.Produtos;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

public class GerarCodigoBarra extends javax.swing.JFrame {

    BufferedImage imagem;
    
    public GerarCodigoBarra() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        jTextFieldId.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDados = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelProduto = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jLabelCodConvenio = new javax.swing.JLabel();
        jLabelGerarAutomaticamente = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldProduto = new javax.swing.JTextField();
        jTextFieldCodigoDeBarras = new javax.swing.JTextField();
        jTextFieldCodigoConvenio = new javax.swing.JTextField();
        jComboBoxtipo = new javax.swing.JComboBox<>();
        jButtongerarCodigo = new javax.swing.JButton();
        jButtonCopiarCodigo = new javax.swing.JButton();
        jLabelCodigoBarras = new javax.swing.JLabel();
        jButtonSalvarCodigo = new javax.swing.JButton();
        jButtonGerarCodigo = new javax.swing.JButton();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonGeraEtiqueta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelCodigo.setText("Id");

        jLabelProduto.setText("Produto");

        jLabelTipo.setText("Tipo");

        jLabelCodConvenio.setText("Código cônvenio");

        jLabelGerarAutomaticamente.setText("Código de barras");

        jComboBoxtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Material", "Medicamento" }));

        jButtongerarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/eye.png"))); // NOI18N
        jButtongerarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtongerarCodigoActionPerformed(evt);
            }
        });

        jButtonCopiarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/page_paste.png"))); // NOI18N
        jButtonCopiarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopiarCodigoActionPerformed(evt);
            }
        });

        jLabelCodigoBarras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonSalvarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/disk.png"))); // NOI18N
        jButtonSalvarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarCodigoActionPerformed(evt);
            }
        });

        jButtonGerarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/printer.png"))); // NOI18N
        jButtonGerarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarCodigoActionPerformed(evt);
            }
        });

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonAlterar.setText("Alterar ");

        jButtonExcluir.setText("Excluir");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonGeraEtiqueta.setText("Gera etiqueta");

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalvar)
                .addGap(30, 30, 30)
                .addComponent(jButtonPesquisar)
                .addGap(41, 41, 41)
                .addComponent(jButtonGeraEtiqueta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jButtonGeraEtiqueta))
                .addGap(26, 26, 26))
        );

        jLabel1.setText("Ações CB");

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelProduto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelCodigo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelTipo)
                                        .addGap(45, 45, 45)
                                        .addComponent(jComboBoxtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCodConvenio)
                                    .addComponent(jTextFieldCodigoConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelGerarAutomaticamente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldCodigoDeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(309, 309, 309)))
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonSalvarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonGerarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonCopiarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtongerarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodConvenio)
                    .addComponent(jLabelCodigo)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProduto)
                    .addComponent(jTextFieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodigoConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipo))
                .addGap(14, 14, 14)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGerarAutomaticamente)
                    .addComponent(jTextFieldCodigoDeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jButtongerarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCopiarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvarCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGerarCodigo))
                    .addComponent(jLabelCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelDadosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCopiarCodigo, jButtonGerarCodigo, jButtonSalvarCodigo, jButtongerarCodigo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarCodigoActionPerformed
        //Imprimir codigo de barras
        try {
            Barcode barcode = BarcodeFactory.createCode128(jTextFieldCodigoDeBarras.getText());//Cria o codigo de barras
            PrinterJob printeJob = PrinterJob.getPrinterJob();//imprimi o codigo de barras
            printeJob.setPrintable(barcode);//seleciona o q quer imprimir
            
            if(printeJob.printDialog()){
                try {
                    printeJob.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(GerarCodigoBarra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (BarcodeException ex) {
            Logger.getLogger(GerarCodigoBarra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonGerarCodigoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {                
        Produtos obj = new Produtos();
        //obj.setIdProduto(Integer.valueOf(jTextFieldId.getText()));
        obj.setProduto(jTextFieldProduto.getText());
        obj.setTipo((String) jComboBoxtipo.getSelectedItem());
        obj.setCodigo_convenio(Integer.valueOf(jTextFieldCodigoConvenio.getText()));
        obj.setCodigo_barras(Integer.valueOf(jTextFieldCodigoDeBarras.getText()));
        obj.setImagem(ManipularImagem.getImgBytes(imagem));
        
        ProdutosDao dao = new ProdutosDao();       
        Boolean foi = dao.inserir(obj);
        
        if(foi){
            JOptionPane.showMessageDialog(rootPane, "Gravado com sucesso!");
        }  else{
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar dados!");
        }    
        } catch (SQLException ex) {
            Logger.getLogger(GerarCodigoBarra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtongerarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtongerarCodigoActionPerformed
        //Cria o codigo de barras
        Barcode barcode = null;
        try {
            barcode =BarcodeFactory.createCode39(jTextFieldCodigoDeBarras.getText(), true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inisra dados no campo de codigo de barras!");
        }
        
        barcode.setDrawingText(false);
        
         barcode.setBarWidth(2);
         barcode.setBarHeight(60);
         
         imagem = new BufferedImage(300, 100, BufferedImage.TYPE_INT_ARGB);
         Graphics2D g = (Graphics2D) imagem.getGraphics();
         
         try {
            barcode.draw(g, 5, 20);
        } catch (Exception e) {
        }
         
         ImageIcon icon = new ImageIcon(imagem);
         
         jLabelCodigoBarras.setIcon(icon);
    }//GEN-LAST:event_jButtongerarCodigoActionPerformed

    private void jButtonCopiarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopiarCodigoActionPerformed
        //Copia o codigo de barrasaultToolkit().getSystemClipboard();
        
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        ImageIcon imagem = (ImageIcon) jLabelCodigoBarras.getIcon();
        ImagemSelecionada dh = new ImagemSelecionada(imagem.getImage());
        
        cb.setContents(dh, null);
    }//GEN-LAST:event_jButtonCopiarCodigoActionPerformed

    private void jButtonSalvarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarCodigoActionPerformed
        //Salvar codigo de barras
        Barcode barcode = null;
        try {
            barcode =BarcodeFactory.createCode39(jTextFieldCodigoDeBarras.getText(), true);
        } catch (Exception e) {
        }
        
        barcode.setDrawingText(false);
        
         barcode.setBarWidth(2);
         barcode.setBarHeight(60);
         
        try {
            FileOutputStream fos = new FileOutputStream("C:/Etiquetas/etiqueta01.jpg");
            try {
                BarcodeImageHandler.writeJPEG(barcode, fos);//salva a imagem dentro do arquivo
                JOptionPane.showMessageDialog(null, "Código salvo com sucesso!");
            } catch (OutputException ex) {
                Logger.getLogger(GerarCodigoBarra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerarCodigoBarra.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jButtonSalvarCodigoActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        new PesquisaProdutos().setVisible(true);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(GerarCodigoBarra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerarCodigoBarra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerarCodigoBarra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerarCodigoBarra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerarCodigoBarra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCopiarCodigo;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonGeraEtiqueta;
    private javax.swing.JButton jButtonGerarCodigo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSalvarCodigo;
    private javax.swing.JButton jButtongerarCodigo;
    private javax.swing.JComboBox<String> jComboBoxtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCodConvenio;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCodigoBarras;
    private javax.swing.JLabel jLabelGerarAutomaticamente;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JTextField jTextFieldCodigoConvenio;
    private javax.swing.JTextField jTextFieldCodigoDeBarras;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldProduto;
    // End of variables declaration//GEN-END:variables
}
