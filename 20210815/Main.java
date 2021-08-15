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
        for(int n=0; n<N; n++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<Character>();
            for(int i=0; i<input.length(); i++) {
                if(input.charAt(i) ==')') {
                    if(stack.empty()) {
                        stack.push('E');
                        break;
                    }
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                } else {
                    stack.push(input.charAt(i));
                }
            }
            if(stack.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
