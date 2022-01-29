package ui.Utils

import java.security.SecureRandom
import kotlin.collections.ArrayList

object RandomStudent {
    private val same = ArrayList<Int>()
    private val secureRandom = SecureRandom()
    fun next(size:Int):String{
        return when (size) {
            1 -> doing()!!
            else -> {
                val builder = StringBuilder()
                while (builder.toString().split(" ").toTypedArray().size <= size){
                    builder.append(doing()).append(" ")
                }
                builder.toString()
            }
        }
    }
    private fun doing():String?{
        val randomNumber = secureRandom.nextInt(Config.students.size)
        return when{
            ifSame(randomNumber) -> doing()
            else -> Config.students[randomNumber.also { same.add(it) }]
        }
    }
    private fun ifSame(number:Int):Boolean{
        if (same.size > 55) same.clear()
        return same.contains(number)
    }
}