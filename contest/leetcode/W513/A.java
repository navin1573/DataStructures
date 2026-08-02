class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        long max = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                long nume=(long)nums[i]*nums[j];
                long deno=(long)gcd(nums[i],nums[j]);
                 ans = nume / (deno*deno);
                 max = Math.max(ans,max);
            }
        }
        return max;
    }
    static int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
