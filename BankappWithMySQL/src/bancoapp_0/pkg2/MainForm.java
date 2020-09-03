/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoapp_0.pkg2;

import Datos.Archivo;
import Datos.ArregloArchivo;
import Modelos.Agencia;
import Modelos.Cliente;
import Modelos.Cuenta;
import Modelos.Empleados;
import Modelos.EstadoCiv;
import Modelos.Sesion;
import Modelos.Sexo;
import Modelos.Transaccion;
import Modelos.Usuario;
import SqlDatabase.SentenciasSql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ariel
 */
public class MainForm extends JFrame {

    final SentenciasSql bankdb;
    public MainForm() {
        initComponents();

        AgregarComponentesConPermiso();
        InicializarComponentesConDatos();
        InitizalizarTablas();
        
        bankdb = new SentenciasSql();
    }

    public void AgregarComponentesConPermiso() {

        ArregloArchivo ar = new ArregloArchivo();
        String rutaAcceso = "src/Datos/Usuario_Acceso.txt";

        if (ar.bus_linea(rutaAcceso, Sesion.IdUser + ";11;")) {
        } else {
            ContenedorDeFunciones.setEnabledAt(0, false);
        }

        if (ar.bus_linea(rutaAcceso, Sesion.IdUser + ";12;")) {
        } else {
            ContenedorDeFunciones.setEnabledAt(1, false);
        }

        if (ar.bus_linea(rutaAcceso, Sesion.IdUser + ";13;")) {
        } else {
            ContenedorDeFunciones.setEnabledAt(2, false);
        }

        if (ar.bus_linea(rutaAcceso, Sesion.IdUser + ";14;")) {
        } else {
            ContenedorDeFunciones.setEnabledAt(3, false);
        }

       
    }

    public void InicializarTransaciones() {

        IdBancoTrans.setText("1");
        NombreBancoTrans.setText("Banpais HN");
        IdAgenciaTrans.setText("" + Sesion.sucursal.IdSucursal);
        NombreAgenciaTrans.setText(Sesion.sucursal.Nombre);

        Archivo fileTrans = new Archivo("src/Datos/Transacciones.txt");
        String filasTrans[] = fileTrans.TToString().split("\n");

        if (filasTrans.length == 1) {
            IdTransacc.setText("1");
        } else {
            int lastTransId = 0;

            for (int i = 1; i < filasTrans.length; i++) {
                String props[] = filasTrans[i].split(";");
                lastTransId = Integer.parseInt(props[0]) + 1;
            }
            IdTransacc.setText(Integer.toString(lastTransId));

        }
    }

    public void InicializarAccesos() {
        String accesos[] = new Archivo("src/Datos/Accesos.txt").TToString().trim().split("\n");
        check = new JCheckBox[accesos.length - 1];
        info_ac = new String[accesos.length - 1];

        int xx = 10, yy = 30;
        int cont = 0;
        for (int i = 0; i < check.length; i++) {
            String inter[] = accesos[i + 1].trim().split(";");
            check[i] = new JCheckBox(inter[1]);
            info_ac[i] = inter[0];

            check[i].setBounds(xx, yy, 160, 20);
            xx += 160;
            cont++;
            if (cont == 4) {
                yy += 30;
                xx = 10;
                cont = 0;
            }
            AccesosPanel.add(check[i]);
        }
    }

