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
            for(int ii=0;ii<len;ii+=i){
                //System.out.println("i:"+i);
                //System.out.println("ii:"+ii);
                int next=ii+i;
                if(next>len-1){
                    next=len-1;
                }
                String subString=s.substring(ii, next);
                //System.out.println(subString);
                if(arr.containsKey(subString)){
                    int num=arr.get(subString);
                    num+=1;
                    arr.replace(subString, num);
                }else{
                    arr.put(subString, 1);
                }
            }
            System.out.println(arr.toString());
            arr.clear();
        }
        return answer;
    }
}
