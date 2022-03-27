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
    static LinkedHashMap<String,Integer>menuAndNum=new LinkedHashMap<>();
    static int num2=0;
    static List<String>menuStrings=new ArrayList<>();
    private static List<String> combination;
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
            Arrays.sort(menus);
            System.out.println(Arrays.toString(menus));
            int len=menus.length;
            for(int i=0;i<len;i++){
                for(int c:course){
                    dfs(c, menus,String.valueOf(menus[i]),menus[i]);
                }
            }

        }
       System.out.println(menuAndNum.toString());
        return answer;
    }
    private static void dfs(int len,char[]menus,String str,char menu) {
        System.out.println("str: "+str);

        //문자열 길이가 조건길이인지 확인
        if(len==str.length()){
            System.out.println("정답");
            System.out.println("str: "+str);
            int count=Optional.ofNullable(menuAndNum.get(str)).orElseGet(()->0);
            if(count==0){
                menuAndNum.put(str, 1);
            }else{
                count+=1;
                menuAndNum.replace(str,  count);
            }
            return;
        }

        //재귀호출
        for(int i=0;i<menus.length;i++){
            if(menus[i]==menu){
                continue;
            }
            dfs(len, menus, str+menus[i],menus[i]);
            System.out.println("다음스텝");
            
        }

    }
    //abcfg
    //0a1ab*

}
