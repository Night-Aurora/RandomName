package ui.Utils

import ui.Utils.Config.config
import ui.Utils.Config.load
import java.lang.System.currentTimeMillis

object Option {
    private val options:MutableList<Option<*>> = mutableListOf()

    fun getIntOption(optionName:String):Option<Int>{
        return options.filter { it.option.equals(optionName,ignoreCase = true) }.map { it as Option<Int> }[0]
    }
    fun getLongOption(optionName:String):Option<Long>{
        return options.filter { it.option.equals(optionName,ignoreCase = true) }.map { it as Option<Long> }[0]
    }
    fun getSelectOption(optionName:String):Option<String>{
        return options.filter { it.option.equals(optionName,ignoreCase = true) }.map { it as Option<String> }[0]
    }
    class Option<T>(val option:String,default:T){
        private val s = currentTimeMillis()
        private var internalvalue:T? = null
        val config = Config.config
        val value:T get() = internalvalue!!
        init {
            config.get(option)?.also { internalvalue = it as T }?:config.set(option,default.also { internalvalue = it })
            load()
        }
        fun setValue(value:T,save:Boolean = true){
            if((currentTimeMillis() - s)/1000 < 2) return
            internalvalue = value
            if(save) saveValue()
        }
        fun saveValue(value: T = internalvalue!!){
            config.set(option, value)
            load()
        }
    }
    fun IntOption(option:String,default:Int):Option<Int>{
        return Option(option, default).also { options.add(it) }
    }
    fun LongOption(option:String,default:Long):Option<Long>{
        return Option(option, default).also { options.add(it) }
    }
    fun SelectOption(option:String,default: String):Option<String>{
        return Option(option, default).also { options.add(it) }
    }
}