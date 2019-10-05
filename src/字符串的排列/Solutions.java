package 字符串的排列;

import java.util.ArrayList;
import java.util.Collections;

public class Solutions {
    public ArrayList<String> Permutation(String str) {
        char a[]=str.toCharArray();
        ArrayList<String> arr=new ArrayList<String>();
        if(str==null||str.length()==0)
            return arr;
        Per(a,0,arr);
        Collections.sort(arr);
        return arr;
    }
    public void Per(char a[],int i , ArrayList<String> arr){
        int len = a.length-1;
        if (i == len){
            arr.add(String.valueOf(a));
            return;
        }
        Per(a,i+1,arr);
        for (int m = i+1 ; m < a.length ; m++){
            if (a[m]!=a[i]){
                char temp = a[m];
                a[m] = a[i];
                a[i] = temp;
                Per(a,i+1,arr);
                temp = a[m];
                a[m] = a[i];
                a[i] = temp;
            }
        }
    }
}
