/**
 * @author rmJay
 * @version 1.1
 * @since 2021/12/12 14:44
 */
class Shop implements Runnable {
    static int item = 0;

    @Override
    public void run() {
        synchronized (Shop.class) {

            for (int i = 0; i < 30000; i++) {
                item++;
            }
        }
    }
}

public class demo03 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Shop()).start();
        }
        Thread.sleep(1000);
        System.out.println(Shop.item);
    }
}
