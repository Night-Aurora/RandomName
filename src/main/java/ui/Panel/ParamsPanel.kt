/*
 * Created by JFormDesigner on Thu Jan 27 20:20:03 CST 2022
 */
package ui.Panel

import ui.Utils.Option
import ui.Utils.Option.getIntOption
import ui.Utils.Option.getLongOption
import ui.Utils.Option.getSelectOption
import javax.swing.JPanel
import java.util.ResourceBundle
import javax.swing.JLabel
import javax.swing.JButton
import javax.swing.JSlider
import javax.swing.JComboBox
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.event.ActionEvent
import javax.swing.BoxLayout
import javax.swing.SwingConstants
import javax.swing.border.EmptyBorder
import javax.swing.event.ChangeEvent

/**
 * @author Night_Aurora
 */
class ParamsPanel : JPanel() {
    private fun initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        val bundle = ResourceBundle.getBundle("language")
        PlaceHold1 = JLabel()
        PlaceHold3 = JLabel()
        PlaceHold4 = JLabel()
        PlaceHold2 = JLabel()
        Select = JPanel()
        OptionName = JPanel()
        lunxun = JLabel()
        renxu = JLabel()
        renxu2 = JLabel()
        ValueAndOption = JPanel()
        OptionValue = JPanel()
        lunxunValue = JLabel()
        renshuValue = JLabel()
        moshiValue = JLabel()
        OptionReset = JPanel()
        lunxunReset = JButton()
        renshuReset = JButton()
        moshiReset = JButton()
        Option = JPanel()
        lunxunSlider = JSlider()
        renshuSlider = JSlider()
        moshicomboBox = JComboBox<String>()

        //======== this ========
        foreground = Color.white
        background = Color.white
        layout = BorderLayout()

        //---- PlaceHold1 ----
        PlaceHold1!!.maximumSize = Dimension(24, 50)
        PlaceHold1!!.preferredSize = Dimension(24, 30)
        add(PlaceHold1, BorderLayout.NORTH)

        //---- PlaceHold3 ----
        PlaceHold3!!.maximumSize = Dimension(50, 16)
        PlaceHold3!!.preferredSize = Dimension(30, 16)
        add(PlaceHold3, BorderLayout.WEST)

        //---- PlaceHold4 ----
        PlaceHold4!!.preferredSize = Dimension(30, 16)
        PlaceHold4!!.maximumSize = Dimension(50, 16)
        add(PlaceHold4, BorderLayout.EAST)

        //---- PlaceHold2 ----
        PlaceHold2!!.preferredSize = Dimension(350, 30)
        PlaceHold2!!.maximumSize = Dimension(24, 50)
        add(PlaceHold2, BorderLayout.SOUTH)

        //======== Select ========
            Select!!.setLayout(BorderLayout())

            //======== OptionName ========
                OptionName!!.preferredSize = Dimension(100, 0)
                OptionName!!.maximumSize = Dimension(100, 30)
                OptionName!!.layout = BoxLayout(OptionName, BoxLayout.Y_AXIS)

                //---- lunxun ----
                lunxun!!.text = bundle.getString("lunxun.text")
                lunxun!!.preferredSize = Dimension(100, 30)
                lunxun!!.minimumSize = Dimension(80, 16)
                lunxun!!.maximumSize = Dimension(100, 30)
                lunxun!!.font = lunxun!!.font.deriveFont(lunxun!!.font.size + 4f)
                lunxun!!.isFocusTraversalPolicyProvider = true
                lunxun!!.horizontalAlignment = SwingConstants.CENTER
                OptionName!!.add(lunxun)

                //---- renxu ----
                renxu!!.text = bundle.getString("renxu.text")
                renxu!!.preferredSize = Dimension(100, 30)
                renxu!!.minimumSize = Dimension(80, 16)
                renxu!!.maximumSize = Dimension(100, 30)
                renxu!!.font = renxu!!.font.deriveFont(renxu!!.font.size + 4f)
                renxu!!.isFocusTraversalPolicyProvider = true
                renxu!!.horizontalAlignment = SwingConstants.CENTER
                OptionName!!.add(renxu)

                //---- renxu2 ----
                renxu2!!.text = bundle.getString("renxu2.text")
                renxu2!!.preferredSize = Dimension(100, 30)
                renxu2!!.minimumSize = Dimension(80, 16)
                renxu2!!.maximumSize = Dimension(100, 30)
                renxu2!!.font = renxu2!!.font.deriveFont(renxu2!!.font.size + 4f)
                renxu2!!.isFocusTraversalPolicyProvider = true
                renxu2!!.horizontalAlignment = SwingConstants.CENTER
                OptionName!!.add(renxu2)

            Select!!.add(OptionName, BorderLayout.WEST)

            //======== ValueAndOption ========

                ValueAndOption!!.setLayout(BorderLayout())

                //======== OptionValue ========

                    OptionValue!!.maximumSize = Dimension(30, 30)
                    OptionValue!!.preferredSize = Dimension(30, 30)
                    OptionValue!!.layout = BoxLayout(OptionValue, BoxLayout.Y_AXIS)

                    //---- lunxunValue ----
                    lunxunValue!!.maximumSize = Dimension(30, 30)
                    lunxunValue!!.preferredSize = Dimension(30, 30)
                    OptionValue!!.add(lunxunValue)

