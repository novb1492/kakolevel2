import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
        Map<String,String>names=new HashMap<>();
        for(Entry<String, List<String[]>> id:ids.entrySet()){
            String name=null;
            List<String[]>infors=id.getValue();
            for(String[] infor:infors){
                String state=infor[0];
                if(!state.equals("Leave")){
                    name=infor[2];
                }
            }
            System.out.println(name);
            names.put(id.getKey(), name);
        }
        System.out.println(names.toString());
        return answer;
    }
}
