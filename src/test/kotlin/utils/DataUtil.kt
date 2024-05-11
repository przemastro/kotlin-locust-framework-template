package utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.nio.file.FileSystems
import java.nio.file.Files;
import kotlin.reflect.KClass


class DataUtil {

    object YAMLParse {
        private val mapper = let {
            val mapper = ObjectMapper(YAMLFactory())
            mapper.registerModule(KotlinModule())
            mapper
        }

        fun <T: Any> parseProp(fileName: String, prop: KClass<T>): T {
            return Files.newBufferedReader(FileSystems.getDefault().getPath(fileName)).use { mapper.readValue(it, prop.java) }
        }
    }
}
