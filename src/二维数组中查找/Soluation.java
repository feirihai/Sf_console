package 二维数组中查找;

import java.util.HashSet;
import java.util.Set;

public class Soluation {
    public static boolean Find(int target, int [][] array) {
        Set set = new HashSet();
        for (int i = 0 ; i < array.length ; i++){
            for (int j = 0 ; j < array[i].length ; j++){
                set.add(array[i][j]);
            }
        }
        set.contains(target);
        return set.contains(target);
    }
    //遍历每一行，然后二分
    public boolean Find(int [][] array,int target) {

        for(int i=0;i<array.length;i++){
            int low=0;
            int high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(target>array[i][mid])
                    low=mid+1;
                else if(target<array[i][mid])
                    high=mid-1;
                else
                    return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        int [][]a = new int[][]{{1,3,5},{2,4,6}};
        System.out.println(Find(5,a));
    }
}
