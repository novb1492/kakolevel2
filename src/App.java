import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
        List<Integer> intList= Arrays.stream(course)
                                    .boxed()
                                    .collect(Collectors.toList());
        System.out.println(intList.toString());
        Map<Integer,String>arr2=new HashMap<>();
        int len=menuArr.size();
        for(int i=0;i<len;i++){
            for(int ii=i+1;ii<len;ii++){
                int len2=ii+1;
                List<Character>menu=menuArr.subList(i, len2);
                if(intList.contains(menu.size())){
                
                    System.out.println(menu.toString());
                }
               // List<Character>menu=menuArr.subList(i, len2);
                
                //System.out.println(menu.toString());
            }
        }
    
        return answer;
    }
}
