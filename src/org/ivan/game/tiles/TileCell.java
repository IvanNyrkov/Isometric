package org.ivan.game.tiles;

/**
 * @autor Nyrkov Ivan
 * Date: 10.04.14
 * Time: 12:45
 * TileCell
 */
public class TileCell {

    private Boolean isBlocked;
    private Boolean hasMonster;

    public TileCell() {

    }

    public Boolean isBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Boolean getHasMonster() {
        return hasMonster;
    }

    public void setHasMonster(Boolean hasMonster) {
        this.hasMonster = hasMonster;
    }
}
