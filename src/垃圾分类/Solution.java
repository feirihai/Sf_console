package 垃圾分类;

import java.util.*;

public class Solution {
    public static int getMix(int n , int m){
        if (n >500||n < 0){
            return 0;
        }
        Scanner scanner = new Scanner(System.in);
        Map A = new HashMap();
        Map B = new HashMap();
        String []rules = new String[m];
        for (int i = 0 ;i < m ; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a>n||a<1||b > n||b<1){
                return 0;
            }
            String rule = a+"-"+b;
            rules[i] = rule;
        }
        for (int i = 1 ; i <= n ; i++){
            for (int j = 0 ; j < rules.length ; j++){
                List list1 = Arrays.asList(rules[0].split("-"));
                List list2 = Arrays.asList(rules[1].split("-"));
                String a1 = (String) list1.get(0);
                String a2 = (String) list1.get(1);
                String a3 = (String) list2.get(0);
                String a4 = (String) list2.get(1);
                if (a1.contains(i+"")|| a2.contains(i+"")||a3.contains(i+"")|| a4.contains(i+"")){
                    if (A.containsKey(list1.get(0))||B.containsKey(list1.get(1))||A.containsKey(list1.get(1))||B.containsKey(list1.get(0))){
                        if (A.containsKey(list1.get(0))||A.containsKey(list1.get(1))){
                            if (A.containsKey(list1.get(0))){
                                B.put((String)list1.get(1),list1.get(1));
                            }else {
                                B.put((String)list1.get(0),list1.get(0));
                            }
                        }
                        if (B.containsKey(list1.get(0))||B.containsKey(list1.get(1))){
                            if (B.containsKey(list1.get(0))){
                                A.put((String)list1.get(1),list1.get(1));
                            }else {
                                A.put((String)list1.get(0),list1.get(0));
                            }
                        }

                    }else {
                        A.put((String)list1.get(0),list1.get(0));
                        B.put((String)list1.get(1),list1.get(1));
                    }
                }else {
                    if (!A.containsKey(i+"")&&!B.containsKey(i+"")){
                        if (A.size()<=B.size()){
                            A.put(i+"",i);
                        }
                        else{
                            B.put(i+"",i);
                        }
                    }

                }
            }
        }
        int a = Math.min(A.size(),B.size());
        return a*2;
    }

    public static void main(String[] args) {
        int a = getMix(5,2);
        System.out.println(a);
    }
}
