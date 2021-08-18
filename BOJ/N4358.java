import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [백준] 4358번 생태학
 */
public class N4358 {
    public static void main(String args[]) throws IOException {
        // 입력 값 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> trees = new HashMap<>();
        String treeType = br.readLine();
        int totalTreeCount = 0;
        while (true) {
            trees.put(treeType, trees.getOrDefault(treeType, 0) + 1);
            totalTreeCount++;
            treeType = br.readLine();
            if (treeType == null || treeType.isBlank()) {
                break;
            }
        }

        ArrayList<String> treesList = new ArrayList<>();
        for (String key : trees.keySet()) {
            treesList.add(key);
        }
        Collections.sort(treesList);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < treesList.size(); i++) {
            double percent = (double) trees.get(treesList.get(i)) / (double) totalTreeCount * 100;
            sb.append(treesList.get(i)).append(' ').append(String.format("%.4f", percent)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
