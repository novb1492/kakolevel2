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
        //몇글자씩 잘라서 확인할지 최대 절반까지만 하면됨
        for(int i=1;i<=len/2;i++){
            String other="";
            //문자열 끝이될때까지
            for(int ii=0;ii<len;ii+=i){
                System.out.println("ii:"+ii);
                int next=ii+i;
                //초과한다면 최대값주기
                if(next>len){
                    next=len;
                }
                System.out.println("next:"+next);
                //시작 지점부터 종료지점자르기
                String subString=s.substring(ii, next);
                System.out.println("oriin:"+subString);
                int num=1;
                //잘른 개수만큼 점프해가면서 확인하기
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
