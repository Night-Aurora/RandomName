package ui.Companet

import java.awt.Image
import javax.swing.ImageIcon

class CustomIcon(path:String,enabled:Boolean = false,pressed:Boolean = false,rollover:Boolean = false,icon:Boolean = false) {
    var normal:ImageIcon
    lateinit var enabled:ImageIcon
    lateinit var pressed:ImageIcon
    lateinit var rollover:ImageIcon
    lateinit var icon: Image
    init {
        this.normal = icon(path)!!
        if(enabled) this.enabled = icon("${path}E") ?: normal
        if(pressed) this.pressed = icon("${path}P") ?: this.enabled
        if(rollover ) this.rollover = icon("${path}R") ?: this.enabled
        if(icon) this.icon = this.normal.image
    }
    private fun icon(name:String): ImageIcon? {
        val url = RandomName.javaClass.getResource("icon/$name.png")
        return if(url == null) null else ImageIcon(url)
    }
}