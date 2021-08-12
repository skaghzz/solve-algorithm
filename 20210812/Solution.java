class Solution {
    /*
    1 -> 0..1
    2 -> 0..2
    3 -> 1..0 -> -1 -> 0..0
    
    5 /3 = 1..2, 1/3 = 0..1 => 12
    11/3 = 3..2, 3/3 = 1..0 (-1) 0..0 => 32(42)
    12/3 = 4..0 (-1) 3..0, 3/3 = 1..0 (-1) 0..0 => 33(44)
    */
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        int[] numberMap = {4, 1, 2};
        while(n > 0) {
            sb.append(numberMap[n%3]);
            n = n/3 - ((n%3 == 0) ? 1:0);
        }
        sb.reverse();
        return sb.toString();
    }
}