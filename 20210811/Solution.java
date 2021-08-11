class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        // 인자로 전달된 picture를 변경하면 오류발생, 배열 복사
        int[][] newPicture = new int[picture.length][picture[0].length];
        for(int i=0; i<picture.length; i++) {
            for(int j=0; j<picture[i].length; j++) {
                newPicture[i][j] = picture[i][j];  
            }
        }
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for(int i=0; i < m; i++) {
            for(int j=0; j<n; j++) {
                if(newPicture[i][j] > 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(newPicture[i][j],i,j,m,n,newPicture,0));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    /**
     * 
     * @param color 탐색 색깔
     * @param i 현재 행 위치
     * @param j 현재 열 위치
     * @param m 총 행 개수
     * @param n 총 열 개수
     * @param picture 컬러링 현황이 있는 2차원 배열
     * @param cnt 탐색한 영역 크기
     * @return 탐색한 영역 크기
     */
    public int dfs(int color, int i, int j, int m, int n, int[][] picture, int cnt) {
        if(i < 0 || i >= m || j < 0 || j >= n) {    // boundary check
            return cnt;
        }
        if(picture[i][j] <= 0 || picture[i][j] != color) {  // 컬러링 영역 여부 확인, 탐색중인 컬러 여부 확인
            return cnt;
        }
        picture[i][j] = -1; // -1는 visited를 의미한다
        cnt++;
        cnt = dfs(color, i+1, j,m,n, picture, cnt);
        cnt = dfs(color, i-1, j,m,n, picture, cnt);
        cnt = dfs(color, i, j+1,m,n, picture, cnt);
        cnt = dfs(color, i, j-1,m,n, picture, cnt);
        return cnt;
    }
}