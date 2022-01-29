/*
 * Created by JFormDesigner on Sat Jan 08 23:52:29 CST 2022
 */
@file:Suppress("FunctionName")

package ui.Panel

import ui.Companet.CustomButton
import ui.UIConsts.MODE_I
import ui.UIConsts.MODE_II
import ui.UIConsts.MULTI
import ui.UIConsts.PRESS
import ui.UIConsts.SINGLE
import ui.Utils.ButtonPress
import ui.Utils.Option.IntOption
import ui.Utils.Option.LongOption
import ui.Utils.Option.SelectOption
import ui.Utils.RandomStudent
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.*
import javax.swing.event.ChangeEvent

/**
 * @author Night_Aurora
 */
class ActionPanel : JPanel() {
    private var ModeIIBoolean = false
    private val ModeII_Delay = LongOption("ModeII",80)
    private val Members = IntOption("Members",1)
    private val Mode = SelectOption("Mode","ModeI")
    private fun Single(e: ActionEvent? = null) {
        SliderBox.isVisible = false
        NumberGroup.whenButtonSelected(Single)
    }

    private fun Multi(e: ActionEvent) {
        SliderBox.isVisible = true
        number.text = slider.value.also { Members.setValue(it) }.toString()
        NumberGroup.whenButtonSelected(Multi)
    }

    private fun ModeI(e: ActionEvent) {
        ModeGroup.whenButtonSelected(ModeI)
        if(ModeIIBoolean){
            child!!.stop()
            child = null
            ModeIIBoolean = false
            Press.icon = Press.disabledIcon
        }
    }
    private fun ModeII(e: ActionEvent) {
        ModeGroup.whenButtonSelected(ModeII)
    }
    private fun sliderState(e: ChangeEvent) {
        number.text = slider.value.also { Members.setValue(it,false) }.toString()
    }

    var child:Thread? = null

    private fun Press(e: ActionEvent) {
        when{
            ModeI.isSelected -> Out.text = RandomStudent.next(if (Single.isSelected) 1 else Members.value)
            else ->{
                ModeIIBoolean = !ModeIIBoolean
                if(child == null)
                    child = Thread(object : Thread() {
                        override fun run() {
                            while (true) {
                                Out.text = RandomStudent.next(if (Single.isSelected) 1 else Members.value)
                                sleep(ModeII_Delay.value)
                            }
                        }
                    })
                when{
                    ModeIIBoolean -> {
                        child!!.start()
                        Press.icon = Press.pressedIcon
                    }
                    else -> {
                        try {
                            child!!.stop()
                            child = null
                            Press.icon = Press.disabledIcon
                        } catch (ignore:Exception) {}
                    }
                }
            }
        }

    }
    private fun initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        val bundle = ResourceBundle.getBundle("language")
        PlaceHold1 = JLabel()
        PlaceHold2 = JLabel()
        PlaceHold3 = JLabel()
        PlaceHold4 = JLabel()
        Select = JPanel()
        ALL = JPanel()
        SliderBox = JPanel()
        slider = JSlider()
        number = JLabel()
        SelectAll = JPanel()
        SelectNumber = JPanel()
        Single = CustomButton(SINGLE.normal, SINGLE.enabled)
        Multi = CustomButton(MULTI.normal, MULTI.enabled)
        SelectMode = JPanel()
        ModeI = CustomButton(MODE_I.normal, MODE_I.enabled)
        ModeII = CustomButton(MODE_II.normal, MODE_II.enabled)
        PlaceHold5 = JLabel()
        PlaceHold6 = JLabel()
        Out = JTextField()
        Middle = JPanel()
        PlaceHold7 = JLabel()
        Press = CustomButton(PRESS.normal, PRESS.enabled, PRESS.pressed)
        PlaceHold8 = JLabel()

        //======== this ========
        foreground = Color.white
        background = Color.white
        layout = BorderLayout()

        //---- PlaceHold1 ----
        PlaceHold1.maximumSize = Dimension(24, 50)
        PlaceHold1.preferredSize = Dimension(24, 50)
        add(PlaceHold1, BorderLayout.NORTH)

        //---- PlaceHold2 ----
        PlaceHold2.preferredSize = Dimension(24, 50)
        PlaceHold2.maximumSize = Dimension(24, 50)
        add(PlaceHold2, BorderLayout.SOUTH)

        //---- PlaceHold3 ----
        PlaceHold3.maximumSize = Dimension(50, 16)
        PlaceHold3.preferredSize = Dimension(50, 16)
        add(PlaceHold3, BorderLayout.WEST)

        //---- PlaceHold4 ----
        PlaceHold4.preferredSize = Dimension(50, 16)
        PlaceHold4.maximumSize = Dimension(50, 16)
        add(PlaceHold4, BorderLayout.EAST)

        //======== Select ========
            Select.setLayout(BorderLayout())

            //======== ALL ========
                ALL.setLayout(BoxLayout(ALL, BoxLayout.Y_AXIS))

                //======== SliderBox ========
                    SliderBox.layout = BoxLayout(SliderBox, BoxLayout.X_AXIS)

                    //---- slider ----
                    slider.preferredSize = Dimension(200, 25)
                    slider.maximumSize = Dimension(32767, 25)
                    slider.font = slider.font.deriveFont(Font.ITALIC)
                    slider.addChangeListener { e: ChangeEvent -> sliderState(e) }
                    SliderBox.add(slider)

