package org.ivan.game;

/**
 * @autor Nyrkov Ivan
 * Date: 10.04.14
 * Time: 12:45
 * World
 */
public class World {

    public static Float offsetX = 0f;
    public static Float offsetY = 0f;

    public static Float offsetMaxX;
    public static Float offsetMinX;
    public static Float offsetMaxY;
    public static Float offsetMinY;

    public static final Integer TILE_CELL_HEIGHT = 32;
    public static final Integer TILE_CELL_WIDTH = 64;
    public static final Integer TILE_CELL_COUNT = 5;

    public static final Integer TILE_HEIGHT = TILE_CELL_HEIGHT * TILE_CELL_COUNT;
    public static final Integer TILE_WIDTH = TILE_CELL_WIDTH * TILE_CELL_COUNT;


    public static final Integer SECRET_OFFSET_X = World.TILE_WIDTH / 2 - World.TILE_CELL_WIDTH / 2;

    public static final Boolean IS_FULL_SCREEN = false;

    public static final Integer RESOLUTION_X = 800;
    public static final Integer RESOLUTION_Y = 600;

    public static final Integer FPS = 60;

    public static final Boolean IS_VSYNC = true;

}
