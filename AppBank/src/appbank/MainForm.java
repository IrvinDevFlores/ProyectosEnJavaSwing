/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbank;

import Modelos.Cliente;
import Modelos.EstadoCiv;
import Modelos.Sexo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariel
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        ContenedorDeFunciones = new javax.swing.JTabbedPane();
        VerTransacionesPanel = new javax.swing.JPanel();
        InfoTransaciones = new javax.swing.JPanel();
        NoCuentaBuscarTrans = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        BuscarTransBtn = new javax.swing.JButton();
        TransacionesHechasScroll = new javax.swing.JScrollPane();
        TablaTransacionesBuscar = new javax.swing.JTable();
        ImprimirBtn = new javax.swing.JButton();
        HacerTransacionPanel = new javax.swing.JPanel();
        OperacionesInfo = new javax.swing.JPanel();
        FechaOpTrans = new javax.swing.JFormattedTextField();
        CodigoOpLabel = new javax.swing.JLabel();
        CodOpTrans = new javax.swing.JTextField();
        FechaOperacionLabel = new javax.swing.JLabel();
        DescripcionOpLabel = new javax.swing.JLabel();
        DescripcionOpTrans = new javax.swing.JTextField();
        TipoOperacionLabel = new javax.swing.JLabel();
        TipoOperacionCombo = new javax.swing.JComboBox();
        NoCuentaLabel = new javax.swing.JLabel();
        NoCuentaTrans = new javax.swing.JFormattedTextField();
        IdTransacionLabel = new javax.swing.JLabel();
        IdTransacionText = new javax.swing.JFormattedTextField();
        DetalleCuentaInfo3 = new javax.swing.JPanel();
        SaldoActualTrans6 = new javax.swing.JTextField();
        SaldoActualLabel3 = new javax.swing.JLabel();
        ImporteLabel3 = new javax.swing.JLabel();
        ImporteTrans3 = new javax.swing.JTextField();
        DineroRetiradoLabel3 = new javax.swing.JLabel();
        DineroRetiradoTrans3 = new javax.swing.JTextField();
        DineroDepositadoTrans3 = new javax.swing.JTextField();
        DineroDepositadoLabel3 = new javax.swing.JLabel();
        NombreLabel3 = new javax.swing.JLabel();
        SaldoActualTrans7 = new javax.swing.JTextField();
        HacerOperacionBtnTrans3 = new javax.swing.JButton();
        DeshacerBtnTrans3 = new javax.swing.JButton();
        BancoInfo = new javax.swing.JPanel();
        IdBancoTrans = new javax.swing.JTextField();
        IdBancoLabel = new javax.swing.JLabel();
        NombreBancoLabel = new javax.swing.JLabel();
        NombreBancoTrans = new javax.swing.JTextField();
        IdAgenciaLabel = new javax.swing.JLabel();
        IdAgenciaTrans = new javax.swing.JTextField();
        NombreAgenciaTrans = new javax.swing.JTextField();
        NombreAgenciaLabel = new javax.swing.JLabel();
        TransacinoesAgregadasPanel = new javax.swing.JPanel();
        TransacionesAgregadasScroll = new javax.swing.JScrollPane();
        TablaTransaciones = new javax.swing.JTable();
        CrearClientePanel = new javax.swing.JPanel();
        InfoClientePanel = new javax.swing.JPanel();
        IdClienteText = new javax.swing.JTextField();
        IdClienteLabel = new javax.swing.JLabel();
        ApellidosClientLabel = new javax.swing.JLabel();
        ApellidosText = new javax.swing.JTextField();
        NombresClienteLabel = new javax.swing.JLabel();
        NombresText = new javax.swing.JTextField();
        FechaNacText = new javax.swing.JTextField();
        FechaNacClientLabel = new javax.swing.JLabel();
        GenSexClientLabel = new javax.swing.JLabel();
        SexoCombo = new javax.swing.JComboBox();
        EstadoCivilClientLabel = new javax.swing.JLabel();
        EstadoCivilCombo = new javax.swing.JComboBox();
        NoCuentaClienteLabel = new javax.swing.JLabel();
        CedulaText = new javax.swing.JTextField();
        EmailClientLabel = new javax.swing.JLabel();
        CorreoText = new javax.swing.JTextField();
        DirecionClientLabel = new javax.swing.JLabel();
        DireccionText = new javax.swing.JTextField();
        CuentaClienteInfo = new javax.swing.JPanel();
        IdCuentaText = new javax.swing.JTextField();
        IdCuentaLabel = new javax.swing.JLabel();
        NoCuentaClientLabel = new javax.swing.JLabel();
        NoCuentaText = new javax.swing.JTextField();
        TipoCuentaLabel = new javax.swing.JLabel();
        TipoCuentaCombo = new javax.swing.JComboBox();
        SaldoCuentaLabel = new javax.swing.JLabel();
        SaldoAperturaText = new javax.swing.JTextField();
        FechaCreacionText = new javax.swing.JTextField();
        FechaAperturaLabel = new javax.swing.JLabel();
        BuscarCuentaClienteLabel = new javax.swing.JPanel();
        NoCuentaBuscarText = new javax.swing.JTextField();
        NoCuentaClienteBuscalLabel = new javax.swing.JLabel();
        BuscarClienteBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        DeshacerBtn = new javax.swing.JButton();
        RegistrarBtn = new javax.swing.JButton();
        HeaderInfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        VerPerfilBtn = new javax.swing.JButton();
        CerrarSesionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ContenedorDeFunciones.setMaximumSize(new java.awt.Dimension(800, 800));
        ContenedorDeFunciones.setPreferredSize(new java.awt.Dimension(800, 536));

        InfoTransaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transacciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 0, 12))); // NOI18N
        InfoTransaciones.setToolTipText("Text");
        InfoTransaciones.setMaximumSize(new java.awt.Dimension(700, 700));
        InfoTransaciones.setPreferredSize(new java.awt.Dimension(700, 157));

        NoCuentaBuscarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoCuentaBuscarTransActionPerformed(evt);
            }
        });

        jLabel24.setText("NoCuenta");

        BuscarTransBtn.setText("Buscar");

        TablaTransacionesBuscar.setAutoCreateRowSorter(true);
        TablaTransacionesBuscar.setModel(new javax.swing.table.DefaultTableModel(
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
        TransacionesHechasScroll.setViewportView(TablaTransacionesBuscar);

        ImprimirBtn.setText("Imprimir");

        javax.swing.GroupLayout InfoTransacionesLayout = new javax.swing.GroupLayout(InfoTransaciones);
        InfoTransaciones.setLayout(InfoTransacionesLayout);
        InfoTransacionesLayout.setHorizontalGroup(
            InfoTransacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoTransacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoTransacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoTransacionesLayout.createSequentialGroup()
                        .addGroup(InfoTransacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoTransacionesLayout.createSequentialGroup()
                                .addComponent(NoCuentaBuscarTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BuscarTransBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ImprimirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel24))
                        .addGap(0, 560, Short.MAX_VALUE))
                    .addComponent(TransacionesHechasScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE))
                .addContainerGap())
        );
        InfoTransacionesLayout.setVerticalGroup(
            InfoTransacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoTransacionesLayout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoTransacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoCuentaBuscarTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarTransBtn)
                    .addComponent(ImprimirBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TransacionesHechasScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout VerTransacionesPanelLayout = new javax.swing.GroupLayout(VerTransacionesPanel);
        VerTransacionesPanel.setLayout(VerTransacionesPanelLayout);
        VerTransacionesPanelLayout.setHorizontalGroup(
            VerTransacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VerTransacionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InfoTransaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                .addContainerGap())
        );
        VerTransacionesPanelLayout.setVerticalGroup(
            VerTransacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerTransacionesPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(InfoTransaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(296, Short.MAX_VALUE))
        );

        ContenedorDeFunciones.addTab("Ver Transacciones", VerTransacionesPanel);

        OperacionesInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 0, 12))); // NOI18N
        OperacionesInfo.setToolTipText("Text");

        FechaOpTrans.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        CodigoOpLabel.setText("Codigo Operacion");

        CodOpTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodOpTransActionPerformed(evt);
            }
        });

        FechaOperacionLabel.setText("Fecha Operacion");

        DescripcionOpLabel.setText("Descripcion de operacion");

        DescripcionOpTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripcionOpTransActionPerformed(evt);
            }
        });

        TipoOperacionLabel.setText("Tipo operacion");

        TipoOperacionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Deposito", "Retiro"}));

        NoCuentaLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        NoCuentaLabel.setText("NoCuenta");

        try {
            NoCuentaTrans.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        IdTransacionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        IdTransacionLabel.setText("IdTransacion");

        try {
            IdTransacionText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout OperacionesInfoLayout = new javax.swing.GroupLayout(OperacionesInfo);
        OperacionesInfo.setLayout(OperacionesInfoLayout);
        OperacionesInfoLayout.setHorizontalGroup(
            OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperacionesInfoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdTransacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdTransacionText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NoCuentaLabel)
                    .addComponent(NoCuentaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OperacionesInfoLayout.createSequentialGroup()
                        .addComponent(FechaOperacionLabel)
                        .addGap(46, 46, 46)
                        .addComponent(TipoOperacionLabel))
                    .addGroup(OperacionesInfoLayout.createSequentialGroup()
                        .addComponent(FechaOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TipoOperacionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionOpLabel)
                    .addComponent(DescripcionOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodigoOpLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OperacionesInfoLayout.setVerticalGroup(
            OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperacionesInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(OperacionesInfoLayout.createSequentialGroup()
                        .addGroup(OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdTransacionLabel)
                            .addComponent(NoCuentaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdTransacionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OperacionesInfoLayout.createSequentialGroup()
                        .addGroup(OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FechaOperacionLabel)
                            .addComponent(CodigoOpLabel)
                            .addComponent(DescripcionOpLabel)
                            .addComponent(TipoOperacionLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(OperacionesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescripcionOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FechaOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TipoOperacionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NoCuentaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DetalleCuentaInfo3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle cuenta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 0, 12))); // NOI18N
        DetalleCuentaInfo3.setToolTipText("Text");

        SaldoActualTrans6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaldoActualTrans6SaldoActualTransActionPerformed(evt);
            }
        });

        SaldoActualLabel3.setText("Saldo actual");

        ImporteLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ImporteLabel3.setText("IMPORTE");

        ImporteTrans3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImporteTrans3ImporteTransActionPerformed(evt);
            }
        });

        DineroRetiradoLabel3.setText("Dinero retirado");

        DineroRetiradoTrans3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DineroRetiradoTrans3DineroRetiradoTransActionPerformed(evt);
            }
        });

        DineroDepositadoTrans3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DineroDepositadoTrans3DineroDepositadoTransActionPerformed(evt);
            }
        });

        DineroDepositadoLabel3.setText("Dinero depositado");

        NombreLabel3.setText("Nombre Cliente");

        SaldoActualTrans7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaldoActualTrans7SaldoActualTrans1ActionPerformed(evt);
            }
        });

        HacerOperacionBtnTrans3.setBackground(new java.awt.Color(255, 255, 102));
        HacerOperacionBtnTrans3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HacerOperacionBtnTrans3.setText("Hacer operacion");
        HacerOperacionBtnTrans3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HacerOperacionBtnTrans3HacerOperacionBtnTransMouseClicked(evt);
            }
        });

        DeshacerBtnTrans3.setBackground(new java.awt.Color(255, 102, 102));
        DeshacerBtnTrans3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeshacerBtnTrans3.setText("Deshacer");
        DeshacerBtnTrans3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeshacerBtnTrans3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DetalleCuentaInfo3Layout = new javax.swing.GroupLayout(DetalleCuentaInfo3);
        DetalleCuentaInfo3.setLayout(DetalleCuentaInfo3Layout);
        DetalleCuentaInfo3Layout.setHorizontalGroup(
            DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetalleCuentaInfo3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetalleCuentaInfo3Layout.createSequentialGroup()
                        .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DineroRetiradoLabel3)
                            .addComponent(SaldoActualLabel3)
                            .addComponent(NombreLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DetalleCuentaInfo3Layout.createSequentialGroup()
                                .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SaldoActualTrans7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SaldoActualTrans6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ImporteTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ImporteLabel3)))
                            .addComponent(DineroRetiradoTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DetalleCuentaInfo3Layout.createSequentialGroup()
                        .addComponent(DineroDepositadoLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(DineroDepositadoTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(HacerOperacionBtnTrans3)
                .addGap(18, 18, 18)
                .addComponent(DeshacerBtnTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DetalleCuentaInfo3Layout.setVerticalGroup(
            DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetalleCuentaInfo3Layout.createSequentialGroup()
                .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SaldoActualTrans7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NombreLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(ImporteLabel3))
                .addGap(9, 9, 9)
                .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetalleCuentaInfo3Layout.createSequentialGroup()
                        .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaldoActualLabel3)
                            .addComponent(SaldoActualTrans6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImporteTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DineroRetiradoLabel3)
                            .addComponent(DineroRetiradoTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DineroDepositadoLabel3)
                            .addComponent(DineroDepositadoTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DetalleCuentaInfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HacerOperacionBtnTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeshacerBtnTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        BancoInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Banco", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 0, 12))); // NOI18N
        BancoInfo.setToolTipText("Text");

        IdBancoTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdBancoTransActionPerformed(evt);
            }
        });

        IdBancoLabel.setText("IdBanco");

        NombreBancoLabel.setText("Nombre banco");

        NombreBancoTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreBancoTransActionPerformed(evt);
            }
        });

        IdAgenciaLabel.setText("IdAgencia");

        IdAgenciaTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdAgenciaTransActionPerformed(evt);
            }
        });

        NombreAgenciaTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreAgenciaTransActionPerformed(evt);
            }
        });

        NombreAgenciaLabel.setText("Nombre agencia");

        javax.swing.GroupLayout BancoInfoLayout = new javax.swing.GroupLayout(BancoInfo);
        BancoInfo.setLayout(BancoInfoLayout);
        BancoInfoLayout.setHorizontalGroup(
            BancoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BancoInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BancoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BancoInfoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(IdBancoLabel))
                    .addComponent(IdBancoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BancoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombreBancoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreBancoLabel))
                .addGap(18, 18, 18)
                .addGroup(BancoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdAgenciaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdAgenciaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BancoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombreAgenciaLabel)
                    .addComponent(NombreAgenciaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(416, Short.MAX_VALUE))
        );
        BancoInfoLayout.setVerticalGroup(
            BancoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BancoInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BancoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BancoInfoLayout.createSequentialGroup()
                        .addComponent(NombreAgenciaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NombreAgenciaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BancoInfoLayout.createSequentialGroup()
                        .addGroup(BancoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdBancoLabel)
                            .addComponent(NombreBancoLabel)
                            .addComponent(IdAgenciaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BancoInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdBancoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreBancoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdAgenciaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TransacinoesAgregadasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 0, 12))); // NOI18N
        TransacinoesAgregadasPanel.setToolTipText("Text");
        TransacinoesAgregadasPanel.setMaximumSize(new java.awt.Dimension(700, 700));
        TransacinoesAgregadasPanel.setPreferredSize(new java.awt.Dimension(700, 157));

        TablaTransaciones.setAutoCreateRowSorter(true);
        TablaTransaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdTransacion", "CuentaAfectada", "TipoOperacion", "Descripcion", "CodigoOperacion", "Nombre cliete", "Importe", "SaldoAnterior", "SaldoActual"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TransacionesAgregadasScroll.setViewportView(TablaTransaciones);

        javax.swing.GroupLayout TransacinoesAgregadasPanelLayout = new javax.swing.GroupLayout(TransacinoesAgregadasPanel);
        TransacinoesAgregadasPanel.setLayout(TransacinoesAgregadasPanelLayout);
        TransacinoesAgregadasPanelLayout.setHorizontalGroup(
            TransacinoesAgregadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransacinoesAgregadasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TransacionesAgregadasScroll))
        );
        TransacinoesAgregadasPanelLayout.setVerticalGroup(
            TransacinoesAgregadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransacinoesAgregadasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TransacionesAgregadasScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HacerTransacionPanelLayout = new javax.swing.GroupLayout(HacerTransacionPanel);
        HacerTransacionPanel.setLayout(HacerTransacionPanelLayout);
        HacerTransacionPanelLayout.setHorizontalGroup(
            HacerTransacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HacerTransacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HacerTransacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OperacionesInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DetalleCuentaInfo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BancoInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TransacinoesAgregadasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)))
        );
        HacerTransacionPanelLayout.setVerticalGroup(
            HacerTransacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HacerTransacionPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(OperacionesInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DetalleCuentaInfo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BancoInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TransacinoesAgregadasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        ContenedorDeFunciones.addTab("Hacer Transaccion", HacerTransacionPanel);

        InfoClientePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 0, 12))); // NOI18N
        InfoClientePanel.setToolTipText("Text");

        IdClienteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdClienteTextActionPerformed(evt);
            }
        });

        IdClienteLabel.setText("IdCliente");

        ApellidosClientLabel.setText("Apellidos");

        ApellidosText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidosTextActionPerformed(evt);
            }
        });

        NombresClienteLabel.setText("Nombres");

        NombresText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombresTextActionPerformed(evt);
            }
        });

        FechaNacText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaNacTextActionPerformed(evt);
            }
        });

        FechaNacClientLabel.setText("Fecha nacimiento");

        GenSexClientLabel.setText("Genero sexual");

        SexoCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Hombre", "Mujer", "Gay" }));

        EstadoCivilClientLabel.setText("Estado civil");

        EstadoCivilCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Casado", "Soltero", "Viudo", "Union libre" }));

        NoCuentaClienteLabel.setText("NoCedula");

        CedulaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaTextActionPerformed(evt);
            }
        });

        EmailClientLabel.setText("Correo electronico");

        CorreoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoTextActionPerformed(evt);
            }
        });

        DirecionClientLabel.setText("Direccion");

        DireccionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoClientePanelLayout = new javax.swing.GroupLayout(InfoClientePanel);
        InfoClientePanel.setLayout(InfoClientePanelLayout);
        InfoClientePanelLayout.setHorizontalGroup(
            InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EstadoCivilClientLabel)
                    .addGroup(InfoClientePanelLayout.createSequentialGroup()
                        .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EstadoCivilCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(IdClienteLabel)
                                .addComponent(NombresText, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(NombresClienteLabel)
                                .addComponent(IdClienteText)))
                        .addGap(6, 6, 6)
                        .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoClientePanelLayout.createSequentialGroup()
                                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ApellidosClientLabel)
                                    .addComponent(NoCuentaClienteLabel)
                                    .addComponent(CedulaText, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(GenSexClientLabel)
                                    .addComponent(FechaNacClientLabel)
                                    .addComponent(FechaNacText, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoClientePanelLayout.createSequentialGroup()
                                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EmailClientLabel)
                                    .addComponent(ApellidosText, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CorreoText))
                                .addGap(18, 18, 18)
                                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SexoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DirecionClientLabel)
                                    .addComponent(DireccionText, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(13, 13, 13))
        );
        InfoClientePanelLayout.setVerticalGroup(
            InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanelLayout.createSequentialGroup()
                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoClientePanelLayout.createSequentialGroup()
                        .addComponent(IdClienteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdClienteText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InfoClientePanelLayout.createSequentialGroup()
                        .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NoCuentaClienteLabel)
                            .addComponent(FechaNacClientLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CedulaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FechaNacText))))
                .addGap(15, 15, 15)
                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombresClienteLabel)
                    .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ApellidosClientLabel)
                        .addComponent(GenSexClientLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombresText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApellidosText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SexoCombo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EstadoCivilClientLabel)
                    .addComponent(EmailClientLabel)
                    .addComponent(DirecionClientLabel))
                .addGap(10, 10, 10)
                .addGroup(InfoClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EstadoCivilCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CorreoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DireccionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        CuentaClienteInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuenta cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 0, 12))); // NOI18N
        CuentaClienteInfo.setToolTipText("Text");

        IdCuentaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdCuentaTextActionPerformed(evt);
            }
        });

        IdCuentaLabel.setText("IdCuenta");

        NoCuentaClientLabel.setText("NoCuenta");

        NoCuentaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoCuentaTextActionPerformed(evt);
            }
        });

        TipoCuentaLabel.setText("Tipo cuenta");

        TipoCuentaCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Clasica", "Premium" }));

        SaldoCuentaLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SaldoCuentaLabel.setText("Saldo apertura");

        SaldoAperturaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaldoAperturaTextActionPerformed(evt);
            }
        });

        FechaCreacionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaCreacionTextActionPerformed(evt);
            }
        });

        FechaAperturaLabel.setText("Fecha creacion");

        javax.swing.GroupLayout CuentaClienteInfoLayout = new javax.swing.GroupLayout(CuentaClienteInfo);
        CuentaClienteInfo.setLayout(CuentaClienteInfoLayout);
        CuentaClienteInfoLayout.setHorizontalGroup(
            CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CuentaClienteInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FechaCreacionText)
                    .addComponent(IdCuentaText, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdCuentaLabel)
                    .addComponent(FechaAperturaLabel))
                .addGap(10, 10, 10)
                .addGroup(CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CuentaClienteInfoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(SaldoCuentaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SaldoAperturaText, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CuentaClienteInfoLayout.createSequentialGroup()
                        .addGroup(CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoCuentaText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NoCuentaClientLabel))
                        .addGroup(CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CuentaClienteInfoLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(TipoCuentaLabel))
                            .addGroup(CuentaClienteInfoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TipoCuentaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        CuentaClienteInfoLayout.setVerticalGroup(
            CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CuentaClienteInfoLayout.createSequentialGroup()
                .addGroup(CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdCuentaLabel)
                    .addComponent(NoCuentaClientLabel)
                    .addComponent(TipoCuentaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoCuentaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdCuentaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoCuentaCombo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaAperturaLabel)
                    .addComponent(SaldoCuentaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CuentaClienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaCreacionText)
                    .addComponent(SaldoAperturaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        BuscarCuentaClienteLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 0, 12))); // NOI18N
        BuscarCuentaClienteLabel.setToolTipText("Text");
        BuscarCuentaClienteLabel.setMaximumSize(new java.awt.Dimension(700, 700));
        BuscarCuentaClienteLabel.setPreferredSize(new java.awt.Dimension(700, 157));

        NoCuentaBuscarText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoCuentaBuscarTextActionPerformed(evt);
            }
        });

        NoCuentaClienteBuscalLabel.setText("NoCuenta");

        BuscarClienteBtn.setText("Buscar");

        TablaCliente.setAutoCreateRowSorter(true);
        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdCliente", "NoCedula", "Nombres", "Apellidos", "Estado Civil", "Email", "Direccion", "FechaNac", "Sexo"
            }
        ));
        jScrollPane2.setViewportView(TablaCliente);

        javax.swing.GroupLayout BuscarCuentaClienteLabelLayout = new javax.swing.GroupLayout(BuscarCuentaClienteLabel);
        BuscarCuentaClienteLabel.setLayout(BuscarCuentaClienteLabelLayout);
        BuscarCuentaClienteLabelLayout.setHorizontalGroup(
            BuscarCuentaClienteLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscarCuentaClienteLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BuscarCuentaClienteLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(BuscarCuentaClienteLabelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(BuscarCuentaClienteLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoCuentaClienteBuscalLabel)
                            .addGroup(BuscarCuentaClienteLabelLayout.createSequentialGroup()
                                .addComponent(NoCuentaBuscarText, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BuscarClienteBtn)))
                        .addGap(0, 560, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BuscarCuentaClienteLabelLayout.setVerticalGroup(
            BuscarCuentaClienteLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscarCuentaClienteLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NoCuentaClienteBuscalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BuscarCuentaClienteLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoCuentaBuscarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarClienteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        DeshacerBtn.setText("Deshacer");

        RegistrarBtn.setText("Registrar");

        javax.swing.GroupLayout CrearClientePanelLayout = new javax.swing.GroupLayout(CrearClientePanel);
        CrearClientePanel.setLayout(CrearClientePanelLayout);
        CrearClientePanelLayout.setHorizontalGroup(
            CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearClientePanelLayout.createSequentialGroup()
                .addGroup(CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearClientePanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(DeshacerBtn)
                        .addGap(18, 18, 18)
                        .addComponent(RegistrarBtn))
                    .addGroup(CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BuscarCuentaClienteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                        .addGroup(CrearClientePanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(InfoClientePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(CuentaClienteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CrearClientePanelLayout.setVerticalGroup(
            CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearClientePanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CuentaClienteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InfoClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegistrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeshacerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BuscarCuentaClienteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        ContenedorDeFunciones.addTab("Crear Cliente", CrearClientePanel);

        HeaderInfo.setBackground(new java.awt.Color(255, 204, 0));

        jLabel3.setFont(new java.awt.Font("Source Sans Pro", 0, 24)); // NOI18N
        jLabel3.setText("Banpais");

        VerPerfilBtn.setText("Perfil");

        CerrarSesionBtn.setText("Cerrar sesion");

        javax.swing.GroupLayout HeaderInfoLayout = new javax.swing.GroupLayout(HeaderInfo);
        HeaderInfo.setLayout(HeaderInfoLayout);
        HeaderInfoLayout.setHorizontalGroup(
            HeaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderInfoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(109, 109, 109)
                .addComponent(VerPerfilBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CerrarSesionBtn)
                .addContainerGap(618, Short.MAX_VALUE))
        );
        HeaderInfoLayout.setVerticalGroup(
            HeaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HeaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(VerPerfilBtn)
                    .addComponent(CerrarSesionBtn))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ContenedorDeFunciones, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(HeaderInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeaderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ContenedorDeFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IdCuentaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdCuentaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdCuentaTextActionPerformed

    private void NoCuentaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoCuentaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoCuentaTextActionPerformed

    private void SaldoAperturaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaldoAperturaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaldoAperturaTextActionPerformed

    private void FechaCreacionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaCreacionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaCreacionTextActionPerformed

    private void DescripcionOpTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionOpTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionOpTransActionPerformed

    private void CodOpTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodOpTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodOpTransActionPerformed

    private void DireccionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionTextActionPerformed

    private void CorreoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreoTextActionPerformed

    private void CedulaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CedulaTextActionPerformed

    private void FechaNacTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaNacTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaNacTextActionPerformed

    private void NombresTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombresTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombresTextActionPerformed

    private void ApellidosTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidosTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosTextActionPerformed

    private void IdClienteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdClienteTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdClienteTextActionPerformed

    private void NoCuentaBuscarTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoCuentaBuscarTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoCuentaBuscarTextActionPerformed

    private void NoCuentaBuscarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoCuentaBuscarTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoCuentaBuscarTransActionPerformed

    private void SaldoActualTrans6SaldoActualTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaldoActualTrans6SaldoActualTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaldoActualTrans6SaldoActualTransActionPerformed

    private void ImporteTrans3ImporteTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImporteTrans3ImporteTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImporteTrans3ImporteTransActionPerformed

    private void DineroRetiradoTrans3DineroRetiradoTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DineroRetiradoTrans3DineroRetiradoTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DineroRetiradoTrans3DineroRetiradoTransActionPerformed

    private void DineroDepositadoTrans3DineroDepositadoTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DineroDepositadoTrans3DineroDepositadoTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DineroDepositadoTrans3DineroDepositadoTransActionPerformed

    private void SaldoActualTrans7SaldoActualTrans1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaldoActualTrans7SaldoActualTrans1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaldoActualTrans7SaldoActualTrans1ActionPerformed

    private void IdBancoTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdBancoTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdBancoTransActionPerformed

    private void NombreBancoTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreBancoTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreBancoTransActionPerformed

    private void IdAgenciaTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdAgenciaTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdAgenciaTransActionPerformed

    private void NombreAgenciaTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreAgenciaTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreAgenciaTransActionPerformed

    private void HacerOperacionBtnTrans3HacerOperacionBtnTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HacerOperacionBtnTrans3HacerOperacionBtnTransMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_HacerOperacionBtnTrans3HacerOperacionBtnTransMouseClicked

    private void DeshacerBtnTrans3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeshacerBtnTrans3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeshacerBtnTrans3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApellidosClientLabel;
    private javax.swing.JTextField ApellidosText;
    private javax.swing.JPanel BancoInfo;
    private javax.swing.JButton BuscarClienteBtn;
    private javax.swing.JPanel BuscarCuentaClienteLabel;
    private javax.swing.JButton BuscarTransBtn;
    private javax.swing.JTextField CedulaText;
    private javax.swing.JButton CerrarSesionBtn;
    private javax.swing.JTextField CodOpTrans;
    private javax.swing.JLabel CodigoOpLabel;
    private javax.swing.JTabbedPane ContenedorDeFunciones;
    private javax.swing.JTextField CorreoText;
    private javax.swing.JPanel CrearClientePanel;
    private javax.swing.JPanel CuentaClienteInfo;
    private javax.swing.JLabel DescripcionOpLabel;
    private javax.swing.JTextField DescripcionOpTrans;
    private javax.swing.JButton DeshacerBtn;
    private javax.swing.JButton DeshacerBtnTrans3;
    private javax.swing.JPanel DetalleCuentaInfo3;
    private javax.swing.JLabel DineroDepositadoLabel3;
    private javax.swing.JTextField DineroDepositadoTrans3;
    private javax.swing.JLabel DineroRetiradoLabel3;
    private javax.swing.JTextField DineroRetiradoTrans3;
    private javax.swing.JTextField DireccionText;
    private javax.swing.JLabel DirecionClientLabel;
    private javax.swing.JLabel EmailClientLabel;
    private javax.swing.JLabel EstadoCivilClientLabel;
    private javax.swing.JComboBox EstadoCivilCombo;
    private javax.swing.JLabel FechaAperturaLabel;
    private javax.swing.JTextField FechaCreacionText;
    private javax.swing.JLabel FechaNacClientLabel;
    private javax.swing.JTextField FechaNacText;
    private javax.swing.JFormattedTextField FechaOpTrans;
    private javax.swing.JLabel FechaOperacionLabel;
    private javax.swing.JLabel GenSexClientLabel;
    private javax.swing.JButton HacerOperacionBtnTrans3;
    private javax.swing.JPanel HacerTransacionPanel;
    private javax.swing.JPanel HeaderInfo;
    private javax.swing.JLabel IdAgenciaLabel;
    private javax.swing.JTextField IdAgenciaTrans;
    private javax.swing.JLabel IdBancoLabel;
    private javax.swing.JTextField IdBancoTrans;
    private javax.swing.JLabel IdClienteLabel;
    private javax.swing.JTextField IdClienteText;
    private javax.swing.JLabel IdCuentaLabel;
    private javax.swing.JTextField IdCuentaText;
    private javax.swing.JLabel IdTransacionLabel;
    private javax.swing.JFormattedTextField IdTransacionText;
    private javax.swing.JLabel ImporteLabel3;
    private javax.swing.JTextField ImporteTrans3;
    private javax.swing.JButton ImprimirBtn;
    private javax.swing.JPanel InfoClientePanel;
    private javax.swing.JPanel InfoTransaciones;
    private javax.swing.JTextField NoCuentaBuscarText;
    private javax.swing.JTextField NoCuentaBuscarTrans;
    private javax.swing.JLabel NoCuentaClientLabel;
    private javax.swing.JLabel NoCuentaClienteBuscalLabel;
    private javax.swing.JLabel NoCuentaClienteLabel;
    private javax.swing.JLabel NoCuentaLabel;
    private javax.swing.JTextField NoCuentaText;
    private javax.swing.JFormattedTextField NoCuentaTrans;
    private javax.swing.JLabel NombreAgenciaLabel;
    private javax.swing.JTextField NombreAgenciaTrans;
    private javax.swing.JLabel NombreBancoLabel;
    private javax.swing.JTextField NombreBancoTrans;
    private javax.swing.JLabel NombreLabel3;
    private javax.swing.JLabel NombresClienteLabel;
    private javax.swing.JTextField NombresText;
    private javax.swing.JPanel OperacionesInfo;
    private javax.swing.JButton RegistrarBtn;
    private javax.swing.JLabel SaldoActualLabel3;
    private javax.swing.JTextField SaldoActualTrans6;
    private javax.swing.JTextField SaldoActualTrans7;
    private javax.swing.JTextField SaldoAperturaText;
    private javax.swing.JLabel SaldoCuentaLabel;
    private javax.swing.JComboBox SexoCombo;
    private javax.swing.JTable TablaCliente;
    private javax.swing.JTable TablaTransaciones;
    private javax.swing.JTable TablaTransacionesBuscar;
    private javax.swing.JComboBox TipoCuentaCombo;
    private javax.swing.JLabel TipoCuentaLabel;
    private javax.swing.JComboBox TipoOperacionCombo;
    private javax.swing.JLabel TipoOperacionLabel;
    private javax.swing.JPanel TransacinoesAgregadasPanel;
    private javax.swing.JScrollPane TransacionesAgregadasScroll;
    private javax.swing.JScrollPane TransacionesHechasScroll;
    private javax.swing.JButton VerPerfilBtn;
    private javax.swing.JPanel VerTransacionesPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
