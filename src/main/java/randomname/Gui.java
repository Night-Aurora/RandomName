/*
 * Created by JFormDesigner on Fri Oct 01 00:42:59 CST 2021
 */

package randomname;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;

/**
 * @author 1
 */
public class Gui extends JFrame {
    private boolean foreaching = false;
    private ForEachThread forEachThread = new ForEachThread();
    private ResourceBundle bundle = ResourceBundle.getBundle("String");
    public Gui() {
        initComponents();
        slider2.setMinimum(1);
        slider2.setMaximum(6);
        slider2.setValue(1);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        radioButton1.setSelected(true);
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
        if(!radioButton2.isSelected())
            Out2.setFont(Out2.getFont().deriveFont(24f));
    }

    private void radioButton2ActionPerformed(ActionEvent e) {
        //mode2
        if(radioButton2.isSelected())
            Out2.setFont(Out2.getFont().deriveFont(44f));
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("String");
        label4 = new JLabel();
        tabbedPane3 = new JTabbedPane();
        menuBar2 = new JMenuBar();
        slider2 = new JSlider();
        scrollPane3 = new JScrollPane();
        label5 = new JLabel();
        Clear2 = new JButton();
        panel1 = new JPanel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        Next2 = new JButton();
        label6 = new JLabel();
        scrollPane1 = new JScrollPane();
        Out2 = new JTextPane();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label4 ----
        label4.setText(bundle.getString("label4.text"));
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
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
                            .addContainerGap(25, Short.MAX_VALUE))
                );
            }
            tabbedPane3.addTab(bundle.getString("panel1.tab.title_2"), panel1);
        }

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
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));

        //======== scrollPane1 ========
        {

            //---- Out2 ----
            Out2.setPreferredSize(new Dimension(10, 65));
            Out2.setFont(Out2.getFont().deriveFont(Out2.getFont().getSize() + 12f));
            Out2.setMinimumSize(new Dimension(7, 65));
            scrollPane1.setViewportView(Out2);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addGap(505, 505, 505))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(tabbedPane3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Next2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(155, 155, 155))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addGap(69, 69, 69))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGap(60, 60, 60))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addGap(153, 153, 153))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(tabbedPane3, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addGap(27, 27, 27)
                            .addComponent(Next2, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
                    .addGap(51, 51, 51)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addGap(31, 31, 31)
                    .addComponent(label6, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addGap(143, 143, 143))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label4;
    private JTabbedPane tabbedPane3;
    private JMenuBar menuBar2;
    private JSlider slider2;
    private JScrollPane scrollPane3;
    private JLabel label5;
    private JButton Clear2;
    private JPanel panel1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton Next2;
    private JLabel label6;
    private JScrollPane scrollPane1;
    private JTextPane Out2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    class mode2 extends Panel{
        public mode2(){

        }
    }
}
