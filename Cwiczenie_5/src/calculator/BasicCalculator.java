package calculator;

public  class BasicCalculator {

    public static double calculateSum(double a, double b){
        return (a+b);
    }
    public static double caclulateDifference(double a, double b){
        return(a-b);
    }
    public static double calculateMultiplication(double a, double b){
        return (a*b);
    }
    public static double calculateDivision(double a,double b)throws IllegalArgumentException{
        if(b==0){
            throw new java.lang.IllegalArgumentException();
        }
        return(a/b);
    }
    public static double calculatePow(double a,double b){
        return Math.pow(a,b);
    }
    public static double calculateSqlr(double a) throws IllegalArgumentException
    {
        if(a<0){
            throw new java.lang.IllegalArgumentException();
        }
        return Math.sqrt(a);
    }
}
