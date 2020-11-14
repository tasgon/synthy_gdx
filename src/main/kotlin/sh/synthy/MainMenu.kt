package sh.synthy

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.Drawable
import ktx.app.KtxScreen
import ktx.scene2d.*
import java.io.File
import java.nio.file.Path
import javax.swing.event.ChangeEvent

class MainMenu(val game: Game) : KtxScreen {
    private val stage: Stage = Stage()
    private val songFolder = "${System.getProperty("user.home")}/songs"
    val songs by lazy { File(songFolder).list() }

    init {
        stage.actors {
            verticalGroup {
                setFillParent(true)
                label("Welcome to synthy.") {
                    color = Color.WHITE
                    style.font = game.font
                    setFontScale(1.5f)
                }
                horizontalGroup {
                    label("Song folder: ")
                    val folder = textField(songFolder)
                    button {
                        label("Refresh")
                    }
                }
            }
        }
        Gdx.input.inputProcessor = stage
    }

    private val cam = OrthographicCamera().apply { setToOrtho(false, 800f, 600f) }

    override fun render(delta: Float) {
        stage.act()
        stage.draw()
    }
}