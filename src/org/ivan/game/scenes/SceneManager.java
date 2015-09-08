package org.ivan.game.scenes;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @autor Nyrkov Ivan
 * Date: 10.04.14
 * Time: 23:40
 * SceneManager
 */
public class SceneManager {

    private List<Scene> scenes ;
    private GameContainer gameContainer;

    public SceneManager (GameContainer gameContainer) {
        this.gameContainer = gameContainer;
        scenes = new ArrayList<>();
    }

    public void render(GameContainer gameContainer, Graphics g) throws SlickException {
        for(Scene scene : scenes) {
            scene.render(gameContainer, g);
        }
    }

    public void update(GameContainer gameContainer, int t) throws SlickException {
        Input input = gameContainer.getInput();
        if (input.isKeyDown(Input.KEY_ESCAPE)) {
            System.exit(0);
        }

        for(Scene scene : scenes) {
            scene.update(gameContainer, t);
        }
    }

    public void addScene (Scene scene) {
        scenes.add(scene);
        try {
            scene.init(gameContainer);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        Collections.sort(scenes);
    }

    public void sort () {
        Collections.sort(scenes);
    }

    public void clear () {
        scenes = new ArrayList<>();
    }

    public void removeScene (Scene scene) {
        scenes.remove(scene);
    }


    public boolean removeScene (String sceneString) {
        for (Scene scene : scenes) {
            if (sceneString.equals(scene.toString())) {
                scenes.remove(scene);
                return true;
            }
        }
        return false;
    }

    public Scene getScene (String sceneString) {
        for (Scene scene : scenes) {
            if( scene.toString().equals(sceneString)) {
                return scene;
            }
        }
        return null;
    }

}
