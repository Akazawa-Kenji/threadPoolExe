/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsapp;
import java.util.concurrent.ThreadPoolExecutor;
/**
 *
 * @author Crazian
 */


public class ThreadStatus implements Runnable
{
    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run=true;

    public ThreadStatus(ThreadPoolExecutor executor, int delay)
    {
        this.executor = executor;
        this.seconds=delay;
    }
    public void shutdown(){
        this.run=false;
    }
    @Override
    public void run()
    {
        while(run){
                System.out.println(
                    String.format("[status] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            //%d:int %s:anytype
                        this.executor.getPoolSize(),
                        //Returns the current number of threads in the pool.
                        this.executor.getCorePoolSize(),
                        //Returns the core number of threads
                        this.executor.getActiveCount(),
                        //Returns the approximate number of threads that are actively executing tasks.
                        this.executor.getCompletedTaskCount(),
                        //Returns the approximate total number of tasks that have completed execution.
                        this.executor.getTaskCount(),
                        //Returns the approximate total number of tasks that have ever been scheduled for execution.
                        this.executor.isShutdown(),
                        //Returns true if this executor has been shut down.
                        this.executor.isTerminated()));
                        //Returns true if all tasks have completed following shut down.
                try {
                    Thread.sleep(seconds*999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
            
    }
}