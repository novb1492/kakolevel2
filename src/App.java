import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
       String s="ababcdcdababcdcd";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        Map<String,Integer>arr=new HashMap<>();
        int answer = s.length();
        int len=s.length();
        for(int i=1;i<=len/2;i++){
            String other="";
            for(int ii=0;ii<len;ii+=i){
                System.out.println("ii:"+ii);
                int next=ii+i;
                if(next>len){
                    next=len;
                }
                System.out.println("next:"+next);
                String subString=s.substring(ii, next);
                System.out.println("oriin:"+subString);
                int num=1;
                for(int iii=ii+i;iii<len;iii+=i){
                    int next2=iii+i;
                    if(next2>len){
                        next2=len;
                    }
                    String subString2=s.substring(iii, next2);
                    System.out.println("sub2: "+subString2);
                    if(subString.equals(subString2)){
                        num+=1;
                        ii=ii+i;
                    }else{
                        break;
                    }
                }
                if(num!=1){
                    other=other+num+subString;
                }else{
                    other=other+subString;
                }
            }
            //System.out.println(arr.toString());
           // System.out.println("other: "+other);
            if(other.length()<answer){
                answer=other.length();
            }
            //System.out.println("len:"+answer);
            arr.clear();
        }
        return answer;
    }
}
