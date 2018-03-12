import java.util.Random;

public class SomeStructure {
    int [] tab;
    int size_maks=1000;
    SomeStructure()
    {
        tab=new int[size_maks];
        Random generator = new Random();
        for(int i=0;i<size_maks;i++)
        {
            tab[i]=generator.nextInt();
        }
    }
    public int Maks(){
        int maks = tab[0];
        for(int i =1;i<size_maks;i++) {
            if(tab[i]>maks){
                maks=tab[i];
            }
        }
        return maks;
    }
    public int Sum(){
        int sum=0;
        for (int i =0;i<size_maks;i++){
            sum+=tab[i];
        }

        return sum;
    }
}
