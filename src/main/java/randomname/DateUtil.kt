package randomname

//import org.apache.poi.ss.usermodel.Sheet
import randomname.CourseUtil.Companion.NumberOfLines
import randomname.CourseUtil.Companion.readForm
import java.text.SimpleDateFormat
import java.util.*


class DateUtil {
    companion object{
        private val now = Calendar.getInstance()
        private val isFirstSunday = now.firstDayOfWeek == Calendar.SUNDAY
        private var df: SimpleDateFormat = SimpleDateFormat("HH:mm")
        private var date = Date()
        //lateinit var sheet:Sheet
        fun weekDay():Int{
            var weekDay = now[Calendar.DAY_OF_WEEK]
            if(isFirstSunday){
                weekDay -= 1
                if(weekDay == 0){
                    weekDay = 7
                }
            }
            return weekDay
        }
        fun nowTime():String{
            date = Date()
            return df.format(date)
        }
        fun inTimeRange(begin:String,end:String):Boolean{
            val now = df.parse(nowTime())
            val begin1 = df.parse(begin)
            val end1 = df.parse(end)
            return (now.after(begin1) || now == begin1) && (now.before(end1) || now == end1)
        }
        /*
        fun whichClasses():String{
            val weekday = weekDay()
            val colnum = sheet.physicalNumberOfRows//行总数
            try {
            for (i in 1 until colnum){
                val row1 = sheet.getRow(i)!!//行
                val timeData = row1.getCell(0).stringCellValue.split("~")//列
                if(inTimeRange(timeData[0],timeData[1])){
                    val row2 = sheet.getRow(i)!!//classes
                    return row2.getCell(weekday).stringCellValue//classes type
                 }
               }
            }catch (e:NullPointerException){
                e.printStackTrace()
            }
            return "rest"
        }

         */
        fun whichClasses():String{
            val weekday = weekDay()
            val colnum = NumberOfLines//行总数
            try {
                for (i in 1..colnum){
                    val row1 = readForm(i,1)!!
                    if(row1 == "Space") continue
                    val timeData = row1.split("~")//列
                    if(inTimeRange(timeData[0],timeData[1])){
                        return readForm(i, weekday +1)!!
                    }
                }
            }catch (e:NullPointerException){
                e.printStackTrace()
            }
            return "rest"
        }
    }
}