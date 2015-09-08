package org.ivan.game.tiles.points;

import org.ivan.game.World;

/**
 * @autor Nyrkov Ivan
 * Date: 13.04.14
 * Time: 17:52
 * TilePoint
 */
public class TilePoint extends IsoPoint {


    public TilePoint(Integer i, Integer j) {
        setI(i);
        setJ(j);
        initIsoCoords();
    }

    public TilePoint(Float x, Float y) {
        setX(x);
        setY(y);
        initIsoIndx();
    }

    public void refresh(Float mouseX, Float mouseY) {
        this.x = mouseX;
        this.y = mouseY;
        initIsoIndx();
        initIsoCoords();
    }

    protected void initIsoIndx() {
        Integer tileHeight;
        Integer tileWidth;

        tileHeight = World.TILE_HEIGHT;
        tileWidth = World.TILE_WIDTH;

        Integer indxI = Math.round(((y - tileHeight / 2) / tileHeight) + ((x - tileWidth / 2) / tileWidth));
        Integer indxJ = Math.round(((y - tileHeight / 2) / tileHeight) - ((x - tileWidth / 2) / tileWidth));

        this.i = indxI;
        this.j = indxJ;
    }

    protected void initIsoCoords() {
        Integer tileWidth;
        Integer tileHeight;
        tileHeight = World.TILE_HEIGHT;
        tileWidth = World.TILE_WIDTH;

        Float x = ((i - j) * ((float)tileWidth / 2));
        Float y = ((i + j) * ((float)tileHeight / 2));

        this.x = x;
        this.y = y;
    }

}
