import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String args[]){

        List<SomeStructure> lista = new LinkedList<>();
        for(int i =0;i<1000;i++) {
            lista.add(new SomeStructure());
        }
        double start =System.nanoTime();
        SomeStructure a =Maks(lista);
        double end = System.nanoTime();

        System.out.format("Maksymalna suma kazdego elementu tablicy to %d",a.Maks());
        System.out.format("Czas trwania : %f sekund",(end-start)/1000000000);
    }
    public static SomeStructure Maks(List<SomeStructure> tab){
        SomeStructure maks=tab.get(0);
        for(int i =1;i<tab.size();i++){
            if(maks.Maks()>tab.get(i).Maks()){
                maks=tab.get(i);
            }
        }
        return maks;
    }
}
