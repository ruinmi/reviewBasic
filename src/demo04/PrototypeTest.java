package demo04;

/**
 * @author rmJay
 * @version 1.1
 * @since 2021/12/12 16:25
 */

public class PrototypeTest {
   public static void main(String[] args) throws CloneNotSupportedException {
      Prototype p = new Prototype();
      p.setX(2);
      p.setY(34234);
      Prototype clone = (Prototype) p.clone();
      System.out.println(clone.getX());
      System.out.println(clone.getY());

   }
}
