import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
       String s="aabbaccc";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        List<Integer>arr=new ArrayList<>();
        int answer = 0;
        int len=s.length();
        int num=0;
        for(int i=1;i<len/2;i++){
            for(int ii=0;ii<len;ii+=i){
                //System.out.println("i:"+i);
               // System.out.println("ii:"+ii);
                System.out.println(s.substring(ii, ii+i));
            }
        }
        return answer;
    }
}
