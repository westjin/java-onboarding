package onboarding;

import java.util.*;


import java.util.*;
class Admin implements Comparable<Admin> {
    int point;
    String name ;

    public Admin(int point, String name) {
        this.point = point;
        this.name = name;
    }

    @Override
    public int compareTo(Admin o) {
        if (o.point == this.point) {
            return this.name.compareTo(o.name);
        }
        return o.point - this.point;
    }
}
public class Problem7 {


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashSet<String> alfr = new HashSet<>();


        HashSet<String> friend = new HashSet<String>();
        HashMap<String, Admin> Afoaf = new HashMap<>();


        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                alfr.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                alfr.add(friends.get(i).get(0));
            }
        }


        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (alfr.contains(friends.get(i).get(j)) && !alfr.contains(friends.get(i).get((j + 1) % 2)) && !friends.get(i).get((j + 1) % 2).equals(user)) {
                    if (!Afoaf.containsKey(friends.get(i).get((j + 1) % 2))) {
                        Afoaf.put(friends.get(i).get((j + 1) % 2), new Admin(0, friends.get(i).get((j + 1) % 2)));
                    }
                    Afoaf.get(friends.get(i).get((j + 1) % 2)).point += 10;
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (!alfr.contains(visitors.get(i))) {
                if (!Afoaf.containsKey(visitors.get(i))) {
                    Afoaf.put(visitors.get(i), new Admin(0, visitors.get(i)));
                }
                Afoaf.get(visitors.get(i)).point += 1;
            }
        }


        ArrayList<Admin> list = new ArrayList<>(Afoaf.values());
        answer = new ArrayList<>();
        Collections.sort(list);
        for (int i = 0; i < 5 && i < list.size(); i++) {
            answer.add(list.get(i).name);
            System.out.println(list.get(i).name + " " + list.get(i).point);
        }


        return answer;
    }

}

