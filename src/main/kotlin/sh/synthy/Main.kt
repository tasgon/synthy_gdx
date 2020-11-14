package sh.synthy

import com.badlogic.gdx.Application
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        Piano.enumerate().forEach { println("${it.first}: ${it.second}") }
        Piano.connect(1)
        val config = LwjglApplicationConfiguration().apply {
            title = "Synthy"
            width = 800
            height = 600
        }
        var app = LwjglApplication(Game(), config)
        app.logLevel = Application.LOG_DEBUG
    }
}