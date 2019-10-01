package 十进制转十五进制;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String getFifteen(int ten){
        if (ten>Integer.MAX_VALUE||ten<Integer.MIN_VALUE){
            return "";
        }
        if (Math.abs(ten) < 15){
            return ten+"";
        }else{
            int flag = Math.abs(ten);
            if (ten < 0)
                return "-" + new StringBuilder(get(flag)).reverse().toString();
            else
                return new StringBuilder(get(ten)).reverse().toString();
        }
    }

    public static String get(int ten){
        String flag;
        String result = "";
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(10,"A");
        map.put(11,"B");
        map.put(12,"C");
        map.put(13,"D");
        map.put(14,"E");
        while (ten > 15){
            int  a = ten % 15;
            if(map.containsKey(a)){
                flag = map.get(a);
            }else {
                flag =a +"";
            }
            result+=flag;
            ten = ten / 15;
        }
        int a1 = ten % 15;
        int a2 = ten/15;
        if (a2 == 0){
            result+=map.containsKey(a1)?map.get(a1):a1+"";
        }else {
            result+=map.containsKey(a1)?map.get(a1):a1+""+Integer.toString(a2);
        }



    return result;
    }

    public static void main(String[] args) {
        String a = getFifteen(200);
        System.out.println(a);
    }
}
