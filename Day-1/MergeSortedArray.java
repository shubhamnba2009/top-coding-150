class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cnt = nums1.length-1;
        n=n-1;m=m-1;
        while(n>=0&&m>=0)
        {
            if(nums1[m]>nums2[n])
                nums1[cnt--] = nums1[m--];
            else
                nums1[cnt--] = nums2[n--];
        }
        while(n>=0)
            nums1[cnt--] = nums2[n--];
    }
}
public class MergeSortedArray {
    public static void main(String[] args) {
        // Sample input arrays
        int[] nums1 = new int[6]; // Assuming nums1 has enough capacity to merge nums2
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        int m = 3;

        int[] nums2 = { 2, 4, 6 };
        int n = 3;

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Merge nums2 into nums1
        solution.merge(nums1, m, nums2, n);

        // Print the merged array
        System.out.print("Merged Array: ");
        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
    }
}