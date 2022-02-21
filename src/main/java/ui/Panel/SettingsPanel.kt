/*
 * Created by JFormDesigner on Thu Jan 20 00:29:58 CST 2022
 */
package ui.Panel

import com.sun.org.apache.bcel.internal.generic.Select
import org.jdesktop.layout.GroupLayout
import org.jdesktop.layout.LayoutStyle
import ui.UIConsts
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import java.net.URI
import java.net.URL
import java.util.*
import javax.swing.*
import javax.swing.event.ChangeEvent

/**
 * @author Night_Aurora
 */
class SettingsPanel : JPanel() {
    private fun initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        val bundle = ResourceBundle.getBundle("language")
        PlaceHold1 = JLabel()
        PlaceHold2 = JLabel()
        PlaceHold3 = JLabel()
        PlaceHold4 = JLabel()
        Select = JPanel()
        SubPanel = JPanel()
        PNG = JLabel(/*ImageIcon(RandomName.javaClass.getResource(""))*/)
        SubSubPanel = JPanel()
        GithubLink = JLabel()
        Github = JButton()
        Bugs = JLabel()
        Report = JButton()

        //======== this ========
        foreground = Color.white
        background = Color.white
        layout = BorderLayout()

        //---- PlaceHold1 ----
        PlaceHold1!!.maximumSize = Dimension(24, 50)
        PlaceHold1!!.preferredSize = Dimension(24, 50)
        add(PlaceHold1, BorderLayout.NORTH)

        //---- PlaceHold2 ----
        PlaceHold2!!.preferredSize = Dimension(24, 50)
        PlaceHold2!!.maximumSize = Dimension(24, 50)
        add(PlaceHold2, BorderLayout.SOUTH)

        //---- PlaceHold3 ----
        PlaceHold3!!.maximumSize = Dimension(50, 16)
        PlaceHold3!!.preferredSize = Dimension(50, 16)
        add(PlaceHold3, BorderLayout.WEST)

        //---- PlaceHold4 ----
        PlaceHold4!!.preferredSize = Dimension(50, 16)
        PlaceHold4!!.maximumSize = Dimension(50, 16)
        add(PlaceHold4, BorderLayout.EAST)

        //======== Select ========
            Select!!.setLayout(BorderLayout())

            //======== SubPanel ========
                SubPanel!!.layout = BorderLayout()

                //---- PNG ----
                PNG!!.preferredSize = Dimension(435, 128)
                PNG!!.maximumSize = Dimension(435, 128)
                SubPanel!!.add(PNG, BorderLayout.NORTH)

                //======== SubSubPanel ========
                    //---- GithubLink ----
                    GithubLink!!.text = bundle.getString("GithubLink.text")
                    GithubLink!!.horizontalAlignment = SwingConstants.CENTER
                    GithubLink!!.font = GithubLink!!.font.deriveFont(GithubLink!!.font.size + 1f)

                    //---- Github ----
                    Github!!.text = bundle.getString("Github.text")
                    Github!!.preferredSize = Dimension(80, 30)
                    Github!!.verticalAlignment = SwingConstants.BOTTOM
                    Github!!.addActionListener(this::Github)

                    //---- Bugs ----
                    Bugs!!.text = bundle.getString("Bugs.text")
                    Bugs!!.font = Bugs!!.font.deriveFont(Bugs!!.font.size + 1f)
                    Bugs!!.horizontalAlignment = SwingConstants.CENTER

                    //---- Report ----
                    Report!!.text = bundle.getString("Report.text")
                    Report!!.preferredSize = Dimension(80, 30)
                    Report!!.verticalAlignment = SwingConstants.BOTTOM
                    Report!!.addActionListener(this::Report)
                    val SubSubPanelLayout = GroupLayout(SubSubPanel)
                    SubSubPanel!!.layout = SubSubPanelLayout
        SubSubPanelLayout.horizontalGroup = SubSubPanelLayout.createParallelGroup(GroupLayout.TRAILING)
            .add(SubSubPanelLayout.createSequentialGroup()
                .add(SubSubPanelLayout.createParallelGroup(GroupLayout.TRAILING)
                    .add(SubSubPanelLayout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(GithubLink, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(Github, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE.toInt()))
                    .add(SubSubPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(Bugs, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(Report, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE.toInt())))
                .add(12, 12, 12))
        SubSubPanelLayout.verticalGroup = SubSubPanelLayout.createParallelGroup()
            .add(SubSubPanelLayout.createSequentialGroup()
                .add(135, 135, 135)
                .add(SubSubPanelLayout.createParallelGroup(GroupLayout.BASELINE)
                    .add(Bugs, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .add(Report, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.UNRELATED)
                .add(SubSubPanelLayout.createParallelGroup(GroupLayout.BASELINE)
                    .add(GithubLink, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE.toInt())
                    .add(Github, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())

                SubPanel!!.add(SubSubPanel, BorderLayout.SOUTH)

            Select!!.add(SubPanel, BorderLayout.CENTER)
        add(Select, BorderLayout.CENTER)
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private var PlaceHold1: JLabel? = null
    private var PlaceHold2: JLabel? = null
    private var PlaceHold3: JLabel? = null
    private var PlaceHold4: JLabel? = null
    private var Select: JPanel? = null
    private var SubPanel: JPanel? = null
    private var PNG: JLabel? = null
    private var SubSubPanel: JPanel? = null
    private var GithubLink: JLabel? = null
    private var Github: JButton? = null
    private var Bugs: JLabel? = null
    private var Report: JButton? = null // JFormDesigner - End of variables declaration  //GEN-END:variables

    init {
        initComponents()
    }

    private fun Github(e:ActionEvent){
        Desktop.getDesktop().browse(URI("https://github.com/Night-Aurora/RandomName"))
    }
    private fun Report(e:ActionEvent){
        Desktop.getDesktop().browse(URI("https://github.com/Night-Aurora/RandomName/issues"))
    }
}