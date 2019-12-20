/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory_mng;

import AppPackage.AnimationClass;
import HomePage_Package.*;
import RetailSalesHandling_Package.*;
import Inventory_mng.*;
import Manage_Customer_Supplier_Package.*;
import RetailSalesHandling_Package.*;
import DbConnection.DatabaseConn;
import com.itextpdf.text.BaseColor;
import com.mysql.jdbc.Blob;
import java.sql.Connection;
import DbConnection.*;
import PurchasingPackage.*;
import ComplaintMng_Package.*;
import Employee_AttendanceMng_Package.*;
import HomePage_Package.*;
import Inventory_mng.*;
import JobMng_Package.*;
import Manage_Customer_Supplier_Package.*;
import RetailSalesHandling_Package.*;
import payrollPACKAGE.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Teshan Chathushka
 */
public class Inventory_Admin extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String si;
    

    /**
     * Creates new form Test2
     */
    int xMouse;//xMouse Global
    int yMouse;//yMouse Global
    int timeRun=0;
    public Inventory_Admin() {
        
        initComponents();
        setIcon();
        setLocationRelativeTo(null);
        con = DatabaseConn.connect();
        TableLoadRoshli1();
       // this.setLocationRelativeTo(null);

        
        setHide();
        setTime();
        new Thread(){
            public void run(){
                while(timeRun==0)
                {
                    Calendar cal = new GregorianCalendar();
                    
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int am_pm = cal.get(Calendar.AM_PM);
                    
                    String DayNight="";
                    if(am_pm==1){
                        DayNight="PM";
                    }
                    else{
                        DayNight="AM";
                    }
                    String time=hour+":"+min/*+":"+sec*/;
                    String day_night = DayNight;
                    Clock.setText(time);
                    Am_Pm.setText(day_night);
                }
            }
        }.start();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
                 String date=sdf.format(new Date());
                 dateLable.setText(date);
        
        FillComboRoshli();
        //checkoutofStock();
        
        
        
        
    }
    
    public void TableLoadRoshli1()
    {
        try {
            String sql = "SELECT CatCode As 'Category Code', Descrip As 'Description', ReorderLevel As 'Reorder Level',ReorderQty As 'Reorder Quantity',BufferStock As 'Buffer Stock' FROM category";
            pst = con.prepareStatement(sql);
            rs  = pst.executeQuery();
            Categorytbl.setModel(DbUtils.resultSetToTableModel(rs));
            //System.out.println(sql);
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
    
    }
    
    private void FillComboRoshli()
    {
        try {
            String sql ="SELECT * FROM category";
            pst = con.prepareStatement(sql);
            rs  = pst.executeQuery();
            
            while(rs.next())
            {
                String name = rs.getString("CatCode");
                jComboBox1.addItem(name);
            
            
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
    
    
    }
    
    
    private void FillCombo2Roshli()
    {
        try {
            String sql ="SELECT * FROM category";
            pst = con.prepareStatement(sql);
            rs  = pst.executeQuery();
            
            while(rs.next())
            {
                String name = rs.getString("CatCode");
                ItemCatFieldUpde.addItem(name);
            
            
            }
            
        } catch (Exception e) {
            System.out.println(e);
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

        SubPanel = new javax.swing.JPanel();
        newHome = new javax.swing.JLabel();
        Search = new javax.swing.JLabel();
        UpDe = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        SubMenu = new javax.swing.JLabel();
        TitleBar = new javax.swing.JPanel();
        Minimize = new javax.swing.JLabel();
        Cancel = new javax.swing.JLabel();
        signOut_button = new javax.swing.JLabel();
        Uname_Separator = new javax.swing.JSeparator();
        Show_Uname = new javax.swing.JLabel();
        logUserImg = new javax.swing.JLabel();
        DetailPanal = new javax.swing.JPanel();
        newHome_txt = new javax.swing.JLabel();
        Search_txt = new javax.swing.JLabel();
        UpDe_txt = new javax.swing.JLabel();
        Category_txt = new javax.swing.JLabel();
        Anime_sub = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        NewHome_panel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jsp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        SupPriField = new javax.swing.JTextField();
        SupDiscField = new javax.swing.JTextField();
        L1Field = new javax.swing.JTextField();
        L3Field = new javax.swing.JTextField();
        L2Field = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ExtDescField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ItemField = new javax.swing.JTextField();
        DescriptField = new javax.swing.JTextField();
        SerialNoField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ManufactField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SellPriField = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        PurchUnitField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        BinnIDField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        WarenPField1 = new javax.swing.JTextField();
        Search_panel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        PNameField = new javax.swing.JTextField();
        PIDField = new javax.swing.JTextField();
        PCatGoryField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchTable = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        UpDe_panel = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        SpPritFieldUpde = new javax.swing.JTextField();
        SupDiscFieldUpDe = new javax.swing.JTextField();
        CusDicL1FieldUpDe = new javax.swing.JTextField();
        CusDicL3FieldUpDe = new javax.swing.JTextField();
        CusDicL2FieldUpDe = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        ExtDescFieldUpDe = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        iemCodeFieldUpde = new javax.swing.JTextField();
        DescFieldUpde = new javax.swing.JTextField();
        MnifactFieldUpde = new javax.swing.JTextField();
        SiraNoFieldUpde = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        SellPriFieldUpde = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        BinIDFieldUpde = new javax.swing.JTextField();
        PurchUniFieldUpde = new javax.swing.JTextField();
        ItemCatFieldUpde = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        CatLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        uWarrenfield = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        Category_panel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        discB = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Categorytbl = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        RorderQantField2 = new javax.swing.JTextField();
        RorderLField2 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        BufffStokField2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        catcodeB = new javax.swing.JTextField();
        AddMore_panel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        BuyItCodeField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        BuyItCatField2 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
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

        newHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Add-32.png"))); // NOI18N
        newHome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                newHomeMouseMoved(evt);
            }
        });
        newHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newHomeMouseExited(evt);
            }
        });

        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Attendance-32 (1).png"))); // NOI18N
        Search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SearchMouseMoved(evt);
            }
        });
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchMouseExited(evt);
            }
        });

        UpDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Details-32.png"))); // NOI18N
        UpDe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpDeMouseMoved(evt);
            }
        });
        UpDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpDeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpDeMouseExited(evt);
            }
        });

        Category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Check File-32.png"))); // NOI18N
        Category.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CategoryMouseMoved(evt);
            }
        });
        Category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CategoryMouseExited(evt);
            }
        });

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

        SubMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Menu-32 (1).png"))); // NOI18N
        SubMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SubMenuMouseMoved(evt);
            }
        });
        SubMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubMenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SubMenuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SubPanelLayout = new javax.swing.GroupLayout(SubPanel);
        SubPanel.setLayout(SubPanelLayout);
        SubPanelLayout.setHorizontalGroup(
            SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Home)
                    .addComponent(SubMenu)
                    .addComponent(newHome)
                    .addComponent(Search)
                    .addComponent(UpDe)
                    .addComponent(Category)))
        );
        SubPanelLayout.setVerticalGroup(
            SubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(Home)
                .addGap(81, 81, 81)
                .addComponent(SubMenu)
                .addGap(31, 31, 31)
                .addComponent(newHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Search)
                .addGap(28, 28, 28)
                .addComponent(UpDe)
                .addGap(32, 32, 32)
                .addComponent(Category)
                .addGap(277, 277, 277))
        );

        getContentPane().add(SubPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 50, 680));

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
        Minimize.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MinimizeMouseMoved(evt);
            }
        });
        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeMouseExited(evt);
            }
        });
        TitleBar.add(Minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, -1, 30));

        Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Cancel-32.png"))); // NOI18N
        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CancelMouseMoved(evt);
            }
        });
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelMouseExited(evt);
            }
        });
        TitleBar.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, -1, 30));

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
        TitleBar.add(Uname_Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 70, 10));

        Show_Uname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Show_Uname.setText("Admin");
        Show_Uname.setToolTipText("User Type");
        TitleBar.add(Show_Uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 40));

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

        getContentPane().add(TitleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1110, -1));

        DetailPanal.setBackground(new java.awt.Color(204, 204, 255));
        DetailPanal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newHome_txt.setBackground(new java.awt.Color(37, 4, 70));
        newHome_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        newHome_txt.setForeground(new java.awt.Color(255, 255, 255));
        newHome_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newHome_txt.setText("Add Item");
        newHome_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                newHome_txtMouseMoved(evt);
            }
        });
        newHome_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newHome_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newHome_txtMouseExited(evt);
            }
        });
        DetailPanal.add(newHome_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 40, 190, 40));

        Search_txt.setBackground(new java.awt.Color(37, 4, 70));
        Search_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        Search_txt.setForeground(new java.awt.Color(255, 255, 255));
        Search_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Search_txt.setText("Search Item");
        Search_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Search_txtMouseMoved(evt);
            }
        });
        Search_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Search_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Search_txtMouseExited(evt);
            }
        });
        DetailPanal.add(Search_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 100, 190, 40));

        UpDe_txt.setBackground(new java.awt.Color(37, 4, 70));
        UpDe_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        UpDe_txt.setForeground(new java.awt.Color(255, 255, 255));
        UpDe_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UpDe_txt.setText("Update & Delete Items");
        UpDe_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpDe_txtMouseMoved(evt);
            }
        });
        UpDe_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpDe_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpDe_txtMouseExited(evt);
            }
        });
        DetailPanal.add(UpDe_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 160, 190, 40));

        Category_txt.setBackground(new java.awt.Color(37, 4, 70));
        Category_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        Category_txt.setForeground(new java.awt.Color(255, 255, 255));
        Category_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Category_txt.setText("Item Categories");
        Category_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Category_txtMouseMoved(evt);
            }
        });
        Category_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Category_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Category_txtMouseExited(evt);
            }
        });
        DetailPanal.add(Category_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 220, 190, 40));

        Anime_sub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sb menu.png"))); // NOI18N
        DetailPanal.add(Anime_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 0, 190, 330));

        NewHome_panel.setPreferredSize(new java.awt.Dimension(1110, 520));

        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Image");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jsp.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jsp, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("Discount Levels");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setText("Supplier Price");

        jLabel18.setText("Level 1");

        jLabel19.setText("Customer Discounts");

        jLabel20.setText("Level 2");

        jLabel21.setText("Level 3");

        SupPriField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupPriFieldActionPerformed(evt);
            }
        });

        SupDiscField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupDiscFieldActionPerformed(evt);
            }
        });

        L1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L1FieldActionPerformed(evt);
            }
        });

        L3Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L3FieldActionPerformed(evt);
            }
        });

        L2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L2FieldActionPerformed(evt);
            }
        });

        jLabel22.setText("Supplier Discount  ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20)
                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(L2Field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(L1Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SupDiscField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SupPriField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L3Field)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SupPriField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SupDiscField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jLabel4.setText("Extended Description");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ExtDescField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtDescFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("General");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Item Code");

        jLabel6.setText("Item Catagory");

        jLabel7.setText("Serial Number");

        jLabel8.setText("Discription");

        ItemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemFieldActionPerformed(evt);
            }
        });

        DescriptField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptFieldActionPerformed(evt);
            }
        });

        SerialNoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerialNoFieldActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Mnufacture  Name");

        ManufactField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManufactFieldActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Selling Price");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Bin ID");

        PurchUnitField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchUnitFieldActionPerformed(evt);
            }
        });

        jLabel16.setText("Purchasing Unit");

        BinnIDField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BinnIDField1ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Scan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(ItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(SerialNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(79, 79, 79)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DescriptField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ManufactField, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(SellPriField, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(BinnIDField1)
                    .addComponent(PurchUnitField))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ManufactField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SerialNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SellPriField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DescriptField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PurchUnitField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BinnIDField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jButton2.setText("Generate Barcode");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel38.setText("Warenty Period");

        WarenPField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WarenPField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewHome_panelLayout = new javax.swing.GroupLayout(NewHome_panel);
        NewHome_panel.setLayout(NewHome_panelLayout);
        NewHome_panelLayout.setHorizontalGroup(
            NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewHome_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewHome_panelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(508, 508, 508)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NewHome_panelLayout.createSequentialGroup()
                        .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(NewHome_panelLayout.createSequentialGroup()
                                .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ExtDescField, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(WarenPField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(30, 30, 30)
                        .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewHome_panelLayout.createSequentialGroup()
                        .addGap(566, 566, 566)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addGap(75, 75, 75)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        NewHome_panelLayout.setVerticalGroup(
            NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewHome_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewHome_panelLayout.createSequentialGroup()
                        .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NewHome_panelLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113)
                        .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(NewHome_panelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(NewHome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExtDescField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WarenPField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Search_panel.setPreferredSize(new java.awt.Dimension(1110, 520));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setText("Product ID");

        jLabel25.setText("Serial  Number");

        jLabel26.setText("Product Category");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Scan");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PCatGoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCatGoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel27.setText("Search Product");

        SearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Serial Number", "Description", "Manufacturer name", "Selling Price", "Bin ID", "Purchase Unit", "Image", "Supplier Price", "Supplier Discount", "Customer Discount 1", "Customer Discount 2", "Customer Discount 3", "Extended Description", "Category Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SearchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SearchTable);

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Search_panelLayout = new javax.swing.GroupLayout(Search_panel);
        Search_panel.setLayout(Search_panelLayout);
        Search_panelLayout.setHorizontalGroup(
            Search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Search_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(Search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Search_panelLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        Search_panelLayout.setVerticalGroup(
            Search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Search_panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        UpDe_panel.setPreferredSize(new java.awt.Dimension(1110, 520));

        jLabel28.setText("Discount Levels");

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setText("Supplier Price");

        jLabel30.setText("Level 1");

        jLabel31.setText("Customer Discounts");

        jLabel32.setText("Level 2");

        jLabel33.setText("Level 3");

        SpPritFieldUpde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpPritFieldUpdeActionPerformed(evt);
            }
        });

        SupDiscFieldUpDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupDiscFieldUpDeActionPerformed(evt);
            }
        });

        CusDicL1FieldUpDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusDicL1FieldUpDeActionPerformed(evt);
            }
        });

        CusDicL3FieldUpDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusDicL3FieldUpDeActionPerformed(evt);
            }
        });

        CusDicL2FieldUpDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusDicL2FieldUpDeActionPerformed(evt);
            }
        });

        jLabel34.setText("Supplier Discount  ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32)
                                .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CusDicL2FieldUpDe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(CusDicL1FieldUpDe, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SupDiscFieldUpDe, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SpPritFieldUpde, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CusDicL3FieldUpDe)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel31)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpPritFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SupDiscFieldUpDe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CusDicL1FieldUpDe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CusDicL2FieldUpDe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CusDicL3FieldUpDe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jLabel35.setText("Extended Description");

        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        ExtDescFieldUpDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtDescFieldUpDeActionPerformed(evt);
            }
        });

        jButton8.setText("Browse");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel42.setText("General");

        jLabel43.setText("Image");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setText("Item Code");

        jLabel45.setText("Item Catagory");

        jLabel46.setText("Serial Number");

        jLabel47.setText("Discription");

        iemCodeFieldUpde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iemCodeFieldUpdeActionPerformed(evt);
            }
        });

        DescFieldUpde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescFieldUpdeActionPerformed(evt);
            }
        });

        MnifactFieldUpde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnifactFieldUpdeActionPerformed(evt);
            }
        });

        SiraNoFieldUpde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiraNoFieldUpdeActionPerformed(evt);
            }
        });

        jLabel48.setText("Mnufacture  Name");

        jLabel49.setText("Selling Price");

        jLabel23.setText("Bin Id");

        jLabel36.setText("Purchasing Unit");

        BinIDFieldUpde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BinIDFieldUpdeActionPerformed(evt);
            }
        });

        PurchUniFieldUpde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchUniFieldUpdeActionPerformed(evt);
            }
        });

        ItemCatFieldUpde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Scan");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(iemCodeFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(SiraNoFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MnifactFieldUpde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SellPriFieldUpde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PurchUniFieldUpde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DescFieldUpde, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(ItemCatFieldUpde, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BinIDFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iemCodeFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MnifactFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SiraNoFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SellPriFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BinIDFieldUpde)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(CatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ItemCatFieldUpde)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DescFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PurchUniFieldUpde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        uWarrenfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWarrenfieldActionPerformed(evt);
            }
        });

        jLabel39.setText("Warranty Period");

        javax.swing.GroupLayout UpDe_panelLayout = new javax.swing.GroupLayout(UpDe_panel);
        UpDe_panel.setLayout(UpDe_panelLayout);
        UpDe_panelLayout.setHorizontalGroup(
            UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpDe_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpDe_panelLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8))
                        .addGap(30, 30, 30)
                        .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UpDe_panelLayout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(508, 508, 508)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpDe_panelLayout.createSequentialGroup()
                        .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ExtDescFieldUpDe, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpDe_panelLayout.createSequentialGroup()
                                .addComponent(uWarrenfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        UpDe_panelLayout.setVerticalGroup(
            UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpDe_panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpDe_panelLayout.createSequentialGroup()
                        .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpDe_panelLayout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(UpDe_panelLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpDe_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ExtDescFieldUpDe, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(uWarrenfield, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))))
        );

        Category_panel3.setPreferredSize(new java.awt.Dimension(1110, 520));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel52.setText("Description");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(discB, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discB, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Categorytbl.setModel(new javax.swing.table.DefaultTableModel(
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
        Categorytbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategorytblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Categorytbl);

        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("update");
        jButton11.setActionCommand("Update");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Delete");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel54.setText("Re-Order Level");

        jLabel55.setText("Reorder Quantity");

        RorderQantField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RorderQantField2ActionPerformed(evt);
            }
        });

        RorderLField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RorderLField2ActionPerformed(evt);
            }
        });

        jLabel56.setText("Buffer Stock");

        BufffStokField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BufffStokField2ActionPerformed(evt);
            }
        });

        jLabel51.setText("Category code");

        catcodeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catcodeBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(catcodeB, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RorderQantField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RorderLField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BufffStokField2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 131, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(catcodeB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RorderLField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RorderQantField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BufffStokField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Category_panel3Layout = new javax.swing.GroupLayout(Category_panel3);
        Category_panel3.setLayout(Category_panel3Layout);
        Category_panel3Layout.setHorizontalGroup(
            Category_panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Category_panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Category_panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Category_panel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12))
                    .addGroup(Category_panel3Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        Category_panel3Layout.setVerticalGroup(
            Category_panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Category_panel3Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(Category_panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(Category_panel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Category_panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10)
                            .addComponent(jButton11)
                            .addComponent(jButton12)))
                    .addGroup(Category_panel3Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        AddMore_panel5.setPreferredSize(new java.awt.Dimension(1110, 520));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setText("Item Code");

        jLabel11.setText("Item Category");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BuyItCodeField1)
                    .addComponent(BuyItCatField2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuyItCodeField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BuyItCatField2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jButton14.setText("Buy");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddMore_panel5Layout = new javax.swing.GroupLayout(AddMore_panel5);
        AddMore_panel5.setLayout(AddMore_panel5Layout);
        AddMore_panel5Layout.setHorizontalGroup(
            AddMore_panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMore_panel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(AddMore_panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddMore_panel5Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton14)))
                .addContainerGap(523, Short.MAX_VALUE))
        );
        AddMore_panel5Layout.setVerticalGroup(
            AddMore_panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMore_panel5Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton14)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(NewHome_panel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Search_panel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(UpDe_panel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Category_panel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(AddMore_panel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(NewHome_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Search_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(UpDe_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Category_panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AddMore_panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(NewHome_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Search_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(UpDe_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Category_panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AddMore_panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        DetailPanal.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 520));

        getContentPane().add(DetailPanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 1110, 530));

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
        TimeLine.add(dateLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(878, 64, 212, 38));

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
        
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_HomeMouseMoved

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_HomeMouseExited

    private void SubMenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubMenuMouseMoved
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_SubMenuMouseMoved

    private void SubMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubMenuMouseExited
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_SubMenuMouseExited

    private void newHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newHomeMouseMoved
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_newHomeMouseMoved

    private void newHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newHomeMouseExited
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_newHomeMouseExited

    private void SearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseMoved
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_SearchMouseMoved

    private void SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseExited
         Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
         Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_SearchMouseExited

    private void UpDeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpDeMouseMoved
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,7
        
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_UpDeMouseMoved

    private void UpDeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpDeMouseExited
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_UpDeMouseExited

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
        AddRemove1.jLabelXRight(-190, 0, 10, 5, newHome_txt);
        // <<<----------
        AnimationClass AddRemove2 = new AnimationClass();
        AddRemove2.jLabelXLeft(0, -190, 10, 5, newHome_txt);
        //---------------------------------------------
        
        //  --------->>>
        AnimationClass Attendance1 = new AnimationClass();
        Attendance1.jLabelXRight(-190, 0, 10, 5, Search_txt);
        // <<<----------
        AnimationClass Attendance2 = new AnimationClass();
        Attendance2.jLabelXLeft(0, -190, 10, 5, Search_txt);
        //---------------------------------------------
        
        //  --------->>>
        AnimationClass EDetails1 = new AnimationClass();
        EDetails1.jLabelXRight(-190, 0, 10, 5, UpDe_txt);
        // <<<----------
        AnimationClass EDetails2 = new AnimationClass();
        EDetails2.jLabelXLeft(0, -190, 10, 5, UpDe_txt);
        //---------------------------------------------
        
        //  --------->>>
        AnimationClass Request1 = new AnimationClass();
        Request1.jLabelXRight(-190, 0, 10, 5, Category_txt);
        // <<<----------
        AnimationClass Request2 = new AnimationClass();
        Request2.jLabelXLeft(0, -190, 10, 5, Category_txt);
        //---------------------------------------------
        
        //  --------->>>
        AnimationClass Report1 = new AnimationClass();
//        Report1.jLabelXRight(-190, 0, 10, 5, Report_txt);
        // <<<----------
        AnimationClass Report2 = new AnimationClass();
//        Report2.jLabelXLeft(0, -190, 10, 5, Report_txt);
        //---------------------------------------------
    }//GEN-LAST:event_SubMenuMouseClicked

    private void newHome_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newHome_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
    }//GEN-LAST:event_newHome_txtMouseMoved

    private void newHome_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newHome_txtMouseExited
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_newHome_txtMouseExited

    private void Search_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_Search_txtMouseMoved

    private void Search_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_txtMouseExited
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Search_txtMouseExited

    private void UpDe_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpDe_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_UpDe_txtMouseMoved

    private void UpDe_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpDe_txtMouseExited
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_UpDe_txtMouseExited

    private void newHome_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newHome_txtMouseClicked
       NewHome_panel.setVisible(true);
       Search_panel.setVisible(false);  
       Category_panel3.setVisible(false);
       UpDe_panel.setVisible(false);
       AddMore_panel5.setVisible(false);
       //AddMore_panel6.setVisible(false);
//        Report_panel.setVisible(false);
        
        
        
    }//GEN-LAST:event_newHome_txtMouseClicked

    private void newHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newHomeMouseClicked
        NewHome_panel.setVisible(true);
        Search_panel.setVisible(false);
        Category_panel3.setVisible(false);
        UpDe_panel.setVisible(false);
        AddMore_panel5.setVisible(false);
        //AddMore_panel6.setVisible(false);
        
        
    }//GEN-LAST:event_newHomeMouseClicked

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        Search_panel.setVisible(true);
        NewHome_panel.setVisible(false);
        Category_panel3.setVisible(false);
        UpDe_panel.setVisible(false);
        AddMore_panel5.setVisible(false);
        //AddMore_panel6.setVisible(false);
        
        
    }//GEN-LAST:event_SearchMouseClicked

    private void UpDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpDeMouseClicked
          UpDe_panel.setVisible(true);
          NewHome_panel.setVisible(false);
          Search_panel.setVisible(false);
          Category_panel3.setVisible(false);
          AddMore_panel5.setVisible(false);
          //AddMore_panel6.setVisible(false);
        
        
    }//GEN-LAST:event_UpDeMouseClicked

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
//        Add_remove_panel.setVisible(false);
//        Attend_panal.setVisible(false);
//        Emp_detail_panel.setVisible(false);
//        Request_panel.setVisible(false);
//        Report_panel.setVisible(false);
    }//GEN-LAST:event_logoMouseClicked

    private void Search_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_txtMouseClicked
          Search_panel.setVisible(true);
          NewHome_panel.setVisible(false);
          Category_panel3.setVisible(false);
          UpDe_panel.setVisible(false);
          AddMore_panel5.setVisible(false);
          //AddMore_panel6.setVisible(false);
        
        
    }//GEN-LAST:event_Search_txtMouseClicked

    private void UpDe_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpDe_txtMouseClicked
          UpDe_panel.setVisible(true);
          NewHome_panel.setVisible(false);
          Search_panel.setVisible(false);
          Category_panel3.setVisible(false);
          AddMore_panel5.setVisible(false);
          //AddMore_panel6.setVisible(false);
        
        
    }//GEN-LAST:event_UpDe_txtMouseClicked

    private void Category_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Category_txtMouseExited
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Category_txtMouseExited

    private void Category_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Category_txtMouseClicked
           Category_panel3.setVisible(true);
           NewHome_panel.setVisible(false);
           Search_panel.setVisible(false);
           UpDe_panel.setVisible(false);
           AddMore_panel5.setVisible(false);
           //AddMore_panel6.setVisible(false);

    }//GEN-LAST:event_Category_txtMouseClicked

    private void Category_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Category_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));

        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70

        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_Category_txtMouseMoved

    private void CategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryMouseExited
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_CategoryMouseExited

    private void CategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryMouseClicked
         Category_panel3.setVisible(true);
         NewHome_panel.setVisible(false);
         Search_panel.setVisible(false);
         UpDe_panel.setVisible(false);
         AddMore_panel5.setVisible(false);
         //AddMore_panel6.setVisible(false);

    }//GEN-LAST:event_CategoryMouseClicked

    private void CategoryMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryMouseMoved
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Category_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70

        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        newHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));

        newHome_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        Search_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
        UpDe_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
