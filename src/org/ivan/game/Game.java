package org.ivan.game;

import org.ivan.game.scenes.StartScene;
import org.newdawn.slick.*;
import org.ivan.game.scenes.SceneManager;
import org.newdawn.slick.Graphics;

/**
 * @autor Nyrkov Ivan
 * Date: 10.04.14
 * Time: 12:45
 * Boot
 */
public class Game extends BasicGame {

    SceneManager sceneManager;

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameContainer.setShowFPS(false);
        sceneManager = new SceneManager(gameContainer);
        sceneManager.addScene(new StartScene());
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        sceneManager.update(gameContainer, delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setBackground(new org.newdawn.slick.Color(80, 80, 80));
        sceneManager.render(gameContainer, graphics);
    }

}
