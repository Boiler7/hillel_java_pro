package HW28_REST;

import HW24_JDBC.Hero;
import HW24_JDBC.HeroDaoImplementation;
import HW25_Patterns_Integration_Testing.HeroDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestController {
    private final HeroDaoImplementation heroDaoImpl;

    @GetMapping("/heroes")
        public List<Hero> getStudents(){
            return heroDaoImpl.findAll();
        }

    @GetMapping("/heroes{id}")
    public List<Hero> getStudent(@PathVariable("id") long heroId){
        return heroDaoImpl.findById(heroId);
    }

    @GetMapping("/heroes{id}")
    public void createHeroes(@RequestBody Hero request){
        return heroDaoImpl.create(request);
    }

    @GetMapping("/heroes{id}")
    public Hero modifyHeroes(@PathVariable("id") long heroId){
        return heroDaoImpl.update();
    }
    @GetMapping("/heroes{id}")
    public HeroDto deleteHeroes(@PathVariable("id") long heroId){
        return heroDaoImpl.delete(request);
    }
}