/*
 * Created by JFormDesigner on Thu Jan 27 20:20:03 CST 2022
 */

package ui.PanelForJX;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Night_Aurora
 */
public class SettingPanel extends JPanel {
    public SettingPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("language");
        PlaceHold1 = new JLabel();
        PlaceHold3 = new JLabel();
        PlaceHold4 = new JLabel();
        PlaceHold2 = new JLabel();
        Select = new JPanel();
        OptionName = new JPanel();
        lunxun = new JLabel();
        renxu = new JLabel();
        renxu2 = new JLabel();
        ValueAndOption = new JPanel();
        OptionValue = new JPanel();
        lunxunValue = new JLabel();
        renshuValue = new JLabel();
        moshiValue = new JLabel();
        OptionReset = new JPanel();
        lunxunReset = new JButton();
        renshuReset = new JButton();
        moshiReset = new JButton();
        Option = new JPanel();
        lunxunSlider = new JSlider();
        renshuSlider = new JSlider();
        moshicomboBox = new JComboBox();

        //======== this ========
        setForeground(Color.white);
        setBackground(Color.white);
        setLayout(new BorderLayout());

        //---- PlaceHold1 ----
        PlaceHold1.setMaximumSize(new Dimension(24, 50));
        PlaceHold1.setPreferredSize(new Dimension(24, 30));
        add(PlaceHold1, BorderLayout.NORTH);

        //---- PlaceHold3 ----
        PlaceHold3.setMaximumSize(new Dimension(50, 16));
        PlaceHold3.setPreferredSize(new Dimension(30, 16));
        add(PlaceHold3, BorderLayout.WEST);

        //---- PlaceHold4 ----
        PlaceHold4.setPreferredSize(new Dimension(30, 16));
        PlaceHold4.setMaximumSize(new Dimension(50, 16));
        add(PlaceHold4, BorderLayout.EAST);

        //---- PlaceHold2 ----
        PlaceHold2.setPreferredSize(new Dimension(350, 30));
        PlaceHold2.setMaximumSize(new Dimension(24, 50));
        add(PlaceHold2, BorderLayout.SOUTH);

