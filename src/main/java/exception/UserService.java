package exception;

import java.util.List;

public class UserService {


    private List<User> users;

    //if your status code is 4xx -> it's a client side issue -> NonRetryableException
    //if your status code is 5xx -> It's a server side issue -> RetryableException

    public User getUser(int index) throws UserNotFoundException, RandomException {
        if (index < 0 || index >= users.size()) {
            throw new UserNotFoundException("invalid index");
        }
        throw new RandomException("Apni Marzi");
        //return users.get(index);
    }

    public void createUser() {
        throw new UserCreationException("could not create user");
    }


}
