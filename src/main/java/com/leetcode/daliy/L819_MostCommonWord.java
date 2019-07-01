package java.com.leetcode.daliy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author TSN
 * @date 2019/7/2
 * @Description
 */
public class L819_MostCommonWord {
    public static void main(String[] args) {
        String paragraph =  "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph,banned));

    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] split = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
        HashSet<String> strings = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        String result = null;
        for (String s : split) {
            if (strings.contains(s)){
                continue;
            }
            if (stringIntegerHashMap.containsKey(s)){
                stringIntegerHashMap.put(s, 1);
            }else {
                stringIntegerHashMap.put(s,stringIntegerHashMap.get(s)+1);
            }

        }
        for (Map.Entry<String, Integer> stringIntegerEntry : stringIntegerHashMap.entrySet()) {
            if (result == null || stringIntegerEntry.getValue()>stringIntegerHashMap.get(result))
                result = stringIntegerEntry.getKey();
        }
        return result;

    }
}
