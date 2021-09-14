import java.util.*;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int N = enter.length;
        Set<Integer> room = new HashSet<>();
        Map<Integer, Integer> meetCnt = new HashMap<>();
        Queue<Integer> inList = new LinkedList<Integer>();
        Queue<Integer> outList = new LinkedList<Integer>();
        for(int i = 0; i < N; i++) {
            inList.add(enter[i]);
            outList.add(leave[i]);
            meetCnt.put(i+1, 0);
        }

        while(!inList.isEmpty()) {
            int in = inList.poll();
            if(room.size() >= 1) {      // 이미 입실한 친구들은 새롭게 온 친구 1명을 만났다.
                room.forEach(humanNum -> {
                    meetCnt.put(humanNum,  meetCnt.get(humanNum) + 1);
                });
            }
            meetCnt.put(in, room.size());   // 새로 입실한 친구는 방에 있는 사람 수 만큼 만났다.
            room.add(in);
            //System.out.println(room.toString() + " || " + in + "번 in");

            while(!outList.isEmpty() && room.contains(outList.peek())) {
                int out = outList.poll();
                room.remove(out);
                //System.out.println(room.toString() + " || " + out + "번 out");
            }
        }

        int[] answer = new int[N];
        for(int i = 0 ; i < N ; i++) {
            answer[i] = meetCnt.get(i+1);
        }
        return answer;
    }
}