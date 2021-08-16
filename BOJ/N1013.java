import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [백준] 1013번 Contact
 */
public class N1013 {
    public static void main(String args[]) throws IOException {
        // 입력 값 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0 ) {
            sb.append(br.readLine().matches("(100+1+|01)+") ? "YES" : "NO").append("\n");
        }
        System.out.print(sb.toString());
    }
}
