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

import javax.print.DocFlavor.STRING;

public class App {
    static String result="";
    public static void main(String[] args) throws Exception {
        String s=")()(()";
        System.out.println("r: "+solution(s));
    }
    public static String solution(String p) {
        String answer = "";
        char[] arr=p.toCharArray();
        Stack<Character>stacks=check(arr);
        //스택이 비어있다면 초기상태가 올바른 괄호문자열임
        if(stacks.empty()){
            return p;
        }
        String a=String.valueOf(arr);
        boolean[] temp=new boolean[p.length()];
        List<Integer>indexs=new ArrayList<>();
        String fix="";
        int count=0;
        while(true){
            //'()'로일치하는 문자열찾기
            int r=division(a);
            //더는 없다면 탈출
            if(r==-1){
                fix=a;
                break;
            }
            //있다면 '()'중 '('위치저장 )는 +1하면되니 
            indexs.add(r+count*2);//count*2는 문자열이 2개 씩 감소하기 때문에
            String aa="";
            char[] aaa=a.toCharArray(); 
            for(int i=0;i<a.length();i++){
                if(i==r){//'()'중 '('인 위치만 true
                    temp[r+count*2]=true;//count*2는 문자열이 2개 씩 감소하기 때문에
                    count++;
                }else if(i==r+1){
                    continue;//aa에 ')'값이 안붙도록
                }
                else{
                    aa=aa+aaa[i];
                }
            }
            a=aa;
        } 
        System.out.println(Arrays.toString(temp));      
        System.out.println(indexs.toString());
        System.out.println(fix);
        int len=fix.length();
        while(true){
            int i=len/2;
            System.out.println("half: "+i);
            char[] fixs=fix.toCharArray();
            String aa="";
            String bb="";
            if(fixs[i-1]!='('){
                aa="(";
            }
            if(fixs[i]!=')'){
                bb=")";
            }
            String s=aa+bb;
            System.out.println(s);
            break;
        }
        return answer;
    }
    private static Stack<Character> check(char[]arr) {
        Stack<Character>stacks=new Stack<>();
        for(char c:arr){
            if(stacks.size()>=1){
                char a=stacks.peek();
                String ac=String.valueOf(a)+String.valueOf(c);
                if(ac.equals("()")){
                    stacks.pop();
                }else{
                    stacks.push(c);
                }
            }else{
                stacks.push(c);
            }
           
        }
        return stacks;
    }
    private static int division(String p) {
       return p.indexOf("()");

    }
}
