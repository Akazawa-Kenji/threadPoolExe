/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsapp;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Crazian
 */

public class AssignmentPool {

    public static void main(String args[]) throws InterruptedException {

        Handler rejectionHandler = new Handler();
        //RejectedExecutionHandler implementation

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //Get the ThreadFactory implementation to use

        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
        //starting pool size to 2 the max pool size to 5
        // ArrayBlockingQueue<Runnable>(2) allows 2 threads to be held in queue. Others are passed to handler

        ThreadStatus status = new ThreadStatus(executorPool, 2);

        Thread statusThread = new Thread(status);
        statusThread.start();
        //submit assignment to the thread pool
        for (int i = 0; i < 10; i++) {
            executorPool.execute(new AssignmentThread("Thread Number" + i));
        }

        Thread.sleep(3000);

        executorPool.shutdown();
        //shut down the pool
        Thread.sleep(5000);

        status.shutdown();
        //shut down the status thread

    }
}
