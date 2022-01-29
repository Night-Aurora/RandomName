package ui

import ui.Companet.CustomIcon
import java.awt.Color
import java.awt.Image

object UIConsts {
    const val MAIN_WINDOW_X = 600
    const val MAIN_WINDOW_Y = 300
    const val MAIN_WINDOW_WIDTH = 650
    const val MAIN_WINDOW_HEIGHT = 450
    const val NAME = "RandomName"
    const val VERSION = "5.0"
    val MAIN_BACK_COLOR = Color(255,255,255,255)
    val TOOL_BAR_COLOR = Color(0,122,174)

    val HOME = CustomIcon("Home",enabled = true)
    val DATA = CustomIcon("Data",enabled = true)
    val PARAMS = CustomIcon("Params",enabled = true)
    val SETTINGS = CustomIcon("Settings",enabled = true)
    val SINGLE = CustomIcon("Single",enabled = true)
    val MULTI = CustomIcon("Multi",enabled = true)
    val MODE_I = CustomIcon("ModeI",enabled = true)
    val MODE_II = CustomIcon("ModeII",enabled = true)
    val PRESS = CustomIcon("Press",enabled = true,pressed = true)
    val ICON_APP: Image = CustomIcon("Random",icon = true).icon
}