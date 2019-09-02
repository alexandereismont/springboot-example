package person.workspace.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "activity")
public class Activity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "activity_name")
    public String activityName;

    @NotNull(message = "Please enter id")
    @Column(name = "person_id")
    public Long personId;

    public String getActivityName(){
        return activityName;
    }

    public void setActivityName(String activityName){
        this.activityName = activityName;
    }

    public void setPersonId(String personId){
        this.personId = Long.parseLong(personId);
    }

    public Long getPersonId(){
        return this.personId;
    }
}
