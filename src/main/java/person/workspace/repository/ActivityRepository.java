package person.workspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import person.workspace.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
