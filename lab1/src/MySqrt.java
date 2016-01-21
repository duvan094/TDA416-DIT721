import java.util.Scanner;

/**
 * Created by Jacob on 2016-01-21.
 */
public class MySqrt {


    /**
     * En metod som räknar ut roten av ett tal x.
     * @param x
     * @param epsilon
     * @return
     */
    public static double mySqrtLoop(double x, double epsilon){
        double yMIN,yMAX,yMITT;

        //Är x mindre än 0?
        if(x<0){
            return Double.NaN;
        }


        if((0<= x) && (x<=1)){
            yMIN = x;
            yMAX = 1;
            yMITT = (yMIN+yMAX)/2;
        }else{

            yMIN = 1;
            yMAX = x;
            yMITT = (yMIN+yMAX)/2;
        }



        while(Math.abs(yMITT*yMITT-x) >= epsilon){

            if(((yMITT*yMITT)-x) > 0){

                yMAX = yMITT;
                yMITT = (yMIN+yMAX)/2;

            }else{

                yMIN = yMITT;
                yMITT = (yMIN+yMAX)/2;

            }

        }

        return yMITT;
    }

    public static double mySqrtRecurse(double x, double epsilon){
        double yMIN,yMAX;

        if(x<0){
            return Double.NaN;
        }

        if((0<= x) && (x<=1)){
            yMIN = x;
            yMAX = 1;
        }else{
            yMIN = 1;
            yMAX = x;
        }

        return recurseHelper(x,epsilon, yMIN, yMAX);
    }

    public static double recurseHelper(double x, double epsilon, double yMIN, double yMAX){
        double yMITT = (yMIN+yMAX)/2;

        if(Math.abs(yMITT*yMITT-x) < epsilon){
            return yMITT;
        }

        if(((yMITT*yMITT)-x) > 0){

            yMAX = yMITT;

        }else{

            yMIN = yMITT;

        }



        return recurseHelper(x,epsilon,yMIN,yMAX);
    }



    public static void main(String[] args){

        double epsilon = Math.pow(10,-6);
        double x1 = 25;
        double x2 = 0;
        double x3 = 0.36;
        double x4 = 1;
        double x5 = -10;

        System.out.println("=========== Root with loop ==========="+"\n");

        System.out.println("=========== TEST 1 ===========");
        System.out.println("sqrt("+x1+") = " + Math.sqrt(x1));
        System.out.println("METHOD RESULT: " + mySqrtLoop(x1, epsilon)+"\n");

        System.out.println("=========== TEST 2 ===========");
        System.out.println("sqrt("+x2+") = " + Math.sqrt(x2));
        System.out.println("METHOD RESULT: " + mySqrtLoop(x2, epsilon)+"\n");

        System.out.println("=========== TEST 3 ===========");
        System.out.println("sqrt("+x3+") = " + Math.sqrt(x3));
        System.out.println("METHOD RESULT: " + mySqrtLoop(x3, epsilon)+"\n");

        System.out.println("=========== TEST 4 ===========");
        System.out.println("sqrt("+x4+") = " + Math.sqrt(x4));
        System.out.println("METHOD RESULT: " + mySqrtLoop(x4, epsilon)+"\n");

        System.out.println("=========== TEST 5 ===========");
        System.out.println("sqrt("+x5+") = " + Math.sqrt(x5));
        System.out.println("METHOD RESULT: " + mySqrtLoop(x5, epsilon)+"\n");

        System.out.println("\n=========== Root with recursion ==========="+"\n");

        System.out.println("=========== TEST 1 ===========");
        System.out.println("sqrt("+x1+") = " + Math.sqrt(x1));
        System.out.println("METHOD RESULT: " + mySqrtRecurse(x1, epsilon)+"\n");

        System.out.println("=========== TEST 2 ===========");
        System.out.println("sqrt("+x2+") = " + Math.sqrt(x2));
        System.out.println("METHOD RESULT: " + mySqrtRecurse(x2, epsilon)+"\n");

        System.out.println("=========== TEST 3 ===========");
        System.out.println("sqrt("+x3+") = " + Math.sqrt(x3));
        System.out.println("METHOD RESULT: " + mySqrtRecurse(x3, epsilon)+"\n");

        System.out.println("=========== TEST 4 ===========");
        System.out.println("sqrt("+x4+") = " + Math.sqrt(x4));
        System.out.println("METHOD RESULT: " + mySqrtRecurse(x4, epsilon)+"\n");

        System.out.println("=========== TEST 5 ===========");
        System.out.println("sqrt("+x5+") = " + Math.sqrt(x5));
        System.out.println("METHOD RESULT: " + mySqrtRecurse(x5, epsilon)+"\n");



        /*Scanner scanner = new Scanner(System.in);

        System.out.println("Write number you wish to square: ");
        double x = Double.parseDouble(scanner.nextLine());

        System.out.println("Write epsilon: ");
        double epsilon = Double.parseDouble(scanner.nextLine());

        System.out.println("Result: " + mySqrtLoop(x, epsilon));
        System.out.println("Write number you wish to square: ");
        double x = Double.parseDouble(scanner.nextLine());

        System.out.println("Write epsilon: ");
        double epsilon = Double.parseDouble(scanner.nextLine());

        System.out.println("Result: " + mySqrtRecurse(x, epsilon));
        */
    }

}
