public class Calculator {

    public static String operator = "add";

    public static int add(int num1,int num2){
        return num1+num2;
    }

    public static void throwError(){
        throw new NullPointerException();
    }



}
