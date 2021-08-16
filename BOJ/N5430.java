import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [백준] 5430번 AC
 */
public class N5430 {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int RESULT_ERROR = 2;

    public static void main(String args[]) throws IOException {
        // 입력 값 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            char[] jobs = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            String x = br.readLine();
            String[] nn = x.substring(1, x.length() - 1).split("\\,");
            Deque<Integer> numbersList = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                numbersList.add(Integer.parseInt(nn[i]));
            }

            int checkResult = doJobs(jobs, numbersList);
            
            if (checkResult == RESULT_ERROR) {
                sb.append("error").append("\n");
                continue;
            }

            sb.append('[');
            if(!numbersList.isEmpty()){
                if (checkResult == LEFT) {
                    sb.append(numbersList.pollFirst());
                    while (!numbersList.isEmpty()) {
                        sb.append(',').append(numbersList.pollFirst());
                    }
                } else if (checkResult == RIGHT) {
                    sb.append(numbersList.pollLast());
                    while (!numbersList.isEmpty()) {
                        sb.append(',').append(numbersList.pollLast());
                    }
                }
            }
            sb.append(']').append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int doJobs(char[] jobs, Deque<Integer> numbersList) {
        int deleteDirection = LEFT;
        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i] == 'R') {
                deleteDirection = (deleteDirection == LEFT) ? RIGHT : LEFT;
            } else if (jobs[i] == 'D') {
                if (numbersList.isEmpty()) {
                    return RESULT_ERROR;
                }
                if (deleteDirection == LEFT) {
                    numbersList.pollFirst();
                } else {
                    numbersList.pollLast();
                }
            }
        }
        return deleteDirection;
    }
}
