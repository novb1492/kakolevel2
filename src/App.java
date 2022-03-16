import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
       String[] s={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(s)));
    }
    public static String[] solution(String[] record) {
        String[] answer = new String[5];
        Map<String,List<String[]>>ids=new HashMap<>();
        for(String r:record){
            String[] recordDetails=r.split(" ");
            String id=recordDetails[1];
            List<String[]>infors=new ArrayList<>();
            if(ids.containsKey(id)){
                infors=ids.get(id);
                infors.add(recordDetails);
            }else{
                infors.add(recordDetails);
                ids.put(id, infors);
            }
        }
        System.out.println(ids.toString());
        return answer;
    }
}
