import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [백준] 2671번 잠수함식별
 */
public class N2671 {
    public static void main(String args[]) throws IOException {
        // 입력 값 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        sb.append(br.readLine().matches("(100+1+|01)+") ? "SUBMARINE" : "NOISE").append("\n");
        System.out.print(sb.toString());
    }
}
