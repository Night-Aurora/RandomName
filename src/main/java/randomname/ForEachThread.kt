package randomname

import javax.swing.JTextPane

class ForEachThread : Thread() {
    var out:JTextPane? = null
    var forEaching = false
    override fun run() {
        while (true){
            if(forEaching) {
                RandomName.hash.forEach{
                    out!!.text = "               ${it.value}"
                    sleep(50)
                }
            }
        }
    }
}