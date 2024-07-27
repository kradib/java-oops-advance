package optional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserController {


    public static void main(String[] args) throws UserException {
        UserService userService = new UserService();
        Optional<User> userOptional = userService.getUser(1);

//        if(user!= null) {
//            //System.out.println("user: " + user);
//        } else {
//            System.out.println("user does not exist"));
//        }


//        userOptional.ifPresentOrElse(user -> {
//            System.out.println("user: " + user);
//        }, () -> System.out.println("user does not exist"));


//        String nameL = userOptional
//                .map(User::getName)
//                .orElseThrow(() -> new UserException("no user found"));


        List<String> names = List.of("Savvy", "Surya", "Radib", "A", "B", "S");

        List<String> namesStartingWithS = names.stream().filter(name -> name.startsWith("S") && name.length() == 5)
                .collect(Collectors.toUnmodifiableList());

        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> evenNum =numbers.stream()
                .filter(number ->number %2==0)
                .collect(Collectors.toList());

        List<Integer> oddNum =numbers.stream()
                .filter(number ->number %2!=0)
                .collect(Collectors.toList());

        System.out.println(evenNum);
        System.out.println(oddNum);


        Map<Boolean, List<Integer>> evenOddNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(number ->number %2==0));

        System.out.println(evenOddNumbers.get(Boolean.TRUE));
        System.out.println(evenOddNumbers.get(Boolean.FALSE));

        //List<Student> studentList =
        // you have a function rand()
        //generate random number within a range 0-200 , 1000-2000

        List<Student> studentList = IntStream.range(1, 50).mapToObj(i -> Student.builder()
                .id(i)
                .age((int) (Math.random()%8 + 18))
                        .name(String.valueOf(UUID.randomUUID()))
                .build())
                .collect(Collectors.toUnmodifiableList());
        Map<Integer, List<Student>> ageGroupWiseStudentMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getAge));
        System.out.println(ageGroupWiseStudentMap);

        //age : 21, name = Saavy
        //age: 21, name : Sourav
        //age 22: name : X
        //age 26: name : Radib
        //age 26: name : Y

        Map<Integer, Map<Character, List<Student>>> ageGroupWiseNameWiseStudentMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getAge,
                        Collectors.groupingBy(student -> student.getName().charAt(0))));

        //System.out.println(ageGroupWiseNameWiseStudentMap);

        ageGroupWiseNameWiseStudentMap.forEach((age, nameWiseStudent) -> {
            System.out.println("Students with age " + age);
            nameWiseStudent.forEach((nameStartsWith, students) -> {
                System.out.println("Students with name starting with " + nameStartsWith);
                students.forEach(System.out::println);
            });
        });

        Map<Integer, Map<Boolean, List<Student>>> ageGroupWiseNameWisePartitionedStudentMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getAge,
                        Collectors.partitioningBy(student -> student.getName().charAt(0)=='s')));
        System.out.println(ageGroupWiseNameWisePartitionedStudentMap);

        //So you will create Car Showr room
        // In that show room there are mnany cars
        //User can give you input like
         //-> show all Red cars
        // -> show all Maruti Cars
        // -> show me only diesel cars(There is only deisel, petrol)

    }

}
