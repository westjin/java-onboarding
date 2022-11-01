package onboarding;

import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");




                HashSet<String> emails = new HashSet<>();

                final Map<String, String > data = new HashMap<>();

                for (int i = 0; i < forms.size(); i++) {

                    final String name = forms.get(i).get(1);

                    if(name.length() < 2){
                        break;
                    }


                    for (int j = 0; j < name.length() - 1; j++) {
                        final String key = name.substring(j, j+2);
                        if(data.containsKey(key)){
                            final String email = data.get(key);
                            if(!email.equals(forms.get(i).get(0))){
                                emails.add(email);
                                emails.add(forms.get(i).get(0));
                            }
                        }
                        data.put(key, forms.get(i).get(0));
                    }
                }

                answer = emails.stream().sorted().collect(Collectors.toList());





        return answer;
    }
}
