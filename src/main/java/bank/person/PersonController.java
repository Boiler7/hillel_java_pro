package bank.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public List<PersonDto> getAll(Pageable pageable) {
        return personService.getPersons(pageable);
    }

    @GetMapping("/{uid}")
    public PersonDto person(@PathVariable("uid") String uid) {
        return personService.getPerson(uid);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto request) {
        return personService.create(request);
    }

    @PutMapping("/{uid}")
    public PersonDto updatedPerson(
            @PathVariable("uid") String uid,
            @RequestBody PersonDto request) {

        return personService.update(uid, request);
    }

    @DeleteMapping("/{uid}")
    public void deletePerson(@PathVariable("uid") String uid) {
        personService.delete(uid);
    }
}
