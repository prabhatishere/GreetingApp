package com.example.GreetingAPP.Modal;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
public class Greeting {

    private String message;

=======
=======
>>>>>>> UC5
=======
>>>>>>> UC6
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id  // Add this annotation to mark this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate values for this field
    private Long id;

<<<<<<< HEAD
<<<<<<< HEAD
    private String message;

    // Constructor
>>>>>>> UC4
=======
    public  String message;

    // Constructor
>>>>>>> UC5
=======
    public  String message;

    public Greeting(){}

    // Constructor
>>>>>>> UC6
    public Greeting(String message) {
        this.message = message;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    // Getter and Setter
=======
=======
>>>>>>> UC5
=======
>>>>>>> UC6
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> UC4
=======
>>>>>>> UC5
=======
>>>>>>> UC6
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> UC4
=======
>>>>>>> UC5
=======
>>>>>>> UC6
