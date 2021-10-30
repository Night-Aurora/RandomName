package randomname

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class CourseUtil {
    companion object{
        lateinit var courseFile:File
        private var courseList = ArrayList<Array<String>>()
        val NumberOfLines get() = courseList.size
        fun loadCurriculum(file: File){
            courseFile = file
            courseList = ArrayList()
            courseList.clear()
            BufferedReader(FileReader(courseFile)).forEachLine {
                courseList.add(it.split("\\s+".toRegex()).toTypedArray())
            }
        }
        @Throws(Exception::class)
        fun readForm(x:Int,y:Int):String?{
            return when{
                y != 0 && x != 0 -> courseList[y - 1][x-1]
                else -> null
            }
        }
    }
}