package randomname

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class CourseUtil {
    companion object{
        private lateinit var courseFile:File
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
                x != 0 && y != 0 -> courseList[x - 1][y-1]
                else -> null
            }
        }
    }
}