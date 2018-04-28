import examples.SystemCache;

import java.io.*;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ExtendedSystemCache extends SystemCache implements Serializable{
    //export functions
    void exportCSV(String path) throws IOException {
       /* FileWriter out = null;
            out = new FileWriter(path, true);
            ObjectOutputStream obOut = new ObjectOutputStream(new FileOutputStream(path));
            obOut.writeObject(cache);*/

    }
    void exportCSV(File file) throws  IOException{
            file.setWritable(true);
            Writer out = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<Parameter,Double>entry:cache.entrySet())
            {
                //String s = String.valueOf(entry.getKey().getValues().length);
                //out.write(s +',');
                for (double i:entry.getKey().getValues())
                {
                    out.write(Double.toString(i)+',');
                }
                out.write("_"+entry.getValue().toString());
            }
            out.close();
    }
    void exportCSV(OutputStream stream) throws IOException{
        //Properties properties = new Properties();
        ObjectOutputStream obOut= new ObjectOutputStream(stream);
        for(Map.Entry<Parameter,Double>entry:cache.entrySet())
        {
            for (double i : entry.getKey().getValues()) {
                obOut.writeChars(Double.toString(i) + ',');

            }

            obOut.writeChars("_,"+entry.getValue().toString()+',');
        }
        //properties.store(obOut,null);
        obOut.close();
    }

    //import functions
    void importCSV(String path) throws IOException{
        FileReader in =null;
        in = new FileReader(path);
        String rawText="";
        int c;
        while ((c=in.read()) !=-1)
        {
            rawText+=(char)c;
        }
        String[] input =rawText.split(",");

        double[] temp = new double[input.length-1];
        int i=0;
        for (;i<temp.length;++i)
        {
            temp[i]=Double.parseDouble(input[i]);
        }
        double value = Double.parseDouble(input[i].substring(1));

        cache.put(new Parameter(temp),value);
    }
    void importCSV(File file) throws IOException{

    }
    void importCSV(InputStream stream) throws IOException{
        ObjectInputStream obIn =new ObjectInputStream(stream);
           int length=obIn.readInt();
           double[] temp=new double[length];
           System.out.println(length);
            //cache.putAll(a);

    }
    //serialize
    void serialize(String path) throws IOException{

    }
    void serialize(File file) throws IOException{

    }

    void serialize(OutputStream stream) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(stream)) {
            outputStream.writeObject(cache);
            outputStream.close();
            System.out.println("Serialize");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    void deserialize(String path) throws IOException{

    }

    void deserialize(File file) throws IOException{

    }

    void deserialize(InputStream stream) throws IOException {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(stream);
            cache = (HashMap<Parameter, Double>) inputStream.readObject();
            inputStream.close();
            System.out.println("Deserialize");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
