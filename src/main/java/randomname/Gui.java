/*
 * Created by JFormDesigner on Fri Oct 01 00:42:59 CST 2021
 */

package randomname;


import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 * @author 1
 */
public class Gui extends JFrame {
    private boolean foreaching = false;
    private ForEachThread forEachThread = new ForEachThread();
    private final ResourceBundle bundle = ResourceBundle.getBundle("String");
    private final ArrayList<Container> containers = new ArrayList<>();
    public Gui() {
        initComponents();
        containers.add(this.getContentPane());
        containers.add(Curriculum.getContentPane());
        slider2.setMinimum(1);
        slider2.setMaximum(6);
        slider2.setValue(1);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        radioButton1.setSelected(true);
        TableEdit();
    }
    private void TableEdit(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames = new String[]{"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        Integer[][] rowData = new Integer[10][8];
        TableModel tableModel = new DefaultTableModel(rowData,columnNames);
        writeTable(tableModel);
        table1.setModel(tableModel);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table1.setDefaultRenderer(Object.class, tcr);
    }

    public void writeTable(TableModel tableModel){
        int tableColumn = tableModel.getColumnCount();
        for (int y = 1;y<CourseUtil.Companion.getNumberOfLines();y++){
            for (int x = 1;x<tableColumn;x++){
                try {
                    String value = CourseUtil.Companion.readForm(x,y);
                    if(Objects.equals(value, "null")) continue;
                    tableModel.setValueAt(value,y-1,x-1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void readTable(){
        int rows = table1.getRowCount();//y
        int column = table1.getColumnCount();//x
        ArrayList<String> caches = new ArrayList<>();
        for (int y = 0;y<rows;y++){
            StringBuilder cache = new StringBuilder();
            for (int x = 0;x<column;x++){
                Object ob = table1.getValueAt(y,x);
                String info;
                if(ob == null) info = "null";
                else info = ob.toString();
                if(info.isEmpty()) info = "null";
                cache.append(info).append(" ");
            }
            caches.add(String.valueOf(cache));
        }
        RandomName.Companion.readTable(caches);
    }
    private void table1PropertyChange(PropertyChangeEvent e) {
        int row = table1.getSelectedRow();
        int column = table1.getSelectedColumn();
        if(row == -1 || column == -1) return;
        //System.out.println(table1.getValueAt(row,column));
        readTable();
    }

    private void println(Object object){
        System.out.println(object);
    }

    private void slider1StateChanged(ChangeEvent e) {
        int value = slider2.getValue();
        label5.setText(String.valueOf(value));
    }

    private void ClearMouseClicked(MouseEvent e) {
        Out2.setText("");
    }

    public void setClasses(String classes){
        if(!Objects.equals(label4.getText(), classes)){
            label4.setText(classes);
        }
    }

    private void NextMouseClicked(MouseEvent e) {
        if(radioButton1.isSelected()) Out2.setText(RandomName.Companion.randomname(slider2.getValue()));
        else{
            foreaching = ! foreaching;
            if(foreaching){
                Next2.setText("筛选中,再次点击暂停");
                forEachThread = new ForEachThread();
                forEachThread.setOut(Out2);
                forEachThread.setForEaching(true);
                forEachThread.start();
            }else{
                Next2.setText(bundle.getString("Next2.text"));
                forEachThread.setForEaching(false);
                forEachThread.stop();
            }
        }
    }

    private void changeContentPane(Container container){
        this.setContentPane(container);
        this.revalidate();
    }

    private void radioButton1ActionPerformed(ActionEvent e) {
        //default
        if(foreaching){
            foreaching = false;
            forEachThread.setForEaching(false);
            forEachThread.stop();
            Next2.setText(bundle.getString("Next2.text"));
        }
        if(!radioButton2.isSelected())
            Out2.setFont(Out2.getFont().deriveFont(24f));
    }

    private void radioButton2ActionPerformed(ActionEvent e) {
        //mode2
        if(radioButton2.isSelected())
            Out2.setFont(Out2.getFont().deriveFont(44f));
    }

    private void radioButton3ActionPerformed(ActionEvent e) {
        Container main = containers.get(0);
        Container curriculum = containers.get(1);
        if(curriculumRadio.isSelected() && this.getContentPane() == main){
            changeContentPane(curriculum);
            mainRadio.setSelected(false);
        }else if(mainRadio.isSelected() && this.getContentPane() == curriculum){
            changeContentPane(main);
            curriculumRadio.setSelected(false);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("String");
        label4 = new JLabel();
        Next2 = new JButton();
        label6 = new JLabel();
        scrollPane1 = new JScrollPane();
        Out2 = new JTextPane();
        tabbedPane3 = new JTabbedPane();
        menuBar2 = new JMenuBar();
        slider2 = new JSlider();
        scrollPane3 = new JScrollPane();
        label5 = new JLabel();
        Clear2 = new JButton();
        panel1 = new JPanel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        curriculumRadio = new JRadioButton();
        Curriculum = new JFrame();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        mainRadio = new JRadioButton();

        //======== this ========
        setTitle(bundle.getString("this.title"));
        Container contentPane = getContentPane();

        //---- label4 ----
        label4.setText(bundle.getString("label4.text"));
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

        //---- Next2 ----
        Next2.setText(bundle.getString("Next2.text"));
        Next2.setPreferredSize(new Dimension(57, 30));
        Next2.setFont(Next2.getFont().deriveFont(Next2.getFont().getSize() + 15f));
        Next2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NextMouseClicked(e);
            }
        });

        //---- label6 ----
        label6.setText(bundle.getString("label6.text"));
        label6.setPreferredSize(new Dimension(174, 35));
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 8f));

        //======== scrollPane1 ========
        {

            //---- Out2 ----
            Out2.setPreferredSize(new Dimension(10, 65));
            Out2.setFont(Out2.getFont().deriveFont(Out2.getFont().getSize() + 12f));
            Out2.setMinimumSize(new Dimension(7, 65));
            scrollPane1.setViewportView(Out2);
        }

        //======== tabbedPane3 ========
        {
            tabbedPane3.setPreferredSize(new Dimension(180, 60));
            tabbedPane3.setMaximumSize(new Dimension(240, 80));
            tabbedPane3.setMinimumSize(new Dimension(240, 91));
            tabbedPane3.setFont(tabbedPane3.getFont().deriveFont(tabbedPane3.getFont().getSize() + 5f));

            //======== menuBar2 ========
            {
                menuBar2.setPreferredSize(new Dimension(209, 10));

                //---- slider2 ----
                slider2.addChangeListener(e -> slider1StateChanged(e));
                menuBar2.add(slider2);

                //======== scrollPane3 ========
                {

                    //---- label5 ----
                    label5.setText(bundle.getString("label5.text"));
                    label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));
                    scrollPane3.setViewportView(label5);
                }
                menuBar2.add(scrollPane3);
            }
            tabbedPane3.addTab(bundle.getString("menuBar2.tab.title"), menuBar2);

            //---- Clear2 ----
            Clear2.setText(bundle.getString("Clear2.text"));
            Clear2.setPreferredSize(new Dimension(57, 30));
            Clear2.setFont(Clear2.getFont().deriveFont(Clear2.getFont().getSize() + 5f));
            Clear2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ClearMouseClicked(e);
                }
            });
            tabbedPane3.addTab(bundle.getString("Clear2.tab.title"), Clear2);

            //======== panel1 ========
            {

                //---- radioButton1 ----
                radioButton1.setText(bundle.getString("radioButton1.text"));
                radioButton1.setFont(radioButton1.getFont().deriveFont(radioButton1.getFont().getSize() + 5f));
                radioButton1.addActionListener(e -> radioButton1ActionPerformed(e));

                //---- radioButton2 ----
                radioButton2.setText(bundle.getString("radioButton2.text"));
                radioButton2.setFont(radioButton2.getFont().deriveFont(radioButton2.getFont().getSize() + 5f));
                radioButton2.addActionListener(e -> radioButton2ActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(radioButton1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioButton2)
                            .addGap(18, 18, 18))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(radioButton2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            tabbedPane3.addTab(bundle.getString("panel1.tab.title_2"), panel1);
        }

        //---- curriculumRadio ----
        curriculumRadio.setText(bundle.getString("curriculumRadio.text"));
        curriculumRadio.addActionListener(e -> radioButton3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addGap(44, 44, 44)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(tabbedPane3, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addComponent(Next2, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                    .addGap(147, 147, 147))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addGap(60, 60, 60))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                    .addGap(67, 67, 67)
                    .addComponent(curriculumRadio)
                    .addGap(25, 25, 25))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addGap(165, 165, 165))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(tabbedPane3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Next2, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addGap(33, 33, 33)))
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(356, Short.MAX_VALUE)
                    .addComponent(curriculumRadio)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== Curriculum ========
        {
            Container CurriculumContentPane = Curriculum.getContentPane();

            //======== scrollPane2 ========
            {

                //---- table1 ----
                table1.setFont(table1.getFont().deriveFont(table1.getFont().getSize() + 5f));
                table1.setPreferredScrollableViewportSize(new Dimension(450, 600));
                table1.setRowHeight(30);
                table1.addPropertyChangeListener(e -> table1PropertyChange(e));
                scrollPane2.setViewportView(table1);
            }

            //---- mainRadio ----
            mainRadio.setText(bundle.getString("mainRadio.text"));
            mainRadio.addActionListener(e -> radioButton3ActionPerformed(e));

            GroupLayout CurriculumContentPaneLayout = new GroupLayout(CurriculumContentPane);
            CurriculumContentPane.setLayout(CurriculumContentPaneLayout);
            CurriculumContentPaneLayout.setHorizontalGroup(
                CurriculumContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, CurriculumContentPaneLayout.createSequentialGroup()
                        .addContainerGap(541, Short.MAX_VALUE)
                        .addComponent(mainRadio)
                        .addGap(35, 35, 35))
                    .addGroup(CurriculumContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                        .addContainerGap())
            );
            CurriculumContentPaneLayout.setVerticalGroup(
                CurriculumContentPaneLayout.createParallelGroup()
                    .addGroup(CurriculumContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainRadio)
                        .addContainerGap())
            );
            Curriculum.pack();
            Curriculum.setLocationRelativeTo(Curriculum.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label4;
    private JButton Next2;
    private JLabel label6;
    private JScrollPane scrollPane1;
    private JTextPane Out2;
    private JTabbedPane tabbedPane3;
    private JMenuBar menuBar2;
    private JSlider slider2;
    private JScrollPane scrollPane3;
    private JLabel label5;
    private JButton Clear2;
    private JPanel panel1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton curriculumRadio;
    public JFrame Curriculum;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JRadioButton mainRadio;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
