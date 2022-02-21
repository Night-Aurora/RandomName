package ui.Utils

import java.lang.System.currentTimeMillis
import java.text.SimpleDateFormat
import java.util.*

object CoursePass {
    private val calendar = Calendar.getInstance()
    private val df = SimpleDateFormat("HH:mm")
    val weekDay = calendar[Calendar.DAY_OF_WEEK].takeIf { calendar.firstDayOfWeek == Calendar.SUNDAY }?.minus(1)?.takeIf { it != 0 }?:7
    private fun inTimeRange(before:String,after:String):Boolean{
        val n = df.parse(df.format(currentTimeMillis()))
        val b = df.parse(before)
        val a = df.parse(after)
        return (n.after(b) || n == b) && (n.before(a) || n == a)
    }
    fun whichClass():String?{
        var Class:String? = null
        repeat(9){ row ->
            Config.curriculum.getString("${row}.0")?.takeIf { it.contains("~") }?.run {
                val z = this.split("~").toTypedArray().takeIf { it.size == 2 }
                val before = z?.get(0)
                val after = z?.get(1)
                takeIf { before != null && after != null }?.takeIf { inTimeRange(before!!,after!!) }?.apply {
                    Class = Config.curriculum.getString("${row}.${weekDay}")
                }
            }
        }
        return Class
    }
}