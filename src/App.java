import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
       String s="aabbaccc";
        System.out.println(solution(s));
    }
    public  static int solution(String s) {
        List<Integer>arr=new ArrayList<>();
        int answer = 0;
        int len=s.length();
        char[] ss=s.toCharArray();
        int num=0;
        for(int i=1;i<=len;i++){
           while(true){
               int num2=num+i;
                if(num2>len-1){
                    num2=len-1;
                }
               System.out.println(s.substring(num, num2));
               num+=i;
               if(num2>=len-1){
                   break;
               }
           }
           num=0;
        
        }
        return answer;
    }
}
