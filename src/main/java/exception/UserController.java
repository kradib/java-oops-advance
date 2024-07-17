package exception;

public class UserController {



    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
        //this throws translated NonRetryable Exception
        try {
            userService.getUser(1);
        }  catch (Exception e) {
            throw ExceptionTranslator.translate(e);
        }

        //this throws translated Retryable Exception

        try {
            userService.createUser();
        }  catch (Exception e) {
            throw ExceptionTranslator.translate(e);
        }
    }




}
