package optional;

import java.util.Optional;

public class UserService {

    public Optional<User> getUser(int id) {
        UserRepository userRepository = new UserRepository();
        return Optional.ofNullable(userRepository.getUser(id));
    }

}
