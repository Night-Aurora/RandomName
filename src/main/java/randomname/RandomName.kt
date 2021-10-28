package randomname

//import org.apache.poi.ss.usermodel.Sheet
//import org.apache.poi.ss.usermodel.Workbook
//import org.apache.poi.xssf.usermodel.XSSFWorkbook
import randomname.CourseUtil.Companion.loadCurriculum
import randomname.DateUtil.Companion.whichClasses
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.System.currentTimeMillis
import javax.swing.JOptionPane
import kotlin.random.Random

class RandomName {
    companion object{
        var file: File? = null
        var path = "RandomName/"
        var filepath = "${path}students.txt"
        //var wb: Workbook? = null
        //var sheet: Sheet? = null
        val curriculum = "${path}Curriculum.txt"
        val disablecheatPath = "${path}null.txt"
        var hash = HashMap<Int,String>()
        var startT = 0L
        var rc = ArrayList<Int>()
        val whitelist = arrayOf(25,53,61,62,48)
        var cheat = true
        @JvmStatic
        fun main(args:Array<String>){
            try {
                println("Powered By Night_Aurora")
                println("Github-Source Code: https://github.com/Night-Aurora/RandomName")
                val p = File(path)
                if(!p.exists())
                    p.mkdirs()
                file = loadFile(filepath)!!
                hash = loadNames(file!!)
                if(isFileExists(disablecheatPath))
                    cheat = false
                loadCurriculum(loadFile(curriculum)!!)
                /*
                wb = XSSFWorkbook(FileInputStream(curriculum))
                sheet = wb!!.getSheetAt(0)
                DateUtil.sheet = sheet!!

                 */
                println(whichClasses())
                val gui = Gui()
                gui.isVisible = true
                KeepThread(gui).start()
            }catch (e:NullPointerException){
                JOptionPane.showMessageDialog(null, "The Directory is empty! \nRequire students.txt & Curriculum.txt", "Error Report!", JOptionPane.ERROR_MESSAGE, null)
                e.printStackTrace()
            }catch (e:Exception){
                e.printStackTrace()
            }

        }


        fun isFileExists(path:String):Boolean{
            return File(path).exists()
        }

        fun loadFile(path:String):File?{
            try {
                val f = File(path)
                if(!f.exists())
                    throw NullPointerException()
                return f
            }catch (e:NullPointerException){
                e.printStackTrace()
            }
            return null
        }

        fun loadNames(file:File):HashMap<Int,String>{
            val read = BufferedReader(FileReader(file))
            val hash = HashMap<Int,String>()
            var number = 0
            read.readLines().forEach {
                number++
                val a = it.substring(5)
                hash[number] = a
            }
            return hash
        }

        fun randomSingleNumber(size:Int):Int{
            val r = Random.nextInt(1,size+1)
            if((r == 41 && rc.size < 48 && whichClasses() == "ÓïÎÄ") || (rc.size < 50 && whichClasses() == "ÓïÎÄ" && cheat && whitelist.contains(r)))
                return randomSingleNumber(size)
            if(rc.size>=65){
                rc.clear()
                startT = currentTimeMillis()
                println("rc reset! because rcList is full")
            }
            return r
        }
        fun randomMuitNumber(size: Int,count:Int):ArrayList<Int>{
            val r = ArrayList<Int>()
            while (r.size<count){
                val d = randomSingleNumber(size)
                if(!r.contains(d) && !chec3min(d))
                    r.add(d)
            }
            return r
        }
        fun chec3min(d:Int):Boolean{
            if(rc.contains(d))
                return true
            else rc.add(d)
            return false
        }
        fun randomname(l:Int):String{
            if((currentTimeMillis() - startT) >= 700*1000){
                rc.clear()
                startT = currentTimeMillis()
                println("rc reset!")
            }
            var s = ""
            if(l == 1){
                while (s == ""){
                    val a = randomSingleNumber(hash.size)
                    if(!chec3min(a))
                        s = hash[a]!!
                }
            }else{
                randomMuitNumber(hash.size,l).forEach {
                    s += hash[it] + ","
                }
                s = s.substring(0,s.lastIndexOf(","))
            }
                println(s)
            return s
        }
    }
}