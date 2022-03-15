import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
       String s="aabbaccc";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        Map<String,Integer>arr=new HashMap<>();
        int answer = 0;
        int len=s.length();
        for(int i=1;i<len;i++){
            String beforeString="";
            for(int ii=0;ii<len;ii+=i){
                //System.out.println("i:"+i);
                //System.out.println("ii:"+ii);
                int next=ii+i;
                if(next>len){
                    next=len-1;
                }
                String subString=s.substring(ii, next);
               // System.out.println(subString);
                if(beforeString.equals("")){
                    beforeString=subString;
                    ii=ii+i;
                }else if(!beforeString.equals(subString)){
                    beforeString=subString;
                }else{
                    //System.out.println(subString);
                    ii=ii+i;
                }
                System.out.println(beforeString);
            }

        }
        return answer;
    }
}
