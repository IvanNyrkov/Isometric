package org.ivan.game.tiles;

import javafx.geometry.Side;
import org.ivan.game.tiles.points.TileCellPoint;
import org.ivan.game.tiles.points.TilePoint;
import org.ivan.game.utils.isometric.IsoPoint;
import org.newdawn.slick.SlickException;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor Nyrkov Ivan
 * Date: 10.04.14
 * Time: 18:14
 * TileGrid
 */
public class TileGrid {

    private Map<TilePoint, Tile> tiles;

    private Tile lastTile;

    public Tile getLastTile() {
        return lastTile;
    }

    public TileGrid() throws SlickException {
        Tile tile = new Tile("resources/tiles/tile2");
        lastTile = tile;

        tiles = new HashMap<>();
        tiles.put(new TilePoint(0, 0), tile);
    }


    public void render() {
        for (Tile tile : tiles.values()) {
            tile.render(getPoint(tile));
        }
    }

    public void addLeft(Tile tile) {
        TilePoint current = getPoint(tile);
        TilePoint leftPoint = new TilePoint(current.getI()-1, current.getJ());

        // left tile already exists
        if (getTile(leftPoint) != null) {
            return;
        }

        try {
            Tile newTile = getRandomTile();
            if (!newTile.getConnectionSide().equals(Side.RIGHT)) {
                newTile.setConnectionSide(Side.RIGHT);
            }
            tiles.put(leftPoint, newTile);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void addRight(Tile tile) {
        TilePoint current = getPoint(tile);
        TilePoint rightPoint = new TilePoint(current.getI()+1, current.getJ());

        // right tile already exists
        if (getTile(rightPoint) != null) {
            return;
        }

        try {
            Tile newTile = getRandomTile();
            if (!newTile.getConnectionSide().equals(Side.LEFT)) {
                newTile.setConnectionSide(Side.LEFT);
            }
            tiles.put(rightPoint, newTile);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void addTop(Tile tile) {
        TilePoint current = getPoint(tile);
        TilePoint topPoint = new TilePoint(current.getI(), current.getJ()-1);

        // top tile already exists
        if (getTile(topPoint) != null) {
            return;
        }

        try {
            Tile newTile = getRandomTile();
            if (!newTile.getConnectionSide().equals(Side.BOTTOM)) {
                newTile.setConnectionSide(Side.BOTTOM);
            }
            tiles.put(topPoint, newTile);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void addBottom(Tile tile) {
        TilePoint current = getPoint(tile);
        TilePoint bottomPoint = new TilePoint(current.getI(), current.getJ()+1);

        // top tile already exists
        if (getTile(bottomPoint) != null) {
            return;
        }

        try {
            Tile newTile = getRandomTile();
            if (!newTile.getConnectionSide().equals(Side.TOP)) {
                newTile.setConnectionSide(Side.TOP);
            }
            tiles.put(bottomPoint, newTile);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void add(TilePoint point) {
        if (tiles.get(point) != null) {
            return;
        }
        TilePoint pointLeft = new TilePoint(point.getI()-1, point.getJ());
        TilePoint pointTop = new TilePoint(point.getI(), point.getJ()-1);
        TilePoint pointRight = new TilePoint(point.getI()+1, point.getJ());
        TilePoint pointBottom = new TilePoint(point.getI(), point.getJ()+1);
        if (tiles.get(pointLeft) != null) {
            addRight(tiles.get(pointLeft));
        }
        if (tiles.get(pointRight) != null) {
            addLeft(tiles.get(pointRight));
        }
        if (tiles.get(pointBottom) != null) {
            addTop(tiles.get(pointBottom));
        }
        if (tiles.get(pointTop) != null) {
            addBottom(tiles.get(pointTop));
        }
    }

    public void add(TilePoint point, Side side) {
        if (tiles.get(point) != null) {
            return;
        }
        TilePoint pointLeft = new TilePoint(point.getI()-1, point.getJ());
        TilePoint pointTop = new TilePoint(point.getI(), point.getJ()-1);
        TilePoint pointRight = new TilePoint(point.getI()+1, point.getJ());
        TilePoint pointBottom = new TilePoint(point.getI(), point.getJ()+1);
        if (tiles.get(pointLeft) != null) {
            addRight(tiles.get(pointLeft));
        }
        if (tiles.get(pointRight) != null) {
            addLeft(tiles.get(pointRight));
        }
        if (tiles.get(pointBottom) != null) {
            addTop(tiles.get(pointBottom));
        }
        if (tiles.get(pointTop) != null) {
            addBottom(tiles.get(pointTop));
        }
    }

    public Tile getTile(TilePoint point) {
        try {
            return tiles.get(point);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public TilePoint getPoint(Tile tile) {
        for (TilePoint point : tiles.keySet()) {
            if (tiles.get(point).equals(tile)) {
                return point;
            }
        }
        return null;
    }

    public Boolean isBlocked(TilePoint pointTile, TileCellPoint pointTileCell) {
        Tile tile = getTile(pointTile);
        if (tile == null) {
            return null;
        }
        TileCell tileCell = tile.getTileCell(pointTileCell);
        if (tileCell == null) {
            return null;
        }
        return tileCell.isBlocked();
    }

    /*
        TODO
     */
    private Tile getRandomTile() throws SlickException {
        return (new Tile("resources/tiles/tile1"));
    }

}
