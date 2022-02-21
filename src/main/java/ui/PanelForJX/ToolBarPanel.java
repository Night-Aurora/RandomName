/*
 * Created by JFormDesigner on Sat Jan 08 18:56:48 CST 2022
 */

package ui.PanelForJX;

import java.awt.event.*;

import ui.Companet.CustomButton;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import static ui.UIConsts.*;


/**
 * @author Night_Aurora
 */
public class ToolBarPanel extends JPanel {
    private List<JButton> buttons = new ArrayList<>();
    public ToolBarPanel() {
        initComponents();
        buttons.add(this.Home);
        buttons.add(this.Data);
        buttons.add(this.Param);
        buttons.add(this.Setting);
    }

    private void Home(ActionEvent e) {
        whenButtonSelected(Home);
    }

    private void Data(ActionEvent e) {
        whenButtonSelected(Data);
    }

    private void Param(ActionEvent e) {
        whenButtonSelected(Param);
    }

    private void Setting(ActionEvent e) {
        whenButtonSelected(Setting);
    }

    private void whenButtonSelected(JButton button){
        button.setSelected(true);
        buttons.stream().filter(it -> it != button).forEach(it -> {
            it.setSelected(false);
            it.setIcon(it.getDisabledIcon());
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ToolBar = new JPanel();
        Home = new JButton();
        Data = new JButton();
        Param = new JButton();
        PlaceHold = new JLabel();
        Setting = new JButton();

        //======== ToolBar ========
        {
            ToolBar.setMinimumSize(new Dimension(40, 360));
            ToolBar.setPreferredSize(new Dimension(40, 400));
            ToolBar.setLayout(new BoxLayout(ToolBar, BoxLayout.Y_AXIS));

            //---- Home ----
            Home.setPreferredSize(new Dimension(40, 45));
            Home.setMaximumSize(new Dimension(40, 45));
            Home.addActionListener(e -> Home(e));
            ToolBar.add(Home);

            //---- Data ----
            Data.setMaximumSize(new Dimension(40, 45));
            Data.setPreferredSize(new Dimension(70, 45));
            Data.addActionListener(e -> Data(e));
            ToolBar.add(Data);

            //---- Param ----
            Param.setMaximumSize(new Dimension(40, 45));
            Param.setPreferredSize(new Dimension(70, 45));
            Param.addActionListener(e -> Param(e));
            ToolBar.add(Param);

            //---- PlaceHold ----
            PlaceHold.setPreferredSize(new Dimension(40, 220));
            PlaceHold.setMaximumSize(new Dimension(40, 220));
            PlaceHold.setMinimumSize(new Dimension(40, 210));
            ToolBar.add(PlaceHold);

            //---- Setting ----
            Setting.setMaximumSize(new Dimension(40, 45));
            Setting.setSelected(true);
            Setting.setAlignmentY(0.0F);
            Setting.setPreferredSize(new Dimension(70, 45));
            Setting.addActionListener(e -> Setting(e));
            ToolBar.add(Setting);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.add(ToolBar);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel ToolBar;
    private JButton Home;
    private JButton Data;
    private JButton Param;
    private JLabel PlaceHold;
    private JButton Setting;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
