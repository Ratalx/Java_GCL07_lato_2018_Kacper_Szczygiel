public class NewThread extends Thread implements Task {
    NewThread()
    {
        super();
    }
    NewThread(Runnable target,String name)
    {
        super(target,name);
    }
    public boolean toStop;
    public void run(int taskNumber) throws InterruptedException {
    run();
    }
    public void run() {
        toStop=false;
        int i=0;
        this.setName(super.getName());
        System.out.println("Nowy watek - " +this.getName()+" : POCZATEK");
        try {
            while (toStop==false){
                System.out.println(this.getName() +" : " + i);
                Thread.sleep(1000);
                i++;
                if(i==10)
                    toStop=true;
            }
        } catch (InterruptedException e) {
        }
        System.out.println(this.getName()+ " : KONIEC");
        notifyAll();
    }
}