                    //---- number ----
                    number.text = bundle.getString("number.text")
                    number.maximumSize = Dimension(40, 25)
                    number.preferredSize = Dimension(40, 25)
                    number.horizontalAlignment = SwingConstants.CENTER
                    number.horizontalTextPosition = SwingConstants.CENTER
                    number.font = Font("Sitka Small", Font.PLAIN, 18)
                    number.foreground = Color(158, 117, 250)
                    SliderBox.add(number)
                ALL.add(SliderBox)

                //======== SelectAll ========
                    SelectAll.setLayout(BoxLayout(SelectAll, BoxLayout.X_AXIS))

                    //======== SelectNumber ========
                        SelectNumber.layout = BoxLayout(SelectNumber, BoxLayout.X_AXIS)

                        //---- Single ----
                        Single.text = bundle.getString("Single.text")
                        Single.maximumSize = Dimension(110, 40)
                        Single.preferredSize = Dimension(110, 40)
                        Single.addActionListener { e: ActionEvent -> Single(e) }
                        SelectNumber.add(Single)

                        //---- Multi ----
                        Multi.text = bundle.getString("Multi.text")
                        Multi.maximumSize = Dimension(110, 40)
                        Multi.preferredSize = Dimension(110, 40)
                        Multi.addActionListener { e: ActionEvent -> Multi(e) }
                        SelectNumber.add(Multi)
                    SelectAll.add(SelectNumber)

                    //======== SelectMode ========
                        SelectMode.layout = BoxLayout(SelectMode, BoxLayout.X_AXIS)

                        //---- ModeI ----
                        ModeI.text = bundle.getString("ModeI.text")
                        ModeI.maximumSize = Dimension(110, 40)
                        ModeI.preferredSize = Dimension(110, 40)
                        ModeI.addActionListener { e: ActionEvent -> ModeI(e) }
                        SelectMode.add(ModeI)

                        //---- ModeII ----
                        ModeII.text = bundle.getString("ModeII.text")
                        ModeII.maximumSize = Dimension(110, 40)
                        ModeII.preferredSize = Dimension(110, 40)
                        ModeII.addActionListener { e: ActionEvent -> ModeII(e) }
                        SelectMode.add(ModeII)
                    SelectAll.add(SelectMode)
                ALL.add(SelectAll)
            Select.add(ALL, BorderLayout.NORTH)

            //---- PlaceHold5 ----
            PlaceHold5.maximumSize = Dimension(100, 16)
            PlaceHold5.preferredSize = Dimension(100, 16)
            Select.add(PlaceHold5, BorderLayout.WEST)

            //---- PlaceHold6 ----
            PlaceHold6.maximumSize = Dimension(100, 16)
            PlaceHold6.preferredSize = Dimension(100, 16)
            Select.add(PlaceHold6, BorderLayout.EAST)

            //---- Out ----
            Out.minimumSize = Dimension(49, 80)
            Out.preferredSize = Dimension(49, 80)
            Out.font = Out.font.deriveFont(Out.font.size + 12f)
            Out.horizontalAlignment = SwingConstants.CENTER
            Select.add(Out, BorderLayout.SOUTH)

            //======== Middle ========
                Middle.maximumSize = Dimension(435, 50)
                Middle.preferredSize = Dimension(435, 50)
                Middle.layout = BoxLayout(Middle, BoxLayout.Y_AXIS)

                //---- PlaceHold7 ----
                PlaceHold7.maximumSize = Dimension(435, 50)
                PlaceHold7.preferredSize = Dimension(24, 50)
                Middle.add(PlaceHold7)

                //---- Press ----
                Press.preferredSize = Dimension(45, 60)
                Press.maximumSize = Dimension(435, 60)
                Press.addActionListener { e: ActionEvent -> Press(e) }
                Middle.add(Press)

                //---- PlaceHold8 ----
                PlaceHold8.maximumSize = Dimension(435, 50)
                PlaceHold8.preferredSize = Dimension(24, 50)
                Middle.add(PlaceHold8)
            Select.add(Middle, BorderLayout.CENTER)
        add(Select, BorderLayout.CENTER)
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        lateinit var PlaceHold1: JLabel
        lateinit var PlaceHold2: JLabel
        lateinit var PlaceHold3: JLabel
        lateinit var PlaceHold4: JLabel
        lateinit var Select: JPanel
        lateinit var ALL: JPanel
        lateinit var SliderBox: JPanel
        lateinit var slider: JSlider
        lateinit var number: JLabel
        lateinit var SelectAll: JPanel
        lateinit var SelectNumber: JPanel
        lateinit var Single: JButton
        lateinit var Multi: JButton
        lateinit var SelectMode: JPanel
        lateinit var ModeI: JButton
        lateinit var ModeII: JButton
        lateinit var PlaceHold5: JLabel
        lateinit var PlaceHold6: JLabel
        lateinit var Out: JTextField
        lateinit var Middle: JPanel
        lateinit var PlaceHold7: JLabel
        lateinit var Press: JButton
        lateinit var PlaceHold8: JLabel // JFormDesigner - End of variables declaration  //GEN-END:variables
        lateinit var ModeGroup : ButtonPress
        lateinit var NumberGroup : ButtonPress

    init {
        initComponents()
        ModeGroup = ButtonPress(ModeI,ModeII)
        NumberGroup = ButtonPress(Single,Multi)
        ModeGroup.whenButtonSelected(if(Mode.value == "ModeI") ModeI else ModeII)
        NumberGroup.whenButtonSelected(if(Members.value == 1) Single.also { Single() } else Multi)
        slider.value = Members.value
        slider.minimum = 2
        slider.maximum = 6
    }
}