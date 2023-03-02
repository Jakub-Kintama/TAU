package pl.edu.pjwstk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import pl.edu.pjwstk.Data.description.Description;
import pl.edu.pjwstk.Data.description.DescriptionRepository;

import java.util.Collection;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class descriptionRepositoryTest {
    @Autowired
    private DescriptionRepository repo;

    @Test
    public void testAddNew(){
        Description description = new Description();
        String str = "jajko x6";
        description.setIngredients(str);
        description.setSteps("jajka usmazyc na patelni");

        Description savedDescription = repo.save(description);

        Assertions.assertNotNull(savedDescription);
        Assertions.assertTrue(savedDescription.getId() > 0);
        Assertions.assertEquals(str, savedDescription.getIngredients());
    }

    @Test
    public void testListAll(){
        Iterable<Description> descriptions = repo.findAll();
        int descriptionsSize = ((Collection<?>) descriptions).size();
        Assertions.assertTrue(descriptionsSize > 0);
        System.out.println(descriptionsSize);
    }

    @Test
    public void testUpdateById(){
        int descriptionId = 1;
        Optional<Description> optionalDescription = repo.findById(descriptionId);
        Description description = optionalDescription.get();
        description.setIngredients("nic");
        repo.save(description);

        Description updatedDescription = repo.findById(descriptionId).get();
        Assertions.assertEquals("nic", updatedDescription.getIngredients());
    }

    @Test
    public void testGet(){
        int descriptionId = 3;
        Optional<Description> optionalDescription = repo.findById(descriptionId);

        Assertions.assertTrue(optionalDescription.isPresent());
        Assertions.assertEquals(3, optionalDescription.get().getId());
    }

    @Test
    public void testDeleteById(){
        int descriptionId = 2;
        repo.deleteById(descriptionId);

        Optional<Description> optionalDescription = repo.findById(descriptionId);
        Assertions.assertTrue(optionalDescription.isEmpty());
    }
}