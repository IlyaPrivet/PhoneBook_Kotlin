import com.google.gson.Gson
import java.io.File

class DslJson {
    fun <T>exportToJson(data: T, path: String){
        val gson = Gson()
        val json = gson.toJson(data)
        File(path).writeText(json)
        println("Данные записаны в $path")
    }
}