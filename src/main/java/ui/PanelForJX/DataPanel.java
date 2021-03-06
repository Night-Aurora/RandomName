/*
 * Created by JFormDesigner on Wed Jan 19 23:58:39 CST 2022
 */

package ui.PanelForJX;

import com.google.common.collect.Table;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Night_Aurora
 */
public class DataPanel extends JPanel {
    public DataPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("language");
        panel = new JPanel();
        PlaceHold1 = new JLabel();
        PlaceHold2 = new JLabel();
        PlaceHold4 = new JLabel();
        PlaceHold3 = new JLabel();
        SubPanel = new JTabbedPane();
        Curriculum = new JScrollPane();
        Table = new JTable();
        Students = new JScrollPane();
        List = new JList();
        StuRLMenu = new JPopupMenu();
        Delete = new JMenuItem();
        Add = new JMenuItem();

        //======== panel ========
        {
            panel.setMinimumSize(new Dimension(373, 183));
            panel.setPreferredSize(new Dimension(735, 295));
            panel.setBackground(Color.white);
            panel.setLayout(new BorderLayout());

            //---- PlaceHold1 ----
            PlaceHold1.setMaximumSize(new Dimension(24, 50));
            PlaceHold1.setPreferredSize(new Dimension(24, 20));
            panel.add(PlaceHold1, BorderLayout.NORTH);

            //---- PlaceHold2 ----
            PlaceHold2.setMaximumSize(new Dimension(24, 50));
            PlaceHold2.setPreferredSize(new Dimension(24, 20));
            panel.add(PlaceHold2, BorderLayout.SOUTH);

            //---- PlaceHold4 ----
            PlaceHold4.setMaximumSize(new Dimension(50, 16));
            PlaceHold4.setPreferredSize(new Dimension(20, 16));
            panel.add(PlaceHold4, BorderLayout.WEST);

            //---- PlaceHold3 ----
            PlaceHold3.setMaximumSize(new Dimension(50, 16));
            PlaceHold3.setPreferredSize(new Dimension(20, 16));
            panel.add(PlaceHold3, BorderLayout.EAST);

            //======== SubPanel ========
            {

                //======== Curriculum ========
                {

                    //---- Table ----
                    Table.setFont(Table.getFont().deriveFont(Table.getFont().getSize() + 4f));
                    Curriculum.setViewportView(Table);
                }
                SubPanel.addTab("\u8bfe\u7a0b\u8868", Curriculum);

                //======== Students ========
                {

                    //---- List ----
                    List.setFont(List.getFont().deriveFont(List.getFont().getSize() + 4f));
                    Students.setViewportView(List);
                }
                SubPanel.addTab("\u5b66\u751f\u5217\u8868", Students);
            }
            panel.add(SubPanel, BorderLayout.CENTER);
        }

        //======== StuRLMenu ========
        {

            //---- Delete ----
            Delete.setText(bundle.getString("Delete.text"));
            StuRLMenu.add(Delete);

            //---- Add ----
            Add.setText(bundle.getString("Add.text"));
            StuRLMenu.add(Add);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel;
    private JLabel PlaceHold1;
    private JLabel PlaceHold2;
    private JLabel PlaceHold4;
    private JLabel PlaceHold3;
    private JTabbedPane SubPanel;
    private JScrollPane Curriculum;
    private JTable Table;
    private JScrollPane Students;
    private JList List;
    private JPopupMenu StuRLMenu;
    private JMenuItem Delete;
    private JMenuItem Add;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
