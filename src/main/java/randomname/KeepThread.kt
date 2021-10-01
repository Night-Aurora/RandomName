package randomname

import randomname.DateUtil.Companion.whichClasses

class KeepThread(private val gui:Gui) : Thread() {
    override fun run() {
        try {
            while (true){
                gui.setClasses(whichClasses())
                sleep(1000*5)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}