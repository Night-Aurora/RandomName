/*
 * Created by JFormDesigner on Sat Jan 08 18:56:48 CST 2022
 */
package ui.Panel

import ui.UIConsts.HOME
import ui.UIConsts.DATA
import ui.UIConsts.PARAMS
import ui.UIConsts.SETTINGS
import javax.swing.JPanel
import javax.swing.JButton
import ui.Companet.CustomButton
import java.awt.BorderLayout
import javax.swing.JLabel
import java.awt.Dimension
import java.awt.event.ActionEvent
import javax.swing.BoxLayout
import java.util.ArrayList

/**
 * @author Night_Aurora
 */
class ToolBarPanel : JPanel() {
    private val buttons: MutableList<JButton?> = ArrayList()
    private fun Home(e: ActionEvent) {
        RandomName.frameChange(RandomName.actionPanel)
        whenButtonSelected(Home)
    }

    private fun Data(e: ActionEvent) {
        RandomName.frameChange(RandomName.dataPanel)
        whenButtonSelected(Data)
    }

    private fun Param(e: ActionEvent) {
        RandomName.frameChange(RandomName.settingPanel)
        whenButtonSelected(Param)
    }

    private fun Setting(e: ActionEvent) {
        RandomName.frameChange(RandomName.infoPanel)
        whenButtonSelected(Setting)
    }

    private fun whenButtonSelected(button: JButton?) {
        button!!.isSelected = true
        buttons.stream().filter { it !== button }.forEach { it: JButton? ->
            it!!.isSelected = false
            it.icon = it.disabledIcon
        }
    }

    private fun initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ToolBar = JPanel()
        Home = CustomButton(HOME.normal, HOME.enabled)
        Data = CustomButton(DATA.normal, DATA.enabled)
        Param = CustomButton(PARAMS.normal, PARAMS.enabled)
        PlaceHold = JLabel()
        Setting = CustomButton(SETTINGS.normal, SETTINGS.enabled)

        //======== ToolBar ========
            ToolBar!!.minimumSize = Dimension(40, 360)
            ToolBar!!.preferredSize = Dimension(40, 400)
            ToolBar!!.layout = BoxLayout(ToolBar, BoxLayout.Y_AXIS)

            //---- Home ----
            Home!!.preferredSize = Dimension(40, 45)
            Home!!.maximumSize = Dimension(40, 45)
            Home!!.addActionListener { e: ActionEvent -> this.Home(e) }
            ToolBar!!.add(Home)

            //---- Data ----
            Data!!.maximumSize = Dimension(40, 45)
            Data!!.preferredSize = Dimension(70, 45)
            Data!!.addActionListener { e: ActionEvent -> this.Data(e) }
            ToolBar!!.add(Data)

            //---- Param ----
            Param!!.maximumSize = Dimension(40, 45)
            Param!!.preferredSize = Dimension(70, 45)
            Param!!.addActionListener { e: ActionEvent -> this.Param(e) }
            ToolBar!!.add(Param)

            //---- PlaceHold ----
            PlaceHold!!.preferredSize = Dimension(40, 220)
            PlaceHold!!.maximumSize = Dimension(40, 220)
            PlaceHold!!.minimumSize = Dimension(40, 210)
            ToolBar!!.add(PlaceHold)

            //---- Setting ----
            Setting!!.maximumSize = Dimension(40, 45)
            Setting!!.isSelected = true
            Setting!!.alignmentY = 0.0f
            Setting!!.preferredSize = Dimension(70, 45)
            Setting!!.addActionListener { e: ActionEvent -> this.Setting(e) }
            ToolBar!!.add(Setting)
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.add(ToolBar)
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private var ToolBar: JPanel? = null
    private var Home: JButton? = null
    private var Data: JButton? = null
    private var Param: JButton? = null
    private var PlaceHold: JLabel? = null
    private var Setting: JButton? = null // JFormDesigner - End of variables declaration  //GEN-END:variables

    init {
        initComponents()
        buttons.add(Home)
        buttons.add(Data)
        buttons.add(Param)
        buttons.add(Setting)
        whenButtonSelected(Home)
    }
}