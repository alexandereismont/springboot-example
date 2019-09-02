package person.workspace.controller.exceptions;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(Long id) {
        super("Person id not found : " + id);
    }
}
