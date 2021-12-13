package demo04;

/**
 * @author rmJay
 * @version 1.1
 * @since 2021/12/12 16:16
 */

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {};

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
