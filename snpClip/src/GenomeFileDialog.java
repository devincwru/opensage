package snpclip;

import javax.swing.ButtonGroup;
import java.util.Vector;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.BorderLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import java.awt.CardLayout;

/**
 *
 * @author  suna
 */

public class GenomeFileDialog extends javax.swing.JDialog {
        // Variables declaration - do not modify
        private javax.swing.JButton okButton;
        private javax.swing.JButton cancelButton;

        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel BottomPanel;
        private javax.swing.JPanel CenterPanel;
        private javax.swing.JPanel FileFormatPanel;
        private javax.swing.JPanel DelimitersPanel;
        private javax.swing.JPanel MarkerPanel;
        private javax.swing.JPanel PositionPanel;

        private javax.swing.JRadioButton SageRButton;
        private javax.swing.JRadioButton RawDataRButton;
        private javax.swing.JRadioButton TabRButton;
        private javax.swing.JRadioButton CommaRButton;
        private javax.swing.JRadioButton SpaceRButton;
        private javax.swing.JRadioButton OtherRButton;

        private javax.swing.JRadioButton AbRButton;
        private javax.swing.JRadioButton CentiRButton;
        private javax.swing.JRadioButton RfRButton;

        private javax.swing.JScrollPane TableScrollPane;
        private javax.swing.JScrollPane TextScrollPane;
        private javax.swing.JTextArea jTextArea1;

        private javax.swing.JSeparator jSeparator1;
        private MyTable jTable1;
        private javax.swing.JTextField OtherTextField;
        // End of variables declaration

        private javax.swing.JLabel pedigreeLabel;
        private javax.swing.JLabel individualLabel;
        private javax.swing.JSpinner MarkerSpinner;
        private javax.swing.JSpinner PositionSpinner;

        ButtonGroup bg1 = new ButtonGroup();
        ButtonGroup bg2 = new ButtonGroup();
        ButtonGroup bg3 = new ButtonGroup();

        int row_limit = 10;
        //int col_limit = 20;

        private int Marker_Col = 1;
        private int Position_Col = 2;

        private int Position_type = 0;

        Vector column;
        Vector linelist;
        DefaultTableModel dm;
        private String FilePath;
        private String TAB = "\t";
        private String COMMA = ",";
        private String SAPCE = " ";
        private int FileType = 0;

        private String FILE_DELIMITER = TAB;

        int returnStatus = RET_CANCEL;
        /** A return status code - returned if Cancel button has been pressed */
        public static final int RET_CANCEL = 0;
        /** A return status code - returned if OK button has been pressed */
        public static final int RET_OK = 1;

        SpinnerNumberModel MarkerModel;
        SpinnerNumberModel PositionModel;

        private javax.swing.JPanel cards;
        final static String TablePanel = "SAGE MAP FILE";
        final static String TextPanel = "RAW DATA FILe";



    /** Creates new form FileInfoJDialog */
    public GenomeFileDialog(java.awt.Frame parent, String title, boolean modal) {
        super(parent, title, modal);

        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        BottomPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        CenterPanel = new javax.swing.JPanel();
        FileFormatPanel = new javax.swing.JPanel();
        PositionPanel = new javax.swing.JPanel();
        cards = new javax.swing.JPanel(new java.awt.CardLayout());

        SageRButton = new javax.swing.JRadioButton();
        RawDataRButton = new javax.swing.JRadioButton();
        DelimitersPanel = new javax.swing.JPanel();
        TabRButton = new javax.swing.JRadioButton();
        CommaRButton = new javax.swing.JRadioButton();
        SpaceRButton = new javax.swing.JRadioButton();
        OtherRButton = new javax.swing.JRadioButton();

        AbRButton = new javax.swing.JRadioButton();
        CentiRButton = new javax.swing.JRadioButton();
        RfRButton = new javax.swing.JRadioButton();

        jLabel5 = new javax.swing.JLabel();

        OtherTextField = new javax.swing.JTextField();
        MarkerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        TableScrollPane = new javax.swing.JScrollPane();
        TextScrollPane = new javax.swing.JScrollPane();
        jTable1 = new MyTable();
        jTextArea1 = new javax.swing.JTextArea();

        pedigreeLabel = new javax.swing.JLabel();
        individualLabel = new javax.swing.JLabel();
        MarkerSpinner = new javax.swing.JSpinner();
        PositionSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bg1.add(SageRButton);
        bg1.add(RawDataRButton);

        SageRButton.setFocusPainted(false);
        RawDataRButton.setFocusPainted(false);

        bg2.add(TabRButton);
        bg2.add(CommaRButton);
        bg2.add(SpaceRButton);
        bg2.add(OtherRButton);

        TabRButton.setFocusPainted(false);
        CommaRButton.setFocusPainted(false);
        SpaceRButton.setFocusPainted(false);
        OtherRButton.setFocusPainted(false);

        BottomPanel.setPreferredSize(new java.awt.Dimension(100, 45));

        okButton.setText("OK");
        okButton.setPreferredSize(new java.awt.Dimension(60, 23));
        okButton.setPreferredSize(new java.awt.Dimension(60, 23));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setMargin(new java.awt.Insets(2,2,2,2));
        cancelButton.setPreferredSize(new java.awt.Dimension(60, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(60, 23));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

       javax.swing.GroupLayout BottomPanelLayout = new javax.swing.GroupLayout(BottomPanel);
       BottomPanel.setLayout(BottomPanelLayout);
       BottomPanelLayout.setHorizontalGroup(
               BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomPanelLayout.createSequentialGroup()
                         .addContainerGap(250, Short.MAX_VALUE)
                         .addComponent(okButton)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(cancelButton)
                         .addContainerGap())
               );

       BottomPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

       BottomPanelLayout.setVerticalGroup(
               BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomPanelLayout.createSequentialGroup()
                         .addContainerGap()
                         .addGroup(BottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(cancelButton)
                                   .addComponent(okButton))
                         .addContainerGap())
               );

        FileFormatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("File Format"));

        SageRButton.setSelected(true);
        SageRButton.setText("S.A.G.E. Map File");
        SageRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SageRButton1ActionPerformed();
            }
        });

        RawDataRButton.setText("Raw Data File");
        RawDataRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawDataRButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout FileFormatPanelLayout = new javax.swing.GroupLayout(FileFormatPanel);
        FileFormatPanel.setLayout(FileFormatPanelLayout);
        FileFormatPanelLayout.setHorizontalGroup(
            FileFormatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FileFormatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FileFormatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SageRButton)
                    .addComponent(RawDataRButton)
                    //.addComponent(AffymetrixRButton)
                    )
                .addContainerGap(12, Short.MAX_VALUE))
        );
        FileFormatPanelLayout.setVerticalGroup(
            FileFormatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FileFormatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SageRButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RawDataRButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                //.addComponent(AffymetrixRButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        DelimitersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Delimiters"));

        TabRButton.setSelected(true);
        TabRButton.setText("Tab");
        TabRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TabRButtonActionPerformed();
            }
        });

        CommaRButton.setText("Comma");
        CommaRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommaRButtonActionPerformed();
            }
        });

        SpaceRButton.setText("Space");

        SpaceRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpaceRButtonActionPerformed();
            }
        });

        OtherRButton.setText("Other");
        OtherRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtherRButtonActionPerformed();
            }
        });

        OtherTextField.setEditable(false);
        OtherTextField.setMinimumSize(new java.awt.Dimension(40, 20));
        OtherTextField.setPreferredSize(new java.awt.Dimension(40, 20));
        OtherTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(DocumentEvent event) {

                String del = OtherTextField.getText();
                try {
                    FILE_DELIMITER = del;
                    ParseFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            public void insertUpdate(DocumentEvent event) {
              changedUpdate(event);
            }

            public void removeUpdate(DocumentEvent event) {
              changedUpdate(event);
          }
        });


        javax.swing.GroupLayout DelimitersPanelLayout = new javax.swing.GroupLayout(DelimitersPanel);
        DelimitersPanel.setLayout(DelimitersPanelLayout);
        DelimitersPanelLayout.setHorizontalGroup(
            DelimitersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DelimitersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DelimitersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabRButton)
                    .addComponent(CommaRButton)
                    .addComponent(SpaceRButton)
                    .addGroup(DelimitersPanelLayout.createSequentialGroup()
                        .addComponent(OtherRButton)
                        .addGap(18, 18, 18)
                        .addComponent(OtherTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DelimitersPanelLayout.setVerticalGroup(
            DelimitersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DelimitersPanelLayout.createSequentialGroup()
                .addComponent(TabRButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CommaRButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpaceRButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DelimitersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OtherRButton)
                    .addComponent(OtherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );


        pedigreeLabel.setText("Marker");
        pedigreeLabel.setPreferredSize(new java.awt.Dimension(60, 20));
        individualLabel.setText("Position");
        individualLabel.setPreferredSize(new java.awt.Dimension(60, 20));

        MarkerSpinner.setPreferredSize(new java.awt.Dimension(60, 20));
        MarkerSpinner.setValue(1);
        PositionSpinner.setPreferredSize(new java.awt.Dimension(60, 20));
        PositionSpinner.setValue(2);

        MarkerModel = new SpinnerNumberModel(1, //initial value
                                       1, //min
                                       Integer.MAX_VALUE, //max
                                        1);

        PositionModel = new SpinnerNumberModel(2, //initial value
                                     1, //min
                                     Integer.MAX_VALUE, //max
                                        1);

        MarkerSpinner.setModel(MarkerModel);
        PositionSpinner.setModel(PositionModel);

        MarkerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Marker data column"));

        javax.swing.GroupLayout MarkerPanelLayout = new javax.swing.GroupLayout(MarkerPanel);
       MarkerPanel.setLayout(MarkerPanelLayout);
       MarkerPanelLayout.setHorizontalGroup(
           MarkerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(MarkerPanelLayout.createSequentialGroup()
               .addContainerGap()
               .addGroup(MarkerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(MarkerPanelLayout.createSequentialGroup()
                       .addComponent(pedigreeLabel)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, 14)
                       .addComponent(MarkerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGroup(MarkerPanelLayout.createSequentialGroup()
                       .addComponent(individualLabel)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, 10)
                       .addComponent(PositionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addContainerGap())
       );
       MarkerPanelLayout.setVerticalGroup(
           MarkerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(MarkerPanelLayout.createSequentialGroup()
               .addGroup(MarkerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(pedigreeLabel)
                   .addComponent(MarkerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(MarkerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(individualLabel)
                   .addComponent(PositionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addContainerGap())
               );


       bg3.add(AbRButton);
       bg3.add(CentiRButton);
       bg3.add(RfRButton);


       AbRButton.setText("Absolute position");
       AbRButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               Position_type = 0;
           }
       });

       CentiRButton.setText("Distance in centimorgans to the next marker");
       CentiRButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               Position_type = 1;
           }
       });

       RfRButton.setText("Recombination fraction to the next marker");
       RfRButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               Position_type = 2;
           }
       });

       AbRButton.setFocusPainted(false);
       CentiRButton.setFocusPainted(false);
       RfRButton.setFocusPainted(false);

       PositionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Position column"));

      javax.swing.GroupLayout PositionPanelLayout = new javax.swing.GroupLayout(PositionPanel);
      PositionPanel.setLayout(PositionPanelLayout);
      PositionPanelLayout.setHorizontalGroup(
          PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(PositionPanelLayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(AbRButton)
                  .addComponent(CentiRButton)
                  .addComponent(RfRButton)
                  )
              .addContainerGap(12, Short.MAX_VALUE))
      );
      PositionPanelLayout.setVerticalGroup(
          PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(PositionPanelLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(AbRButton)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(CentiRButton)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(RfRButton)
              .addContainerGap(26, Short.MAX_VALUE))
        );




        dm = new DefaultTableModel();
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setIntercellSpacing(new Dimension(2, 0));
        jTable1.setRowSelectionAllowed(true);
        TableScrollPane.setViewportView(jTable1);

        jLabel1.setText("Data preview");
        jLabel1.setForeground(new java.awt.Color(0, 70, 213));
        jLabel5.setText("Note: not all of the data may be displayed.");

        TextScrollPane.setViewportView(jTextArea1);


        cards.add(TableScrollPane, TablePanel);
        cards.add(TextScrollPane, TextPanel);

        javax.swing.GroupLayout CenterPanelLayout = new javax.swing.GroupLayout(CenterPanel);
        CenterPanel.setLayout(CenterPanelLayout);
        CenterPanelLayout.setHorizontalGroup(
            CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CenterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cards, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CenterPanelLayout.createSequentialGroup()
                        .addComponent(FileFormatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DelimitersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MarkerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PositionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
              .addGroup(CenterPanelLayout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CenterPanelLayout.setVerticalGroup(
            CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CenterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(FileFormatPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PositionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MarkerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DelimitersPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        this.setMinimumSize(new Dimension(600,400));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(CenterPanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(BottomPanel, java.awt.BorderLayout.SOUTH);

        setMarkerPanelEnabled(false);
        setDelimitersEnabled(false);
        setPositonPanelEnabled(false);

        pack();
    }// </editor-fold>


    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        doClose(RET_OK);
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        doClose(RET_CANCEL);
    }

    private void doClose(int retStatus) {
        Marker_Col = Integer.parseInt(MarkerSpinner.getValue().toString());
        Position_Col = Integer.parseInt(PositionSpinner.getValue().toString());

        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    public void setFilePath(String value)
    {
        FilePath = value;
    }

    public int getFileType()
    {
        return FileType;
    }


    public int getMarkerColumn()
    {
        return Marker_Col;
    }

    public int getPositionColumn()
    {
        return Position_Col;
    }

    public int getPositionType()
    {
        return Position_type;
    }

    public String getDELIMITER()
    {
        return FILE_DELIMITER;
    }

    public void ParseRawDataFile() throws Exception
    {
        String[] t = null;
        Vector eachlinecontents = null;
        column = new Vector();
        linelist = new Vector();

        int i = 0;

        FileReader fr = new FileReader(FilePath);
        BufferedReader br = new BufferedReader(fr);
        String aLine = new String();

        int col_size = 0;
        while ((aLine = br.readLine()) != null && aLine.trim().length() > 0) {

            if (i >= row_limit)
                break;

            //t = aLine.split(delimiter, row_limit + 1);
            t = aLine.split(FILE_DELIMITER);

            if (i == 0) {
                for (int ti = 0; ti < t.length; ti++) {
                    column.add(t[ti]);
                }

            } else if (i > 0) {
                eachlinecontents = new Vector();

                for (int ti = 0; ti < t.length; ti++) {
                    eachlinecontents.add(t[ti]);
                }

                linelist.add(eachlinecontents);
                eachlinecontents = null;
            }
            i++;
        }

        linelist.trimToSize();

        MarkerModel.setMaximum(column.size());
        PositionModel.setMaximum(column.size());

        set_table_data(linelist, column);

    }

    public void ParseSageFile() throws Exception
    {
        jTextArea1.setText("");
        int i = 0;

        FileReader fr = new FileReader(FilePath);
        BufferedReader br = new BufferedReader(fr);
        String aLine = new String();

        while ((aLine = br.readLine()) != null && aLine.trim().length() > 0) {

            if (i >= row_limit)
                break;

            jTextArea1.append(aLine+"\n");

            i++;
        }
    }

     public void ParseFile() throws Exception
     {
         switch(FileType)
         {
             case 0: // SAGE Map file
                 ParseSageFile();
                 break;
             case 1: // RAW Data File
                 ParseRawDataFile();
                 break;
         }
     }

    private void setDelimitersEnabled(boolean val)
    {
        TabRButton.setEnabled(val);
        CommaRButton.setEnabled(val);
        SpaceRButton.setEnabled(val);
        OtherRButton.setEnabled(val);
    }

    private void setMarkerPanelEnabled(boolean val)
    {
        pedigreeLabel.setEnabled(val);
        MarkerSpinner.setEnabled(val);
        individualLabel.setEnabled(val);
        PositionSpinner.setEnabled(val);
    }

    private void setPositonPanelEnabled(boolean val)
    {
        AbRButton.setEnabled(val);
        CentiRButton.setEnabled(val);
        RfRButton.setEnabled(val);
    }

    private void set_table_data(Vector data, Vector col)
    {
      dm.setDataVector(data, col);
      jTable1.setModel(dm);
    }

    //SAGE
    void SageRButton1ActionPerformed() {
        FileType = 0;
        setMarkerPanelEnabled(false);
        setDelimitersEnabled(false);
        setPositonPanelEnabled(false);

        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, TextPanel);

        try {
            ParseFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Raw Data File
    private void RawDataRButtonActionPerformed() {
        setMarkerPanelEnabled(true);
        setDelimitersEnabled(true);
        setPositonPanelEnabled(true);
        TabRButton.setSelected(true);
        FileType = 1;

        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, TablePanel);

        try {
            ParseFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Tab
    private void TabRButtonActionPerformed() {
        try {
            FILE_DELIMITER = TAB;
            ParseFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Comma
    private void CommaRButtonActionPerformed() {
        try {
            FILE_DELIMITER = COMMA;
            ParseFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //SAPCE
    private void SpaceRButtonActionPerformed() {
        try {
            FILE_DELIMITER = SAPCE;
            ParseFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Other
    private void OtherRButtonActionPerformed() {
        OtherTextField.requestFocus(OtherRButton.isSelected());
        OtherTextField.setEditable(OtherRButton.isSelected());
    }


  class MyTable extends JTable {
      public String getToolTipText(MouseEvent evt) {
        if (columnAtPoint(evt.getPoint()) == -1)
          return null;
        return Integer.toString(columnAtPoint(evt.getPoint())+1);
    }
  }
}
