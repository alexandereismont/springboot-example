package person.workspace.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import person.workspace.model.Person;
import person.workspace.repository.PersonRepository;

import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@DirtiesContext
public class PersonControllerTest {

    private PersonController personController;
    private MockMvc mvc;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void before(){
        personController = new PersonController(personRepository);
        mvc = MockMvcBuilders.standaloneSetup(new PersonController(personRepository)).build();
    }

    @Test
    public void checkAddedPerson() throws Exception {
        mvc.perform(post("/person/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"firstName\": \"TestFirstName\", \"lastName\": \"TestLastName\"}")).andExpect(status().isOk());

        List<Person> all = personRepository.findAll();
        assert(all.stream().filter(p -> p.getFirstName().equals("TestFirstName")).findAny().isPresent());
    }

}
