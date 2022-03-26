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
                    dfs(c, menus,String.valueOf(menus[i]),i+1);
                }
            }

        }
       System.out.println(menuAndNum.toString());
        return answer;
    }
    private static void dfs(int len,char[]menus,String str,int num) {
        //끝에를 초과한다면 리턴
        if(num>=menus.length){
            return;
        }
        //아니라면 그다음 문자열 붙히기
        str=str+menus[num];
        System.out.println("num: "+num);
        System.out.println("str: "+str);
        //문자열 길이가 조건길이인지 확인
        if(len==str.length()){
            System.out.println("정답");
            System.out.println("num: "+num);
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
        //다음 문자열 위해 증가
        num=num+1;
        //재귀호출
        for(int i=0;i<menus.length;i++){
            dfs(len, menus, str,num);
            //호출이 끝났으면 다음 문자열 위해 
            //ex) abc abf이렇게 
            num=num+1;
            System.out.println("다음스텝");
        }

    }
    //abcfg
    //0a1ab*

}
