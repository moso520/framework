package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class LeetCode {

    @Test
    void test(){
        ArrayList<Character> arrayList = new ArrayList<Character>();
        arrayList.add('a');
        arrayList.add('b');
        arrayList.add('c');
        arrayList.add('d');
        arrayList.add('e');
        arrayList.add('f');
        Iterator<Character> it = arrayList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            if (it.next() > 'e'){
                it.remove();
            }
        }
        System.out.println();
    }
}