                    //---- renshuValue ----
                    renshuValue!!.maximumSize = Dimension(30, 30)
                    renshuValue!!.preferredSize = Dimension(30, 30)
                    OptionValue!!.add(renshuValue)

                    //---- moshiValue ----
                    moshiValue!!.maximumSize = Dimension(30, 30)
                    moshiValue!!.preferredSize = Dimension(30, 30)
                    OptionValue!!.add(moshiValue)

                ValueAndOption!!.add(OptionValue, BorderLayout.WEST)

                //======== OptionReset ========

                    OptionReset!!.preferredSize = Dimension(70, 0)
                    OptionReset!!.maximumSize = Dimension(70, 0)
                    OptionReset!!.layout = BoxLayout(OptionReset, BoxLayout.Y_AXIS)

                    //---- lunxunReset ----
                    lunxunReset!!.text = bundle.getString("lunxunReset.text")
                    lunxunReset!!.addActionListener { Reset(lunxunReset!!) }
                    OptionReset!!.add(lunxunReset)

                    //---- renshuReset ----
                    renshuReset!!.text = bundle.getString("renshuReset.text")
                    renshuReset!!.addActionListener { Reset(renshuReset!!) }
                    OptionReset!!.add(renshuReset)

                    //---- moshiReset ----
                    moshiReset!!.text = bundle.getString("moshiReset.text")
                    moshiReset!!.addActionListener { Reset(moshiReset!!) }
                    OptionReset!!.add(moshiReset)
                ValueAndOption!!.add(OptionReset, BorderLayout.CENTER)
            Select!!.add(ValueAndOption, BorderLayout.EAST)

            //======== Option ========
                Option!!.preferredSize = Dimension(150, 0)
                Option!!.maximumSize = Dimension(150, 90)
                Option!!.minimumSize = Dimension(150, 62)
                Option!!.inheritsPopupMenu = true
                Option!!.layout = BoxLayout(Option, BoxLayout.Y_AXIS)

                //---- lunxunSlider ----
                lunxunSlider!!.maximumSize = Dimension(32767, 30)
                lunxunSlider!!.preferredSize = Dimension(150, 30)
                lunxunSlider!!.addChangeListener(this::lunxunS)
                Option!!.add(lunxunSlider)

                //---- renshuSlider ----
                renshuSlider!!.maximumSize = Dimension(32767, 30)
                renshuSlider!!.preferredSize = Dimension(150, 30)
                renshuSlider!!.addChangeListener(this::renshuS)
                Option!!.add(renshuSlider)

                //---- moshicomboBox ----
                moshicomboBox!!.maximumSize = Dimension(32767, 30)
                moshicomboBox!!.minimumSize = Dimension(81, 30)
                moshicomboBox!!.preferredSize = Dimension(150, 30)
                moshicomboBox!!.addActionListener(this::moshiS)
                moshicomboBox!!.border = EmptyBorder(5, 5, 5, 5)
                Option!!.add(moshicomboBox)
            Select!!.add(Option, BorderLayout.CENTER)
        add(Select, BorderLayout.CENTER)
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private var PlaceHold1: JLabel? = null
    private var PlaceHold3: JLabel? = null
    private var PlaceHold4: JLabel? = null
    private var PlaceHold2: JLabel? = null
    private var Select: JPanel? = null
    private var OptionName: JPanel? = null
    private var lunxun: JLabel? = null
    private var renxu: JLabel? = null
    private var renxu2: JLabel? = null
    private var ValueAndOption: JPanel? = null
    private var OptionValue: JPanel? = null
    private var lunxunValue: JLabel? = null
    private var renshuValue: JLabel? = null
    private var moshiValue: JLabel? = null
    private var OptionReset: JPanel? = null
    private var lunxunReset: JButton? = null
    private var renshuReset: JButton? = null
    private var moshiReset: JButton? = null
    private var Option: JPanel? = null
    private var lunxunSlider: JSlider? = null
    private var renshuSlider: JSlider? = null
    private var moshicomboBox: JComboBox<String>? = null // JFormDesigner - End of variables declaration  //GEN-END:variables

    init {
        initComponents()
        lunxunSlider.also { it!!.minimum = 20;it.maximum = 200;it.value = getLongOption("ModeII").value.toInt() }
        renshuSlider.also { it!!.minimum = 1;it.maximum = 6;it.value = getIntOption("Members").value }
        moshicomboBox.also { it!!.addItem("ModeI");it.addItem("ModeII");it.selectedItem = getSelectOption("Mode").value }
    }

    private fun lunxunS(e:ChangeEvent){
        lunxunValue!!.text = lunxunSlider!!.value.also { getLongOption("ModeII").setValue(it.toLong()) }.toString()
    }
    private fun renshuS(e:ChangeEvent){
        renshuValue!!.text = renshuSlider!!.value.also { getIntOption("Members").saveValue(it) }.toString()
    }
    private fun moshiS(e:ActionEvent){
        getSelectOption("Mode").setValue(moshicomboBox!!.selectedItem.toString())
    }
    private fun Reset(button:JButton){
        when(button){
            lunxunReset -> lunxunSlider!!.value = 60
            renshuReset -> renshuSlider!!.value = 1
            moshiReset -> moshicomboBox!!.selectedIndex = 0
        }
    }
}