package schedule;

import java.util.concurrent.TimeUnit;

/**
 * @author wujingyi
 */
public class ScheduleJob implements Runnable {
    public final ScheduleType type;
    public final long delay;
    public final long period;
    public final TimeUnit timeUnit;
    public final Runnable runnable;

    public ScheduleJob(ScheduleType type, long delay, long period, TimeUnit timeUnit, Runnable runnable) {
        this.type = type;
        this.delay = delay;
        this.period = period;
        this.timeUnit = timeUnit;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        try {
            runnable.run();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
