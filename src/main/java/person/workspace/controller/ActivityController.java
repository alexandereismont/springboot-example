package person.workspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.workspace.model.Activity;
import person.workspace.repository.ActivityRepository;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivityRepository activityRepository;

    @PostMapping("/add")
    public void addActivity(@RequestBody Activity activity){
        activityRepository.save(activity);
    }

}
