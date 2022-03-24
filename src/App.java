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
        for(int num:course){
            for(int i=0;i<len;i++){
                int lange=i+num;
                if(lange>=len){
                    break;
                }
                List<Character>arr=menuArr.subList(i, lange);
                int num2=0;
                for(String order:orders){
                    System.out.println(arr.toString());
                    //System.out.println("order: "+order);
                    for(Character cc:arr){
                       if(order.indexOf(cc)!=-1){
                       // System.out.println("char: "+cc);
                       }
                    }
                }
                String mm="";
            }
        }
        return answer;
    }
}
