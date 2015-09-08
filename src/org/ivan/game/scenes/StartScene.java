package org.ivan.game.scenes;

import org.ivan.game.player.Player;
import org.ivan.game.tiles.Tile;
import org.ivan.game.tiles.points.TileCellPoint;
import org.ivan.game.tiles.points.TilePoint;
import org.ivan.game.tiles.selection.SelectionTile;
import org.ivan.game.tiles.selection.SelectionTileCell;
import org.ivan.game.World;
import org.ivan.game.tiles.TileGrid;

import org.newdawn.slick.*;

/**
 * @autor Nyrkov Ivan
 * Date: 11.04.14
 * Time: 0:09
 * StartScene
 */
public class StartScene extends Scene {

    private TileGrid tileGrid;

    private SelectionTile selectionTile;
    private SelectionTileCell selectionTileCell;
    private Player player;

    public StartScene() {
        super();
        setPriority(1);
    }

    public String toString() {
        return "StartScene";
    }

    public void init(GameContainer gameContainer) throws SlickException {
        tileGrid = new TileGrid();
        selectionTileCell = new SelectionTileCell(new TileCellPoint(0f, 0f));
        selectionTile = new SelectionTile(new TilePoint(0f, 0f));
        player = new Player(1, 1);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics g) throws SlickException {
        tileGrid.render();

        // g.drawString("Offset X, Y: " + World.offsetX.intValue() + ":" + World.offsetY.intValue(), 40, 100);

        Tile tile = tileGrid.getTile(selectionTile.getPoint());
        if (tile != null) {
            g.drawString("Tile i,j: " + (int) selectionTile.getI() + ":" + (int)selectionTile.getJ(), 40, 20);
            //g.draw(selectionTile);
        }

        Boolean isBlocked = tileGrid.isBlocked(selectionTile.getPoint(), selectionTileCell.getPoint());
        if (isBlocked != null) {
            if (isBlocked == false) {
                g.draw(selectionTileCell);
            }
            g.drawString("TileCell i,j: " + (int) selectionTileCell.getI() + ":" + (int)selectionTileCell.getJ(), 40, 40);
            g.drawString("IsBlocked: " + isBlocked, 40, 60);
        }

        player.draw();
    }

    protected void CustomUpdate(GameContainer gameContainer, int delta) throws SlickException {
        Input input = gameContainer.getInput();

        updateSelections(input, gameContainer, delta);
        cameraControll(input, gameContainer, delta);
        //playerControll(input, gameContainer, delta);
        getKeyboardInput(input, gameContainer, delta);

        if (input.isMousePressed(0)) {
            tileGrid.add(selectionTile.getPoint());
        }
    }

    private void updateSelections(Input input, GameContainer gameContainer, int delta) {
        float mouseX = (input.getMouseX() - World.offsetX);
        float mouseY = (input.getMouseY() - World.offsetY);

        selectionTileCell.update(mouseX, mouseY);
        selectionTile.update(mouseX, mouseY);
    }

    private void cameraControll(Input input, GameContainer gameContainer, int delta) {
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();

        if ((mouseY <= 0+10) && (World.offsetY <= World.offsetMaxY)) {
            World.offsetY += delta*0.6f;
        }
        if ((mouseY >= gameContainer.getHeight()-10) && (World.offsetY >= World.offsetMinY)) {
            World.offsetY -= delta*0.6f;
        }
        if ((mouseX <= 0+10) && (World.offsetX <= World.offsetMaxX)) {
            World.offsetX += delta*0.6f;
        }
        if ((mouseX >= gameContainer.getWidth()-10) && (World.offsetX >= World.offsetMinX)){
            World.offsetX -= delta*0.6f;
        }
    }

    private void playerControll(Input input, GameContainer gameContainer, int delta) {
        Boolean isW = input.isKeyDown(Input.KEY_W);
        Boolean isA = input.isKeyDown(Input.KEY_A);
        Boolean isS = input.isKeyDown(Input.KEY_S);
        Boolean isD = input.isKeyDown(Input.KEY_D);

        if (isW && isD) {
            player.changeX(delta*-0.1f);
            player.changeY(delta*-0.1f);
        } else if (isW && isW) {
            player.changeX(delta*+0.1f);
            player.changeY(delta*-0.1f);
        } else if (isS && isA) {
            player.changeX(delta*-0.1f);
            player.changeY(delta*+0.1f);
        } else if (isS && isD) {
            player.changeX(delta*+0.1f);
            player.changeY(delta*+0.1f);
        } else {
            if (isW) {
                player.changeY(delta*-0.1f);
            }
            if (isS) {
                player.changeY(delta*+0.1f);
            }
            if (isA) {
                player.changeX(delta*-0.1f);
            }
            if (isD) {
                player.changeX(delta*+0.1f);
            }
        }
    }

    private void getKeyboardInput(Input input, GameContainer gameContainer, int delta) {
        if (input.isKeyPressed(Input.KEY_UP)) {
            tileGrid.addTop(tileGrid.getLastTile());
        }
        if (input.isKeyPressed(Input.KEY_DOWN)) {
            tileGrid.addBottom(tileGrid.getLastTile());
        }
        if (input.isKeyPressed(Input.KEY_LEFT)) {
            tileGrid.addLeft(tileGrid.getLastTile());
        }
        if (input.isKeyPressed(Input.KEY_RIGHT)) {
            tileGrid.addRight(tileGrid.getLastTile());
        }
    }
}
