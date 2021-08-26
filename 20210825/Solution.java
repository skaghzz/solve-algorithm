import java.util.*;

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        HashMap<String, ArrayList> languageRankMap = new HashMap<>();
        for (int i = 0; i < table.length; i++) {
            String[] a = table[i].split("\\s");
            ArrayList<String> rank = new ArrayList<>();
            rank.add("");
            for (int j = a.length - 1; j > 0; j--) {
                rank.add(a[j]);
            }
            languageRankMap.put(a[0], rank);
        }

        String bestJob = "";
        int maxTotal = Integer.MIN_VALUE;
        for (String job : languageRankMap.keySet()) {
            ArrayList<String> rank = languageRankMap.get(job);
            int total = 0;
            for (int i = 0; i < languages.length; i++) {
                for (int j = 1; j < rank.size(); j++) {
                    if (rank.get(j).equals(languages[i])) {
                        total += preference[i] * j;
                    }
                }
            }
            System.out.println(job);
            System.out.println(total);
            if (total > maxTotal) {
                maxTotal = total;
                bestJob = job;
            }
            if (total == maxTotal) {
                if (bestJob.compareTo(job) > 0) {
                    bestJob = job;
                }
            }
        }

        return bestJob;
    }
}