

class WrongAgeException extends Exception {

    public WrongAgeException(String message) {

        super(message);  

    }

}



// Base class: Father

class Father {

    int fatherAge;



    Father(int age) throws WrongAgeException {

        if (age < 0) {

            throw new WrongAgeException("Father's age cannot be negative!");

            

        }

        fatherAge = age;

        System.out.println("Father's age: " + fatherAge);

    }

}



// Derived class: Son

class Son extends Father {

    int sonAge;



    Son(int fatherAge, int sonAge) throws WrongAgeException {

        super(fatherAge);



        if (sonAge >= fatherAge) {

            throw new WrongAgeException("Son's age cannot be greater than or equal to father's age!");

        }



        this.sonAge = sonAge;

        System.out.println("Son's age: " + sonAge);

    }

}



// Test class

public class ExceptionDemo {

    public static void main(String[] args) {

        try {

            Son s1 = new Son(45, 20);  // Valid

            System.out.println("Object created successfully!");

            System.out.println("--------------------------------------");



            Son s2 = new Son(50, 20);  // Will throw exception

        }

        catch (WrongAgeException e) {

            System.out.println("Exception caught: " + e.getMessage());

            System.out.println("--------------------------------------");

        }

    }

}