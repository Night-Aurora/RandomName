package ui.Utils

import javax.swing.JButton

class ButtonPress() {
    constructor(vararg button: JButton) : this() {
        button.forEach(buttons::add)
    }
    val buttons = ArrayList<JButton>()
    fun whenButtonSelected(button: JButton) {
        button.isSelected = true
        buttons.filter { it !== button }.forEach {
            it.isSelected = false
            it.icon = it.disabledIcon
        }
    }
}