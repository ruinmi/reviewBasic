package demo04;

/**
 * @author rmJay
 * @version 1.1
 * @since 2021/12/12 16:11
 */

public class EagerSingleton {
   private static final EagerSingleton instance = new EagerSingleton();

   private EagerSingleton() {}

   public static EagerSingleton getInstance() {
      return instance;
   }
}
