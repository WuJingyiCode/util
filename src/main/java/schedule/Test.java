package schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(10);
        new ScheduledThreadPoolExecutor(10, r -> null);
    }
}
