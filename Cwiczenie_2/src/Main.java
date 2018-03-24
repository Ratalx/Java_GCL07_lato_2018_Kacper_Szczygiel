public class Main {
    public static void main(String args[])
    {
        ChatEngine CE= new ChatEngine();
        User user1 = new User("Jan");
        User user2 = new User("Kuba");
        User user3 = new User("Ania");


        try {
            CE.addUser(user1);
            CE.addUser(user2);
            CE.addUser(user3);
        } catch (UserAddException e) {
            e.printStackTrace();
        }


    }
}
