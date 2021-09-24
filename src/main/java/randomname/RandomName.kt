package randomname

import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import randomname.DateUtil.Companion.whichClasses
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.lang.System.currentTimeMillis
import java.util.*

class RandomName {
    companion object{
        var file: File? = null
        var path = "RandomName/"
        var filepath = "${path}xlx.txt"
        var wb: Workbook? = null
        var sheet: Sheet? = null
        val filePath = "${path}¿Î³Ì±í.xlsx"
        var random = Random()
        var hash = HashMap<Int,String>()
        var startT = 0L
        var rc = ArrayList<Int>()
        @JvmStatic
        fun main(args:Array<String>){
            val p = File(path)
            if(!p.exists())
                p.mkdirs()
            file = loadFile(filepath)!!
            hash = loadNames(file!!)
            wb = XSSFWorkbook(FileInputStream(filePath))
            sheet = wb!!.getSheetAt(0)
            DateUtil.sheet = sheet!!
            println(whichClasses())
            val gui = GUIFor()
            gui.isVisible = true
            KeepThread(gui).start()
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
            val r = random.nextInt(size+1)
            if(r == 0 || (r == 41 && whichClasses() == "ÓïÎÄ"))
                return randomSingleNumber(size-1)
            if(rc.size==65){
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
            if(rc.contains(d)) return true
            else rc.add(d)
            return false
        }
        fun randomname(l:Int):String{
            if((currentTimeMillis() - startT) >= 180*1000){
                rc.clear()
                startT = currentTimeMillis()
                println("rc reset!")
            }
            var s = ""
            if(l == 1){
                while (s == ""){
                    val a = randomSingleNumber(hash.size)
                    if(!chec3min(a))
                        s = hash[randomSingleNumber(hash.size)]!!
                }
            }else{
                randomMuitNumber(hash.size,l).forEach {
                    s += hash[it] + ","
                }
            }
            println(s)
            return s
        }
    }
}