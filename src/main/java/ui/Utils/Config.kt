package ui.Utils

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import ui.UIConsts
import java.io.File
import java.util.*

object Config {

    private val filePath = "${UIConsts.NAME}/config.yml"
    private val studentPath = "${UIConsts.NAME}/students.yml"
    private val curriculumPath = "${UIConsts.NAME}/curriculum.yml"
    private val config_File = File(filePath)
    private val student_File = File(studentPath)
    val curriculum_File = File(curriculumPath)
    val config:FileConfiguration = YamlConfiguration.loadConfiguration(config_File)
    val curriculum:FileConfiguration = YamlConfiguration.loadConfiguration(curriculum_File)
    val student:FileConfiguration = YamlConfiguration.loadConfiguration(student_File)
    val students = LinkedList<String>()
    fun load(fileconfiguration:FileConfiguration? = null) =
        fileconfiguration?.also {
            when(it){
                config -> config.save(config_File)
                curriculum -> curriculum.save(curriculum_File)
                student -> student.save(student_File)
            }
        }?:run {
            config.save(config_File)
            curriculum.save(curriculum_File)
            student.save(student_File)
        }

    fun loadNames() {
        takeIf { student_File.exists() }?:return
        student.getStringList("students").forEach(students::add)
    }
}