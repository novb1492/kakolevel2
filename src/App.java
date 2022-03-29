import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        String s="(()())()";
        System.out.println("r: "+solution(s));
    }
    public static String solution(String p) {
        String answer = "";
        Stack<Character>stacks=new Stack<>();
        

        
        
        return answer;
    }
    private static String name() {
        
    }
    private static Map<String,String> getUandV(int len,char[] arr) {
        int num=0;
        int num2=0;
        String u="";
        String v="";
        Map<String,String>uAndV=new HashMap<>();
        for(int i=0;i<len;i++){
            char aaa=arr[i];
            u=u+aaa;
            if(aaa=='('){
                num+=1;
            }else{
                num2+=1;
            }
            if(num==num2){
                //같다면 기준으로 분리
                for(int ii=i+1;ii<len;ii++){
                    v=v+arr[ii];
                }
                break;
            }
        }
        uAndV.put("u", u);
        uAndV.put("v", v);
        return uAndV;
    }
}
