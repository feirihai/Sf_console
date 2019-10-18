package 动态规划;

/**g购入
 * 算法的主要思想：每次遍历到第i个物品，
 * 根据w[i]和v[i]来确定是否要将该物品放入背包中
 *
 * 即对于给定的n个物品，设v[i]和w[i]分别为第i个物品的价值和重量，
 * c为背包容量，在令v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
 *
 * 1）v[i][0] = v[0][j] = 0;//填入表的第一行第一列为0
 * 2) 当w[i] > j 时：v[i][j] = v[i-1][j] //当准备加入新增的物品的容量大于当前背包容量时，就直接使用
 * 上一个单元格的装入策略
 * 3）当 j > w[i] 时: v[i][j] = max{v[i-1][j],v[i]+v[i-1][j-w[i]}
 * 当准备加入的新增商品的容量小于等于当前背包的容量，
 * v[i-1][j]  上一个单元格装入的最大值
 * v[i]       当前商品的价值
 * v[i-1][j-w[i]]    装入i-1商品，到剩余空间j-w[i]的最大值
 */
public class Solution {
    public static void main(String[] args) {
        int []w = {1,4,3};//物品的重量
        int []val = {1500,3000,2000};//物品的价值，这里的value就是前面讲的v[i]
        int m = 4;//背包的容量
        int n = val.length;//物品的个数
        //创建二维数组，表示
        int[][] v = new int[n+1][m+1];

        //为了记录放入商品的情况，我们定义一个二位数组
        int [][] path = new int[n+1][m+1];
        //初始化第一行，第一列
        for (int i = 0 ; i < v.length ; i++){
            v[i][0] = 0;//第一列设置为0；
        }
        for (int i = 0; i < v[0].length ; i++){
            v[0][i] = 0;//将第一行设置为0
        }
        //根据前面得到的公式动态规划处理
        for (int i = 1 ; i < v.length ; i++){//不处理第一行
            for (int j = 1 ; j < v[0].length; j++){//不处理第一列
                //公式
                if (w[i-1] > j){//因为程序i是从1开始的，因此原来公式的w[i] 修改成w[i-1]
                    v[i][j] = v[i-1][j];
                }else {
                    //因为我们的i是从1开始的，因此公式要修改为下面的形式
                    //v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    //为了记录商品存放到背包的情况，我们不能简单地使用上面的公式，需要使用if-else来体现
                    if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        //把当前情况记录到path
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }

        }
        //输出一下v，看一下当前情况
        /*for (int i = 0 ; i < v.length ; i++){
            for (int j = 0 ; j < v[i].length ; j++){
                System.out.println(v[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("============================================");

        //遍历path，这样输出会把所有的放入情况都得到，其实我们只需要最后的放入情况
        for (int i = 0 ; i < path.length ; i++){
            for (int j = 0 ; j < path[i].length; j++){
                if(path[i][j] == 1){
                    System.out.printf("第%d个商品放入到背包中\n",i);
                }
            }
        }
        */
        int i = path.length - 1;//行的最大下标
        int j = path[0].length - 1;//列的最大下标
        while (i > 0 && j > 0){//从path最后开始找
            if (path[i][j] == 1){
                System.out.printf("第%d个商品放入到背包中\n",i);
                j -= w[i-1];
            }
            i--;
        }


    }
}
