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
    static List<Character>menuArr=new ArrayList<>();
    static Map<Character,Boolean>flag=new HashMap<>();
    static int num=0;
    static int num2=0;
    static List<String>menuStrings=new ArrayList<>();
    public static void main(String[] args) throws Exception {
       String[] s={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
       int[] c={2,3,4};
        System.out.println(Arrays.toString(solution(s,c)));
    }
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        menuArr=new ArrayList<>();
        for(String order:orders){
            char[] menus=order.toCharArray();
            for(char menu:menus){
                if(!menuArr.contains(menu)){
                    menuArr.add(menu);
                }
            }
        }
        System.out.println(menuArr.toString());
        for(int c:course){
            for(char menu:menuArr){
               
            }
        } 
        System.out.println(menuStrings.toString());
        return answer;
    }

}
