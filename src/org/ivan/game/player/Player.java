package org.ivan.game.player;

import org.ivan.game.World;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * @autor Nyrkov Ivan
 * Date: 10.04.14
 * Time: 12:45
 * Player
 */
public class Player {

   /* Image[] movementUp = {new Image("data/wmg1_bk1.png"), new Image("data/wmg1_bk2.png")};
    Image [] movementDown = {new Image("data/wmg1_fr1.png"), new Image("data/wmg1_fr2.png")};
    Image [] movementLeft = {new Image("data/wmg1_lf1.png"), new Image("data/wmg1_lf2.png")};
    Image [] movementRight = {new Image("data/wmg1_rt1.png"), new Image("data/wmg1_rt2.png")};
    int [] duration = {300, 300}; */

    private Image image;
    private float x, y;

    public Player(int i, int j) throws SlickException {
        image = new Image("res/images/Mage.png");
        x = ((i - j) * ((float)64 / 2));
        y = ((i + j) * ((float)128 / 2));
    }

    public void draw() {
        image.draw(x + World.TILE_WIDTH / 2 - 32 / 2+World.offsetX, y+World.offsetY-64+World.TILE_CELL_HEIGHT/2);
    }

    public void changeX(float delta) {
        x += delta;
    }

    public void changeY(float delta) {
        y += delta;
    }

}
