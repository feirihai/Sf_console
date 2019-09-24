package 寻找两个有序数组的中位数;

public class Soluction {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int []num = new int[nums1.length+nums2.length];
        int i = 0;
        if (nums1.length!=0&&nums2.length!=0){
            int j = 0,k = 0;
            while (i < nums1.length+nums2.length){
                if (j >= nums1.length && k < nums2.length){

                    num[i] = nums2[k];
                    k++;
                }
                if (k >= nums2.length && j < nums1.length){

                    num[i] = nums1[j];
                    j++;
                }
                if (j < nums1.length&&k < nums2.length){
                    int im1 = nums1[j];
                    int im2 = nums2[k];
                    if (im1<im2){
                        num[i] = nums1[j];
                        j++;
                    }else{
                        num[i] = nums2[k];
                        k++;
                    }
                }

                i++;
            }
            int index = num.length;
            if (index%2 == 0){
                int h2 = index/2;
                int h1 = index/2 - 1;
                double h3 = (num[h1]+num[h2])/2.0;
                return h3;
            }else {
                int c = index/2;
                double h1 = num[c];
                return h1;
            }
        }else{
            if (nums1.length==0&&nums2.length==0){
                return 0;
            }
            if (nums1.length!=0){
                num = nums1;
            }
            if (nums2.length!=0){
                num = nums2;
            }
            int index = num.length;
            if (index%2 == 0){
                int h2 = index/2;
                int h1 = index/2 - 1;
                double h3 = (num[h1]+num[h2])/2.0;
                return h3;
            }else {
                int c = index/2;
                if (c==1){
                    c = 0;
                }
                double h1 = num[c];
                return h1;
            }
        }
    }

    public static void main(String[] args) {
        int []a1 = new int[]{};
        int []a2 = new int[]{1,2,3,4,5};
        double a = findMedianSortedArrays(a1,a2);
        System.out.println(a);
    }
}
