/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage_Customer_Supplier_Package;

import AppPackage.AnimationClass;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DbConnection.DBconnect;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import HomePage_Package.*;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

/**
 *
 * @author Teshan Chathushka
 */
public class Manage_Customer_Supplier_User extends javax.swing.JFrame {

    /**
     * Creates new form Test2
     */
    int xMouse;//xMouse Global
    int yMouse;//yMouse Global
    int timeRun = 0;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Manage_Customer_Supplier_User() {
        initComponents();
        setHide();
        setIcon();
        setLocationRelativeTo(null);
        conn = DBconnect.connect();
        tableLoad_Supplier();
        tableLoad_Customer();
        tableLoad_Loyalty();
        tableLoad_Customer1();
        FillComboCusID();
        FillComboSalesAmount();
        new Thread() {
            public void run() {
                while (timeRun == 0) {
                    Calendar cal = new GregorianCalendar();

                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int am_pm = cal.get(Calendar.AM_PM);

                    String DayNight = "";
                    if (am_pm == 1) {
                        DayNight = "PM";
                    } else {
                        DayNight = "AM";
                    }
                    String time = hour + ":" + min/*+":"+sec*/;
                    String day_night = DayNight;
                    Clock.setText(time);
                    Am_Pm.setText(day_night);
                }
            }
        }.start();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
                 String date=sdf.format(new Date());
                 dateLable.setText(date);
        //setTime();
        
    }

    public static boolean validatingint_Customer(String Cusid) {
        boolean Result = false;
        int num1 = Integer.parseInt(Cusid);
        if (Cusid.matches("[0-9]+") && Cusid.length() >= 4) {
            Result = true;
        }
        return Result;
    }
    
    public static boolean ValidatingSupplierVarchar(String Supplier_ID) {
        boolean Result = false;
        if (Supplier_ID.length() >= 5) {
            Result = true;
        }
        return Result;
    }

    public static boolean validateCustomerName(String Name) {
        boolean status = false;
        for (int i = 0; i < Name.length(); i++) {
            if (Character.isAlphabetic(Name.charAt(i))) {
                status = true;
            } else {
                status = false;
            }
        }
        return status;
    }
    
    public static boolean validateSupplierName(String name) {
        boolean status = false;
        for (int i = 0; i < name.length(); i++) {
            if (Character.isAlphabetic(name.charAt(i))) {
                status = true;
            } else {
                status = false;
            }
        }
        return status;
    }
    
    public static boolean ValidatingPhoneNumber(String ContactNo) {
        boolean Result = false;
        if (ContactNo.length() == 10) {
            Result = true;
        }
        return Result;
    }
    
    public static boolean ValidatingSuppContactNO(String Contact_No)
    {
        boolean Result = false;
        if (Contact_No.length() == 10) {
            Result = true;
        }
        return Result;
    
    }
  
    public static boolean validatingInt(String qty) {
        boolean Result = false;
        int num1 = Integer.parseInt(qty);
        if (num1 > 2) {
            Result = true;
        }
        return Result;
    }
            
