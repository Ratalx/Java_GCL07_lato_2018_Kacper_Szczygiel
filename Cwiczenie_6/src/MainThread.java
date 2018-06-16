public class MainThread {
    public static void main(String args[]) {
        System.out.println("Main Thread:START ");
        System.out.println("Making Worker1");
        Worker worker1= new Worker("Worker1");
        NewThread newThread1=new NewThread();
        Task task1= newThread1;
        worker1.enqueueTask("Task1",task1);
        worker1.enqueueTask("Task2",task1);
        worker1.start();
    }
    public static void main2(String argv[]){

    }
}
