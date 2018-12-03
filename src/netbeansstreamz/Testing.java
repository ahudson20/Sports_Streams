package netbeansstreamz;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author anaruhudson
 */
public class Testing extends javax.swing.JDialog {
    
    private Links soccer = null;
    private Links nba = null;
    private Links nfl = null;
    private Links mma = null;
    private Links nhl = null;
    private Links cricket = null;
    private Links ncaabb = null;
    private Links rugby = null;
    
    private Map<String, Collection<String>> soccerLinks;
    private Map<String, Collection<String>> nbaLinks;
    private Map<String, Collection<String>> nflLinks;
    private Map<String, Collection<String>> mmaLinks;
    private Map<String, Collection<String>> nhlLinks;
    private Map<String, Collection<String>> cricketLinks;
    private Map<String, Collection<String>> ncaabbLinks;
    private Map<String, Collection<String>> rugbyLinks;
    
    private DefaultListModel listModel = new DefaultListModel();
   
    /**
     * Creates new form Testing
     * @param parent
     * @param modal
     */
    public Testing(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        soccerReset.addActionListener(new ButtonListener());
        nbaReset.addActionListener(new ButtonListener());
        nflReset.addActionListener(new ButtonListener());
        mmaReset.addActionListener(new ButtonListener());
        nhlReset.addActionListener(new ButtonListener());
        cricketReset.addActionListener(new ButtonListener());
        ncaabbReset.addActionListener(new ButtonListener());
        rugbyReset.addActionListener(new ButtonListener());
    }
    
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int tab = jTabbedPane1.getSelectedIndex();
            String url;
            switch(tab){
                case 0:
                    Testing.this.soccer = null;
                    url = "https://www.reddit.com/r/soccerstreams/";
                    comboSoccer.setEditable(false);
                    comboSoccer.removeAllItems();
                    setLinks(tab, url);
                    break;
                case 1 : 
                    Testing.this.nba = null;
                    url = "https://www.reddit.com/r/nbastreams/";
                    comboNBA.setEditable(false);
                    comboNBA.removeAllItems();
                    setLinks(tab, url);
                    break;
                case 2 :
                    Testing.this.nfl = null;
                    url = "https://www.reddit.com/r/nflstreams/";
                    comboNFL.setEditable(false);
                    comboNFL.removeAllItems();
                    setLinks(tab, url);
                    break;
                case 3 :
                    Testing.this.mma = null;
                    url = "https://www.reddit.com/r/MMAStreams/";
                    comboMMA.setEditable(false);
                    comboMMA.removeAllItems();
                    setLinks(tab, url);
                case 4 :
                    Testing.this.nhl = null;
                    url = "https://www.reddit.com/r/NHLStreams";
                    comboNHL.setEditable(false);
                    comboNHL.removeAllItems();
                    setLinks(tab, url);
                case 5 :
                    Testing.this.cricket = null;
                    url = "https://www.reddit.com/r/CricketStreams";
                    comboCricket.setEditable(false);
                    comboCricket.removeAllItems();
                    setLinks(tab, url);
                case 6 :
                    Testing.this.ncaabb = null;
                    url = "https://www.reddit.com/r/ncaaBBallStreams/";
                    comboNCAABB.setEditable(false);
                    comboNCAABB.removeAllItems();
                    setLinks(tab, url);
                case 7 :
                    Testing.this.rugby = null;
                    url = "https://www.reddit.com/r/rugbystreams/";
                    comboRugby.setEditable(false);
                    comboRugby.removeAllItems();
                    setLinks(tab, url);
                default:
                    Testing.this.soccer = null;
                    url = "https://www.reddit.com/r/soccerstreams/";
                    comboSoccer.setEditable(false);
                    comboSoccer.removeAllItems();
                    setLinks(tab, url);
                    break;
            }
        }  
    }
    
    private void setLinks(int tab, String url){
        switch (tab) {
            case 0:
                if(this.soccer == null){
                    this.soccer = new Links(url);
                    this.soccerLinks = soccer.getFinalLinks();
                    if(!soccerLinks.isEmpty()){
                        this.listModel.clear();
                        for (Map.Entry<String, Collection<String>> entry : this.soccerLinks.entrySet()){
                            comboSoccer.addItem(entry.getKey());
                        }
                        openSoccer.setEnabled(true);
                    }else{
                        comboSoccer.addItem("There are no games available!");
                        this.listModel.clear();
                        openSoccer.setEnabled(false);
                    }
                }   break;
            case 1:
                if(this.nba == null){
                    this.nba = new Links(url);
                    this.nbaLinks = nba.getFinalLinks();
                    if(!nbaLinks.isEmpty()){
                        this.listModel.clear();
                        for (Map.Entry<String, Collection<String>> entry : this.nbaLinks.entrySet()){
                            comboNBA.addItem(entry.getKey());
                        }
                        openNBA.setEnabled(true);
                    }else{
                        comboNBA.addItem("There are no games available!");
                        this.listModel.clear();
                        openNBA.setEnabled(false);
                    }
                }   break;
            case 2:
                if(this.nfl == null){
                    this.nfl = new Links(url);
                    this.nflLinks = nfl.getFinalLinks();
                    if(!nflLinks.isEmpty()){
                        this.listModel.clear();
                        for (Map.Entry<String, Collection<String>> entry : this.nflLinks.entrySet()){
                            comboNFL.addItem(entry.getKey());
                        }
                        openNFL.setEnabled(true);
                    }else{
                        comboNFL.addItem("There are no games available!");
                        this.listModel.clear();
                        openNFL.setEnabled(false);
                    }
                    
                }   break;
            case 3 :
                if(this.mma == null){
                    this.mma = new Links(url);
                    this.mmaLinks = mma.getFinalLinks();
                    if(!mmaLinks.isEmpty()){
                        this.listModel.clear();
                       for (Map.Entry<String, Collection<String>> entry : this.mmaLinks.entrySet()){
                            comboMMA.addItem(entry.getKey());
                        }
                       openMMA.setEnabled(true);
                    }else{
                        comboMMA.addItem("There are no games available!");
                        this.listModel.clear();
                        openMMA.setEnabled(false);
                    }
                }
                break;
                
            case 4:
                if(this.nhl == null){
                    this.nhl = new Links(url);
                    this.nhlLinks = nhl.getFinalLinks();
                    if(!nhlLinks.isEmpty()){
                        this.listModel.clear();
                       for (Map.Entry<String, Collection<String>> entry : this.nhlLinks.entrySet()){
                            comboNHL.addItem(entry.getKey());
                        }
                       openNHL.setEnabled(true);
                    }else{
                        comboNHL.addItem("There are no games available!");
                        this.listModel.clear();
                        openNHL.setEnabled(false);
                    }
                }
                break;
            case 5:
                if(this.cricket == null){
                    this.cricket = new Links(url);
                    this.cricketLinks = cricket.getFinalLinks();
                    if(!cricketLinks.isEmpty()){
                        this.listModel.clear();
                       for (Map.Entry<String, Collection<String>> entry : this.cricketLinks.entrySet()){
                            comboCricket.addItem(entry.getKey());
                        }
                       openCricket.setEnabled(true);
                    }else{
                        comboCricket.addItem("There are no games available!");
                        this.listModel.clear();
                        openCricket.setEnabled(false);
                    }
                }
                break;
            case 6:
                if(this.ncaabb == null){
                    this.ncaabb = new Links(url);
                    this.ncaabbLinks = ncaabb.getFinalLinks();
                    if(!ncaabbLinks.isEmpty()){
                        this.listModel.clear();
                       for (Map.Entry<String, Collection<String>> entry : this.ncaabbLinks.entrySet()){
                            comboNCAABB.addItem(entry.getKey());
                        } 
                       openNCAABB.setEnabled(true);
                    }else{
                        comboNCAABB.addItem("There are no games available!");
                        this.listModel.clear();
                        openNCAABB.setEnabled(false);
                    }
                }
                break;
            case 7:
                if(this.rugby == null){
                    this.rugby = new Links(url);
                    this.rugbyLinks = rugby.getFinalLinks();
                    if(!rugbyLinks.isEmpty()){
                        this.listModel.clear();
                       for (Map.Entry<String, Collection<String>> entry : this.rugbyLinks.entrySet()){
                            comboRugby.addItem(entry.getKey());
                        } 
                       openRugby.setEnabled(true);
                    }else{
                        comboRugby.addItem("There are no games available!");
                        this.listModel.clear();
                        openRugby.setEnabled(false);
                    }
                }
                break;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        comboSoccer = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSoccer = new javax.swing.JList<>();
        closeSoccer = new javax.swing.JButton();
        openSoccer = new javax.swing.JButton();
        soccerReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        comboNBA = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNBA = new javax.swing.JList<>();
        closeNBA = new javax.swing.JButton();
        openNBA = new javax.swing.JButton();
        nbaReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        comboNFL = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listNFL = new javax.swing.JList<>();
        closeNFL = new javax.swing.JButton();
        openNFL = new javax.swing.JButton();
        nflReset = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        comboMMA = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listMMA = new javax.swing.JList<>();
        closeMMA = new javax.swing.JButton();
        mmaReset = new javax.swing.JButton();
        openMMA = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        comboNHL = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listNHL = new javax.swing.JList<>();
        closeNHL = new javax.swing.JButton();
        nhlReset = new javax.swing.JButton();
        openNHL = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        comboCricket = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        listCricket = new javax.swing.JList<>();
        closeCricket = new javax.swing.JButton();
        cricketReset = new javax.swing.JButton();
        openCricket = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        comboNCAABB = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        listNCAABB = new javax.swing.JList<>();
        closeNCAABB = new javax.swing.JButton();
        ncaabbReset = new javax.swing.JButton();
        openNCAABB = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        comboRugby = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        listRugby = new javax.swing.JList<>();
        closeRugby = new javax.swing.JButton();
        openRugby = new javax.swing.JButton();
        rugbyReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        comboSoccer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSoccerActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listSoccer);

        closeSoccer.setText("Close");
        closeSoccer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeSoccerActionPerformed(evt);
            }
        });

        openSoccer.setText("Open");
        openSoccer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSoccerActionPerformed(evt);
            }
        });

        soccerReset.setText("Refresh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboSoccer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(closeSoccer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(soccerReset, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(openSoccer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSoccer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeSoccer)
                    .addComponent(openSoccer)
                    .addComponent(soccerReset))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Soccer", jPanel1);

        comboNBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNBAActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listNBA);

        closeNBA.setText("Close");
        closeNBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeNBAActionPerformed(evt);
            }
        });

        openNBA.setText("Open");
        openNBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openNBAActionPerformed(evt);
            }
        });

        nbaReset.setText("Refresh");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboNBA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(closeNBA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(nbaReset, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(openNBA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboNBA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeNBA)
                    .addComponent(openNBA)
                    .addComponent(nbaReset))
                .addContainerGap())
        );

        jTabbedPane1.addTab("NBA", jPanel3);

        comboNFL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNFLActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listNFL);

        closeNFL.setText("Close");
        closeNFL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeNFLActionPerformed(evt);
            }
        });

        openNFL.setText("Open");
        openNFL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openNFLActionPerformed(evt);
            }
        });

        nflReset.setText("Refresh");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboNFL, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(closeNFL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(nflReset, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(openNFL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboNFL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeNFL)
                    .addComponent(openNFL)
                    .addComponent(nflReset))
                .addContainerGap())
        );

        jTabbedPane1.addTab("NFL", jPanel2);

        comboMMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMMAActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(listMMA);

        closeMMA.setText("Close");
        closeMMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMMAActionPerformed(evt);
            }
        });

        mmaReset.setText("Refresh");

        openMMA.setText("Open");
        openMMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMMAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboMMA, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(closeMMA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(mmaReset, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(openMMA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboMMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeMMA)
                    .addComponent(mmaReset)
                    .addComponent(openMMA))
                .addContainerGap())
        );

        jTabbedPane1.addTab("MMA", jPanel4);

        comboNHL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNHLActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(listNHL);

        closeNHL.setText("Close");
        closeNHL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeNHLActionPerformed(evt);
            }
        });

        nhlReset.setText("Refresh");

        openNHL.setText("Open");
        openNHL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openNHLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboNHL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(closeNHL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(nhlReset, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(openNHL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboNHL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeNHL)
                    .addComponent(nhlReset)
                    .addComponent(openNHL))
                .addContainerGap())
        );

        jTabbedPane1.addTab("NHL", jPanel5);

        comboCricket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCricketActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(listCricket);

        closeCricket.setText("Close");
        closeCricket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeCricketActionPerformed(evt);
            }
        });

        cricketReset.setText("Refresh");

        openCricket.setText("Open");
        openCricket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCricketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboCricket, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(closeCricket, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(cricketReset, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openCricket, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCricket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeCricket)
                    .addComponent(cricketReset)
                    .addComponent(openCricket))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cricket", jPanel6);

        comboNCAABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNCAABBActionPerformed(evt);
            }
        });

        jScrollPane7.setViewportView(listNCAABB);

        closeNCAABB.setText("Close");
        closeNCAABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeNCAABBActionPerformed(evt);
            }
        });

        ncaabbReset.setText("Refresh");

        openNCAABB.setText("Open");
        openNCAABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openNCAABBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboNCAABB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(closeNCAABB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(ncaabbReset, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(openNCAABB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboNCAABB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ncaabbReset)
                    .addComponent(closeNCAABB)
                    .addComponent(openNCAABB))
                .addContainerGap())
        );

        jTabbedPane1.addTab("NCAA BB", jPanel7);

        comboRugby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRugbyActionPerformed(evt);
            }
        });

        jScrollPane8.setViewportView(listRugby);

        closeRugby.setText("Close");
        closeRugby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeRugbyActionPerformed(evt);
            }
        });

        openRugby.setText("Open");
        openRugby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openRugbyActionPerformed(evt);
            }
        });

        rugbyReset.setText("Refresh");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboRugby, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(closeRugby, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(rugbyReset, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(openRugby, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboRugby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeRugby)
                    .addComponent(openRugby)
                    .addComponent(rugbyReset))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Rugby", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboSoccerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSoccerActionPerformed
        if(!soccerLinks.isEmpty() && this.soccer != null){
            String game = (String)comboSoccer.getSelectedItem();
            Collection<String>  gameLinks = soccerLinks.get(game);
            //DefaultListModel listModel = new DefaultListModel();
            this.listModel.clear();
            for(String s : gameLinks){
                listModel.addElement(s);
            }
            listSoccer.setModel(listModel);
        }
    }//GEN-LAST:event_comboSoccerActionPerformed

    private void openSoccerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSoccerActionPerformed
        String link = (String)listSoccer.getSelectedValue();

        if(listSoccer.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a link before opening!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URL(link).toURI());
                } catch (IOException | URISyntaxException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_openSoccerActionPerformed

    private void closeSoccerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeSoccerActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeSoccerActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
         int tab = jTabbedPane1.getSelectedIndex();
        String url;
        switch(tab){
            case 0: url = "https://www.reddit.com/r/soccerstreams/";
                break;
            case 1 : url = "https://www.reddit.com/r/nbastreams/";
                break;
            case 2 : url = "https://www.reddit.com/r/nflstreams/";
                break;
            case 3 : url = "https://www.reddit.com/r/MMAStreams/";
                break;
            case 4 : url = "https://www.reddit.com/r/NHLStreams";
                break;
            case 5 : url = "https://www.reddit.com/r/CricketStreams";
                break;
            case 6 : url = "https://www.reddit.com/r/ncaaBBallStreams/";
                break;
            case 7 : url = "https://www.reddit.com/r/rugbystreams/";
                break;
            default: url = "https://www.reddit.com/r/soccerstreams/";
                break;
        }
        setLinks(tab, url);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void closeNBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeNBAActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeNBAActionPerformed

    private void openNBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openNBAActionPerformed
        String link = (String)listNBA.getSelectedValue();

        if(listNBA.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a link before opening!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URL(link).toURI());
                } catch (IOException | URISyntaxException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_openNBAActionPerformed

    private void comboNBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNBAActionPerformed
        if(!nbaLinks.isEmpty() && this.nba != null){
            String game = (String)comboNBA.getSelectedItem();
            Collection<String>  gameLinks = nbaLinks.get(game);
//            DefaultListModel listModel = new DefaultListModel();
            this.listModel.clear();
            for(String s : gameLinks){
                listModel.addElement(s);
            }
            listNBA.setModel(listModel);
        }
    }//GEN-LAST:event_comboNBAActionPerformed

    private void closeNFLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeNFLActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeNFLActionPerformed

    private void openNFLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openNFLActionPerformed
        String link = (String)listNFL.getSelectedValue();

        if(listNFL.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a link before opening!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URL(link).toURI());
                } catch (IOException | URISyntaxException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_openNFLActionPerformed

    private void comboNFLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNFLActionPerformed
        if(!nflLinks.isEmpty() && this.nfl != null){
            String game = (String)comboNFL.getSelectedItem();
            Collection<String>  gameLinks = nflLinks.get(game);
            this.listModel.clear();
            //DefaultListModel listModel = new DefaultListModel();
            for(String s : gameLinks){
                listModel.addElement(s);
            }
            listNFL.setModel(listModel);
        }
    }//GEN-LAST:event_comboNFLActionPerformed

    private void closeMMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMMAActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeMMAActionPerformed

    private void openMMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMMAActionPerformed
        String link = (String)listMMA.getSelectedValue();

        if(listMMA.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a link before opening!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URL(link).toURI());
                } catch (IOException | URISyntaxException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_openMMAActionPerformed

    private void comboMMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMMAActionPerformed
        if(!mmaLinks.isEmpty() && this.mma != null){
            String game = (String)comboMMA.getSelectedItem();
            Collection<String>  gameLinks = mmaLinks.get(game);
            this.listModel.clear();
            for(String s : gameLinks){
                listModel.addElement(s);
            }
            listMMA.setModel(listModel);
        }
    }//GEN-LAST:event_comboMMAActionPerformed

    private void closeNHLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeNHLActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeNHLActionPerformed

    private void openNHLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openNHLActionPerformed
        String link = (String)listNHL.getSelectedValue();

        if(listNHL.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a link before opening!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URL(link).toURI());
                } catch (IOException | URISyntaxException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_openNHLActionPerformed

    private void comboNHLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNHLActionPerformed
        if(!nhlLinks.isEmpty() && this.nhl != null){
            String game = (String)comboNHL.getSelectedItem();
            Collection<String>  gameLinks = nhlLinks.get(game);
//            DefaultListModel listModel = new DefaultListModel();
              this.listModel.clear();
            for(String s : gameLinks){
                listModel.addElement(s);
            }
            listNHL.setModel(listModel);
        }
    }//GEN-LAST:event_comboNHLActionPerformed

    private void comboCricketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCricketActionPerformed
        if(!cricketLinks.isEmpty() && this.cricket != null){
            String game = (String)comboCricket.getSelectedItem();
            Collection<String>  gameLinks = cricketLinks.get(game);
            //DefaultListModel listModel = new DefaultListModel();
            this.listModel.clear();
            for(String s : gameLinks){
                listModel.addElement(s);
            }
            listCricket.setModel(listModel);
        }
    }//GEN-LAST:event_comboCricketActionPerformed

    private void closeCricketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeCricketActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeCricketActionPerformed

    private void openCricketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openCricketActionPerformed
        String link = (String)listCricket.getSelectedValue();

        if(listCricket.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a link before opening!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URL(link).toURI());
                } catch (IOException | URISyntaxException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_openCricketActionPerformed

    private void comboNCAABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNCAABBActionPerformed
        if(!ncaabbLinks.isEmpty() && this.ncaabb != null){
            String game = (String)comboNCAABB.getSelectedItem();
            Collection<String>  gameLinks = ncaabbLinks.get(game);
            //DefaultListModel listModel = new DefaultListModel();
            this.listModel.clear();
            for(String s : gameLinks){
                listModel.addElement(s);
            }
            listNCAABB.setModel(listModel);
        }
    }//GEN-LAST:event_comboNCAABBActionPerformed

    private void closeNCAABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeNCAABBActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeNCAABBActionPerformed

    private void openNCAABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openNCAABBActionPerformed
        String link = (String)listNCAABB.getSelectedValue();

        if(listNCAABB.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a link before opening!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URL(link).toURI());
                } catch (IOException | URISyntaxException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_openNCAABBActionPerformed

    private void comboRugbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRugbyActionPerformed
        if(!rugbyLinks.isEmpty() && this.rugby != null){
            String game = (String)comboRugby.getSelectedItem();
            Collection<String>  gameLinks = rugbyLinks.get(game);
            //DefaultListModel listModel = new DefaultListModel();
            this.listModel.clear();
            for(String s : gameLinks){
                listModel.addElement(s);
            }
            listRugby.setModel(listModel);
        }
    }//GEN-LAST:event_comboRugbyActionPerformed

    private void closeRugbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeRugbyActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeRugbyActionPerformed

    private void openRugbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openRugbyActionPerformed
        String link = (String)listRugby.getSelectedValue();

        if(listRugby.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a link before opening!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URL(link).toURI());
                } catch (IOException | URISyntaxException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_openRugbyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeCricket;
    private javax.swing.JButton closeMMA;
    private javax.swing.JButton closeNBA;
    private javax.swing.JButton closeNCAABB;
    private javax.swing.JButton closeNFL;
    private javax.swing.JButton closeNHL;
    private javax.swing.JButton closeRugby;
    private javax.swing.JButton closeSoccer;
    private javax.swing.JComboBox<String> comboCricket;
    private javax.swing.JComboBox<String> comboMMA;
    private javax.swing.JComboBox<String> comboNBA;
    private javax.swing.JComboBox<String> comboNCAABB;
    private javax.swing.JComboBox<String> comboNFL;
    private javax.swing.JComboBox<String> comboNHL;
    private javax.swing.JComboBox<String> comboRugby;
    private javax.swing.JComboBox<String> comboSoccer;
    private javax.swing.JButton cricketReset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> listCricket;
    private javax.swing.JList<String> listMMA;
    private javax.swing.JList<String> listNBA;
    private javax.swing.JList<String> listNCAABB;
    private javax.swing.JList<String> listNFL;
    private javax.swing.JList<String> listNHL;
    private javax.swing.JList<String> listRugby;
    private javax.swing.JList<String> listSoccer;
    private javax.swing.JButton mmaReset;
    private javax.swing.JButton nbaReset;
    private javax.swing.JButton ncaabbReset;
    private javax.swing.JButton nflReset;
    private javax.swing.JButton nhlReset;
    private javax.swing.JButton openCricket;
    private javax.swing.JButton openMMA;
    private javax.swing.JButton openNBA;
    private javax.swing.JButton openNCAABB;
    private javax.swing.JButton openNFL;
    private javax.swing.JButton openNHL;
    private javax.swing.JButton openRugby;
    private javax.swing.JButton openSoccer;
    private javax.swing.JButton rugbyReset;
    private javax.swing.JButton soccerReset;
    // End of variables declaration//GEN-END:variables
}
