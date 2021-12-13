import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author rmJay
 * @since 2021/12/07-14:56
 */

public class demo02 {
    @Test
    public void test1() {

        int i = Integer.MAX_VALUE;
        long a = System.currentTimeMillis();
        for (int j = 0; j < Integer.MAX_VALUE; j++) {
            i /= 32;
//            i >>= 5;
            if (i == 0) i = Integer.MAX_VALUE;
        }
        long b = System.currentTimeMillis();

        System.out.println(b - a);
        int bb = 1;
        System.out.println("fix");
        System.out.println("master");
        System.out.println("fix2");
        System.out.println("push test");
        int bbbbbbb;
    }


}
