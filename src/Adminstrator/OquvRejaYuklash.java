/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminstrator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Asus
 */
public class OquvRejaYuklash extends javax.swing.JFrame {

    /**
     * Creates new form OquvRejaYuklash
     */
    public OquvRejaYuklash() {
        initComponents();
        combobox();
    }
    private void combobox() {
        Connection con;
        PreparedStatement ps,ps1,ps2,ps3,ps4;
        ResultSet rs,rs1,rs2,rs3,rs4;    
        try {
            con = MyConnection.getConnection();
            String query = "Select nomi from fakultet";
            String query1 = "Select nomi from kafedra";
            String query2 = "Select nomi from yunalish";
            String query3 = "Select nomi from guruh";
            String query4 = "Select concat(`ism`,' ',`familiya`,' ',`sharif`) as `tuliq_ism` from `uqituvchi`";
            
            ps = con.prepareStatement(query);
            ps1 = con.prepareStatement(query1);
            ps2 = con.prepareStatement(query2);
            ps3 = con.prepareStatement(query3);
            ps4 = con.prepareStatement(query4);
            
            rs = ps.executeQuery();
            rs1 = ps1.executeQuery();
            rs2 = ps2.executeQuery();
            rs3 = ps3.executeQuery();
            rs4 = ps4.executeQuery();
            
            while(rs.next()){
                String fakultet = rs.getString("nomi");
                Uqit_fakultet.addItem(fakultet);
                Kafedra_Kaftanlash.addItem(fakultet);
                Kaf_FakultetId.addItem(fakultet);
            }
            while(rs1.next()){
                String kafedra = rs1.getString("nomi");
                Uqit_kafedra.addItem(kafedra);
            }
            while(rs2.next()){
                String yunalish = rs2.getString("nomi");
                Uquv_yunalish.addItem(yunalish);
                UqitYuk_yunalish.addItem(yunalish);
            }
            while(rs3.next()){
                String guruh = rs3.getString("nomi");
                UqitYuk_guruh.addItem(guruh);
            }
            while(rs4.next()){
                String uqituvchi = rs4.getString("tuliq_ism");
                UqitYuk_uqituvchi.addItem(uqituvchi);
            }
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    } 
    
    public boolean checkInputs(){
        if(reg_ism.getText().equals("") && reg_fam.getText().equals("") || String.valueOf(reg_pass.getPassword()).equals("")
                ||  String.valueOf(reg_retypePass.getPassword()).equals("")
                ||  reg_login.getText().equals("") 
          ){
            JOptionPane.showMessageDialog(AsosiyDoc, "Bir yoki ko'p maydonlar bo'sh!");
            return false;
        }
        else if(!String.valueOf(reg_pass.getPassword()).equals(String.valueOf(reg_retypePass.getPassword()))){
            JOptionPane.showMessageDialog(AsosiyDoc, "Parol noto'g'ri!");
            return false;
        }
        else
        {
            try{
                return true;
            }catch(Exception ex){
                return false;
            }
        }
    }
    public boolean checkUquvReja(){
        if(Uquv_Mar.getText().equals("") || Uquv_UmumSoat.getText().equals("") || Uquv_amal.getText().equals("")
                ||  Uquv_fanBlok.getText().equals("") || Uquv_fanKredit.getText().equals("") || Uquv_fanNomi.getText().equals("") 
                || Uquv_fankodi.getText().equals("") ||  Uquv_labsoat.getText().equals("") ||  Uquv_musTalim.getText().equals("") 
                ||  Uquv_seminar.getText().equals("") ||  Uquv_uquv_yili.getText().equals("")
                ){
            JOptionPane.showMessageDialog(AsosiyDoc, "Bir yoki ko'p maydonlar bo'sh!");
            return false;
        }
        else
        {
            try{
                return true;
            }catch(Exception ex){
                return false;
            }
        }
    }
    
    public boolean isUsernameExist(String un){
        Connection con;
        PreparedStatement ps;
        boolean uExist = false;
        try {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM users WHERE login = ? ");
            ps.setString(1, sign_login.getText());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                uExist = true;
            }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Bunday foydalanuvchi tizimda mavjud!");
                uExist = false;
            }           
        } catch (Exception ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uExist;
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AsosiyDoc = new javax.swing.JDesktopPane();
        SignUpFrame = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        reg_ism = new javax.swing.JTextField();
        reg_fam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        reg_foydalanuvchi = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        reg_login = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        reg_pass = new javax.swing.JPasswordField();
        reg_qushish = new javax.swing.JButton();
        reg_cancel = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        reg_email = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        reg_retypePass = new javax.swing.JPasswordField();
        jLabel82 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        LoginFrame = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        sign_login = new javax.swing.JTextField();
        huquq_tanlash = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sign_parol = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        sign_cancel = new javax.swing.JButton();
        sign_kirish = new javax.swing.JButton();
        Parol_yangi = new javax.swing.JLabel();
        UqituvchiFrame = new javax.swing.JInternalFrame();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Uqit_fami = new javax.swing.JTextField();
        Uqit_ism = new javax.swing.JTextField();
        Uqit_sharifi = new javax.swing.JTextField();
        Uqit_lavozim = new javax.swing.JComboBox<>();
        Uqit_buyruqRaq = new javax.swing.JTextField();
        Uqit_Staj = new javax.swing.JTextField();
        bt_yuklash = new javax.swing.JButton();
        but_uzgartirish = new javax.swing.JButton();
        but_uchirish = new javax.swing.JButton();
        bt_tozalash = new javax.swing.JButton();
        Uqit_kafedra = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        Uqit_bdate = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        Uqit_qabul_date = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Uqit_OTMnomi = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Uqit_Tugat_Yili = new com.toedter.calendar.JYearChooser();
        Uqit_fakultet = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        Uqit_Daraja = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Uqit_Unvon = new javax.swing.JTextField();
        NewPassFrame = new javax.swing.JInternalFrame();
        jLabel27 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_ok = new javax.swing.JButton();
        jpass_parol1 = new javax.swing.JPasswordField();
        jLabel28 = new javax.swing.JLabel();
        jpass_parol2 = new javax.swing.JPasswordField();
        jLabel29 = new javax.swing.JLabel();
        pass1 = new java.awt.Checkbox();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        pass2 = new java.awt.Checkbox();
        txt_log = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        uquv_reja = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        Uquv_talimShakli = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Uquv_uquv_yili = new javax.swing.JTextField();
        Uquv_semestr = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Uquv_fanBlok = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Uquv_fankodi = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        Uquv_fanNomi = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        Uquv_fanKredit = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_lab = new javax.swing.JLabel();
        txt_Sem = new javax.swing.JLabel();
        Uquv_UmumSoat = new javax.swing.JTextField();
        Uquv_Mar = new javax.swing.JTextField();
        Uquv_amal = new javax.swing.JTextField();
        Uquv_labsoat = new javax.swing.JTextField();
        Uquv_seminar = new javax.swing.JTextField();
        txt_mus = new javax.swing.JLabel();
        Uquv_musTalim = new javax.swing.JTextField();
        Uquv_yuklash = new javax.swing.JButton();
        Uquv_tozalash = new javax.swing.JButton();
        Uquv_uzgartirish = new javax.swing.JButton();
        Uquv_uchirish = new javax.swing.JButton();
        Uquv_yunalish = new javax.swing.JComboBox<>();
        jInternal_Fakultet = new javax.swing.JInternalFrame();
        fakultet = new javax.swing.JPanel();
        btn_Uchirish = new javax.swing.JButton();
        btn_Uzgartirish = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        btn_Yuklash = new javax.swing.JButton();
        txt_fakultetId = new javax.swing.JTextField();
        txt_fakultetNomi = new javax.swing.JTextField();
        jInternal_Yunalish = new javax.swing.JInternalFrame();
        yunalish = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        butt_yunalish = new javax.swing.JButton();
        text_yunalishId = new javax.swing.JTextField();
        text_Yunalishnomi = new javax.swing.JTextField();
        butt_uchirish = new javax.swing.JButton();
        butt_uzgartirish = new javax.swing.JButton();
        jInternal_YunalishGuruh = new javax.swing.JInternalFrame();
        yunalish_guruh = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        tx_fakultetNomi = new javax.swing.JTextField();
        tx_yunalishNomi = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        comKursi = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        com_talimshakli = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        tx_guruhNomi = new javax.swing.JTextField();
        tx_talabalarSoni = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jInternal_Kafedra = new javax.swing.JInternalFrame();
        kafedra = new javax.swing.JPanel();
        Kaf_nomi = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        Kaf_FakultetId = new javax.swing.JComboBox<>();
        YuklamaUqituvchi = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        UqitYuk_uqituvchi = new javax.swing.JComboBox<>();
        UqitYuk_talimshakli = new javax.swing.JComboBox<>();
        UqitYuk_kurs = new javax.swing.JComboBox<>();
        UqitYuk_yunalish = new javax.swing.JComboBox<>();
        UqitYuk_guruh = new javax.swing.JComboBox<>();
        UqitYuk_fan = new javax.swing.JComboBox<>();
        UqitYuk_mar = new javax.swing.JTextField();
        UqitYuk_amal = new javax.swing.JTextField();
        UqitYuk_lab = new javax.swing.JTextField();
        UqitYuk_sem = new javax.swing.JTextField();
        UqitYuk_qushish = new javax.swing.JButton();
        UqitYuk_tozala = new javax.swing.JButton();
        UqitYuk_Uzgartir = new javax.swing.JButton();
        UqitYuk_Uchir = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        UqitYuk_umum = new javax.swing.JTextField();
        YuklamaKafedra = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        Kafedra_Kaftanlash = new javax.swing.JComboBox<>();
        YukKaf_fan = new javax.swing.JComboBox<>();
        YukKaf_yunalish = new javax.swing.JComboBox<>();
        YukKaf_semestr = new javax.swing.JComboBox<>();
        YukKaf_amalReja = new javax.swing.JTextField();
        YukKaf_amalJami = new javax.swing.JTextField();
        YukKaf_labReja = new javax.swing.JTextField();
        YukKaf_labJami = new javax.swing.JTextField();
        YukKaf_qushish = new javax.swing.JButton();
        YukKaf_Tozalash = new javax.swing.JButton();
        YukKaf_Uzgar = new javax.swing.JButton();
        YukKaf_Uchir = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        YukKaf_TalSoni = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        YukKaf_PotokSoni = new javax.swing.JTextField();
        YukKaf_GurSoni = new javax.swing.JTextField();
        YukKaf_marReja = new javax.swing.JTextField();
        YukKaf_marJami = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        YukKaf_nazorat = new javax.swing.JTextField();
        YukKaf_KursIshi = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        YukKaf_BMI = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        YukKaf_DAK = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        YukKaf_Jami = new javax.swing.JTextField();
        SidebarForm = new javax.swing.JPanel();
        btn_Reg = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        btn_Uqituvchilar = new javax.swing.JButton();
        btn_KafedraMudiri = new javax.swing.JButton();
        btn_UqituvchiYuklama = new javax.swing.JButton();
        btn_uquvReja = new javax.swing.JButton();
        btn_fakultet = new javax.swing.JButton();
        btn_kafedra = new javax.swing.JButton();
        btn_yunalish = new javax.swing.JButton();
        btn_guruh = new javax.swing.JButton();
        SidebarForm1 = new javax.swing.JPanel();
        btn_Reg1 = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        btn_Uqituvchilar1 = new javax.swing.JButton();
        btn_UqituvchiYuklama1 = new javax.swing.JButton();
        Dasturchi = new javax.swing.JInternalFrame();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_kirish = new javax.swing.JMenuItem();
        menu_registratsiya = new javax.swing.JMenuItem();
        menu_exit = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yuklama taqsimlash dasturi");
        setAlwaysOnTop(true);
        setIconImages(null);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setSize(new java.awt.Dimension(0, 0));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        AsosiyDoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AsosiyDoc.setAutoscrolls(true);
        AsosiyDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AsosiyDoc.setNextFocusableComponent(LoginFrame);
        AsosiyDoc.setPreferredSize(new java.awt.Dimension(1100, 730));
        AsosiyDoc.setRequestFocusEnabled(false);
        AsosiyDoc.setSelectedFrame(LoginFrame);
        AsosiyDoc.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                AsosiyDocComponentResized(evt);
            }
        });

        javax.swing.GroupLayout AsosiyDocLayout = new javax.swing.GroupLayout(AsosiyDoc);
        AsosiyDoc.setLayout(AsosiyDocLayout);
        AsosiyDocLayout.setHorizontalGroup(
            AsosiyDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        AsosiyDocLayout.setVerticalGroup(
            AsosiyDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        SignUpFrame.setClosable(true);
        SignUpFrame.setIconifiable(true);
        SignUpFrame.setTitle("Ro'yxatga olish");
        SignUpFrame.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        SignUpFrame.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_add_user_678158.png"))); // NOI18N
        SignUpFrame.setInheritsPopupMenu(true);
        SignUpFrame.setMinimumSize(new java.awt.Dimension(480, 434));
        SignUpFrame.setPreferredSize(new java.awt.Dimension(518, 468));
        SignUpFrame.setRequestFocusEnabled(false);
        try {
            SignUpFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        SignUpFrame.setVisible(false);

        jPanel2.setMinimumSize(new java.awt.Dimension(463, 347));
        jPanel2.setPreferredSize(new java.awt.Dimension(480, 440));
        jPanel2.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Ism:");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Familiya:");

        reg_foydalanuvchi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        reg_foydalanuvchi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kafedra mudiri", "O'qituvchi" }));
        reg_foydalanuvchi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_foydalanuvchiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Foydalanuvchi turi:");

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Login:");

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Parol:");

        reg_qushish.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reg_qushish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_administrator_star_67248_3.png"))); // NOI18N
        reg_qushish.setText("Bazaga Qo'shish");
        reg_qushish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reg_qushishMouseClicked(evt);
            }
        });
        reg_qushish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_qushishActionPerformed(evt);
            }
        });
        reg_qushish.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reg_qushishKeyPressed(evt);
            }
        });

        reg_cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reg_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_clear-left_9220.png"))); // NOI18N
        reg_cancel.setText("Tozalash");
        reg_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_cancelActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 153, 0));
        jLabel80.setText("Email:");

        jLabel81.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 153, 0));
        jLabel81.setText("Takror parol:");

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Login_73221.png"))); // NOI18N
        jLabel82.setText("Siz allaqachon ro'yxatdan o'tkanmisiz?");
        jLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel82MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel82MousePressed(evt);
            }
        });

        jCheckBox2.setText("Ko'rish");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Ko'rish");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(325, 325, 325))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(reg_qushish))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(reg_ism, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reg_foydalanuvchi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reg_fam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reg_login, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(reg_retypePass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBox3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(reg_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBox2))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(reg_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(reg_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel80)
                            .addComponent(jLabel81)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel82)))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(reg_foydalanuvchi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reg_ism, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reg_fam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reg_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(reg_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox3)
                        .addComponent(reg_retypePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel81))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel80))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(reg_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reg_qushish, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reg_cancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SignUpFrameLayout = new javax.swing.GroupLayout(SignUpFrame.getContentPane());
        SignUpFrame.getContentPane().setLayout(SignUpFrameLayout);
        SignUpFrameLayout.setHorizontalGroup(
            SignUpFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );
        SignUpFrameLayout.setVerticalGroup(
            SignUpFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        LoginFrame.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoginFrame.setClosable(true);
        LoginFrame.setIconifiable(true);
        LoginFrame.setTitle("Tizimga kirish");
        LoginFrame.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LoginFrame.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Login_73221.png"))); // NOI18N
        LoginFrame.setMinimumSize(new java.awt.Dimension(460, 308));
        LoginFrame.setPreferredSize(new java.awt.Dimension(472, 308));
        LoginFrame.setVisible(false);

        jPanel4.setPreferredSize(new java.awt.Dimension(462, 261));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sign_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_loginActionPerformed(evt);
            }
        });
        jPanel4.add(sign_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 48, 180, -1));

        huquq_tanlash.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        huquq_tanlash.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Kafedra mudiri", "O'qituvchi" }));
        jPanel4.add(huquq_tanlash, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 90, 180, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Login");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel25.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 153, 0));
        jLabel25.setText("Huquq");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 92, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Parol");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 135, -1, -1));

        sign_parol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_parolActionPerformed(evt);
            }
        });
        jPanel4.add(sign_parol, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 134, 180, -1));

        jCheckBox1.setText("Ko'rish");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 133, -1, -1));

        sign_cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sign_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_clear-left_9220_2.png"))); // NOI18N
        sign_cancel.setText("Tozalash");
        sign_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_cancelActionPerformed(evt);
            }
        });
        jPanel4.add(sign_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        sign_kirish.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sign_kirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Login_73221.png"))); // NOI18N
        sign_kirish.setText("Kirish");
        sign_kirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_kirishActionPerformed(evt);
            }
        });
        jPanel4.add(sign_kirish, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 120, 40));

        Parol_yangi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_add_user_678158_2.png"))); // NOI18N
        Parol_yangi.setText("Ro'yxatdan o'tish");
        Parol_yangi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parol_yangiMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Parol_yangiMousePressed(evt);
            }
        });
        jPanel4.add(Parol_yangi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        javax.swing.GroupLayout LoginFrameLayout = new javax.swing.GroupLayout(LoginFrame.getContentPane());
        LoginFrame.getContentPane().setLayout(LoginFrameLayout);
        LoginFrameLayout.setHorizontalGroup(
            LoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        LoginFrameLayout.setVerticalGroup(
            LoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        UqituvchiFrame.setBorder(null);
        UqituvchiFrame.setClosable(true);
        UqituvchiFrame.setIconifiable(true);
        UqituvchiFrame.setTitle("O'qituvchilarni bazaga qo'shish");
        UqituvchiFrame.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        UqituvchiFrame.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_teacher_writing_on_board_1741313 (1).png"))); // NOI18N
        UqituvchiFrame.setMinimumSize(new java.awt.Dimension(866, 483));
        UqituvchiFrame.setPreferredSize(new java.awt.Dimension(895, 455));
        UqituvchiFrame.setVisible(false);
        UqituvchiFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel9.setText("Familiya");
        UqituvchiFrame.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 126, -1, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel11.setText("Ism");
        UqituvchiFrame.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 167, -1, 20));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel12.setText("Sharifi");
        UqituvchiFrame.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 213, -1, -1));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel13.setText("Lavozimi");
        UqituvchiFrame.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 80, -1, -1));

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel14.setText("Buyruq raqami");
        UqituvchiFrame.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 41, -1, -1));

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel15.setText("Ped staji");
        UqituvchiFrame.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 218, -1, -1));
        UqituvchiFrame.getContentPane().add(Uqit_fami, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 124, 200, -1));

        Uqit_ism.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uqit_ismActionPerformed(evt);
            }
        });
        UqituvchiFrame.getContentPane().add(Uqit_ism, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 166, 200, -1));
        UqituvchiFrame.getContentPane().add(Uqit_sharifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 208, 200, -1));

        Uqit_lavozim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Uqit_lavozim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stajer o'qituvchi", "Assistent", "Katta o'qituvchi", "Dotsent", "Professor", "Kafedra mudiri" }));
        Uqit_lavozim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uqit_lavozimActionPerformed(evt);
            }
        });
        UqituvchiFrame.getContentPane().add(Uqit_lavozim, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 78, 200, -1));
        UqituvchiFrame.getContentPane().add(Uqit_buyruqRaq, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 36, 200, -1));
        UqituvchiFrame.getContentPane().add(Uqit_Staj, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 213, 200, -1));

        bt_yuklash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_yuklash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_add_user_678158 (1).png"))); // NOI18N
        bt_yuklash.setText("Yuklash");
        bt_yuklash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_yuklashActionPerformed(evt);
            }
        });
        UqituvchiFrame.getContentPane().add(bt_yuklash, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 363, -1, -1));

        but_uzgartirish.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        but_uzgartirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_update_172618.png"))); // NOI18N
        but_uzgartirish.setText("O'zgartirish");
        but_uzgartirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_uzgartirishActionPerformed(evt);
            }
        });
        UqituvchiFrame.getContentPane().add(but_uzgartirish, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 363, -1, -1));

        but_uchirish.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        but_uchirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Streamline-70_185090.png"))); // NOI18N
        but_uchirish.setText("O'chirish");
        but_uchirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_uchirishActionPerformed(evt);
            }
        });
        UqituvchiFrame.getContentPane().add(but_uchirish, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 363, -1, -1));

        bt_tozalash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_tozalash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_edit-clear_118917 (1).png"))); // NOI18N
        bt_tozalash.setText("Tozalash");
        bt_tozalash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tozalashActionPerformed(evt);
            }
        });
        UqituvchiFrame.getContentPane().add(bt_tozalash, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 363, -1, -1));

        Uqit_kafedra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Uqit_kafedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uqit_kafedraActionPerformed(evt);
            }
        });
        UqituvchiFrame.getContentPane().add(Uqit_kafedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 78, 200, -1));

        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel17.setText("Kafedra");
        UqituvchiFrame.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 80, -1, -1));
        UqituvchiFrame.getContentPane().add(Uqit_bdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 250, 200, -1));

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel18.setText("Tug'ilgan sana");
        UqituvchiFrame.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 260, -1, -1));
        UqituvchiFrame.getContentPane().add(Uqit_qabul_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 297, 200, -1));

        jLabel19.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel19.setText("Ishga kirish sanasi");
        UqituvchiFrame.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 307, -1, -1));

        jLabel20.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel20.setText("Tugatgan OTM");
        UqituvchiFrame.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 126, -1, -1));
        UqituvchiFrame.getContentPane().add(Uqit_OTMnomi, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 124, 200, -1));

        jLabel21.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel21.setText("Tugatgan yili");
        UqituvchiFrame.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 168, -1, -1));
        UqituvchiFrame.getContentPane().add(Uqit_Tugat_Yili, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 166, 67, -1));

        Uqit_fakultet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Uqit_fakultet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uqit_fakultetActionPerformed(evt);
            }
        });
        UqituvchiFrame.getContentPane().add(Uqit_fakultet, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 35, 200, -1));

        jLabel23.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel23.setText("Fakultet");
        UqituvchiFrame.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 37, -1, -1));
        UqituvchiFrame.getContentPane().add(Uqit_Daraja, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 255, 200, -1));

        jLabel22.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel22.setText("Ilmiy darajasi");
        UqituvchiFrame.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 257, -1, -1));

        jLabel24.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel24.setText("Ilmiy unvoni");
        UqituvchiFrame.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 304, -1, -1));
        UqituvchiFrame.getContentPane().add(Uqit_Unvon, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 302, 200, -1));

        NewPassFrame.setClosable(true);
        NewPassFrame.setIconifiable(true);
        NewPassFrame.setTitle("Yangilash");
        NewPassFrame.setMinimumSize(new java.awt.Dimension(380, 278));
        NewPassFrame.setVisible(false);

        jLabel27.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 153, 0));
        jLabel27.setText("Parolni tasdiqlash");

        btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_cancel.setText("Tozalash");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_ok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        jpass_parol1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpass_parol1ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 153, 0));
        jLabel28.setText("Yangi parol");

        jpass_parol2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpass_parol2ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(60, 83, 119));
        jLabel29.setText("Yangi parol o'rnatish");

        pass1.setLabel("Ko'rish");
        pass1.setName("Ko'rish"); // NOI18N

        jLabel78.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 153, 0));
        jLabel78.setText("Emailni kiriting");

        jLabel79.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 153, 0));
        jLabel79.setText("Login");

        pass2.setLabel("Ko'rish");
        pass2.setName("Ko'rish"); // NOI18N

        javax.swing.GroupLayout NewPassFrameLayout = new javax.swing.GroupLayout(NewPassFrame.getContentPane());
        NewPassFrame.getContentPane().setLayout(NewPassFrameLayout);
        NewPassFrameLayout.setHorizontalGroup(
            NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPassFrameLayout.createSequentialGroup()
                .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewPassFrameLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(NewPassFrameLayout.createSequentialGroup()
                                .addComponent(btn_ok)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_cancel))
                            .addGroup(NewPassFrameLayout.createSequentialGroup()
                                .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel78)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel79))
                                .addGap(23, 23, 23)
                                .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(NewPassFrameLayout.createSequentialGroup()
                                        .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_log, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jpass_parol1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                        .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(NewPassFrameLayout.createSequentialGroup()
                                        .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jpass_parol2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(NewPassFrameLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NewPassFrameLayout.setVerticalGroup(
            NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPassFrameLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel79)
                    .addComponent(txt_log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(NewPassFrameLayout.createSequentialGroup()
                        .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jpass_parol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28))
                            .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jpass_parol2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewPassFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_ok))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        uquv_reja.setClosable(true);
        uquv_reja.setIconifiable(true);
        uquv_reja.setTitle("O'quv rejasini bazaga yuklash");
        uquv_reja.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_set_of_three_books_1741315 (4).png"))); // NOI18N
        uquv_reja.setMinimumSize(new java.awt.Dimension(760, 454));
        uquv_reja.setPreferredSize(new java.awt.Dimension(760, 454));
        uquv_reja.setVisible(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(747, 418));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Uquv_talimShakli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kunduzgi", "Kechki", "Sirtqi" }));
        jPanel1.add(Uquv_talimShakli, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 39, 100, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel8.setText("Ta'lim shakli");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 42, 90, 20));

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel16.setText("O'quv yili");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 85, 90, 20));

        Uquv_uquv_yili.setText("2019-2020");
        Uquv_uquv_yili.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_uquv_yiliActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_uquv_yili, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 83, 100, -1));

        Uquv_semestr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        jPanel1.add(Uquv_semestr, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 125, 100, -1));

        jLabel30.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel30.setText("Semestr");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 128, 90, 20));

        jLabel31.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel31.setText("Yo'nalish");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 172, 90, 20));

        jLabel32.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel32.setText("Fan blok");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 219, 90, 18));

        Uquv_fanBlok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_fanBlokActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_fanBlok, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 213, 180, -1));

        jLabel33.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel33.setText("Fan kodi");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 259, 90, -1));

        Uquv_fankodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_fankodiActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_fankodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 255, 180, -1));

        jLabel34.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel34.setText("Fan nomi");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 301, 90, -1));

        Uquv_fanNomi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_fanNomiActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_fanNomi, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 297, 180, -1));

        jLabel35.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel35.setText("Fan krediti");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 44, 90, -1));

        Uquv_fanKredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_fanKreditActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_fanKredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 40, 180, -1));

        jLabel36.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel36.setText("Fan umumiy soati");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 87, -1, -1));

        jLabel37.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel37.setText("Maruza soati");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 130, -1, -1));

        jLabel38.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel38.setText("Amaliyot soati");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 174, -1, -1));

        txt_lab.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        txt_lab.setText("Laboratoriya soati");
        jPanel1.add(txt_lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 217, -1, -1));

        txt_Sem.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        txt_Sem.setText("Seminar soati");
        jPanel1.add(txt_Sem, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 259, -1, -1));

        Uquv_UmumSoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_UmumSoatActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_UmumSoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 83, 180, -1));

        Uquv_Mar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_MarActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_Mar, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 126, 180, -1));

        Uquv_amal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_amalActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_amal, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 170, 180, -1));

        Uquv_labsoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_labsoatActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_labsoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 213, 180, -1));

        Uquv_seminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_seminarActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_seminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 255, 180, -1));

        txt_mus.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        txt_mus.setText("Mustaqil ta'lim soati");
        jPanel1.add(txt_mus, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 301, -1, -1));

        Uquv_musTalim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_musTalimActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_musTalim, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 297, 180, -1));

        Uquv_yuklash.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Uquv_yuklash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_plus_1646001.png"))); // NOI18N
        Uquv_yuklash.setText("Yuklash");
        Uquv_yuklash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_yuklashActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_yuklash, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 351, -1, -1));

        Uquv_tozalash.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Uquv_tozalash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_edit-clear_118917 (1).png"))); // NOI18N
        Uquv_tozalash.setText("Tozalash");
        Uquv_tozalash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_tozalashActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_tozalash, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 351, -1, -1));

        Uquv_uzgartirish.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Uquv_uzgartirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_update_172618.png"))); // NOI18N
        Uquv_uzgartirish.setText("O'zgartirish");
        Uquv_uzgartirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_uzgartirishActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_uzgartirish, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 351, -1, -1));

        Uquv_uchirish.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Uquv_uchirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Streamline-70_185090.png"))); // NOI18N
        Uquv_uchirish.setText("O'chirish");
        Uquv_uchirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Uquv_uchirishActionPerformed(evt);
            }
        });
        jPanel1.add(Uquv_uchirish, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 351, -1, -1));

        jPanel1.add(Uquv_yunalish, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 169, 180, -1));

        javax.swing.GroupLayout uquv_rejaLayout = new javax.swing.GroupLayout(uquv_reja.getContentPane());
        uquv_reja.getContentPane().setLayout(uquv_rejaLayout);
        uquv_rejaLayout.setHorizontalGroup(
            uquv_rejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        uquv_rejaLayout.setVerticalGroup(
            uquv_rejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jInternal_Fakultet.setClosable(true);
        jInternal_Fakultet.setIconifiable(true);
        jInternal_Fakultet.setTitle("Fakultetlar");
        jInternal_Fakultet.setVisible(false);

        fakultet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Uchirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Streamline-70_185090.png"))); // NOI18N
        btn_Uchirish.setText("O'chirish");
        btn_Uchirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UchirishActionPerformed(evt);
            }
        });
        fakultet.add(btn_Uchirish, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        btn_Uzgartirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_system-software-update_118827.png"))); // NOI18N
        btn_Uzgartirish.setText("O'zgartirish");
        btn_Uzgartirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UzgartirishActionPerformed(evt);
            }
        });
        fakultet.add(btn_Uzgartirish, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        jLabel43.setText("Fakultet id");
        fakultet.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel45.setText("Fakultet nomi");
        fakultet.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        btn_Yuklash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_plus_1646001.png"))); // NOI18N
        btn_Yuklash.setText("Yuklash");
        btn_Yuklash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_YuklashActionPerformed(evt);
            }
        });
        fakultet.add(btn_Yuklash, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        fakultet.add(txt_fakultetId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, -1));
        fakultet.add(txt_fakultetNomi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 180, -1));

        javax.swing.GroupLayout jInternal_FakultetLayout = new javax.swing.GroupLayout(jInternal_Fakultet.getContentPane());
        jInternal_Fakultet.getContentPane().setLayout(jInternal_FakultetLayout);
        jInternal_FakultetLayout.setHorizontalGroup(
            jInternal_FakultetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fakultet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternal_FakultetLayout.setVerticalGroup(
            jInternal_FakultetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternal_FakultetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fakultet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        fakultet.getAccessibleContext().setAccessibleParent(AsosiyDoc);

        jInternal_Yunalish.setClosable(true);
        jInternal_Yunalish.setIconifiable(true);
        jInternal_Yunalish.setTitle("Yo'nalishlar");
        jInternal_Yunalish.setVisible(false);

        yunalish.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setText("Yo'nalish id");
        yunalish.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel40.setText("Yo'nalish nomi");
        yunalish.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        butt_yunalish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_plus_1646001.png"))); // NOI18N
        butt_yunalish.setText("Yuklash");
        butt_yunalish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butt_yunalishActionPerformed(evt);
            }
        });
        yunalish.add(butt_yunalish, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));
        yunalish.add(text_yunalishId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 180, -1));

        text_Yunalishnomi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_YunalishnomiActionPerformed(evt);
            }
        });
        yunalish.add(text_Yunalishnomi, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 90, 180, -1));

        butt_uchirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Streamline-70_185090.png"))); // NOI18N
        butt_uchirish.setText("O'chirish");
        butt_uchirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butt_uchirishActionPerformed(evt);
            }
        });
        yunalish.add(butt_uchirish, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        butt_uzgartirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_update_172618.png"))); // NOI18N
        butt_uzgartirish.setText("O'zgartirish");
        butt_uzgartirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butt_uzgartirishActionPerformed(evt);
            }
        });
        yunalish.add(butt_uzgartirish, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        javax.swing.GroupLayout jInternal_YunalishLayout = new javax.swing.GroupLayout(jInternal_Yunalish.getContentPane());
        jInternal_Yunalish.getContentPane().setLayout(jInternal_YunalishLayout);
        jInternal_YunalishLayout.setHorizontalGroup(
            jInternal_YunalishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternal_YunalishLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yunalish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternal_YunalishLayout.setVerticalGroup(
            jInternal_YunalishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternal_YunalishLayout.createSequentialGroup()
                .addComponent(yunalish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        yunalish.getAccessibleContext().setAccessibleParent(AsosiyDoc);

        jInternal_YunalishGuruh.setClosable(true);
        jInternal_YunalishGuruh.setIconifiable(true);
        jInternal_YunalishGuruh.setTitle("Yo'nalishlar bo'yicha guruhlar");
        jInternal_YunalishGuruh.setVisible(false);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Streamline-70_185090.png"))); // NOI18N
        jButton14.setText("O'chirish");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_update_172618.png"))); // NOI18N
        jButton15.setText("O'zgartirish");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel51.setText("Ta'lim shakli");

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_plus_1646001.png"))); // NOI18N
        jButton16.setText("Yuklash");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        tx_fakultetNomi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_fakultetNomiActionPerformed(evt);
            }
        });

        comKursi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        comKursi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comKursiActionPerformed(evt);
            }
        });

        jLabel54.setText("Fakultet nomi");

        com_talimshakli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kunduzgi", "Sirtki", "Kechki" }));

        jLabel55.setText("Kursi");

        jLabel57.setText("Yo'nalish nomi");

        jLabel58.setText("Guruh nomi");

        jLabel59.setText("Talabalar soni");

        javax.swing.GroupLayout yunalish_guruhLayout = new javax.swing.GroupLayout(yunalish_guruh);
        yunalish_guruh.setLayout(yunalish_guruhLayout);
        yunalish_guruhLayout.setHorizontalGroup(
            yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yunalish_guruhLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(yunalish_guruhLayout.createSequentialGroup()
                        .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addGroup(yunalish_guruhLayout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53)))
                        .addGap(97, 97, 97)
                        .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comKursi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(com_talimshakli, 0, 180, Short.MAX_VALUE)))
                    .addGroup(yunalish_guruhLayout.createSequentialGroup()
                        .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57))
                        .addGap(86, 86, 86)
                        .addComponent(tx_yunalishNomi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yunalish_guruhLayout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addGap(103, 103, 103)
                        .addComponent(tx_guruhNomi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yunalish_guruhLayout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(92, 92, 92)
                        .addComponent(tx_fakultetNomi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(yunalish_guruhLayout.createSequentialGroup()
                        .addComponent(jButton16)
                        .addGap(27, 27, 27)
                        .addComponent(jButton15)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14))
                    .addGroup(yunalish_guruhLayout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addGap(88, 88, 88)
                        .addComponent(tx_talabalarSoni, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        yunalish_guruhLayout.setVerticalGroup(
            yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yunalish_guruhLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(yunalish_guruhLayout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel56)
                        .addGap(130, 130, 130))
                    .addGroup(yunalish_guruhLayout.createSequentialGroup()
                        .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_fakultetNomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))
                        .addGap(18, 18, 18)
                        .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(com_talimshakli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addGap(18, 18, 18)
                        .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comKursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addGap(18, 18, 18)
                        .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_yunalishNomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addGap(18, 18, 18)
                        .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_guruhNomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))
                        .addGap(18, 18, 18)
                        .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_talabalarSoni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))
                        .addGap(34, 34, 34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(yunalish_guruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton15)
                    .addComponent(jButton14))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jInternal_YunalishGuruhLayout = new javax.swing.GroupLayout(jInternal_YunalishGuruh.getContentPane());
        jInternal_YunalishGuruh.getContentPane().setLayout(jInternal_YunalishGuruhLayout);
        jInternal_YunalishGuruhLayout.setHorizontalGroup(
            jInternal_YunalishGuruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yunalish_guruh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternal_YunalishGuruhLayout.setVerticalGroup(
            jInternal_YunalishGuruhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yunalish_guruh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        yunalish_guruh.getAccessibleContext().setAccessibleParent(AsosiyDoc);

        jInternal_Kafedra.setClosable(true);
        jInternal_Kafedra.setIconifiable(true);
        jInternal_Kafedra.setTitle("Kafedralar");
        jInternal_Kafedra.setVisible(false);

        kafedra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        kafedra.add(Kaf_nomi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 190, -1));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Streamline-70_185090.png"))); // NOI18N
        jButton11.setText("O'chirish");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        kafedra.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, -1));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_update_172618.png"))); // NOI18N
        jButton12.setText("O'zgartirish");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        kafedra.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jLabel47.setText("Kafedra nomi");
        kafedra.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_plus_1646001.png"))); // NOI18N
        jButton13.setText("Yuklash");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        kafedra.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel49.setText("Fakultet nomi");
        kafedra.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        kafedra.add(Kaf_FakultetId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 190, -1));

        javax.swing.GroupLayout jInternal_KafedraLayout = new javax.swing.GroupLayout(jInternal_Kafedra.getContentPane());
        jInternal_Kafedra.getContentPane().setLayout(jInternal_KafedraLayout);
        jInternal_KafedraLayout.setHorizontalGroup(
            jInternal_KafedraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kafedra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternal_KafedraLayout.setVerticalGroup(
            jInternal_KafedraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternal_KafedraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kafedra, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kafedra.getAccessibleContext().setAccessibleParent(AsosiyDoc);

        YuklamaUqituvchi.setClosable(true);
        YuklamaUqituvchi.setIconifiable(true);
        YuklamaUqituvchi.setTitle("O'qituvchilarga yuklama taqsimlash bo'limi");
        YuklamaUqituvchi.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_teacher_writing_on_board_1741313.png"))); // NOI18N
        YuklamaUqituvchi.setVisible(true);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel42.setText("O'qituvchi");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 43, -1, -1));

        jLabel50.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel50.setText("Ta'lim shakli");
        jPanel3.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 87, -1, -1));

        jLabel60.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel60.setText("Kurs");
        jPanel3.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 131, -1, -1));

        jLabel61.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel61.setText("Yo'nalish");
        jPanel3.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 175, -1, -1));

        jLabel62.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel62.setText("Guruh");
        jPanel3.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 219, -1, -1));

        jLabel63.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel63.setText("Fan");
        jPanel3.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 263, -1, -1));

        jLabel64.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel64.setText("Ma'ruza soati");
        jPanel3.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 47, -1, -1));

        jLabel65.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel65.setText("Amaliyot soati");
        jPanel3.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 87, -1, -1));

        jLabel66.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel66.setText("Labaratoriya soati");
        jPanel3.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 131, -1, -1));

        jLabel67.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel67.setText("Seminar soati");
        jPanel3.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 175, -1, -1));

        jPanel3.add(UqitYuk_uqituvchi, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 40, 150, -1));

        UqitYuk_talimshakli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kunduzgi", "Sirtqi", "Kechki" }));
        jPanel3.add(UqitYuk_talimshakli, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 84, 150, -1));

        UqitYuk_kurs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        UqitYuk_kurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UqitYuk_kursActionPerformed(evt);
            }
        });
        jPanel3.add(UqitYuk_kurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 128, 150, -1));

        UqitYuk_yunalish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UqitYuk_yunalishActionPerformed(evt);
            }
        });
        jPanel3.add(UqitYuk_yunalish, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 172, 150, -1));

        jPanel3.add(UqitYuk_guruh, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 216, 150, -1));

        jPanel3.add(UqitYuk_fan, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 260, 150, -1));
        jPanel3.add(UqitYuk_mar, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 41, 150, -1));
        jPanel3.add(UqitYuk_amal, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 85, 150, -1));

        UqitYuk_lab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UqitYuk_labActionPerformed(evt);
            }
        });
        jPanel3.add(UqitYuk_lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 129, 150, -1));
        jPanel3.add(UqitYuk_sem, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 173, 150, -1));

        UqitYuk_qushish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_plus_1646001.png"))); // NOI18N
        UqitYuk_qushish.setText("Qo'shish");
        UqitYuk_qushish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UqitYuk_qushishActionPerformed(evt);
            }
        });
        jPanel3.add(UqitYuk_qushish, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 304, -1, -1));

        UqitYuk_tozala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_edit-clear_118917 (1).png"))); // NOI18N
        UqitYuk_tozala.setText("Tozalash");
        UqitYuk_tozala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UqitYuk_tozalaActionPerformed(evt);
            }
        });
        jPanel3.add(UqitYuk_tozala, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 304, -1, -1));

        UqitYuk_Uzgartir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_update_172618.png"))); // NOI18N
        UqitYuk_Uzgartir.setText("O'zgartirish");
        UqitYuk_Uzgartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UqitYuk_UzgartirActionPerformed(evt);
            }
        });
        jPanel3.add(UqitYuk_Uzgartir, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 304, -1, -1));

        UqitYuk_Uchir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Streamline-70_185090.png"))); // NOI18N
        UqitYuk_Uchir.setText("O'chirish");
        UqitYuk_Uchir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UqitYuk_UchirActionPerformed(evt);
            }
        });
        jPanel3.add(UqitYuk_Uchir, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 304, -1, -1));

        jLabel73.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel73.setText("Umumiy soati");
        jPanel3.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 219, -1, -1));
        jPanel3.add(UqitYuk_umum, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 217, 150, -1));

        javax.swing.GroupLayout YuklamaUqituvchiLayout = new javax.swing.GroupLayout(YuklamaUqituvchi.getContentPane());
        YuklamaUqituvchi.getContentPane().setLayout(YuklamaUqituvchiLayout);
        YuklamaUqituvchiLayout.setHorizontalGroup(
            YuklamaUqituvchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        YuklamaUqituvchiLayout.setVerticalGroup(
            YuklamaUqituvchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        YuklamaKafedra.setClosable(true);
        YuklamaKafedra.setIconifiable(true);
        YuklamaKafedra.setTitle("Kafedraga yuklama taqsimlash bo'limi");
        YuklamaKafedra.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_513_classroom_class_teacher_room_4212901.png"))); // NOI18N
        YuklamaKafedra.setMinimumSize(new java.awt.Dimension(897, 533));
        YuklamaKafedra.setVisible(false);

        jLabel68.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel68.setText("Kafedrani  tanlang:");

        jLabel69.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel69.setText("Fan");

        jLabel70.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel70.setText("Yo'nalish");

        jLabel71.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel71.setText("Semestr");

        jLabel72.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel72.setText("Talaba soni");

        jLabel74.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel74.setText("Amaliyot reja");

        jLabel75.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel75.setText("Amaliyot jami");

        jLabel76.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel76.setText("Labaratoriya reja");

        jLabel77.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel77.setText("Labaratoriya jami");

        YukKaf_labJami.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YukKaf_labJamiActionPerformed(evt);
            }
        });

        YukKaf_qushish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_plus_1646001.png"))); // NOI18N
        YukKaf_qushish.setText("Qo'shish");
        YukKaf_qushish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YukKaf_qushishActionPerformed(evt);
            }
        });

        YukKaf_Tozalash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_edit-clear_118917 (1).png"))); // NOI18N
        YukKaf_Tozalash.setText("Tozalash");
        YukKaf_Tozalash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YukKaf_TozalashActionPerformed(evt);
            }
        });

        YukKaf_Uzgar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_update_172618.png"))); // NOI18N
        YukKaf_Uzgar.setText("O'zgartirish");
        YukKaf_Uzgar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YukKaf_UzgarActionPerformed(evt);
            }
        });

        YukKaf_Uchir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Streamline-70_185090.png"))); // NOI18N
        YukKaf_Uchir.setText("O'chirish");
        YukKaf_Uchir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YukKaf_UchirActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel86.setText("Guruh soni");

        jLabel87.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel87.setText("Potok soni");

        jLabel88.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel88.setText("Maruza reja");

        jLabel89.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel89.setText("Maruza jami");

        jLabel84.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel84.setText("Nazorat ishi");

        jLabel85.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel85.setText("Kurs ishi");

        jLabel90.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel90.setText("BMI va Mag.diss");

        jLabel91.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel91.setText("DAK");

        jLabel92.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel92.setText("Jami");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel68)
                        .addGap(37, 37, 37)
                        .addComponent(Kafedra_Kaftanlash, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(YukKaf_qushish)
                                        .addComponent(jLabel88)
                                        .addComponent(jLabel87)
                                        .addComponent(jLabel86)
                                        .addComponent(jLabel89)
                                        .addComponent(jLabel74))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel71)
                                            .addComponent(jLabel72)
                                            .addComponent(jLabel70))
                                        .addGap(39, 39, 39)))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(YukKaf_semestr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(YukKaf_TalSoni, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(YukKaf_GurSoni, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                            .addGap(127, 127, 127)
                                                            .addComponent(YukKaf_PotokSoni, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(YukKaf_marReja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(YukKaf_marJami, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(YukKaf_amalReja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(YukKaf_yunalish, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(115, 115, 115))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(YukKaf_Tozalash)
                                                .addGap(68, 68, 68)))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(YukKaf_Uzgar)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel75)
                                                    .addComponent(jLabel76)
                                                    .addComponent(jLabel77)
                                                    .addComponent(jLabel84)
                                                    .addComponent(jLabel85)
                                                    .addComponent(jLabel90)
                                                    .addComponent(jLabel91)
                                                    .addComponent(jLabel92)))))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel69)
                                        .addGap(102, 102, 102)
                                        .addComponent(YukKaf_fan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(YukKaf_nazorat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YukKaf_KursIshi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YukKaf_BMI, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YukKaf_DAK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YukKaf_Jami, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YukKaf_Uchir, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(YukKaf_amalJami, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YukKaf_labReja, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YukKaf_labJami, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel68))
                    .addComponent(Kafedra_Kaftanlash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(YukKaf_amalJami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(YukKaf_fan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YukKaf_yunalish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70)
                            .addComponent(jLabel76))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(YukKaf_semestr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel71))
                            .addComponent(jLabel77))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YukKaf_TalSoni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(YukKaf_labReja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(YukKaf_labJami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YukKaf_nazorat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel86))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YukKaf_GurSoni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel85)
                            .addComponent(YukKaf_KursIshi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YukKaf_PotokSoni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87)
                            .addComponent(YukKaf_BMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel90))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YukKaf_marReja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88)
                            .addComponent(YukKaf_DAK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(YukKaf_marJami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel89)
                                .addComponent(jLabel92))
                            .addComponent(YukKaf_Jami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YukKaf_amalReja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YukKaf_Uchir)
                            .addComponent(YukKaf_Uzgar)
                            .addComponent(YukKaf_qushish))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YukKaf_Tozalash)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout YuklamaKafedraLayout = new javax.swing.GroupLayout(YuklamaKafedra.getContentPane());
        YuklamaKafedra.getContentPane().setLayout(YuklamaKafedraLayout);
        YuklamaKafedraLayout.setHorizontalGroup(
            YuklamaKafedraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YuklamaKafedraLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        YuklamaKafedraLayout.setVerticalGroup(
            YuklamaKafedraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        SidebarForm.setBackground(new java.awt.Color(51, 51, 51));
        SidebarForm.setToolTipText("");
        SidebarForm.setAutoscrolls(true);
        SidebarForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SidebarForm.setFocusCycleRoot(true);
        SidebarForm.setMaximumSize(new java.awt.Dimension(200, 700));
        SidebarForm.setPreferredSize(new java.awt.Dimension(200, 591));

        btn_Reg.setBackground(new java.awt.Color(0, 204, 204));
        btn_Reg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Reg.setText("Registratsiya");
        btn_Reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 153));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Ro'yxatga olish");
        jLabel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btn_Uqituvchilar.setBackground(new java.awt.Color(0, 204, 204));
        btn_Uqituvchilar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btn_Uqituvchilar.setText("O'qituvchilar bazasi");
        btn_Uqituvchilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UqituvchilarActionPerformed(evt);
            }
        });

        btn_KafedraMudiri.setBackground(new java.awt.Color(0, 204, 204));
        btn_KafedraMudiri.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        btn_KafedraMudiri.setText("Kafedra yuklamasi");
        btn_KafedraMudiri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KafedraMudiriActionPerformed(evt);
            }
        });

        btn_UqituvchiYuklama.setBackground(new java.awt.Color(0, 204, 204));
        btn_UqituvchiYuklama.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        btn_UqituvchiYuklama.setText("O'qituvchi yuklamasi");
        btn_UqituvchiYuklama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UqituvchiYuklamaActionPerformed(evt);
            }
        });

        btn_uquvReja.setBackground(new java.awt.Color(0, 204, 204));
        btn_uquvReja.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        btn_uquvReja.setText("O'quv rejalar bazasi ");
        btn_uquvReja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uquvRejaActionPerformed(evt);
            }
        });

        btn_fakultet.setBackground(new java.awt.Color(0, 204, 204));
        btn_fakultet.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        btn_fakultet.setText("Fakultet tahrirlash");
        btn_fakultet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fakultetActionPerformed(evt);
            }
        });

        btn_kafedra.setBackground(new java.awt.Color(0, 204, 204));
        btn_kafedra.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        btn_kafedra.setText("Kafedra tahrirlash");
        btn_kafedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kafedraActionPerformed(evt);
            }
        });

        btn_yunalish.setBackground(new java.awt.Color(0, 204, 204));
        btn_yunalish.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        btn_yunalish.setText("Yo'nalish tahrirlash");
        btn_yunalish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yunalishActionPerformed(evt);
            }
        });

        btn_guruh.setBackground(new java.awt.Color(0, 204, 204));
        btn_guruh.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        btn_guruh.setText("Guruh tahrirlash");
        btn_guruh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guruhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidebarFormLayout = new javax.swing.GroupLayout(SidebarForm);
        SidebarForm.setLayout(SidebarFormLayout);
        SidebarFormLayout.setHorizontalGroup(
            SidebarFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Reg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_UqituvchiYuklama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_KafedraMudiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Uqituvchilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_kafedra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_yunalish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_guruh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_uquvReja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_fakultet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidebarFormLayout.setVerticalGroup(
            SidebarFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarFormLayout.createSequentialGroup()
                .addComponent(btn_UqituvchiYuklama, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_KafedraMudiri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Uqituvchilar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_uquvReja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_fakultet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_kafedra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_yunalish, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_guruh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SidebarForm1.setBackground(new java.awt.Color(51, 51, 51));
        SidebarForm1.setToolTipText("");
        SidebarForm1.setAutoscrolls(true);
        SidebarForm1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SidebarForm1.setFocusCycleRoot(true);
        SidebarForm1.setMaximumSize(new java.awt.Dimension(200, 700));
        SidebarForm1.setPreferredSize(new java.awt.Dimension(200, 591));

        btn_Reg1.setBackground(new java.awt.Color(0, 204, 204));
        btn_Reg1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Reg1.setText("Registratsiya");
        btn_Reg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Reg1ActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 153, 153));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Ro'yxatga olish");
        jLabel83.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btn_Uqituvchilar1.setBackground(new java.awt.Color(0, 204, 204));
        btn_Uqituvchilar1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        btn_Uqituvchilar1.setText("O'qituvchilar bazasi");
        btn_Uqituvchilar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Uqituvchilar1ActionPerformed(evt);
            }
        });

        btn_UqituvchiYuklama1.setBackground(new java.awt.Color(0, 204, 204));
        btn_UqituvchiYuklama1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 14)); // NOI18N
        btn_UqituvchiYuklama1.setText("O'qituvchi yuklamasi");
        btn_UqituvchiYuklama1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UqituvchiYuklama1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidebarForm1Layout = new javax.swing.GroupLayout(SidebarForm1);
        SidebarForm1.setLayout(SidebarForm1Layout);
        SidebarForm1Layout.setHorizontalGroup(
            SidebarForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Reg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_UqituvchiYuklama1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Uqituvchilar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidebarForm1Layout.setVerticalGroup(
            SidebarForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarForm1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_UqituvchiYuklama1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Uqituvchilar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Reg1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Dasturchi.setClosable(true);
        Dasturchi.setTitle("Dastur va G'oya mualliflari");
        Dasturchi.setVisible(false);

        jTextField1.setText("Dastur muallifi: TATU Urganch filiali 941-18 guruh talabasi MADAMINOV SHAYXNAZAR");

        jTextField2.setText("G'oya muallifi: TATU Urganch filiali Dasturiy injiniringi kafedra mudiri KURYAZOV DILSHOD");

        javax.swing.GroupLayout DasturchiLayout = new javax.swing.GroupLayout(Dasturchi.getContentPane());
        Dasturchi.getContentPane().setLayout(DasturchiLayout);
        DasturchiLayout.setHorizontalGroup(
            DasturchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DasturchiLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(DasturchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        DasturchiLayout.setVerticalGroup(
            DasturchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DasturchiLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jMenuBar1.setBackground(new java.awt.Color(71, 120, 190));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(106, 20));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Account_1891016_2.png"))); // NOI18N
        jMenu1.setText("Tizimni boshqarish");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        menu_kirish.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_MASK));
        menu_kirish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Login_in_85205 (1).png"))); // NOI18N
        menu_kirish.setText("Kirish");
        menu_kirish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_kirishActionPerformed(evt);
            }
        });
        jMenu1.add(menu_kirish);

        menu_registratsiya.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menu_registratsiya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_7_1173387 (1).png"))); // NOI18N
        menu_registratsiya.setText("Ro'yxatga olish");
        menu_registratsiya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_registratsiyaActionPerformed(evt);
            }
        });
        jMenu1.add(menu_registratsiya);

        menu_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        menu_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_Login_out_85206 (1).png"))); // NOI18N
        menu_exit.setText("Chiqish");
        menu_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_exitActionPerformed(evt);
            }
        });
        jMenu1.add(menu_exit);
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Dastur haqida");

        jMenuItem1.setText("Dasturchi");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(SignUpFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(uquv_reja, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addComponent(LoginFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(jInternal_YunalishGuruh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(YuklamaUqituvchi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(621, 621, 621)
                        .addComponent(jInternal_Kafedra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(621, 621, 621)
                        .addComponent(YuklamaKafedra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(621, 621, 621)
                        .addComponent(jInternal_Fakultet, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(UqituvchiFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(720, 720, 720)
                        .addComponent(SidebarForm, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(NewPassFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(621, 621, 621)
                        .addComponent(jInternal_Yunalish, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(722, Short.MAX_VALUE))
            .addComponent(AsosiyDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 1442, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(548, Short.MAX_VALUE)
                    .addComponent(Dasturchi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(894, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(SignUpFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(uquv_reja, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(LoginFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jInternal_YunalishGuruh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(YuklamaUqituvchi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jInternal_Kafedra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(YuklamaKafedra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jInternal_Fakultet, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(UqituvchiFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addComponent(SidebarForm, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(NewPassFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jInternal_Yunalish, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 203, Short.MAX_VALUE))
            .addComponent(AsosiyDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(256, Short.MAX_VALUE)
                    .addComponent(Dasturchi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
        );

        AsosiyDoc.getAccessibleContext().setAccessibleName("");
        LoginFrame.getAccessibleContext().setAccessibleParent(AsosiyDoc);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_kirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_kirishActionPerformed
            this.LoginFrame.setLocation(400, 50);
            this.LoginFrame.setSize(476, 289);
            this.LoginFrame.setVisible(true);
            this.AsosiyDoc.add(this.LoginFrame);
    }//GEN-LAST:event_menu_kirishActionPerformed

    private void sign_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sign_loginActionPerformed

    private void sign_parolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_parolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sign_parolActionPerformed

    private void bt_yuklashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_yuklashActionPerformed
        PreparedStatement ps;
        String query = "INSERT INTO users (kafedra_id, familiya, ism, sharif, tug_sana, kabul_sanasi, buyruq_raqami, lavozimi, tugatgan_OTM,OTM_tug_vaqti,ped_staji,ilmiy_unvoni,ilmiy_daraja) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, Uqit_kafedra.getSelectedItem().toString());
            ps.setString(2, Uqit_fami.getText());
            ps.setString(3, Uqit_ism.getText());
            ps.setString(4, Uqit_sharifi.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(5, dateFormat.format(Uqit_bdate.getDate()));
            ps.setString(6, dateFormat.format(Uqit_qabul_date.getDate()));
            ps.setString(7, Uqit_buyruqRaq.getText());
            ps.setString(8, Uqit_lavozim.getSelectedItem().toString());
            ps.setString(9, Uqit_OTMnomi.getText());
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy");
            ps.setString(10, dateFormat2.format(Uqit_Tugat_Yili.getYear()));
            ps.setString(11, Uqit_Staj.getText());
            ps.setString(12, Uqit_Unvon.getText());
            ps.setString(13, Uqit_Daraja.getText());
                       
            ps.executeUpdate();
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "New User Add!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
             
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_bt_yuklashActionPerformed

    private void bt_tozalashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tozalashActionPerformed
            Uqit_Daraja.setText("");
            Uqit_OTMnomi.setText("");
            Uqit_Staj.setText("");
            Uqit_Unvon.setText("");
            Uqit_buyruqRaq.setText("");
            Uqit_fami.setText("");
            Uqit_ism.setText("");
            Uqit_sharifi.setText("");
                    
    }//GEN-LAST:event_bt_tozalashActionPerformed

    private void but_uchirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_uchirishActionPerformed
            
    }//GEN-LAST:event_but_uchirishActionPerformed

    private void but_uzgartirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_uzgartirishActionPerformed
       
    }//GEN-LAST:event_but_uzgartirishActionPerformed

    private void Uqit_lavozimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uqit_lavozimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uqit_lavozimActionPerformed

    private void Uqit_ismActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uqit_ismActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uqit_ismActionPerformed

    private void Uqit_kafedraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uqit_kafedraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uqit_kafedraActionPerformed

    private void Uqit_fakultetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uqit_fakultetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uqit_fakultetActionPerformed

    private void btn_RegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegActionPerformed
        this.SignUpFrame.setLocation(200, 10);
        this.SignUpFrame.setSize(518, 458);
        this.SignUpFrame.setVisible(true);
        this.AsosiyDoc.add(this.SignUpFrame);
    }//GEN-LAST:event_btn_RegActionPerformed

    private void jpass_parol1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpass_parol1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpass_parol1ActionPerformed

    private void jpass_parol2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpass_parol2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpass_parol2ActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_okActionPerformed

    private void sign_kirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_kirishActionPerformed
        Connection con;
        try {
            con = MyConnection.getConnection();
            String query = "SELECT * FROM users WHERE login =? AND turi=? AND parol =?"; 
            PreparedStatement ps;
            ps = con.prepareStatement(query);
            String turi = huquq_tanlash.getSelectedItem().toString();
            ps.setString(1, sign_login.getText());
            ps.setString(2, turi);
            ps.setString(3, String.valueOf(sign_parol.getPassword()));
            
            ResultSet rs = ps.executeQuery();
            if(rs.next() && turi.equals("Administrator")){
               // JOptionPane.showMessageDialog(jDesktopPane1, "Login Admin!");
                this.SidebarForm.setLocation(0, 0);
                this.SidebarForm.setSize(200, 625);
                this.SidebarForm.setVisible(true);
                this.LoginFrame.setVisible(false);
                this.AsosiyDoc.add(this.SidebarForm);
            }else if(rs.next()&& turi.equals("Kafedra mudiri")){
               // JOptionPane.showMessageDialog(jDesktopPane1, "Login Kafedra Mudiri!");
                this.SidebarForm1.setLocation(0, 0);
                this.SidebarForm1.setSize(200, 625);
                this.SidebarForm1.setVisible(true);
                this.LoginFrame.setVisible(false);
                this.AsosiyDoc.add(this.SidebarForm1);
            }
            else if(rs.next()){
               JOptionPane.showMessageDialog(AsosiyDoc, "Login O'qituvchi!");
             
            }
            else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Login error!");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_sign_kirishActionPerformed

    private void Uquv_uquv_yiliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_uquv_yiliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_uquv_yiliActionPerformed

    private void Uquv_fanBlokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_fanBlokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_fanBlokActionPerformed

    private void Uquv_fankodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_fankodiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_fankodiActionPerformed

    private void Uquv_fanNomiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_fanNomiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_fanNomiActionPerformed

    private void Uquv_fanKreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_fanKreditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_fanKreditActionPerformed

    private void Uquv_UmumSoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_UmumSoatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_UmumSoatActionPerformed

    private void Uquv_MarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_MarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_MarActionPerformed

    private void Uquv_amalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_amalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_amalActionPerformed

    private void Uquv_labsoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_labsoatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_labsoatActionPerformed

    private void Uquv_seminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_seminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_seminarActionPerformed

    private void Uquv_musTalimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_musTalimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_musTalimActionPerformed

    private void Uquv_tozalashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_tozalashActionPerformed
        Uquv_Mar.setText("");
        Uquv_seminar.setText("");
        Uquv_amal.setText("");
        Uquv_fanKredit.setText("");
        Uquv_fanBlok.setText("");
        Uquv_UmumSoat.setText("");
        Uquv_fankodi.setText("");
        Uquv_fanNomi.setText("");
        Uquv_labsoat.setText("");
        Uquv_musTalim.setText("");
        Uquv_uquv_yili.setText("");
    }//GEN-LAST:event_Uquv_tozalashActionPerformed

    private void menu_registratsiyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_registratsiyaActionPerformed
        this.SignUpFrame.setLocation(200, 10);
        this.SignUpFrame.setSize(518, 458);
        this.SignUpFrame.setVisible(true);
        this.AsosiyDoc.add(this.SignUpFrame);
    }//GEN-LAST:event_menu_registratsiyaActionPerformed

    private void btn_UqituvchilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UqituvchilarActionPerformed
        this.UqituvchiFrame.setLocation(200, 10);
        this.UqituvchiFrame.setSize(867, 460);
        this.UqituvchiFrame.setVisible(true);
        this.AsosiyDoc.add(this.UqituvchiFrame);
           
    }//GEN-LAST:event_btn_UqituvchilarActionPerformed

    private void btn_UqituvchiYuklamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UqituvchiYuklamaActionPerformed
        this.YuklamaUqituvchi.setLocation(200, 10);
        this.YuklamaUqituvchi.setSize(841, 411);
        this.YuklamaUqituvchi.setVisible(true);
        this.AsosiyDoc.add(this.YuklamaUqituvchi);
    }//GEN-LAST:event_btn_UqituvchiYuklamaActionPerformed

    private void reg_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_cancelActionPerformed
        reg_ism.setText("");
        reg_fam.setText("");
        reg_login.setText("");
        reg_pass.setText("");
        reg_retypePass.setText("");
        reg_email.setText("");
    }//GEN-LAST:event_reg_cancelActionPerformed

    private void reg_qushishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_qushishActionPerformed
        
        if(checkInputs()){
        
        PreparedStatement ps;
         Connection con;
        String query= "INSERT INTO users (ism , familiya, turi , login, parol, email) VALUES (?, ?, ?, ?, ?, ?)";
       // String query2 = "UPDATE uqituvchi SET login=?, parol=?, email=? WHERE  ism=? familiya=?";
        try {
           con =MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, reg_ism.getText());
           ps.setString(2, reg_fam.getText());
           ps.setString(3, reg_foydalanuvchi.getSelectedItem().toString());
           ps.setString(4, reg_login.getText());
           ps.setString(5,String.valueOf(reg_pass.getPassword()));
           ps.setString(6, reg_email.getText());    
           
           
           if(isUsernameExist(reg_login.getText())){
                JOptionPane.showMessageDialog(AsosiyDoc, "Bunday foydalanuvchi tizimda mavjud!");
           }else{
                ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "New User Add!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
           }     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
        JOptionPane.showMessageDialog(AsosiyDoc, "Bir yoki Ko'proq Joy Bo'sh!");
        }
        
    }//GEN-LAST:event_reg_qushishActionPerformed

    private void reg_foydalanuvchiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_foydalanuvchiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reg_foydalanuvchiActionPerformed

    private void Parol_yangiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parol_yangiMousePressed
       
    }//GEN-LAST:event_Parol_yangiMousePressed

    private void butt_yunalishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butt_yunalishActionPerformed
        PreparedStatement ps;
        Connection con;
        String query= "INSERT INTO yunalish (id, nomi) VALUES (?, ?)";
        try {
           con =MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, text_yunalishId.getText());
           ps.setString(2, text_Yunalishnomi.getText());    
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Yangi yunalish qo'shildi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butt_yunalishActionPerformed

    private void butt_uchirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butt_uchirishActionPerformed
        PreparedStatement ps;
        Connection con;
        String query= "Delete from `yunalish` WHERE `id`=?";
        try {
           con = MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, text_yunalishId.getText());
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Fakultet o'chirildi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butt_uchirishActionPerformed

    private void butt_uzgartirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butt_uzgartirishActionPerformed
        PreparedStatement ps;
        Connection con;
        String query= "UPDATE `yunalish` SET nomi=? WHERE `id`=?";
        try {
           con = MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, text_Yunalishnomi.getText());
           ps.setString(2, text_yunalishId.getText());    
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Yo'nalish Yangilandi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butt_uzgartirishActionPerformed

    private void btn_UchirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UchirishActionPerformed
        PreparedStatement ps;
        Connection con;
        String query= "Delete from `fakultet` WHERE `id`=?";
        try {
           con = MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, txt_fakultetNomi.getText());
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Fakultet o'chirildi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_UchirishActionPerformed

    private void btn_UzgartirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UzgartirishActionPerformed
        PreparedStatement ps;
        Connection con;
        String query= "UPDATE `fakultet` SET nomi=? WHERE `id`=?";
        try {
           con = MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, txt_fakultetNomi.getText());
           ps.setString(2, txt_fakultetId.getText());    
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Fakultet yangilandi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_UzgartirishActionPerformed

    private void btn_YuklashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_YuklashActionPerformed
        PreparedStatement ps;
        Connection con;
        String query= "INSERT INTO fakultet (id, nomi) VALUES (?, ?)";
        try {
           con =MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, txt_fakultetId.getText());
           ps.setString(2, txt_fakultetNomi.getText());    
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Yangi fakultet qo'shildi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_YuklashActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        PreparedStatement ps;
        Connection con;
        String query= "INSERT INTO yunalish_guruh ( Select id from fakultet where nomi =? , talim_shakli, kursi,"
                + "Select id from yunalish where nomi =?,guruh_nomi,tal_soni ) VALUES (?,?,?,?,?,?)";
        try {
           con =MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, tx_fakultetNomi.getText());
           ps.setString(2, com_talimshakli.getSelectedItem().toString()); 
           ps.setString(3, comKursi.getSelectedItem().toString()); 
           ps.setString(4, tx_yunalishNomi.getText());
           ps.setString(5, tx_guruhNomi.getText());
           ps.setString(6, tx_talabalarSoni.getText());
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Yangi fakultet qo'shildi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        PreparedStatement ps;
        Connection con;
        String query= "INSERT INTO kafedra (fakultet_id, nomi) VALUES (?, ?)";
        try {
           con =MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, Kaf_FakultetId.getSelectedItem().toString());
           ps.setString(2, Kaf_nomi.getText());    
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Yangi kafedra qo'shildi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       PreparedStatement ps;
        Connection con;
        String query= "Delete from `fakultet` WHERE `id`=?";
        try {
           con = MyConnection.getConnection();
           ps = con.prepareStatement(query);
           ps.setString(1, txt_fakultetNomi.getText());
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Fakultet o'chirildi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        txt_log.setText("");
        txt_email.setText("");
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void AsosiyDocComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AsosiyDocComponentResized
       
    }//GEN-LAST:event_AsosiyDocComponentResized

    private void UqitYuk_qushishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UqitYuk_qushishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UqitYuk_qushishActionPerformed

    private void UqitYuk_tozalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UqitYuk_tozalaActionPerformed
       
    }//GEN-LAST:event_UqitYuk_tozalaActionPerformed

    private void UqitYuk_UzgartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UqitYuk_UzgartirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UqitYuk_UzgartirActionPerformed

    private void UqitYuk_UchirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UqitYuk_UchirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UqitYuk_UchirActionPerformed

    private void YukKaf_qushishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YukKaf_qushishActionPerformed
        PreparedStatement ps;
        Connection con;
        String query= "INSERT INTO kafedra_yuklama ( nomi) VALUES (?, ?)";
        try {
           con =MyConnection.getConnection();
           ps = con.prepareStatement(query);
            
           ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "Yangi yuklama qo'shildi!");
                }else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");
                }
  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishhda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_YukKaf_qushishActionPerformed

    private void YukKaf_TozalashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YukKaf_TozalashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YukKaf_TozalashActionPerformed

    private void YukKaf_UzgarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YukKaf_UzgarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YukKaf_UzgarActionPerformed

    private void YukKaf_UchirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YukKaf_UchirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YukKaf_UchirActionPerformed

    private void Uquv_uchirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_uchirishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_uchirishActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
                  
    }//GEN-LAST:event_formWindowActivated

    private void menu_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_exitActionPerformed
        this.SidebarForm.setVisible(false);
        this.SidebarForm1.setVisible(false);
        this.sign_parol.setText("");
        this.sign_login.setText("");
    }//GEN-LAST:event_menu_exitActionPerformed

    private void text_YunalishnomiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_YunalishnomiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_YunalishnomiActionPerformed

    private void comKursiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comKursiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comKursiActionPerformed

    private void tx_fakultetNomiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_fakultetNomiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_fakultetNomiActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            sign_parol.setEchoChar((char)0);
        }else{
            sign_parol.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
       if(jCheckBox2.isSelected()){
            reg_pass.setEchoChar((char)0);
        }else{
            reg_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
       if(jCheckBox3.isSelected()){
            reg_retypePass.setEchoChar((char)0);
        }else{
            reg_retypePass.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jLabel82MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MousePressed
        
    }//GEN-LAST:event_jLabel82MousePressed

    private void sign_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_cancelActionPerformed
        sign_login.setText("");
        sign_parol.setText("");
    }//GEN-LAST:event_sign_cancelActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        
    }//GEN-LAST:event_formComponentAdded

    private void Parol_yangiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parol_yangiMouseClicked
        this.LoginFrame.setVisible(false);
        this.SignUpFrame.setLocation(200, 10);
        this.SignUpFrame.setSize(518, 458);
        this.SignUpFrame.setVisible(true);
        this.AsosiyDoc.add(this.SignUpFrame);   
    }//GEN-LAST:event_Parol_yangiMouseClicked

    private void btn_Reg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Reg1ActionPerformed
        this.SignUpFrame.setLocation(200, 10);
        this.SignUpFrame.setSize(518, 458);
        this.SignUpFrame.setVisible(true);
        this.AsosiyDoc.add(this.SignUpFrame);
    }//GEN-LAST:event_btn_Reg1ActionPerformed

    private void btn_Uqituvchilar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Uqituvchilar1ActionPerformed
         this.UqituvchiFrame.setLocation(200, 10);
        this.UqituvchiFrame.setSize(867, 460);
        this.UqituvchiFrame.setVisible(true);
        this.AsosiyDoc.add(this.UqituvchiFrame);
    }//GEN-LAST:event_btn_Uqituvchilar1ActionPerformed

    private void btn_UqituvchiYuklama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UqituvchiYuklama1ActionPerformed
        this.YuklamaUqituvchi.setLocation(200, 10);
        this.YuklamaUqituvchi.setSize(841, 411);
        this.YuklamaUqituvchi.setVisible(true);
        this.AsosiyDoc.add(this.YuklamaUqituvchi);
    }//GEN-LAST:event_btn_UqituvchiYuklama1ActionPerformed

    private void btn_KafedraMudiriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KafedraMudiriActionPerformed
        this.YuklamaKafedra.setLocation(200, 10);
        this.YuklamaKafedra.setSize(851, 563);
        this.YuklamaKafedra.setVisible(true);
        this.AsosiyDoc.add(this.YuklamaKafedra);

    }//GEN-LAST:event_btn_KafedraMudiriActionPerformed

    private void btn_uquvRejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uquvRejaActionPerformed
        this.uquv_reja.setLocation(200, 10);
        this.uquv_reja.setSize(760, 440);
        this.uquv_reja.setVisible(true);
        this.AsosiyDoc.add(this.uquv_reja);
    }//GEN-LAST:event_btn_uquvRejaActionPerformed

    private void btn_fakultetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fakultetActionPerformed
        this.jInternal_Fakultet.setLocation(200, 10);
        this.jInternal_Fakultet.setSize(456, 252);
        this.jInternal_Fakultet.setVisible(true);
        this.AsosiyDoc.add(this.jInternal_Fakultet);
    }//GEN-LAST:event_btn_fakultetActionPerformed

    private void btn_kafedraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kafedraActionPerformed
       this.jInternal_Kafedra.setLocation(200, 10);
        this.jInternal_Kafedra.setSize(502, 290);
        this.jInternal_Kafedra.setVisible(true);
        this.AsosiyDoc.add(this.jInternal_Kafedra);
    }//GEN-LAST:event_btn_kafedraActionPerformed

    private void btn_yunalishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yunalishActionPerformed
        this.jInternal_Yunalish.setLocation(200, 10);
        this.jInternal_Yunalish.setSize(428, 270);
        this.jInternal_Yunalish.setVisible(true);
        this.AsosiyDoc.add(this.jInternal_Yunalish);
    }//GEN-LAST:event_btn_yunalishActionPerformed

    private void btn_guruhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guruhActionPerformed
         this.jInternal_YunalishGuruh.setLocation(200, 10);
        this.jInternal_YunalishGuruh.setSize(454, 405);
        this.jInternal_YunalishGuruh.setVisible(true);
        this.AsosiyDoc.add(this.jInternal_YunalishGuruh);
    }//GEN-LAST:event_btn_guruhActionPerformed

    private void jLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseClicked
        this.SignUpFrame.setVisible(false);
        this.LoginFrame.setLocation(200, 10);
        this.LoginFrame.setSize(460, 308);
        this.LoginFrame.setVisible(true);
        this.AsosiyDoc.add(this.LoginFrame);
    }//GEN-LAST:event_jLabel82MouseClicked

    private void Uquv_yuklashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_yuklashActionPerformed
        if(checkUquvReja()){
            PreparedStatement ps;
            Connection con;
            String query= "INSERT INTO `uquv_reja`( `talim_shakli`, `uquv_yili`, `semestr`, `yunalish_id`, `fan_blok`, `fan_kodi`, `fan_nomi`, `fan_krediti`, `fan_umumiy_soat`, `maruza_soat`, `amaliyot_soat`, `lab_soat`, `seminar_soat`, `mus_tal_soat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // String query2 = "UPDATE uqituvchi SET login=?, parol=?, email=? WHERE  ism=? familiya=?";
        try {
            con =MyConnection.getConnection();
            ps = con.prepareStatement(query);
             ps.setString(1, Uquv_talimShakli.getSelectedItem().toString());
             ps.setString(2, Uquv_uquv_yili.getText());
             ps.setString(3, Uquv_semestr.getSelectedItem().toString());
             ps.setString(4, Uquv_yunalish.getSelectedItem().toString());
             ps.setString(5, Uquv_fanBlok.getText());
             ps.setString(6, Uquv_fankodi.getText());
             ps.setString(7, Uquv_fanNomi.getText());
             ps.setString(8, Uquv_fanKredit.getText());
             ps.setString(9, Uquv_UmumSoat.getText());
             ps.setString(10, Uquv_Mar.getText());
             ps.setString(11, Uquv_amal.getText());
             ps.setString(12, Uquv_labsoat.getText());
             ps.setString(13, Uquv_seminar.getText());
             ps.setString(13, Uquv_musTalim.getText());
               
             ps.executeUpdate(); 
                if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(AsosiyDoc, "New Data Add!");
                }
                else{
                JOptionPane.showMessageDialog(AsosiyDoc, "Xato Mavjud!");      
           }     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(AsosiyDoc, "Ulanishda xatolik bo'ldi!");
            Logger.getLogger(OquvRejaYuklash.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }else{
             JOptionPane.showMessageDialog(AsosiyDoc, "Bir yoki Ko'p maydonlar bo'sh!");
             
        }
    }//GEN-LAST:event_Uquv_yuklashActionPerformed

    private void YukKaf_labJamiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YukKaf_labJamiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YukKaf_labJamiActionPerformed

    private void reg_qushishKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reg_qushishKeyPressed
        
    }//GEN-LAST:event_reg_qushishKeyPressed

    private void reg_qushishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reg_qushishMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_reg_qushishMouseClicked

    private void UqitYuk_kursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UqitYuk_kursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UqitYuk_kursActionPerformed

    private void UqitYuk_yunalishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UqitYuk_yunalishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UqitYuk_yunalishActionPerformed

    private void Uquv_uzgartirishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Uquv_uzgartirishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Uquv_uzgartirishActionPerformed

    private void UqitYuk_labActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UqitYuk_labActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UqitYuk_labActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.Dasturchi.setLocation(200, 10);
        this.Dasturchi.setSize(569, 183);
        this.Dasturchi.setVisible(true);
        this.AsosiyDoc.add(this.Dasturchi);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(OquvRejaYuklash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OquvRejaYuklash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OquvRejaYuklash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OquvRejaYuklash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OquvRejaYuklash().setVisible(true);
                         
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane AsosiyDoc;
    private javax.swing.JInternalFrame Dasturchi;
    private javax.swing.JComboBox<String> Kaf_FakultetId;
    private javax.swing.JTextField Kaf_nomi;
    private javax.swing.JComboBox<String> Kafedra_Kaftanlash;
    private javax.swing.JInternalFrame LoginFrame;
    private javax.swing.JInternalFrame NewPassFrame;
    private javax.swing.JLabel Parol_yangi;
    private javax.swing.JPanel SidebarForm;
    private javax.swing.JPanel SidebarForm1;
    private javax.swing.JInternalFrame SignUpFrame;
    private javax.swing.JButton UqitYuk_Uchir;
    private javax.swing.JButton UqitYuk_Uzgartir;
    private javax.swing.JTextField UqitYuk_amal;
    private javax.swing.JComboBox<String> UqitYuk_fan;
    private javax.swing.JComboBox<String> UqitYuk_guruh;
    private javax.swing.JComboBox<String> UqitYuk_kurs;
    private javax.swing.JTextField UqitYuk_lab;
    private javax.swing.JTextField UqitYuk_mar;
    private javax.swing.JButton UqitYuk_qushish;
    private javax.swing.JTextField UqitYuk_sem;
    private javax.swing.JComboBox<String> UqitYuk_talimshakli;
    private javax.swing.JButton UqitYuk_tozala;
    private javax.swing.JTextField UqitYuk_umum;
    private javax.swing.JComboBox<String> UqitYuk_uqituvchi;
    private javax.swing.JComboBox<String> UqitYuk_yunalish;
    private javax.swing.JTextField Uqit_Daraja;
    private javax.swing.JTextField Uqit_OTMnomi;
    private javax.swing.JTextField Uqit_Staj;
    private com.toedter.calendar.JYearChooser Uqit_Tugat_Yili;
    private javax.swing.JTextField Uqit_Unvon;
    private com.toedter.calendar.JDateChooser Uqit_bdate;
    private javax.swing.JTextField Uqit_buyruqRaq;
    private javax.swing.JComboBox<String> Uqit_fakultet;
    private javax.swing.JTextField Uqit_fami;
    private javax.swing.JTextField Uqit_ism;
    private javax.swing.JComboBox<String> Uqit_kafedra;
    private javax.swing.JComboBox<String> Uqit_lavozim;
    private com.toedter.calendar.JDateChooser Uqit_qabul_date;
    private javax.swing.JTextField Uqit_sharifi;
    private javax.swing.JInternalFrame UqituvchiFrame;
    private javax.swing.JTextField Uquv_Mar;
    private javax.swing.JTextField Uquv_UmumSoat;
    private javax.swing.JTextField Uquv_amal;
    private javax.swing.JTextField Uquv_fanBlok;
    private javax.swing.JTextField Uquv_fanKredit;
    private javax.swing.JTextField Uquv_fanNomi;
    private javax.swing.JTextField Uquv_fankodi;
    private javax.swing.JTextField Uquv_labsoat;
    private javax.swing.JTextField Uquv_musTalim;
    private javax.swing.JComboBox<String> Uquv_semestr;
    private javax.swing.JTextField Uquv_seminar;
    private javax.swing.JComboBox<String> Uquv_talimShakli;
    private javax.swing.JButton Uquv_tozalash;
    private javax.swing.JButton Uquv_uchirish;
    private javax.swing.JTextField Uquv_uquv_yili;
    private javax.swing.JButton Uquv_uzgartirish;
    private javax.swing.JButton Uquv_yuklash;
    private javax.swing.JComboBox<String> Uquv_yunalish;
    private javax.swing.JTextField YukKaf_BMI;
    private javax.swing.JTextField YukKaf_DAK;
    private javax.swing.JTextField YukKaf_GurSoni;
    private javax.swing.JTextField YukKaf_Jami;
    private javax.swing.JTextField YukKaf_KursIshi;
    private javax.swing.JTextField YukKaf_PotokSoni;
    private javax.swing.JTextField YukKaf_TalSoni;
    private javax.swing.JButton YukKaf_Tozalash;
    private javax.swing.JButton YukKaf_Uchir;
    private javax.swing.JButton YukKaf_Uzgar;
    private javax.swing.JTextField YukKaf_amalJami;
    private javax.swing.JTextField YukKaf_amalReja;
    private javax.swing.JComboBox<String> YukKaf_fan;
    private javax.swing.JTextField YukKaf_labJami;
    private javax.swing.JTextField YukKaf_labReja;
    private javax.swing.JTextField YukKaf_marJami;
    private javax.swing.JTextField YukKaf_marReja;
    private javax.swing.JTextField YukKaf_nazorat;
    private javax.swing.JButton YukKaf_qushish;
    private javax.swing.JComboBox<String> YukKaf_semestr;
    private javax.swing.JComboBox<String> YukKaf_yunalish;
    private javax.swing.JInternalFrame YuklamaKafedra;
    private javax.swing.JInternalFrame YuklamaUqituvchi;
    private javax.swing.JButton bt_tozalash;
    private javax.swing.JButton bt_yuklash;
    private javax.swing.JButton btn_KafedraMudiri;
    private javax.swing.JButton btn_Reg;
    private javax.swing.JButton btn_Reg1;
    private javax.swing.JButton btn_Uchirish;
    private javax.swing.JButton btn_UqituvchiYuklama;
    private javax.swing.JButton btn_UqituvchiYuklama1;
    private javax.swing.JButton btn_Uqituvchilar;
    private javax.swing.JButton btn_Uqituvchilar1;
    private javax.swing.JButton btn_Uzgartirish;
    private javax.swing.JButton btn_Yuklash;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_fakultet;
    private javax.swing.JButton btn_guruh;
    private javax.swing.JButton btn_kafedra;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_uquvReja;
    private javax.swing.JButton btn_yunalish;
    private javax.swing.JButton but_uchirish;
    private javax.swing.JButton but_uzgartirish;
    private javax.swing.JButton butt_uchirish;
    private javax.swing.JButton butt_uzgartirish;
    private javax.swing.JButton butt_yunalish;
    private javax.swing.JComboBox<String> comKursi;
    private javax.swing.JComboBox<String> com_talimshakli;
    private javax.swing.JPanel fakultet;
    private javax.swing.JComboBox<String> huquq_tanlash;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JInternalFrame jInternal_Fakultet;
    private javax.swing.JInternalFrame jInternal_Kafedra;
    private javax.swing.JInternalFrame jInternal_Yunalish;
    private javax.swing.JInternalFrame jInternal_YunalishGuruh;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private static javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPasswordField jpass_parol1;
    private javax.swing.JPasswordField jpass_parol2;
    private javax.swing.JPanel kafedra;
    private javax.swing.JMenuItem menu_exit;
    private javax.swing.JMenuItem menu_kirish;
    private javax.swing.JMenuItem menu_registratsiya;
    private java.awt.Checkbox pass1;
    private java.awt.Checkbox pass2;
    private javax.swing.JButton reg_cancel;
    private javax.swing.JTextField reg_email;
    private javax.swing.JTextField reg_fam;
    private javax.swing.JComboBox<String> reg_foydalanuvchi;
    private javax.swing.JTextField reg_ism;
    private javax.swing.JTextField reg_login;
    private javax.swing.JPasswordField reg_pass;
    private javax.swing.JButton reg_qushish;
    private javax.swing.JPasswordField reg_retypePass;
    private javax.swing.JButton sign_cancel;
    private javax.swing.JButton sign_kirish;
    private javax.swing.JTextField sign_login;
    private javax.swing.JPasswordField sign_parol;
    private javax.swing.JTextField text_Yunalishnomi;
    private javax.swing.JTextField text_yunalishId;
    private javax.swing.JTextField tx_fakultetNomi;
    private javax.swing.JTextField tx_guruhNomi;
    private javax.swing.JTextField tx_talabalarSoni;
    private javax.swing.JTextField tx_yunalishNomi;
    private javax.swing.JLabel txt_Sem;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fakultetId;
    private javax.swing.JTextField txt_fakultetNomi;
    private javax.swing.JLabel txt_lab;
    private javax.swing.JTextField txt_log;
    private javax.swing.JLabel txt_mus;
    private javax.swing.JInternalFrame uquv_reja;
    private javax.swing.JPanel yunalish;
    private javax.swing.JPanel yunalish_guruh;
    // End of variables declaration//GEN-END:variables
}