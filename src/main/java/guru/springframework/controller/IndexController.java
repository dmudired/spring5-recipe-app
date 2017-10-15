package guru.springframework.controller;

import guru.springframework.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /*
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository){
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/", "/index"})
    public String getIndex(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("AMERICAN");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Pinch");
        System.out.println("categoryOptional AMERICAN getID::" +categoryOptional.get().getId());
        System.out.println("unitOfMeasure Pinch ID::  " + unitOfMeasure.get().getId());

        return "index";
    }
    */
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipe", "", "/"})
    public String getRecipes(Model model){
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }
}
