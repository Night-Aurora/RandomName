package ui.Companet

import java.awt.Insets
import javax.swing.JButton
import javax.swing.ImageIcon

class CustomButton : JButton {
    constructor(iconNormal: ImageIcon?) : super(iconNormal) {
        init()
    }
    constructor(iconNormal: ImageIcon?,iconEnabled: ImageIcon?) : super(iconNormal){
        selectedIcon = iconEnabled
        rolloverIcon = iconEnabled
        disabledIcon = iconNormal
        pressedIcon = iconEnabled
        init()
    }
    constructor(iconNormal: ImageIcon?,iconEnabled: ImageIcon?,iconPressed: ImageIcon?) : super(iconNormal){
        selectedIcon = iconEnabled
        rolloverIcon = iconEnabled
        disabledIcon = iconNormal
        pressedIcon = iconPressed
        init()
    }

    private fun init() {
        this.isBorderPainted = false
        this.isFocusPainted = false
        this.isContentAreaFilled = false
        this.isFocusable = true
        margin = Insets(0, 0, 0, 0)
    }
}