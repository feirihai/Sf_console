package 字符串的排列;
import java.util.ArrayList;
import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        char a[]=str.toCharArray();
        ArrayList<String> arr=new ArrayList<String>();
        if(str==null||str.length()==0)
            return arr;
        Per(a,0,arr);
        Collections.sort(arr);
        return arr;
    }

    public void Per(char a[],int i, ArrayList<String> arr){
        int len=a.length;
        if(i==len-1){
            arr.add(String.valueOf(a));
            return;
        }
        Per(a,i+1,arr);
        for(int m=i+1;m<len;m++){
            if(a[m]!=a[i]){
                char temp=a[m];
                a[m]=a[i];
                a[i]=temp;
                Per(a,i+1,arr);
                temp=a[m];
                a[m]=a[i];
                a[i]=temp;
            }
        }
    }

    public static void main(String[] args) {
        String a = "abc";
        Solution solution = new Solution();
        solution.Permutation(a);
    }
}