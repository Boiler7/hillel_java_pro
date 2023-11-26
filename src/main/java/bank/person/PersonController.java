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

    @GetMapping("/{id}")
    public PersonDto person(@PathVariable("id") String id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto request) {
        return personService.create(request);
    }

    @PutMapping("/{id}")
    public PersonDto updatedPerson(
            @PathVariable("id") Long id,
            @RequestBody PersonDto request) {

        return personService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        personService.delete(id);
    }
}
