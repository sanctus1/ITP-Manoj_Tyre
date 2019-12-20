/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComplaintMng_Package;

import AppPackage.AnimationClass;
import HomePage_Package.MainHome;
import static customer_compliants_management.Daycal.ChkDay;
import static customer_compliants_management.Daycal.DayGap;
import customer_compliants_management.Dbconnecter;
import static customer_compliants_management.Validate.isValidComId;
import static customer_compliants_management.Validate.isValidCost;
import static customer_compliants_management.Validate.isValidFloat;
import static customer_compliants_management.Validate.isValidName;
import static customer_compliants_management.Validate.isValidNameNum;
import static customer_compliants_management.Validate.isValidNum;
import static customer_compliants_management.Validate.isValidTyreDepth;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import javax.swing.JTextField;

/**
 *
 * @author Teshan Chathushka
 */
public class Complaint_management_User extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs;

    /**
     * Creates new form Complaint_management
     */
    int xMouse;//xMouse Global
    int yMouse;//yMouse Global
    int timeRun = 0;

    public Complaint_management_User() {
        initComponents();

        conn = Dbconnecter.con();

        //load to combo-battry type
        FillCombobatteryWarrantyDetails();

        //load to combobox-tyre type
        FillComboTyreType();

        //disable datechooser complaint battery pannel
        //disableDateChooserMaxDate();
        
        setHide();
        setTime();
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
    }

    //disable the datechooser
    public void disableDateChooserMaxDate() {
        complaint_battery_jDateChooser1.setMaxSelectableDate(new Date());
        battery_claiming_jDateChooser5.setMaxSelectableDate(new Date());
        battery_claiming_jDateChooser2.setMaxSelectableDate(new Date());
        battery_claiming_jDateChooser3.setMaxSelectableDate(new Date());
        battery_claiming_jDateChooser4.setMaxSelectableDate(new Date());
        tyre_jDateChooser9.setMaxSelectableDate(new Date());
        tyre_claiming_jDateChooser10.setMaxSelectableDate(new Date());
        tyre_claiming_jDateChooser12.setMaxSelectableDate(new Date());
        tyre_claiming_jDateChooser11.setMaxSelectableDate(new Date());
        service_warrantycheck_jDateChooser6.setMaxSelectableDate(new Date());
        service_warrantycheck_jDateChooser7.setMaxSelectableDate(new Date());
        service_warrantycheck_jDateChooser8.setMaxSelectableDate(new Date());

    }

    //combo box load-battery type
    private void FillCombobatteryWarrantyDetails() {
        try {
            String sql = "select * from warranty_details_battery";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String batt_type = rs.getString("battery_type");
                warranty_claiming_details_searchbattery.addItem(batt_type);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //laod combo box tyre type
    private void FillComboTyreType() {
        try {
            String sql = "select * from warranty_details_tyre";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String type = rs.getString("type");
                warranty_claiming_details_jComboBox1.addItem(type);

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
        Complaint_item_main = new javax.swing.JLabel();
        Complaint_service = new javax.swing.JLabel();
        Warranty_claiming_details = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        SubMenu = new javax.swing.JLabel();
        TitleBar = new javax.swing.JPanel();
        Minimize = new javax.swing.JLabel();
        Cancel = new javax.swing.JLabel();
        signOut_button = new javax.swing.JLabel();
        Show_Uname = new javax.swing.JLabel();
        logUserImg = new javax.swing.JLabel();
        DetailPanal = new javax.swing.JPanel();
        Complaint_item_main_txt = new javax.swing.JLabel();
        Complaint_service_txt = new javax.swing.JLabel();
        Warranty_claiming_details_txt = new javax.swing.JLabel();
        Anime_sub = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Complaint_item_main_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        selec_complitem1 = new javax.swing.JComboBox();
        next = new javax.swing.JButton();
        Warranty_claiming_details_panel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        warranty_claiming_details_jTextField13 = new javax.swing.JTextField();
        warranty_claiming_details_jTextField14 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        warranty_claiming_details_jButton7 = new javax.swing.JButton();
        warranty_claiming_details_jTextField17 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        warranty_claiming_details_jButton8 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        warranty_claiming_details_jButton9 = new javax.swing.JButton();
        warranty_claiming_details_jButton10 = new javax.swing.JButton();
        warranty_claiming_details_jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        warranty_claiming_details_jTextField15 = new javax.swing.JTextField();
        warranty_claiming_details_jLabel4 = new javax.swing.JLabel();
        warranty_claiming_details_jTextField16 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        warranty_claiming_details_searchbattery = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        warranty_claiming_details_jButton11 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        warranty_claiming_details_jButton12 = new javax.swing.JButton();
        warranty_claiming_details_jTextField19 = new javax.swing.JTextField();
        warranty_claiming_details_jTextField20 = new javax.swing.JTextField();
        warranty_claiming_details_jTextField21 = new javax.swing.JTextField();
        warranty_claiming_details_jTextField22 = new javax.swing.JTextField();
        warranty_claiming_details_jTextField23 = new javax.swing.JTextField();
        warranty_claiming_details_jButton13 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        warranty_claiming_details_jButton14 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel143 = new javax.swing.JLabel();
        warranty_claiming_details_jLabel4tyre = new javax.swing.JLabel();
        warranty_claiming_details_jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        Complaint_battery_panel = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        complaint_battery_jTextField45 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        complaint_battery_jTextField48 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        complaint_battery_jTextField49 = new javax.swing.JTextField();
        complaint_battery_jTextField50 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        complaint_battery_jTextField51 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        complaint_battery_jTextField52 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        complaint_battery_jPanel6 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        complaint_battery_jButton20 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        complaint_battery_jPanel14 = new javax.swing.JPanel();
        complaint_battery_jButton21 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        complaint_battery_jTextField41 = new javax.swing.JTextField();
        complaint_battery_jTextField40 = new javax.swing.JTextField();
        complaint_battery_jTextField46 = new javax.swing.JTextField();
        complaint_battery_jTextField43 = new javax.swing.JTextField();
        complaint_battery_jTextField47 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        complaint_battery_jTextField42 = new javax.swing.JTextField();
        complaint_battery_view = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        complaint_battery_jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel67 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        complaint_battery_jTextField37 = new javax.swing.JTextField();
        complaint_battery_jTextField39 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        complaint_battery_jTextField36 = new javax.swing.JTextField();
        complaint_battery_jTextField38 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        complaint_battery_jButton18 = new javax.swing.JButton();
        complaint_battery_jTextField35 = new javax.swing.JTextField();
        complaint_battery_jTextField44 = new javax.swing.JTextField();
        complaint_battery_jLabel52 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        complaint_battery_jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        Claiming_battery_panel = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        battery_claiming_jPanel7 = new javax.swing.JPanel();
        battery_claiming_jTextField53 = new javax.swing.JTextField();
        battery_claiming_jButton23 = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        battery_claiming_jTextField54 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        battery_claiming_jTextField55 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        battery_claiming_jTextField56 = new javax.swing.JTextField();
        battery_claiming_jTextField57 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        battery_claiming_jTextField59 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        battery_claiming_jTextField60 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        battery_claiming_jTextField61 = new javax.swing.JTextField();
        battery_claiming_jTextField62 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        battery_claiming_jTextField63 = new javax.swing.JTextField();
        battery_claiming_jButton6 = new javax.swing.JButton();
        battery_claiming_jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel98 = new javax.swing.JLabel();
        battery_claiming_jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel99 = new javax.swing.JLabel();
        battery_claiming_jTextField64 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        battery_claiming_jTextField13 = new javax.swing.JTextField();
        battery_claiming_jPanel8 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        battery_claiming_jTextField65 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        battery_claiming_jTextField66 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        battery_claiming_jTextField67 = new javax.swing.JTextField();
        battery_claiming_jButton25 = new javax.swing.JButton();
        battery_claiming_jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel105 = new javax.swing.JLabel();
        battery_claiming_jDateChooser5 = new com.toedter.calendar.JDateChooser();
        battery_claiming_jTextField69 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        battery_claiming_jTextField70 = new javax.swing.JTextField();
        battery_claiming_jTextField71 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Complaint_service_panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        service_complaint_jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        service_complaint_jTextField5 = new javax.swing.JTextField();
        service_complaint_jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        service_complaint_jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        service_complaint_jTextField8 = new javax.swing.JTextField();
        service_complaint_jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        service_complaint_jTextField9 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        service_complaint_jTextField10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        service_complaint_jTextField11 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        service_complaint_jTextField12 = new javax.swing.JTextField();
        Warranty_check_service_panel = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        service_warrantycheck_jPanel9 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        warrantycheck_jRadioButton3 = new javax.swing.JRadioButton();
        service_warrantycheck_jTextField72 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        service_warrantycheck_jTextField73 = new javax.swing.JTextField();
        warrantycheck_jRadioButton1 = new javax.swing.JRadioButton();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        service_warrantycheck_jButton27 = new javax.swing.JButton();
        jLabel115 = new javax.swing.JLabel();
        service_warrantycheck_jDateChooser6 = new com.toedter.calendar.JDateChooser();
        service_warrantycheck_jTextField74 = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        service_warrantycheck_jPanel6 = new javax.swing.JPanel();
        service_warrantycheck_jTextField79 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        service_warrantycheck_jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jLabel118 = new javax.swing.JLabel();
        service_warrantycheck_jDateChooser7 = new com.toedter.calendar.JDateChooser();
        service_warrantycheck_jButton28 = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        service_warrantycheck_jTextField77 = new javax.swing.JTextField();
        service_warrantycheck_jTextField76 = new javax.swing.JTextField();
        service_warrantycheck_jTextField78 = new javax.swing.JTextField();
        service_warrantycheck_jTextField80 = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        service_warrantycheck_jTextField75 = new javax.swing.JTextField();
        Complaint_tyre_panel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        tyre_jTextField25 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        tyre_jTextField26 = new javax.swing.JTextField();
        tyre_jButton31 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        tyre_jTextField27 = new javax.swing.JTextField();
        tyre_jButton32 = new javax.swing.JButton();
        tyre_jTextField28 = new javax.swing.JTextField();
        tyre_jDateChooser9 = new com.toedter.calendar.JDateChooser();
        tyre_jTextField29 = new javax.swing.JTextField();
        tyre_jTextField30 = new javax.swing.JTextField();
        tyre_jTextField81 = new javax.swing.JTextField();
        tyre_jTextField82 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        tyre_jTextField83 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        tyre_jTextField84 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        tyre_jTextField85 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        tyre_jTextField86 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        tyre_jTextField87 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        tyre_jTextField88 = new javax.swing.JTextField();
        tyre_jLabel57 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tyre_jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        Claiming_tyre_panel = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        tyre_claiming_jButton35 = new javax.swing.JButton();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        tyre_claiming_jTextField89 = new javax.swing.JTextField();
        tyre_claiming_jTextField90 = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        tyre_claiming_jTextField91 = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        tyre_claiming_jTextField92 = new javax.swing.JTextField();
        tyre_claiming_jTextField93 = new javax.swing.JTextField();
        tyre_claiming_jTextField94 = new javax.swing.JTextField();
        tyre_claiming_jTextField95 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        tyre_claiming_jDateChooser10 = new com.toedter.calendar.JDateChooser();
        tyre_claiming_jTextField96 = new javax.swing.JTextField();
        tyre_claiming_jTextField97 = new javax.swing.JTextField();
        tyre_claiming_jTextField98 = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        tyre_invoice_jTextField13 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        tyre_claiming_jTextField99 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        tyre_claiming_jButton37 = new javax.swing.JButton();
        tyre_claiming_jDateChooser11 = new com.toedter.calendar.JDateChooser();
        tyre_claiming_jTextField100 = new javax.swing.JTextField();
        tyre_claiming_jTextField101 = new javax.swing.JTextField();
        tyre_claiming_jTextField102 = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        tyre_claiming_jTextField103 = new javax.swing.JTextField();
        tyre_claiming_jButton38 = new javax.swing.JButton();
        tyre_claiming_jTextField104 = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        tyre_claiming_jDateChooser12 = new com.toedter.calendar.JDateChooser();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        tyre_claiming_jTextField105 = new javax.swing.JTextField();
        tyre_claiming_jTextField107 = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        tyre_invoice_re_jTextField13 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
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

        Complaint_item_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Add-32.png"))); // NOI18N
        Complaint_item_main.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Complaint_item_mainMouseMoved(evt);
            }
        });
        Complaint_item_main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Complaint_item_mainMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Complaint_item_mainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Complaint_item_mainMouseExited(evt);
            }
        });
        SubPanel.add(Complaint_item_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        Complaint_service.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Attendance-32 (1).png"))); // NOI18N
        Complaint_service.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Complaint_serviceMouseMoved(evt);
            }
        });
        Complaint_service.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Complaint_serviceMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Complaint_serviceMouseExited(evt);
            }
        });
        SubPanel.add(Complaint_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        Warranty_claiming_details.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Details-32.png"))); // NOI18N
        Warranty_claiming_details.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Warranty_claiming_detailsMouseMoved(evt);
            }
        });
        Warranty_claiming_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Warranty_claiming_detailsMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Warranty_claiming_detailsMouseExited(evt);
            }
        });
        SubPanel.add(Warranty_claiming_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 319, -1, -1));

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
        SubPanel.add(SubMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, -1, -1));

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
        TitleBar.add(Minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1023, 11, -1, 30));

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
        TitleBar.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1071, 11, -1, 30));

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

        Show_Uname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Show_Uname.setText("Normal User");
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

        getContentPane().add(TitleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1120, -1));

        DetailPanal.setBackground(new java.awt.Color(204, 204, 255));
        DetailPanal.setPreferredSize(new java.awt.Dimension(1120, 520));
        DetailPanal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Complaint_item_main_txt.setBackground(new java.awt.Color(37, 4, 70));
        Complaint_item_main_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        Complaint_item_main_txt.setForeground(new java.awt.Color(255, 255, 255));
        Complaint_item_main_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Complaint_item_main_txt.setText("Item Complaint Management");
        Complaint_item_main_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Complaint_item_main_txtMouseMoved(evt);
            }
        });
        Complaint_item_main_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Complaint_item_main_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Complaint_item_main_txtMouseExited(evt);
            }
        });
        DetailPanal.add(Complaint_item_main_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 40, 190, 40));

        Complaint_service_txt.setBackground(new java.awt.Color(37, 4, 70));
        Complaint_service_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        Complaint_service_txt.setForeground(new java.awt.Color(255, 255, 255));
        Complaint_service_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Complaint_service_txt.setText("Rapair Complaint Manage");
        Complaint_service_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Complaint_service_txtMouseMoved(evt);
            }
        });
        Complaint_service_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Complaint_service_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Complaint_service_txtMouseExited(evt);
            }
        });
        DetailPanal.add(Complaint_service_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 100, 190, 40));

        Warranty_claiming_details_txt.setBackground(new java.awt.Color(37, 4, 70));
        Warranty_claiming_details_txt.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        Warranty_claiming_details_txt.setForeground(new java.awt.Color(255, 255, 255));
        Warranty_claiming_details_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Warranty_claiming_details_txt.setText("Waranty Claming Details");
        Warranty_claiming_details_txt.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Warranty_claiming_details_txtMouseMoved(evt);
            }
        });
        Warranty_claiming_details_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Warranty_claiming_details_txtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Warranty_claiming_details_txtMouseExited(evt);
            }
        });
        DetailPanal.add(Warranty_claiming_details_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 160, 190, 40));

        Anime_sub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sb menu.png"))); // NOI18N
        DetailPanal.add(Anime_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 0, 190, 220));

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1120, 520));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Complaint_item_main_panel.setBackground(new java.awt.Color(204, 204, 255));
        Complaint_item_main_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Complaint_item_main_panel.setPreferredSize(new java.awt.Dimension(1120, 520));
        Complaint_item_main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Item Complaint Management");

        selec_complitem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selec_complitem1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a complained item type", "Battery", "Tyre" }));
        selec_complitem1.setPreferredSize(new java.awt.Dimension(167, 41));
        selec_complitem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selec_complitem1ActionPerformed(evt);
            }
        });

        next.setText("NEXT");
        next.setPreferredSize(new java.awt.Dimension(55, 41));
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(selec_complitem1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selec_complitem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        Complaint_item_main_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, 170));

        jLayeredPane1.add(Complaint_item_main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Warranty_claiming_details_panel.setBackground(new java.awt.Color(204, 204, 255));
        Warranty_claiming_details_panel.setPreferredSize(new java.awt.Dimension(1120, 520));
        Warranty_claiming_details_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Replacement Period");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setText("Enter Battery Warranty Claiming Details");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Company Name");

        warranty_claiming_details_jButton7.setText("REMOVE");
        warranty_claiming_details_jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jButton7ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Warranty Period");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Pro-rata Period");

        warranty_claiming_details_jButton8.setText("UPDATE");
        warranty_claiming_details_jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jButton8ActionPerformed(evt);
            }
        });

        jLabel24.setText("months");

        jLabel25.setText("months");

        jLabel26.setText("months");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Battery Type");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Search Battery");

        warranty_claiming_details_jButton9.setText("SEARCH");
        warranty_claiming_details_jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jButton9ActionPerformed(evt);
            }
        });

        warranty_claiming_details_jButton10.setText("SAVE");
        warranty_claiming_details_jButton10.setPreferredSize(new java.awt.Dimension(57, 32));
        warranty_claiming_details_jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jButton10ActionPerformed(evt);
            }
        });

        warranty_claiming_details_jButton2.setText("CLEAR");
        warranty_claiming_details_jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jButton2ActionPerformed(evt);
            }
        });

        jLabel19.setText("Add new battery type->");

        warranty_claiming_details_jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        warranty_claiming_details_jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jTextField16ActionPerformed(evt);
            }
        });

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel109.setText("Selected Battery Type");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(warranty_claiming_details_jTextField17)
                            .addComponent(warranty_claiming_details_jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(warranty_claiming_details_jTextField15)
                            .addComponent(warranty_claiming_details_jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(warranty_claiming_details_jTextField16)
                            .addComponent(warranty_claiming_details_jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(warranty_claiming_details_searchbattery, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(warranty_claiming_details_jButton9))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel24))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(warranty_claiming_details_jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(warranty_claiming_details_jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(warranty_claiming_details_jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(warranty_claiming_details_jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {warranty_claiming_details_jTextField13, warranty_claiming_details_jTextField14, warranty_claiming_details_jTextField17});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warranty_claiming_details_jLabel4)
                    .addComponent(jLabel109))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(warranty_claiming_details_jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(warranty_claiming_details_jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(warranty_claiming_details_jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel26)
                            .addComponent(warranty_claiming_details_jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(warranty_claiming_details_searchbattery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(warranty_claiming_details_jButton9)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(warranty_claiming_details_jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(warranty_claiming_details_jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(warranty_claiming_details_jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(warranty_claiming_details_jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(warranty_claiming_details_jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {warranty_claiming_details_jLabel4, warranty_claiming_details_jTextField15});

        Warranty_claiming_details_panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 450, 370));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel29.setText("Enter Tire Warranty Details");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Company");

        jLabel31.setText("Add new tyre type->");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("Warranty Period");

        warranty_claiming_details_jButton11.setText("REMOVE");
        warranty_claiming_details_jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jButton11ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Tax Percentage");

        warranty_claiming_details_jButton12.setText("UPDATE");
        warranty_claiming_details_jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jButton12ActionPerformed(evt);
            }
        });

        warranty_claiming_details_jButton13.setText("SAVE");
        warranty_claiming_details_jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jButton13ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Claiming Amount Per Tire Depth Unit");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setText("Search Tire");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Tire Type");

        warranty_claiming_details_jButton14.setText("SEARCH");
        warranty_claiming_details_jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warranty_claiming_details_jButton14ActionPerformed(evt);
            }
        });

        jLabel37.setText("months");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("RS");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setText("%");

        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel143.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel143.setText("Selected Tyre Type");

        warranty_claiming_details_jLabel4tyre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel34)
                    .addComponent(jLabel33)
                    .addComponent(jLabel143)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(warranty_claiming_details_jComboBox1, 0, 128, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(warranty_claiming_details_jButton14)
                        .addGap(85, 85, 85))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(warranty_claiming_details_jTextField20, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(warranty_claiming_details_jTextField19)
                                    .addComponent(warranty_claiming_details_jTextField21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(warranty_claiming_details_jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(warranty_claiming_details_jButton12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addGap(34, 34, 34)
                                        .addComponent(warranty_claiming_details_jButton11))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(warranty_claiming_details_jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(warranty_claiming_details_jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(warranty_claiming_details_jLabel4tyre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, warranty_claiming_details_jButton11, warranty_claiming_details_jButton12, warranty_claiming_details_jButton13});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel143)
                    .addComponent(warranty_claiming_details_jLabel4tyre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(warranty_claiming_details_jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warranty_claiming_details_jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(warranty_claiming_details_jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warranty_claiming_details_jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(warranty_claiming_details_jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warranty_claiming_details_jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(warranty_claiming_details_jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(warranty_claiming_details_jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(warranty_claiming_details_jButton14)
                    .addComponent(warranty_claiming_details_jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {warranty_claiming_details_jLabel4tyre, warranty_claiming_details_jTextField21});

        Warranty_claiming_details_panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 510, 370));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Warranty Claiming Details");
        Warranty_claiming_details_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLayeredPane1.add(Warranty_claiming_details_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Complaint_battery_panel.setBackground(new java.awt.Color(204, 204, 255));
        Complaint_battery_panel.setPreferredSize(new java.awt.Dimension(1120, 520));
        Complaint_battery_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel60.setText("Battery");
        Complaint_battery_panel.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 22, -1, -1));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel61.setText("Complaint Id");
        Complaint_battery_panel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));
        Complaint_battery_panel.add(complaint_battery_jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 120, -1));

        jButton19.setText("BACK");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        Complaint_battery_panel.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 11, -1, 30));

        jLabel76.setText("Warranty period");

        jLabel77.setText("Company");

        jLabel78.setText("Complaint Id");

        jLabel79.setText("Service Life");

        jLabel80.setText("Battery Type");

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel82.setText("This battery is eligible for free replacement.");

        complaint_battery_jButton20.setText("NEXT");
        complaint_battery_jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaint_battery_jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout complaint_battery_jPanel6Layout = new javax.swing.GroupLayout(complaint_battery_jPanel6);
        complaint_battery_jPanel6.setLayout(complaint_battery_jPanel6Layout);
        complaint_battery_jPanel6Layout.setHorizontalGroup(
            complaint_battery_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaint_battery_jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(complaint_battery_jButton20)
                .addGap(18, 18, 18))
        );
        complaint_battery_jPanel6Layout.setVerticalGroup(
            complaint_battery_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, complaint_battery_jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(complaint_battery_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(complaint_battery_jButton20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel75.setText("Warranty Claiming");

        complaint_battery_jButton21.setText("NEXT");
        complaint_battery_jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaint_battery_jButton21ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel81.setText("This battery is eligible for warranty claim under pro-rata basis.");

        javax.swing.GroupLayout complaint_battery_jPanel14Layout = new javax.swing.GroupLayout(complaint_battery_jPanel14);
        complaint_battery_jPanel14.setLayout(complaint_battery_jPanel14Layout);
        complaint_battery_jPanel14Layout.setHorizontalGroup(
            complaint_battery_jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaint_battery_jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(complaint_battery_jButton21)
                .addGap(15, 15, 15))
        );
        complaint_battery_jPanel14Layout.setVerticalGroup(
            complaint_battery_jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complaint_battery_jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(complaint_battery_jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(complaint_battery_jButton21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(complaint_battery_jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel79, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addComponent(complaint_battery_jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(complaint_battery_jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(complaint_battery_jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(complaint_battery_jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(complaint_battery_jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(complaint_battery_jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel75)
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complaint_battery_jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complaint_battery_jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel80))
                    .addComponent(complaint_battery_jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel79))
                    .addComponent(complaint_battery_jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel76))
                    .addComponent(complaint_battery_jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(complaint_battery_jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(complaint_battery_jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        Complaint_battery_panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 430, 450));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel72.setText("Sold Price");

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel70.setText("Serial No");

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel74.setText("Item Id");

        complaint_battery_view.setText("VIEW DETAILS");
        complaint_battery_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaint_battery_viewActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel71.setText("Warranty period");

        complaint_battery_jDateChooser1.setDateFormatString(" yyyy-MM-dd");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel67.setText("Date of sale");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel63.setText("Enter serial No on battery");

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel64.setText("Customer id");

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel69.setText("Battery type");

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel62.setText("Enter serial No in warranty card");

        complaint_battery_jTextField36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaint_battery_jTextField36ActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel65.setText("Customer Name");

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel73.setText("Company");

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel66.setText("Vehicle registration No");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel68.setText("Complaint Date");

        complaint_battery_jButton18.setText("ENTER TO WARRANTY CLAIMING");
        complaint_battery_jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaint_battery_jButton18ActionPerformed(evt);
            }
        });

        complaint_battery_jLabel52.setForeground(new java.awt.Color(255, 0, 0));
        complaint_battery_jLabel52.setText("Serial numbers are not matched!!");

        jLabel52.setText("months");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setText("Customer Address");

        complaint_battery_jTextArea1.setColumns(20);
        complaint_battery_jTextArea1.setRows(5);
        jScrollPane2.setViewportView(complaint_battery_jTextArea1);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(complaint_battery_view)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel63)
                                        .addComponent(jLabel62))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(complaint_battery_jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(complaint_battery_jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(complaint_battery_jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(complaint_battery_jTextField43, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(complaint_battery_jTextField37, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(complaint_battery_jTextField38, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(complaint_battery_jTextField39, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(complaint_battery_jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(complaint_battery_jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(complaint_battery_jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(complaint_battery_jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(complaint_battery_jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel52))
                                    .addComponent(complaint_battery_jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(complaint_battery_jButton18, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(complaint_battery_jLabel52)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {complaint_battery_jTextField35, complaint_battery_jTextField36});

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {complaint_battery_jDateChooser1, complaint_battery_jTextField37, complaint_battery_jTextField38, complaint_battery_jTextField39, complaint_battery_jTextField40, complaint_battery_jTextField41, complaint_battery_jTextField43, complaint_battery_jTextField44, complaint_battery_jTextField46, complaint_battery_jTextField47});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel62)
                        .addComponent(complaint_battery_jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addComponent(complaint_battery_jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complaint_battery_view)
                    .addComponent(complaint_battery_jLabel52))
                .addGap(35, 35, 35)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(complaint_battery_jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(complaint_battery_jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel73))
                                .addGap(18, 18, 18)
                                .addComponent(complaint_battery_jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel74))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(complaint_battery_jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(complaint_battery_jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71)
                            .addComponent(jLabel52))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(complaint_battery_jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72))
                        .addComponent(complaint_battery_jButton18)
                        .addGap(84, 84, 84))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(complaint_battery_jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(complaint_battery_jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel64))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(complaint_battery_jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(complaint_battery_jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel66))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(complaint_battery_jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel67))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))))
        );

        Complaint_battery_panel.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 600, 450));

        jButton1.setText("Demo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Complaint_battery_panel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, -1, 20));

        jLayeredPane1.add(Complaint_battery_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Claiming_battery_panel.setBackground(new java.awt.Color(204, 204, 255));
        Claiming_battery_panel.setPreferredSize(new java.awt.Dimension(1120, 520));
        Claiming_battery_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel83.setText("Warranty Claiming-Free Replacement");
        Claiming_battery_panel.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jButton22.setText("BACK");
        jButton22.setPreferredSize(new java.awt.Dimension(59, 41));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        Claiming_battery_panel.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 70, 30));

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel84.setText("Warranty Caiming-Under Pro rata Basis");
        Claiming_battery_panel.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        battery_claiming_jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        battery_claiming_jTextField53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battery_claiming_jTextField53ActionPerformed(evt);
            }
        });

        battery_claiming_jButton23.setText("DONE");
        battery_claiming_jButton23.setPreferredSize(new java.awt.Dimension(93, 31));
        battery_claiming_jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battery_claiming_jButton23ActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel85.setText("Complaint Id");

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel86.setText("Sold Price");

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel87.setText("Serial No");

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel88.setText("Battery Type");

        battery_claiming_jTextField55.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                battery_claiming_jTextField55KeyPressed(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel89.setText("Replaced Date");

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel90.setText("Price");

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel91.setText("Item Id");

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel93.setText("Discount Percentage");

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel94.setText("Special Price");

        battery_claiming_jTextField59.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                battery_claiming_jTextField59KeyPressed(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel95.setText("New Battry Details");

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel96.setText("Warranty Period");

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel97.setText("Battery Type");

        battery_claiming_jButton6.setText("PAYMENT CONFIRM");
        battery_claiming_jButton6.setPreferredSize(new java.awt.Dimension(115, 31));
        battery_claiming_jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battery_claiming_jButton6ActionPerformed(evt);
            }
        });

        battery_claiming_jDateChooser3.setDateFormatString("yyyy-MM-dd");

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel98.setText("Date Of Sale");

        battery_claiming_jDateChooser4.setDateFormatString("yyyy-MM-dd");

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel99.setText("Company");

        jLabel56.setForeground(new java.awt.Color(153, 0, 0));
        jLabel56.setText("Please enter the Item Id or the Serial No and PRESS ENTER.");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setText("Invoice No");

        javax.swing.GroupLayout battery_claiming_jPanel7Layout = new javax.swing.GroupLayout(battery_claiming_jPanel7);
        battery_claiming_jPanel7.setLayout(battery_claiming_jPanel7Layout);
        battery_claiming_jPanel7Layout.setHorizontalGroup(
            battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel85)
                            .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel93)
                                .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addComponent(jLabel86)))
                            .addComponent(jLabel88))
                        .addGap(4, 4, 4)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(battery_claiming_jTextField57)
                            .addComponent(battery_claiming_jTextField63, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(battery_claiming_jTextField62, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(battery_claiming_jTextField60, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel54)
                            .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel90))
                                .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(battery_claiming_jTextField56)
                            .addComponent(battery_claiming_jTextField61, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(battery_claiming_jTextField13))))
                .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, battery_claiming_jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel96)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(battery_claiming_jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                                .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel91, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel97, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel98, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel89, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(battery_claiming_jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(battery_claiming_jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(battery_claiming_jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(battery_claiming_jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(battery_claiming_jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(battery_claiming_jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(88, 88, 88))
                    .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95)
                            .addComponent(jLabel56))
                        .addGap(0, 49, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, battery_claiming_jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(battery_claiming_jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(battery_claiming_jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        battery_claiming_jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {battery_claiming_jButton23, battery_claiming_jButton6});

        battery_claiming_jPanel7Layout.setVerticalGroup(
            battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, battery_claiming_jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(battery_claiming_jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85)
                    .addComponent(jLabel95))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel91)
                            .addComponent(battery_claiming_jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(battery_claiming_jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(battery_claiming_jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(battery_claiming_jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88))
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93)
                            .addComponent(battery_claiming_jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86)
                            .addComponent(battery_claiming_jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89))))
                .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(battery_claiming_jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(battery_claiming_jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel90))
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(battery_claiming_jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94)))
                    .addGroup(battery_claiming_jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(battery_claiming_jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel98))
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(battery_claiming_jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel97))
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(battery_claiming_jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(battery_claiming_jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(battery_claiming_jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(battery_claiming_jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(battery_claiming_jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );

        Claiming_battery_panel.add(battery_claiming_jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 610, 440));

        battery_claiming_jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel100.setText("Replaced Date");

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel101.setText("Battery Type");

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel102.setText("Serial No");

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel103.setText("Date Of Sale");

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel104.setText("Item Id");

        battery_claiming_jTextField67.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                battery_claiming_jTextField67KeyPressed(evt);
            }
        });

        battery_claiming_jButton25.setText("DONE");
        battery_claiming_jButton25.setPreferredSize(new java.awt.Dimension(57, 31));
        battery_claiming_jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battery_claiming_jButton25ActionPerformed(evt);
            }
        });

        battery_claiming_jDateChooser2.setDateFormatString("yyyy-MM-dd");

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel105.setText("Company");

        battery_claiming_jDateChooser5.setDateFormatString("yyyy-MM-dd");

        battery_claiming_jTextField69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battery_claiming_jTextField69ActionPerformed(evt);
            }
        });
        battery_claiming_jTextField69.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                battery_claiming_jTextField69KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                battery_claiming_jTextField69KeyTyped(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel107.setText("Warranty period");

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel108.setText("Complaint Id");

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel106.setText("Replacement Details");

        jLabel55.setForeground(new java.awt.Color(153, 0, 0));
        jLabel55.setText("Please enter the Item Id or the Serial No and PRESS ENTER.");

        jLabel3.setText("months");

        javax.swing.GroupLayout battery_claiming_jPanel8Layout = new javax.swing.GroupLayout(battery_claiming_jPanel8);
        battery_claiming_jPanel8.setLayout(battery_claiming_jPanel8Layout);
        battery_claiming_jPanel8Layout.setHorizontalGroup(
            battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(battery_claiming_jPanel8Layout.createSequentialGroup()
                .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(battery_claiming_jPanel8Layout.createSequentialGroup()
                        .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(battery_claiming_jPanel8Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel100, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel103, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel102, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel101, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel107, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(4, 4, 4)
                                    .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(battery_claiming_jTextField65, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                        .addComponent(battery_claiming_jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                        .addComponent(battery_claiming_jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                        .addComponent(battery_claiming_jTextField69, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                        .addComponent(battery_claiming_jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(battery_claiming_jTextField71, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                        .addComponent(battery_claiming_jTextField66, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                        .addGroup(battery_claiming_jPanel8Layout.createSequentialGroup()
                                            .addComponent(battery_claiming_jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel3))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, battery_claiming_jPanel8Layout.createSequentialGroup()
                                    .addGap(101, 101, 101)
                                    .addComponent(battery_claiming_jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(battery_claiming_jPanel8Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel106)))
                        .addGap(0, 198, Short.MAX_VALUE))
                    .addGroup(battery_claiming_jPanel8Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        battery_claiming_jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {battery_claiming_jDateChooser2, battery_claiming_jDateChooser5, battery_claiming_jTextField65, battery_claiming_jTextField66, battery_claiming_jTextField67, battery_claiming_jTextField69, battery_claiming_jTextField71});

        battery_claiming_jPanel8Layout.setVerticalGroup(
            battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(battery_claiming_jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(battery_claiming_jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108))
                .addGap(18, 18, 18)
                .addComponent(jLabel106)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(battery_claiming_jDateChooser5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(battery_claiming_jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103))
                .addGap(2, 2, 2)
                .addComponent(jLabel55)
                .addGap(2, 2, 2)
                .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(battery_claiming_jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(battery_claiming_jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102))
                .addGap(18, 18, 18)
                .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(battery_claiming_jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(battery_claiming_jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(battery_claiming_jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(battery_claiming_jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(battery_claiming_jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        Claiming_battery_panel.add(battery_claiming_jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 440, 440));

        jButton3.setText("Demo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Claiming_battery_panel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, 20));

        jLayeredPane1.add(Claiming_battery_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Complaint_service_panel.setBackground(new java.awt.Color(204, 204, 255));
        Complaint_service_panel.setPreferredSize(new java.awt.Dimension(1120, 520));
        Complaint_service_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setText("Services And Repairs");
        Complaint_service_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        service_complaint_jButton4.setText("ASSIGN AWARRANTY CHECK");
        service_complaint_jButton4.setPreferredSize(new java.awt.Dimension(155, 31));
        service_complaint_jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                service_complaint_jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Customer Name");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Customer Id");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Enter Job No");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Job Details");

        service_complaint_jButton5.setText("VIEW JOB DETAILS");
        service_complaint_jButton5.setPreferredSize(new java.awt.Dimension(125, 31));
        service_complaint_jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                service_complaint_jButton5ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Technecian No");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Technecian Name");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Vehicle Registration No");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Job Date");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Next Service Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(service_complaint_jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(service_complaint_jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(service_complaint_jTextField7)
                            .addComponent(service_complaint_jTextField6)
                            .addComponent(service_complaint_jTextField10)
                            .addComponent(service_complaint_jTextField9)
                            .addComponent(service_complaint_jTextField11)
                            .addComponent(service_complaint_jTextField12)
                            .addComponent(service_complaint_jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(service_complaint_jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {service_complaint_jTextField10, service_complaint_jTextField11, service_complaint_jTextField12, service_complaint_jTextField6, service_complaint_jTextField7, service_complaint_jTextField8, service_complaint_jTextField9});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(service_complaint_jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(service_complaint_jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(service_complaint_jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(service_complaint_jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(service_complaint_jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(service_complaint_jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(service_complaint_jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(service_complaint_jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(service_complaint_jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(service_complaint_jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        Complaint_service_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 780, 410));

        jLayeredPane1.add(Complaint_service_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Warranty_check_service_panel.setBackground(new java.awt.Color(204, 204, 255));
        Warranty_check_service_panel.setPreferredSize(new java.awt.Dimension(1120, 520));
        Warranty_check_service_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel110.setText("Warranty Check");
        Warranty_check_service_panel.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel111.setText("Complaint Id");

        warrantycheck_jRadioButton3.setText("Error is not regarding to the service done by the thechnecian.");
        warrantycheck_jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warrantycheck_jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel112.setText("Technecian Id");

        warrantycheck_jRadioButton1.setText("Error is regarding to the service done by the thechnecian.");
        warrantycheck_jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warrantycheck_jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel113.setText("Checked Date");

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel114.setText("Technecian Name");

        service_warrantycheck_jButton27.setText("NEXT");
        service_warrantycheck_jButton27.setPreferredSize(new java.awt.Dimension(57, 31));
        service_warrantycheck_jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                service_warrantycheck_jButton27ActionPerformed(evt);
            }
        });

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel115.setText("Warranty Check Details");

        service_warrantycheck_jDateChooser6.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout service_warrantycheck_jPanel9Layout = new javax.swing.GroupLayout(service_warrantycheck_jPanel9);
        service_warrantycheck_jPanel9.setLayout(service_warrantycheck_jPanel9Layout);
        service_warrantycheck_jPanel9Layout.setHorizontalGroup(
            service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(service_warrantycheck_jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warrantycheck_jRadioButton3)
                    .addComponent(warrantycheck_jRadioButton1)
                    .addGroup(service_warrantycheck_jPanel9Layout.createSequentialGroup()
                        .addGroup(service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel111)
                            .addComponent(jLabel112)
                            .addComponent(jLabel114)
                            .addComponent(jLabel113))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(service_warrantycheck_jTextField73)
                                .addComponent(service_warrantycheck_jTextField74)
                                .addComponent(service_warrantycheck_jDateChooser6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(service_warrantycheck_jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel115)
                    .addComponent(service_warrantycheck_jButton27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        service_warrantycheck_jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {service_warrantycheck_jTextField72, service_warrantycheck_jTextField73});

        service_warrantycheck_jPanel9Layout.setVerticalGroup(
            service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(service_warrantycheck_jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel115)
                .addGap(18, 18, 18)
                .addGroup(service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(service_warrantycheck_jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(service_warrantycheck_jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(service_warrantycheck_jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(service_warrantycheck_jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(service_warrantycheck_jDateChooser6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(warrantycheck_jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warrantycheck_jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(service_warrantycheck_jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Warranty_check_service_panel.add(service_warrantycheck_jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 123, -1, -1));

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel116.setText("Warranty Claim Service Details");
        Warranty_check_service_panel.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 83, -1, -1));

        jButton30.setText("BACK");
        jButton30.setPreferredSize(new java.awt.Dimension(59, 31));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        Warranty_check_service_panel.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 11, 70, 30));

        jLabel121.setText("Next Service Date");

        jLabel123.setText("Discount");

        jLabel122.setText("Full Service Cost");

        jLabel120.setText("Service Date");

        service_warrantycheck_jDateChooser8.setDateFormatString("yyyy-MM-dd");

        jLabel118.setText("Technecian Id");

        service_warrantycheck_jDateChooser7.setDateFormatString("yyyy-MM-dd");

        service_warrantycheck_jButton28.setText("CONFIRM");
        service_warrantycheck_jButton28.setPreferredSize(new java.awt.Dimension(79, 31));
        service_warrantycheck_jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                service_warrantycheck_jButton28ActionPerformed(evt);
            }
        });

        jLabel124.setText("Final Service cost");

        jLabel117.setText("Complaint Id");

        jLabel119.setText("Technecian Name");

        javax.swing.GroupLayout service_warrantycheck_jPanel6Layout = new javax.swing.GroupLayout(service_warrantycheck_jPanel6);
        service_warrantycheck_jPanel6.setLayout(service_warrantycheck_jPanel6Layout);
        service_warrantycheck_jPanel6Layout.setHorizontalGroup(
            service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(service_warrantycheck_jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel117)
                    .addComponent(jLabel118)
                    .addComponent(jLabel119)
                    .addComponent(jLabel120)
                    .addComponent(jLabel121))
                .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(service_warrantycheck_jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(service_warrantycheck_jTextField75)
                            .addComponent(service_warrantycheck_jTextField76)
                            .addComponent(service_warrantycheck_jTextField77)
                            .addComponent(service_warrantycheck_jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, service_warrantycheck_jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(service_warrantycheck_jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(service_warrantycheck_jPanel6Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jLabel122)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(service_warrantycheck_jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, service_warrantycheck_jPanel6Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, service_warrantycheck_jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel123)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(service_warrantycheck_jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, service_warrantycheck_jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel124)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(service_warrantycheck_jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, service_warrantycheck_jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(service_warrantycheck_jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        service_warrantycheck_jPanel6Layout.setVerticalGroup(
            service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(service_warrantycheck_jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, service_warrantycheck_jPanel6Layout.createSequentialGroup()
                        .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(service_warrantycheck_jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel122))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(service_warrantycheck_jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel123))
                        .addGap(18, 18, 18)
                        .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(service_warrantycheck_jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel124)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, service_warrantycheck_jPanel6Layout.createSequentialGroup()
                        .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel117)
                            .addComponent(service_warrantycheck_jTextField75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(service_warrantycheck_jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel118))
                        .addGap(18, 18, 18)
                        .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(service_warrantycheck_jTextField77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel119))))
                .addGap(18, 18, 18)
                .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(service_warrantycheck_jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(service_warrantycheck_jPanel6Layout.createSequentialGroup()
                        .addGroup(service_warrantycheck_jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(service_warrantycheck_jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, service_warrantycheck_jPanel6Layout.createSequentialGroup()
                        .addComponent(service_warrantycheck_jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        Warranty_check_service_panel.add(service_warrantycheck_jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 123, -1, -1));

        jLayeredPane1.add(Warranty_check_service_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Complaint_tyre_panel.setBackground(new java.awt.Color(204, 204, 255));
        Complaint_tyre_panel.setPreferredSize(new java.awt.Dimension(1120, 520));
        Complaint_tyre_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel40.setText("Tyre");
        Complaint_tyre_panel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 28, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("Complaint Id");
        Complaint_tyre_panel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 60, -1, -1));

        jButton15.setText("BACK");
        jButton15.setPreferredSize(new java.awt.Dimension(59, 31));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        Complaint_tyre_panel.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1043, 11, 67, -1));
        Complaint_tyre_panel.add(tyre_jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 58, 120, -1));

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tyre_jButton31.setText("ENTER TO WARRANTY CLAIMING");
        tyre_jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_jButton31ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("Sold Price");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setText("Tyre Type");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("Customer Id");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Vehicle Registration No");

        tyre_jButton32.setText("View Details");
        tyre_jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_jButton32ActionPerformed(evt);
            }
        });

        tyre_jDateChooser9.setDateFormatString("yyyy-MM-dd");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setText("Enter Serial No On Tyre");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setText("Enter Serial No In Warranty Card");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setText("Customer Name");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setText("Warranty Period");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setText("Complaint Date");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setText("Company");

        jLabel125.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel125.setText("Item Id");

        jLabel126.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel126.setText("Serial No");

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel127.setText("Date of Sale");

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel128.setText("Original Tyre Depth");

        tyre_jLabel57.setForeground(new java.awt.Color(204, 0, 0));
        tyre_jLabel57.setText("Serial numbers are not matched!");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel57.setText("Customer Address");

        tyre_jTextArea1.setColumns(20);
        tyre_jTextArea1.setRows(5);
        jScrollPane1.setViewportView(tyre_jTextArea1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel46))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tyre_jTextField81, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(tyre_jTextField88)))
                            .addComponent(tyre_jButton32)
                            .addComponent(tyre_jLabel57))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel48)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addComponent(jLabel57)
                    .addComponent(jLabel45)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tyre_jTextField83)
                    .addComponent(tyre_jTextField26)
                    .addComponent(tyre_jTextField28)
                    .addComponent(tyre_jDateChooser9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tyre_jTextField87)
                    .addComponent(tyre_jTextField86)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel51)
                                .addComponent(jLabel125)
                                .addComponent(jLabel126)
                                .addComponent(jLabel49))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tyre_jTextField27, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(tyre_jTextField30)
                                .addComponent(tyre_jTextField84)
                                .addComponent(tyre_jTextField82)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel42)
                                .addComponent(jLabel128))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tyre_jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tyre_jTextField85, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(tyre_jButton31)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(tyre_jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel125)
                            .addComponent(tyre_jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel126)
                            .addComponent(tyre_jTextField84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tyre_jTextField86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tyre_jTextField82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(tyre_jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(tyre_jTextField88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tyre_jButton32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tyre_jLabel57))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(tyre_jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel44))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tyre_jTextField87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel127))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(tyre_jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tyre_jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel128))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(tyre_jTextField85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tyre_jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(tyre_jTextField83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tyre_jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        Complaint_tyre_panel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, 380));

        jButton4.setText("Demo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Complaint_tyre_panel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 23, -1, 20));

        jLayeredPane1.add(Complaint_tyre_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Claiming_tyre_panel.setBackground(new java.awt.Color(204, 204, 255));
        Claiming_tyre_panel.setPreferredSize(new java.awt.Dimension(1120, 520));
        Claiming_tyre_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel129.setText("Tyre");
        Claiming_tyre_panel.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jButton34.setText("BACK");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        Claiming_tyre_panel.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 11, -1, 30));

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel130.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel130.setText("Refund Date");

        jLabel131.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel131.setText("Refundable Amount");

        tyre_claiming_jButton35.setText("REFUND");
        tyre_claiming_jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_claiming_jButton35ActionPerformed(evt);
            }
        });

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel132.setText("Waste Tyre Depth");

        jLabel133.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel133.setText("Service Life");

        tyre_claiming_jTextField90.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tyre_claiming_jTextField90KeyPressed(evt);
            }
        });

        jLabel134.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel134.setText("Company");

        jLabel135.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel135.setText("Tyre Type");

        jLabel136.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel136.setText("Sold Price");

        jLabel137.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel137.setText("Claiming Amount");

        tyre_claiming_jTextField92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_claiming_jTextField92ActionPerformed(evt);
            }
        });

        tyre_claiming_jTextField95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_claiming_jTextField95ActionPerformed(evt);
            }
        });

        jLabel138.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel138.setText("Tax Amount");

        jLabel139.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel139.setText("Complaint Id");

        jLabel140.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel140.setText("Warranty Period");

        tyre_claiming_jDateChooser10.setDateFormatString("yyyy-MM-dd");

        jLabel141.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel141.setText("Wrranty Claiming-Refund");

        jLabel58.setForeground(new java.awt.Color(153, 0, 0));
        jLabel58.setText("Please enter waste tire depth and PRESS ENTER");

        jLabel155.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel155.setText("Invoice No");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel141)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel135)
                                    .addComponent(jLabel134)
                                    .addComponent(jLabel140)
                                    .addComponent(jLabel133)
                                    .addComponent(jLabel132)
                                    .addComponent(jLabel139))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tyre_claiming_jTextField98, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tyre_claiming_jTextField89, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tyre_claiming_jTextField94, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tyre_claiming_jTextField90, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tyre_claiming_jTextField95, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(tyre_claiming_jTextField97)))
                            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tyre_claiming_jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel136)
                                    .addComponent(jLabel137)
                                    .addComponent(jLabel138)
                                    .addComponent(jLabel131)
                                    .addComponent(jLabel130)
                                    .addComponent(jLabel155))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tyre_claiming_jTextField93, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(tyre_claiming_jTextField91, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(tyre_claiming_jTextField96, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(tyre_claiming_jTextField92, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(tyre_claiming_jDateChooser10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tyre_invoice_jTextField13))))))
                .addGap(43, 43, 43))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tyre_claiming_jDateChooser10, tyre_claiming_jTextField89, tyre_claiming_jTextField90, tyre_claiming_jTextField91, tyre_claiming_jTextField92, tyre_claiming_jTextField93, tyre_claiming_jTextField94, tyre_claiming_jTextField95, tyre_claiming_jTextField96, tyre_claiming_jTextField97, tyre_claiming_jTextField98});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel141)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel136)
                            .addComponent(tyre_claiming_jTextField91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel137)
                            .addComponent(tyre_claiming_jTextField92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel138)
                            .addComponent(tyre_claiming_jTextField93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel131)
                            .addComponent(tyre_claiming_jTextField96, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(tyre_claiming_jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel139)
                            .addComponent(tyre_claiming_jTextField95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 19, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel135)
                            .addComponent(tyre_claiming_jTextField97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel134)
                            .addComponent(tyre_claiming_jTextField98, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel140)
                            .addComponent(tyre_claiming_jTextField89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel133)
                            .addComponent(tyre_claiming_jTextField94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel130))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel132)
                            .addComponent(tyre_claiming_jTextField90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel155)
                            .addComponent(tyre_invoice_jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tyre_claiming_jButton35))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel58)))
                .addGap(75, 75, 75))
        );

        Claiming_tyre_panel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 530, 380));

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tyre_claiming_jTextField99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_claiming_jTextField99ActionPerformed(evt);
            }
        });
        tyre_claiming_jTextField99.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tyre_claiming_jTextField99KeyPressed(evt);
            }
        });

        jLabel142.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel142.setText("Warranty Period");

        tyre_claiming_jButton37.setText("PAYMENT CONFIRM");
        tyre_claiming_jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_claiming_jButton37ActionPerformed(evt);
            }
        });

        tyre_claiming_jDateChooser11.setDateFormatString("yyyy-MM-dd");

        tyre_claiming_jTextField101.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tyre_claiming_jTextField101KeyPressed(evt);
            }
        });

        tyre_claiming_jTextField102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_claiming_jTextField102ActionPerformed(evt);
            }
        });

        jLabel144.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel144.setText("Date Of Sale");

        jLabel145.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel145.setText("Warranty Claiming-Replacement Without Refund");

        jLabel146.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel146.setText("New Tire Details");

        tyre_claiming_jButton38.setText("DONE");
        tyre_claiming_jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_claiming_jButton38ActionPerformed(evt);
            }
        });

        tyre_claiming_jTextField104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyre_claiming_jTextField104ActionPerformed(evt);
            }
        });

        jLabel147.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel147.setText("Item Id");

        jLabel148.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel148.setText("Serial No");

        tyre_claiming_jDateChooser12.setDateFormatString("yyyy-MM-dd");

        jLabel149.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel149.setText("Price");

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel150.setText("Special Price");

        jLabel151.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel151.setText("Complaint Id");

        jLabel152.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel152.setText("Company");

        jLabel153.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel153.setText("Replaced Date");

        jLabel154.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel154.setText("Tyre Type");

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel59.setText("Invoice No");

        jLabel92.setForeground(new java.awt.Color(153, 0, 0));
        jLabel92.setText("Enter Item Id OR Serial NO and PRESS ENTER");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel151)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tyre_claiming_jTextField107, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel145)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(tyre_claiming_jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tyre_claiming_jButton37))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel142)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tyre_claiming_jTextField104, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel149)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tyre_claiming_jTextField105))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel144)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tyre_claiming_jDateChooser12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(jLabel153)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tyre_claiming_jDateChooser11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel152)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tyre_claiming_jTextField100))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel154)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tyre_claiming_jTextField103)))
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(jLabel150)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tyre_claiming_jTextField102, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel12Layout.createSequentialGroup()
                                                    .addComponent(jLabel59)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(tyre_invoice_re_jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                                        .addComponent(jLabel148)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(tyre_claiming_jTextField101))
                                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(jLabel147)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(tyre_claiming_jTextField99)))))))))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel146)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel92)
                        .addContainerGap())))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tyre_claiming_jDateChooser11, tyre_claiming_jDateChooser12, tyre_claiming_jTextField100, tyre_claiming_jTextField101, tyre_claiming_jTextField102, tyre_claiming_jTextField103, tyre_claiming_jTextField104, tyre_claiming_jTextField105, tyre_claiming_jTextField107, tyre_claiming_jTextField99});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel145)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel151)
                            .addComponent(tyre_claiming_jTextField107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel146)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel152)
                            .addComponent(tyre_claiming_jTextField100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tyre_claiming_jTextField103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel154))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tyre_claiming_jTextField104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel142))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tyre_claiming_jDateChooser12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tyre_claiming_jTextField99, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel147))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tyre_claiming_jTextField101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel148))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tyre_claiming_jTextField105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel149))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel150)
                            .addComponent(tyre_claiming_jTextField102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tyre_claiming_jDateChooser11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tyre_claiming_jButton38)
                            .addComponent(tyre_claiming_jButton37))
                        .addGap(67, 67, 67))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(tyre_invoice_re_jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        Claiming_tyre_panel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 480, 400));

        jButton5.setText("Demo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Claiming_tyre_panel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jButton6.setText("Demo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Claiming_tyre_panel.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, -1, -1));

        jLayeredPane1.add(Claiming_tyre_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        DetailPanal.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(DetailPanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 153, 1120, 520));

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

        getContentPane().add(TimeLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 44, 1120, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TitleBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleBarMouseClicked

    private void TitleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMouseDragged
        //mouse dragged even and create mouse x & y axie
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_TitleBarMouseDragged

    private void TitleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleBarMousePressed
        //Jframe pressed and dragged Ivent
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_TitleBarMousePressed

    private void MinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseClicked
        this.setState(JFrame.ICONIFIED); // minimize Button Mouse click event

    }//GEN-LAST:event_MinimizeMouseClicked

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        //Close Button mouse click event
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Exit", dialog);
        if (result == 0) {
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
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

    }//GEN-LAST:event_HomeMouseMoved

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_HomeMouseExited

    private void SubMenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubMenuMouseMoved
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

    }//GEN-LAST:event_SubMenuMouseMoved

    private void SubMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubMenuMouseExited
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_SubMenuMouseExited

    private void Complaint_item_mainMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_item_mainMouseMoved
        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70

        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

    }//GEN-LAST:event_Complaint_item_mainMouseMoved

    private void Complaint_item_mainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_item_mainMouseExited
        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Complaint_item_mainMouseExited

    private void Complaint_serviceMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_serviceMouseMoved
        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70

        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

    }//GEN-LAST:event_Complaint_serviceMouseMoved

    private void Complaint_serviceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_serviceMouseExited
        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Complaint_serviceMouseExited

    private void Warranty_claiming_detailsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Warranty_claiming_detailsMouseMoved
        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,7

        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

    }//GEN-LAST:event_Warranty_claiming_detailsMouseMoved

    private void Warranty_claiming_detailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Warranty_claiming_detailsMouseExited
        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Warranty_claiming_detailsMouseExited

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
        AddRemove1.jLabelXRight(-190, 0, 10, 5, Complaint_item_main_txt);
        // <<<----------
        AnimationClass AddRemove2 = new AnimationClass();
        AddRemove2.jLabelXLeft(0, -190, 10, 5, Complaint_item_main_txt);
        //---------------------------------------------

        //  --------->>>
        AnimationClass Attendance1 = new AnimationClass();
        Attendance1.jLabelXRight(-190, 0, 10, 5, Complaint_service_txt);
        // <<<----------
        AnimationClass Attendance2 = new AnimationClass();
        Attendance2.jLabelXLeft(0, -190, 10, 5, Complaint_service_txt);
        //---------------------------------------------

        //  --------->>>
        AnimationClass EDetails1 = new AnimationClass();
        EDetails1.jLabelXRight(-190, 0, 10, 5, Warranty_claiming_details_txt);
        // <<<----------
        AnimationClass EDetails2 = new AnimationClass();
        EDetails2.jLabelXLeft(0, -190, 10, 5, Warranty_claiming_details_txt);
        //---------------------------------------------


    }//GEN-LAST:event_SubMenuMouseClicked

    private void Complaint_item_main_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_item_main_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70

        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));


    }//GEN-LAST:event_Complaint_item_main_txtMouseMoved

    private void Complaint_item_main_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_item_main_txtMouseExited
        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Complaint_item_main_txtMouseExited

    private void Complaint_service_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_service_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70

        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

    }//GEN-LAST:event_Complaint_service_txtMouseMoved

    private void Complaint_service_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_service_txtMouseExited
        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Complaint_service_txtMouseExited

    private void Warranty_claiming_details_txtMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Warranty_claiming_details_txtMouseMoved
        Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        SubMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70

        Complaint_item_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_item_main_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));
        Complaint_service_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 4, 70)));

    }//GEN-LAST:event_Warranty_claiming_details_txtMouseMoved

    private void Warranty_claiming_details_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Warranty_claiming_details_txtMouseExited
        Warranty_claiming_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Warranty_claiming_details_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_Warranty_claiming_details_txtMouseExited

    private void Complaint_item_main_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_item_main_txtMouseClicked
        Complaint_item_main_panel.setVisible(true);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);


    }//GEN-LAST:event_Complaint_item_main_txtMouseClicked

    private void Complaint_item_mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_item_mainMouseClicked
        Complaint_item_main_panel.setVisible(true);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);


    }//GEN-LAST:event_Complaint_item_mainMouseClicked

    private void Complaint_serviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_serviceMouseClicked
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(true);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);


    }//GEN-LAST:event_Complaint_serviceMouseClicked

    private void Warranty_claiming_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Warranty_claiming_detailsMouseClicked

        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(true);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);


    }//GEN-LAST:event_Warranty_claiming_detailsMouseClicked

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);
    }//GEN-LAST:event_logoMouseClicked

    private void Complaint_service_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_service_txtMouseClicked
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(true);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);


    }//GEN-LAST:event_Complaint_service_txtMouseClicked

    private void Warranty_claiming_details_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Warranty_claiming_details_txtMouseClicked
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(true);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);


    }//GEN-LAST:event_Warranty_claiming_details_txtMouseClicked

    private void Complaint_item_mainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Complaint_item_mainMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Complaint_item_mainMouseEntered

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Do you want to go 'Home Page'", "Exit", dialog);
        if (result == 0) {
            // AddEmp home = new AddEmp();//venas karanna main home eke name ekata
            //home.setVisible(true);
            //this.dispose();
        }
