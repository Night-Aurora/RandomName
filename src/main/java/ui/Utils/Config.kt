package ui.Utils

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import ui.UIConsts
import java.io.File

object Config {

    private val filePath = "${UIConsts.NAME}/config.yml"
    private val studentPath = "${UIConsts.NAME}/students.yml"
    private val config_File = File(filePath)
    private val student_File = File(studentPath)
    val config:FileConfiguration = YamlConfiguration.loadConfiguration(config_File)
    val students = HashMap<Int,String>()
    fun load() {
        config.save(config_File)
    }
    fun loadNames(){
        if(!student_File.exists()) return
        val txt = YamlConfiguration.loadConfiguration(student_File)
        val list = txt.getStringList("students")
        repeat(list.size){
            students[it] = list[it]
        }
    }
}