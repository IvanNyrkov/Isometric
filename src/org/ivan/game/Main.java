package org.ivan.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


/**
 * @autor Nyrkov Ivan
 * Date: 10.04.14
 * Time: 23:35
 * Main
 */
public class Main {

    public static void main(String[] args) {
        try {
            Game game = new Game("Wrath of Ashardalon!");
            AppGameContainer app = new AppGameContainer(game);

            if (World.IS_FULL_SCREEN) {
                app.setDisplayMode(app.getScreenWidth(), app.getScreenHeight(), true);
            } else {
                app.setDisplayMode(World.RESOLUTION_X, World.RESOLUTION_Y, false);
            }

            World.offsetX = app.getWidth() / 2.5f;
            World.offsetY = app.getHeight() / 2.5f;
            World.offsetMaxX = World.offsetX + 500;
            World.offsetMinX = World.offsetX - 500;
            World.offsetMaxY = World.offsetY + 250;
            World.offsetMinY = World.offsetY - 250;
            app.setTargetFrameRate(World.FPS);

            if (World.IS_VSYNC) {
                app.setVSync(true);
            }

            app.setUpdateOnlyWhenVisible(true);

            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }
}
