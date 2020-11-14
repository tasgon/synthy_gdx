package sh.synthy

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.utils.Drawable
import ktx.app.KtxScreen
import ktx.scene2d.*

class MainMenu(val game: Game) : KtxScreen {
    val menu by lazy {
        scene2d.verticalGroup {
            label("Welcome to synthy.")
        }
    }

    var stage: Stage

    init {
        stage = Stage()
        stage.actors {
            label("Test") {
                color = Color.BLUE
            }
        }
    }

    private val cam = OrthographicCamera().apply { setToOrtho(false, 800f, 600f) }

    override fun render(delta: Float) {
        stage.act()
        stage.draw()
        println("Rendering")
    }
}