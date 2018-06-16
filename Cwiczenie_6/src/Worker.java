import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Worker {
    WorkerListener workerListener;
    private boolean working,started,toStop;
    private  String workerName;
    private HashMap<String,Task> tasks;
    private Queue<HashMap<String,Task>> tasksQ;
    private  NewThread thread;
    Worker(String workerName){
        this.workerName=workerName;
        tasks=new HashMap<String,Task>();
        started=false;
        working=false;
        toStop=false;
    }
    public  void  enqueueTask(String taskName, Task task){
        tasks.put(taskName,task);
    }
    public  void start(){
        if(!started) {
            started = true;
            int i = 1;
            for (Map.Entry<String, Task> entry : tasks.entrySet()) {
                thread = new NewThread(entry.getValue(), entry.getKey());

                if(working==false) {


                    thread.start();
                    working = true;
                }
                else
                {
                    try {
                        thread.wait();
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }

    }}
    public void stop(){toStop=true;}
    void setListener(WorkerListener workerListener){
        this.workerListener=workerListener;
    }
    public boolean isStarted(){return started;}
    boolean isWorking(){return working;}
}
