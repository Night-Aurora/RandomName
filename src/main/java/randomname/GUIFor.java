package randomname;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Sep 18 00:19:15 CST 2021
 */



/**
 * @author 1
 */
public class GUIFor extends JFrame {
    public static void main(String[] args) {
        new GUIFor().setVisible(true);
    }
    public static int ren = 1;
    public GUIFor() {
        //UIManager.setLookAndFeel();
        initComponents();
    }

    private void slider1StateChanged(ChangeEvent e) {
        ren = slider1.getValue();
        label1.setText(slider1.getValue()+"");
    }

    private void NextMouseClicked(MouseEvent e) {
        Out.setText(RandomName.Companion.randomname(ren));
    }

    private void ClearMouseClicked(MouseEvent e) {
        Out.setText("");
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
        menuBar1 = new JMenuBar();
    }

    public void setClass(String classes){
        this.label3.setText(classes);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label3 = new JLabel();
        tabbedPane2 = new JTabbedPane();
        menuBar1 = new JMenuBar();
        slider1 = new JSlider(1,8,1);
        scrollPane2 = new JScrollPane();
        label1 = new JLabel();
        checkBox1 = new JCheckBox();
        Clear = new JButton();
        Next = new JButton();
        scrollPane1 = new JScrollPane();
        Out = new JTextPane();
        label2 = new JLabel();

        //======== this ========
        setTitle(bundle.getString("this.title"));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setMinimumSize(new Dimension(180, 206));
                contentPanel.setLayout(new MigLayout(
                    "insets dialog,hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label3 ----
                label3.setText(bundle.getString("label3.text"));
                contentPanel.add(label3, "cell 0 0");

                //======== tabbedPane2 ========
                {
                    tabbedPane2.setPreferredSize(new Dimension(120, 60));
                    tabbedPane2.setMaximumSize(new Dimension(180, 60));
                    tabbedPane2.setMinimumSize(new Dimension(160, 91));

                    //======== menuBar1 ========
                    {
                        menuBar1.setPreferredSize(new Dimension(209, 10));

                        //---- slider1 ----
                        slider1.addChangeListener(e -> slider1StateChanged(e));
                        menuBar1.add(slider1);

                        //======== scrollPane2 ========
                        {

                            //---- label1 ----
                            label1.setText(bundle.getString("label1.text"));
                            scrollPane2.setViewportView(label1);
                        }
                        menuBar1.add(scrollPane2);
                    }
                    tabbedPane2.addTab(bundle.getString("menuBar1.tab.title"), menuBar1);

                    //---- checkBox1 ----
                    checkBox1.setText(bundle.getString("checkBox1.text"));
                    checkBox1.setMaximumSize(new Dimension(60, 50));
                    checkBox1.setMinimumSize(new Dimension(60, 91));
                    tabbedPane2.addTab(bundle.getString("checkBox1.tab.title"), checkBox1);

                    //---- Clear ----
                    Clear.setText(bundle.getString("Clear.text"));
                    Clear.setPreferredSize(new Dimension(57, 30));
                    Clear.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            ClearMouseClicked(e);
                        }
                    });
                    tabbedPane2.addTab(bundle.getString("Clear.tab.title"), Clear);
                }
                contentPanel.add(tabbedPane2, "cell 7 1");

                //---- Next ----
                Next.setText(bundle.getString("Next.text"));
                Next.setPreferredSize(new Dimension(57, 30));
                Next.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        NextMouseClicked(e);
                    }
                });
                contentPanel.add(Next, "cell 7 4");

                //======== scrollPane1 ========
                {

                    //---- Out ----
                    Out.setPreferredSize(new Dimension(10, 50));
                    scrollPane1.setViewportView(Out);
                }
                contentPanel.add(scrollPane1, "cell 4 8 7 3");

                //---- label2 ----
                label2.setText(bundle.getString("label2.text"));
                label2.setPreferredSize(new Dimension(174, 35));
                contentPanel.add(label2, "cell 7 11 1 2");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label3;
    private JTabbedPane tabbedPane2;
    private JMenuBar menuBar1;
    private JSlider slider1;
    private JScrollPane scrollPane2;
    private JLabel label1;
    private JCheckBox checkBox1;
    private JButton Clear;
    private JButton Next;
    private JScrollPane scrollPane1;
    private JTextPane Out;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
