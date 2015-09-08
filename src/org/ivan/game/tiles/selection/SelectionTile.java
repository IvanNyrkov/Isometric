package org.ivan.game.tiles.selection;

import org.ivan.game.World;
import org.ivan.game.tiles.points.TilePoint;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

/**
 * @autor Nyrkov Ivan
 * Date: 11.04.14
 * Time: 15:29
 * SelectionTileCell
 */
public class SelectionTile extends Shape {

    private TilePoint point;

    public SelectionTile(TilePoint point) {
        super();
        this.point = point;
        points = new float[8];
    }


    public void update(Float mouseX, Float mouseY) {
        point.refresh(mouseX, mouseY);
        initPoints();
    }


    public TilePoint getPoint() {
        return point;
    }

    public float getI() {
        return point.getI();
    }

    public float getJ() {
        return point.getJ();
    }

    @Override
    public Shape transform(Transform transform) {
        return null;
    }

    @Override
    protected void createPoints() {
        initPoints();
    }

    private void initPoints() {
        Float x =  point.getX() + World.offsetX;
        Float y =  point.getY() + World.offsetY;
        points[0] = x + World.TILE_WIDTH / 2;
        points[1] = y;

        points[2] = x + World.TILE_WIDTH;
        points[3] = y + World.TILE_HEIGHT / 2;

        points[4] = x + World.TILE_WIDTH / 2;
        points[5] = y + World.TILE_HEIGHT;

        points[6] = x;
        points[7] = y + World.TILE_HEIGHT / 2;
    }
}
