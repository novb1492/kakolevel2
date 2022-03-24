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
        List<Character>menuArr=new ArrayList<>();
        for(String order:orders){
            char[] menus=order.toCharArray();
            for(char menu:menus){
                if(!menuArr.contains(menu)){
                    menuArr.add(menu);
                }
            }
        }
        System.out.println(menuArr.toString());
        Map<Integer,String>arr2=new HashMap<>();
        int len=menuArr.size();
        for(int i=0;i<len;i++){
            for(int ii=i+1;ii<len;ii++){
                List<Character>menu=menuArr.subList(i, ii+1);
                
                System.out.println(menuArr.subList(i, ii+1));
            }
        }
    
        return answer;
    }
}
