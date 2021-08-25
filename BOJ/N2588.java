import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [백준] 2588번 곱셈
 */
public class N2588 {
    public static void main(String args[]) throws IOException {
        // 입력 값 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int preNumber = Integer.parseInt(br.readLine());
        String postNumber = br.readLine();
        
        StringBuffer sb = new StringBuffer();
        sb.append(preNumber * (postNumber.charAt(2) - '0') ).append('\n');
        sb.append(preNumber * (postNumber.charAt(1) - '0') ).append('\n');
        sb.append(preNumber * (postNumber.charAt(0) - '0') ).append('\n');
        sb.append(preNumber * Integer.parseInt(postNumber)).append('\n');
        System.out.print(sb.toString());
    }
}
