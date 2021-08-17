import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [백준] 12904번 A와 B
 */
public class N12904 {
    public static int flag = 0;

    public static void main(String args[]) throws IOException {
        // 입력 값 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        StringBuffer sbT = new StringBuffer(T);
        for (int t = 0; t < T.length() - S.length(); t++) {
            int lastIndex = sbT.length() - 1;
            if (sbT.charAt(lastIndex) == 'A') {
                sbT.deleteCharAt(lastIndex);
            } else if (sbT.charAt(lastIndex) == 'B') {
                sbT.deleteCharAt(lastIndex);
                sbT.reverse();
            }
        }
        System.out.println(sbT.toString().equals(S) ? '1' : '0');
    }
}
