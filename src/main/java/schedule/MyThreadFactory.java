package schedule;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wujingyi
 */
public class MyThreadFactory implements ThreadFactory {
    private final String threadNamePattern;
    private final boolean daemon;
    private final AtomicInteger threadCounter;

    public MyThreadFactory(String threadNamePattern, boolean daemon) {
        this.threadNamePattern = threadNamePattern;
        this.daemon = daemon;
        threadCounter = new AtomicInteger(1);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(daemon);
        thread.setName(String.format(threadNamePattern, threadCounter.getAndIncrement()));
        return thread;
    }
}