    public void InicializarComponentesConDatos() {
        InicializarTransaciones();
        AutoIncrementarIDCliente();
        llenarUserenCombo();

        InicializarAccesos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeaderInfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CerrarSesionBtn = new javax.swing.JButton();
        ContenedorDeFunciones = new javax.swing.JTabbedPane();
        HacerTransacionesPanel = new javax.swing.JPanel();
        InfoClientePanel1 = new javax.swing.JPanel();
        FechaOperacionLabel = new javax.swing.JLabel();
        DescripcionOpLabel = new javax.swing.JLabel();
        DescripcionOpTrans = new javax.swing.JTextField();
        TipoOperacionLabel = new javax.swing.JLabel();
        TipoOperacionCombo = new javax.swing.JComboBox();
        NoCuentaLabel = new javax.swing.JLabel();
        CodigoOpLabel = new javax.swing.JLabel();
        CodOpTrans = new javax.swing.JTextField();
        IdTransacionLabel = new javax.swing.JLabel();
        Nocuenta = new javax.swing.JTextField();
        FechaOperacionT = new javax.swing.JTextField();
        IdTransacc = new javax.swing.JTextField();
        InfoClientePanel3 = new javax.swing.JPanel();
        TransacionesAgregadasScroll = new javax.swing.JScrollPane();
        TablaTransaciones = new javax.swing.JTable();
        NoCuentaBuscarTrans = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        ImprimirBtn = new javax.swing.JButton();
        InfoClientePanel2 = new javax.swing.JPanel();
        SaldoActualLabel3 = new javax.swing.JLabel();
        ImporteLabel3 = new javax.swing.JLabel();
        ImporteTrans = new javax.swing.JTextField();
        DineroRetiradoLabel3 = new javax.swing.JLabel();
        SaldoNuevoTrans = new javax.swing.JTextField();
        NombreLabel3 = new javax.swing.JLabel();
        NombreClienteTrans = new javax.swing.JTextField();
        HacerOperacionBtnTrans3 = new javax.swing.JButton();
        DeshacerBtnTrans3 = new javax.swing.JButton();
        SaldoActualTrans = new javax.swing.JTextField();
        NombreBancoLabel = new javax.swing.JLabel();
        IdAgenciaTrans = new javax.swing.JTextField();
        IdBancoTrans = new javax.swing.JTextField();
        NombreAgenciaLabel = new javax.swing.JLabel();
        IdBancoLabel = new javax.swing.JLabel();
        IdAgenciaLabel = new javax.swing.JLabel();
        NombreAgenciaTrans = new javax.swing.JTextField();
        NombreBancoTrans = new javax.swing.JTextField();
        CrearClientePanel = new javax.swing.JPanel();
        InfoClientePanel = new javax.swing.JPanel();
        IdClienteLabel = new javax.swing.JLabel();
        NoCuentaClienteLabel = new javax.swing.JLabel();
        ApellidosClientLabel = new javax.swing.JLabel();
        CedulaText = new javax.swing.JTextField();
        ApellidosText = new javax.swing.JTextField();
        EmailClientLabel = new javax.swing.JLabel();
        NombresClienteLabel = new javax.swing.JLabel();
        CorreoText = new javax.swing.JTextField();
        NombresText = new javax.swing.JTextField();
        DirecionClientLabel = new javax.swing.JLabel();
        FechaNacText = new javax.swing.JTextField();
        DireccionText = new javax.swing.JTextField();
        FechaNacClientLabel = new javax.swing.JLabel();
        GenSexClientLabel = new javax.swing.JLabel();
        SexoCombo = new javax.swing.JComboBox();
        EstadoCivilClientLabel = new javax.swing.JLabel();
        IdClienteText = new javax.swing.JTextField();
        EstadoCivilCombo = new javax.swing.JComboBox();
        InfoCuentaPanel = new javax.swing.JPanel();
        TipoCuentaLabel = new javax.swing.JLabel();
        TipoCuentaCombo = new javax.swing.JComboBox();
        SaldoCuentaLabel = new javax.swing.JLabel();
        SaldoAperturaText = new javax.swing.JTextField();
        FechaCreacionText = new javax.swing.JTextField();
        FechaAperturaLabel = new javax.swing.JLabel();
        IdCuentaText = new javax.swing.JTextField();
        IdCuentaLabel = new javax.swing.JLabel();
        NoCuentaClientLabel = new javax.swing.JLabel();
        NoCuentaText = new javax.swing.JTextField();
        CuentasAgregadasPanel = new javax.swing.JPanel();
        NoCuentaBuscarText = new javax.swing.JTextField();
        NoCuentaClienteBuscalLabel = new javax.swing.JLabel();
        TablaClienteScroll = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        GenerarUsuarioBtn = new javax.swing.JButton();
        DeshacerBtn = new javax.swing.JButton();
        RegistrarBtn = new javax.swing.JButton();
        AccesosPanel = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        UsuarioPermisoCombo = new javax.swing.JComboBox<>();
        BtnGenerarPermisos = new javax.swing.JButton();
        BtnActualizarPermisos = new javax.swing.JButton();
        ComboUserId = new javax.swing.JComboBox<>();
        CrearEmpleadoPanel = new javax.swing.JPanel();
        InfoClientePanel5 = new javax.swing.JPanel();
        Apellido = new javax.swing.JLabel();
        DescripcionOpLabel3 = new javax.swing.JLabel();
        CedulaEmpT = new javax.swing.JTextField();
        NoCuentaLabel3 = new javax.swing.JLabel();
        CodigoOpLabel1 = new javax.swing.JLabel();
        IdTransacionLabel3 = new javax.swing.JLabel();
        NombreEmpleadoT = new javax.swing.JTextField();
        ApellidoEmpT = new javax.swing.JTextField();
        TipoUsuarioCombo = new javax.swing.JComboBox();
        IdEmpleadoTT = new javax.swing.JTextField();
        InfoClientePanel6 = new javax.swing.JPanel();
        Apellido1 = new javax.swing.JLabel();
        NoCuentaLabel4 = new javax.swing.JLabel();
        CodigoOpLabel2 = new javax.swing.JLabel();
        IdTransacionLabel4 = new javax.swing.JLabel();
        UsuarioT = new javax.swing.JTextField();
        ContrasenaT = new javax.swing.JTextField();
        EstadoCombo = new javax.swing.JComboBox();
        IdUsuarioTT = new javax.swing.JTextField();
        DeshacerBtnTrans4 = new javax.swing.JButton();
        UsuariosPanel = new javax.swing.JPanel();
        NoCuentaBuscarText1 = new javax.swing.JTextField();
        NoCuentaClienteBuscalLabel1 = new javax.swing.JLabel();
        TablaClienteScroll1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        BtnAgregarEmp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(1);
        setPreferredSize(new java.awt.Dimension(950, 640));
        setSize(new java.awt.Dimension(700, 700));

        HeaderInfo.setBackground(new java.awt.Color(255, 204, 0));

        jLabel3.setFont(new java.awt.Font("Source Sans Pro", 0, 24)); // NOI18N
        jLabel3.setText("Banpais");

        CerrarSesionBtn.setText("Cerrar sesion");
        CerrarSesionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderInfoLayout = new javax.swing.GroupLayout(HeaderInfo);
        HeaderInfo.setLayout(HeaderInfoLayout);
        HeaderInfoLayout.setHorizontalGroup(
            HeaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderInfoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CerrarSesionBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderInfoLayout.setVerticalGroup(
            HeaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HeaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CerrarSesionBtn))
                .addGap(22, 22, 22))
        );

        ContenedorDeFunciones.setPreferredSize(new java.awt.Dimension(780, 600));

        HacerTransacionesPanel.setPreferredSize(new java.awt.Dimension(975, 800));

        InfoClientePanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Info Operacion"));

        FechaOperacionLabel.setText("Fecha Operacion");

        DescripcionOpLabel.setText("Descripcion de operacion");

        TipoOperacionLabel.setText("Tipo operacion");

        TipoOperacionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Deposito", "Retiro"}));
        TipoOperacionCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TipoOperacionComboItemStateChanged(evt);
            }
        });

        NoCuentaLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        NoCuentaLabel.setText("NoCuenta");

        CodigoOpLabel.setText("Codigo Operacion");

        IdTransacionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        IdTransacionLabel.setText("IdTransacion");

        Nocuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NocuentaKeyReleased(evt);
            }
        });

        IdTransacc.setEditable(false);

        javax.swing.GroupLayout InfoClientePanel1Layout = new javax.swing.GroupLayout(InfoClientePanel1);
        InfoClientePanel1.setLayout(InfoClientePanel1Layout);
        InfoClientePanel1Layout.setHorizontalGroup(
            InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdTransacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdTransacc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NoCuentaLabel)
                    .addComponent(Nocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoClientePanel1Layout.createSequentialGroup()
                        .addComponent(FechaOperacionLabel)
                        .addGap(46, 46, 46)
                        .addComponent(TipoOperacionLabel))
                    .addGroup(InfoClientePanel1Layout.createSequentialGroup()
                        .addComponent(FechaOperacionT, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TipoOperacionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionOpLabel)
                    .addComponent(DescripcionOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CodigoOpLabel)
                    .addComponent(CodOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        InfoClientePanel1Layout.setVerticalGroup(
            InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanel1Layout.createSequentialGroup()
                .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoClientePanel1Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FechaOperacionLabel)
                            .addComponent(CodigoOpLabel)
                            .addComponent(DescripcionOpLabel)
                            .addComponent(TipoOperacionLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescripcionOpTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TipoOperacionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(InfoClientePanel1Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NoCuentaLabel)
                            .addComponent(IdTransacionLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoClientePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FechaOperacionT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdTransacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        InfoClientePanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Info Operacion"));

        TablaTransaciones.setAutoCreateRowSorter(true);
        TablaTransaciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TablaTransaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TransacionesAgregadasScroll.setViewportView(TablaTransaciones);

        NoCuentaBuscarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoCuentaBuscarTransActionPerformed(evt);
            }
        });

        jLabel24.setText("NoCuenta");

        ImprimirBtn.setText("Imprimir");

        InfoClientePanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Transacion"));

        SaldoActualLabel3.setText("Saldo actual");

        ImporteLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ImporteLabel3.setText("IMPORTE");

        ImporteTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImporteTransImporteTransActionPerformed(evt);
            }
        });
        ImporteTrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ImporteTransKeyReleased(evt);
            }
        });

        DineroRetiradoLabel3.setText("Nuevo saldo");

        SaldoNuevoTrans.setEditable(false);
        SaldoNuevoTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaldoNuevoTransDineroRetiradoTransActionPerformed(evt);
            }
        });

        NombreLabel3.setText("Nombre Cliente");

        NombreClienteTrans.setEditable(false);
        NombreClienteTrans.setText(" ");
        NombreClienteTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NombreClienteTransMouseReleased(evt);
            }
        });
        NombreClienteTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreClienteTransSaldoActualTrans1ActionPerformed(evt);
            }
        });

        HacerOperacionBtnTrans3.setBackground(new java.awt.Color(255, 255, 102));
        HacerOperacionBtnTrans3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HacerOperacionBtnTrans3.setText("Hacer operacion");
        HacerOperacionBtnTrans3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HacerOperacionBtnTrans3ActionPerformed(evt);
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

        SaldoActualTrans.setEditable(false);
        SaldoActualTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaldoActualTransSaldoActualTransActionPerformed(evt);
            }
        });

        NombreBancoLabel.setText("Nombre banco");

        IdAgenciaTrans.setEditable(false);
        IdAgenciaTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdAgenciaTransActionPerformed(evt);
            }
        });

        IdBancoTrans.setEditable(false);
        IdBancoTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdBancoTransActionPerformed(evt);
            }
        });

        NombreAgenciaLabel.setText("Nombre agencia");

        IdBancoLabel.setText("IdBanco");

        IdAgenciaLabel.setText("IdAgencia");

        NombreAgenciaTrans.setEditable(false);
        NombreAgenciaTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreAgenciaTransActionPerformed(evt);
            }
        });

        NombreBancoTrans.setEditable(false);
        NombreBancoTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreBancoTransActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoClientePanel2Layout = new javax.swing.GroupLayout(InfoClientePanel2);
        InfoClientePanel2.setLayout(InfoClientePanel2Layout);
        InfoClientePanel2Layout.setHorizontalGroup(
            InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoClientePanel2Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoClientePanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(IdBancoLabel))
                            .addComponent(IdBancoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreBancoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreBancoLabel)))
                    .addGroup(InfoClientePanel2Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DineroRetiradoLabel3)
                            .addComponent(SaldoActualLabel3)
                            .addComponent(NombreLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SaldoActualTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaldoNuevoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreClienteTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImporteLabel3)
                    .addGroup(InfoClientePanel2Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdAgenciaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdAgenciaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreAgenciaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreAgenciaLabel)))
                    .addComponent(ImporteTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HacerOperacionBtnTrans3)
                    .addComponent(DeshacerBtnTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(615, Short.MAX_VALUE))
        );
        InfoClientePanel2Layout.setVerticalGroup(
            InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HacerOperacionBtnTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeshacerBtnTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(InfoClientePanel2Layout.createSequentialGroup()
                .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NombreClienteTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ImporteLabel3))
                    .addComponent(NombreLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(13, 13, 13)
                .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaldoActualLabel3)
                    .addComponent(SaldoActualTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImporteTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DineroRetiradoLabel3)
                    .addComponent(SaldoNuevoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InfoClientePanel2Layout.createSequentialGroup()
                        .addComponent(NombreAgenciaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NombreAgenciaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InfoClientePanel2Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdBancoLabel)
                            .addComponent(NombreBancoLabel)
                            .addComponent(IdAgenciaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoClientePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdBancoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreBancoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdAgenciaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout InfoClientePanel3Layout = new javax.swing.GroupLayout(InfoClientePanel3);
        InfoClientePanel3.setLayout(InfoClientePanel3Layout);
        InfoClientePanel3Layout.setHorizontalGroup(
            InfoClientePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InfoClientePanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(InfoClientePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoClientePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InfoClientePanel3Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoClientePanel3Layout.createSequentialGroup()
                                .addComponent(NoCuentaBuscarTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ImprimirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel24))
                        .addGap(0, 1072, Short.MAX_VALUE))
                    .addComponent(TransacionesAgregadasScroll))
                .addContainerGap())
        );
        InfoClientePanel3Layout.setVerticalGroup(
            InfoClientePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoClientePanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(InfoClientePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoClientePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoCuentaBuscarTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImprimirBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransacionesAgregadasScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HacerTransacionesPanelLayout = new javax.swing.GroupLayout(HacerTransacionesPanel);
        HacerTransacionesPanel.setLayout(HacerTransacionesPanelLayout);
        HacerTransacionesPanelLayout.setHorizontalGroup(
            HacerTransacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HacerTransacionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HacerTransacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InfoClientePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(HacerTransacionesPanelLayout.createSequentialGroup()
                        .addComponent(InfoClientePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        HacerTransacionesPanelLayout.setVerticalGroup(
            HacerTransacionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HacerTransacionesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InfoClientePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(InfoClientePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 69, Short.MAX_VALUE))
        );

        ContenedorDeFunciones.addTab("HACER TRANSACCION", HacerTransacionesPanel);

        InfoClientePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Info Cliente"));

        IdClienteLabel.setText("IdCliente");

        NoCuentaClienteLabel.setText("NoCedula");

        ApellidosClientLabel.setText("Apellidos");

        CedulaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaTextActionPerformed(evt);
            }
        });

        ApellidosText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidosTextActionPerformed(evt);
            }
        });

        EmailClientLabel.setText("Correo electronico");

        NombresClienteLabel.setText("Nombres");

        CorreoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoTextActionPerformed(evt);
            }
        });

        NombresText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombresTextActionPerformed(evt);
            }
        });

        DirecionClientLabel.setText("Direccion");

        FechaNacText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaNacTextActionPerformed(evt);
            }
        });

        DireccionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionTextActionPerformed(evt);
            }
        });

        FechaNacClientLabel.setText("Fecha nacimiento");

        GenSexClientLabel.setText("Genero sexual");

        SexoCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Hombre", "Mujer", "Gay" }));

        EstadoCivilClientLabel.setText("Estado civil");

        IdClienteText.setEnabled(false);
        IdClienteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdClienteTextActionPerformed(evt);
            }
        });

        EstadoCivilCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Casado", "Soltero", "Viudo", "Union libre" }));

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
                                .addGap(67, 67, 67)
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

        InfoCuentaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Info Cuenta"));

        TipoCuentaLabel.setText("Tipo cuenta");

        TipoCuentaCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Clasica", "Premium" }));

        SaldoCuentaLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SaldoCuentaLabel.setText("Saldo apertura");

        SaldoAperturaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaldoAperturaTextActionPerformed(evt);
            }
        });

        FechaCreacionText.setEnabled(false);
        FechaCreacionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaCreacionTextActionPerformed(evt);
            }
        });

        FechaAperturaLabel.setText("Fecha creacion");

        IdCuentaText.setEditable(false);
        IdCuentaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdCuentaTextActionPerformed(evt);
            }
        });

        IdCuentaLabel.setText("IdCuenta");

        NoCuentaClientLabel.setText("NoCuenta");

        NoCuentaText.setEditable(false);
        NoCuentaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoCuentaTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoCuentaPanelLayout = new javax.swing.GroupLayout(InfoCuentaPanel);
        InfoCuentaPanel.setLayout(InfoCuentaPanelLayout);
        InfoCuentaPanelLayout.setHorizontalGroup(
            InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoCuentaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(InfoCuentaPanelLayout.createSequentialGroup()
                        .addGroup(InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdCuentaText, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdCuentaLabel)
                            .addComponent(FechaAperturaLabel))
                        .addGap(10, 10, 10)
                        .addGroup(InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoCuentaText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NoCuentaClientLabel)))
                    .addComponent(FechaCreacionText, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SaldoCuentaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaldoAperturaText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(InfoCuentaPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipoCuentaLabel)
                            .addComponent(TipoCuentaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        InfoCuentaPanelLayout.setVerticalGroup(
            InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoCuentaPanelLayout.createSequentialGroup()
                .addGroup(InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdCuentaLabel)
                    .addComponent(NoCuentaClientLabel)
                    .addComponent(TipoCuentaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoCuentaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdCuentaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoCuentaCombo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaAperturaLabel)
                    .addComponent(SaldoCuentaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoCuentaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaCreacionText)
                    .addComponent(SaldoAperturaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        CuentasAgregadasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuentas Agregadas"));

        NoCuentaBuscarText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoCuentaBuscarTextActionPerformed(evt);
            }
        });
        NoCuentaBuscarText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NoCuentaBuscarTextKeyReleased(evt);
            }
        });

        NoCuentaClienteBuscalLabel.setText("NoCuenta");

        TablaCliente.setAutoCreateRowSorter(true);
        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaClienteScroll.setViewportView(TablaCliente);

        javax.swing.GroupLayout CuentasAgregadasPanelLayout = new javax.swing.GroupLayout(CuentasAgregadasPanel);
        CuentasAgregadasPanel.setLayout(CuentasAgregadasPanelLayout);
        CuentasAgregadasPanelLayout.setHorizontalGroup(
            CuentasAgregadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CuentasAgregadasPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(CuentasAgregadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NoCuentaClienteBuscalLabel)
                    .addComponent(NoCuentaBuscarText, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(874, Short.MAX_VALUE))
            .addGroup(CuentasAgregadasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TablaClienteScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
                .addContainerGap())
        );
        CuentasAgregadasPanelLayout.setVerticalGroup(
            CuentasAgregadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CuentasAgregadasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NoCuentaClienteBuscalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoCuentaBuscarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TablaClienteScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        GenerarUsuarioBtn.setBackground(new java.awt.Color(102, 255, 102));
        GenerarUsuarioBtn.setText("Generar cuenta");
        GenerarUsuarioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarUsuarioBtnActionPerformed(evt);
            }
        });

        DeshacerBtn.setBackground(new java.awt.Color(255, 0, 0));
        DeshacerBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeshacerBtn.setText("Deshacer");
        DeshacerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeshacerBtnActionPerformed(evt);
            }
        });

        RegistrarBtn.setBackground(new java.awt.Color(255, 204, 0));
        RegistrarBtn.setText("Registrar");
        RegistrarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarBtnMouseClicked(evt);
            }
        });
        RegistrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearClientePanelLayout = new javax.swing.GroupLayout(CrearClientePanel);
        CrearClientePanel.setLayout(CrearClientePanelLayout);
        CrearClientePanelLayout.setHorizontalGroup(
            CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearClientePanelLayout.createSequentialGroup()
                .addGroup(CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearClientePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CrearClientePanelLayout.createSequentialGroup()
                                .addComponent(InfoClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(InfoCuentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CuentasAgregadasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CrearClientePanelLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(DeshacerBtn)
                        .addGap(18, 18, 18)
                        .addComponent(GenerarUsuarioBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RegistrarBtn)))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        CrearClientePanelLayout.setVerticalGroup(
            CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearClientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(InfoClientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InfoCuentaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeshacerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenerarUsuarioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegistrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CuentasAgregadasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        ContenedorDeFunciones.addTab("REGISTRAR CLIENTE", CrearClientePanel);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Usuario");

        UsuarioPermisoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        BtnGenerarPermisos.setText("Generar");
        BtnGenerarPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGenerarPermisosActionPerformed(evt);
            }
        });

        BtnActualizarPermisos.setText("Actualizar");
        BtnActualizarPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarPermisosActionPerformed(evt);
            }
        });

        ComboUserId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        javax.swing.GroupLayout AccesosPanelLayout = new javax.swing.GroupLayout(AccesosPanel);
        AccesosPanel.setLayout(AccesosPanelLayout);
        AccesosPanelLayout.setHorizontalGroup(
            AccesosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccesosPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(AccesosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnActualizarPermisos)
                    .addGroup(AccesosPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(UsuarioPermisoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(BtnGenerarPermisos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1006, Short.MAX_VALUE))
        );
        AccesosPanelLayout.setVerticalGroup(
            AccesosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccesosPanelLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addGroup(AccesosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuarioPermisoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(BtnGenerarPermisos)
                    .addComponent(ComboUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnActualizarPermisos)
                .addContainerGap(382, Short.MAX_VALUE))
        );

        ContenedorDeFunciones.addTab("PERMISOS", AccesosPanel);

        InfoClientePanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Info Empleado"));

        Apellido.setText("Apellido");

        DescripcionOpLabel3.setText("Cedula");

        CedulaEmpT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaEmpTActionPerformed(evt);
            }
        });

        NoCuentaLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        NoCuentaLabel3.setText("Nombre");

        CodigoOpLabel1.setText("TipoUsuario");

        IdTransacionLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        IdTransacionLabel3.setText("IdEmpleado");

        NombreEmpleadoT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NombreEmpleadoTKeyReleased(evt);
            }
        });

        TipoUsuarioCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Cajero", "Admin"}));
        TipoUsuarioCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TipoUsuarioComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout InfoClientePanel5Layout = new javax.swing.GroupLayout(InfoClientePanel5);
        InfoClientePanel5.setLayout(InfoClientePanel5Layout);
        InfoClientePanel5Layout.setHorizontalGroup(
            InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdTransacionLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdEmpleadoTT, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NoCuentaLabel3)
                    .addComponent(NombreEmpleadoT, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Apellido)
                    .addComponent(ApellidoEmpT, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CedulaEmpT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescripcionOpLabel3))
                .addGap(18, 18, 18)
                .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodigoOpLabel1)
                    .addComponent(TipoUsuarioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        InfoClientePanel5Layout.setVerticalGroup(
            InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InfoClientePanel5Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NoCuentaLabel3)
                                .addComponent(IdTransacionLabel3))
                            .addComponent(CodigoOpLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreEmpleadoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ApellidoEmpT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CedulaEmpT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TipoUsuarioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdEmpleadoTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(InfoClientePanel5Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Apellido)
                            .addComponent(DescripcionOpLabel3))
                        .addGap(26, 26, 26)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        InfoClientePanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Info Usuario"));

        Apellido1.setText("Contraseña");

        NoCuentaLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        NoCuentaLabel4.setText("Usuario");

        CodigoOpLabel2.setText("Estado");

        IdTransacionLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        IdTransacionLabel4.setText("IdUsuario");

        UsuarioT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UsuarioTKeyReleased(evt);
            }
        });

        EstadoCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Habilitado", "Deshabilitado"}));
        EstadoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EstadoComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout InfoClientePanel6Layout = new javax.swing.GroupLayout(InfoClientePanel6);
        InfoClientePanel6.setLayout(InfoClientePanel6Layout);
        InfoClientePanel6Layout.setHorizontalGroup(
            InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdTransacionLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdUsuarioTT, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsuarioT, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoCuentaLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContrasenaT, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EstadoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodigoOpLabel2))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        InfoClientePanel6Layout.setVerticalGroup(
            InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoClientePanel6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InfoClientePanel6Layout.createSequentialGroup()
                        .addGroup(InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NoCuentaLabel4)
                                .addComponent(IdTransacionLabel4))
                            .addComponent(CodigoOpLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoClientePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UsuarioT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ContrasenaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EstadoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdUsuarioTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(InfoClientePanel6Layout.createSequentialGroup()
                        .addComponent(Apellido1)
                        .addGap(26, 26, 26)))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        DeshacerBtnTrans4.setBackground(new java.awt.Color(255, 102, 102));
        DeshacerBtnTrans4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeshacerBtnTrans4.setText("Deshacer");
        DeshacerBtnTrans4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeshacerBtnTrans4ActionPerformed(evt);
            }
        });

        UsuariosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuentas Agregadas"));

        NoCuentaBuscarText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoCuentaBuscarText1ActionPerformed(evt);
            }
        });
        NoCuentaBuscarText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NoCuentaBuscarText1KeyReleased(evt);
            }
        });

        NoCuentaClienteBuscalLabel1.setText("Cedula");

        TablaEmpleados.setAutoCreateRowSorter(true);
        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaClienteScroll1.setViewportView(TablaEmpleados);

        javax.swing.GroupLayout UsuariosPanelLayout = new javax.swing.GroupLayout(UsuariosPanel);
        UsuariosPanel.setLayout(UsuariosPanelLayout);
        UsuariosPanelLayout.setHorizontalGroup(
            UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuariosPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TablaClienteScroll1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                    .addGroup(UsuariosPanelLayout.createSequentialGroup()
                        .addGroup(UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoCuentaClienteBuscalLabel1)
                            .addComponent(NoCuentaBuscarText1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        UsuariosPanelLayout.setVerticalGroup(
            UsuariosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuariosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NoCuentaClienteBuscalLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoCuentaBuscarText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TablaClienteScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        BtnAgregarEmp.setBackground(new java.awt.Color(51, 255, 51));
        BtnAgregarEmp.setText("Agregar");
        BtnAgregarEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAgregarEmpMouseClicked(evt);
            }
        });
        BtnAgregarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearEmpleadoPanelLayout = new javax.swing.GroupLayout(CrearEmpleadoPanel);
        CrearEmpleadoPanel.setLayout(CrearEmpleadoPanelLayout);
        CrearEmpleadoPanelLayout.setHorizontalGroup(
            CrearEmpleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearEmpleadoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CrearEmpleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearEmpleadoPanelLayout.createSequentialGroup()
                        .addGroup(CrearEmpleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InfoClientePanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InfoClientePanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(CrearEmpleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DeshacerBtnTrans4, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(BtnAgregarEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(UsuariosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(307, Short.MAX_VALUE))
        );
        CrearEmpleadoPanelLayout.setVerticalGroup(
            CrearEmpleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearEmpleadoPanelLayout.createSequentialGroup()
                .addGroup(CrearEmpleadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearEmpleadoPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(BtnAgregarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeshacerBtnTrans4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CrearEmpleadoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(InfoClientePanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InfoClientePanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UsuariosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        ContenedorDeFunciones.addTab("CREAR EMPLEADO", CrearEmpleadoPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenedorDeFunciones, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HeaderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContenedorDeFunciones, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String[] columnasUser = {"Codigo", "Usuario", "Clave", "Estado"};
    ArrayList<Usuario> userEnMemoria = new ArrayList<>();

    public DefaultTableModel ListarUsers() {
        userEnMemoria = new ArrayList<>();
        Archivo archivo = new Archivo("src/Datos/Usuario.txt");
        String filas[] = archivo.TToString().split("\n");

        for (int i = 1; i < filas.length; i++) {
            String props[] = filas[i].split(";");

            Usuario emp = new Usuario();

            emp.IdUsuario = Integer.parseInt(props[0]);
            emp.UserName = props[1];
            emp.Pass = props[2];
            emp.Estado = props[3];

            userEnMemoria.add(emp);
        }
        DefaultTableModel dt = new DefaultTableModel(null, columnasUser);

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < userEnMemoria.size(); i++) {
            Usuario emple = userEnMemoria.get(i);

            fila[0] = emple.IdUsuario;
            fila[1] = emple.UserName;
            fila[2] = emple.Pass;
            fila[3] = emple.Estado;
            dt.addRow(fila);
        }

        return dt;
    }

    private void BtnAgregarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarEmpActionPerformed

        Archivo file = new Archivo("src/Datos/Empleado.txt");
        Empleados emp = new Empleados();

        emp.IdEmpleado = IdEmpleadoTT.getText();
        emp.Nombre = NombreEmpleadoT.getText();
        emp.Apellidos = ApellidoEmpT.getText();
        emp.Cedula = CedulaEmpT.getText();
        emp.TipoUsuario = (String) TipoUsuarioCombo.getSelectedItem();

        try {
            String empleadoNuevo = emp.ToString();

            file.guardarstring(empleadoNuevo);
            JOptionPane.showMessageDialog(null, "Inssertado");
        } catch (Exception e) {
        }

        Usuario user = new Usuario() {
            {
                IdUsuario = Integer.parseInt(IdUsuarioTT.getText());
                UserName = UsuarioT.getText();
                Pass = ContrasenaT.getText();
                Estado = (String) EstadoCombo.getSelectedItem();
            }
        };

        String cuentaNueva = user.ToString();

        try {
            Archivo archivoCuenta = new Archivo("src/Datos/Usuario.txt");
            archivoCuenta.guardarstring(cuentaNueva);
            JOptionPane.showMessageDialog(null, "Inssertado");

        } catch (Exception e) {
        }

        /*TablaEmpleados.setModel(new DefaultTableModel(null,columnasEmpleados));
        
        TablaEmpleados.setModel(ListarEmpleados());*/
        TablaEmpleados.setModel(new DefaultTableModel(null, columnasUser));

        TablaEmpleados.setModel(ListarUsers());

        UsuarioPermisoCombo.removeAll();

        LimpiarBotonesUsuario();
        llenarUserenCombo();
    }//GEN-LAST:event_BtnAgregarEmpActionPerformed

    private void BtnAgregarEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAgregarEmpMouseClicked

    }//GEN-LAST:event_BtnAgregarEmpMouseClicked

    private void NoCuentaBuscarText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoCuentaBuscarText1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NoCuentaBuscarText1KeyReleased

    private void NoCuentaBuscarText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoCuentaBuscarText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoCuentaBuscarText1ActionPerformed

    private void DeshacerBtnTrans4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeshacerBtnTrans4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeshacerBtnTrans4ActionPerformed

    private void EstadoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EstadoComboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoComboItemStateChanged

    private void UsuarioTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsuarioTKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioTKeyReleased

    private void TipoUsuarioComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoUsuarioComboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoUsuarioComboItemStateChanged

    private void NombreEmpleadoTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreEmpleadoTKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreEmpleadoTKeyReleased

    private void CedulaEmpTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaEmpTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CedulaEmpTActionPerformed

    private void BtnActualizarPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarPermisosActionPerformed
        guardaraccesos();
        JOptionPane.showMessageDialog(null, "Se Actualizo Satisfactoriamente");
    }//GEN-LAST:event_BtnActualizarPermisosActionPerformed

    private void BtnGenerarPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGenerarPermisosActionPerformed

        llenarAccesos("" + ComboUserId.getItemAt(UsuarioPermisoCombo.getSelectedIndex()));
    }//GEN-LAST:event_BtnGenerarPermisosActionPerformed

    ArregloArchivo aa;
    Archivo arc;
    JCheckBox check[] = new JCheckBox[0];
    String info_ac[] = new String[0];

    String lineas[] = new String[0];

    public void llenarAccesos(String idusuario) {
        for (int i = 0; i < check.length; i++) {
            String linea = idusuario + ";" + info_ac[i] + ";";
            boolean siesta = new Archivo("src/Datos/Usuario_Acceso.txt").TToString().contains(linea);
            check[i].setSelected(siesta);
        }
    }

    public void llenarUserenCombo() {
        arc = new Archivo("src/Datos/Usuario.txt");
        String lines[] = arc.TToString().split("\n");
        for (int i = 1; i < lines.length; i++) {
            //JOptionPane.showMessageDialog(null,lines[i]);
            String inter[] = lines[i].split(";");
            //JOptionPane.showMessageDialog(null,inter.length+"");
            UsuarioPermisoCombo.addItem(inter[1].trim());
            ComboUserId.addItem(inter[0].trim());
        }
    }

    public void guardaraccesos() {
        String iduser = ComboUserId.getItemAt(UsuarioPermisoCombo.getSelectedIndex());
        arc = new Archivo("src/Datos/Usuario_Acceso.txt");
        String accesos[] = arc.TToString().split("\n");
        for (int i = 0; i < accesos.length; i++) {
            String inter[] = accesos[i].split(";");
            if (i == 0) {
                agregarlinea(accesos[i].trim());
            } else {
                if (inter[0].trim().equals(iduser)) {
                } else {
                    agregarlinea(accesos[i].trim());
                }
            }
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i].isSelected()) {
                agregarlinea(iduser + ";" + info_ac[i] + ";");
            }
        }

        try {

            arc.guardararreglo(lineas);
            lineas = new String[0];
            UsuarioPermisoCombo.setSelectedIndex(0);
            llenarAccesos("0");
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp);
        }
    }

    public void imprimir() {
        for (int i = 0; i < lineas.length; i++) {
            System.out.println(lineas[i]);
        }
    }

    public void agregarlinea(String n) {
        String tmp[] = new String[lineas.length + 1];
        for (int i = 0; i < lineas.length; i++) {
            tmp[i] = lineas[i];
        }
        tmp[lineas.length] = n;
        lineas = tmp;
    }

    private void RegistrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarBtnActionPerformed
        try {

            Archivo file = new Archivo("src/Datos/Clientes.txt");

            String filas[] = file.TToString().split("\n");

            if (filas.length == 1) {
                Cliente cliente = new Cliente() {
                    {
                        IdCliente = Integer.parseInt(IdClienteText.getText());
                        NoCedula = CedulaText.getText();
                        Nombres = NombresText.getText();
                        Apellidos = ApellidosText.getText();

                        EstadoCivil.EstadoId = EstadoCivilCombo.getSelectedIndex();
                        EstadoCivil.Nombre = (String) EstadoCivilCombo.getSelectedItem();

                        Email = CorreoText.getText();
                        Direccion = DireccionText.getText();
                        FechaNac = FechaNacText.getText();
                        Sexo.IdSexo = SexoCombo.getSelectedIndex();
                        Sexo.Nombre = (String) SexoCombo.getSelectedItem();

                    }
                };

                String clienteNuevo = cliente.ToString();
                file.guardarstring(clienteNuevo);

                Cuenta cuenta = new Cuenta() {
                    {
                        IdCuenta = Integer.parseInt(IdCuentaText.getText());
                        NoCuenta = NoCuentaText.getText();
                        NombreCliente = NombresText.getText() + ApellidosText.getText();
                        TipoCuenta.IdCuenta = TipoCuentaCombo.getSelectedIndex();
                        TipoCuenta.Nombre = (String) TipoCuentaCombo.getSelectedItem();
                        FechaCreacion = FechaCreacionText.getText();
                        SaldoApertura = Double.parseDouble(SaldoAperturaText.getText());
                        SaldoActual = SaldoApertura;
                    }
                };

                String cuentaNueva = cuenta.ToString();

                Archivo archivoCuenta = new Archivo("src/Datos/Cuentas.txt");
                archivoCuenta.guardarstring(cuentaNueva);

                JOptionPane.showMessageDialog(null, "Insertado");

                return;
            }

            Cliente cliente = new Cliente() {
                {
                    IdCliente = Integer.parseInt(IdClienteText.getText());
                    NoCedula = CedulaText.getText();
                    Nombres = NombresText.getText();
                    Apellidos = ApellidosText.getText();

                    EstadoCivil.EstadoId = EstadoCivilCombo.getSelectedIndex();
                    EstadoCivil.Nombre = (String) EstadoCivilCombo.getSelectedItem();

                    Email = CorreoText.getText();
                    Direccion = DireccionText.getText();
                    FechaNac = FechaNacText.getText();
                    Sexo.IdSexo = SexoCombo.getSelectedIndex();
                    Sexo.Nombre = (String) SexoCombo.getSelectedItem();

                }
            };

            String clienteNuevo = cliente.ToString();
            file.guardarstring(clienteNuevo);

            Cuenta cuenta = new Cuenta() {
                {
                    IdCuenta = Integer.parseInt(IdCuentaText.getText());
                    NoCuenta = NoCuentaText.getText();
                    NombreCliente = NombresText.getText() + ApellidosText.getText();
                    TipoCuenta.IdCuenta = TipoCuentaCombo.getSelectedIndex();
                    TipoCuenta.Nombre = (String) TipoCuentaCombo.getSelectedItem();
                    FechaCreacion = FechaCreacionText.getText();
                    SaldoApertura = Double.parseDouble(SaldoAperturaText.getText());
                    SaldoActual = SaldoApertura;
                }
            };

            String cuentaNueva = cuenta.ToString();

            Archivo archivoCuenta = new Archivo("src/Datos/Cuentas.txt");
            archivoCuenta.guardarstring(cuentaNueva);
            
            int result = bankdb.InsertCliente(cliente);
            
            JOptionPane.showMessageDialog(null,"Listo"+result);

        } catch (IOException e) {
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TablaCliente.setModel(new DefaultTableModel(null, columnasClientes));
        TablaCliente.setModel(ListarClientes());
        LimpiarClienteCampos();
        
        
        AutoIncrementarIDCliente();
    }//GEN-LAST:event_RegistrarBtnActionPerformed

    private void RegistrarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarBtnMouseClicked

    }//GEN-LAST:event_RegistrarBtnMouseClicked

    private void GenerarUsuarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarUsuarioBtnActionPerformed
        Archivo file = new Archivo("src/Datos/Cuentas.txt");
        String filas[] = file.TToString().split("\n");

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        FechaCreacionText.setText(hourdateFormat.format(date));

        if (filas.length == 1) {
            IdCuentaText.setText("10");
            NoCuentaText.setText("6662019100");
            return;
        }

        int ultimoId = 0;
        for (int i = 1; i < filas.length; i++) {
            String props[] = filas[i].split(";");
            ultimoId += Integer.parseInt(props[0]);
        }
        ultimoId++;
        IdCuentaText.setText("" + ultimoId);

        String mask = "6662019";
        String cuenta = "";
        long Identificador = 0;
        for (int i = 1; i < filas.length; i++) {
            String props[] = filas[i].split(";");
            cuenta = props[1];
            Identificador = Long.parseLong(cuenta.substring(6, 10));
        }
        Identificador++;

        NoCuentaText.setText(mask + Identificador);

    }//GEN-LAST:event_GenerarUsuarioBtnActionPerformed

    private void NoCuentaBuscarTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoCuentaBuscarTextKeyReleased
        TablaCliente.setModel(BuscarClient(NoCuentaBuscarText.getText()));
    }//GEN-LAST:event_NoCuentaBuscarTextKeyReleased

    private void NoCuentaBuscarTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoCuentaBuscarTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoCuentaBuscarTextActionPerformed

    private void NoCuentaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoCuentaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoCuentaTextActionPerformed

    private void IdCuentaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdCuentaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdCuentaTextActionPerformed

    private void FechaCreacionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaCreacionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaCreacionTextActionPerformed

    private void SaldoAperturaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaldoAperturaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaldoAperturaTextActionPerformed

    private void IdClienteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdClienteTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdClienteTextActionPerformed

    private void DireccionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionTextActionPerformed

    private void FechaNacTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaNacTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaNacTextActionPerformed

    private void NombresTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombresTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombresTextActionPerformed

    private void CorreoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreoTextActionPerformed

    private void ApellidosTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidosTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosTextActionPerformed

    private void CedulaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CedulaTextActionPerformed

    private void NombreBancoTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreBancoTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreBancoTransActionPerformed

    private void NombreAgenciaTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreAgenciaTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreAgenciaTransActionPerformed

    private void IdBancoTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdBancoTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdBancoTransActionPerformed

    private void IdAgenciaTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdAgenciaTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdAgenciaTransActionPerformed

    private void SaldoActualTransSaldoActualTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaldoActualTransSaldoActualTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaldoActualTransSaldoActualTransActionPerformed

    private void DeshacerBtnTrans3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeshacerBtnTrans3ActionPerformed
        LimpiarTransaccionesCampos();
    }//GEN-LAST:event_DeshacerBtnTrans3ActionPerformed

    public void LimpiarTransaccionesCampos() {
        Nocuenta.setText("");
        FechaOperacionT.setText("");
        TipoOperacionCombo.setSelectedItem("");
        DescripcionOpTrans.setText("");
        CodOpTrans.setText("");
        NombreClienteTrans.setText("");
        SaldoActualTrans.setText("");
        SaldoNuevoTrans.setText("");
        ImporteTrans.setText("");
        SaldoActualTrans.setText("");
    }

    private void HacerOperacionBtnTrans3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HacerOperacionBtnTrans3ActionPerformed
        try {

            Archivo file = new Archivo(Transaciones);

            String filas[] = file.TToString().split("\n");

            int id = Integer.parseInt(IdTransacc.getText());
            Transaccion transacion = new Transaccion() {
                {
                    IdTransacion = id;
                    CuentaAfectada = Nocuenta.getText();
                    FechaOperacion = FechaOperacionT.getText();
                    tipoOperacion.Nombre = (String) TipoOperacionCombo.getSelectedItem();
                    NombreCliente = NombreClienteTrans.getText();
                    Descripcion = DescripcionOpTrans.getText();
                    CodigoOperacion = CodOpTrans.getText();
                    Importe = Double.parseDouble(ImporteTrans.getText());
                    SaldoAnterior = Double.parseDouble(SaldoActualTrans.getText());
                    SaldoNuevo = Double.parseDouble(SaldoNuevoTrans.getText());
                    agencia.IdAgencia = Sesion.sucursal.IdSucursal;
                    agencia.Nombre = Sesion.sucursal.Nombre;
                    NombreBanco = NombreBancoTrans.getText();

                }
            };

            String transacionNueva = transacion.ToString();
            file.guardarstring(transacionNueva);

        } catch (IOException e) {
        }

        TablaTransaciones.setModel(new DefaultTableModel(null,
                columnasTransaciones));
        TablaTransaciones.setModel(ListarTransaciones());
        LimpiarTransaccionesCampos();
        InicializarTransaciones();
    }//GEN-LAST:event_HacerOperacionBtnTrans3ActionPerformed

    private void NombreClienteTransSaldoActualTrans1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreClienteTransSaldoActualTrans1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreClienteTransSaldoActualTrans1ActionPerformed

    private void NombreClienteTransMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreClienteTransMouseReleased

    }//GEN-LAST:event_NombreClienteTransMouseReleased

    private void SaldoNuevoTransDineroRetiradoTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaldoNuevoTransDineroRetiradoTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaldoNuevoTransDineroRetiradoTransActionPerformed

    private void ImporteTransKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ImporteTransKeyReleased
        double importe = Double.parseDouble(ImporteTrans.getText()
                .replaceAll(",", "."));

        double saldoActual = Double.parseDouble(SaldoActualTrans.getText());
        boolean saldoSobrepasaElLimite = importe > saldoActual || importe <= 0;

        if (saldoSobrepasaElLimite) {
            if (importe <= 0) {
                JOptionPane.showMessageDialog(null, "No se puede ingresar numeros negativos o cero");
                SaldoNuevoTrans.setText("");
            } else if (importe > saldoActual) {
                JOptionPane.showMessageDialog(null, "NO puede superar el dinero que tiene");
                SaldoNuevoTrans.setText("");
            }
            return;
        }

        if ("1".equals(CodOpTrans.getText())) {
            saldoActual += importe;
            SaldoNuevoTrans.setText("" + saldoActual);
        } else {
            saldoActual -= importe;
            SaldoNuevoTrans.setText("" + saldoActual);
        }

    }//GEN-LAST:event_ImporteTransKeyReleased

    private void ImporteTransImporteTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImporteTransImporteTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImporteTransImporteTransActionPerformed

    private void NoCuentaBuscarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoCuentaBuscarTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoCuentaBuscarTransActionPerformed

    private void NocuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NocuentaKeyReleased

        int len = Nocuenta.getText().length();
        if (Nocuenta.getText().isEmpty() || len < 10) {
            NombreClienteTrans.setText("");
            SaldoActualTrans.setText("");
            ImporteTrans.setText("");
            return;
        }
        Archivo archivoCuenta = new Archivo("src/Datos/Cuentas.txt");

        String filas[] = archivoCuenta.TToString().split("\n");

        ArrayList<Cuenta> cuentasEnMemoria = new ArrayList<>();
        for (int i = 1; i < filas.length; i++) {
            String props[] = filas[i].split(";");
            Cuenta cuenta = new Cuenta() {
                {
                    IdCuenta = Integer.parseInt(props[0]);
                    NoCuenta = props[1];
                    NombreCliente = props[2];
                    TipoCuenta.IdCuenta = 0;
                    TipoCuenta.Nombre = props[3];
                    FechaCreacion = props[4];
                    SaldoApertura = Double.parseDouble(props[6].replaceAll(",", "."));
                    SaldoActual = Double.parseDouble(props[6].replaceAll(",", "."));
                }
            };
            cuentasEnMemoria.add(cuenta);
        }

        for (Cuenta cuen : cuentasEnMemoria) {
            if (cuen.NoCuenta.equals(Nocuenta.getText())) {
                NombreClienteTrans.setText(cuen.NombreCliente);
                SaldoActualTrans.setText("" + cuen.SaldoActual);
                cuentaGlobal.IdCuenta = cuen.IdCuenta;
            }
        }

    }//GEN-LAST:event_NocuentaKeyReleased

    private void TipoOperacionComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoOperacionComboItemStateChanged
        CodOpTrans.setText("" + TipoOperacionCombo.getSelectedIndex());
    }//GEN-LAST:event_TipoOperacionComboItemStateChanged

    private void DeshacerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeshacerBtnActionPerformed

        LimpiarClienteCampos();

    }//GEN-LAST:event_DeshacerBtnActionPerformed

    public void LimpiarClienteCampos() {
        TipoCuentaCombo.setSelectedItem("");
        NoCuentaText.setText("");
        FechaNacText.setText("");
        NombresText.setText("");
        ApellidosText.setText("");

        SexoCombo.setSelectedItem("");
        EstadoCivilCombo.setSelectedItem("");
        CorreoText.setText("");
        DireccionText.setText("");

        CedulaText.setText("");
        FechaCreacionText.setText("");
        SaldoAperturaText.setText("");
    }

    private void CerrarSesionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionBtnActionPerformed
        Sesion.IdUser = 0;
        Sesion.userName = "";
        Sesion.pass = "";
        Sesion.sucursal.Nombre = "";
        Sesion.sucursal.IdSucursal = 0;

        LoginPrincipal prin = new LoginPrincipal();
        prin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CerrarSesionBtnActionPerformed

    public String columnasTransaciones[] = {"IdTransacion", "CuentaAfectada", "FechaOperacion", "TipoOperacion", "Descripcion",
        "CodigoOperacion", "Nombre cliete", "SaldoAnterior",
        "Importe", "SaldoNuevo", "Agencia", "Banco"};
    ArrayList<Transaccion> transacionesEnMemoria = new ArrayList<Transaccion>();

    public DefaultTableModel ListarTransaciones() {
        transacionesEnMemoria = new ArrayList<Transaccion>();
        Archivo archivo = new Archivo("src/Datos/Transacciones.txt");
        String filas[] = archivo.TToString().split("\n");

        for (int i = 1; i < filas.length; i++) {
            String props[] = filas[i].split(";");
            Transaccion transaccion = new Transaccion() {
                {
                    IdTransacion = Integer.parseInt(props[0]);
                    CuentaAfectada = props[1];
                    FechaOperacion = props[2];
                    tipoOperacion.Nombre = props[3];
                    Descripcion = props[4];

                    CodigoOperacion = props[5];
                    NombreCliente = props[6];
                    SaldoAnterior = Double.parseDouble(props[7].replaceAll(",", "."));
                    Importe = Double.parseDouble(props[8].replaceAll(",", "."));
                    SaldoNuevo = Double.parseDouble(props[9].replaceAll(",", "."));
                    agencia.Nombre = props[10];
                    NombreBanco = props[11];

                }
            };
            transacionesEnMemoria.add(transaccion);
        }
        DefaultTableModel dt = new DefaultTableModel(null, columnasTransaciones);

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < transacionesEnMemoria.size(); i++) {
            Transaccion transacc = transacionesEnMemoria.get(i);
            fila[0] = transacc.IdTransacion;
            fila[1] = transacc.CuentaAfectada;
            fila[2] = transacc.FechaOperacion;
            fila[3] = transacc.tipoOperacion.Nombre;
            fila[4] = transacc.Descripcion;
            fila[5] = transacc.CodigoOperacion;
            fila[6] = transacc.NombreCliente;
            fila[7] = transacc.SaldoAnterior;
            fila[8] = transacc.Importe;
            fila[9] = transacc.SaldoNuevo;
            fila[10] = transacc.agencia.Nombre;
            fila[11] = transacc.NombreBanco;
            dt.addRow(fila);
        }

        return dt;
    }

    ArrayList<Cuenta> clientesEnMemoria = new ArrayList<>();

    public DefaultTableModel ListarClientes() {
        clientesEnMemoria = new ArrayList<Cuenta>();
        Archivo archivo = new Archivo("src/Datos/Cuentas.txt");
        String filas[] = archivo.TToString().split("\n");

        for (int i = 1; i < filas.length; i++) {
            String props[] = filas[i].split(";");
            Cuenta cliente = new Cuenta() {
                {

                    IdCuenta = Integer.parseInt(props[0]);
                    NoCuenta = props[1];
                    NombreCliente = props[2];
                    TipoCuenta.Nombre = props[3];

                    FechaCreacion = props[4];
                    SaldoApertura = Double.parseDouble(props[5].replace(",", "."));

                    SaldoActual = Double.parseDouble(props[6].replace(",", "."));

                }
            };
            clientesEnMemoria.add(cliente);
        }
        DefaultTableModel dt = new DefaultTableModel(null, columnasClientes);

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < clientesEnMemoria.size(); i++) {
            Cuenta cliente = clientesEnMemoria.get(i);
            fila[0] = cliente.IdCuenta;
            fila[1] = cliente.NoCuenta;
            fila[2] = cliente.NombreCliente;
            fila[3] = cliente.TipoCuenta.Nombre;
            fila[4] = cliente.FechaCreacion;
            fila[5] = cliente.SaldoApertura;
            fila[6] = cliente.SaldoActual;
            dt.addRow(fila);
        }

        return dt;
    }

    String[] columnasClientes = {"IdCuenta", "NoCuenta", "NombreCliente", "TipoCuenta", "FechaCreacion", "SaldoApertura", "SaldoActual"};

    public DefaultTableModel BuscarClient(String buscar) {
        Archivo archivo = new Archivo("src/Datos/Cuentas.txt");
       
        DefaultTableModel dt = new DefaultTableModel(null, columnasClientes);

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < clientesEnMemoria.size(); i++) {
            Cuenta cliente = clientesEnMemoria.get(i);
            String IdStr = Integer.toString(cliente.IdCuenta);
            if (cliente.NoCuenta.contains(buscar) || cliente.NombreCliente.contains(buscar)
                    || IdStr.contains(buscar)) {

                fila[0] = cliente.IdCuenta;
                fila[1] = cliente.NoCuenta;
                fila[2] = cliente.NombreCliente;
                fila[3] = cliente.TipoCuenta.Nombre;
                fila[4] = cliente.FechaCreacion;
                fila[5] = cliente.SaldoApertura;
                fila[6] = cliente.SaldoActual;
                dt.addRow(fila);
            }
        }

        return dt;
    }

    String Transaciones = "src/Datos/Transacciones.txt";

    public ArrayList<Transaccion> TranscionesEnMemoria = new ArrayList<Transaccion>();
    Cuenta cuentaGlobal = new Cuenta();

    String EmpleadoArc = "src/Datos/Empleados.txt";

    String[] columnasEmpleados = {"IdEmpleado", "Nombre", "Apellidos", "Cedula", "TipoUsuario"};

    ArrayList<Empleados> empleadosEnMemoria = new ArrayList<Empleados>();

    public DefaultTableModel ListarEmpleados() {
        empleadosEnMemoria = new ArrayList<Empleados>();
        Archivo archivo = new Archivo("src/Datos/Empleado.txt");
        String filas[] = archivo.TToString().split("\n");

        for (int i = 1; i < filas.length; i++) {
            String props[] = filas[i].split(";");

            Empleados emp = new Empleados();

            emp.IdEmpleado = props[0];
            emp.Nombre = props[1];
            emp.Apellidos = props[2];
            emp.Cedula = props[3];
            emp.TipoUsuario = props[4];

            empleadosEnMemoria.add(emp);
        }
        DefaultTableModel dt = new DefaultTableModel(null, columnasEmpleados);

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < empleadosEnMemoria.size(); i++) {
            Empleados emple = empleadosEnMemoria.get(i);

            fila[0] = emple.IdEmpleado;
            fila[1] = emple.Nombre;
            fila[2] = emple.Apellidos;
            fila[3] = emple.Cedula;
            fila[4] = emple.TipoUsuario;
            dt.addRow(fila);
        }

        return dt;
    }

    public void LimpiarBotonesUsuario() {
        IdEmpleadoTT.setText("");
        NombreEmpleadoT.setText("");
        ApellidoEmpT.setText("");
        CedulaEmpT.setText("");
        TipoCuentaCombo.setSelectedItem("");

        IdUsuarioTT.setText("");
        UsuarioT.setText("");
        ContrasenaT.setText("");
        EstadoCombo.setSelectedItem("");
    }

    public void BuscarCuenta(String cuentaBuscada) {

        Archivo archivoCuenta = new Archivo("src/Datos/Cuentas.txt");

        String filas[] = archivoCuenta.TToString().split("\n");

        ArrayList<Cuenta> cuentasEnMemoria = new ArrayList<Cuenta>();
        for (int i = 1; i <= filas.length; i++) {
            String props[] = filas[i].split(";");
            Cuenta cuenta = new Cuenta() {
                {
                    IdCuenta = Integer.parseInt(props[0]);
                    NoCuenta = props[1];
                    NombreCliente = props[2];
                    TipoCuenta.IdCuenta = 0;
                    TipoCuenta.Nombre = props[3];
                    FechaCreacion = props[4];
                    SaldoApertura = Double.parseDouble(props[5]);
                    SaldoActual = Double.parseDouble(props[6].replaceAll(",", "."));
                }
            };
            cuentasEnMemoria.add(cuenta);
        }

        for (Cuenta cuen : cuentasEnMemoria) {
            if (cuen.NoCuenta.contains(cuentaBuscada)) {
                NombreClienteTrans.setText(cuen.NombreCliente);
                SaldoActualTrans.setText("" + cuen.SaldoActual);
                double importe = Double.parseDouble(ImporteTrans.getText().replaceAll(",", "."));
                SaldoNuevoTrans.setText("" + importe);
            }
        }

    }

    public void BuscarCuentas(String cuentaBuscar) {
        Archivo archivoCuenta = new Archivo("src/Datos/Cuentas.txt");

        String filas[] = archivoCuenta.TToString().split("\n");

        ArrayList<Cuenta> cuentasEnMemoria = new ArrayList<Cuenta>();
        for (int i = 1; i < filas.length; i++) {
            String props[] = filas[i].split(";");
            Cuenta cuenta = new Cuenta() {
                {
                    IdCuenta = Integer.parseInt(props[0]);
                    NoCuenta = props[1];
                    NombreCliente = props[2];
                    TipoCuenta.IdCuenta = 0;
                    TipoCuenta.Nombre = props[3];
                    FechaCreacion = props[4];
                    SaldoApertura = Double.parseDouble(props[5]);
                    SaldoActual = Double.parseDouble(props[6].replaceAll(",", "."));
                }
            };
            cuentasEnMemoria.add(cuenta);
        }
        for (Cuenta cuen : cuentasEnMemoria) {
            if (cuen.NoCuenta.contains(cuentaBuscar)) {
                NombreClienteTrans.setText(cuen.NombreCliente);
                SaldoActualTrans.setText("" + cuen.SaldoActual);
                double importe = Double.parseDouble(ImporteTrans.getText().replaceAll(",", "."));
                SaldoNuevoTrans.setText("" + importe);

            }
        }

    }

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
    private javax.swing.JPanel AccesosPanel;
    private javax.swing.JLabel Apellido;
    private javax.swing.JLabel Apellido1;
    private javax.swing.JTextField ApellidoEmpT;
    private javax.swing.JLabel ApellidosClientLabel;
    private javax.swing.JTextField ApellidosText;
    private javax.swing.JButton BtnActualizarPermisos;
    private javax.swing.JButton BtnAgregarEmp;
    private javax.swing.JButton BtnGenerarPermisos;
    private javax.swing.JTextField CedulaEmpT;
    private javax.swing.JTextField CedulaText;
    private javax.swing.JButton CerrarSesionBtn;
    private javax.swing.JTextField CodOpTrans;
    private javax.swing.JLabel CodigoOpLabel;
    private javax.swing.JLabel CodigoOpLabel1;
    private javax.swing.JLabel CodigoOpLabel2;
    private javax.swing.JComboBox<String> ComboUserId;
    private javax.swing.JTabbedPane ContenedorDeFunciones;
    private javax.swing.JTextField ContrasenaT;
    private javax.swing.JTextField CorreoText;
    private javax.swing.JPanel CrearClientePanel;
    private javax.swing.JPanel CrearEmpleadoPanel;
    private javax.swing.JPanel CuentasAgregadasPanel;
    private javax.swing.JLabel DescripcionOpLabel;
    private javax.swing.JLabel DescripcionOpLabel3;
    private javax.swing.JTextField DescripcionOpTrans;
    private javax.swing.JButton DeshacerBtn;
    private javax.swing.JButton DeshacerBtnTrans3;
    private javax.swing.JButton DeshacerBtnTrans4;
    private javax.swing.JLabel DineroRetiradoLabel3;
    private javax.swing.JTextField DireccionText;
    private javax.swing.JLabel DirecionClientLabel;
    private javax.swing.JLabel EmailClientLabel;
    private javax.swing.JLabel EstadoCivilClientLabel;
    private javax.swing.JComboBox EstadoCivilCombo;
    private javax.swing.JComboBox EstadoCombo;
    private javax.swing.JLabel FechaAperturaLabel;
    private javax.swing.JTextField FechaCreacionText;
    private javax.swing.JLabel FechaNacClientLabel;
    private javax.swing.JTextField FechaNacText;
    private javax.swing.JLabel FechaOperacionLabel;
    private javax.swing.JTextField FechaOperacionT;
    private javax.swing.JLabel GenSexClientLabel;
    private javax.swing.JButton GenerarUsuarioBtn;
    private javax.swing.JButton HacerOperacionBtnTrans3;
    private javax.swing.JPanel HacerTransacionesPanel;
    private javax.swing.JPanel HeaderInfo;
    private javax.swing.JLabel IdAgenciaLabel;
    private javax.swing.JTextField IdAgenciaTrans;
    private javax.swing.JLabel IdBancoLabel;
    private javax.swing.JTextField IdBancoTrans;
    private javax.swing.JLabel IdClienteLabel;
    private javax.swing.JTextField IdClienteText;
    private javax.swing.JLabel IdCuentaLabel;
    private javax.swing.JTextField IdCuentaText;
    private javax.swing.JTextField IdEmpleadoTT;
    private javax.swing.JTextField IdTransacc;
    private javax.swing.JLabel IdTransacionLabel;
    private javax.swing.JLabel IdTransacionLabel3;
    private javax.swing.JLabel IdTransacionLabel4;
    private javax.swing.JTextField IdUsuarioTT;
    private javax.swing.JLabel ImporteLabel3;
    private javax.swing.JTextField ImporteTrans;
    private javax.swing.JButton ImprimirBtn;
    private javax.swing.JPanel InfoClientePanel;
    private javax.swing.JPanel InfoClientePanel1;
    private javax.swing.JPanel InfoClientePanel2;
    private javax.swing.JPanel InfoClientePanel3;
    private javax.swing.JPanel InfoClientePanel5;
    private javax.swing.JPanel InfoClientePanel6;
    private javax.swing.JPanel InfoCuentaPanel;
    private javax.swing.JTextField NoCuentaBuscarText;
    private javax.swing.JTextField NoCuentaBuscarText1;
    private javax.swing.JTextField NoCuentaBuscarTrans;
    private javax.swing.JLabel NoCuentaClientLabel;
    private javax.swing.JLabel NoCuentaClienteBuscalLabel;
    private javax.swing.JLabel NoCuentaClienteBuscalLabel1;
    private javax.swing.JLabel NoCuentaClienteLabel;
    private javax.swing.JLabel NoCuentaLabel;
    private javax.swing.JLabel NoCuentaLabel3;
    private javax.swing.JLabel NoCuentaLabel4;
    private javax.swing.JTextField NoCuentaText;
    private javax.swing.JTextField Nocuenta;
    private javax.swing.JLabel NombreAgenciaLabel;
    private javax.swing.JTextField NombreAgenciaTrans;
    private javax.swing.JLabel NombreBancoLabel;
    private javax.swing.JTextField NombreBancoTrans;
    private javax.swing.JTextField NombreClienteTrans;
    private javax.swing.JTextField NombreEmpleadoT;
    private javax.swing.JLabel NombreLabel3;
    private javax.swing.JLabel NombresClienteLabel;
    private javax.swing.JTextField NombresText;
    private javax.swing.JButton RegistrarBtn;
    private javax.swing.JLabel SaldoActualLabel3;
    private javax.swing.JTextField SaldoActualTrans;
    private javax.swing.JTextField SaldoAperturaText;
    private javax.swing.JLabel SaldoCuentaLabel;
    private javax.swing.JTextField SaldoNuevoTrans;
    private javax.swing.JComboBox SexoCombo;
    private javax.swing.JTable TablaCliente;
    private javax.swing.JScrollPane TablaClienteScroll;
    private javax.swing.JScrollPane TablaClienteScroll1;
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JTable TablaTransaciones;
    private javax.swing.JComboBox TipoCuentaCombo;
    private javax.swing.JLabel TipoCuentaLabel;
    private javax.swing.JComboBox TipoOperacionCombo;
    private javax.swing.JLabel TipoOperacionLabel;
    private javax.swing.JComboBox TipoUsuarioCombo;
    private javax.swing.JScrollPane TransacionesAgregadasScroll;
    private javax.swing.JComboBox<String> UsuarioPermisoCombo;
    private javax.swing.JTextField UsuarioT;
    private javax.swing.JPanel UsuariosPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    public void InitizalizarTablas() {
        TablaTransaciones.setModel(ListarTransaciones());
        TablaCliente.setModel(ListarClientes());
        TablaEmpleados.setModel(ListarUsers());
    }

    private void AutoIncrementarIDCliente() {
        Archivo file = new Archivo("src/Datos/Clientes.txt");
        String filas[] = file.TToString().split("\n");

        if (filas.length == 1) {
            IdClienteText.setText("1");
        } else {
            int lastClientId = 0;

            for (int i = 1; i < filas.length; i++) {
                String props[] = filas[i].split(";");
                lastClientId = Integer.parseInt(props[0]) + 1;
            }
            IdClienteText.setText("" + lastClientId);

        }

    }

}
