import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 5052번 전화번호 목록
 */
public class Main {
    public static void main(String args[]) throws IOException {
        // 입력 값 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<String> telNoList = new ArrayList<>(N);

            for(int n =0; n < N; n++) {
                String telNo = br.readLine();
                //System.out.println(telNo);
                telNoList.add(telNo);

            }
            Collections.sort(telNoList);
            System.out.println(checkPrefix(telNoList));
        }
    }

    private static String checkPrefix(ArrayList<String> telNoList) {
        // System.out.println(telNoList);
        for(int n =0; n < telNoList.size()-1; n++) {
            if(telNoList.get(n+1).startsWith(telNoList.get(n))) {
                return "NO";
            }
        }
        return "YES";
    }
}
