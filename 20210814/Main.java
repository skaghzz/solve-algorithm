import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // 입력 값 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += input.charAt(i) - '0';

        }
        System.out.println(answer);
    }
}
