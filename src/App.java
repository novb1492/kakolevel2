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
            Arrays.sort(menus);
            System.out.println(Arrays.toString(menus));
            int len=menus.length;
            for(int i=0;i<len;i++){
                for(int c:course){
                    List<Character>already=new ArrayList<>();
                    //이전까지 넣었던 문자 제외 추가 이렇게 해야하나 싶다... 반복문 3개 좀 극혐
                    for(int ii=0;ii<=i;ii++){
                        already.add(menus[ii]);
                    }
                    //System.out.println("--------------------------------");
                    dfs(c, menus,String.valueOf(menus[i]),menus[i],already);
                    already.clear();
                }
            }

        }
        System.out.println(menuAndNums.toString());
        Map<Integer,Integer>topInLen=new HashMap<>();      
        for(Entry<String, Integer> menuAndNum:menuAndNums.entrySet()){
            int len=menuAndNum.getKey().length();
            int topCount=Optional.ofNullable(topInLen.get(len)).orElseGet(()->0);
            if(topCount<menuAndNum.getValue()){
                topInLen.put(len, menuAndNum.getValue());
            }
        }
        System.out.println(topInLen.toString());
        
        List<String>topMenusInLen=new ArrayList<>();
        for(Entry<String, Integer> menuAndNum:menuAndNums.entrySet()){
            if(menuAndNum.getValue()==topInLen.get(menuAndNum.getKey().length())&&menuAndNum.getValue()>=2){
                topMenusInLen.add(menuAndNum.getKey());
            }
        }
        Collections.sort(topMenusInLen);
        System.out.println(topMenusInLen.toString());
        answer=topMenusInLen.toArray(new String[topMenusInLen.size()]);
        //가장많이 주문된 개수 분류하기
       /* List<String>topMenusInLen=new ArrayList<>();
        for(Entry<String, Integer> menuAndNum:menuAndNums.entrySet()){
            String menu=menuAndNum.getKey();
            int topCount=topInLen.get(menu.length());
            if(topCount<=1){
                continue;
            }
            if(topCount==menuAndNum.getValue()){
                topMenusInLen.add(menu);
            }
        }
        Collections.sort(topMenusInLen);
        System.out.println(topMenusInLen.toString());
        answer=topMenusInLen.toArray(new String[topMenusInLen.size()]);*/
        return answer;
    }
    private static void dfs(int len,char[]menus,String str,char menu,List<Character>already) {
       // System.out.println("str: "+str);
       // System.out.println(already.toString());
        //문자열 길이가 조건길이인지 확인
        if(len==str.length()){
           // System.out.println("정답");
            //System.out.println("str: "+str);
            int count=Optional.ofNullable(menuAndNums.get(str)).orElseGet(()->0);
            count++;
            menuAndNums.put(str, count);
            return;
        }
        //재귀호출
        for(int i=0;i<menus.length;i++){
            char a=menus[i];
            //이미 있다면 무시
            if(str.contains(String.valueOf(a))||a<menu){
                continue;
            }
            //아니라면 넣어주기 중복 확인 방지
            already.add(a);
            dfs(len, menus, str+menus[i],menus[i],already);
            //System.out.println("다음스텝"); 
        }

    }
    //abcfg
    //0a1ab*

}
