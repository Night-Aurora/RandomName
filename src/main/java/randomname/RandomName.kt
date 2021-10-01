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
import kotlin.random.Random

class RandomName {
    companion object{
        var file: File? = null
        var path = "RandomName/"
        var filepath = "${path}xlx.txt"
        var wb: Workbook? = null
        var sheet: Sheet? = null
        val filePath = "${path}课程表.xlsx"
        val disablecheatPath = "${path}null.txt"
        var hash = HashMap<Int,String>()
        var startT = 0L
        var t1 = 0L
        var rc = ArrayList<Int>()
        val whitelist = arrayOf(25,53,61,62,48)
        var cheat = true
        @JvmStatic
        fun main(args:Array<String>){
            println("Powered By Night_Aurora")
            println("Github-Source Code: https://github.com/Night-Aurora/RandomName")
            val p = File(path)
            if(!p.exists())
                p.mkdirs()
            file = loadFile(filepath)!!
            hash = loadNames(file!!)
            if(isFileExists(disablecheatPath))
                cheat = false
            wb = XSSFWorkbook(FileInputStream(filePath))
            sheet = wb!!.getSheetAt(0)
            DateUtil.sheet = sheet!!
            println(whichClasses())
            val gui = Gui()
            gui.isVisible = true
            KeepThread(gui).start()
        }

        fun test(){
            val h = HashMap<Int,Int>()
            var i = 0
            val time = 660
            while(i < time){
                i++
                val s = randomSingleNumber(hash.size)
                h[s] = h.getOrDefault(s,0)+1
            }
            h.forEach{
                if(it.value > 2){
                    println("${hash[it.key]}:${it.value}")
                }
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
            if((r == 41 && rc.size < 48 && whichClasses() == "语文") || (rc.size < 50 && whichClasses() == "语文" && cheat && whitelist.contains(r)))
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
            if((currentTimeMillis() - t1) >= 1*1000){
                t1 = currentTimeMillis()
                println(s)
            }

            return s
        }
    }
}