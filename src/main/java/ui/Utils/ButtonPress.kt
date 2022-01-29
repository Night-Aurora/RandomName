package ui.Utils

import javax.swing.JButton

class ButtonPress() {
    constructor(vararg button: JButton) : this() {
        button.forEach { buttons.add(it) }
    }
    val buttons = ArrayList<JButton>()
    fun whenButtonSelected(button: JButton) {
        button.isSelected = true
        buttons.stream().filter { it !== button }.forEach {
            it!!.isSelected = false
            it.icon = it.disabledIcon
        }
    }
}