        //======== Select ========
        {
            Select.setLayout(new BorderLayout());

            //======== OptionName ========
            {
                OptionName.setPreferredSize(new Dimension(100, 0));
                OptionName.setMaximumSize(new Dimension(100, 30));
                OptionName.setLayout(new BoxLayout(OptionName, BoxLayout.Y_AXIS));

                //---- lunxun ----
                lunxun.setText(bundle.getString("lunxun.text"));
                lunxun.setPreferredSize(new Dimension(100, 30));
                lunxun.setMinimumSize(new Dimension(80, 16));
                lunxun.setMaximumSize(new Dimension(100, 30));
                lunxun.setFont(lunxun.getFont().deriveFont(lunxun.getFont().getSize() + 4f));
                lunxun.setFocusTraversalPolicyProvider(true);
                lunxun.setHorizontalAlignment(SwingConstants.CENTER);
                OptionName.add(lunxun);

                //---- renxu ----
                renxu.setText(bundle.getString("renxu.text"));
                renxu.setPreferredSize(new Dimension(100, 30));
                renxu.setMinimumSize(new Dimension(80, 16));
                renxu.setMaximumSize(new Dimension(100, 30));
                renxu.setFont(renxu.getFont().deriveFont(renxu.getFont().getSize() + 4f));
                renxu.setFocusTraversalPolicyProvider(true);
                renxu.setHorizontalAlignment(SwingConstants.CENTER);
                OptionName.add(renxu);

                //---- renxu2 ----
                renxu2.setText(bundle.getString("renxu2.text"));
                renxu2.setPreferredSize(new Dimension(100, 30));
                renxu2.setMinimumSize(new Dimension(80, 16));
                renxu2.setMaximumSize(new Dimension(100, 30));
                renxu2.setFont(renxu2.getFont().deriveFont(renxu2.getFont().getSize() + 4f));
                renxu2.setFocusTraversalPolicyProvider(true);
                renxu2.setHorizontalAlignment(SwingConstants.CENTER);
                OptionName.add(renxu2);
            }
            Select.add(OptionName, BorderLayout.WEST);

            //======== ValueAndOption ========
            {
                ValueAndOption.setLayout(new BorderLayout());

                //======== OptionValue ========
                {
                    OptionValue.setMaximumSize(new Dimension(30, 30));
                    OptionValue.setPreferredSize(new Dimension(30, 30));
                    OptionValue.setLayout(new BoxLayout(OptionValue, BoxLayout.Y_AXIS));

                    //---- lunxunValue ----
                    lunxunValue.setMaximumSize(new Dimension(30, 30));
                    lunxunValue.setPreferredSize(new Dimension(30, 30));
                    OptionValue.add(lunxunValue);

                    //---- renshuValue ----
                    renshuValue.setMaximumSize(new Dimension(30, 30));
                    renshuValue.setPreferredSize(new Dimension(30, 30));
                    OptionValue.add(renshuValue);

                    //---- moshiValue ----
                    moshiValue.setMaximumSize(new Dimension(30, 30));
                    moshiValue.setPreferredSize(new Dimension(30, 30));
                    OptionValue.add(moshiValue);
                }
                ValueAndOption.add(OptionValue, BorderLayout.WEST);

                //======== OptionReset ========
                {
                    OptionReset.setPreferredSize(new Dimension(70, 0));
                    OptionReset.setMaximumSize(new Dimension(70, 0));
                    OptionReset.setLayout(new BoxLayout(OptionReset, BoxLayout.Y_AXIS));

                    //---- lunxunReset ----
                    lunxunReset.setText(bundle.getString("lunxunReset.text"));
                    OptionReset.add(lunxunReset);

                    //---- renshuReset ----
                    renshuReset.setText(bundle.getString("renshuReset.text"));
                    OptionReset.add(renshuReset);

                    //---- moshiReset ----
                    moshiReset.setText(bundle.getString("moshiReset.text"));
                    OptionReset.add(moshiReset);
                }
                ValueAndOption.add(OptionReset, BorderLayout.CENTER);
            }
            Select.add(ValueAndOption, BorderLayout.EAST);

            //======== Option ========
            {
                Option.setPreferredSize(new Dimension(150, 0));
                Option.setMaximumSize(new Dimension(150, 90));
                Option.setMinimumSize(new Dimension(150, 62));
                Option.setInheritsPopupMenu(true);
                Option.setLayout(new BoxLayout(Option, BoxLayout.Y_AXIS));

                //---- lunxunSlider ----
                lunxunSlider.setMaximumSize(new Dimension(32767, 30));
                lunxunSlider.setPreferredSize(new Dimension(150, 30));
                Option.add(lunxunSlider);

                //---- renshuSlider ----
                renshuSlider.setMaximumSize(new Dimension(32767, 30));
                renshuSlider.setPreferredSize(new Dimension(150, 30));
                Option.add(renshuSlider);

                //---- moshicomboBox ----
                moshicomboBox.setMaximumSize(new Dimension(32767, 30));
                moshicomboBox.setMinimumSize(new Dimension(81, 30));
                moshicomboBox.setPreferredSize(new Dimension(150, 30));
                moshicomboBox.setBorder(new EmptyBorder(5, 5, 5, 5));
                Option.add(moshicomboBox);
            }
            Select.add(Option, BorderLayout.CENTER);
        }
        add(Select, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel PlaceHold1;
    private JLabel PlaceHold3;
    private JLabel PlaceHold4;
    private JLabel PlaceHold2;
    private JPanel Select;
    private JPanel OptionName;
    private JLabel lunxun;
    private JLabel renxu;
    private JLabel renxu2;
    private JPanel ValueAndOption;
    private JPanel OptionValue;
    private JLabel lunxunValue;
    private JLabel renshuValue;
    private JLabel moshiValue;
    private JPanel OptionReset;
    private JButton lunxunReset;
    private JButton renshuReset;
    private JButton moshiReset;
    private JPanel Option;
    private JSlider lunxunSlider;
    private JSlider renshuSlider;
    private JComboBox moshicomboBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
