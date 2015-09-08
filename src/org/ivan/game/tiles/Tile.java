package org.ivan.game.tiles;

import javafx.geometry.Side;
import org.ivan.game.World;
import org.ivan.game.tiles.points.TileCellPoint;
import org.ivan.game.tiles.points.TilePoint;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * @autor Nyrkov Ivan
 * Date: 10.04.14
 * Time: 12:45
 * Tile
 */
public class Tile {

    private TileCell[][] tileCells;
    private Side connectionSide;

    private TiledMap topTile;
    private TiledMap bottomTile;
    private TiledMap leftTile;
    private TiledMap rightTIle;
    private TiledMap currentTile;

    public Tile(String path) throws SlickException {
        topTile = new TiledMap(path+"_top.tmx");
        bottomTile = new TiledMap(path+"_bottom.tmx");
        leftTile = new TiledMap(path+"_left.tmx");
        rightTIle = new TiledMap(path+"_right.tmx");

        connectionSide = Side.TOP;
        currentTile = topTile;
        initTileCells();
    }


    public Side getConnectionSide() {
        return connectionSide;
    }

    public void setConnectionSide(Side connectionSide) {
        switch (connectionSide) {
            case TOP:
                rotateArray(connectionSide);
                currentTile = topTile;
                break;
            case BOTTOM:
                rotateArray(connectionSide);
                currentTile = bottomTile;
                break;
            case LEFT:
                rotateArray(connectionSide);
                currentTile = leftTile;
                break;
            case RIGHT:
                rotateArray(connectionSide);
                currentTile = rightTIle;
                break;
        }
        this.connectionSide = connectionSide;
    }

    public void render(TilePoint p) {
        Float x = p.getX() + World.SECRET_OFFSET_X + World.offsetX;
        Float y = p.getY() + World.offsetY;
        currentTile.render(x.intValue(), y.intValue());
    }

    public TileCell getTileCell(TileCellPoint point) {
        Integer i = point.getI();
        Integer j = point.getJ();

        // так надо
        while (i >= World.TILE_CELL_COUNT) {
            i -= World.TILE_CELL_COUNT;
        }
        while (j >= World.TILE_CELL_COUNT) {
            j -= World.TILE_CELL_COUNT;
        }
        while (i < 0) {
            i += World.TILE_CELL_COUNT;
        }
        while (j < 0) {
            j += World.TILE_CELL_COUNT;
        }

        TileCell tileCell;
        try {
            tileCell = tileCells[i][j];
        } catch(NullPointerException e) {
            tileCell = null;
        }
        return tileCell;
    }

    private void initTileCells() {
        tileCells = new TileCell[currentTile.getWidth()][currentTile.getHeight()];

        for (int x = 0; x < currentTile.getWidth(); x++) {
            for (int y = 0; y < currentTile.getHeight(); y++) {
                tileCells[x][y] = new TileCell();
                int tileID = currentTile.getTileId(x, y, 0);

                String isBlocked = currentTile.getTileProperty(tileID, "blocked", "false");
                if ("true".equals(isBlocked)) {
                    tileCells[x][y].setIsBlocked(true);
                } else {
                    tileCells[x][y].setIsBlocked(false);
                }

                String hasMonster = currentTile.getTileProperty(tileID, "hasMonster", "false");
                if ("true".equals(hasMonster)) {
                    tileCells[x][y].setHasMonster(true);
                } else {
                    tileCells[x][y].setHasMonster(false);
                }
            }
        }
    }

    private void rotateArray(Side newSide) {
        if (newSide.equals(connectionSide)) {
            return;
        }
        int rotateCountTop = 0;
        int rotateCountLeft = 0;
        int rotateCountRight = 0;
        int rotateCountBottom = 0;

        switch (connectionSide) {
            case TOP:
                rotateCountLeft = 1;
                rotateCountBottom = 2;
                rotateCountRight = 3;
                break;
            case LEFT:
                rotateCountBottom = 1;
                rotateCountRight = 2;
                rotateCountTop = 3;
                break;
            case BOTTOM:
                rotateCountRight = 1;
                rotateCountTop = 2;
                rotateCountLeft = 3;
                break;
            case RIGHT:
                rotateCountTop = 1;
                rotateCountLeft = 2;
                rotateCountBottom = 3;
                break;
        }

        int rotateCount = 0;
        switch (newSide) {
            case TOP:
                rotateCount = rotateCountTop;
                break;
            case LEFT:
                rotateCount = rotateCountLeft;
                break;
            case BOTTOM:
                rotateCount = rotateCountBottom;
                break;
            case RIGHT:
                rotateCount = rotateCountRight;
                break;
        }

        while (rotateCount > 0) {
            TileCell[][] ret = new TileCell[currentTile.getWidth()][currentTile.getHeight()];
            for (int i = 0; i < currentTile.getWidth(); ++i) {
                for (int j = 0; j < currentTile.getWidth(); ++j) {
                    ret[i][j] = tileCells[currentTile.getWidth() - j - 1][i];
                }
            }
            tileCells = ret;
            rotateCount--;
        }
    }

}
