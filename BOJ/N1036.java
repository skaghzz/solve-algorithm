import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/**
 * [백준] 1036번 36진수
 */
public class N1036 {
    public static void main(String args[]) throws IOException {
        // 입력 값 셋팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numbers = new String[N];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = br.readLine();
        }
        int K = Integer.parseInt(br.readLine());

        ArrayList<Value36> numList36 = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers[i].length() - 1; j >= 0; j--) {
                int pos = numbers[i].length() - 1 - j;
                //long num = (int) (charToNum(numbers[i].charAt(j)) * Math.pow(36, pos));
                BigInteger num = BigInteger.valueOf(36).pow(pos).multiply(charToNum(numbers[i].charAt(j)));
                //long changeValue = (int) (charToNum('Z') * Math.pow(36, pos) - num);
                BigInteger changeValue = BigInteger.valueOf(36).pow(pos).multiply(charToNum('Z')).subtract(num);
                numList36.add(new Value36(num, changeValue, numbers[i].charAt(j)));
            }
        }

        //System.out.println(numList36);

        BigInteger answer = BigInteger.ZERO;
        for (int i = 0; i < numList36.size(); i++) {
            answer = answer.add(numList36.get(i).num);
        }
        //System.out.println(answer);
        BigInteger[] changeValueArray = new BigInteger[36];
        for(int i = 0; i < changeValueArray.length; i++) {
            changeValueArray[i] = BigInteger.ZERO;
        }
        for (int i = 0; i < numList36.size(); i++) {
            int idx = charToNum(numList36.get(i).c).intValue();
            changeValueArray[idx] = changeValueArray[idx].add(numList36.get(i).changeValue);
        }
        Arrays.sort(changeValueArray);
        //System.out.println(Arrays.toString(changeValueArray));
        for (int i = 0; i < K; i++) {
            answer = answer.add(changeValueArray[changeValueArray.length - 1 - i]);
        }

        //System.out.println(answer);
        System.out.println(numToStr(answer));
    }

    static class Value36 {
        BigInteger num;
        BigInteger changeValue;
        char c;

        Value36(BigInteger num, BigInteger changeValue, char c) {
            this.num = num;
            this.changeValue = changeValue;
            this.c = c;
        }

        @Override
        public String toString() {
            return "num : " + num + ", changeValue : " + changeValue + ", char : " + c + "\n";
        }
    }

    public static String numToStr(BigInteger num) {
        StringBuffer sb = new StringBuffer();
        
        while (num.compareTo(BigInteger.valueOf(36)) >= 0) {
            
            sb.append(numToChar(num.remainder(BigInteger.valueOf(36))));
            num = num.divide(BigInteger.valueOf(36));
        }
        sb.append(numToChar(num));
        return sb.reverse().toString();
    }

    public static BigInteger charToNum(char c) {
        if (c >= '0' && c <= '9') {
            return BigInteger.valueOf(c-'0');
        } else if (c >= 'A' && c <= 'Z') {
            return BigInteger.valueOf(c - 'A' + 10);
        }
        return BigInteger.ZERO;
    }

    public static char numToChar(BigInteger num) {
        if ((num.compareTo(BigInteger.ZERO) >= 0) && num.compareTo(BigInteger.TEN) == -1) {
            return (char) ('0' + num.intValue());
        } else {
            return (char) (num.intValue() - 10 + 'A');
        }
    }
}
