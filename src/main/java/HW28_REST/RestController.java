package HW28_REST;

import HW25_Patterns_Integration_Testing.HeroDto;
import HW25_Patterns_Integration_Testing.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestController {
    private final HeroService heroService;

    @GetMapping("/heroes")
        public List<HeroDto> getStudents(){
            return heroService.getHeroes();
        }

    @GetMapping("/heroes{id}")
    public HeroDto getStudent(@PathVariable("id") long heroId){
        return heroService.getHeroById(heroId);
    }

    @PostMapping("/heroes{id}")
    public void createHeroes(@RequestBody HeroCreationRequest request){
        heroService.create(request);
    }

    @PutMapping("/heroes{id}")
    public HeroDto modifyHeroes(@PathVariable("id") long heroId, HeroDto heroDto){
        return heroService.updateHero(heroId, heroDto);
    }
    @DeleteMapping("/heroes{id}")
    public boolean deleteHeroes(@PathVariable("id") long heroId){
        return heroService.delete(heroId);
    }
}