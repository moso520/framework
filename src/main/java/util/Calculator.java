package util;

public class Calculator {
    public static int result = 0;

    public static int add(int x ,int y ) throws InterruptedException {
        result = x+y;
        Thread.sleep(1000);
        return result;
    }
    public  static int count(int x) throws InterruptedException {
        int i= result;
        Thread.sleep(1000);
        result = i + x;
        return result;
    }
    public synchronized static int synCount(int x) throws InterruptedException {
        int i= result;
        Thread.sleep(1000);
        result = i + x;
        return result;
    }
    public static int subtract(int x,int y) throws InterruptedException {
        result = x-y;
        Thread.sleep(1000);
        return result;
    }
    public static int multiply(int x,int y){
        result = x*y;
        return result;
    }
    public static int divide(int x,int y){
        result = x/y;
        return result;
    }
    public static void clear(){
        result =0;
        System.out.println("当前结果已清零！");
    }
    public static int counttest(int x) throws InterruptedException {
        int i = 0;
        Thread.sleep(1000);
        i += x;
        return i;
    }
}