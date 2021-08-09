class Solution {
    public long solution(int price, int money, int count) {
        long totalPrice = (count+1L) * count * price / 2;
        long ans = totalPrice - money;
        if(ans >= 0) {
            return ans;
        } else {
            return 0;
        }
    }
}