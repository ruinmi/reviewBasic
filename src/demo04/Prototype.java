package demo04;

/**
 * @author rmJay
 * @version 1.1
 * @since 2021/12/12 16:20
 */

public class Prototype implements Cloneable {
    private int x;
    private int y;

    public Prototype() {}

//    public Prototype(Prototype target) {
//        if (target != null) {
//            this.x = target.x;
//            this.y = target.y;
//        }
//    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
