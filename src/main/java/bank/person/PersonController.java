package bank.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/persons")
    public List<PersonDto> getAll(Pageable pageable) {
        return personService.getPersons(pageable);
    }

    @GetMapping("/persons/{uid}")
    public PersonDto person(@PathVariable("uid") String uid) {
        return personService.getPerson(uid);
    }

    @PostMapping("/persons")
    public PersonDto createPerson(@RequestBody PersonDto request) {
        return personService.create(request);
    }

    @PutMapping("/persons/{uid}")
    public PersonDto updatedPerson(
            @PathVariable("uid") String uid,
            @RequestBody PersonDto request) {

        return personService.update(uid, request);
    }

    @DeleteMapping("/persons/{uid}")
    public void deletePerson(@PathVariable("uid") String uid) {
        personService.delete(uid);
    }
}
