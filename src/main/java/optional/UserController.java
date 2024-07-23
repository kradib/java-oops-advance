package optional;

import java.util.Optional;

public class UserController {


    public void f() throws UserException {
        UserService userService = new UserService();
        Optional<User> userOptional = userService.getUser(1);

//        if(user!= null) {
//            //System.out.println("user: " + user);
//        } else {
//            System.out.println("user does not exist"));
//        }


        userOptional.ifPresentOrElse(user -> {
            System.out.println("user: " + user);
        }, () -> System.out.println("user does not exist"));


        String name = userOptional
                .map(User::getName)
                .orElseThrow(() -> new UserException("no user found"));
    }

}
