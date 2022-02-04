/*
 * Created by JFormDesigner on Sat Jan 08 23:52:29 CST 2022
 */

package ui.PanelForJX;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author Night_Aurora
 */
public class ActionPanel extends JPanel {
    public ActionPanel() {
        initComponents();
        slider.setValue(1);
        slider.setMinimum(1);
        slider.setMaximum(6);
    }

    private void Single(ActionEvent e) {
        slider.setVisible(false);
        number.setText("Single Mode");
    }

    private void Multi(ActionEvent e) {
        slider.setVisible(true);
        number.setText(String.valueOf(slider.getValue()));
    }

    private void ModeI(ActionEvent e) {

    }

    private void ModeII(ActionEvent e) {

    }

    private void sliderState(ChangeEvent e) {
        number.setText(String.valueOf(slider.getValue()));
    }

    private void Press(ActionEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("language");
        PlaceHold1 = new JLabel();
        PlaceHold2 = new JLabel();
        PlaceHold3 = new JLabel();
        PlaceHold4 = new JLabel();
        Select = new JPanel();
        ALL = new JPanel();
        SliderBox = new JPanel();
        slider = new JSlider();
        number = new JLabel();
        SelectAll = new JPanel();
        SelectNumber = new JPanel();
        Single = new JButton();
        Multi = new JButton();
        SelectMode = new JPanel();
        ModeI = new JButton();
        ModeII = new JButton();
        PlaceHold5 = new JLabel();
        PlaceHold6 = new JLabel();
        Out = new JTextField();
        Middle = new JPanel();
        PlaceHold7 = new JLabel();
        Press = new JButton();
        PlaceHold8 = new JLabel();

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

            //======== ALL ========
            {
                ALL.setLayout(new BoxLayout(ALL, BoxLayout.Y_AXIS));

                //======== SliderBox ========
                {
                    SliderBox.setLayout(new BoxLayout(SliderBox, BoxLayout.X_AXIS));

                    //---- slider ----
                    slider.setPreferredSize(new Dimension(200, 25));
                    slider.setMaximumSize(new Dimension(32767, 25));
                    slider.setFont(slider.getFont().deriveFont(Font.ITALIC));
                    slider.addChangeListener(e -> sliderState(e));
                    SliderBox.add(slider);

                    //---- number ----
                    number.setText(bundle.getString("number.text"));
                    number.setMaximumSize(new Dimension(40, 25));
                    number.setPreferredSize(new Dimension(40, 25));
                    number.setHorizontalAlignment(SwingConstants.CENTER);
                    number.setHorizontalTextPosition(SwingConstants.CENTER);
                    number.setFont(new Font("Sitka Small", Font.PLAIN, 18));
                    number.setForeground(new Color(158, 117, 250));
                    SliderBox.add(number);
                }
                ALL.add(SliderBox);

                //======== SelectAll ========
                {
                    SelectAll.setLayout(new BoxLayout(SelectAll, BoxLayout.X_AXIS));

                    //======== SelectNumber ========
                    {
                        SelectNumber.setLayout(new BoxLayout(SelectNumber, BoxLayout.X_AXIS));

                        //---- Single ----
                        Single.setText(bundle.getString("Single.text"));
                        Single.setMaximumSize(new Dimension(110, 40));
                        Single.setPreferredSize(new Dimension(110, 40));
                        Single.addActionListener(e -> Single(e));
                        SelectNumber.add(Single);

                        //---- Multi ----
                        Multi.setText(bundle.getString("Multi.text"));
                        Multi.setMaximumSize(new Dimension(110, 40));
                        Multi.setPreferredSize(new Dimension(110, 40));
                        Multi.addActionListener(e -> Multi(e));
                        SelectNumber.add(Multi);
                    }
                    SelectAll.add(SelectNumber);

                    //======== SelectMode ========
                    {
                        SelectMode.setLayout(new BoxLayout(SelectMode, BoxLayout.X_AXIS));

                        //---- ModeI ----
                        ModeI.setText(bundle.getString("ModeI.text"));
                        ModeI.setMaximumSize(new Dimension(110, 40));
                        ModeI.setPreferredSize(new Dimension(110, 40));
                        ModeI.addActionListener(e -> ModeI(e));
                        SelectMode.add(ModeI);

                        //---- ModeII ----
                        ModeII.setText(bundle.getString("ModeII.text"));
                        ModeII.setMaximumSize(new Dimension(110, 40));
                        ModeII.setPreferredSize(new Dimension(110, 40));
                        ModeII.addActionListener(e -> ModeII(e));
                        SelectMode.add(ModeII);
                    }
                    SelectAll.add(SelectMode);
                }
                ALL.add(SelectAll);
            }
            Select.add(ALL, BorderLayout.NORTH);

            //---- PlaceHold5 ----
            PlaceHold5.setMaximumSize(new Dimension(100, 16));
            PlaceHold5.setPreferredSize(new Dimension(100, 16));
            Select.add(PlaceHold5, BorderLayout.WEST);

            //---- PlaceHold6 ----
            PlaceHold6.setMaximumSize(new Dimension(100, 16));
            PlaceHold6.setPreferredSize(new Dimension(100, 16));
            Select.add(PlaceHold6, BorderLayout.EAST);

            //---- Out ----
            Out.setMinimumSize(new Dimension(49, 80));
            Out.setPreferredSize(new Dimension(49, 80));
            Out.setFont(Out.getFont().deriveFont(Out.getFont().getSize() + 10f));
            Out.setHorizontalAlignment(SwingConstants.CENTER);
            Select.add(Out, BorderLayout.SOUTH);

            //======== Middle ========
            {
                Middle.setMaximumSize(new Dimension(435, 50));
                Middle.setPreferredSize(new Dimension(435, 50));
                Middle.setLayout(new BoxLayout(Middle, BoxLayout.Y_AXIS));

                //---- PlaceHold7 ----
                PlaceHold7.setMaximumSize(new Dimension(435, 50));
                PlaceHold7.setPreferredSize(new Dimension(24, 50));
                Middle.add(PlaceHold7);

                //---- Press ----
                Press.setText(bundle.getString("Press.text"));
                Press.setPreferredSize(new Dimension(45, 60));
                Press.setMaximumSize(new Dimension(435, 60));
                Press.addActionListener(e -> Press(e));
                Middle.add(Press);

                //---- PlaceHold8 ----
                PlaceHold8.setMaximumSize(new Dimension(435, 50));
                PlaceHold8.setPreferredSize(new Dimension(24, 50));
                Middle.add(PlaceHold8);
            }
            Select.add(Middle, BorderLayout.CENTER);
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
    private JPanel ALL;
    private JPanel SliderBox;
    private JSlider slider;
    private JLabel number;
    private JPanel SelectAll;
    private JPanel SelectNumber;
    private JButton Single;
    private JButton Multi;
    private JPanel SelectMode;
    private JButton ModeI;
    private JButton ModeII;
    private JLabel PlaceHold5;
    private JLabel PlaceHold6;
    private JTextField Out;
    private JPanel Middle;
    private JLabel PlaceHold7;
    private JButton Press;
    private JLabel PlaceHold8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