//         TestHome home = new TestHome();
//         home.setVisible(true);
//         this.dispose();
    }//GEN-LAST:event_HomeMouseClicked

    private void selec_complitem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selec_complitem1ActionPerformed
        complitem = selec_complitem1.getSelectedItem().toString();
    }//GEN-LAST:event_selec_complitem1ActionPerformed

    //item main panel - item selection
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if (complitem.equals("Battery")) {
            //
            complaint_battery_jLabel52.setVisible(false);
            //
//            complaint_battery_jPanel6.setVisible(false);
//            complaint_battery_jPanel14.setVisible(false);
            complaint_battery_jButton20.setEnabled(false);
            complaint_battery_jButton21.setEnabled(false);

            Complaint_item_main_panel.setVisible(false);
            Complaint_service_panel.setVisible(false);
            Warranty_claiming_details_panel.setVisible(false);
            Claiming_battery_panel.setVisible(false);
            Claiming_tyre_panel.setVisible(false);
            Complaint_battery_panel.setVisible(true);
            Complaint_tyre_panel.setVisible(false);
            Warranty_check_service_panel.setVisible(false);
        } else if (complitem.equals("Tyre")) {
            //
            tyre_jLabel57.setVisible(false);

            Complaint_item_main_panel.setVisible(false);
            Complaint_service_panel.setVisible(false);
            Warranty_claiming_details_panel.setVisible(false);
            Claiming_battery_panel.setVisible(false);
            Claiming_tyre_panel.setVisible(false);
            Complaint_battery_panel.setVisible(false);
            Complaint_tyre_panel.setVisible(true);
            Warranty_check_service_panel.setVisible(false);
        }

    }//GEN-LAST:event_nextActionPerformed

    ///service complaint ASSIGN WARRANTY CHECK button
    private void service_complaint_jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_service_complaint_jButton4ActionPerformed

        long chkgap = ChkDay(service_nextServiceDate1);

        if (chkgap <= 0) {
            Complaint_item_main_panel.setVisible(false);
            Complaint_service_panel.setVisible(false);
            Warranty_claiming_details_panel.setVisible(false);
            Claiming_battery_panel.setVisible(false);
            Claiming_tyre_panel.setVisible(false);
            Complaint_battery_panel.setVisible(false);
            Complaint_tyre_panel.setVisible(false);
            Warranty_check_service_panel.setVisible(true);

            service_warrantycheck_jButton28.setEnabled(false);

            //fill warranty check details
            service_warrantycheck_jTextField73.setText(service_techNo);
            service_warrantycheck_jTextField74.setText(service_techName);

        } else {
            JOptionPane.showMessageDialog(this, "Service is due.Not eligible for warranty claiming.");
        }
    }//GEN-LAST:event_service_complaint_jButton4ActionPerformed

    //warranty claiming details battery REMOVE button
    private void warranty_claiming_details_jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jButton7ActionPerformed

        try {
            String sql = "delete from warranty_details_battery where battery_type=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, warranty_claiming_details_jLabel4.getText());

            pst.execute();
            //message
            JOptionPane.showMessageDialog(this, "Battery type successfully deleted.");

            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_warranty_claiming_details_jButton7ActionPerformed

    //warranty claiming details battry UPDATE button
    private void warranty_claiming_details_jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jButton8ActionPerformed
        
        String fs=warranty_claiming_details_jTextField15.getText();
        String emptys2=warranty_claiming_details_jTextField16.getText();
        String emptys3=warranty_claiming_details_jTextField14.getText();
        String emptys4=warranty_claiming_details_jTextField13.getText();
        String emptys5=warranty_claiming_details_jTextField17.getText(); 
        
        if(emptys2.isEmpty()|| emptys3.isEmpty()|| emptys4.isEmpty()|| emptys5.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        }
        else
        {
            if(fs.isEmpty())
            {
        boolean ck1 = isValidName(warranty_claiming_details_jTextField16.getText());
        boolean ck2 = isValidNum(warranty_claiming_details_jTextField14.getText());
        boolean ck3 = isValidNum(warranty_claiming_details_jTextField13.getText());
        boolean ck4 = isValidNum(warranty_claiming_details_jTextField17.getText());
        
        if (ck1 == true && ck2 == true && ck3 == true && ck4 == true)
        {
        try {
            String sql = "update warranty_details_battery set company=?,replacement_period=?,prorata_period=?,warranty_period=? where battery_type=?";
            pst = conn.prepareStatement(sql);

            pst.setString(1, warranty_claiming_details_jTextField16.getText());
            pst.setString(2, warranty_claiming_details_jTextField13.getText());
            pst.setString(3, warranty_claiming_details_jTextField17.getText());
            pst.setString(4, warranty_claiming_details_jTextField14.getText());
            pst.setString(5, warranty_claiming_details_jLabel4.getText());

            pst.execute();
            JOptionPane.showMessageDialog(this, "Details are successfully updated.");

            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

        }
            }
            else
            {
               JOptionPane.showMessageDialog(this, "Can't update Battry type!"); 
            }
        }
    }//GEN-LAST:event_warranty_claiming_details_jButton8ActionPerformed

    //warranty claiming details battry SERACH button
    private void warranty_claiming_details_jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jButton9ActionPerformed

        try {
            String sql = "select * from warranty_details_battery where battery_type=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, warranty_claiming_details_searchbattery.getSelectedItem().toString());

            rs = pst.executeQuery();

            if (rs.next()) {
                String s1 = rs.getString("company");
                warranty_claiming_details_jTextField16.setText(s1);
                String s2 = rs.getString("battery_type");
                warranty_claiming_details_jLabel4.setText(s2);
                String s3 = rs.getString("warranty_period");
                warranty_claiming_details_jTextField14.setText(s3);
                String s4 = rs.getString("replacement_period");
                warranty_claiming_details_jTextField13.setText(s4);
                String s5 = rs.getString("prorata_period");
                warranty_claiming_details_jTextField17.setText(s5);

            } else {
                JOptionPane.showMessageDialog(this, "Battery type is not found");
            }

            pst.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_warranty_claiming_details_jButton9ActionPerformed

    /////warranty cliaming details
    //warranty claiming details battery SAVE button
    private void warranty_claiming_details_jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jButton10ActionPerformed
        String emptys1=warranty_claiming_details_jTextField15.getText();
        String emptys2=warranty_claiming_details_jTextField16.getText();
        String emptys3=warranty_claiming_details_jTextField14.getText();
        String emptys4=warranty_claiming_details_jTextField13.getText();
        String emptys5=warranty_claiming_details_jTextField17.getText(); 
        
        if(emptys1.isEmpty() || emptys2.isEmpty()|| emptys3.isEmpty()|| emptys4.isEmpty()|| emptys5.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        }
        else
        {
        boolean ck1 = isValidName(warranty_claiming_details_jTextField16.getText());
        boolean ck2 = isValidNum(warranty_claiming_details_jTextField14.getText());
        boolean ck3 = isValidNum(warranty_claiming_details_jTextField13.getText());
        boolean ck4 = isValidNum(warranty_claiming_details_jTextField17.getText());

        String batt_type = warranty_claiming_details_jTextField15.getText();

        if (ck1 == true && ck2 == true && ck3 == true && ck4 == true) {
            //warranty_claiming_details_jLabel52.setVisible(false);
            String s = "select * from warranty_details_battery where battery_type='" + batt_type + "'";
            try {
                pst = conn.prepareStatement(s);
                rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Can't make new record.The battry type is allready exist.");
                } else {

                    String sql = "insert into warranty_details_battery"
                            + "(company,battery_type,warranty_period,replacement_period,prorata_period)"
                            + "values(?,?,?,?,?)";

                    try {
                        pst = conn.prepareStatement(sql);

                        pst.setString(1, warranty_claiming_details_jTextField16.getText());
                        pst.setString(2, warranty_claiming_details_jTextField15.getText());
                        pst.setString(3, warranty_claiming_details_jTextField14.getText());
                        pst.setString(4, warranty_claiming_details_jTextField13.getText());
                        pst.setString(5, warranty_claiming_details_jTextField17.getText());

                        pst.execute();
                        pst.close();
                        JOptionPane.showMessageDialog(this, "Details are successfully inserted.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                }

                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }

        } else if (ck1 == false) {
            //warranty_claiming_details_jLabel52.setVisible(true);
            JOptionPane.showMessageDialog(this, "Use uppercase & lowercase letters only for company name.");
        } else if (ck2 == false || ck3 == false || ck4 == false) {
            JOptionPane.showMessageDialog(this, "Use valid values only for enter months.");
        }

        }
    }//GEN-LAST:event_warranty_claiming_details_jButton10ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        Complaint_item_main_panel.setVisible(true);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    /////battery////
    //NEXT button if eligible for free replacement - battrey
    private void complaint_battery_jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaint_battery_jButton20ActionPerformed
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);

        Claiming_battery_panel.setVisible(true);

        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);

        //
        battery_claiming_jPanel8.setVisible(true);
        battery_claiming_jPanel7.setVisible(false);

        //display complaint id in claiming_battery panel-replacement
        battery_claiming_jTextField65.setText(battery_complId);

    }//GEN-LAST:event_complaint_battery_jButton20ActionPerformed

    //NEXT button if eligible for prorata claiming - battrey
    private void complaint_battery_jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaint_battery_jButton21ActionPerformed
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);

        Claiming_battery_panel.setVisible(true);

        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);

        //
        battery_claiming_jPanel8.setVisible(false);
        battery_claiming_jPanel7.setVisible(true);

        //display details in claiming_battery panel pro_rata
        battery_claiming_jTextField57.setText(battery_complId);
        battery_claiming_jTextField62.setText(battery_battType);

        //////
        double dbattery_serviceLife = Double.parseDouble(Integer.toString(battery_serviceLife));
        double dbattery_wrrPeriod = Double.parseDouble(battery_wrrPeriod);
        battery_claiming_discPecentage = (1.0 - (dbattery_serviceLife / dbattery_wrrPeriod)) * 100.0;

        battery_claiming_jTextField63.setText(new DecimalFormat(".##").format(battery_claiming_discPecentage));
        //battery_claiming_jTextField63.setText(Double.toString(battery_claiming_discPecentage));

        battery_claiming_jTextField60.setText(battery_soldPrice);
    }//GEN-LAST:event_complaint_battery_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(true);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(true);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        Complaint_item_main_panel.setVisible(true);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);
    }//GEN-LAST:event_jButton15ActionPerformed

    //ENTER WARRANTY CLAIMING button in complaint_tyre panel
    private void tyre_jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_jButton31ActionPerformed

        String c1 = tyre_jTextField25.getText();
        String c2 = ((JTextField) tyre_jDateChooser9.getDateEditor().getUiComponent()).getText();
        String c3 = tyre_jTextField81.getText();
        String c4 = tyre_jTextField88.getText();

        if (c1.isEmpty() || c2.isEmpty() || c3.isEmpty() || c4.isEmpty()) {
            JOptionPane
                    .showMessageDialog(this, "Please fill all fields.");
        } else {

            //
            tyre_complId = tyre_jTextField25.getText();

            tyre_compldate1 = tyre_jDateChooser9.getDate();
            tyre_complDate = ((JTextField) tyre_jDateChooser9.getDateEditor().getUiComponent()).getText();

            tyre_complType = "Tyre";

            tyre_dateGap = DayGap(tyre_saleDate1, tyre_compldate1);
            tyre_serviceLife = (int) (long) tyre_dateGap;

            if (tyre_serviceLife > Integer.parseInt(tyre_wrrPeriod))//checking the service life of the battery
            {
                JOptionPane.showMessageDialog(this, "Can't do warranty cliam process,service life is exeeded the warranty period!");
            } else {
                Complaint_item_main_panel.setVisible(false);
                Complaint_service_panel.setVisible(false);
                Warranty_claiming_details_panel.setVisible(false);
                Claiming_battery_panel.setVisible(false);
                Claiming_tyre_panel.setVisible(true);
                Complaint_battery_panel.setVisible(false);
                Complaint_tyre_panel.setVisible(false);
                Warranty_check_service_panel.setVisible(false);

                //fill tyre claiming refund panel
                tyre_claiming_jTextField95.setText(tyre_complId);
                tyre_claiming_jTextField97.setText(tyre_trType);
                tyre_claiming_jTextField98.setText(tyre_company);
                tyre_claiming_jTextField89.setText(tyre_wrrPeriod);
                tyre_claiming_jTextField91.setText(tyre_soldPrice);

                tyre_claiming_serviceLife = Integer.toString(tyre_serviceLife);
                tyre_claiming_jTextField94.setText(tyre_claiming_serviceLife);

                //fill tyre claiming replacement without refund
                tyre_claiming_jTextField107.setText(tyre_complId);
            }
        }

    }//GEN-LAST:event_tyre_jButton31ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(true);
        Warranty_check_service_panel.setVisible(false);
    }//GEN-LAST:event_jButton34ActionPerformed

    //tyre claiming replacement without refund DONE button
    private void tyre_claiming_jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_claiming_jButton38ActionPerformed

        tyre_claimType = "Replacement";
        tyre_eligibleStatus = 1;
        tyre_itemType = "Tyre";

        String check1 = tyre_claiming_jTextField100.getText();
        String check2 = tyre_claiming_jTextField103.getText();
        String check3 = tyre_claiming_jTextField104.getText();
        String check4 = ((JTextField) tyre_claiming_jDateChooser12.getDateEditor().getUiComponent()).getText();
        String check5 = ((JTextField) tyre_claiming_jDateChooser11.getDateEditor().getUiComponent()).getText();
        String check6 = tyre_claiming_jTextField99.getText();
        String check7 = tyre_claiming_jTextField101.getText();
        String check8 = tyre_claiming_jTextField105.getText();
        String check9 = tyre_claiming_jTextField102.getText();
        String check10 = tyre_invoice_re_jTextField13.getText();

        String id = tyre_claiming_jTextField99.getText();
        boolean a = isValidNameNum(id);
        String srlno = tyre_claiming_jTextField101.getText();
        boolean b = isValidNameNum(srlno);
        
        String invo=tyre_invoice_re_jTextField13.getText();
        boolean c=isValidComId(invo);

        if (check1.isEmpty() || check2.isEmpty() || check3.isEmpty() || check4.isEmpty() || check5.isEmpty() || check6.isEmpty() || check7.isEmpty() || check8.isEmpty() || check9.isEmpty() || check10.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        } else {
            if (a == false || b == false) {
                JOptionPane.showMessageDialog(this, "Please enter valid Item Id and Serial No.");
            }
            else if(c==false)
            {
                JOptionPane.showMessageDialog(this, "Please enter invoice number(only digits).");
            }
            else {
                int x = JOptionPane.showConfirmDialog(this, "Do you want to continue the process?");
                if (x == 0) {
                    //insert tyre complaint data to complaint_item table
                    try {
                        String s = "insert into complaint_item"
                                + "(complaint_id, complaint_date, customer_name, customer_id, vehicle_reg_no, customer_address, complaint_type, claim_type, eligible_status, item_type)"
                                + "values('" + tyre_complId + "','" + tyre_complDate + "','" + tyre_cusName + "','" + tyre_cusId + "','" + tyre_vRegNo + "','" + tyre_cusAddress + "','" + tyre_complType + "','" + tyre_claimType + "','" + tyre_eligibleStatus + "','" + tyre_itemType + "')";
                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                    //insert tyre complaint data to complaint_tyre table
                    try {
                        tyre_claiming_serviceLife = Integer.toString(tyre_serviceLife);

                        String s = "insert into complaint_tyre"
                                + "(item_id, type, date_of_sale, sold_price, serial_no, warranty_period, service_life, original_tire_depth, waste_tire_depth, complaint_id, company)"
                                + "values('" + tyre_itemId + "','" + tyre_trType + "','" + tyre_saleDate + "','" + tyre_soldPrice + "','" + tyre_srlNo + "','" + tyre_wrrPeriod + "','" + tyre_claiming_serviceLife + "','" + tyre_oriTyreDepth + "','" + tyre_wasteTyreDepth + "','" + tyre_complId + "','" + tyre_company + "')";
                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                    //insert tyre claiming replaced tyre data to replace_tyre table 
                    tyre_newReplacedDate = ((JTextField) tyre_claiming_jDateChooser11.getDateEditor().getUiComponent()).getText();
                    tyre_newSaleDate = ((JTextField) tyre_claiming_jDateChooser12.getDateEditor().getUiComponent()).getText();
                    try {
                        String s = "insert into replaced_tyre"
                                + "(complaint_id, item_id, date, serial_no, type, warranty_period, price, sp_price, date_of_sale, companny)"
                                + "values('" + tyre_complId + "','" + tyre_newItemId + "','" + tyre_newReplacedDate + "','" + tyre_newSrlNo + "','" + tyre_newType + "','" + tyre_newWrrPeriod + "','" + tyre_replacePrice + "','" + tyre_replaceSpPrice + "','" + tyre_newSaleDate + "','" + tyre_newCompany + "')";
                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                    //show message
                    JOptionPane.showMessageDialog(this, "Process is completed.");
                } else {
                    JOptionPane.showMessageDialog(this, "Process is cancelled!!");
                }
            }
        }
    }//GEN-LAST:event_tyre_claiming_jButton38ActionPerformed

    /////complaint battery/////
    //complaint_battery panel ENTER TO WARRANTY CLAIMING button

    private void complaint_battery_jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaint_battery_jButton18ActionPerformed

        String check1 = complaint_battery_jTextField45.getText();
        String check2 = ((JTextField) complaint_battery_jDateChooser1.getDateEditor().getUiComponent()).getText();
        String check3 = complaint_battery_jTextField35.getText();
        String check4 = complaint_battery_jTextField36.getText();
        if (check1.isEmpty() || check2.isEmpty() || check3.isEmpty() || check4.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        } else {
            battery_complId = complaint_battery_jTextField45.getText();
            battery_complDate = complaint_battery_jDateChooser1.getDate();
            battery_complDate1 = ((JTextField) complaint_battery_jDateChooser1.getDateEditor().getUiComponent()).getText();
            battery_complaint_type = "Battery";

            gap = DayGap(battery_saleDate, battery_complDate);
            battery_serviceLife = (int) (long) gap;

            if (battery_serviceLife > Integer.parseInt(battery_wrrPeriod))//checking the service life of the battery
            {
                JOptionPane.showMessageDialog(this, "Can't do warranty cliam process,service life is exeeded the warranty period!");
            } else {
                int x = JOptionPane.showConfirmDialog(this, "Do you want to continue the process?");
                if (x == 0) {
                    battery_eligibleStatus = 1;
                    battery_itemType = "Battery";

                    try {
                        //get data from sale_item table
                        String s = "select prorata_period,replacement_period from warranty_details_battery where battery_type='" + battery_battType + "'";

                        pst = conn.prepareStatement(s);
                        rs = pst.executeQuery();

                        if (rs.next()) {
                            prorata = rs.getInt("prorata_period");
                            replacement = rs.getInt("replacement_period");

                        }

                        if (battery_serviceLife <= replacement)//checking the warranty claiming type of the battery
                        {
//                        complaint_battery_jPanel6.setVisible(true);
//                        complaint_battery_jPanel14.setVisible(false);
                            complaint_battery_jButton20.setEnabled(true);
                            complaint_battery_jButton21.setEnabled(false);

                            battery_claimType = "Replacement";
                        } else {
//                        complaint_battery_jPanel14.setVisible(true);
//                        complaint_battery_jPanel6.setVisible(false);
                            complaint_battery_jButton20.setEnabled(false);
                            complaint_battery_jButton21.setEnabled(true);

                            battery_claimType = "Prorata";
                        }
                        //fill warranty claiming details panel
                        complaint_battery_jTextField51.setText(battery_complId);
                        complaint_battery_jTextField52.setText(battery_company);
                        complaint_battery_jTextField50.setText(battery_battType);
                        complaint_battery_jTextField49.setText(Integer.toString(battery_serviceLife));
                        complaint_battery_jTextField48.setText(battery_wrrPeriod);

                        pst.close();
                        rs.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                    //store data in complaint_item table
                    try {
                        String s = "insert into complaint_item"
                                + "(complaint_id, complaint_date, customer_name, customer_id, vehicle_reg_no, customer_address, complaint_type, claim_type, eligible_status, item_type)"
                                + "values('" + battery_complId + "','" + battery_complDate1 + "','" + battery_cusName + "','" + battery_cusId + "','" + battery_vRegNo + "','" + battery_cusAddress + "','" + battery_complaint_type + "','" + battery_claimType + "','" + battery_eligibleStatus + "','" + battery_itemType + "')";

                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                    //store data in complaint_battery table
                    battery_claiming_serviceLife = Integer.toString(battery_serviceLife);
                    try {
                        String s = "insert into complaint_battery"
                                + "(battery_type, service_life, complaint_id, item_id, warranty_period, company, sold_price, dateof_sale, serial_no)"
                                + "values('" + battery_battType + "','" + battery_claiming_serviceLife + "','" + battery_complId + "','" + battery_itemId + "','" + battery_wrrPeriod + "','" + battery_company + "','" + battery_soldPrice + "','" + battery_Date + "','" + srlNo + "')";
                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                    //
                } else {
                    JOptionPane.showMessageDialog(this, "Process is cancelled!!");
                }

            }
        }

//        }
//
//        }
    }//GEN-LAST:event_complaint_battery_jButton18ActionPerformed

    private void complaint_battery_jTextField36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaint_battery_jTextField36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_complaint_battery_jTextField36ActionPerformed

    //VIEW DETAILS button in complaint_battery panel
    //retrieve data from item_sale table to complaint_battry panel
    private void complaint_battery_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaint_battery_viewActionPerformed

        String comid=complaint_battery_jTextField45.getText();
        boolean chkcomid=isValidComId(comid);
        
        if(chkcomid==true)
        {
        tyre_srlNoWrrcard = tyre_jTextField81.getText();
        tyre_srlNoTyre = tyre_jTextField88.getText();
        ///////
        srlNoWarrantyCard = complaint_battery_jTextField35.getText();
        String srlNoBattery = complaint_battery_jTextField36.getText();

        if (srlNoWarrantyCard.isEmpty() || srlNoBattery.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please ENTER SERIAL NUMBER.");
        } 
        else 
        {
            if (srlNoWarrantyCard.equals(srlNoBattery)) 
            {
                complaint_battery_jLabel52.setVisible(false);

                //
                try {
                    String s1 = "Select * from item where SerialNo='" + srlNoWarrantyCard + "'";
                    pst = conn.prepareStatement(s1);
                    rs = pst.executeQuery();

                    if (rs.next()) 
                    {
                        battery_itemId = rs.getString("ItemCode");
                        battery_company = rs.getString("ManufactName");
                        battery_wrrPeriod = rs.getString("warranty_period");
                        battery_battType = rs.getString("Description");
                        String type=rs.getString("ExtDescription");
                        
                        rs.close();
                        pst.close();
        
                        if(type.equals("Battery"))
                        {
                        //
                        String s2 = "select * from sitem where ItemID='" + battery_itemId + "'";
                        try {
                            pst = conn.prepareStatement(s2);
                            rs = pst.executeQuery();

                            if (rs.next()) 
                            {
                                srlNo = complaint_battery_jTextField35.getText();//get serl no

                                battery_cusId = rs.getString("cus_id");
                                battery_soldPrice = rs.getString("Amount");
                                
                                battery_vRegNo = rs.getString("vehicle_reg_no");
                                                        
                                rs.close();
                                pst.close();
                                
                                //
                                try {
                                    String s3="select * from stransaction where ItemID='"+battery_itemId+"'";
                                    pst=conn.prepareStatement(s3);
                                    rs=pst.executeQuery();
                                    
                                    if(rs.next())
                                    {
                                        
//                                        battery_saleDate = rs.getDate("Date");
//                                        battery_Date = battery_saleDate.toString();
                                        battery_Date = rs.getString("Date");
                                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");            
                                        battery_saleDate = df.parse(battery_Date);
                                        battery_Date = df.format(battery_saleDate);

                                    }
                                } 
                                catch (Exception e) 
                                {
                                   JOptionPane.showMessageDialog(this, e); 
                                }
                                
                                //
                                try {
                                    String s4="select * from customer where CusId='"+battery_cusId+"'";
                                    pst=conn.prepareStatement(s4);
                                    rs=pst.executeQuery();
                                    
                                    if(rs.next())
                                    {
                                        battery_cusAddress = rs.getString("Address");
                                        battery_cusName = rs.getString("Name");
                                    }
                                    rs.close();
                                    pst.close();
                                } 
                                catch (Exception e) 
                                {
                                    JOptionPane.showMessageDialog(this, e);
                                }
 
                        complaint_battery_jTextField43.setText(battery_cusId);

                        complaint_battery_jTextField37.setText(battery_cusName);

                        complaint_battery_jTextField38.setText(battery_vRegNo);

                        complaint_battery_jTextField39.setText(battery_Date);

                        complaint_battery_jTextArea1.setText(battery_cusAddress);

                        complaint_battery_jTextField40.setText(battery_battType);

                        complaint_battery_jTextField46.setText(battery_company);

                        complaint_battery_jTextField47.setText(battery_itemId);

                        complaint_battery_jTextField41.setText(srlNoWarrantyCard);

                        complaint_battery_jTextField42.setText(battery_wrrPeriod);

                        complaint_battery_jTextField44.setText(battery_soldPrice);
                            } 
                            else 
                            {
                                JOptionPane.showMessageDialog(this, "Entered SERIAL NUMBER is dosn't exist!");
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, e);
                        }

                    }
                    else
                        {
                            JOptionPane.showMessageDialog(this, "Entered SERIAL NUMBER is dosn't exist!");
                        }
                    } 
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Entered SERIAL NUMBER is dosn't exist!");
                    }
                    rs.close();
                    pst.close();
                    
                } 
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(this, e);
                }

            } 
            else 
            {
                complaint_battery_jLabel52.setVisible(true);
            }

        }
        //////////////////////////////------------OLD CODE------------/////////////////////////////////
//        srlNoWarrantyCard = complaint_battery_jTextField35.getText();
//        String srlNoBattery = complaint_battery_jTextField36.getText();
//
//        if (srlNoWarrantyCard.isEmpty() || srlNoBattery.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter SERIAL NUMBERS.");
//        } 
//        else 
//        {
//            if (srlNoWarrantyCard.equals(srlNoBattery)) 
//            {
//                complaint_battery_jLabel52.setVisible(false);
//
//                //srlNo = complaint_battery_jTextField35.getText();
//                String sql = "select * from sale_item where serialno='" + srlNo + "'";
//                try {
//                    pst = conn.prepareStatement(sql);
//                    //pst.setString(1, srlNo);
//                    rs = pst.executeQuery();
//
//                    if (rs.next()) {
//                        battery_cusId = rs.getString("cus_id");
//                        complaint_battery_jTextField43.setText(battery_cusId);
//
//                        battery_cusName = rs.getString("cus_name");
//                        complaint_battery_jTextField37.setText(battery_cusName);
//
//                        battery_vRegNo = rs.getString("vehicle_reg_no");
//                        complaint_battery_jTextField38.setText(battery_vRegNo);
//
//                        battery_saleDate = rs.getDate("date_of_sale");
//                        battery_Date = battery_saleDate.toString();
//                        complaint_battery_jTextField39.setText(battery_Date);
//
//                        battery_cusAddress = rs.getString("customer_address");
//                        complaint_battery_jTextField13.setText(battery_cusAddress);
//
//                        battery_battType = rs.getString("battery_type");
//                        complaint_battery_jTextField40.setText(battery_battType);
//
//                        battery_company = rs.getString("company");
//                        complaint_battery_jTextField46.setText(battery_company);
//
//                        battery_itemId = rs.getString("item_id");
//                        complaint_battery_jTextField47.setText(battery_itemId);
//
//                        complaint_battery_jTextField41.setText(srlNoWarrantyCard);
//
//                        battery_wrrPeriod = rs.getString("warranty_period");
//                        complaint_battery_jTextField42.setText(battery_wrrPeriod);
//
//                        battery_soldPrice = rs.getString("sold_price");
//                        complaint_battery_jTextField44.setText(battery_soldPrice);
//
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Entered serial number is dosn't exist!");
//                    }
//
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(this, e);
//                }
//            } else {
//                complaint_battery_jLabel52.setVisible(true);
//            }
//        }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Please enter valid COMPLAINT ID(hint:check the invoice number).");
        }
    }//GEN-LAST:event_complaint_battery_viewActionPerformed

    private void battery_claiming_jTextField53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battery_claiming_jTextField53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_battery_claiming_jTextField53ActionPerformed

    /////battery claiming pannel
    //item id text box event-prorata battery
    private void battery_claiming_jTextField55KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_battery_claiming_jTextField55KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Enter was pressed

            String id = battery_claiming_jTextField55.getText();
            boolean a = isValidNameNum(id);

            if (a == false) {
                JOptionPane.showMessageDialog(this, "Please enter valid ITEM ID.");
            } else {
                try {
                    battery_claiming_itemIdPro = battery_claiming_jTextField55.getText();

                    String s = "select * from item where ItemCode='" + battery_claiming_itemIdPro + "'";

                    pst = conn.prepareStatement(s);
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        battery_claiming_battTypePro = rs.getString("Description");
                        battery_claiming_companyPro = rs.getString("ManufactName");
                        battery_claiming_srlNoPro = rs.getString("SerialNo");
                        battery_claiming_wrrPeriodPro = rs.getString("warranty_period");
                        battery_claiming_price = rs.getString("SuplierPri");

                        battery_claiming_jTextField54.setText(battery_claiming_battTypePro);
                        battery_claiming_jTextField64.setText(battery_claiming_companyPro);
                        battery_claiming_jTextField59.setText(battery_claiming_srlNoPro);
                        battery_claiming_jTextField53.setText(battery_claiming_wrrPeriodPro);
                        battery_claiming_jTextField56.setText(battery_claiming_price);

                        double dbattery_claiming_price = Double.parseDouble(battery_claiming_price);
                        double dbattery_claiming_spprice = dbattery_claiming_price * ((100.0 - battery_claiming_discPecentage) / 100.0);
                        battery_claiming_spprice = Double.toString(dbattery_claiming_spprice);

                        battery_claiming_jTextField61.setText(battery_claiming_spprice);
                    } else {
                        JOptionPane.showMessageDialog(this, "ITEM ID is not found.");
                    }
//                battery_claiming_jTextField54.setText(battery_claiming_battTypePro);
//                battery_claiming_jTextField64.setText(battery_claiming_companyPro);
//                battery_claiming_jTextField59.setText(battery_claiming_srlNoPro);
//                battery_claiming_jTextField53.setText(battery_claiming_wrrPeriodPro);
//                battery_claiming_jTextField56.setText(battery_claiming_price);
//
//                double dbattery_claiming_price = Double.parseDouble(battery_claiming_price);
//                double dbattery_claiming_spprice = dbattery_claiming_price * ((100.0 - battery_claiming_discPecentage) / 100.0);
//                battery_claiming_spprice = Double.toString(dbattery_claiming_spprice);
//
//                battery_claiming_jTextField61.setText(battery_claiming_spprice);

                    pst.close();
                    rs.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }

            }
        }
    }//GEN-LAST:event_battery_claiming_jTextField55KeyPressed

    /////battery claiming
    //serial no text box event-battery claiming prorata
    private void battery_claiming_jTextField59KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_battery_claiming_jTextField59KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Enter was pressed
            String srlno = battery_claiming_jTextField59.getText();
            boolean b = isValidNameNum(srlno);

            if (b == false) {
                JOptionPane.showMessageDialog(this, "Please enter valid SERIAL NUMBER.");
            } else {
                try {
                    battery_claiming_srlNoPro = battery_claiming_jTextField59.getText();

                    String s = "select * from item where SerialNO='" + battery_claiming_srlNoPro + "'";

                    pst = conn.prepareStatement(s);
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        battery_claiming_itemIdPro = rs.getString("ItemCode");
                        battery_claiming_battTypePro = rs.getString("Description");
                        battery_claiming_companyPro = rs.getString("ManufactName");
                        battery_claiming_wrrPeriodPro = rs.getString("warranty_period");
                        battery_claiming_price = rs.getString("SuplierPri");

                        battery_claiming_jTextField55.setText(battery_claiming_itemIdPro);
                        battery_claiming_jTextField54.setText(battery_claiming_battTypePro);
                        battery_claiming_jTextField64.setText(battery_claiming_companyPro);
                        battery_claiming_jTextField53.setText(battery_claiming_wrrPeriodPro);
                        battery_claiming_jTextField56.setText(battery_claiming_price);

                        double dbattery_claiming_price = Double.parseDouble(battery_claiming_price);
                        double dbattery_claiming_spprice = dbattery_claiming_price * ((100.0 - battery_claiming_discPecentage) / 100.0);
                        battery_claiming_spprice = Double.toString(dbattery_claiming_spprice);

                        battery_claiming_jTextField61.setText(battery_claiming_spprice);
                    } else {
                        JOptionPane.showMessageDialog(this, "SERIAL NUMBER is not found.");
                    }

////                battery_claiming_jTextField55.setText(battery_claiming_itemIdPro);
////                battery_claiming_jTextField54.setText(battery_claiming_battTypePro);
////                battery_claiming_jTextField64.setText(battery_claiming_companyPro);
////                battery_claiming_jTextField53.setText(battery_claiming_wrrPeriodPro);
////                battery_claiming_jTextField56.setText(battery_claiming_price);
////
////                double dbattery_claiming_price = Double.parseDouble(battery_claiming_price);
////                double dbattery_claiming_spprice = dbattery_claiming_price * ((100.0 - battery_claiming_discPecentage) / 100.0);
////                battery_claiming_spprice = Double.toString(dbattery_claiming_spprice);
////
////                battery_claiming_jTextField61.setText(battery_claiming_spprice);
                    pst.close();
                    rs.close();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }

            }
        }
    }//GEN-LAST:event_battery_claiming_jTextField59KeyPressed

    /////battery////
    //store prorata battery details 
    private void battery_claiming_jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battery_claiming_jButton23ActionPerformed

        String check1 = ((JTextField) battery_claiming_jDateChooser3.getDateEditor().getUiComponent()).getText();
        String check2 = ((JTextField) battery_claiming_jDateChooser4.getDateEditor().getUiComponent()).getText();
        String check3 = battery_claiming_jTextField13.getText();
        String check4 = battery_claiming_jTextField55.getText();
        String check5 = battery_claiming_jTextField59.getText();
        String check6 = battery_claiming_jTextField54.getText();
        String check7 = battery_claiming_jTextField64.getText();
        String check8 = battery_claiming_jTextField53.getText();
        String check9 = battery_claiming_jTextField56.getText();
        String check10 = battery_claiming_jTextField56.getText();

        String id = battery_claiming_jTextField55.getText();
        boolean a = isValidNameNum(id);

        String srlno = battery_claiming_jTextField59.getText();
        boolean b = isValidNameNum(srlno);
        
        String invo=tyre_invoice_re_jTextField13.getText();
        boolean c=isValidComId(invo);

        if (check1.isEmpty() || check2.isEmpty() || check3.isEmpty() || check4.isEmpty() || check5.isEmpty() || check6.isEmpty() || check7.isEmpty() || check8.isEmpty() || check9.isEmpty() || check10.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        } else {
            if (a == false || b == false) {
                JOptionPane.showMessageDialog(this, "Please enter valid Item Id and Serial No.");
            }
             else if(c==false)
            {
                JOptionPane.showMessageDialog(this, "Please enter invoice number(only digits).");
            }
            else {
                battery_claiming_complIdPro = battery_claiming_jTextField57.getText();
                battery_claiming_replacedDatePro = ((JTextField) battery_claiming_jDateChooser3.getDateEditor().getUiComponent()).getText();
                battery_claiming_saleDatePro = ((JTextField) battery_claiming_jDateChooser4.getDateEditor().getUiComponent()).getText();
                battery_claiming_discPecentagePro = Double.toString(battery_claiming_discPecentage);

                int x = JOptionPane.showConfirmDialog(this, "Do you want to confirm the process?");
                if (x == 0) {
                    try {
                        String s = "insert into prorata_battery"
                                + "(complaint_id, item_id, battery_type, serial_no, replaced_date, warranty_period, price, special_price, discount_percentage, date_of_sale, company)"
                                + "values('" + battery_claiming_complIdPro + "','" + battery_claiming_itemIdPro + "','" + battery_claiming_battTypePro + "','" + battery_claiming_srlNoPro + "','" + battery_claiming_replacedDatePro + "','" + battery_claiming_wrrPeriodPro + "','" + battery_claiming_price + "','" + battery_claiming_spprice + "','" + battery_claiming_discPecentagePro + "','" + battery_claiming_saleDatePro + "','" + battery_claiming_companyPro + "')";

                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                    //message
                    JOptionPane.showMessageDialog(this, "process is successfully completed.");
                } else {
                    JOptionPane.showMessageDialog(this, "process is cancelled!!");
                }
            }
        }

    }//GEN-LAST:event_battery_claiming_jButton23ActionPerformed

    //payment confirm battery claiming-prorata
    private void battery_claiming_jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battery_claiming_jButton6ActionPerformed

        String check1 = ((JTextField) battery_claiming_jDateChooser3.getDateEditor().getUiComponent()).getText();
        String check2 = ((JTextField) battery_claiming_jDateChooser4.getDateEditor().getUiComponent()).getText();
        String check3 = battery_claiming_jTextField13.getText();
        String check4 = battery_claiming_jTextField55.getText();
        String check5 = battery_claiming_jTextField59.getText();
        String check6 = battery_claiming_jTextField54.getText();
        String check7 = battery_claiming_jTextField64.getText();
        String check8 = battery_claiming_jTextField53.getText();
        String check9 = battery_claiming_jTextField56.getText();
        String check10 = battery_claiming_jTextField56.getText();

        String id = battery_claiming_jTextField55.getText();
        boolean a = isValidNameNum(id);

        String srlno = battery_claiming_jTextField59.getText();
        boolean b = isValidNameNum(srlno);

        String invo=tyre_invoice_re_jTextField13.getText();
        boolean c=isValidComId(invo);
        
        if (check1.isEmpty() || check2.isEmpty() || check3.isEmpty() || check4.isEmpty() || check5.isEmpty() || check6.isEmpty() || check7.isEmpty() || check8.isEmpty() || check9.isEmpty() || check10.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        } else {
            if (a == false || b == false) {
                JOptionPane.showMessageDialog(this, "Please enter valid Item Id and Serial No.");
            }
             else if(c==false)
            {
                JOptionPane.showMessageDialog(this, "Please enter invoice number(only digits).");
            }
            else {
                battery_claiming_invoice_no = battery_claiming_jTextField13.getText();
                battery_claiming_complIdPro = battery_claiming_jTextField57.getText();
                battery_claiming_saleDatePro = ((JTextField) battery_claiming_jDateChooser4.getDateEditor().getUiComponent()).getText();
                battery_claiming_complIdPro = battery_claiming_jTextField57.getText();

                int x = JOptionPane.showConfirmDialog(this, "Do you want to confirm?");
                if (x == 0) {
                    try {
                        String s = "insert into payment_battery"
                                + "(complant_id, complaint_type, item_id, battery_type, claim_type, serial_no, payment_date, amount, complaint_date, customer_name, customer_address, invoice_no)"
                                + "values('" + battery_claiming_complIdPro + "','" + battery_complaint_type + "','" + battery_claiming_itemIdPro + "','" + battery_claiming_battTypePro + "','" + battery_claimType + "','" + battery_claiming_srlNoPro + "','" + battery_claiming_saleDatePro + "','" + battery_claiming_spprice + "','" + battery_complDate1 + "','" + battery_cusName + "','" + battery_cusAddress + "','" + battery_claiming_invoice_no + "')";

                        pst = conn.prepareStatement(s);
                        pst.execute();

                        JOptionPane.showMessageDialog(this, "Payment is confirmed.");

                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cancelled!");
                }
            }
        }
    }//GEN-LAST:event_battery_claiming_jButton6ActionPerformed

    /////tyre
    //complaint tyre view details
    private void tyre_jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_jButton32ActionPerformed

        String comid=tyre_jTextField25.getText();
        boolean chkcomid=isValidComId(comid);
        
        if(chkcomid==true)
        {
        tyre_srlNoWrrcard = tyre_jTextField81.getText();
        tyre_srlNoTyre = tyre_jTextField88.getText();

        if (tyre_srlNoWrrcard.isEmpty() || tyre_srlNoTyre.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please ENTER SERIAL NUMBER.");
        } 
        else 
        {
            if (tyre_srlNoWrrcard.equals(tyre_srlNoTyre)) 
            {
                tyre_jLabel57.setVisible(false);

                //
                try {
                    String s1 = "Select * from item where SerialNo='" + tyre_srlNoWrrcard + "'";
                    pst = conn.prepareStatement(s1);
                    rs = pst.executeQuery();

                    if (rs.next()) 
                    {
                        tyre_itemId = rs.getString("ItemCode");
                        tyre_company = rs.getString("ManufactName");
                        tyre_wrrPeriod = rs.getString("warranty_period");
                        tyre_trType = rs.getString("Description");
                        String type=rs.getString("ExtDescription");
                        
                        rs.close();
                        pst.close();
        
                        if(type.equals("Tyre"))
                        {
                        //
                        String s2 = "select * from sitem where ItemID='" + tyre_itemId + "'";
                        try {
                            pst = conn.prepareStatement(s2);
                            rs = pst.executeQuery();

                            if (rs.next()) 
                            {
                                tyre_srlNo=tyre_jTextField81.getText();//get serl no

                                tyre_cusId = rs.getString("cus_id");
                                tyre_soldPrice = rs.getString("Amount");
                                
                                tyre_vRegNo = rs.getString("vehicle_reg_no");
                                
                                rs.close();
                                pst.close();
                                
                                //
                                try {
                                    String s3="select * from stransaction where ItemID='"+tyre_itemId+"'";
                                    pst=conn.prepareStatement(s3);
                                    rs=pst.executeQuery();
                                    
                                    if(rs.next())
                                    {
                                        //tyre_saleDate1 = rs.getDate("Date");
                                        //tyre_saleDate = tyre_saleDate1.toString();
                                        tyre_saleDate = rs.getString("Date");
                                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");            
                                        tyre_saleDate1 = df.parse(tyre_saleDate);
                                        tyre_saleDate = df.format(tyre_saleDate1);
                                    }
                                } 
                                catch (Exception e) 
                                {
                                   JOptionPane.showMessageDialog(this, e+"kkkk"); 
                                }
                                
                                //
                                try {
                                    String s4="select * from customer where CusId='"+tyre_cusId+"'";
                                    pst=conn.prepareStatement(s4);
                                    rs=pst.executeQuery();
                                    
                                    if(rs.next())
                                    {
                                        tyre_cusAddress = rs.getString("Address");
                                        tyre_cusName = rs.getString("Name");
                                    }
                                    rs.close();
                                    pst.close();
                                } 
                                catch (Exception e) 
                                {
                                    JOptionPane.showMessageDialog(this, e+"llll");
                                }
                                
                                //
                                try 
                                {
                                String s5="select * from warranty_details_tyre where type='"+tyre_trType+"'";
                                
                                pst=conn.prepareStatement(s5);
                                rs=pst.executeQuery();
                                
                                if(rs.next())
                                {
                                    tyre_oriTyreDepth = rs.getString("originaltyredepth");
                                }
                                
                                rs.close();
                                pst.close();
                                } 
                                catch (Exception e) 
                                {
                                    JOptionPane.showMessageDialog(this, e+"iiii");
                                }

                                tyre_jTextField28.setText(tyre_cusName);

                                tyre_jTextArea1.setText(tyre_cusAddress);

                                tyre_jTextField26.setText(tyre_vRegNo);
 
                                tyre_jTextField87.setText(tyre_saleDate);

                                tyre_jTextField83.setText(tyre_trType);

                                tyre_jTextField86.setText(tyre_cusId);
                                
                                tyre_jTextField27.setText(tyre_company);

                                tyre_jTextField30.setText(tyre_itemId);

                                tyre_jTextField84.setText(tyre_srlNo);

                                tyre_jTextField82.setText(tyre_wrrPeriod);

                                tyre_jTextField29.setText(tyre_oriTyreDepth);

                                tyre_jTextField85.setText(tyre_soldPrice);

                            } 
                            else 
                            {
                                JOptionPane.showMessageDialog(this, "Entered SERIAL NUMBER is dosn't exist!");
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, e+"uuuu");
                        }

                        }
                        else
                        {
                              JOptionPane.showMessageDialog(this, "Entered SERIAL NUMBER is dosn't exist!");  
                        }
                    } 
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Entered SERIAL NUMBER is dosn't exist!");
                    }
                    rs.close();
                    pst.close();
                    
                } 
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(this, e+"yyy");
                }

            } 
            else 
            {
                tyre_jLabel57.setVisible(true);
            }

        }

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Plese enter valid COMPLAINT ID(hint:look the invoice number).");
        }
    }//GEN-LAST:event_tyre_jButton32ActionPerformed

    private void tyre_claiming_jTextField95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_claiming_jTextField95ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyre_claiming_jTextField95ActionPerformed

    //tyre_claiming refund - tyre depth textbox event
    private void tyre_claiming_jTextField90KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tyre_claiming_jTextField90KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Enter was pressed

            String check = tyre_claiming_jTextField90.getText();
            boolean b = isValidTyreDepth(check);

            if (b == false) {
                JOptionPane.showMessageDialog(this, "Please enter valid tyre depth value.");
            } else {
                tyre_wasteTyreDepth = tyre_claiming_jTextField90.getText();

                try {
                    String s = "select * from warranty_details_tyre where type='" + tyre_trType + "'";
                    pst = conn.prepareStatement(s);
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        tax = rs.getString("tax");
                        claimPer = rs.getString("claim_amount");

                        double dtyre_refundableAmount;
                        double dtyre_taxAmount;
                        double dtyre_claimingAmount;

                        double dtyre_soldPrice = Double.parseDouble(tyre_soldPrice);
                        double dtyre_wasteTyreDepth = Double.parseDouble(tyre_wasteTyreDepth);
                        double dclaimPer = Double.parseDouble(claimPer);
                        double dtax = Double.parseDouble(tax);

                        dtyre_claimingAmount = dtyre_soldPrice - ((Double.parseDouble(tyre_oriTyreDepth) - dtyre_wasteTyreDepth) * dclaimPer);
                        tyre_claimingAmount = Double.toString(dtyre_claimingAmount);
                        tyre_claiming_jTextField92.setText(tyre_claimingAmount);

                        dtyre_taxAmount = dtyre_claimingAmount * (dtax / 100.0);
                        tyre_taxAmount = Double.toString(dtyre_taxAmount);
                        tyre_claiming_jTextField93.setText(tyre_taxAmount);

                        dtyre_refundableAmount = dtyre_claimingAmount - dtyre_taxAmount;
                        tyre_refundableAmount = Double.toString(dtyre_refundableAmount);
                        tyre_claiming_jTextField96.setText(tyre_refundableAmount);
                    }
//                double dtyre_refundableAmount;
//                double dtyre_taxAmount;
//                double dtyre_claimingAmount;
//
//                double dtyre_soldPrice = Double.parseDouble(tyre_soldPrice);
//                double dtyre_wasteTyreDepth = Double.parseDouble(tyre_wasteTyreDepth);
//                double dclaimPer = Double.parseDouble(claimPer);
//                double dtax = Double.parseDouble(tax);
//
//                dtyre_claimingAmount = dtyre_soldPrice - ((Double.parseDouble(tyre_oriTyreDepth) - dtyre_wasteTyreDepth) * dclaimPer);
//                tyre_claimingAmount = Double.toString(dtyre_claimingAmount);
//                tyre_claiming_jTextField92.setText(tyre_claimingAmount);
//
//                dtyre_taxAmount = dtyre_claimingAmount * (dtax / 100.0);
//                tyre_taxAmount = Double.toString(dtyre_taxAmount);
//                tyre_claiming_jTextField93.setText(tyre_taxAmount);
//
//                dtyre_refundableAmount = dtyre_claimingAmount - dtyre_taxAmount;
//                tyre_refundableAmount = Double.toString(dtyre_refundableAmount);
//                tyre_claiming_jTextField96.setText(tyre_refundableAmount);

                    pst.close();
                    rs.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }

            }

        }
    }//GEN-LAST:event_tyre_claiming_jTextField90KeyPressed

    //tyre claiming refund button
    private void tyre_claiming_jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_claiming_jButton35ActionPerformed

        tyre_refundDate = ((JTextField) tyre_claiming_jDateChooser10.getDateEditor().getUiComponent()).getText();
        tyre_claimType = "Refund";
        tyre_eligibleStatus = 1;
        tyre_itemType = "Tyre";

        String check1 = tyre_claiming_jTextField90.getText();
        String check2 = tyre_claiming_jTextField91.getText();
        String check3 = tyre_claiming_jTextField92.getText();
        String check4 = tyre_claiming_jTextField93.getText();
        String check5 = tyre_claiming_jTextField96.getText();
        String check6 = ((JTextField) tyre_claiming_jDateChooser10.getDateEditor().getUiComponent()).getText();
        String check7 = tyre_invoice_jTextField13.getText();

        String chk1 = tyre_claiming_jTextField90.getText();
        boolean a = isValidTyreDepth(chk1);
        String chk2=tyre_invoice_jTextField13.getText();
        boolean b=isValidComId(chk2);

        if (check1.isEmpty() || check2.isEmpty() || check3.isEmpty() || check4.isEmpty() || check5.isEmpty() || check6.isEmpty() || check7.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        } else {
            if (a == false ) 
            {
                JOptionPane.showMessageDialog(this, "Please enter valid tyre depth value.");
            } 
            else if( b==false)
            {
               JOptionPane.showMessageDialog(this, "Please enter invoice number(only digits)."); 
            }
            else {
                int x = JOptionPane.showConfirmDialog(this, "Do you want to continue the process?");
                if (x == 0) {
                    //insert tyre complaint data to complaint_item table
                    try {
                        String s = "insert into complaint_item"
                                + "(complaint_id, complaint_date, customer_name, customer_id, vehicle_reg_no, customer_address, complaint_type, claim_type, eligible_status, item_type)"
                                + "values('" + tyre_complId + "','" + tyre_complDate + "','" + tyre_cusName + "','" + tyre_cusId + "','" + tyre_vRegNo + "','" + tyre_cusAddress + "','" + tyre_complType + "','" + tyre_claimType + "','" + tyre_eligibleStatus + "','" + tyre_itemType + "')";
                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                    //insert tyre complaint data to complaint_tyre table
                    try {
                        tyre_claiming_serviceLife = Integer.toString(tyre_serviceLife);

                        String s = "insert into complaint_tyre"
                                + "(item_id, type, date_of_sale, sold_price, serial_no, warranty_period, service_life, original_tire_depth, waste_tire_depth, complaint_id, company)"
                                + "values('" + tyre_itemId + "','" + tyre_trType + "','" + tyre_saleDate + "','" + tyre_soldPrice + "','" + tyre_srlNo + "','" + tyre_wrrPeriod + "','" + tyre_claiming_serviceLife + "','" + tyre_oriTyreDepth + "','" + tyre_wasteTyreDepth + "','" + tyre_complId + "','" + tyre_company + "')";
                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                    //insert tyre climing details in to refund_tyre table 
                    tyre_invoiceNo = tyre_invoice_jTextField13.getText();
                    try {
                        String s = "insert into refund_tyre"
                                + "(complaint_id, tax_amount, refund_date, company, claiming_amount, invoice_no, refund_amount,type)"
                                + "values('" + tyre_complId + "','" + tyre_taxAmount + "','" + tyre_refundDate + "','" + tyre_company + "','" + tyre_claimingAmount + "','" + tyre_invoiceNo + "','" + tyre_refundableAmount + "','" + tyre_trType + "')";

                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                    //show success message
                    JOptionPane.showMessageDialog(this, "Successfully refunded.");
                } else {
                    JOptionPane.showMessageDialog(this, "Process is cancelled!!");
                }
            }
        }
    }//GEN-LAST:event_tyre_claiming_jButton35ActionPerformed

    private void tyre_claiming_jTextField102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_claiming_jTextField102ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyre_claiming_jTextField102ActionPerformed

    private void tyre_claiming_jTextField104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_claiming_jTextField104ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyre_claiming_jTextField104ActionPerformed

    /////tyre warranty claiming
    //claiming_tyre panel item id text box event
    private void tyre_claiming_jTextField99KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tyre_claiming_jTextField99KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Enter was pressed
            String check = tyre_claiming_jTextField96.getText();

            String id = tyre_claiming_jTextField99.getText();
            boolean b = isValidNameNum(id);

            if (check.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Waste Tyre Depth and PRESS ENTER.");
            } else {
                if (b == false) {
                    JOptionPane.showMessageDialog(this, "Please enter valid ITEM ID.");
                } else {
                    tyre_newItemId = tyre_claiming_jTextField99.getText();
                    try {
                        String s = "select * from item where ItemCode='" + tyre_newItemId + "'";
                        pst = conn.prepareStatement(s);
                        rs = pst.executeQuery();

                        if (rs.next()) {
                            tyre_newType = rs.getString("Description");
                            tyre_replacePrice = rs.getString("SuplierPri");
                            tyre_newCompany = rs.getString("ManufactName");
                            tyre_newSrlNo = rs.getString("SerialNo");
                            tyre_newWrrPeriod = rs.getString("warranty_period");

                            double dtyre_replaceSpPrice;
                            double dtyre_replacePrice = Double.parseDouble(tyre_replacePrice);
                            double dtyre_refundableAmount = Double.parseDouble(tyre_refundableAmount);
                            dtyre_replaceSpPrice = dtyre_replacePrice - dtyre_refundableAmount;
                            tyre_replaceSpPrice = Double.toString(dtyre_replaceSpPrice);

                            tyre_claiming_jTextField100.setText(tyre_newCompany);
                            tyre_claiming_jTextField103.setText(tyre_newType);
                            tyre_claiming_jTextField104.setText(tyre_newWrrPeriod);
                            tyre_claiming_jTextField101.setText(tyre_newSrlNo);
                            tyre_claiming_jTextField105.setText(tyre_replacePrice);
                            tyre_claiming_jTextField102.setText(tyre_replaceSpPrice);
                        } else {
                            JOptionPane.showMessageDialog(this, "Record is not found.");
                        }
//                    double dtyre_replaceSpPrice;
//                    double dtyre_replacePrice = Double.parseDouble(tyre_replacePrice);
//                    double dtyre_refundableAmount = Double.parseDouble(tyre_refundableAmount);
//                    dtyre_replaceSpPrice = dtyre_replacePrice - dtyre_refundableAmount;
//                    tyre_replaceSpPrice = Double.toString(dtyre_replaceSpPrice);
//
//                    tyre_claiming_jTextField100.setText(tyre_newCompany);
//                    tyre_claiming_jTextField103.setText(tyre_newType);
//                    tyre_claiming_jTextField104.setText(tyre_newWrrPeriod);
//                    tyre_claiming_jTextField101.setText(tyre_newSrlNo);
//                    tyre_claiming_jTextField105.setText(tyre_replacePrice);
//                    tyre_claiming_jTextField102.setText(tyre_replaceSpPrice);

                        pst.close();
                        rs.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }

                }
            }

        }
    }//GEN-LAST:event_tyre_claiming_jTextField99KeyPressed

    /////tyre warranty claiming
    //claiming_tyre panel serial no text box event
    private void tyre_claiming_jTextField101KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tyre_claiming_jTextField101KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Enter was pressed

            String srlno = tyre_claiming_jTextField101.getText();
            boolean b = isValidNameNum(srlno);

            String check = tyre_claiming_jTextField96.getText();

            if (check.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Plese enter Waste Tyre Depth and PRESS ENTER.");
            } else {
                if (b == false) {
                    JOptionPane.showMessageDialog(this, "Please enter valid SERIAL NUMBER.");
                } else {
                    tyre_newSrlNo = tyre_claiming_jTextField101.getText();
                    try {
                        String s = "select * from item where SerialNo='" + tyre_newSrlNo + "'";
                        pst = conn.prepareStatement(s);
                        rs = pst.executeQuery();

                        if (rs.next()) {
                            tyre_newType = rs.getString("Description");
                            tyre_replacePrice = rs.getString("SuplierPri");
                            tyre_newCompany = rs.getString("ManufactName");
                            tyre_newItemId = rs.getString("ItemCode");
                            tyre_newWrrPeriod = rs.getString("warranty_period");

                            double dtyre_replaceSpPrice;
                            double dtyre_replacePrice = Double.parseDouble(tyre_replacePrice);
                            double dtyre_refundableAmount = Double.parseDouble(tyre_refundableAmount);
                            dtyre_replaceSpPrice = dtyre_replacePrice - dtyre_refundableAmount;
                            tyre_replaceSpPrice = Double.toString(dtyre_replaceSpPrice);

                            tyre_claiming_jTextField100.setText(tyre_newCompany);
                            tyre_claiming_jTextField103.setText(tyre_newType);
                            tyre_claiming_jTextField104.setText(tyre_newWrrPeriod);
                            tyre_claiming_jTextField99.setText(tyre_newItemId);
                            tyre_claiming_jTextField105.setText(tyre_replacePrice);
                            tyre_claiming_jTextField102.setText(tyre_replaceSpPrice);
                        } else {
                            JOptionPane.showMessageDialog(this, "Record is not found.");
                        }
//                    double dtyre_replaceSpPrice;
//                    double dtyre_replacePrice = Double.parseDouble(tyre_replacePrice);
//                    double dtyre_refundableAmount = Double.parseDouble(tyre_refundableAmount);
//                    dtyre_replaceSpPrice = dtyre_replacePrice - dtyre_refundableAmount;
//                    tyre_replaceSpPrice = Double.toString(dtyre_replaceSpPrice);
//
//                    tyre_claiming_jTextField100.setText(tyre_newCompany);
//                    tyre_claiming_jTextField103.setText(tyre_newType);
//                    tyre_claiming_jTextField104.setText(tyre_newWrrPeriod);
//                    tyre_claiming_jTextField99.setText(tyre_newItemId);
//                    tyre_claiming_jTextField105.setText(tyre_replacePrice);
//                    tyre_claiming_jTextField102.setText(tyre_replaceSpPrice);

                        pst.close();
                        rs.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                }
            }

        }
    }//GEN-LAST:event_tyre_claiming_jTextField101KeyPressed

    //claiming tyre replacement without refund PAYMENT CONFIRM button
    private void tyre_claiming_jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_claiming_jButton37ActionPerformed

        tyre_newSaleDate = ((JTextField) tyre_claiming_jDateChooser12.getDateEditor().getUiComponent()).getText();
        tyre_newinvoiceNo = tyre_invoice_re_jTextField13.getText();

        String check1 = tyre_claiming_jTextField100.getText();
        String check2 = tyre_claiming_jTextField103.getText();
        String check3 = tyre_claiming_jTextField104.getText();
        String check4 = ((JTextField) tyre_claiming_jDateChooser12.getDateEditor().getUiComponent()).getText();
        String check5 = ((JTextField) tyre_claiming_jDateChooser11.getDateEditor().getUiComponent()).getText();
        String check6 = tyre_claiming_jTextField99.getText();
        String check7 = tyre_claiming_jTextField101.getText();
        String check8 = tyre_claiming_jTextField105.getText();
        String check9 = tyre_claiming_jTextField102.getText();
        String check10 = tyre_invoice_re_jTextField13.getText();

        String id = tyre_claiming_jTextField99.getText();
        boolean a = isValidNameNum(id);
        String srlno = tyre_claiming_jTextField101.getText();
        boolean b = isValidNameNum(srlno);
        
        String invo=tyre_invoice_re_jTextField13.getText();
        boolean c=isValidComId(invo);

        if (check1.isEmpty() || check2.isEmpty() || check3.isEmpty() || check4.isEmpty() || check5.isEmpty() || check6.isEmpty() || check7.isEmpty() || check8.isEmpty() || check9.isEmpty() || check10.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        } else {
            if (a == false || b == false) {
                JOptionPane.showMessageDialog(this, "Please enter valid Item Id and Serial No.");
            }
            else if(c==false)
            {
                JOptionPane.showMessageDialog(this, "Please enter invoice number(only digits).");
            }
            else {
                int x = JOptionPane.showConfirmDialog(this, "Do yo want to confirm the payment?");
                if (x == 0) {
                    try {
                        String s = "insert into payment_tyre"
                                + "(complaint_id, amount, date, complaint_type, complaint_date, item_id, tyre_type, serial_no, cusname, cus_address, invoice_no)"
                                + "values('" + tyre_complId + "','" + tyre_replaceSpPrice + "','" + tyre_newSaleDate + "','" + tyre_complType + "','" + tyre_complDate + "','" + tyre_newItemId + "','" + tyre_newType + "','" + tyre_newSrlNo + "','" + tyre_cusName + "','" + tyre_cusAddress + "','" + tyre_newinvoiceNo + "')";

                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();
                        //message
                        JOptionPane.showMessageDialog(this, "Payment confirmed.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                }
            }
        }
    }//GEN-LAST:event_tyre_claiming_jButton37ActionPerformed

    /////services/////
    //service_complaint panel VIEW JOB DETAILS button
    private void service_complaint_jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_service_complaint_jButton5ActionPerformed

        service_jobNo = service_complaint_jTextField5.getText();

        try {
            String s1 = "select * from final_job_table where jid='" + service_jobNo + "'";
            pst = conn.prepareStatement(s1);
            rs = pst.executeQuery();

            if (rs.next()) {
                sevice_cusId = rs.getString("cusID");
                service_vRegNo = rs.getString("reg_no");
                service_techNo = rs.getString("eid");
                service_cusName = rs.getString("name");
                
                service_jobDate1 = rs.getDate("date");
                service_jobDate = service_jobDate1.toString();
                
                rs.close();
                pst.close();
                //
                try {
                    String s2="select * from emp_details where Emp_ID='"+sevice_cusId+"'";
                    pst=conn.prepareStatement(s2);
                    rs=pst.executeQuery();
                    
                    if(rs.next())
                    {
                        String service_FtechName = rs.getString("Fname");
                        String service_MtechName = rs.getString("Mname");
                        String service_LtechName = rs.getString("Lname");
                        
                        service_techName=service_FtechName+" "+service_MtechName+" "+service_LtechName;
                    }
                } 
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(this, e);
                }

/////                service_cusAddress = rs.getString("cusaddress");

                service_complaint_jTextField7.setText(service_cusName);
                
                service_complaint_jTextField8.setText(sevice_cusId);
                
                service_complaint_jTextField6.setText(service_vRegNo);

                service_complaint_jTextField10.setText(service_techNo);

                service_complaint_jTextField11.setText(service_jobDate);
                
                service_complaint_jTextField9.setText(service_techName);

                //
                String [] dateParts = service_jobDate.split("-");
                String year = dateParts[0];
                String month= dateParts[1];
                String day = dateParts[2];

                int newyear=(Integer.parseInt(year))+1;
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");            
                service_nextServiceDate1 = df.parse(newyear+"-"+month+"-"+day);
                service_nextServiceDate = df.format(service_nextServiceDate1);
                System.out.println(newyear+"-"+month+"-"+day);
                
                service_complaint_jTextField12.setText(service_nextServiceDate);

            }
            else
            {
                JOptionPane.showMessageDialog(this, "Entered JOB ID is not in records.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_service_complaint_jButton5ActionPerformed

    //service warranty check radio button1
    private void warrantycheck_jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warrantycheck_jRadioButton1ActionPerformed
        service_warrantycheck_eligibleStatus = 1;
        if (warrantycheck_jRadioButton1.isSelected()) {
            warrantycheck_jRadioButton3.setSelected(false);
        }
    }//GEN-LAST:event_warrantycheck_jRadioButton1ActionPerformed

    //service warranty check radio button2
    private void warrantycheck_jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warrantycheck_jRadioButton3ActionPerformed
        service_warrantycheck_eligibleStatus = 0;
        if (warrantycheck_jRadioButton3.isSelected()) {
            warrantycheck_jRadioButton1.setSelected(false);
        }
    }//GEN-LAST:event_warrantycheck_jRadioButton3ActionPerformed

    //service warranty check NEXT button
    private void service_warrantycheck_jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_service_warrantycheck_jButton27ActionPerformed
        String idcheck = service_warrantycheck_jTextField72.getText();
        String checkDate = ((JTextField) service_warrantycheck_jDateChooser6.getDateEditor().getUiComponent()).getText();

        String id=service_warrantycheck_jTextField72.getText();
        boolean a=isValidComId(id);
        
        if(a==false)
        {
            JOptionPane.showMessageDialog(this, "Please insert Complaint id(hint:use the invoice no).");
        }
        else
        {
        if (idcheck.isEmpty() || checkDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all entries.");
        } else {

            if (service_warrantycheck_eligibleStatus == 1) {
                service_warrantycheck_jButton28.setEnabled(true);

                service_complId = service_warrantycheck_jTextField72.getText();
                service_newTechNo = service_warrantycheck_jTextField73.getText();
                service_newTechName = service_warrantycheck_jTextField74.getText();
                service_claimCheckDate = ((JTextField) service_warrantycheck_jDateChooser6.getDateEditor().getUiComponent()).getText();

                //fill warranty claim details side
                service_warrantycheck_jTextField75.setText(service_complId);
                service_warrantycheck_jTextField76.setText(service_newTechNo);
                service_warrantycheck_jTextField77.setText(service_newTechName);

                //store warranty check details in to complaint_service table
                try {
                    String s = "insert into complaint_service"
                            + "(complaint_id,job_no,eligible_status,job_date,cusid,cusname,cus_address,techid,techname,next_service_date,vehicle_reg_no)"
                            + "values('" + service_complId + "','" + service_jobNo + "','" + service_warrantycheck_eligibleStatus + "','" + service_jobDate + "','" + sevice_cusId + "','" + service_cusName + "','" + service_cusAddress + "','" + service_newTechNo + "','" + service_newTechName + "','" + service_nextServiceDate + "','" + service_vRegNo + "')";
                    pst = conn.prepareStatement(s);
                    pst.execute();

                    pst.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }

                //store warranty check details in to warranty_check_details table
                try {
                    String s = "insert into warranty_check_details"
                            + "(complaint_id, tech_id, tech_name, eligible_status, date)"
                            + "values('" + service_complId + "','" + service_newTechNo + "','" + service_newTechName + "','" + service_warrantycheck_eligibleStatus + "','" + service_claimCheckDate + "')";
                    pst = conn.prepareStatement(s);
                    pst.execute();

                    pst.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }

                //message
                JOptionPane.showMessageDialog(this, "Process is successfully completed.");
            } else {
                JOptionPane.showMessageDialog(this, "This vehicle not eligible for free warranty claim service.");
            }
        }
        
        }
    }//GEN-LAST:event_service_warrantycheck_jButton27ActionPerformed

    //service warranty check details CONFIRM button
    private void service_warrantycheck_jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_service_warrantycheck_jButton28ActionPerformed

        String ClaimServiceDate = ((JTextField) service_warrantycheck_jDateChooser7.getDateEditor().getUiComponent()).getText();
        String ClaimServiceNextDate = ((JTextField) service_warrantycheck_jDateChooser8.getDateEditor().getUiComponent()).getText();
        String ClaimServiceFullCost = service_warrantycheck_jTextField78.getText();;
        String warrantyClaimServiceDisc = service_warrantycheck_jTextField79.getText();

        boolean a=isValidCost(ClaimServiceFullCost);
        boolean b=isValidCost(warrantyClaimServiceDisc);
        
        if(a==false)
        {
            JOptionPane.showMessageDialog(this, "Plese insert full service cost(hint: 0000.00).");
        }
        else if(b==false)
        {
            JOptionPane.showMessageDialog(this, "Plese insert full discount amount(hint: 0000.00).");
        }
        else
        {
        if (ClaimServiceDate.isEmpty() || ClaimServiceNextDate.isEmpty() || ClaimServiceFullCost.isEmpty() || warrantyClaimServiceDisc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese fill relevent fields.");
        } else {
            int x = JOptionPane.showConfirmDialog(this, "Do you want to continue the process?");
            if (x == 0) {
                try {
                    service_warrantyClaimServiceDate = ((JTextField) service_warrantycheck_jDateChooser7.getDateEditor().getUiComponent()).getText();
                    service_warrantyClaimServiceNextDate = ((JTextField) service_warrantycheck_jDateChooser8.getDateEditor().getUiComponent()).getText();

                    service_warrantyClaimServiceFullCost = service_warrantycheck_jTextField78.getText();
                    service_warrantyClaimServiceDisc = service_warrantycheck_jTextField79.getText();

                    double dservice_warrantyClaimServiceFullCost = Double.parseDouble(service_warrantyClaimServiceFullCost);
                    double dservice_warrantyClaimServiceDisc = Double.parseDouble(service_warrantyClaimServiceDisc);
                    double dservice_warrantyClaimServiceFinalCost = dservice_warrantyClaimServiceFullCost - dservice_warrantyClaimServiceDisc;
                    service_warrantyClaimServiceFinalCost = Double.toString(dservice_warrantyClaimServiceFinalCost);

                    service_warrantycheck_jTextField80.setText(service_warrantyClaimServiceFinalCost);

                    //store warranty claim service data to warranty_claim_service table
                    String s = "insert into warranty_claim_service"
                            + "(complaint_id,date,full_service_cost,discount,final_cost,next_service_date)"
                            + "values('" + service_complId + "','" + service_warrantyClaimServiceDate + "','" + service_warrantyClaimServiceFullCost + "','" + service_warrantyClaimServiceDisc + "','" + service_warrantyClaimServiceFinalCost + "','" + service_warrantyClaimServiceNextDate + "')";
                    pst = conn.prepareStatement(s);
                    pst.execute();

                    pst.close();

                    //message
                    JOptionPane.showMessageDialog(this, "Process is successfully confirmed.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Process is cancelled!!");
            }

        }
        
        }
    }//GEN-LAST:event_service_warrantycheck_jButton28ActionPerformed

    //warranty climing details battery CLEAR button
    private void warranty_claiming_details_jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jButton2ActionPerformed

        warranty_claiming_details_jTextField16.setText("");
        warranty_claiming_details_jTextField15.setText("");
        warranty_claiming_details_jTextField14.setText("");
        warranty_claiming_details_jTextField13.setText("");
        warranty_claiming_details_jTextField17.setText("");
    }//GEN-LAST:event_warranty_claiming_details_jButton2ActionPerformed

    //warranty claiming details tyre CLEAR button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        warranty_claiming_details_jTextField21.setText("");
        warranty_claiming_details_jTextField19.setText("");
        warranty_claiming_details_jTextField20.setText("");
        warranty_claiming_details_jTextField23.setText("");
        warranty_claiming_details_jTextField22.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    //warranty claiming details tyre SAVE button
    private void warranty_claiming_details_jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jButton13ActionPerformed

        String emptys1=warranty_claiming_details_jTextField19.getText();
        String emptys2=warranty_claiming_details_jTextField20.getText();
        String emptys3=warranty_claiming_details_jTextField21.getText();
        String emptys4=warranty_claiming_details_jTextField23.getText();
        String emptys5=warranty_claiming_details_jTextField22.getText();
        
        if(emptys1.isEmpty() || emptys2.isEmpty()|| emptys3.isEmpty()|| emptys4.isEmpty()|| emptys5.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        }
        else
        {
        boolean ck1 = isValidName(warranty_claiming_details_jTextField19.getText());
        boolean ck2 = isValidNum(warranty_claiming_details_jTextField20.getText());
        boolean ck3=isValidFloat(warranty_claiming_details_jTextField23.getText());
        boolean ck4=isValidNum(warranty_claiming_details_jTextField22.getText());
        
        String tyre_type = warranty_claiming_details_jTextField21.getText();

        if (ck1 == true && ck2 == true && ck3==true && ck4==true) {
            //warranty_claiming_details_jLabel52.setVisible(false);
            try {
                String s = "select * from warranty_details_tyre where type='" + tyre_type + "'";
                pst = conn.prepareStatement(s);
                rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Can't make new record.The battry type is allready exist.");
                } else {
                    String sql = "insert into warranty_details_tyre"
                            + "(company,type,warranty_period,tax,claim_amount)"
                            + "values(?,?,?,?,?)";

                    try {
                        pst = conn.prepareStatement(sql);

                        pst.setString(1, warranty_claiming_details_jTextField19.getText());
                        pst.setString(2, warranty_claiming_details_jTextField21.getText());
                        pst.setString(3, warranty_claiming_details_jTextField20.getText());
                        pst.setString(4, warranty_claiming_details_jTextField23.getText());
                        pst.setString(5, warranty_claiming_details_jTextField22.getText());

                        pst.execute();
                        pst.close();
                        //message
                        JOptionPane.showMessageDialog(this, "Details are successfully inserted.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                }

                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }

        } else if (ck1 == false) {
            
            JOptionPane.showMessageDialog(this, "Use uppercase & lowercase letters only for company name.");
        } else if (ck2 == false) {
            JOptionPane.showMessageDialog(this, "Use valid numbers only for enter months.");
        }
        else if (ck3 == false) {
            JOptionPane.showMessageDialog(this, "Enter correct amount(hint:Rs.800.00).");
        }
        else if (ck4 == false) {
            JOptionPane.showMessageDialog(this, "Enter correct tax percentage(0-99).");
        }
        
        }
    }//GEN-LAST:event_warranty_claiming_details_jButton13ActionPerformed

    //warranty claiming details tyre UPDATE button
    private void warranty_claiming_details_jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jButton12ActionPerformed

        String fs=warranty_claiming_details_jTextField21.getText();
        String emptys1=warranty_claiming_details_jTextField19.getText();
        String emptys2=warranty_claiming_details_jTextField20.getText();
        String emptys4=warranty_claiming_details_jTextField23.getText();
        String emptys5=warranty_claiming_details_jTextField22.getText();
        
        if(emptys1.isEmpty() || emptys2.isEmpty() || emptys4.isEmpty()|| emptys5.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        }
        else
        {
            if(fs.isEmpty())
            {
                boolean ck1 = isValidName(warranty_claiming_details_jTextField19.getText());
                boolean ck2 = isValidNum(warranty_claiming_details_jTextField20.getText());
                boolean ck3=isValidFloat(warranty_claiming_details_jTextField23.getText());
                boolean ck4=isValidNum(warranty_claiming_details_jTextField22.getText());
                
                if(ck1 == true && ck2 == true && ck3==true && ck4==true)
                {
        try {
            String sql = "update warranty_details_tyre set company=?,warranty_period=?,tax=?,claim_amount=? where type=?";
            pst = conn.prepareStatement(sql);

            pst.setString(1, warranty_claiming_details_jTextField19.getText());
            pst.setString(2, warranty_claiming_details_jTextField20.getText());
            pst.setString(3, warranty_claiming_details_jTextField22.getText());
            pst.setString(4, warranty_claiming_details_jTextField23.getText());
            pst.setString(5, warranty_claiming_details_jLabel4tyre.getText());

            pst.execute();
            //message
            JOptionPane.showMessageDialog(this, "Details are successfully updated.");

            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
                }
        else if (ck1 == false) {
            
            JOptionPane.showMessageDialog(this, "Use uppercase & lowercase letters only for company name.");
        } 
        else if (ck2 == false) {
            JOptionPane.showMessageDialog(this, "Use valid numbers only for enter months.");
        }
        else if (ck3 == false) {
            JOptionPane.showMessageDialog(this, "Enter correct amount(hint:Rs.800.00).");
        }
        else if (ck4 == false) {
            JOptionPane.showMessageDialog(this, "Enter correct tax percentage.");
        }                
            }
            else
            {
               JOptionPane.showMessageDialog(this, "Can't update the battery type."); 
            }
        }
    }//GEN-LAST:event_warranty_claiming_details_jButton12ActionPerformed

    //warranty claiming details tyre REMOVE button
    private void warranty_claiming_details_jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jButton11ActionPerformed

        try {
            String sql = "delete from warranty_details_tyre where type=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, warranty_claiming_details_jLabel4tyre.getText());

            pst.execute();
            //message
            JOptionPane.showMessageDialog(this, "Claiming details of selected tyre type successfully deleted.");

            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_warranty_claiming_details_jButton11ActionPerformed

    //warranty details tyre SEARCH button
    private void warranty_claiming_details_jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jButton14ActionPerformed

        try {
            String sql = "select * from warranty_details_tyre where type=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, warranty_claiming_details_jComboBox1.getSelectedItem().toString());

            rs = pst.executeQuery();

            if (rs.next()) {
                String s1 = rs.getString("company");
                warranty_claiming_details_jTextField19.setText(s1);
                String s2 = rs.getString("type");
                warranty_claiming_details_jLabel4tyre.setText(s2);
                String s3 = rs.getString("warranty_period");
                warranty_claiming_details_jTextField20.setText(s3);
                String s4 = rs.getString("tax");
                warranty_claiming_details_jTextField22.setText(s4);
                String s5 = rs.getString("claim_amount");
                warranty_claiming_details_jTextField23.setText(s5);

            } else {
                JOptionPane.showMessageDialog(this, "Battery type is not found");
            }

            pst.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_warranty_claiming_details_jButton14ActionPerformed

    private void tyre_claiming_jTextField92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_claiming_jTextField92ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyre_claiming_jTextField92ActionPerformed

    private void tyre_claiming_jTextField99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyre_claiming_jTextField99ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyre_claiming_jTextField99ActionPerformed

    private void warranty_claiming_details_jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warranty_claiming_details_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warranty_claiming_details_jTextField16ActionPerformed

    private void battery_claiming_jTextField69KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_battery_claiming_jTextField69KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_battery_claiming_jTextField69KeyTyped

    //item_id text box event-battery replacement
    private void battery_claiming_jTextField69KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_battery_claiming_jTextField69KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Enter was pressed

            String id = battery_claiming_jTextField69.getText();
            boolean a = isValidNameNum(id);

            try {
                String s = "select * from item where ItemCode='" + id + "'";
                pst = conn.prepareStatement(s);
                rs = pst.executeQuery();

                if (rs.next()) {
                    if (a == false) {
                        JOptionPane.showMessageDialog(this, "Please enter valid Item Id.");
                    } else {
                        rs.close();
                        pst.close();

                        try {
                            battery_claiming_itemId = battery_claiming_jTextField69.getText();

                            String s2 = "select * from item where ItemCode='" + battery_claiming_itemId + "'";

                            pst = conn.prepareStatement(s2);
                            rs = pst.executeQuery();

                            if (rs.next()) {
                                battery_claiming_battType = rs.getString("Description");
                                battery_claiming_company = rs.getString("ManufactName");
                                battery_claiming_srlNo = rs.getString("SerialNo");
                                battery_claiming_wrrPeriod = rs.getString("warranty_period");

                                battery_claiming_jTextField71.setText(battery_claiming_battType);
                                battery_claiming_jTextField66.setText(battery_claiming_company);
                                battery_claiming_jTextField67.setText(battery_claiming_srlNo);
                                battery_claiming_jTextField70.setText(battery_claiming_wrrPeriod);
                            } else {
                                JOptionPane.showMessageDialog(this, "Record is not found!");
                            }
                            //                battery_claiming_jTextField71.setText(battery_claiming_battType);
                            //                battery_claiming_jTextField66.setText(battery_claiming_company);
                            //                battery_claiming_jTextField67.setText(battery_claiming_srlNo);
                            //                battery_claiming_jTextField70.setText(battery_claiming_wrrPeriod);

                            pst.close();
                            rs.close();

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, e);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No such a ITEM CODE!!");
                }

            } catch (Exception e) {

            }

        }

    }//GEN-LAST:event_battery_claiming_jTextField69KeyPressed

    private void battery_claiming_jTextField69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battery_claiming_jTextField69ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_battery_claiming_jTextField69ActionPerformed

    /////battery/////
    //store the battery free replacement data
    private void battery_claiming_jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battery_claiming_jButton25ActionPerformed

        String check1 = ((JTextField) battery_claiming_jDateChooser5.getDateEditor().getUiComponent()).getText();
        String check2 = ((JTextField) battery_claiming_jDateChooser2.getDateEditor().getUiComponent()).getText();
        String check3 = battery_claiming_jTextField69.getText();
        String check4 = battery_claiming_jTextField67.getText();
        String check5 = battery_claiming_jTextField71.getText();
        String check6 = battery_claiming_jTextField66.getText();
        String check7 = battery_claiming_jTextField70.getText();

        String id = battery_claiming_jTextField69.getText();
        boolean a = isValidNameNum(id);

        String srlno = battery_claiming_jTextField67.getText();
        boolean b = isValidNameNum(srlno);

        if (check1.isEmpty() || check2.isEmpty() || check3.isEmpty() || check4.isEmpty() || check5.isEmpty() || check6.isEmpty() || check7.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        } else {
            if (a == false || b == false) {
                JOptionPane.showMessageDialog(this, "Please enter valid Item No and Serial No.");
            } else {
                battery_claiming_complId = battery_claiming_jTextField65.getText();
                battery_claiming_replacedDate = ((JTextField) battery_claiming_jDateChooser5.getDateEditor().getUiComponent()).getText();
                battery_claiming_saleDate = ((JTextField) battery_claiming_jDateChooser2.getDateEditor().getUiComponent()).getText();

                int x = JOptionPane.showConfirmDialog(this, "Do you want to continue the process?");

                if (x == 0) {
                    //store data in replaced_battery table
                    try {
                        String s = "insert into replaced_battery"
                                + "(complaint_id, item_id, battery_type, serial_no, replaced_date, warranty_period, date_of_sale, company)"
                                + "values('" + battery_claiming_complId + "','" + battery_claiming_itemId + "','" + battery_claiming_battType + "','" + battery_claiming_srlNo + "','" + battery_claiming_replacedDate + "','" + battery_claiming_wrrPeriod + "','" + battery_claiming_saleDate + "','" + battery_claiming_company + "')";

                        pst = conn.prepareStatement(s);
                        pst.execute();

                        pst.close();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e);
                    }
                    //message
                    JOptionPane.showMessageDialog(this, "Process is successfully completed.");
                } else {
                    JOptionPane.showMessageDialog(this, "Process is cancelled!!");
                }
            }
        }
    }//GEN-LAST:event_battery_claiming_jButton25ActionPerformed

    /////battery claiming
    // serial_no text box event-battery replacement
    private void battery_claiming_jTextField67KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_battery_claiming_jTextField67KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Enter was pressed

            String srlno = battery_claiming_jTextField67.getText();
            boolean a = isValidNameNum(srlno);

            try {
                String s1 = "select * from item where SerialNo='" + srlno + "'";
                pst = conn.prepareStatement(s1);
                rs = pst.executeQuery();

                if (rs.next()) {
                    if (a == false) {
                        JOptionPane.showMessageDialog(this, "Please enter valid Serial No.");
                    } else {
                        rs.close();
                        pst.close();
                        try {
                            battery_claiming_srlNo = battery_claiming_jTextField67.getText();

                            String s = "select * from item where SerialNo='" + battery_claiming_srlNo + "'";

                            pst = conn.prepareStatement(s);
                            rs = pst.executeQuery();

                            if (rs.next()) {
                                battery_claiming_itemId = rs.getString("ItemCode");
                                battery_claiming_battType = rs.getString("Description");
                                battery_claiming_company = rs.getString("ManufactName");
                                battery_claiming_wrrPeriod = rs.getString("warranty_period");

                                battery_claiming_jTextField69.setText(battery_claiming_itemId);
                                battery_claiming_jTextField71.setText(battery_claiming_battType);
                                battery_claiming_jTextField66.setText(battery_claiming_company);
                                battery_claiming_jTextField70.setText(battery_claiming_wrrPeriod);
                            } else {
                                JOptionPane.showMessageDialog(this, "Record not found.");
                            }

                    //                battery_claiming_jTextField69.setText(battery_claiming_itemId);
                            //                battery_claiming_jTextField71.setText(battery_claiming_battType);
                            //                battery_claiming_jTextField66.setText(battery_claiming_company);
                            //                battery_claiming_jTextField70.setText(battery_claiming_wrrPeriod);
                            pst.close();
                            rs.close();

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, e);
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "No such a SERIAL NUMBER!!");
                }
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_battery_claiming_jTextField67KeyPressed

    
    //demo button battery complaint
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        complaint_battery_jTextField35.setText("Exide123b");
        complaint_battery_jTextField36.setText("Exide123b");
        complaint_battery_jTextField45.setText("1");

    }//GEN-LAST:event_jButton1ActionPerformed

    
    //demo button battery claiming
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        battery_claiming_jTextField69.setText("Exide876c");
                
        battery_claiming_jTextField55.setText("Exide876c");
        battery_claiming_jTextField13.setText("1");
    }//GEN-LAST:event_jButton3ActionPerformed

    
    //demo button tyre complaint
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        tyre_jTextField81.setText("Ceat123b");
        tyre_jTextField88.setText("Ceat123b");
        tyre_jTextField25.setText("1");
    }//GEN-LAST:event_jButton4ActionPerformed

    
    //demo button claim tyre refund
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        tyre_claiming_jTextField90.setText("2");
        tyre_invoice_jTextField13.setText("1");
    }//GEN-LAST:event_jButton5ActionPerformed

    
    //demo button claiminf tyre replace
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        tyre_claiming_jTextField99.setText("Ceat123b");
        tyre_invoice_re_jTextField13.setText("1");
    }//GEN-LAST:event_jButton6ActionPerformed

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

    private void logUserImgMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logUserImgMouseMoved
        logUserImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 96, 125)));//37,4,70
        signOut_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));

    }//GEN-LAST:event_logUserImgMouseMoved

    private void logUserImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logUserImgMouseExited
        logUserImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }//GEN-LAST:event_logUserImgMouseExited

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
            java.util.logging.Logger.getLogger(Complaint_management_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Complaint_management_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Complaint_management_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Complaint_management_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Complaint_management_User().setVisible(true);
            }
        });
    }
    //---variables---

    /////SERVICES/////
    //complaint_service
    private String service_warrantyClaimServiceDate;
    private String service_warrantyClaimServiceNextDate;
    private String service_warrantyClaimServiceFullCost;
    private String service_warrantyClaimServiceDisc;
    private String service_warrantyClaimServiceFinalCost;

    private String service_complId;
    private String service_jobNo;
    private String sevice_cusId;
    private String service_cusName;
    private String service_cusAddress;
    private String service_vRegNo;
    private String service_techNo;
    private String service_techName;
    private String service_jobDate;
    private Date service_jobDate1;
    private String service_nextServiceDate;
    private Date service_nextServiceDate1;

    private String service_newTechNo;
    private String service_newTechName;
    private String service_claimCheckDate;
    private Date service_claimCheckDate1;

    private int service_warrantycheck_eligibleStatus;

    /////tyre/////
    //complaint_tyre_panel
    private String tyre_complId;

    private String tyre_complType;
    private String tyre_claimType;

    private double tyre_dateGap;
    private Date tyre_compldate1;
    private String tyre_complDate;

    private int tyre_serviceLife;
    private String tyre_claiming_serviceLife;
    private int tyre_eligibleStatus;
    private String tyre_itemType;

    private String tyre_wasteTyreDepth;
    private String tyre_claimingAmount;
    private String tyre_taxAmount;
    private String tyre_refundableAmount;
    private String tyre_refundDate;
    private String tax;
    private String claimPer;
    private String tyre_invoiceNo;

    private String tyre_newItemId;
    private String tyre_newType;
    private String tyre_replacePrice;
    private String tyre_replaceSpPrice;
    private String tyre_newCompany;
    private String tyre_newSrlNo;
    private String tyre_newWrrPeriod;
    private String tyre_newReplacedDate;
    private String tyre_newSaleDate;
    private String tyre_newinvoiceNo;

    private String tyre_srlNoWrrcard;
    private String tyre_srlNoTyre;
    private String tyre_saleDate;
    private Date tyre_saleDate1;
    private String tyre_cusId;
    private String tyre_cusName;
    private String tyre_cusAddress;
    private String tyre_vRegNo;
    private String tyre_trType;
    private String tyre_company;
    private String tyre_itemId;
    private String tyre_srlNo;
    private String tyre_wrrPeriod;
    private String tyre_oriTyreDepth;
    private String tyre_soldPrice;

    //item_main_panel
    private String complitem;
    private String viewitem;

    /////Battery/////
    //complaint_battery_panel
    private String srlNoWarrantyCard;
    private String battery_cusId;
    private String srlNo;
    private String battery_cusName;
    private String battery_vRegNo;
    private Date battery_saleDate;
    private String battery_Date;
    private String battery_cusAddress;
    private String battery_battType;
    private String battery_company;
    private String battery_itemId;
    private String battery_wrrPeriod;
    private String battery_soldPrice;

    private String battery_complId;
    private Date battery_complDate;
    private String battery_complDate1;

    private long gap;
    private int battery_serviceLife;
    private String battery_claiming_serviceLife;
    private int prorata, replacement;

    private String battery_claimType;
    private String battery_complaint_type;
    private String battery_claimType1;//
    private String battery_complaint_type1;//
    private int battery_eligibleStatus;
    private String battery_itemType;

    //claiming_battery panel
    //claiming_battery panel replacement
    private String battery_claiming_complId;
    private String battery_claiming_replacedDate;
    private String battery_claiming_saleDate;
    private String battery_claiming_itemId;
    private String battery_claiming_battType;
    private String battery_claiming_company;
    private String battery_claiming_srlNo;
    private String battery_claiming_wrrPeriod;
    //claiming_battery panel pro-rata basis
    private String battery_claiming_complIdPro;
    private double battery_claiming_discPecentage;
    private String battery_claiming_discPecentagePro;
    private String battery_claiming_price;
    private String battery_claiming_spprice;
    private String battery_claiming_soldPrice;
    private String battery_claiming_replacedDatePro;
    private String battery_claiming_saleDatePro;
    private String battery_claiming_battTypePro;
    private String battery_claiming_companyPro;
    private String battery_claiming_itemIdPro;
    private String battery_claiming_srlNoPro;
    private String battery_claiming_wrrPeriodPro;
    private String battery_claiming_invoice_no;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Am_Pm;
    private javax.swing.JLabel Anime_sub;
    private javax.swing.JLabel Cancel;
    private javax.swing.JPanel Claiming_battery_panel;
    private javax.swing.JPanel Claiming_tyre_panel;
    private javax.swing.JLabel Clock;
    private javax.swing.JPanel Complaint_battery_panel;
    private javax.swing.JLabel Complaint_item_main;
    private javax.swing.JPanel Complaint_item_main_panel;
    private javax.swing.JLabel Complaint_item_main_txt;
    private javax.swing.JLabel Complaint_service;
    private javax.swing.JPanel Complaint_service_panel;
    private javax.swing.JLabel Complaint_service_txt;
    private javax.swing.JPanel Complaint_tyre_panel;
    private javax.swing.JPanel DetailPanal;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel Minimize;
    private javax.swing.JLabel Show_Uname;
    private javax.swing.JLabel SubMenu;
    private javax.swing.JPanel SubPanel;
    private javax.swing.JPanel TimeLine;
    private javax.swing.JPanel TitleBar;
    private javax.swing.JPanel Warranty_check_service_panel;
    private javax.swing.JLabel Warranty_claiming_details;
    private javax.swing.JPanel Warranty_claiming_details_panel;
    private javax.swing.JLabel Warranty_claiming_details_txt;
    private javax.swing.JButton battery_claiming_jButton23;
    private javax.swing.JButton battery_claiming_jButton25;
    private javax.swing.JButton battery_claiming_jButton6;
    private com.toedter.calendar.JDateChooser battery_claiming_jDateChooser2;
    private com.toedter.calendar.JDateChooser battery_claiming_jDateChooser3;
    private com.toedter.calendar.JDateChooser battery_claiming_jDateChooser4;
    private com.toedter.calendar.JDateChooser battery_claiming_jDateChooser5;
    private javax.swing.JPanel battery_claiming_jPanel7;
    private javax.swing.JPanel battery_claiming_jPanel8;
    private javax.swing.JTextField battery_claiming_jTextField13;
    private javax.swing.JTextField battery_claiming_jTextField53;
    private javax.swing.JTextField battery_claiming_jTextField54;
    private javax.swing.JTextField battery_claiming_jTextField55;
    private javax.swing.JTextField battery_claiming_jTextField56;
    private javax.swing.JTextField battery_claiming_jTextField57;
    private javax.swing.JTextField battery_claiming_jTextField59;
    private javax.swing.JTextField battery_claiming_jTextField60;
    private javax.swing.JTextField battery_claiming_jTextField61;
    private javax.swing.JTextField battery_claiming_jTextField62;
    private javax.swing.JTextField battery_claiming_jTextField63;
    private javax.swing.JTextField battery_claiming_jTextField64;
    private javax.swing.JTextField battery_claiming_jTextField65;
    private javax.swing.JTextField battery_claiming_jTextField66;
    private javax.swing.JTextField battery_claiming_jTextField67;
    private javax.swing.JTextField battery_claiming_jTextField69;
    private javax.swing.JTextField battery_claiming_jTextField70;
    private javax.swing.JTextField battery_claiming_jTextField71;
    private javax.swing.JButton complaint_battery_jButton18;
    private javax.swing.JButton complaint_battery_jButton20;
    private javax.swing.JButton complaint_battery_jButton21;
    private com.toedter.calendar.JDateChooser complaint_battery_jDateChooser1;
    private javax.swing.JLabel complaint_battery_jLabel52;
    private javax.swing.JPanel complaint_battery_jPanel14;
    private javax.swing.JPanel complaint_battery_jPanel6;
    private javax.swing.JTextArea complaint_battery_jTextArea1;
    private javax.swing.JTextField complaint_battery_jTextField35;
    private javax.swing.JTextField complaint_battery_jTextField36;
    private javax.swing.JTextField complaint_battery_jTextField37;
    private javax.swing.JTextField complaint_battery_jTextField38;
    private javax.swing.JTextField complaint_battery_jTextField39;
    private javax.swing.JTextField complaint_battery_jTextField40;
    private javax.swing.JTextField complaint_battery_jTextField41;
    private javax.swing.JTextField complaint_battery_jTextField42;
    private javax.swing.JTextField complaint_battery_jTextField43;
    private javax.swing.JTextField complaint_battery_jTextField44;
    private javax.swing.JTextField complaint_battery_jTextField45;
    private javax.swing.JTextField complaint_battery_jTextField46;
    private javax.swing.JTextField complaint_battery_jTextField47;
    private javax.swing.JTextField complaint_battery_jTextField48;
    private javax.swing.JTextField complaint_battery_jTextField49;
    private javax.swing.JTextField complaint_battery_jTextField50;
    private javax.swing.JTextField complaint_battery_jTextField51;
    private javax.swing.JTextField complaint_battery_jTextField52;
    private javax.swing.JButton complaint_battery_view;
    private javax.swing.JLabel dateLable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
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
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logUserImg;
    private javax.swing.JLabel logo;
    private javax.swing.JButton next;
    private javax.swing.JComboBox selec_complitem1;
    private javax.swing.JButton service_complaint_jButton4;
    private javax.swing.JButton service_complaint_jButton5;
    private javax.swing.JTextField service_complaint_jTextField10;
    private javax.swing.JTextField service_complaint_jTextField11;
    private javax.swing.JTextField service_complaint_jTextField12;
    private javax.swing.JTextField service_complaint_jTextField5;
    private javax.swing.JTextField service_complaint_jTextField6;
    private javax.swing.JTextField service_complaint_jTextField7;
    private javax.swing.JTextField service_complaint_jTextField8;
    private javax.swing.JTextField service_complaint_jTextField9;
    private javax.swing.JButton service_warrantycheck_jButton27;
    private javax.swing.JButton service_warrantycheck_jButton28;
    private com.toedter.calendar.JDateChooser service_warrantycheck_jDateChooser6;
    private com.toedter.calendar.JDateChooser service_warrantycheck_jDateChooser7;
    private com.toedter.calendar.JDateChooser service_warrantycheck_jDateChooser8;
    private javax.swing.JPanel service_warrantycheck_jPanel6;
    private javax.swing.JPanel service_warrantycheck_jPanel9;
    private javax.swing.JTextField service_warrantycheck_jTextField72;
    private javax.swing.JTextField service_warrantycheck_jTextField73;
    private javax.swing.JTextField service_warrantycheck_jTextField74;
    private javax.swing.JTextField service_warrantycheck_jTextField75;
    private javax.swing.JTextField service_warrantycheck_jTextField76;
    private javax.swing.JTextField service_warrantycheck_jTextField77;
    private javax.swing.JTextField service_warrantycheck_jTextField78;
    private javax.swing.JTextField service_warrantycheck_jTextField79;
    private javax.swing.JTextField service_warrantycheck_jTextField80;
    private javax.swing.JLabel signOut_button;
    private javax.swing.JButton tyre_claiming_jButton35;
    private javax.swing.JButton tyre_claiming_jButton37;
    private javax.swing.JButton tyre_claiming_jButton38;
    private com.toedter.calendar.JDateChooser tyre_claiming_jDateChooser10;
    private com.toedter.calendar.JDateChooser tyre_claiming_jDateChooser11;
    private com.toedter.calendar.JDateChooser tyre_claiming_jDateChooser12;
    private javax.swing.JTextField tyre_claiming_jTextField100;
    private javax.swing.JTextField tyre_claiming_jTextField101;
    private javax.swing.JTextField tyre_claiming_jTextField102;
    private javax.swing.JTextField tyre_claiming_jTextField103;
    private javax.swing.JTextField tyre_claiming_jTextField104;
    private javax.swing.JTextField tyre_claiming_jTextField105;
    private javax.swing.JTextField tyre_claiming_jTextField107;
    private javax.swing.JTextField tyre_claiming_jTextField89;
    private javax.swing.JTextField tyre_claiming_jTextField90;
    private javax.swing.JTextField tyre_claiming_jTextField91;
    private javax.swing.JTextField tyre_claiming_jTextField92;
    private javax.swing.JTextField tyre_claiming_jTextField93;
    private javax.swing.JTextField tyre_claiming_jTextField94;
    private javax.swing.JTextField tyre_claiming_jTextField95;
    private javax.swing.JTextField tyre_claiming_jTextField96;
    private javax.swing.JTextField tyre_claiming_jTextField97;
    private javax.swing.JTextField tyre_claiming_jTextField98;
    private javax.swing.JTextField tyre_claiming_jTextField99;
    private javax.swing.JTextField tyre_invoice_jTextField13;
    private javax.swing.JTextField tyre_invoice_re_jTextField13;
    private javax.swing.JButton tyre_jButton31;
    private javax.swing.JButton tyre_jButton32;
    private com.toedter.calendar.JDateChooser tyre_jDateChooser9;
    private javax.swing.JLabel tyre_jLabel57;
    private javax.swing.JTextArea tyre_jTextArea1;
    private javax.swing.JTextField tyre_jTextField25;
    private javax.swing.JTextField tyre_jTextField26;
    private javax.swing.JTextField tyre_jTextField27;
    private javax.swing.JTextField tyre_jTextField28;
    private javax.swing.JTextField tyre_jTextField29;
    private javax.swing.JTextField tyre_jTextField30;
    private javax.swing.JTextField tyre_jTextField81;
    private javax.swing.JTextField tyre_jTextField82;
    private javax.swing.JTextField tyre_jTextField83;
    private javax.swing.JTextField tyre_jTextField84;
    private javax.swing.JTextField tyre_jTextField85;
    private javax.swing.JTextField tyre_jTextField86;
    private javax.swing.JTextField tyre_jTextField87;
    private javax.swing.JTextField tyre_jTextField88;
    private javax.swing.JButton warranty_claiming_details_jButton10;
    private javax.swing.JButton warranty_claiming_details_jButton11;
    private javax.swing.JButton warranty_claiming_details_jButton12;
    private javax.swing.JButton warranty_claiming_details_jButton13;
    private javax.swing.JButton warranty_claiming_details_jButton14;
    private javax.swing.JButton warranty_claiming_details_jButton2;
    private javax.swing.JButton warranty_claiming_details_jButton7;
    private javax.swing.JButton warranty_claiming_details_jButton8;
    private javax.swing.JButton warranty_claiming_details_jButton9;
    private javax.swing.JComboBox warranty_claiming_details_jComboBox1;
    private javax.swing.JLabel warranty_claiming_details_jLabel4;
    private javax.swing.JLabel warranty_claiming_details_jLabel4tyre;
    private javax.swing.JTextField warranty_claiming_details_jTextField13;
    private javax.swing.JTextField warranty_claiming_details_jTextField14;
    private javax.swing.JTextField warranty_claiming_details_jTextField15;
    private javax.swing.JTextField warranty_claiming_details_jTextField16;
    private javax.swing.JTextField warranty_claiming_details_jTextField17;
    private javax.swing.JTextField warranty_claiming_details_jTextField19;
    private javax.swing.JTextField warranty_claiming_details_jTextField20;
    private javax.swing.JTextField warranty_claiming_details_jTextField21;
    private javax.swing.JTextField warranty_claiming_details_jTextField22;
    private javax.swing.JTextField warranty_claiming_details_jTextField23;
    private javax.swing.JComboBox warranty_claiming_details_searchbattery;
    private javax.swing.JRadioButton warrantycheck_jRadioButton1;
    private javax.swing.JRadioButton warrantycheck_jRadioButton3;
    // End of variables declaration//GEN-END:variables

//    private void setTime() {
    private void setHide() {
        Complaint_item_main_panel.setVisible(false);
        Complaint_service_panel.setVisible(false);
        Warranty_claiming_details_panel.setVisible(false);
        Claiming_battery_panel.setVisible(false);
        Claiming_tyre_panel.setVisible(false);
        Complaint_battery_panel.setVisible(false);
        Complaint_tyre_panel.setVisible(false);
        Warranty_check_service_panel.setVisible(false);

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

}
