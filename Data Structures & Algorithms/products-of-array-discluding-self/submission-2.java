class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] leftArray = new int[n];
        int[] rightArray = new int[n];
        Arrays.fill(leftArray, 1);
        Arrays.fill(rightArray, 1);
        int left = 0, right = n-1, leftProd = 1, rightProd = 1;

        for(int i = 0; i < n; i++){
            leftArray[left + i] = leftProd;
            rightArray[right-i] = rightProd;

            leftProd *= nums[left+i];
            rightProd *= nums[right - i];
        }

        for(int i = 0;i < n; i++){
            ans[i] = leftArray[i] * rightArray[i];
        }
        return ans;
    }
}  
