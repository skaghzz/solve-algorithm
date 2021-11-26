import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        for(int i = 0; i<numbers.length(); i++) {
            boolean[] visited = new boolean[numbers.length()];
            visited[i] = true;
            combination(1, String.valueOf(numbers.charAt(i)), numbers, visited);
        }

        return set.size();
    }

    public void combination(int depth, String s, String numbers, boolean[] visited) {
        if (depth > numbers.length()) {
            return;
        }

        if (depth > 0) {
            int n = Integer.parseInt(s);
            //System.out.println(s);
            if (isPrime(n)) {
                set.add(n);
            }
        }

        for(int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(depth + 1, s + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String numbers = "0123";
        System.out.println(s.solution(numbers));
    }
}