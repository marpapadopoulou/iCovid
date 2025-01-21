package register;

import java.util.ArrayList;
import java.util.HashMap;

public class userdao {

    // Mock data
    private HashMap<String, user> userDatabase = new HashMap<>();

    public userdao() {
        // Add some mock users
        user mockUser = new user();
        mockUser.setName("Test User");
        mockUser.setEmail("test@example.com");
        mockUser.setLat(40.7128f);
        mockUser.setLng(-74.0060f);
        mockUser.setRes(0.5f);

        userDatabase.put(mockUser.getEmail(), mockUser);
    }

    // Mock method for inserting a user
    public boolean insert(user user) {
        if (!userDatabase.containsKey(user.getEmail())) {
            userDatabase.put(user.getEmail(), user);
            System.out.println("User added: " + user.getEmail());
            return true;
        } else {
            System.out.println("User already exists: " + user.getEmail());
            return false;
        }
    }

    public boolean validate(user user) {
        // Mock validation: Check if the user email matches the mock user
        return "test@example.com".equals(user.getEmail());
    }

    // Mock method to get coordinates
    public ArrayList<Float> getCoords() {
        ArrayList<Float> coords = new ArrayList<>();
        for (user u : userDatabase.values()) {
            coords.add(u.getLat());
            coords.add(u.getLng());
            coords.add(u.getRes());
        }
        return coords;
    }

    // Mock method for updating 'res'
    public void insertRes(Float res, user user) {
        if (userDatabase.containsKey(user.getEmail())) {
            user existingUser = userDatabase.get(user.getEmail());
            existingUser.setRes(res);
            System.out.println("Updated res for user: " + user.getEmail());
        } else {
            System.out.println("User not found: " + user.getEmail());
        }
    }
}
