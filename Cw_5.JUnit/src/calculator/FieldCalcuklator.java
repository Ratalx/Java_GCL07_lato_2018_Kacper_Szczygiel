package calculator;

public class FieldCalcuklator {
   public static double calculateSquare(double a)throws IllegalArgumentException{
       if(a<=0){
           throw new IllegalArgumentException();
       }
        return(a*a);
    }
    public static double calculateCircle(double R)throws IllegalArgumentException{
       if(R<=0)
       {
           throw new IllegalArgumentException();
       }
        return(Math.PI*R*R);

    }
    public static double calculateTriangle(double a,double h)throws IllegalArgumentException{
       if(a<=0 || h<=0)
       {
           throw new IllegalArgumentException();
       }
        return((a*h)/3);
    }
    public static double calculateRectangle(double a, double b)throws IllegalArgumentException{
       if(a<=0||b<=0)
       {
           throw  new IllegalArgumentException();
       }
        return(a*b);
    }

}
