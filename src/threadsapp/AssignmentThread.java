/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsapp;
/**
 *
 * @author Crazian
 */
public class AssignmentThread implements Runnable {
  // implementable the Runnable interface on our AssignmentThreadClass
    private String ThrNum;
    
    public AssignmentThread(String t){
        this.ThrNum = t;
        //constructor
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Thread =  " +ThrNum);
        processThread();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processThread() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.ThrNum;
    }
}