package person.workspace.controller.dto;

public class UpdatedName {

    private Long personId;

    private String newFirstName;

    private String newLastName;

    public Long getPersonId() {
        return personId;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }
}
