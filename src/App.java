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
    public static void main(String[] args) throws Exception {
        String s="(()())()";
        System.out.println("r: "+solution(s));
    }
    public static String solution(String p) {
        String answer = "";
        char[] arr=p.toCharArray();
        int num=0;
        int num2=0;
        String aa="";
        for(char a:arr){
            aa=aa+a;
            if(a=='('){
                num+=1;
            }else{
                num2+=1;
            }
            if(num==num2){
                System.out.println(aa);
                break;
            }
        }
        
        return answer;
    }
    

}
