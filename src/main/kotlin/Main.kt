import java.io.File

val cssRegex = "<style>([.\\s\\S]+)<\\/style>".toRegex()

lateinit var css: String

fun main(args: Array<String>) {
    val pathToFolder = args.getOrNull(0)
    require(pathToFolder != null)

    val folder = File(pathToFolder)
    require(folder.isDirectory)
    require(folder.listFiles()?.isNotEmpty() == true)
    folder.listFiles()!!.forEach {
        if (it.extension == "html") {

            val html = it.readText()

            css = cssRegex.find(html)?.groups?.get(1)?.value ?: ""
        }
    }
}