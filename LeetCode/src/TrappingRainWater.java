class TrappingRainWater{
    public int trap(int[] height){
        int left = 0, right = height.length - 1, lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE, ans = 0;
        while(right > left){
            if(height[left] < height[right]){
                if (height[left] >= lMax) lMax = height[left];
                else ans += lMax - height[left];
                left++;
            }else{
                if (height[right] >= rMax) rMax = height[right];
                else ans += rMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
