import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
       String[] s={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
       int[] c={2,3,4};
        System.out.println(Arrays.toString(solution(s,c)));
    }
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Map<String,Integer>arr=new HashMap<>();
        for(String order:orders){
            char[] chars=order.toCharArray();
            for(char c:chars){
                String cc=String.valueOf(c);
                if(arr.containsKey(cc)){
                    int num=arr.get(cc);
                    num+=1;
                    arr.replace(cc, num);
                }else{
                    arr.put(cc, 1);
                }
            }
        }
        System.out.println(arr.toString());
    
        return answer;
    }
}
