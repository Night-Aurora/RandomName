/*
 * Created by JFormDesigner on Thu Jan 20 00:29:58 CST 2022
 */

package ui.PanelForJX;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Night_Aurora
 */
public class InfoPanel extends JPanel {
    public InfoPanel() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("language");
        PlaceHold1 = new JLabel();
        PlaceHold2 = new JLabel();
        PlaceHold3 = new JLabel();
        PlaceHold4 = new JLabel();
        Select = new JPanel();
        Free = new JPanel();
        PNG = new JLabel();
        GithubLink = new JLabel();
        Copyright = new JLabel();

        //======== this ========
        setForeground(Color.white);
        setBackground(Color.white);
        setLayout(new BorderLayout());

        //---- PlaceHold1 ----
        PlaceHold1.setMaximumSize(new Dimension(24, 50));
        PlaceHold1.setPreferredSize(new Dimension(24, 50));
        add(PlaceHold1, BorderLayout.NORTH);

        //---- PlaceHold2 ----
        PlaceHold2.setPreferredSize(new Dimension(24, 50));
        PlaceHold2.setMaximumSize(new Dimension(24, 50));
        add(PlaceHold2, BorderLayout.SOUTH);

        //---- PlaceHold3 ----
        PlaceHold3.setMaximumSize(new Dimension(50, 16));
        PlaceHold3.setPreferredSize(new Dimension(50, 16));
        add(PlaceHold3, BorderLayout.WEST);

        //---- PlaceHold4 ----
        PlaceHold4.setPreferredSize(new Dimension(50, 16));
        PlaceHold4.setMaximumSize(new Dimension(50, 16));
        add(PlaceHold4, BorderLayout.EAST);

        //======== Select ========
        {
            Select.setLayout(new BorderLayout());

            //======== Free ========
            {

                //---- PNG ----
                PNG.setMaximumSize(new Dimension(64, 64));
                PNG.setPreferredSize(new Dimension(64, 64));

                //---- GithubLink ----
                GithubLink.setText(bundle.getString("GithubLink.text"));
                GithubLink.setHorizontalAlignment(SwingConstants.CENTER);
                GithubLink.setFont(GithubLink.getFont().deriveFont(GithubLink.getFont().getSize() + 2f));

                //---- Copyright ----
                Copyright.setText(bundle.getString("Copyright.text"));
                Copyright.setHorizontalAlignment(SwingConstants.CENTER);
                Copyright.setFont(Copyright.getFont().deriveFont(Copyright.getFont().getSize() - 1f));

                GroupLayout FreeLayout = new GroupLayout(Free);
                Free.setLayout(FreeLayout);
                FreeLayout.setHorizontalGroup(
                    FreeLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, FreeLayout.createSequentialGroup()
                            .addGap(168, 168, 168)
                            .addComponent(PNG, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addGap(164, 164, 164))
                        .addGroup(FreeLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(FreeLayout.createParallelGroup()
                                .addComponent(Copyright, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                                .addComponent(GithubLink, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                            .addContainerGap())
                );
                FreeLayout.setVerticalGroup(
                    FreeLayout.createParallelGroup()
                        .addGroup(FreeLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(PNG, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addGap(65, 65, 65)
                            .addComponent(GithubLink, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Copyright, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                );
            }
            Select.add(Free, BorderLayout.CENTER);
        }
        add(Select, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel PlaceHold1;
    private JLabel PlaceHold2;
    private JLabel PlaceHold3;
    private JLabel PlaceHold4;
    private JPanel Select;
    private JPanel Free;
    private JLabel PNG;
    private JLabel GithubLink;
    private JLabel Copyright;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
