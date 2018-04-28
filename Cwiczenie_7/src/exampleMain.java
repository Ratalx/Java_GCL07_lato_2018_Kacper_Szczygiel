import java.io.*;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class exampleMain {
    public static void main(String[] args){
        Random generator= new Random();
        String pathIE = "cos.csv";
        String pathSRE ="cos.sre";
        ExtendedSystemCache cache=new ExtendedSystemCache();
        double input[] = {1,3.23,31.32,213.5,123.21,423.52,0.213};
       // for (int i =0;i<input.length;++i)
        //{
           // input[i]=generator.nextDouble();
        //}
        if(new File(pathSRE).exists())
        {
            try{
                cache.deserialize(new FileInputStream(pathSRE));
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
        /*if(new File(pathIE).exists()) {
            try {
                cache.importCSV(pathIE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        Double output=null;
        try {

             output = cache.get(input);
        }
        catch (NullPointerException e)
        {

        }
        System.out.println(output);
        if(output==null)
        {
            System.out.println(" Tworze nowe wyniki ");
            output = makeOperation(input);
            cache.put(input,output);
        }

          try {
            cache.exportCSV(new File(pathIE));
            cache.serialize(new FileOutputStream(pathSRE));
        }
         catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static double makeOperation(double[] input)
    {
        double output=0;
        for (double i:input) {
            output+=i;
        }
        //output = input *2.5;
        return output;
    }

}

