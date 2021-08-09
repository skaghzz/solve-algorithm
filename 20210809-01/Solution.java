class Solution {
    public String solution(int[][] scores) {
        StringBuffer sb = new StringBuffer();
        int N = scores.length;
        
        for(int j=0; j< N; j++) {
            int myScore = scores[j][j];
            double myTotalScore = 0;
            boolean isHighestScore = true;
            boolean isLowestScore = true;
            boolean isSameScore = false;
            for(int i=0; i < N; i++) {
                myTotalScore += scores[i][j];
                if(myScore > scores[i][j]){
                    isHighestScore = false;
                }
                if(myScore < scores[i][j]){
                    isLowestScore = false;
                }
                if(i != j && myScore == scores[i][j]) {
                    isSameScore = true;
                }
            }
            int studentCnt = N;
            if(!isSameScore && (isHighestScore || isLowestScore)) {
                myTotalScore -= myScore;
                studentCnt--;
            }
            sb.append(scoreToRank(myTotalScore/studentCnt));
        }
        
        return sb.toString();
    }
    
    public char scoreToRank(double score) {
        if(score >= (double) 90)
            return 'A'; 
        if(score >= (double) 80)
            return 'B';
        if(score >= (double) 70)
            return 'C';
        if(score >= (double) 50)
            return 'D';
        return 'F';
    }
}