import ui.Panel.*
import ui.UIConsts
import ui.Utils.Config
import ui.Utils.CoursePass
import ui.Utils.RandomStudent
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Component
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel

object RandomName {
    lateinit var frame:JFrame
    lateinit var actionPanel: ActionPanel
    lateinit var toolBarPanel: ToolBarPanel
    lateinit var dataPanel: DataPanel
    lateinit var infoPanel: SettingsPanel
    lateinit var settingPanel : ParamsPanel
    lateinit var mainPanel: JPanel
    lateinit var lastComponent : Component
    @JvmStatic
    fun main(args: Array<String>) {
        Config.load()
        Config.loadNames()
        RandomStudent.next(1)
        init()
        frame.isVisible = true
        frame.iconImage = UIConsts.ICON_APP
    }
    private fun init(){
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        frame = JFrame() //init Main Frame
        frame.setBounds(UIConsts.MAIN_WINDOW_X, UIConsts.MAIN_WINDOW_Y, UIConsts.MAIN_WINDOW_WIDTH, UIConsts.MAIN_WINDOW_HEIGHT)
        frame.title = "${UIConsts.NAME} ${UIConsts.VERSION}"
        //For Image
        frame.background = UIConsts.MAIN_BACK_COLOR
        mainPanel = JPanel(true)
        mainPanel.background = Color.white
        mainPanel.layout = BorderLayout()
        actionPanel = ActionPanel()
        toolBarPanel = ToolBarPanel()
        dataPanel = DataPanel()
        infoPanel = SettingsPanel()
        settingPanel = ParamsPanel()
        lastComponent = actionPanel
        mainPanel.add(actionPanel,BorderLayout.CENTER)
        mainPanel.add(toolBarPanel,BorderLayout.WEST)
        frame.add(mainPanel)
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        Thread(object :Thread(){
            override fun run() {
                while (Config.curriculum_File.length() > 0) {
                    frame.title = "${UIConsts.NAME} ${UIConsts.VERSION} ¿Î³Ì£º${CoursePass.whichClass() ?: "ÎÞ"}"
                    sleep(100)
                }
            }
        }).start()
    }
    fun frameChange(component: Component){
        mainPanel.remove(lastComponent)
        mainPanel.add(component.also { lastComponent = it },BorderLayout.CENTER)
        mainPanel.updateUI()
    }
}