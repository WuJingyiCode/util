package schedule;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * @author wujingyi
 */
public class MyThreadExecutorService {
    private final ScheduledExecutorService executorService;

    public MyThreadExecutorService(int corePoolSize, ThreadFactory threadFactory) {
        this.executorService = new ScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }

    public void schedule(ScheduleJob job) {
        switch (job.type) {
            case ONCE:
                executorService.submit(job);
                break;
            case WITH_FIX_DELAY:
                executorService.scheduleWithFixedDelay(job, job.delay, job.period, job.timeUnit);
                break;
            case AT_FIX_RATE:
                executorService.scheduleAtFixedRate(job, job.delay, job.period, job.timeUnit);
                break;
            default:
                throw new IllegalArgumentException(String.format("<MyThreadExecutorService> schedule error. no such type. type=%s", job.type));
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
