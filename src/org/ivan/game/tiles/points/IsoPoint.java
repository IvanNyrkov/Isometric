package org.ivan.game.tiles.points;

/**
 * @autor Nyrkov Ivan
 * Date: 13.04.14
 * Time: 17:49
 * IsoPoint
 */
public abstract class IsoPoint {

    protected Float x;
    protected Float y;
    protected Integer i;
    protected Integer j;


    public Float getY() {
        if (y == null) {
            initIsoCoords();
        }
        return y;
    }

    public void setY(Float y) {
        this.y = y;
        this.j = null;
    }

    public Float getX() {
        if (x == null) {
            initIsoCoords();
        }
        return x;
    }

    public void setX(Float x) {
        this.x = x;
        this.i = null;
    }

    public Integer getI() {
        if (i == null) {
            initIsoIndx();
        }
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
        this.x = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IsoPoint)) return false;

        IsoPoint isoPoint = (IsoPoint) o;

        if (i != null ? !i.equals(isoPoint.i) : isoPoint.i != null) return false;
        if (j != null ? !j.equals(isoPoint.j) : isoPoint.j != null) return false;
        if (x != null ? !x.equals(isoPoint.x) : isoPoint.x != null) return false;
        if (y != null ? !y.equals(isoPoint.y) : isoPoint.y != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (i != null ? i.hashCode() : 0);
        result = 31 * result + (j != null ? j.hashCode() : 0);
        return result;
    }

    public Integer getJ() {
        if (j == null) {
            initIsoIndx();
        }
        return j;

    }

    public void setJ(Integer j) {
        this.j = j;
        this.y= null;
    }

    protected abstract void initIsoIndx();

    protected abstract void initIsoCoords();

}
