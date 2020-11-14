package sh.synthy

import com.badlogic.gdx.Application
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val config = LwjglApplicationConfiguration().apply {
            title = "Synthy"
            width = 800
            height = 600
        }
        var app = LwjglApplication(Game(), config)
        app.logLevel = Application.LOG_DEBUG
    }
}