import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class App {
    static List<Character>menuArr=new ArrayList<>();
    static LinkedHashMap<String,Integer>menuAndNums=new LinkedHashMap<>();
    static int num2=0;
    static List<String>menuStrings=new ArrayList<>();
    public static void main(String[] args) throws Exception {
       String[] s={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
       int[] c={2,3,4};
        System.out.println("r: "+Arrays.toString(solution(s,c)));
    }
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        menuArr=new ArrayList<>();
        //경우의수가져오기
        for(String order:orders){
            char[] menus=order.toCharArray();
            //이정렬이 있어야 
            //밑에 a<menu조건식이 성립함
            Arrays.sort(menus);
            System.out.println(Arrays.toString(menus));
            int len=menus.length;
            for(int i=0;i<len;i++){
                for(int c:course){
                    dfs(c, menus,String.valueOf(menus[i]),menus[i]);
                }
            }

        }
        System.out.println(menuAndNums.toString());
        //해당 길이중 가장 많이 된것 넣기
        Map<Integer,Integer>topInLen=new HashMap<>();      
        for(Entry<String, Integer> menuAndNum:menuAndNums.entrySet()){
            int len=menuAndNum.getKey().length();
            int topCount=Optional.ofNullable(topInLen.get(len)).orElseGet(()->0);
            if(topCount<menuAndNum.getValue()){
                topInLen.put(len, menuAndNum.getValue());
            }
        }
        System.out.println(topInLen.toString());
        //해당 메뉴중 가장 많이 주문된것 모두 추려내기
        List<String>topMenusInLen=new ArrayList<>();
        for(Entry<String, Integer> menuAndNum:menuAndNums.entrySet()){
            if(menuAndNum.getValue()==topInLen.get(menuAndNum.getKey().length())&&menuAndNum.getValue()>=2){
                topMenusInLen.add(menuAndNum.getKey());
            }
        }
        //정렬
        Collections.sort(topMenusInLen);
        answer=topMenusInLen.toArray(new String[topMenusInLen.size()]);
        return answer;
    }
    private static void dfs(int len,char[]menus,String str,char menu) {
        //문자열 길이가 조건길이인지 확인
        if(len==str.length()){
            int count=Optional.ofNullable(menuAndNums.get(str)).orElseGet(()->0);
            count++;
            menuAndNums.put(str, count);
            return;
        }
        //재귀호출
        for(int i=0;i<menus.length;i++){
            char a=menus[i];
            //이미 있다면 혹은 이전 메뉴라면 무시 dfs 타지 않음
            //위에 Arrays.sort(menus); 했기 때문에 a<menu로 잡아낸것
            if(str.contains(String.valueOf(a))||a<menu){
                continue;
            }
            dfs(len, menus, str+menus[i],menus[i]);
            //System.out.println("다음스텝"); 
        }

    }
    //abcfg
    //0a1ab*

}
