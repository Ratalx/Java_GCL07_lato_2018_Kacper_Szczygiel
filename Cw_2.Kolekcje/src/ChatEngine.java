import java.util.*;
import java.util.stream.Collector;

public class ChatEngine {
    public Map<String, User> usersMap = new HashMap<String, User>();
    public Map<Long, User> userIdMap = new HashMap<>();
    private int incrementator = 0;
    private Set<String> SetOfBans = new HashSet<>();

    public void addUser(User user) throws UserAddException {

        if (usersMap.containsKey(user.getName())) {
            throw new UserAddException();
        } else if (!SetOfBans.contains(user.getName())) {

            user.setId(++incrementator);
            user.setCreatedAt(System.currentTimeMillis() % 1000);
            usersMap.put(user.getName(), user);
            userIdMap.put(user.getId(), user);
        }


    }

    public void removeUser(long userId) throws UserRemoveException {
        boolean remove = false;
        if (userIdMap.containsKey(userId)) {
            User temp = userIdMap.get(userId);
            usersMap.remove(temp.getName(), temp);
            userIdMap.remove(userId);
        } else {
            throw new UserRemoveException();
        }
    }

    public int getNumberOfUsers() {
        return usersMap.size();
    }

    public void createBan(String userName) {
        SetOfBans.add(userName);

        if (usersMap.containsKey(userName)) {
            User temp = usersMap.get(userName);
            userIdMap.remove(temp.getId(), temp);
            usersMap.remove(userName);
        }

    }

    public void removeBan(String userName) {
        SetOfBans.remove(userName);
    }

    boolean hasUser(long userId) {
        if (userIdMap.containsKey(userId)) {
            return true;
        }
        return false;
    }
    boolean hasUser(String userName){
        if(usersMap.containsKey(userName))
            return true;
        return false;
    }
    boolean broadcastMessage(long userId,String message){
        System.out.format("Wyslono wiadomosc '"+message+"' do uzytkownika o id - %d i nazwie" + userIdMap.get(userId).getName(), userId);
        return true;
    }
    void printStaistics(){
        List<Long> times = new ArrayList<>();
        for (Map.Entry<String,User> entry:usersMap.entrySet()
             ) {
            times.add(entry.getValue().getCreatedAt());
        }
        Collections.sort(times);
        System.out.format("Maks-%d Averge-%d Min-%d  ",Collections.max(times,null),times.get(times.size()/2),Collections.min(times,null));
        for (Map.Entry<String,User> entry:usersMap.entrySet()
                ) {
            System.out.format(entry.getKey()+"  "+ entry.getValue().getId()+ " " + entry.getValue().getCreatedAt());
        }
    }
}