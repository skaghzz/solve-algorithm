import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickNameMap = new HashMap<String, String>();
        ArrayList<Info> inOutList = new ArrayList<Info>();
        for (String r : record) {
            String[] token = r.split("\\s");
            if (token[0].equals("Enter")) {
                nickNameMap.put(token[1], token[2]);
                inOutList.add(new Info(token[1], token[0]));
            } else if (token[0].equals("Leave")) {
                inOutList.add(new Info(token[1], token[0]));
            } else if (token[0].equals("Change")) {
                nickNameMap.replace(token[1], token[2]);
            }
        }

        String[] answer = new String[inOutList.size()];
        for (int i = 0; i < inOutList.size(); i++) {
            answer[i] = nickNameMap.get(inOutList.get(i).userId) + inOutList.get(i).getInAndOutMsg();
        }
        return answer;
    }

    class Info {
        public String userId;
        public String inAndOut;

        public Info(String userId, String inAndOut) {
            this.userId = userId;
            this.inAndOut = inAndOut;
        }

        public String getInAndOutMsg() {
            if (this.inAndOut.equals("Enter")) {
                return "님이 들어왔습니다.";
            } else if (this.inAndOut.equals("Leave")) {
                return "님이 나갔습니다.";
            }
            return "";
        }
    }
}