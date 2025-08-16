import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDatabase {

    List <String> adminNames = new ArrayList<>(Arrays.asList("Admin1", "Admin2", "Admin3"));
    List <String> adminPasswords = new ArrayList<>(Arrays.asList("1", "2", "3"));
    List<User> users = new ArrayList<>();
    List <String> userNames = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
        userNames.add(user.getName());
    }

    public int login (String name, String password){
        int n = -1;
        for(User i: users){
            if(i.getName().matches(name) && i.getPassword().matches(password)){
                n = users.indexOf(i);
                break;
            }
        }
        return n;
    }

    public boolean adminLogin (String name, String password){
        for(int i=0; i < adminNames.size(); i++){
            if(name.matches(adminNames.get(i)) && password.matches(adminPasswords.get(i))){
               return true;
            }
        }
        return false;
    }

    public User getUser(int n){
        return users.get(n);
    }

    public boolean accountExists(String name){
        for(User i: users){
            if(i.getName().matches(name)){
                return true;
            }
        }
        return false;
    }
}
