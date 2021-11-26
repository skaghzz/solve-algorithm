import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] persons1pattern = new int[]{1, 2, 3, 4, 5};
        int person1Count = 0;
        int[] persons2pattern = new int[]{2,1,2,3,2,4,2,5};
        int person2Count = 0;
        int[] persons3pattern = new int[]{3,3,1,1,2,2,4,4,5,5};
        int person3Count = 0;


        for(int i = 0; i < answers.length; i++) {
            if (persons1pattern[i % persons1pattern.length] == answers[i % answers.length]) {
                person1Count++;
            }
            if (persons2pattern[i % persons2pattern.length] == answers[i % answers.length]) {
                person2Count++;
            }
            if (persons3pattern[i % persons3pattern.length] == answers[i % answers.length]) {
                person3Count++;
            }
        }

        int maxCount = Math.max(person1Count, Math.max(person2Count, person3Count));

        ArrayList<Integer> count = new ArrayList<>();
        if (maxCount == person1Count) {
            count.add(1);
        }
        if (maxCount == person2Count) {
            count.add(2);
        }
        if (maxCount == person3Count) {
            count.add(3);
        }

        int[] winner = new int[count.size()];
        for(int i = 0; i < winner.length; i++) {
            winner[i] = count.get(i);
        }
        return winner;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        int[] b = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(a.solution(b)));
    }
}

