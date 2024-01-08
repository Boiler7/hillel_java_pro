package hw31.mvc;

import hw25.patterns.integration.testing.HeroDto;
import hw25.patterns.integration.testing.HeroService;
import hw28.rest.HeroCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class SpringMvcController {
    private final HeroService heroService;

    @GetMapping
    public String heroes(Model model) {
//           model.addAttribute("hero", "movie");
        model.addAttribute("heroes", heroService.getHeroes());
        return "heroes.mvc/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("hero", HeroDto.builder().build());
        return "heroes.mvc/create";
    }

    @PostMapping("/add")
    public String create(HeroCreationRequest request) {
        heroService.create(request);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        var hero = heroService.getHeroById(id);

        model.addAttribute("hero", hero);
        return "heroes.mvc/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("hero") HeroDto heroDto) {
        heroService.updateHero(id, heroDto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        heroService.delete(id);

        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("hero", heroService.getHeroById(id));
        return "view";
    }
}