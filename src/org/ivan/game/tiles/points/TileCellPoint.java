package org.ivan.game.tiles.points;

import org.ivan.game.World;

/**
 * @autor Nyrkov Ivan
 * Date: 13.04.14
 * Time: 17:52
 * TileCellPoint
 */
public class TileCellPoint extends IsoPoint {

    public TileCellPoint(Float x, Float y) {
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

        tileHeight = World.TILE_CELL_HEIGHT;
        tileWidth = World.TILE_CELL_WIDTH;

        Integer indxI = Math.round(((y - tileHeight / 2) / tileHeight) + ((x - tileWidth / 2) / tileWidth));
        Integer indxJ = Math.round(((y - tileHeight / 2) / tileHeight) - ((x - tileWidth / 2) / tileWidth));

        indxI -= 2;
        indxJ += 2;

        this.i = indxI;
        this.j = indxJ;
    }

    protected void initIsoCoords() {
        Integer tileWidth;
        Integer tileHeight;

        tileHeight = World.TILE_CELL_HEIGHT;
        tileWidth = World.TILE_CELL_WIDTH;

        Float x = ((i - j) * ((float)tileWidth / 2));
        Float y = ((i + j) * ((float)tileHeight / 2));

        x += World.TILE_WIDTH / 2 - World.TILE_CELL_WIDTH / 2;

        this.x = x;
        this.y = y;
    }
}
