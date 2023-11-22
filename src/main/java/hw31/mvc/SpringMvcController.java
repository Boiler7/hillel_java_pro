package hw31.mvc;

import HW25_Patterns_Integration_Testing.HeroDto;
import HW25_Patterns_Integration_Testing.HeroService;
import HW28_REST.HeroCreationRequest;
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
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("hero", HeroDto.builder().build());
        return "create";
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
        return "edit";
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