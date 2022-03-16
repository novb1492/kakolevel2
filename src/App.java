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
        int size=0;
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
            String state=recordDetails[0];
            if(state.equals("Enter")||state.equals("Leave")){
                size+=1;
            }
        }
        String[] answer = new String[size];
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
            names.put(id.getKey(), name);
        }
        int num=0;
        for(String s:record){
            String[] inforArr=s.split(" ");
            String name=names.get(inforArr[1]);
            String state=inforArr[0];
            if(state.equals("Change")){
                continue;
            }else if(state.equals("Enter")){
                name=name+"님이 들어왔습니다.";
            }else if(state.equals("Leave")){
                name=name+"님이 나갔습니다.";
            }
            answer[num]=name;
            num+=1;
        }
        return answer;
    }
}
