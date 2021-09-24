package randomname

import randomname.DateUtil.Companion.whichClasses

class KeepThread(private val gui:GUIFor) : Thread() {
    override fun run() {
        try {
            while (true){
                gui.setClass(whichClasses())
                sleep(1000*5)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}