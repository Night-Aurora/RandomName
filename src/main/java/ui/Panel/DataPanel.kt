/*
 * Created by JFormDesigner on Wed Jan 19 23:58:39 CST 2022
 */
package ui.Panel

import ui.Utils.Config
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.beans.PropertyChangeEvent
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*
import javax.swing.*
import javax.swing.table.DefaultTableCellRenderer
import javax.swing.table.DefaultTableModel

/**
 * @author Night_Aurora
 */
class DataPanel : JPanel() {
    private fun initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        val bundle = ResourceBundle.getBundle("language")
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = JPanel()
        PlaceHold1 = JLabel()
        PlaceHold2 = JLabel()
        PlaceHold4 = JLabel()
        PlaceHold3 = JLabel()
        SubPanel = JTabbedPane()
        Curriculum = JScrollPane()
        Students = JScrollPane()
        Table = JTable()
        List = JList()
        StudentList = DefaultListModel()
        StuRLMenu = JPopupMenu()
        Delete = JMenuItem()
        Add = JMenuItem()
        Import = JMenuItem()

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
            Table!!.addPropertyChangeListener(this::Table)
            Curriculum!!.setViewportView(Table)
            SubPanel!!.addTab("\u8bfe\u7a0b\u8868", Curriculum)

        //======== StuRLMenu ========

        class StuL : MouseAdapter(){
            override fun mouseClicked(e: MouseEvent) {
                takeIf { e.button == 3 }?:return//检查右键点击并且选中菜单不为空
                Delete!!.isVisible = List!!.selectedValuesList.size > 0
                StuRLMenu!!.show(List!!,e.x,e.y)
            }
        }
        //---- Delete ----
        Delete!!.text = bundle.getString("Delete.text")
        Delete!!.addActionListener {
            List!!.selectedValuesList.takeIf { List!!.selectedValuesList.size>0 }
                ?.takeIf { JOptionPane.showConfirmDialog(this, "确认更改？","",0) == 0 }
                ?.map { it as String }?.let {
                it.forEach(StudentList!!::removeElement)
                it.forEach{ st ->
                    val iterator = Config.students.iterator()
                    while (iterator.hasNext()){
                        if(iterator.next() == st) {
                            iterator.remove()
                        }
                    }
                }
                Config.student.set("students",Config.students.toMutableList())
                Config.load(Config.student)
            }//(it -> String)-> remove
            editStudentList()//resetListModel
        }
        //---- Add ----
        Add!!.text = bundle.getString("Add.text")
        Add!!.addActionListener {
            var input = JOptionPane.showInputDialog("键入名称").takeUnless { it.isNullOrEmpty() }?:return@addActionListener//输入为空返回
            input = input.replace("[^\u4e00-\u9fa5]".toRegex(),"")//过滤出汉字
            input.takeIf { it.isEmpty() || it.length > 4 }?.apply { JOptionPane.showMessageDialog(this@DataPanel,"非法字符","",JOptionPane.ERROR_MESSAGE) }?: run {
                input.takeUnless { StudentList!!.contains(it) }?.run {//检查名字重复
                    StudentList!!.addElement(this)
                    Config.students.add(this)
                    editStudentList()
                    Config.student.set("students",Config.students.toMutableList())
                    Config.load(Config.student)
                }
            }
        }
        //---- Import ----
        Import!!.text = bundle.getString("Import.text")
        Import!!.addActionListener {
            takeUnless {  JOptionPane.showConfirmDialog(this,"从外部文件导入学生名单\n请检查当前目录存在被导入文件\n确认开始导入","确认导入",0) == 0 }?:importStudentList()
        }
        StuRLMenu!!.add(Add)
        StuRLMenu!!.add(Delete)
        StuRLMenu!!.add(Import)
        List!!.add(StuRLMenu)
        List!!.font = List!!.font.deriveFont(List!!.font.size + 4f)
        List!!.addMouseListener(StuL())
            //======== Students ========
            Students!!.setViewportView(List)
            SubPanel!!.addTab("\u5b66\u751f\u5217\u8868", Students)
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
    private var Students: JScrollPane? = null
    private var List: JList<Any>? = null
    private var StudentList: DefaultListModel<Any>? = null
    private var StuRLMenu: JPopupMenu? = null
    private var Delete: JMenuItem? = null
    private var Add: JMenuItem? = null
    private var Import : JMenuItem? = null

    init {
        initComponents()
        val columnWorkDays = arrayOf("","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
        val rows = Array(10) { arrayOfNulls<Int>(8) }
        val tableMode = DefaultTableModel(rows,columnWorkDays)
        //
        Table!!.model = tableMode
        Table!!.setDefaultRenderer(Any::class.java, DefaultTableCellRenderer().also { it.horizontalAlignment = JLabel.CENTER })
        writeTableForm()
        Config.students.forEach { StudentList!!.addElement(it) }
        editStudentList()
    }
    private fun readTableForm(){
        repeat(Table!!.rowCount){ row ->
            repeat(Table!!.columnCount){ colunm ->
                Table!!.getValueAt(row,colunm)?.takeIf { it.toString().isNotEmpty() }
                    ?.let { Config.curriculum.set("${row}.${colunm}",it.toString()) }
                    ?:run { Config.curriculum.set("${row}.${colunm}",null) }
            }
        }
        Config.load(Config.curriculum)
    }
    private fun writeTableForm() =
        repeat(Table!!.rowCount){ row ->
            repeat(Table!!.columnCount){ colunm ->
                Config.curriculum.getString("${row}.${colunm}")?.takeIf { it.isNotEmpty() }?.let {
                    Table!!.setValueAt(it,row,colunm)
                }
            }
        }
    private fun editStudentList(){
        List!!.model = StudentList
    }
    private fun importStudentList(){
        val f = File("students.txt")
        takeIf { f.exists() }?:run { JOptionPane.showMessageDialog(this,"文件不存在!"); return }
        takeIf { f.length() > 0L }?:run { JOptionPane.showMessageDialog(this,"文件为空!"); return }
        val loadedList = FileReader(f).readLines()
        StudentList!!.removeAllElements()
        loadedList.forEach(StudentList!!::addElement)
        editStudentList()
        Config.student.set("students",loadedList)
        Config.load(Config.student)
        JOptionPane.showMessageDialog(this,"导入成功!")
    }
    private fun Table(e: PropertyChangeEvent) = takeIf { Table!!.selectedColumn != -1 && Table!!.selectedRow != -1 }?.run { readTableForm() }
}