    public static boolean validatingFloat(String rprice) {
        boolean Result = false;
        double num1 = Float.parseFloat(rprice);
        if (num1 > 2) {
            Result = true;
        }
        return Result;
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubPanel = new javax.swing.JPanel();
        Customer_Icon = new javax.swing.JLabel();
        Supplier_Icon = new javax.swing.JLabel();
        LoyaltyScheme_Icon = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        SubMenu = new javax.swing.JLabel();
        TitleBar = new javax.swing.JPanel();
        Minimize = new javax.swing.JLabel();
        Cancel = new javax.swing.JLabel();
        logUserImg = new javax.swing.JLabel();
        Uname_Separator = new javax.swing.JSeparator();
        Show_Uname = new javax.swing.JLabel();
        signOut_button = new javax.swing.JLabel();
        DetailPanal = new javax.swing.JPanel();
        Customer_txt = new javax.swing.JLabel();
        Supplier_txt = new javax.swing.JLabel();
        LoyaltyScheme_txt = new javax.swing.JLabel();
        Anime_sub = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Customer_panel = new javax.swing.JPanel();
        tcad = new javax.swing.JTextField();
        con_CL = new javax.swing.JLabel();
        tcnm = new javax.swing.JTextField();
        cbl = new javax.swing.JButton();
        rm = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tcrm = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        cid = new javax.swing.JLabel();
        cs_a_CheckBox = new javax.swing.JCheckBox();
        cs_e_jCheckBox2 = new javax.swing.JCheckBox();
        nm = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ct = new javax.swing.JTable();
        st = new javax.swing.JLabel();
        tccon = new javax.swing.JTextField();
        ad = new javax.swing.JLabel();
        Add_C = new javax.swing.JButton();
        Search_C = new javax.swing.JButton();
        Search_cmb_cus = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Clear_C = new javax.swing.JButton();
        Update_C = new javax.swing.JButton();
        cusid_txt_user = new javax.swing.JTextField();
        Supplier_panal = new javax.swing.JPanel();
        spnml = new javax.swing.JLabel();
        srml = new javax.swing.JLabel();
        supidl = new javax.swing.JLabel();
        snml = new javax.swing.JLabel();
        spidl = new javax.swing.JLabel();
        srpl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sql = new javax.swing.JLabel();
        sconl = new javax.swing.JLabel();
        ss_ComboBox1 = new javax.swing.JComboBox();
        srtt = new javax.swing.JTextField();
        ssqt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        srm_extArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        st1 = new javax.swing.JTable();
        Add_S = new javax.swing.JButton();
        Update_S = new javax.swing.JButton();
        snmt = new javax.swing.JTextField();
        spidt = new javax.swing.JTextField();
        scont = new javax.swing.JTextField();
        spnmt = new javax.swing.JTextField();
        ssl = new javax.swing.JLabel();
        Search_S = new javax.swing.JButton();
        search_cmb_supp = new javax.swing.JComboBox<>();
        Clear_S = new javax.swing.JButton();
        SupId_txt_Supp_user = new javax.swing.JTextField();
        LoyaltySchemel_panel = new javax.swing.JPanel();
        lcusidl = new javax.swing.JLabel();
        lsrl = new javax.swing.JLabel();
        lctl = new javax.swing.JLabel();
        lrpl = new javax.swing.JLabel();
        lrtt = new javax.swing.JTextField();
        lsr_ComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lt = new javax.swing.JTable();
        lbb = new javax.swing.JButton();
        update_loyal_user_btn = new javax.swing.JButton();
        Calculate_L = new javax.swing.JButton();
        ltotl = new javax.swing.JLabel();
        Search_L = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Loyal_Search_cmb_Admin = new javax.swing.JComboBox<>();
        Clear_L = new javax.swing.JButton();
        lctlt1 = new javax.swing.JTextField();
        Add_loyal_user_btn = new javax.swing.JButton();
        loyalty_combo_user = new javax.swing.JComboBox<>();
        lsrl1 = new javax.swing.JLabel();
        SalesAmount_Combo_User = new javax.swing.JComboBox();
        Delete_loyal_user_btn = new javax.swing.JButton();
        TimeLine = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        Clock = new javax.swing.JLabel();
        Am_Pm = new javax.swing.JLabel();
        dateLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubPanel.setBackground(new java.awt.Color(37, 4, 70));
        SubPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Customer_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Add-32.png"))); // NOI18N
        Customer_Icon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Customer_IconMouseMoved(evt);
            }
        });
        Customer_Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Customer_IconMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Customer_IconMouseExited(evt);
            }
        });
        SubPanel.add(Customer_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        Supplier_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Attendance-32 (1).png"))); // NOI18N
        Supplier_Icon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Supplier_IconMouseMoved(evt);
            }
        });
        Supplier_Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Supplier_IconMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Supplier_IconMouseExited(evt);
            }
        });
        SubPanel.add(Supplier_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        LoyaltyScheme_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Details-32.png"))); // NOI18N
        LoyaltyScheme_Icon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                LoyaltyScheme_IconMouseMoved(evt);
            }
        });
        LoyaltyScheme_Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoyaltyScheme_IconMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoyaltyScheme_IconMouseExited(evt);
            }
        });
        SubPanel.add(LoyaltyScheme_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 319, -1, -1));

        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Home-32.png"))); // NOI18N
        Home.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                HomeMouseMoved(evt);
            }
        });
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeMouseExited(evt);
            }
        });
        SubPanel.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        SubMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Menu-32 (1).png"))); // NOI18N
        SubMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubMenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SubMenuMouseExited(evt);
            }
        });
        SubMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SubMenuMouseMoved(evt);
            }
        });
        SubPanel.add(SubMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, -1, -1));

        getContentPane().add(SubPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 50, 670));

        TitleBar.setBackground(new java.awt.Color(255, 255, 255));
        TitleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TitleBarMouseDragged(evt);
            }
        });
        TitleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TitleBarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TitleBarMousePressed(evt);
            }
        });
        TitleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Minimize Window-32 (1).png"))); // NOI18N
        Minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeMouseExited(evt);
            }
        });
        Minimize.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MinimizeMouseMoved(evt);
            }
        });
        TitleBar.add(Minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1013, 11, -1, 30));

        Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Cancel-32.png"))); // NOI18N
        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelMouseExited(evt);
            }
        });
        Cancel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CancelMouseMoved(evt);
            }
        });
        TitleBar.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 11, -1, 30));

        logUserImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Male User-32 (dark).png"))); // NOI18N
        logUserImg.setToolTipText("User Info");
        logUserImg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                logUserImgMouseMoved(evt);
            }
        });
        logUserImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logUserImgMouseExited(evt);
            }
        });
        TitleBar.add(logUserImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 30));
        TitleBar.add(Uname_Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 70, 10));

        Show_Uname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Show_Uname.setText("Normal User");
        Show_Uname.setToolTipText("User Type");
        TitleBar.add(Show_Uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 40));

        signOut_button.setBackground(new java.awt.Color(204, 204, 204));
        signOut_button.setForeground(new java.awt.Color(51, 0, 0));
        signOut_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signOut_button.setText("SignOut");
        signOut_button.setToolTipText("SignOut");
        signOut_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOut_button.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                signOut_buttonMouseMoved(evt);
            }
        });
        signOut_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOut_buttonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signOut_buttonMouseExited(evt);
            }
        });
        TitleBar.add(signOut_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 70, 40));

        getContentPane().add(TitleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1110, -1));

        DetailPanal.setBackground(new java.awt.Color(204, 204, 255));
        DetailPanal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Customer_txt.setBackground(new java.awt.Color(37, 4, 70));
        Customer_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        Customer_txt.setForeground(new java.awt.Color(255, 255, 255));
        Customer_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Customer_txt.setText("Customers");
        Customer_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Customer_txtMouseMoved(evt);
            }
        });
        Customer_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Customer_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Customer_txtMouseExited(evt);
            }
        });
        DetailPanal.add(Customer_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 40, 190, 40));

        Supplier_txt.setBackground(new java.awt.Color(37, 4, 70));
        Supplier_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        Supplier_txt.setForeground(new java.awt.Color(255, 255, 255));
        Supplier_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Supplier_txt.setText("Suppliers");
        Supplier_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Supplier_txtMouseMoved(evt);
            }
        });
        Supplier_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Supplier_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Supplier_txtMouseExited(evt);
            }
        });
        DetailPanal.add(Supplier_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 100, 190, 40));

        LoyaltyScheme_txt.setBackground(new java.awt.Color(37, 4, 70));
        LoyaltyScheme_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        LoyaltyScheme_txt.setForeground(new java.awt.Color(255, 255, 255));
        LoyaltyScheme_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoyaltyScheme_txt.setText("Loyalty Scheme");
        LoyaltyScheme_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                LoyaltyScheme_txtMouseMoved(evt);
            }
        });
        LoyaltyScheme_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoyaltyScheme_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoyaltyScheme_txtMouseExited(evt);
            }
        });
        DetailPanal.add(LoyaltyScheme_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 160, 190, 40));

        Anime_sub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sb menu.png"))); // NOI18N
        DetailPanal.add(Anime_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 0, 190, 210));

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Customer_panel.setBackground(new java.awt.Color(204, 204, 255));
        Customer_panel.setPreferredSize(new java.awt.Dimension(1110, 520));
        Customer_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Customer_panel.add(tcad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 277, 136, 29));

        con_CL.setText("ContactNo");
        Customer_panel.add(con_CL, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 334, 100, 30));
        Customer_panel.add(tcnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 136, 29));

        cbl.setText("Loyalty Scheme");
        cbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblActionPerformed(evt);
            }
        });
        Customer_panel.add(cbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 250, 30));

        rm.setText("Remarks");
        Customer_panel.add(rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 32));

        tcrm.setColumns(20);
        tcrm.setRows(5);
        jScrollPane1.setViewportView(tcrm);

        Customer_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 140, 90));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Customer Registration");
        Customer_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 24, 320, 52));

        cid.setText("Customer_ID");
        Customer_panel.add(cid, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 124, 100, 32));

        cs_a_CheckBox.setBackground(new java.awt.Color(204, 204, 255));
        cs_a_CheckBox.setText("Active");
        cs_a_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cs_a_CheckBoxActionPerformed(evt);
            }
        });
        Customer_panel.add(cs_a_CheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 80, 20));

        cs_e_jCheckBox2.setBackground(new java.awt.Color(204, 204, 255));
        cs_e_jCheckBox2.setText("Expire");
        cs_e_jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cs_e_jCheckBox2ActionPerformed(evt);
            }
        });
        Customer_panel.add(cs_e_jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 80, 20));

        nm.setText("Name");
        Customer_panel.add(nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 226, 100, 32));

        ct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CustomerID", "Name", "Address", "Contact No", "Remarks", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ct);

        Customer_panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 550, 180));

        st.setText("Status");
        Customer_panel.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 175, 100, 32));
        Customer_panel.add(tccon, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 335, 140, 29));

        ad.setText("Address");
        Customer_panel.add(ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 280, 100, 32));

        Add_C.setText("Add");
        Add_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_CActionPerformed(evt);
            }
        });
        Customer_panel.add(Add_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 250, 30));

        Search_C.setText("Search");
        Search_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_CActionPerformed(evt);
            }
        });
        Customer_panel.add(Search_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 140, 30));

        Search_cmb_cus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1001", "1002", "1003", "1004", "1005", "1006", "1007", "1008", "1009" }));
        Customer_panel.add(Search_cmb_cus, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 140, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CusId", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable1);

        Customer_panel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 310, 130));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("            Black Listed Customers");
        Customer_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 300, 30));

        Clear_C.setText("Clear");
        Clear_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_CActionPerformed(evt);
            }
        });
        Customer_panel.add(Clear_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 470, 140, 30));

        Update_C.setText("Update");
        Update_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_CActionPerformed(evt);
            }
        });
        Customer_panel.add(Update_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 250, 30));
        Customer_panel.add(cusid_txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 136, 29));

        jLayeredPane1.add(Customer_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Supplier_panal.setBackground(new java.awt.Color(204, 204, 255));
        Supplier_panal.setPreferredSize(new java.awt.Dimension(1110, 520));
        Supplier_panal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spnml.setText("Product Name");
        Supplier_panal.add(spnml, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, 28));

        srml.setText("Remarks");
        Supplier_panal.add(srml, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, 28));

        supidl.setText("Supplier_ID");
        Supplier_panal.add(supidl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, 28));

        snml.setText("Name");
        Supplier_panal.add(snml, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 28));

        spidl.setText("Product ID");
        Supplier_panal.add(spidl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, 28));

        srpl.setText("Retail Price(With TAX)");
        Supplier_panal.add(srpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 28));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Supplier Detais");
        Supplier_panal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 10, 250, 40));

        sql.setText("Qty");
        Supplier_panal.add(sql, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 28));

        sconl.setText("Contact_No");
        Supplier_panal.add(sconl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 120, 28));

        ss_ComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1-10", "11-20", "21-30", "31-40", "41-50", "51-60", "61-70", "71-80", "81-90", "91-100", "101-110", "111-120", "121-130", "131-140", "141-150" }));
        ss_ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ss_ComboBox1ActionPerformed(evt);
            }
        });
        Supplier_panal.add(ss_ComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 172, 30));

        srtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srttActionPerformed(evt);
            }
        });
        Supplier_panal.add(srtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 172, 30));

        ssqt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssqtActionPerformed(evt);
            }
        });
        Supplier_panal.add(ssqt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 172, 30));

        srm_extArea1.setColumns(20);
        srm_extArea1.setRows(5);
        jScrollPane3.setViewportView(srm_extArea1);

        Supplier_panal.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 170, 79));

        st1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Supplier_ID", "Name", "Product ID", "Product Name", "Size", "Retail Price(With VAT)", "Qty", "Contact_No", "Remarks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        st1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                st1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(st1);
        if (st1.getColumnModel().getColumnCount() > 0) {
            st1.getColumnModel().getColumn(0).setMinWidth(45);
            st1.getColumnModel().getColumn(0).setPreferredWidth(45);
            st1.getColumnModel().getColumn(1).setMinWidth(28);
            st1.getColumnModel().getColumn(1).setPreferredWidth(28);
            st1.getColumnModel().getColumn(2).setMinWidth(55);
            st1.getColumnModel().getColumn(2).setPreferredWidth(55);
            st1.getColumnModel().getColumn(3).setMinWidth(60);
            st1.getColumnModel().getColumn(3).setPreferredWidth(60);
            st1.getColumnModel().getColumn(4).setMinWidth(18);
            st1.getColumnModel().getColumn(4).setPreferredWidth(18);
            st1.getColumnModel().getColumn(5).setMinWidth(50);
            st1.getColumnModel().getColumn(5).setPreferredWidth(50);
            st1.getColumnModel().getColumn(6).setMinWidth(18);
            st1.getColumnModel().getColumn(6).setPreferredWidth(18);
            st1.getColumnModel().getColumn(8).setMinWidth(45);
            st1.getColumnModel().getColumn(8).setPreferredWidth(45);
        }

        Supplier_panal.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 720, 250));

        Add_S.setText("Add Supplier");
        Add_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_SActionPerformed(evt);
            }
        });
        Supplier_panal.add(Add_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 140, 30));

        Update_S.setText("Update");
        Update_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_SActionPerformed(evt);
            }
        });
        Supplier_panal.add(Update_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, 130, 30));

        snmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snmtActionPerformed(evt);
            }
        });
        Supplier_panal.add(snmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 172, 30));

        spidt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spidtActionPerformed(evt);
            }
        });
        Supplier_panal.add(spidt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 172, 30));

        scont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scontActionPerformed(evt);
            }
        });
        Supplier_panal.add(scont, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 180, 30));
        Supplier_panal.add(spnmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 172, 30));

        ssl.setText("Size");
        Supplier_panal.add(ssl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 28));

        Search_S.setText("Search");
        Search_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_SActionPerformed(evt);
            }
        });
        Supplier_panal.add(Search_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 160, 30));

        search_cmb_supp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "S0001", "S0002", "S0003", "S0004", "S0005", "S0006", "S0007", "S0008", "S0009", "S0010", "S0011", "S0012", "S0013", "S0014", "S0015" }));
        Supplier_panal.add(search_cmb_supp, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 60, 130, 30));

        Clear_S.setText("Clear");
        Clear_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_SActionPerformed(evt);
            }
        });
        Supplier_panal.add(Clear_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, 130, 30));

        SupId_txt_Supp_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupId_txt_Supp_userActionPerformed(evt);
            }
        });
        Supplier_panal.add(SupId_txt_Supp_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 172, 30));

        jLayeredPane1.add(Supplier_panal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LoyaltySchemel_panel.setBackground(new java.awt.Color(204, 204, 255));
        LoyaltySchemel_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lcusidl.setText("Customer ID");
        LoyaltySchemel_panel.add(lcusidl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 150, 25));

        lsrl.setText("Sales Range");
        LoyaltySchemel_panel.add(lsrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 150, 25));

        lctl.setText("Current Total Loyalty Level");
        LoyaltySchemel_panel.add(lctl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 150, 25));

        lrpl.setText("Rating Point");
        LoyaltySchemel_panel.add(lrpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 150, 25));
        LoyaltySchemel_panel.add(lrtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 130, 23));

        lsr_ComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1000-1500", "1501-2000", "2001-2500", "2501-3000", "3001-3500", "3501-4000", "4001-4500", "4501-5000", "5001-10000", "1100-20000", "21000-30000", "31000-40000", "41000-50000", "51000-60000", "61000-70000", "71000-80000", "81000-90000", "91000-100000", "110000-120000", "121000-130000", "131000-140000", "141000-150000" }));
        lsr_ComboBox2.setToolTipText("");
        lsr_ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lsr_ComboBox2ActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(lsr_ComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 130, 23));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Loyalty Scheme");
        LoyaltySchemel_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 11, 280, 74));

        lt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Sales_Amount", "Sales Range", "Rating Pont", "Current Total Loyalty Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        lt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ltMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(lt);

        LoyaltySchemel_panel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 120, 600, 220));

        lbb.setText("Back");
        lbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbbActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(lbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 420, 130, 30));

        update_loyal_user_btn.setText("Update");
        update_loyal_user_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_loyal_user_btnActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(update_loyal_user_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 130, 30));

        Calculate_L.setText("Calculate");
        Calculate_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Calculate_LActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(Calculate_L, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 130, 30));
        LoyaltySchemel_panel.add(ltotl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 130, 23));

        Search_L.setText("Search");
        Search_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_LActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(Search_L, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 120, 30));

        jLabel2.setText("New Total Loyalty Level");
        LoyaltySchemel_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 150, 25));

        Loyal_Search_cmb_Admin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1001", "1002", "1003", "1004", "1005", "1006", "1007", "1008", "1009", "1010", "1011", "1012", "1013", "1014", "1015", "1016" }));
        LoyaltySchemel_panel.add(Loyal_Search_cmb_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, 120, 30));

        Clear_L.setText("Clear");
        Clear_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_LActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(Clear_L, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 390, 130, 30));
        LoyaltySchemel_panel.add(lctlt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 130, 23));

        Add_loyal_user_btn.setText("Add");
        Add_loyal_user_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_loyal_user_btnActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(Add_loyal_user_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 130, 30));

        loyalty_combo_user.setToolTipText("");
        loyalty_combo_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loyalty_combo_userActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(loyalty_combo_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 130, 23));

        lsrl1.setText("Sales Amount");
        LoyaltySchemel_panel.add(lsrl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 150, 25));

        SalesAmount_Combo_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesAmount_Combo_UserActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(SalesAmount_Combo_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 130, 23));

        Delete_loyal_user_btn.setText("Delete");
        Delete_loyal_user_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_loyal_user_btnActionPerformed(evt);
            }
        });
        LoyaltySchemel_panel.add(Delete_loyal_user_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 130, 30));

        jLayeredPane1.add(LoyaltySchemel_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        DetailPanal.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 510));

        getContentPane().add(DetailPanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 153, 1110, 510));

        TimeLine.setBackground(new java.awt.Color(204, 204, 204));
        TimeLine.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SLogo.png"))); // NOI18N
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });
        TimeLine.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 120));

        Clock.setFont(new java.awt.Font("Digital-7 Mono", 0, 48)); // NOI18N
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("00:00");
        Clock.setToolTipText("");
        TimeLine.add(Clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(917, 11, 128, 53));

        Am_Pm.setFont(new java.awt.Font("Digital-7 Mono", 0, 24)); // NOI18N
        Am_Pm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Am_Pm.setToolTipText("");
        TimeLine.add(Am_Pm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1045, 21, 26, 43));

        dateLable.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        dateLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLable.setText("00 00 0000");
        TimeLine.add(dateLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(878, 70, 212, 38));

        getContentPane().add(TimeLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 44, 1110, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TitleBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleBarMouseClicked

    private void TitleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMouseDragged
       //mouse dragged even and create mouse x & y axie
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_TitleBarMouseDragged

    private void TitleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMousePressed
        //Jframe pressed and dragged Ivent
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_TitleBarMousePressed

    private void MinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseClicked
        this.setState(JFrame.ICONIFIED); // minimize Button Mouse click event
        
    }//GEN-LAST:event_MinimizeMouseClicked

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
       //Close Button mouse click event
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Exit",dialog);
        if(result == 0)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_CancelMouseClicked

    private void MinimizeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseMoved
        Minimize.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));
    }//GEN-LAST:event_MinimizeMouseMoved

    private void MinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseExited
       Minimize.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_MinimizeMouseExited

    private void CancelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseMoved
        Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
    }//GEN-LAST:event_CancelMouseMoved

    private void CancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseExited
        Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_CancelMouseExited

    private void HomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
       
    }//GEN-LAST:event_HomeMouseMoved

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_HomeMouseExited

    private void SubMenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubMenuMouseMoved
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
       
        
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
    }//GEN-LAST:event_SubMenuMouseMoved

    private void SubMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubMenuMouseExited
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_SubMenuMouseExited

    private void Customer_IconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_IconMouseMoved
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        
        Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
    }//GEN-LAST:event_Customer_IconMouseMoved

    private void Customer_IconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_IconMouseExited
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Customer_IconMouseExited

    private void Supplier_IconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Supplier_IconMouseMoved
        Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
    }//GEN-LAST:event_Supplier_IconMouseMoved

    private void Supplier_IconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Supplier_IconMouseExited
         Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
         Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Supplier_IconMouseExited

    private void LoyaltyScheme_IconMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoyaltyScheme_IconMouseMoved
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,7
        
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
    }//GEN-LAST:event_LoyaltyScheme_IconMouseMoved

    private void LoyaltyScheme_IconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoyaltyScheme_IconMouseExited
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_LoyaltyScheme_IconMouseExited

    //Sub Menu Animation Movement
    private void SubMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubMenuMouseClicked
        //  --------->>>
        AnimationClass sub1 = new AnimationClass();
        sub1.jLabelXRight(-190, 0, 10, 5, Anime_sub);
        // <<<----------
        AnimationClass sub2 = new AnimationClass();
        sub2.jLabelXLeft(0, -190, 10, 5, Anime_sub);
        //---------------------------------------------
        
        //  --------->>>
        AnimationClass AddRemove1 = new AnimationClass();
        AddRemove1.jLabelXRight(-190, 0, 10, 5, Customer_txt);
        // <<<----------
        AnimationClass AddRemove2 = new AnimationClass();
        AddRemove2.jLabelXLeft(0, -190, 10, 5, Customer_txt);
        //---------------------------------------------
        
        //  --------->>>
        AnimationClass Attendance1 = new AnimationClass();
        Attendance1.jLabelXRight(-190, 0, 10, 5, Supplier_txt);
        // <<<----------
        AnimationClass Attendance2 = new AnimationClass();
        Attendance2.jLabelXLeft(0, -190, 10, 5, Supplier_txt);
        //---------------------------------------------
        
        //  --------->>>
        AnimationClass EDetails1 = new AnimationClass();
        EDetails1.jLabelXRight(-190, 0, 10, 5, LoyaltyScheme_txt);
        // <<<----------
        AnimationClass EDetails2 = new AnimationClass();
        EDetails2.jLabelXLeft(0, -190, 10, 5, LoyaltyScheme_txt);
        //---------------------------------------------
        
        
        
    }//GEN-LAST:event_SubMenuMouseClicked

    private void Customer_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        
    }//GEN-LAST:event_Customer_txtMouseMoved

    private void Customer_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_txtMouseExited
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Customer_txtMouseExited

    private void Supplier_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Supplier_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
    }//GEN-LAST:event_Supplier_txtMouseMoved

    private void Supplier_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Supplier_txtMouseExited
        Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Supplier_txtMouseExited

    private void LoyaltyScheme_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoyaltyScheme_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        Customer_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Customer_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Supplier_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
    }//GEN-LAST:event_LoyaltyScheme_txtMouseMoved

    private void LoyaltyScheme_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoyaltyScheme_txtMouseExited
        LoyaltyScheme_Icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        LoyaltyScheme_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_LoyaltyScheme_txtMouseExited

    private void Customer_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_txtMouseClicked
        Customer_panel.setVisible(true);
        Supplier_panal.setVisible(false);
        LoyaltySchemel_panel.setVisible(false);
        
    }//GEN-LAST:event_Customer_txtMouseClicked

    private void Customer_IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_IconMouseClicked
        Customer_panel.setVisible(true);
        Supplier_panal.setVisible(false);
        LoyaltySchemel_panel.setVisible(false);
    }//GEN-LAST:event_Customer_IconMouseClicked

    private void Supplier_IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Supplier_IconMouseClicked
        Supplier_panal.setVisible(true);
        Customer_panel.setVisible(false);
        LoyaltySchemel_panel.setVisible(false);
        
    }//GEN-LAST:event_Supplier_IconMouseClicked

    private void LoyaltyScheme_IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoyaltyScheme_IconMouseClicked
        LoyaltySchemel_panel.setVisible(true);
        Customer_panel.setVisible(false);
        Supplier_panal.setVisible(false);
        
        
        
    }//GEN-LAST:event_LoyaltyScheme_IconMouseClicked

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        Customer_panel.setVisible(false);
        Supplier_panal.setVisible(false);
        LoyaltySchemel_panel.setVisible(false);
        
    }//GEN-LAST:event_logoMouseClicked

    private void Supplier_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Supplier_txtMouseClicked
        Supplier_panal.setVisible(true);
        Customer_panel.setVisible(false);
        LoyaltySchemel_panel.setVisible(false);
       
    }//GEN-LAST:event_Supplier_txtMouseClicked

    private void LoyaltyScheme_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoyaltyScheme_txtMouseClicked
        LoyaltySchemel_panel.setVisible(true);
        Customer_panel.setVisible(false);
        Supplier_panal.setVisible(false);
         
    }//GEN-LAST:event_LoyaltyScheme_txtMouseClicked

    private void cblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblActionPerformed
        // TODO add your handling code here:
  
        Customer_panel.setVisible(false);
        Supplier_panal.setVisible(false);
        LoyaltySchemel_panel.setVisible(true);
        
        
    }//GEN-LAST:event_cblActionPerformed

    private void cs_a_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cs_a_CheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cs_a_CheckBoxActionPerformed

    private void ctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctMouseClicked
        // TODO add your handling code here:
        int r = ct.getSelectedRow();
        String Address = ct.getValueAt(r, 3).toString();
        String Name = ct.getValueAt(r, 2).toString();
        String ContactNo = ct.getValueAt(r, 4).toString();
        String Status = ct.getValueAt(r, 1).toString();
        switch (Status) {
            case "Active":
                cs_a_CheckBox.setSelected(true);
                cs_e_jCheckBox2.setSelected(false);
                break;
            case "Expire":
                cs_e_jCheckBox2.setSelected(true);
                cs_a_CheckBox.setSelected(false);
                break;
            default:
                cs_a_CheckBox.setSelected(true);
                cs_e_jCheckBox2.setSelected(true);
                break;
        }
        String CusId = ct.getValueAt(r, 0).toString();
        String Remarks = ct.getValueAt(r, 5).toString();

        tccon.setText(ContactNo);
        tcad.setText(Address);
        cusid_txt_user.setText(CusId);
        tcnm.setText(Name);
        tcrm.setText(Remarks);
        if (cusid_txt_user.getText().length() != 0) {
            cusid_txt_user.setEnabled(false);
        }

    }//GEN-LAST:event_ctMouseClicked

    private void Add_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_CActionPerformed
        // TODO add your handling code here:

        {
            String status;
            status = " ";
            String Cusid = cusid_txt_user.getText();

            if (cs_a_CheckBox.isSelected()) {
                status = "Active";
            } else if (cs_e_jCheckBox2.isSelected()) {
                status = "Expire";;
            }

            String Name = tcnm.getText();
            String Address = tcad.getText();

            String ContactNo = tccon.getText();
            String Remarks = tcrm.getText();

            try {
                if (validatingint_Customer(Cusid)) {
                    if (ValidatingPhoneNumber(ContactNo)) {
                        if (validateCustomerName(Name)) {

                            JOptionPane.showConfirmDialog(rootPane, "Do you want to save?");
                            String n = "INSERT INTO customer (Cusid,status,Name,Address,ContactNo,Remarks) values('" + Cusid + "','" + status + "','" + Name + "','" + Address + "','" + ContactNo + "','" + Remarks + "')";
                            pst = conn.prepareStatement(n);
                            pst.execute();

                            tableLoad_Customer();

                            JOptionPane.showMessageDialog(rootPane, "Successfully Added");
                        } else {
                            JOptionPane.showMessageDialog(this, "Can't add digits to Name ");

                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Contact_No needs exactly 10 characters");

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "CustomerID need 4 or more than 4 digits & can't add Strings");

                }

            } catch (SQLException e) {
                System.out.println(e);

                if (cusid_txt_user.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter  Cusid");
                    cusid_txt_user.requestFocus();
                    return;

                }
                if (cs_a_CheckBox.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter status");
                    cs_a_CheckBox.requestFocus();
                    return;

                }
                if (tcnm.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter Name");
                    tcnm.requestFocus();
                    return;

                }
                if (tcad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter address");
                    tcad.requestFocus();
                    return;

                }
                if (tccon.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter ContactNo");
                    tccon.requestFocus();
                    return;

                }

                if (tcrm.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter remarks");
                    tcrm.requestFocus();
                    return;

                }

            }
        }

  
    }//GEN-LAST:event_Add_CActionPerformed

    private void ss_ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ss_ComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ss_ComboBox1ActionPerformed

    private void st1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_st1MouseClicked
        int r = st1.getSelectedRow();
        String Supplier_ID = st1.getValueAt(r, 0).toString();
        String name = st1.getValueAt(r, 1).toString();
        String pid = st1.getValueAt(r, 2).toString();
        String pname = st1.getValueAt(r, 3).toString();
        String siz = st1.getValueAt(r, 4).toString();
        String ren = st1.getValueAt(r, 5).toString();
        String qty = st1.getValueAt(r, 6).toString();
        String Contact_No = st1.getValueAt(r, 7).toString();
        String rem = st1.getValueAt(r, 8).toString();

        SupId_txt_Supp_user.setText(Supplier_ID);
        snmt.setText(name);
        spidt.setText(pid);
        spnmt.setText(pname);
        ss_ComboBox1.setSelectedItem(siz);
        srtt.setText(ren);
        ssqt.setText(qty);
        scont.setText(Contact_No);
        srm_extArea1.setText(rem);
        if (SupId_txt_Supp_user.getText().length() != 0) {
            SupId_txt_Supp_user.setEnabled(false);
        }

    }//GEN-LAST:event_st1MouseClicked

    private void Add_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_SActionPerformed
        // TODO add your handling code here:

        String Supplier_ID = SupId_txt_Supp_user.getText();
        String name = snmt.getText();
        String pid = spidt.getText();
        String pname = spnmt.getText();
        String size = ss_ComboBox1.getSelectedItem().toString();
        String rprice = srtt.getText();
        String qty = ssqt.getText();
        String Contact_No = scont.getText();
        String remarks = srm_extArea1.getText();

        try {
            if (validateSupplierName(name)) {
                if (ValidatingSupplierVarchar(Supplier_ID)) {
                    if (validatingFloat(rprice)) {
                        if (validatingInt(qty)) {
                            if (ValidatingSuppContactNO(Contact_No)) {

                                String q = "INSERT INTO supplier1(Supplier_ID,Name,Product_ID,Product_Name,Size,Retail_Price,Qty,Contact_No,Remarks) VALUES('" + Supplier_ID + "','" + name + "','" + pid + "','" + pname + "','" + size + "','" + rprice + "','" + qty + "','" + Contact_No + "','" + remarks + "')";

                                pst = conn.prepareStatement(q);
                                pst.execute();
                                tableLoad_Supplier();
                                JOptionPane.showMessageDialog(rootPane, "Successfully Added");
                            } else {
                                JOptionPane.showMessageDialog(this, "Contact_No needs at least 10 characters");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Qty should be more than 1");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this,"Retail Price should be more than 1");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Supplier_ID need 5 or more characters");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Supplier_Name can't add digits");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_Add_SActionPerformed

    private void Update_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_SActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you want to update?");
        if (x == 0) {
            String Supplier_ID = SupId_txt_Supp_user.getText();
            String name = snmt.getText();
            String pid = spidt.getText();
            String pname = spnmt.getText();
            String size = ss_ComboBox1.getSelectedItem().toString();
            String rprice = srtt.getText();
            String qty = ssqt.getText();
            String Contact_No = scont.getText();
            String remarks = srm_extArea1.getText();

            try {
                if (ValidatingPhoneNumber(Contact_No)) {
                    if (validateSupplierName(name)) {
                        if ((rprice).length()>2) {
                            if ((qty).length()>2) {

                                String q = "update supplier1  set Product_ID='" + pid + "',Product_Name='" + pname + "',Size='" + size + "',Retail_Price='" + rprice + "',Qty='" + qty + "',Contact_No='" + Contact_No + "',Remarks='" + remarks + "',Name='" + name + "' where Supplier_ID='" + Supplier_ID + "'";

                                pst = conn.prepareStatement(q);
                                pst.execute();
                                tableLoad_Supplier();
                                
                            } else {
                                JOptionPane.showMessageDialog(this, "Qty should be more than 1");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Retail_Price should be more than 1");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Supplier_Name can't add digits");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ContactNO should be 10 digits");
                }
            } catch (Exception e) {

            }

        }
    }//GEN-LAST:event_Update_SActionPerformed

    private void snmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snmtActionPerformed

    private void spidtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spidtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spidtActionPerformed

    private void ltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltMouseClicked
        // TODO add your handling code here:
        int r = lt.getSelectedRow();
        String CustomerID = lt.getValueAt(r, 0).toString();
        String Sales_Amount = lt.getValueAt(r, 1).toString();
        String SalesRange = lt.getValueAt(r, 2).toString();
        String RatingPoint = lt.getValueAt(r, 3).toString();
        String CurrentTotalLoyaltyLevel = lt.getValueAt(r, 4).toString();

        loyalty_combo_user.setSelectedItem(CustomerID);
        SalesAmount_Combo_User.setSelectedItem(Sales_Amount);
        lsr_ComboBox2.setSelectedItem(SalesRange);
        lrtt.setText(RatingPoint);
        lctlt1.setText(CurrentTotalLoyaltyLevel);
        
        if (loyalty_combo_user.getSelectedItem().toString().length() != 0) { 
            loyalty_combo_user.setEnabled(false);
        }
    }//GEN-LAST:event_ltMouseClicked

    private void lbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbbActionPerformed
        // TODO add your handling code here:
        
        Customer_panel.setVisible(true);
        Supplier_panal.setVisible(false);
        LoyaltySchemel_panel.setVisible(false);
        
    }//GEN-LAST:event_lbbActionPerformed

    private void update_loyal_user_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_loyal_user_btnActionPerformed
        // TODO add your handling code here:

        String CustomerID = loyalty_combo_user.getSelectedItem().toString();
        String Sales_Amount = SalesAmount_Combo_User.getSelectedItem().toString();
        String SalesRange = lsr_ComboBox2.getSelectedItem().toString();
        String RatingPoint = lrtt.getText();
        String CurrentTotalLoyaltyLevel = ltotl.getText();

            try {

                JOptionPane.showConfirmDialog(rootPane, "Do you want to save?");

                String sql = "UPDATE LoyaltyScheme SET Sales_Amount = '" + Sales_Amount + "',SalesRange = '" + SalesRange + "',RatingPoint = '" + RatingPoint + "',CurrentTotalLoyaltyLevel = '" + CurrentTotalLoyaltyLevel + "'where CustomerID = '" + CustomerID + "'";
                pst = conn.prepareStatement(sql);
                pst.execute();

                tableLoad_Loyalty();

                JOptionPane.showMessageDialog(rootPane, "Successfully Added");
             

        } catch (SQLException e) {
            System.out.println(e);
        }

        loyalty_combo_user.setSelectedIndex(0);
        SalesAmount_Combo_User.setSelectedIndex(0);
        lsr_ComboBox2.setSelectedIndex(0);
        lctlt1.setText("");
        lrtt.setText("");
        ltotl.setText("");

    }//GEN-LAST:event_update_loyal_user_btnActionPerformed

    private void Calculate_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Calculate_LActionPerformed
        // TODO add your handling code here:
        int d = Integer.parseInt(lrtt.getText());
        int e = Integer.parseInt(lctlt1.getText());
        int f = d + e;
        ltotl.setText(f+" ");
    }//GEN-LAST:event_Calculate_LActionPerformed

    private void Search_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_LActionPerformed
        // TODO add your handling code here:
            
        String CustomerID = Loyal_Search_cmb_Admin.getSelectedItem().toString();
        String sql = "SELECT CustomerID,Amount,SalesRange,RatingPoint,CurrentTotalLoyaltyLevel from LoyaltyScheme where CustomerID = '" + CustomerID + "'";

        try {

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            lt.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {

        }
        
       
    }//GEN-LAST:event_Search_LActionPerformed

    private void cs_e_jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cs_e_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cs_e_jCheckBox2ActionPerformed

    private void srttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srttActionPerformed

    private void scontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scontActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scontActionPerformed

    private void ssqtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssqtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssqtActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void Search_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_CActionPerformed
        // TODO add your handling code here:
         
        String CusId = Search_cmb_cus.getSelectedItem().toString();
        String sql = "SELECT Cusid,status,Name,Address,ContactNo,Remarks from customer where CusId  = '" + CusId + "'";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            ct.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {

        }
    }//GEN-LAST:event_Search_CActionPerformed

    private void Search_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_SActionPerformed
        // TODO add your handling code here:
         
        String Supplier_ID = search_cmb_supp.getSelectedItem().toString();
        String sql = "SELECT Supplier_ID,Name,Product_ID,Product_Name,Size,Retail_Price,Qty,Contact_No,Remarks from supplier1  where Supplier_ID  = '" + Supplier_ID + "'";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            st1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {

        }
    }//GEN-LAST:event_Search_SActionPerformed

    private void Clear_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_SActionPerformed
        // TODO add your handling code here:
        SupId_txt_Supp_user.setText("");
        snmt .setText("");
        spidt.setText("");
        spnmt.setText("");
        ss_ComboBox1.setSelectedIndex(0);
        srtt.setText("");
        ssqt.setText("");
        scont.setText("");
        srm_extArea1.setText("");
        search_cmb_supp.setSelectedIndex(0);
        SupId_txt_Supp_user.setEnabled(true);
       
    }//GEN-LAST:event_Clear_SActionPerformed

    private void Clear_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_LActionPerformed
        // TODO add your handling code here:        
        lsr_ComboBox2.setSelectedIndex(0);
        SalesAmount_Combo_User.setSelectedIndex(0);
        lrtt.setText("");
        lctlt1.setText("");
        loyalty_combo_user.setSelectedIndex(0);
        ltotl.setText("");
        loyalty_combo_user.setEnabled(true);
        
        
    }//GEN-LAST:event_Clear_LActionPerformed

    private void Clear_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_CActionPerformed
        // TODO add your handling code here:
        cusid_txt_user.setText("");
        cs_a_CheckBox.setSelected(false);
        cs_e_jCheckBox2.setSelected(false);
        tcnm.setText("");
        tcad.setText("");
        tccon.setText("");  
        tcrm.setText("");
        Search_cmb_cus.setSelectedIndex(0);
        cusid_txt_user.setEnabled(true);
    }//GEN-LAST:event_Clear_CActionPerformed

    private void Update_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_CActionPerformed
        // TODO add your handling code here:
        
        int x = JOptionPane.showConfirmDialog(null,"DO YOU REALLY WANT UPDATE");
        if (x == 0) {
            String status;
            status = " ";
            String Cusid = cusid_txt_user.getText();

            if (cs_a_CheckBox.isSelected()) {
                status = "Active";
            } else if (cs_e_jCheckBox2.isSelected()) {
                status = "Expire";;
            }

            String Name = tcnm.getText();
            String Address = tcad.getText();
            String ContactNo = tccon.getText();
            String Remarks = tcrm.getText();

            try {
                if (ValidatingPhoneNumber(ContactNo)) {
                    if (validateCustomerName(Name)) {

                        String sql = "UPDATE customer SET status = '" + status + "',Name = '" + Name + "',Address = '" + Address + "',ContactNo = '" + ContactNo + "',Remarks = '" + Remarks + "'where Cusid = '" + Cusid + "'";

                        JOptionPane.showConfirmDialog(rootPane, "Do you want to save?");
                        pst = conn.prepareStatement(sql);
                        pst.execute();

                        tableLoad_Customer();

                        JOptionPane.showMessageDialog(rootPane, "Successfully Updated");

                    } else {
                        JOptionPane.showMessageDialog(this, "Can't add digits to Name ");

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Contact No should be 10 digits");
                }

            } catch (SQLException e) {
                System.out.println(e);

                if (cusid_txt_user.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter  Cusid");
                    cusid_txt_user.requestFocus();
                    return;

                }
                if (cs_a_CheckBox.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter status");
                    cs_a_CheckBox.requestFocus();
                    return;

                }
                if (tcnm.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter Name");
                    tcnm.requestFocus();
                    return;

                }
                if (tcad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter address");
                    tcad.requestFocus();
                    return;

                }
                if (tccon.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter ContactNo");
                    tccon.requestFocus();
                    return;

                }

                if (tcrm.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter remarks");
                    tcrm.requestFocus();
                    return;

                }

            }
        }

        {
            String status;
            status = " ";
            String Cusid = cusid_txt_user.getText();

            if (cs_e_jCheckBox2.isSelected()) {
                status = "Expire";

                try {

                    JOptionPane.showConfirmDialog(rootPane, "Do you want to save black list?");

                    String m = "INSERT INTO customer1 (Cusid,status) values('" + Cusid + "','" + status + "')";
                    pst = conn.prepareStatement(m);
                    pst.execute();

                    tableLoad_Customer1();

                    JOptionPane.showMessageDialog(rootPane, "Successfully Added to the BlackListed Table");

                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
        

    }//GEN-LAST:event_Update_CActionPerformed
    
    private void SupId_txt_Supp_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupId_txt_Supp_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupId_txt_Supp_userActionPerformed

    private void Add_loyal_user_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_loyal_user_btnActionPerformed
        // TODO add your handling code here:
              
        String CustomerID = loyalty_combo_user.getSelectedItem().toString();
        String Sales_Amount = SalesAmount_Combo_User.getSelectedItem().toString();
        String SalesRange = lsr_ComboBox2.getSelectedItem().toString();
        String RatingPoint = lrtt.getText();
        String CurrentTotalLoyaltyLevel = ltotl.getText();
        
        try {

                JOptionPane.showConfirmDialog(rootPane, "Do you want to save?");

                String n = "INSERT INTO LoyaltyScheme (CustomerID,Amount,SalesRange,RatingPoint,CurrentTotalLoyaltyLevel) values('" + CustomerID + "','" + Sales_Amount + "','" + SalesRange + "','" + RatingPoint + "','" + CurrentTotalLoyaltyLevel + "')";
                pst = conn.prepareStatement(n);
                pst.execute();

                tableLoad_Loyalty();
                JOptionPane.showMessageDialog(rootPane, "Successfully Added");


        } catch (SQLException e) {
        }

        loyalty_combo_user.setSelectedIndex(0);
        SalesAmount_Combo_User.setSelectedIndex(0);
        lsr_ComboBox2.setSelectedIndex(0);
        lctlt1.setText("");
        lrtt.setText("");
        ltotl.setText("");
    }//GEN-LAST:event_Add_loyal_user_btnActionPerformed

    private void loyalty_combo_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loyalty_combo_userActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_loyalty_combo_userActionPerformed

    private void lsr_ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lsr_ComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lsr_ComboBox2ActionPerformed

    private void SalesAmount_Combo_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesAmount_Combo_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalesAmount_Combo_UserActionPerformed

    private void Delete_loyal_user_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_loyal_user_btnActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(null,"Do you want to delete?");
        if (x==0)
        {   
            String  CustomerID = loyalty_combo_user.getSelectedItem().toString();
            System.out.println(CustomerID);
            String sq = "DELETE FROM `loyaltyscheme` WHERE CustomerID = '"+CustomerID+"'";
            try {
                pst=conn.prepareStatement(sq);
                pst.execute();
                tableLoad_Loyalty();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        lsr_ComboBox2.setSelectedIndex(0);
        SalesAmount_Combo_User.setSelectedIndex(0);
        lrtt.setText("");
        lctlt1.setText("");
        loyalty_combo_user.setSelectedIndex(0);
        ltotl.setText("");
        loyalty_combo_user.setEnabled(true);
        
    }//GEN-LAST:event_Delete_loyal_user_btnActionPerformed

    private void logUserImgMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logUserImgMouseMoved
        logUserImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        signOut_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
        
        //        Details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        //        Confirm_request.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        //        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        //
        //        ADD_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        //        Attend_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        //        EmpDetail_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        //        Request_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        //        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_logUserImgMouseMoved

    private void logUserImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logUserImgMouseExited
        logUserImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_logUserImgMouseExited

    private void signOut_buttonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOut_buttonMouseMoved
        signOut_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        logUserImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
        
    }//GEN-LAST:event_signOut_buttonMouseMoved

    private void signOut_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOut_buttonMouseClicked
        //this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //this.setCursor(Cursor.getDefaultCursor());

        MainHome home = new MainHome();
        home.setVisible(true);
        this.dispose();

        //            User_login.setVisible(true);
        //            logUserImg.setVisible(false);
        //            Show_Uname.setVisible(false);
        //            Uname_Separator.setVisible(false);
        //            signOut_button.setVisible(false);
        //            Admin_login_sign1.setVisible(false);
        //            ExpandArrow.setVisible(false);
        //            Other_login_sign.hide();
        //            CollapseArrow.hide();
        //
        //           Admin_menu_panel.setVisible(false);
        //           NonUser_menu_panel.setVisible(true);
        //           Employees_back2.setVisible(false);
        //           User_menu_panel.setVisible(false);
        //           ManageEmployee_subMenu_panel.setVisible(false);
        //           ManageEmployee_subMenu_panel1.setVisible(false);

    }//GEN-LAST:event_signOut_buttonMouseClicked

    private void signOut_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOut_buttonMouseExited
        signOut_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_signOut_buttonMouseExited

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
       int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Do you want to go 'Home Page'", "Exit",dialog);
        if(result == 0)
        {
            UserHome home = new UserHome();//venas karanna main home eke name ekata
            home.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_HomeMouseClicked

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
            java.util.logging.Logger.getLogger(Manage_Customer_Supplier_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Customer_Supplier_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Customer_Supplier_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Customer_Supplier_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Customer_Supplier_User().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_C;
    private javax.swing.JButton Add_S;
    private javax.swing.JButton Add_loyal_user_btn;
    private javax.swing.JLabel Am_Pm;
    private javax.swing.JLabel Anime_sub;
    private javax.swing.JButton Calculate_L;
    private javax.swing.JLabel Cancel;
    private javax.swing.JButton Clear_C;
    private javax.swing.JButton Clear_L;
    private javax.swing.JButton Clear_S;
    private javax.swing.JLabel Clock;
    private javax.swing.JLabel Customer_Icon;
    private javax.swing.JPanel Customer_panel;
    private javax.swing.JLabel Customer_txt;
    private javax.swing.JButton Delete_loyal_user_btn;
    private javax.swing.JPanel DetailPanal;
    private javax.swing.JLabel Home;
    private javax.swing.JComboBox<String> Loyal_Search_cmb_Admin;
    private javax.swing.JLabel LoyaltyScheme_Icon;
    private javax.swing.JLabel LoyaltyScheme_txt;
    private javax.swing.JPanel LoyaltySchemel_panel;
    private javax.swing.JLabel Minimize;
    private javax.swing.JComboBox SalesAmount_Combo_User;
    private javax.swing.JButton Search_C;
    private javax.swing.JButton Search_L;
    private javax.swing.JButton Search_S;
    private javax.swing.JComboBox<String> Search_cmb_cus;
    private javax.swing.JLabel Show_Uname;
    private javax.swing.JLabel SubMenu;
    private javax.swing.JPanel SubPanel;
    private javax.swing.JTextField SupId_txt_Supp_user;
    private javax.swing.JLabel Supplier_Icon;
    private javax.swing.JPanel Supplier_panal;
    private javax.swing.JLabel Supplier_txt;
    private javax.swing.JPanel TimeLine;
    private javax.swing.JPanel TitleBar;
    private javax.swing.JSeparator Uname_Separator;
    private javax.swing.JButton Update_C;
    private javax.swing.JButton Update_S;
    private javax.swing.JLabel ad;
    private javax.swing.JButton cbl;
    private javax.swing.JLabel cid;
    private javax.swing.JLabel con_CL;
    private javax.swing.JCheckBox cs_a_CheckBox;
    private javax.swing.JCheckBox cs_e_jCheckBox2;
    private javax.swing.JTable ct;
    private javax.swing.JTextField cusid_txt_user;
    private javax.swing.JLabel dateLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lbb;
    private javax.swing.JLabel lctl;
    private javax.swing.JTextField lctlt1;
    private javax.swing.JLabel lcusidl;
    private javax.swing.JLabel logUserImg;
    private javax.swing.JLabel logo;
    private javax.swing.JComboBox<String> loyalty_combo_user;
    private javax.swing.JLabel lrpl;
    private javax.swing.JTextField lrtt;
    private javax.swing.JComboBox lsr_ComboBox2;
    private javax.swing.JLabel lsrl;
    private javax.swing.JLabel lsrl1;
    private javax.swing.JTable lt;
    private javax.swing.JLabel ltotl;
    private javax.swing.JLabel nm;
    private javax.swing.JLabel rm;
    private javax.swing.JLabel sconl;
    private javax.swing.JTextField scont;
    private javax.swing.JComboBox<String> search_cmb_supp;
    private javax.swing.JLabel signOut_button;
    private javax.swing.JLabel snml;
    private javax.swing.JTextField snmt;
    private javax.swing.JLabel spidl;
    private javax.swing.JTextField spidt;
    private javax.swing.JLabel spnml;
    private javax.swing.JTextField spnmt;
    private javax.swing.JLabel sql;
    private javax.swing.JTextArea srm_extArea1;
    private javax.swing.JLabel srml;
    private javax.swing.JLabel srpl;
    private javax.swing.JTextField srtt;
    private javax.swing.JComboBox ss_ComboBox1;
    private javax.swing.JLabel ssl;
    private javax.swing.JTextField ssqt;
    private javax.swing.JLabel st;
    private javax.swing.JTable st1;
    private javax.swing.JLabel supidl;
    private javax.swing.JTextField tcad;
    private javax.swing.JTextField tccon;
    private javax.swing.JTextField tcnm;
    private javax.swing.JTextArea tcrm;
    private javax.swing.JButton update_loyal_user_btn;
    // End of variables declaration//GEN-END:variables

//    private void setTime() {
//        new Thread(){
//            public void run(){
//                while(timeRun==0)
//                {
//                    Calendar cal = new GregorianCalendar();
//                    
//                    int hour=cal.get(Calendar.HOUR);
//                    int min=cal.get(Calendar.MINUTE);
//                    int sec=cal.get(Calendar.SECOND);
//                    int am_pm=cal.get(Calendar.AM_PM);
//                    
//                    String DayNight="";
//                    if(am_pm==1){
//                        DayNight="PM";
//                    }
//                    else{
//                        DayNight="AM";
//                    }
//                    String time =hour+":"+min+":"+sec;
//                    String day_night = DayNight;
//                    Clock.setText(time);
//                    Am_Pm.setText(day_night);
//                }
//            }
//        }.start();
//    }

    private void setHide() {
        Customer_panel.setVisible(false);
        Supplier_panal.setVisible(false);
        LoyaltySchemel_panel.setVisible(false);
        
    }

    private void tableLoad_Supplier() {
        try {
                 String sql="SELECT Supplier_ID,Name,Product_ID,Product_Name,Size,Retail_Price,Qty,Contact_No,Remarks from supplier1";
        pst=conn.prepareStatement(sql);
       rs= pst.executeQuery();
       st1.setModel(DbUtils.resultSetToTableModel(rs));
       
       
       
       
        } catch (Exception e) {
        }
        
        }

    private void tableLoad_Customer() {
        try {
            String sql ="SELECT Cusid,status,Name,Address,ContactNo,Remarks FROM customer";
            pst = conn.prepareStatement(sql); 
            rs = pst.executeQuery();
         
         ct.setModel(DbUtils.resultSetToTableModel(rs));
         
        } catch (SQLException e) {
            
        }
    }
    private void tableLoad_Customer1() {
        try {
            String sql = "SELECT Cusid,status FROM customer1";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {

        }
    }
   
    private void tableLoad_Loyalty() {
        try {
            String sql ="SELECT CustomerID,Amount,SalesRange,RatingPoint,CurrentTotalLoyaltyLevel FROM LoyaltyScheme";
            pst = conn.prepareStatement(sql); 
            rs = pst.executeQuery();
         
         lt.setModel(DbUtils.resultSetToTableModel(rs));
         
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    private void FillComboCusID()
    {
        try {
            String sql ="SELECT * FROM customer";
            pst = conn.prepareStatement(sql);
            rs  = pst.executeQuery();
           
            loyalty_combo_user.addItem("");
            
            while(rs.next())
            {
                String name = rs.getString("cusid");
                loyalty_combo_user.addItem(name);
            
            
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }    
    }
    
    private void FillComboSalesAmount()
    {
        try {
            String sql ="SELECT * FROM stransaction";
            pst = conn.prepareStatement(sql);
            rs  = pst.executeQuery();
            
            SalesAmount_Combo_User.addItem("");
            
            while(rs.next())
            {
                float name = rs.getFloat("Amount");
                String amount = Float.toString(name);
                SalesAmount_Combo_User.addItem(amount);
            
            
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }    
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("SLogo.png")));
    }
}
