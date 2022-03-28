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
    static Map<Integer,Integer>topInLen=new HashMap<>();
    public static void main(String[] args) throws Exception {
       String[] s={"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
       int[] c={2,3,5};
        System.out.println(Arrays.toString(solution(s,c)));
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
                    dfs(c, menus,String.valueOf(menus[i]),menus[i],already);
                    already.clear();
                }
            }

        }
        System.out.println(menuAndNums.toString());
        System.out.println(topInLen.toString());
        //가장많이 주문된 개수 분류하기
        List<String>topMenusInLen=new ArrayList<>();
        for(Entry<String, Integer> menuAndNum:menuAndNums.entrySet()){
            String menu=menuAndNum.getKey();
            int topCount=topInLen.get(menu.length());
            if(topCount==menuAndNum.getValue()){
                topMenusInLen.add(menu);
            }
        }
        Collections.sort(topMenusInLen);
        System.out.println(topMenusInLen.toString());
        //최소 두명이상에게 주문되었나확인하기
        for(String order:orders){
            
        }
        return answer;
    }
    private static void dfs(int len,char[]menus,String str,char menu,List<Character>already) {
        System.out.println("str: "+str);
        //문자열 길이가 조건길이인지 확인
        if(len==str.length()){
            //System.out.println("정답");
            //System.out.println("str: "+str);
            int count=Optional.ofNullable(menuAndNums.get(str)).orElseGet(()->0);
            count++;
            if(count==1){
                menuAndNums.put(str, count);
            }else{
                menuAndNums.replace(str,  count);
            }
            // 길이에 가장 많은 카운트 저장
            int count2=Optional.ofNullable(topInLen.get(len)).orElseGet(()->0);
            if(count2<=count){
                topInLen.put(len,count);
            }
            already.remove(already.indexOf(menu));
            return;
        }
        //재귀호출
        for(int i=0;i<menus.length;i++){
            char a=menus[i];
            //이미 있다면 무시
            if(already.contains(a)){
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
