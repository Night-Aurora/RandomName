/*
 * Created by JFormDesigner on Wed Jan 19 23:58:39 CST 2022
 */
package ui.Panel

import com.google.common.collect.Table
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import javax.swing.*
import javax.swing.table.DefaultTableCellRenderer
import javax.swing.table.DefaultTableModel

/**
 * @author Night_Aurora
 */
class DataPanel : JPanel() {
    private fun initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = JPanel()
        PlaceHold1 = JLabel()
        PlaceHold2 = JLabel()
        PlaceHold4 = JLabel()
        PlaceHold3 = JLabel()
        SubPanel = JTabbedPane()
        Curriculum = JScrollPane()
        Table = JTable()

        //======== panel ========

        //======== panel ========
            panel!!.preferredSize = Dimension(600, 400)
            panel!!.background = Color.white
            panel!!.layout = BorderLayout()

            //---- PlaceHold1 ----
            PlaceHold1!!.maximumSize = Dimension(24, 50)
            PlaceHold1!!.preferredSize = Dimension(24, 20)
            panel!!.add(PlaceHold1, BorderLayout.NORTH)

            //---- PlaceHold2 ----
            PlaceHold2!!.maximumSize = Dimension(24, 50)
            PlaceHold2!!.preferredSize = Dimension(24, 20)
            panel!!.add(PlaceHold2, BorderLayout.SOUTH)

            //---- PlaceHold4 ----
            PlaceHold4!!.setMaximumSize(Dimension(50, 16))
            PlaceHold4!!.setPreferredSize(Dimension(20, 16))
            panel!!.add(PlaceHold4, BorderLayout.WEST)

            //---- PlaceHold3 ----
            PlaceHold3!!.maximumSize = Dimension(50, 16)
            PlaceHold3!!.preferredSize = Dimension(20, 16)
            panel!!.add(PlaceHold3, BorderLayout.EAST)

            //======== SubPanel ========

                //======== Curriculum ========

                    //---- Table ----
            Table!!.font = Table!!.font.deriveFont(Table!!.font.size + 4f)
            Table!!.preferredSize = Dimension(552,300)
            Table!!.rowHeight = 30
            Curriculum!!.setViewportView(Table)
            SubPanel!!.addTab("\u8bfe\u7a0b\u8868", Curriculum)
            panel!!.add(SubPanel, BorderLayout.CENTER)
        add(panel)
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private var panel: JPanel? = null
    private var PlaceHold1: JLabel? = null
    private var PlaceHold2: JLabel? = null
    private var PlaceHold4: JLabel? = null
    private var PlaceHold3: JLabel? = null
    private var SubPanel: JTabbedPane? = null
    private var Curriculum: JScrollPane? = null
    private var Table: JTable? = null

    init {
        initComponents()
        val columnWorkDays = arrayOf("","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
        val rows = Array(10) { arrayOfNulls<Int>(8) }
        val tableMode = DefaultTableModel(rows,columnWorkDays)
        //
        Table!!.model = tableMode
        Table!!.setDefaultRenderer(Any::class.java, DefaultTableCellRenderer().also { it.horizontalAlignment = JLabel.CENTER })
    }
}