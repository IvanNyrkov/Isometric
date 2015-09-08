package org.ivan.game.scenes;

import org.ivan.game.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * @autor Nyrkov Ivan
 * Date: 10.04.14
 * Time: 23:46
 * Scene
 */
public class Scene implements Comparable<Scene> {

    public enum STATE { ON , FREEZE , FREEZE_NEXT , INVISIBLE }; 

    private STATE state;

    private int priority = 0;

    private Image scene;


    public Scene () {
        state = STATE.ON;
        try {
            scene = new Image(World.RESOLUTION_X, World.RESOLUTION_Y);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    
    protected void CustomRender(GameContainer gameContainer, Graphics g) throws SlickException {

    }

    protected void CustomUpdate(GameContainer gameContainer, int delta) throws SlickException {

    }

    public void init(GameContainer gameContainer) throws SlickException {

    }


    public void render(GameContainer gameContainer, Graphics g) throws SlickException {
        if (state != STATE.INVISIBLE) {
            if (state == STATE.ON) {
                CustomRender(gameContainer, g);
            }
            if (state == STATE.FREEZE_NEXT) {
                scene.getGraphics().clear();
                CustomRender(gameContainer, scene.getGraphics());
                state = STATE.FREEZE;
            }
            if (state == STATE.FREEZE) {
                g.drawImage(scene, 0, 0);
            }
        }
    }

    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if(state == STATE.ON) {
            CustomUpdate(gameContainer, delta);
        }
    }

    public void setPriority (int p) {
        priority = p;
    }

    public String toString() {
        return "default";
    }

    public int getPriority () {
        return priority;
    }

    public int compareTo(Scene compareObject) {
        if (getPriority() < compareObject.getPriority())
            return -1;
        else if (getPriority() == compareObject.getPriority())
            return 0;
        else
            return 1;
    }

    public void setState(STATE s) {
        state = s;
    }

}
