package wechat.wechatTest;



import java.util.*;

public class Huawei {



    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        //in.next();
        String str = "[[20,16],[15,11],[10,10],[9,10]]";
        str = str.substring(2,str.length()-2);
        String[] strings = str.split("],");
        for (int i = 1; i < strings.length; i++){
            strings[i] = strings[i].substring(1, strings[i].length());
        }
        int res = 1;
        for (int i = 0; i < strings.length - 1 ; i++){
            String[] s1 = strings[i].split(",");
            String[] s2 = strings[i+1].split(",");
            if (Integer.parseInt(s1[0]) > Integer.parseInt(s2[0]) &&  Integer.parseInt(s1[1]) > Integer.parseInt(s2[1])){
                res++;
            }
        }
        System.out.println(res);
    }

}