//        Report_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
    }//GEN-LAST:event_CategoryMouseMoved

    private void newHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newHomeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_newHomeMouseEntered

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
       int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Do you want to go 'Home Page'", "Exit",dialog);
        if(result == 0)
        {
            AdminHome home = new AdminHome();//venas karanna main home eke name ekata
            home.setVisible(true);
            this.dispose();
        }
//         TestHome home = new TestHome();
//         home.setVisible(true);
//         this.dispose();
    }//GEN-LAST:event_HomeMouseClicked

    //JLabel jlab = new JLabel();
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image","jpg");
        chooser.addChoosableFileFilter(filter);
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String img_path= file.getAbsolutePath();
        jsp.setIcon(ResizeImage(img_path));
        si = img_path;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void SupPriFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupPriFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupPriFieldActionPerformed

    private void SupDiscFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupDiscFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupDiscFieldActionPerformed

    private void L1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L1FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L1FieldActionPerformed

    private void L3FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L3FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L3FieldActionPerformed

    private void L2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L2FieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if((ItemField.getText().trim().isEmpty())||
           (SerialNoField.getText()).trim().isEmpty()||
           (DescriptField.getText()).trim().isEmpty()||
           (ManufactField.getText()).trim().isEmpty()||
           (SellPriField.getText()).trim().isEmpty()||
           (BinnIDField1.getText()).trim().isEmpty()||
           (PurchUnitField.getText()).trim().isEmpty()||
           (SupPriField.getText()).trim().isEmpty()||
           (ExtDescField.getText()).trim().isEmpty()||
           (SupDiscField.getText()).trim().isEmpty()||
           (L1Field.getText()).trim().isEmpty()||
           (L2Field.getText()).trim().isEmpty()||
           (L3Field.getText()).trim().isEmpty()||
           (WarenPField1.getText()).trim().isEmpty()
                
            ){
            String fill="Fill in all the fields to continue";
            JOptionPane.showMessageDialog(null,fill);

        }
        else{
            if(WarenPField1.getText().matches("[0-9]*\\.?[0-9]+"))
            {
                if(jComboBox1.getSelectedItem() != "Select Category")
                {
                    if (SellPriField.getText().matches("[0-9]*\\.?[0-9]+"))
                    {
                        if(SupPriField.getText().matches("[0-9]*\\.?[0-9]+")){

                            if(SupDiscField.getText().matches("[0-9]*\\.?[0-9]+")){

                                if(L1Field.getText().matches("[0-9]*\\.?[0-9]+")){

                                    if(L2Field.getText().matches("[0-9]*\\.?[0-9]+")){

                                        if(L3Field.getText().matches("[0-9]*\\.?[0-9]+")){
                                                String ItmCode = ItemField.getText();
                                                String SriaNo = SerialNoField.getText();
                                                String Descript = DescriptField.getText();
                                                String ManuFactName = ManufactField.getText();
                                                String SellPri = SellPriField.getText();
                                                Float nSellPri = Float.parseFloat(SellPri);
                                                String BinIIId = BinnIDField1.getText();
                                                String PurchaseUni = PurchUnitField.getText();
                                                String ItemCat = jComboBox1.getSelectedItem().toString();

                                                String extDescrip = ExtDescField.getText();
                                                String supPri = SupPriField.getText();
                                                Float nsupPri = Float.parseFloat(supPri);
                                                String supDisc = SupDiscField.getText();
                                                Float nsupDisc = Float.parseFloat(supDisc);

                                                String custDiskL1 = L1Field.getText();
                                                String custDiskL2 = L2Field.getText();
                                                String custDiskL3 = L3Field.getText();
                                                Float ncustDiskL1 = Float.parseFloat(custDiskL1);
                                                Float ncustDiskL2 = Float.parseFloat(custDiskL2);
                                                Float ncustDiskL3 = Float.parseFloat(custDiskL3);
                                                String waren = WarenPField1.getText();
                                                int nwaren = Integer.parseInt(waren);

                                                try {
                                                      String q = "INSERT INTO item (ItemCode,SerialNo,Description,ManufactName,SellingPri,BinID,PurchUnit,Image,SuplierPri,SupDiscount,CusDiscL1,CusDickL2,CusDiskL3,ExtDescription,warranty_period,CatCode) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                                        pst = con.prepareStatement(q);
                                                        InputStream is = new FileInputStream(new File(si));
                                                        pst.setString(1,ItmCode );
                                                        pst.setString(2,SriaNo);
                                                        pst.setString(3,Descript);
                                                        pst.setString(4,ManuFactName);
                                                        pst.setFloat(5,nSellPri);
                                                        pst.setString(6,BinIIId);
                                                        pst.setString(7, PurchaseUni);
                                                        pst.setBlob(8,is);
                                                        pst.setFloat(9,nsupPri );
                                                        pst.setFloat(10,nsupDisc );
                                                        pst.setFloat(11,ncustDiskL1 );
                                                        pst.setFloat(12,ncustDiskL2 );
                                                        pst.setFloat(13,ncustDiskL3 );
                                                        pst.setString(14,extDescrip );
                                                        pst.setInt(15, nwaren);
                                                        pst.setString(16,ItemCat );
                                                        pst.executeUpdate();
                                                        String s = "Add Sucessful";
                                                        JOptionPane.showMessageDialog(null, s);
                                                        TableLoadRoshli1();

                                                } catch (Exception e) {
    //                                                System.out.println(e);
    //                                                String excep = e.getMessage().toString();
    //                                               
    //                                                String error = "com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry";
    //                                                if(excep.equalsIgnoreCase(error))
    //                                                {
    //                                                    JOptionPane.showMessageDialog(null,"Error! Item with same Item Code Exists");
    //                                                }
                                                    JOptionPane.showMessageDialog(null,e.getMessage() +"Add Unsucessful !");
                                                    //JOptionPane.showMessageDialog(null,"Add Unsucessful !");
                                                } 

                                                ItemField.setText("");
                                                SerialNoField.setText("");
                                                DescriptField.setText("");
                                                ManufactField.setText("");
                                                SellPriField.setText("");
                                                BinnIDField1.setText("");
                                                PurchUnitField.setText("");
                                                ExtDescField.setText("");
                                                SupPriField.setText("");
                                                SupDiscField.setText("");
                                                L1Field.setText("");
                                                L2Field.setText("");
                                                L3Field.setText("");
                                                WarenPField1.setText("");
                                                jsp.setIcon(null);



                                        }
                                        else{
                                        JOptionPane.showMessageDialog(null, "Enter Valid Customer Discount 3");

                                        }


                                    }
                                    else{
                                    JOptionPane.showMessageDialog(null, "Enter Valid Customer Discount 2");

                                    }


                                }
                                else{
                                JOptionPane.showMessageDialog(null, "Enter Valid Customer Discount 1");
                                }

                            }
                            else{
                            JOptionPane.showMessageDialog(null, "Enter Valid Suplier Discount");

                            }



                        }
                        else{
                        JOptionPane.showMessageDialog(null, "Enter Valid Supplier Price");
                        }


                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Enter Valid Selling Price");
                    }
                }
                else{
                   JOptionPane.showMessageDialog(null, "Enter Valid Category"); 
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter Valid Warranty Period");
            }
        }
//        try{
//               
//               pst = con.prepareStatement("insert into item(Image) values(?)");
//               InputStream is = new FileInputStream(new File(si));
//               
//               pst.setBlob(1,is);
//               pst.executeUpdate();
//               JOptionPane.showMessageDialog(null, "Data Inserted");
//           }catch(Exception ex){
//               ex.printStackTrace();
//           }
               
        
        
        
        
        //jsp.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ExtDescFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtDescFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExtDescFieldActionPerformed

    private void PurchUnitFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchUnitFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PurchUnitFieldActionPerformed

    private void ItemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemFieldActionPerformed

    private void DescriptFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptFieldActionPerformed

    private void SerialNoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerialNoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SerialNoFieldActionPerformed

    private void ManufactFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManufactFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManufactFieldActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String bcode = ItemField.getText();
        
        try {
            BarcodeDemo.GenerateBcode(bcode);
        } catch (Exception ex) {
            Logger.getLogger(Inventory_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        try {
//            String sql = "SELECT * FROM category";
//            pst = con.prepareStatement(sql);
//            rs  = pst.executeQuery();
//            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
//            //System.out.println(sql);
//            
//        } catch (Exception e) {
//            System.out.println(e);
//            
//        }
//        
        String PID = PIDField.getText();
        String pName = PNameField.getText();
        String pCategory = PCatGoryField.getText();
        
        try {
            String sql = "Select ItemCode AS 'Item Code', SerialNo AS 'Serial Number', Description, ManufactName As 'Manufacturer Name',SellingPri AS 'Selling Price', BinID, PurchUnit As 'Purchase Unit', Image, SuplierPri As 'Suplier Price', SupDiscount As 'Suplier Discount', CusDiscL1 As 'Custmer Discount 1', CusDickL2 As 'Customer Discount 2', CusDiskL3 AS 'Customer Discount 3', ExtDescription As 'Extended Description', warranty_period AS 'Warranty Period', CatCode As 'Category Code' From item where ItemCode LIKE '%"+PID+"%' AND SerialNo LIKE '%"+pName+"%' AND CatCode LIKE '%"+pCategory+"%'";
            pst = con.prepareStatement(sql);
            rs  = pst.executeQuery();
            
            SearchTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            int rows = SearchTable.getRowCount();
            System.out.println(rows);
            if(rows == 0)
            {
                JOptionPane.showMessageDialog(null, "No Results Found");
            }
            
            PIDField.setText("");
            PNameField.setText("");
            PCatGoryField.setText("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        JPasswordField pw=new JPasswordField(10);
       
        
        
        int y =JOptionPane.showConfirmDialog(null,pw,"Enter password",JOptionPane.OK_CANCEL_OPTION);
        //String adf=String(pw.getPassword());
        char[] pwwd = {'a','d','m','i','n'};
        char[] epass =pw.getPassword();
        System.out.println(y);
        if(y == 0)
        {
                            System.out.println("1 wade");
                           // System.out.println(adf);
            if(Arrays.equals(pwwd,epass))
            {
                System.out.println("2 wada");
            String ItemCd = iemCodeFieldUpde.getText();
            

            String Sql = "DELETE From item WHERE ItemCode = '"+ItemCd+"'";
            try {
                pst = con.prepareStatement(Sql);
                pst.execute();
                String s = "Delete Sucessful";
                JOptionPane.showMessageDialog(null, s);
                iemCodeFieldUpde.setText("");
                SiraNoFieldUpde.setText("");
                DescFieldUpde.setText("");
                MnifactFieldUpde.setText("");
                SellPriFieldUpde.setText("");
                BinIDFieldUpde.setText("");
                PurchUniFieldUpde.setText("");
                ExtDescFieldUpDe.setText("");
                SpPritFieldUpde.setText("");
                SupDiscFieldUpDe.setText("");
                CusDicL1FieldUpDe.setText("");
                CusDicL2FieldUpDe.setText("");
                CusDicL3FieldUpDe.setText("");
                uWarrenfield.setText("");
                jLabel50.setIcon(null);
                //CatLabel.setIcon(null);
            }
            catch (Exception e) {
                System.out.println(e);
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed
    }
    private void SpPritFieldUpdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpPritFieldUpdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SpPritFieldUpdeActionPerformed

    private void SupDiscFieldUpDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupDiscFieldUpDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupDiscFieldUpDeActionPerformed

    private void CusDicL1FieldUpDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusDicL1FieldUpDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusDicL1FieldUpDeActionPerformed

    private void CusDicL3FieldUpDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusDicL3FieldUpDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusDicL3FieldUpDeActionPerformed

    private void CusDicL2FieldUpDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusDicL2FieldUpDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusDicL2FieldUpDeActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
               String s1="Do you want to UPDATE";
               int x = JOptionPane.showConfirmDialog(null, s1);

        
        
        if(x == 0)
        {
            
            if((iemCodeFieldUpde.getText().trim().isEmpty())||
           (SiraNoFieldUpde.getText()).trim().isEmpty()||
           (DescFieldUpde.getText()).trim().isEmpty()||
           (MnifactFieldUpde.getText()).trim().isEmpty()||
           (SellPriFieldUpde.getText()).trim().isEmpty()||
           (BinIDFieldUpde.getText()).trim().isEmpty()||
           (PurchUniFieldUpde.getText()).trim().isEmpty()||
           (SpPritFieldUpde.getText()).trim().isEmpty()||
           (ExtDescFieldUpDe.getText()).trim().isEmpty()||
           (SupDiscFieldUpDe.getText()).trim().isEmpty()||
           (CusDicL1FieldUpDe.getText()).trim().isEmpty()||
           (CusDicL2FieldUpDe.getText()).trim().isEmpty()||
           (CusDicL3FieldUpDe.getText()).trim().isEmpty()||
           (uWarrenfield.getText()).trim().isEmpty()
                
           ){
            String fill="Fill in all the fields to continue";
            JOptionPane.showMessageDialog(null,fill);

        }
        else{
            if(uWarrenfield.getText().matches("[0-9]*\\.?[0-9]+"))
            {
                if(ItemCatFieldUpde.getSelectedItem() != "Select Category")
                {
                    if (SellPriFieldUpde.getText().matches("[0-9]*\\.?[0-9]+"))
                    {
                        if(SpPritFieldUpde.getText().matches("[0-9]*\\.?[0-9]+")){

                            if(SupDiscFieldUpDe.getText().matches("[0-9]*\\.?[0-9]+")){

                                if(CusDicL1FieldUpDe.getText().matches("[0-9]*\\.?[0-9]+")){

                                    if(CusDicL2FieldUpDe.getText().matches("[0-9]*\\.?[0-9]+")){

                                        if(CusDicL3FieldUpDe.getText().matches("[0-9]*\\.?[0-9]+")){
                                            if(si != null){
                                                    String ItmCodeU = iemCodeFieldUpde.getText();
                                                    String SriaNoU = SiraNoFieldUpde.getText();
                                                    String DescriptU = DescFieldUpde.getText();
                                                    String ManuFactNameU = MnifactFieldUpde.getText();
                                                    String SellPriU = SellPriFieldUpde.getText();
                                                    Float nSellPriU = Float.parseFloat(SellPriU);
                                                    String BinIIIdU = BinIDFieldUpde.getText();
                                                    String PurchaseUniU = PurchUniFieldUpde.getText();
                                                    String ItemCatU = ItemCatFieldUpde.getSelectedItem().toString();

                                                    String extDescripU = ExtDescFieldUpDe.getText();
                                                    String supPriU = SpPritFieldUpde.getText();
                                                    Float nsupPriU = Float.parseFloat(supPriU);
                                                    String supDiscU = SupDiscFieldUpDe.getText();
                                                    Float nsupDiscU = Float.parseFloat(supDiscU);

                                                    String custDiskL1U = CusDicL1FieldUpDe.getText();
                                                    String custDiskL2U = CusDicL2FieldUpDe.getText();
                                                    String custDiskL3U = CusDicL3FieldUpDe.getText();
                                                    Float ncustDiskL1U = Float.parseFloat(custDiskL1U);
                                                    Float ncustDiskL2U = Float.parseFloat(custDiskL2U);
                                                    Float ncustDiskL3U = Float.parseFloat(custDiskL3U);
                                                    String warenu = uWarrenfield.getText();
                                                    int nwarenu = Integer.parseInt(warenu);

                                                    try {
                                                        String qNew = "UPDATE item SET ItemCode = ?,SerialNo = ?,Description = ?,ManufactName = ?,SellingPri = ? ,BinID = ?,PurchUnit = ?,Image = ?,SuplierPri = ?,SupDiscount = ?,CusDiscL1 = ?,CusDickL2 = ?,CusDiskL3 = ?,ExtDescription = ?,warranty_period = ?,CatCode = ? Where ItemCode = ? ";
                                                        pst = con.prepareStatement(qNew);
                                                        InputStream is = new FileInputStream(new File(si));
                                                        pst.setString(1,ItmCodeU );
                                                        pst.setString(2,SriaNoU);
                                                        pst.setString(3,DescriptU);
                                                        pst.setString(4,ManuFactNameU);
                                                        pst.setFloat(5,nSellPriU);
                                                        pst.setString(6,BinIIIdU);
                                                        pst.setString(7, PurchaseUniU);
                                                        pst.setBlob(8,is);
                                                        pst.setFloat(9,nsupPriU );
                                                        pst.setFloat(10,nsupDiscU );
                                                        pst.setFloat(11,ncustDiskL1U );
                                                        pst.setFloat(12,ncustDiskL2U );
                                                        pst.setFloat(13,ncustDiskL3U );
                                                        pst.setString(14,extDescripU );
                                                        pst.setInt(15,nwarenu );
                                                        pst.setString(16,ItemCatU );
                                                        pst.setString(17,ItmCodeU );




                                                        pst.executeUpdate();

                                                        String s = "Update Sucessful";
                                                        JOptionPane.showMessageDialog(null, s);
                                                        iemCodeFieldUpde.setText("");
                                                        SiraNoFieldUpde.setText("");
                                                        DescFieldUpde.setText("");
                                                        MnifactFieldUpde.setText("");
                                                        SellPriFieldUpde.setText("");
                                                        BinIDFieldUpde.setText("");
                                                        PurchUniFieldUpde.setText("");
                                                        ExtDescFieldUpDe.setText("");
                                                        SpPritFieldUpde.setText("");
                                                        SupDiscFieldUpDe.setText("");
                                                        CusDicL1FieldUpDe.setText("");
                                                        CusDicL2FieldUpDe.setText("");
                                                        CusDicL3FieldUpDe.setText("");
                                                        uWarrenfield.setText("");
                                                        jLabel50.setIcon(null);
                                                        CatLabel.setIcon(null);
                                                        CatLabel.setText(null);
                                                        //TableLoad();

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                    String sn = "Update Unsucessful";
                                                    JOptionPane.showMessageDialog(null, sn);
                                                }
                                            


                                            }
                                            else
                                            {
                                               //JOptionPane.showMessageDialog(null, "Insert an Image");
                                                String ItmCodeU = iemCodeFieldUpde.getText();
                                                    String SriaNoU = SiraNoFieldUpde.getText();
                                                    String DescriptU = DescFieldUpde.getText();
                                                    String ManuFactNameU = MnifactFieldUpde.getText();
                                                    String SellPriU = SellPriFieldUpde.getText();
                                                    Float nSellPriU = Float.parseFloat(SellPriU);
                                                    String BinIIIdU = BinIDFieldUpde.getText();
                                                    String PurchaseUniU = PurchUniFieldUpde.getText();
                                                    String ItemCatU = ItemCatFieldUpde.getSelectedItem().toString();

                                                    String extDescripU = ExtDescFieldUpDe.getText();
                                                    String supPriU = SpPritFieldUpde.getText();
                                                    Float nsupPriU = Float.parseFloat(supPriU);
                                                    String supDiscU = SupDiscFieldUpDe.getText();
                                                    Float nsupDiscU = Float.parseFloat(supDiscU);

                                                    String custDiskL1U = CusDicL1FieldUpDe.getText();
                                                    String custDiskL2U = CusDicL2FieldUpDe.getText();
                                                    String custDiskL3U = CusDicL3FieldUpDe.getText();
                                                    Float ncustDiskL1U = Float.parseFloat(custDiskL1U);
                                                    Float ncustDiskL2U = Float.parseFloat(custDiskL2U);
                                                    Float ncustDiskL3U = Float.parseFloat(custDiskL3U);
                                                    String warenu = uWarrenfield.getText();
                                                    int nwarenu = Integer.parseInt(warenu);

                                                    try {
                                                        String qNew = "UPDATE item SET ItemCode = ?,SerialNo = ?,Description = ?,ManufactName = ?,SellingPri = ? ,BinID = ?,PurchUnit = ?,SuplierPri = ?,SupDiscount = ?,CusDiscL1 = ?,CusDickL2 = ?,CusDiskL3 = ?,ExtDescription = ?,warranty_period = ?,CatCode = ? Where ItemCode = ? ";
                                                        pst = con.prepareStatement(qNew);
                                                       // InputStream is = new FileInputStream(new File(si));
                                                        pst.setString(1,ItmCodeU );
                                                        pst.setString(2,SriaNoU);
                                                        pst.setString(3,DescriptU);
                                                        pst.setString(4,ManuFactNameU);
                                                        pst.setFloat(5,nSellPriU);
                                                        pst.setString(6,BinIIIdU);
                                                        pst.setString(7, PurchaseUniU);
                                                        //pst.setBlob(8,is);
                                                        pst.setFloat(8,nsupPriU );
                                                        pst.setFloat(9,nsupDiscU );
                                                        pst.setFloat(10,ncustDiskL1U );
                                                        pst.setFloat(11,ncustDiskL2U );
                                                        pst.setFloat(12,ncustDiskL3U );
                                                        pst.setString(13,extDescripU );
                                                        pst.setInt(14,nwarenu );
                                                        pst.setString(15,ItemCatU );
                                                        pst.setString(16,ItmCodeU );




                                                        pst.executeUpdate();

                                                        String s = "Update Sucessful";
                                                        JOptionPane.showMessageDialog(null, s);
                                                        iemCodeFieldUpde.setText("");
                                                        SiraNoFieldUpde.setText("");
                                                        DescFieldUpde.setText("");
                                                        MnifactFieldUpde.setText("");
                                                        SellPriFieldUpde.setText("");
                                                        BinIDFieldUpde.setText("");
                                                        PurchUniFieldUpde.setText("");
                                                        ExtDescFieldUpDe.setText("");
                                                        SpPritFieldUpde.setText("");
                                                        SupDiscFieldUpDe.setText("");
                                                        CusDicL1FieldUpDe.setText("");
                                                        CusDicL2FieldUpDe.setText("");
                                                        CusDicL3FieldUpDe.setText("");
                                                        uWarrenfield.setText("");
                                                        jLabel50.setIcon(null);
                                                        CatLabel.setIcon(null);
                                                        CatLabel.setText(null);
                                                        //TableLoad();

                                                } catch (Exception e) {
                                                    System.out.println(e);
                                                    String sn = "Update Unsucessful";
                                                    JOptionPane.showMessageDialog(null, sn);
                                                }
                                            }

                                        }
                                        else{
                                        JOptionPane.showMessageDialog(null, "Enter Valid Customer Discount 3");

                                        }


                                    }
                                    else{
                                    JOptionPane.showMessageDialog(null, "Enter Valid Customer Discount 2");

                                    }


                                }
                                else{
                                JOptionPane.showMessageDialog(null, "Enter Valid Customer Discount 1");
                                }

                            }
                            else{
                            JOptionPane.showMessageDialog(null, "Enter Valid Suplier Discount");

                            }



                        }
                        else{
                        JOptionPane.showMessageDialog(null, "Enter Valid Supplier Price");
                        }


                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Enter Valid Selling Price");
                    }
                }
                else
                {
                JOptionPane.showMessageDialog(null, "Enter Valid Category");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter Valid Warrenty Period");
            }
            }
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void ExtDescFieldUpDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtDescFieldUpDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExtDescFieldUpDeActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image","jpg");
        chooser.addChoosableFileFilter(filter);
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String img_path= file.getAbsolutePath();
        jLabel50.setIcon(ResizeImage(img_path));
        si = img_path;
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void iemCodeFieldUpdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iemCodeFieldUpdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iemCodeFieldUpdeActionPerformed

    private void DescFieldUpdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescFieldUpdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescFieldUpdeActionPerformed

    private void SiraNoFieldUpdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiraNoFieldUpdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SiraNoFieldUpdeActionPerformed

    private void MnifactFieldUpdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnifactFieldUpdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MnifactFieldUpdeActionPerformed

    private void catcodeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catcodeBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catcodeBActionPerformed

    private void CategorytblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategorytblMouseClicked
        int row = Categorytbl.getSelectedRow();
        String catId = Categorytbl.getValueAt(row, 0).toString();
        String Desc = Categorytbl.getValueAt(row, 1).toString();
        String ReoLevel = Categorytbl.getValueAt(row, 2).toString();
        String RoQtty = Categorytbl.getValueAt(row, 3).toString();
        String BfStock = Categorytbl.getValueAt(row, 4).toString();
        

        catcodeB.setText(catId);
        discB.setText(Desc);
        RorderLField2.setText(ReoLevel);
        RorderQantField2.setText(RoQtty);
        BufffStokField2.setText(BfStock);

    }//GEN-LAST:event_CategorytblMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if((catcodeB.getText().trim().isEmpty())||
                (discB.getText().trim().isEmpty())||
                (RorderLField2.getText().trim().isEmpty())||
                (RorderQantField2.getText().trim().isEmpty())||
                (BufffStokField2.getText().trim().isEmpty())
                ){
            String fill="Fill in all the fields to continue";
            JOptionPane.showMessageDialog(null,fill);

        }
        else{
            if(RorderLField2.getText().matches("[0-9]*")){
                
                if(RorderQantField2.getText().matches("[0-9]*")){
                    
                    if(BufffStokField2.getText().matches("[0-9]*")){
                        
                        String category = catcodeB.getText();
                        String description = discB.getText();
                        String R_order_L = RorderLField2.getText();
                        String R_Quantity = RorderQantField2.getText();
                        String B_Stock = BufffStokField2.getText();
                        int nR_order_L = Integer.parseInt(R_order_L);
                        int nR_Quantity = Integer.parseInt(R_Quantity);
                        int nB_Stock = Integer.parseInt(B_Stock);

                        try {
                            String q = "INSERT INTO category (CatCode, Descrip, ReorderLevel, ReorderQty, BufferStock) VALUES('"+ category +"','"+ description +"', '"+ nR_order_L +"','"+ nR_Quantity +"','"+ nB_Stock +"')";
                            pst = con.prepareStatement(q);
                            pst.execute();
                            String s = "Add Sucessful";
                            JOptionPane.showMessageDialog(null, s);
                            catcodeB.setText("");
                            discB.setText("");
                            RorderLField2.setText("");
                            RorderQantField2.setText("");
                            BufffStokField2.setText("");
                            TableLoadRoshli1();
                            FillComboRoshli();
                        } catch (Exception e) {
                            System.out.println(e);
                            JOptionPane.showMessageDialog(null,e.getMessage());
                        }
                    
                    
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Enter Valid Buffer Stock");
                    }
                }
                else{
                JOptionPane.showMessageDialog(null, "Enter Valid ReOrder Quantity");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter Valid ReOrder Level");
            }

            
            

        }
        

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to update");
        if(x == 0)
        {
            if((catcodeB.getText().trim().isEmpty())||
                (discB.getText().trim().isEmpty())||
                (RorderLField2.getText().trim().isEmpty())||
                (RorderQantField2.getText().trim().isEmpty())||
                (BufffStokField2.getText().trim().isEmpty())
                ){
            String fill="Fill in all the fields to continue";
            JOptionPane.showMessageDialog(null,fill);

        }
        else{
            if(RorderLField2.getText().matches("[0-9]*")){
                
                if(RorderQantField2.getText().matches("[0-9]*")){
                    
                    if(BufffStokField2.getText().matches("[0-9]*")){
                        
//                        String category = catcodeB.getText();
//                        String description = discB.getText();
//                        String R_order_L = RorderLField2.getText();
//                        String R_Quantity = RorderQantField2.getText();
//                        String B_Stock = BufffStokField2.getText();
//                        int nR_order_L = Integer.parseInt(R_order_L);
//                        int nR_Quantity = Integer.parseInt(R_Quantity);
//                        int nB_Stock = Integer.parseInt(B_Stock);

                        String catc = catcodeB.getText();
                        String des = discB.getText();
                        String RoLevel = RorderLField2.getText();
                        String RoQty = RorderQantField2.getText();
                        String bstock = BufffStokField2.getText();
                        Float nRoLevel = Float.parseFloat(RoLevel);
                        Float nRoQty = Float.parseFloat(RoQty);
                        Float nbstock = Float.parseFloat(bstock);


                        String Sql = "UPDATE category SET CatCode = '"+catc+"', Descrip = '"+des+"',ReorderLevel = '"+nRoLevel+"', ReorderQty ='"+nRoQty+"',BufferStock = '"+nbstock+"' WHERE CatCode = '"+catc+"'";
                        try {
                            pst = con.prepareStatement(Sql);
                            pst.execute();
                            String s = "Update Sucessful";
                            JOptionPane.showMessageDialog(null, s);

                            catcodeB.setText("");
                            discB.setText("");
                            RorderLField2.setText("");
                            RorderQantField2.setText("");
                            BufffStokField2.setText("");
                            
                            TableLoadRoshli1();
                            FillComboRoshli();




                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    
                    
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Enter Valid Buffer Stock");
                    }
                }
                else{
                JOptionPane.showMessageDialog(null, "Enter Valid ReOrder Quantity");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter Valid ReOrder Level");
            }
            

            
            

        }
            
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int y = JOptionPane.showConfirmDialog(null, "Do you want to DELETE");
        if(y == 0)
        {
            String catc = catcodeB.getText();
            String des = discB.getText();

            String Sql = "DELETE From category WHERE CatCode = '"+catc+"'";
            try {
                pst = con.prepareStatement(Sql);
                pst.execute();
                String s = "Delete Sucessful";
                JOptionPane.showMessageDialog(null, s);
                    catcodeB.setText("");
                    discB.setText("");
                    RorderLField2.setText("");
                    RorderQantField2.setText("");
                    BufffStokField2.setText("");
            }
            catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Delete Unsucessful");
            }

        }

        TableLoadRoshli1();
        FillComboRoshli();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void BinnIDField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BinnIDField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BinnIDField1ActionPerformed

    private void PurchUniFieldUpdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchUniFieldUpdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PurchUniFieldUpdeActionPerformed

    private void RorderQantField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RorderQantField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RorderQantField2ActionPerformed

    private void RorderLField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RorderLField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RorderLField2ActionPerformed

    private void BufffStokField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BufffStokField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BufffStokField2ActionPerformed

    private void SearchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchTableMouseClicked
       
        
        
        
        
        
        int row = SearchTable.getSelectedRow();

        String getItmCode = SearchTable.getValueAt(row, 0).toString();
        String getSriaNo = SearchTable.getValueAt(row, 1).toString();
        String getDescript = SearchTable.getValueAt(row, 2).toString();
        String getManuFactName = SearchTable.getValueAt(row, 3).toString();
        String getSellPri = SearchTable.getValueAt(row, 4).toString();
        //Float nSellPri = Float.parseFloat(SellPri);
        String getBinIIId = SearchTable.getValueAt(row, 5).toString();
        String getPurchaseUni = SearchTable.getValueAt(row, 6).toString();
        String getItemCat = SearchTable.getValueAt(row, 15).toString();
        
        String getextDescrip = SearchTable.getValueAt(row, 13).toString();
        String getsupPri = SearchTable.getValueAt(row, 8).toString();
        //Float supPri = Float.parseFloatgetValueAt(row, 9).toString();
        String getsupDisc = SearchTable.getValueAt(row, 9).toString();
        //Float nsupDisc = Float.parseFloat(supDisc);
        
        String getcustDiskL1 = SearchTable.getValueAt(row, 10).toString();
        String getcustDiskL2 = SearchTable.getValueAt(row, 11).toString();
        String getcustDiskL3 = SearchTable.getValueAt(row, 12).toString();
        String getWaran = SearchTable.getValueAt(row, 14).toString();
        
        
        
            try {
            String sql5 = "Select Image  From item where Itemcode = '"+getItmCode+"'";
            pst = con.prepareStatement(sql5);
            rs  = pst.executeQuery();
            
            if(rs.next()){
                    byte[] img = rs.getBytes("Image");
                    
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(jLabel50.getWidth(), jLabel50.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    jLabel50.setIcon(newImage);
                    
            }
        } catch (Exception e) {
        }
        
       // Float ncustDiskL1 = Float.parseFloat(custDiskL1);
       // Float ncustDiskL2 = Float.parseFloat(custDiskL2);
        //Float ncustDiskL3 = Float.parseFloat(custDiskL3);
        
        iemCodeFieldUpde.setText(getItmCode);
        SiraNoFieldUpde.setText(getSriaNo);
        CatLabel.setText(getItemCat);
        DescFieldUpde.setText(getDescript);
        MnifactFieldUpde.setText(getManuFactName);
        SellPriFieldUpde.setText(getSellPri);
        BinIDFieldUpde.setText(getBinIIId);
        PurchUniFieldUpde.setText(getPurchaseUni);
        SpPritFieldUpde.setText(getsupPri);
        SupDiscFieldUpDe.setText(getsupDisc);
        CusDicL1FieldUpDe.setText(getcustDiskL1);
        CusDicL2FieldUpDe.setText(getcustDiskL2);
        CusDicL3FieldUpDe.setText(getcustDiskL3);
        ExtDescFieldUpDe.setText(getextDescrip);
        uWarrenfield.setText(getWaran);
        String a = "Do you need to buy ?";
        int x = JOptionPane.showConfirmDialog(null, a);
        if(x==0)
        {  
//          AddMore_panel5.setVisible(true);
            
//          BuyItCodeField1.setText(getItmCode);
//          BuyItCatField2.setText(getItemCat);
            RetailSalesHandling_Admin Rsha = new RetailSalesHandling_Admin();
            Rsha.BuyItemCat.setText(getItemCat);
           Rsha.tbiid.setText(getItmCode);
           Rsha.tbup.setText(getSellPri);
           
          Rsha.setVisible(true);
          Rsha.Item_panel.setVisible(true);
          Search_panel.setVisible(false);
          Rsha.DiscountCombo.addItem(getcustDiskL1);
          Rsha.DiscountCombo.addItem(getcustDiskL2);
          Rsha.DiscountCombo.addItem(getcustDiskL3);
          Rsha.ItemId.setText(getItmCode);
          this.dispose();
        
        }
        else if(x == 1)
        {
            FillCombo2Roshli();
            UpDe_panel.setVisible(true);
            Search_panel.setVisible(false);
            
        
        }
       
       // System.out.println(getItemCat);
        
    }//GEN-LAST:event_SearchTableMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String itcode = BuyItCatField2.getText();
       
        
        try {
            
            String sql = "Select count(ItemCode) From item where CatCode = '"+itcode+"' ";
            pst = con.prepareStatement(sql);
            rs  = pst.executeQuery();
            while(rs.next())
           {
            String name = rs.getString("count(ItemCode)");
            //System.out.println(name);
            
            rs.close();
            pst.close();  
            
            String sql2 = "Select ReorderLevel From category where CatCode = '"+itcode+"'";
            pst = con.prepareStatement(sql2);
            rs  = pst.executeQuery();
            while(rs.next())
            {
                String name2 = rs.getString("ReorderLevel");
                //System.out.println(name2);
                
                int RLevel = Integer.parseInt(name2);
                int itemCount = Integer.parseInt(name);
                
                if(itemCount <= RLevel)
                {
                    JOptionPane.showMessageDialog(null, "'"+itcode +"' is running out of stock");
                
                }
                
            }
            
          }
            
            
            //int bfstoc = Integer.parseInt(name2);
           // int itemCount = Integer.parseInt(this.name);
            
            //System.out.println(bfstoc);
           // System.out.println(itemCount);
            
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void BinIDFieldUpdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BinIDFieldUpdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BinIDFieldUpdeActionPerformed

    private void signOut_buttonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOut_buttonMouseMoved
        signOut_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        logUserImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
        //Info.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
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

    private void logUserImgMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logUserImgMouseMoved
        logUserImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        signOut_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
      //  Info.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37,4,70)));
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

    private void WarenPField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WarenPField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WarenPField1ActionPerformed

    private void uWarrenfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWarrenfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uWarrenfieldActionPerformed

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
            java.util.logging.Logger.getLogger(Inventory_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory_Admin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddMore_panel5;
    private javax.swing.JLabel Am_Pm;
    private javax.swing.JLabel Anime_sub;
    private javax.swing.JTextField BinIDFieldUpde;
    private javax.swing.JTextField BinnIDField1;
    private javax.swing.JTextField BufffStokField2;
    private javax.swing.JTextField BuyItCatField2;
    private javax.swing.JTextField BuyItCodeField1;
    private javax.swing.JLabel Cancel;
    private javax.swing.JLabel CatLabel;
    private javax.swing.JLabel Category;
    private javax.swing.JPanel Category_panel3;
    private javax.swing.JLabel Category_txt;
    private javax.swing.JTable Categorytbl;
    private javax.swing.JLabel Clock;
    private javax.swing.JTextField CusDicL1FieldUpDe;
    private javax.swing.JTextField CusDicL2FieldUpDe;
    private javax.swing.JTextField CusDicL3FieldUpDe;
    private javax.swing.JTextField DescFieldUpde;
    private javax.swing.JTextField DescriptField;
    private javax.swing.JPanel DetailPanal;
    private javax.swing.JTextField ExtDescField;
    private javax.swing.JTextField ExtDescFieldUpDe;
    private javax.swing.JLabel Home;
    private javax.swing.JComboBox<String> ItemCatFieldUpde;
    private javax.swing.JTextField ItemField;
    private javax.swing.JTextField L1Field;
    private javax.swing.JTextField L2Field;
    private javax.swing.JTextField L3Field;
    private javax.swing.JTextField ManufactField;
    private javax.swing.JLabel Minimize;
    private javax.swing.JTextField MnifactFieldUpde;
    private javax.swing.JPanel NewHome_panel;
    private javax.swing.JTextField PCatGoryField;
    private javax.swing.JTextField PIDField;
    private javax.swing.JTextField PNameField;
    private javax.swing.JTextField PurchUniFieldUpde;
    private javax.swing.JTextField PurchUnitField;
    private javax.swing.JTextField RorderLField2;
    private javax.swing.JTextField RorderQantField2;
    private javax.swing.JLabel Search;
    private javax.swing.JTable SearchTable;
    private javax.swing.JPanel Search_panel;
    private javax.swing.JLabel Search_txt;
    private javax.swing.JTextField SellPriField;
    private javax.swing.JTextField SellPriFieldUpde;
    private javax.swing.JTextField SerialNoField;
    private javax.swing.JLabel Show_Uname;
    private javax.swing.JTextField SiraNoFieldUpde;
    private javax.swing.JTextField SpPritFieldUpde;
    private javax.swing.JLabel SubMenu;
    private javax.swing.JPanel SubPanel;
    private javax.swing.JTextField SupDiscField;
    private javax.swing.JTextField SupDiscFieldUpDe;
    private javax.swing.JTextField SupPriField;
    private javax.swing.JPanel TimeLine;
    private javax.swing.JPanel TitleBar;
    private javax.swing.JSeparator Uname_Separator;
    private javax.swing.JLabel UpDe;
    private javax.swing.JPanel UpDe_panel;
    private javax.swing.JLabel UpDe_txt;
    private javax.swing.JTextField WarenPField1;
    private javax.swing.JTextField catcodeB;
    private javax.swing.JLabel dateLable;
    private javax.swing.JTextField discB;
    private javax.swing.JTextField iemCodeFieldUpde;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jsp;
    private javax.swing.JLabel logUserImg;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel newHome;
    private javax.swing.JLabel newHome_txt;
    private javax.swing.JLabel signOut_button;
    private javax.swing.JTextField uWarrenfield;
    // End of variables declaration//GEN-END:variables

//    private void setTime() {
        

    private void setHide() {
        NewHome_panel.setVisible(false);
        Search_panel.setVisible(false);
        UpDe_panel.setVisible(false);
        Category_panel3.setVisible(false);
        AddMore_panel5.setVisible(false);
        //AddMore_panel6.setVisible(false);
    }

    private void setTime() {
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
    }

    public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(jsp.getWidth(), jsp.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
    
//    public void checkoutofStock(){
//        
//        try {
////                String sqlcatcount = "Select COUNT(Number) From category";
////                pst = con.prepareStatement(sqlcatcount);
////                rs  = pst.executeQuery();
////            
////                while(rs.next())
////            {
////                String count = rs.getString("COUNT(Number)");
////                Integer nCount = Integer.parseInt(count);
////                System.out.println(nCount);
//                
////                for(int i = 1; i< 5; i++)
////                {
//                    String catego = StockCheck.printarray(1);
//                    System.out.println(catego);
//                    //try {
//                        String Sqlbstock = "SELECT ReorderLevel From category WHERE CatCode = '"+catego+"'";
//                        pst = con.prepareStatement(Sqlbstock);
//                        ResultSet rs2  = pst.executeQuery();
//                        
//                        while(rs2.next())
//                        {
//                        String bStock = rs2.getString("ReorderLevel");
//                        Integer nbStock = Integer.parseInt(bStock);
//                            System.out.println(nbStock);
//                        
//                            //try {
////                                String itemcount = "SELECT count(ItemCode) From category WHERE CatCode = '"+catego+"'";
////                                pst = con.prepareStatement(itemcount);
////                                ResultSet rs3  = pst.executeQuery();
////                        
////                            while(rs3.next())
////                            {
////                                String ItCount = rs3.getString("count(ItemCode)");
////                                Integer nItCount = Integer.parseInt(ItCount);
////                                System.out.println(nItCount);
////                                
////                                    if(nItCount <= nbStock)
////                                    {
////                                        String s = "'"+catego+"' is running out of stock";
////                                        JOptionPane.showMessageDialog(null, s);
////                                    
////                                    
////                                    }
////                                
////                            }
//                            //}
//                            //catch (Exception e) {
//                            //    System.out.println(e);
//                            //}
//                        
//                        
//                        }   
//                    //}
//                        //catch (Exception e) {
//                        //    System.out.println(e);
//                        //}
//        
//                //}
//           // }
//                
//            
//                
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//    //get the count of the categories
//    
//    
//    
//        
// 
//    }
//    
////    public int getNoOfCategories()
////    {
////        try {
////                String sqlcatcount = "Select COUNT(Number) From category";
////                pst = con.prepareStatement(sqlcatcount);
////                rs  = pst.executeQuery();
////                
////                
////            
////        } catch (Exception e) {
////            System.out.println(e);
////        }
////                
////        
////        String count = rs.getString("COUNT(Number)");
////        Integer nCount = Integer.parseInt(count);
////        System.out.println(nCount);
////        return nCount;
////                
////            
////    
////    
////    
////    
////    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("SLogo.png")));
    }
    
}
