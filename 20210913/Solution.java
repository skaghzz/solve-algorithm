import java.util.*;

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        List<Boxer> boxers = new ArrayList<>();
        int N = weights.length;
        for (int i = 0; i < N; i++) {
            int totalGameCnt = 0;
            int winGameCnt = 0;
            int winHeavyCnt = 0;
            for (int j = 0; j < N; j++) {
                if (head2head[i].charAt(j) == 'N') {
                } else if (head2head[i].charAt(j) == 'W') {
                    totalGameCnt++;
                    winGameCnt++;
                    if (weights[i] < weights[j]) {
                        winHeavyCnt++;
                    }
                } else if (head2head[i].charAt(j) == 'L') {
                    totalGameCnt++;
                }
            }
            if (totalGameCnt == 0) {
                boxers.add(new Boxer(i + 1, 0, winHeavyCnt, weights[i]));
            } else {
                boxers.add(new Boxer(i + 1, (double) winGameCnt / totalGameCnt, winHeavyCnt, weights[i]));
            }
        }
        System.out.println(boxers.toString());

        boxers.sort(new Comparator<Boxer>() {
            @Override
            public int compare(Boxer b1, Boxer b2) {
                if (b1.winRate > b2.winRate) {
                    return -1;
                } else if (b1.winRate < b2.winRate) {
                    return 1;
                } else {
                    if (b1.winHeavy > b2.winHeavy) {
                        return -1;
                    } else if (b1.winHeavy < b2.winHeavy) {
                        return 1;
                    } else {
                        if (b1.weight > b2.weight) {
                            return -1;
                        } else if (b1.weight < b2.weight) {
                            return 1;
                        } else {
                            if (b1.num < b2.num) {
                                return -1;
                            } else if (b1.num > b2.num) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        });
        System.out.println(boxers.toString());

        int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = boxers.get(i).num;
        }
        return answer;
    }

    class Boxer {
        int num;
        double winRate;
        int winHeavy;
        int weight;

        Boxer(int num, double winRate, int winHeavy, int weight) {
            this.num = num;
            this.winRate = winRate;
            this.winHeavy = winHeavy;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "num : " + num + ", winRate : " + winRate + ", winHeavy : " + winHeavy + ", weight : " + weight
                    + "\n";
        }
    }
}