package ar.edu.unlp.info.oo1.ej14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class JobSchedulerTest {
    protected JobDescription firstJob;
    protected JobDescription highestPriorityJob;
    protected JobDescription mostEffortJob;
    protected JobDescription lastJob;

    private void initializeJobs() {

        firstJob = new JobDescription (1, 1, "Este es el primero");
        highestPriorityJob = new JobDescription (1, 100, "Este es el de más prioridad");
        mostEffortJob = new JobDescription (100, 1, "Este es el de más esfuerzo");
        lastJob = new JobDescription (1, 1, "Este es el último");
    }

    @BeforeEach
    void setUp() {
        this.initializeJobs();
    }

    private JobScheduler newFifoScheduler() {
        return new JobScheduler(new FIFOPolicy());
    }

    private JobScheduler newLifoScheduler() {
        return new JobScheduler(new LIFOPolicy());
    }

    private JobScheduler newPriorityScheduler() {
        return new JobScheduler(new HighestPriorityPolicy());
    }

    private JobScheduler newEffortScheduler() {
        return new JobScheduler(new MostEffortPolicy());
    }

    private void scheduleJobsIn(JobScheduler aJobScheduler) {
        aJobScheduler.schedule(firstJob);
        aJobScheduler.schedule(highestPriorityJob);
        aJobScheduler.schedule(mostEffortJob);
        aJobScheduler.schedule(lastJob);
    }

    @Test
    void testSchedule() {
    	JobScheduler aScheduler = new JobScheduler(new FIFOPolicy());
        aScheduler.schedule(highestPriorityJob);
        assertTrue(aScheduler.getJobs().contains(highestPriorityJob));
    }

    @Test
    void testUnschedule() {
    	JobScheduler aScheduler = new JobScheduler(new FIFOPolicy());
        this.scheduleJobsIn(aScheduler);
        aScheduler.unschedule(highestPriorityJob);
        assertFalse(aScheduler.getJobs().contains(highestPriorityJob));
    }

    @Test
    void testNext() {
    	JobScheduler scheduler;

        scheduler = this.newFifoScheduler();
        this.scheduleJobsIn(scheduler);

        assertEquals(firstJob, scheduler.next());
        assertEquals(3, scheduler.getJobs().size());

        scheduler = this.newLifoScheduler();
        this.scheduleJobsIn(scheduler);

        assertEquals(lastJob, scheduler.next());
        assertEquals(3, scheduler.getJobs().size());

        scheduler = this.newPriorityScheduler();
        this.scheduleJobsIn(scheduler);

        assertEquals(highestPriorityJob, scheduler.next());
        assertEquals(3, scheduler.getJobs().size());

        scheduler = this.newEffortScheduler();
        this.scheduleJobsIn(scheduler);

        assertEquals(mostEffortJob, scheduler.next());
        assertEquals(3, scheduler.getJobs().size());
    }
}
