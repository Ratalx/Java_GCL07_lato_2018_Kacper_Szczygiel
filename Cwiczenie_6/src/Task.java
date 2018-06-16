public interface Task extends Runnable {
   void run( int taskNumber ) throws InterruptedException;
}
