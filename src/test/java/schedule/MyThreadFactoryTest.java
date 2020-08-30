package schedule;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MyThreadFactoryTest {
    private static final String THREAD_PATTERN = "Thread %s";

    private MyThreadFactory factory;

    @Before
    public void setUp() {
        factory = new MyThreadFactory(THREAD_PATTERN, false);
    }

    @org.junit.Test
    public void newThread() throws InterruptedException {
        Runnable r = () -> System.out.println(Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            Thread thread = factory.newThread(r);
            assertEquals(String.format(THREAD_PATTERN, i), thread.getName());
            thread.start();
            // 让线程跑完
            thread.join();
        }
    }
}