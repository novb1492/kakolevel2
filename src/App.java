import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
       String s="abcabcabcabcdededededede";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        Map<String,Integer>arr=new HashMap<>();
        int answer = s.length();
        int len=s.length();
        for(int i=1;i<=len/2;i++){
            String beforeString="";
            String other="";
            for(int ii=0;ii<len;ii+=i){
                //System.out.println("i:"+i);
                //System.out.println("ii:"+ii);
                int next=ii+i;
                if(next>len){
                    next=len;
                }
                String subString=s.substring(ii, next);
                //System.out.println(subString);
                if(beforeString.equals(subString)){
                    int num=arr.get(beforeString);
                    num=num+1;
                    arr.put(beforeString, num);
                }else{
                    if(!arr.containsKey(subString)){
                        arr.put(subString, 1);
                    }else{
                        other=other+subString;
                    }
                    beforeString=subString;
                }
            }
            System.out.println(arr.toString());
            System.out.println(other);
            for(Entry<String, Integer> d:arr.entrySet()){
                if(d.getValue()!=1){
                    other=other+d.getValue()+d.getKey();    
                }else{
                    other=other+d.getKey();    
                }
            }
            System.out.println(other);
            if(other.length()<answer){
                answer=other.length();
            }
            arr.clear();
        }
        return answer;
    }
}
