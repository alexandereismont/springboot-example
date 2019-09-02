package person.workspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import person.workspace.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
