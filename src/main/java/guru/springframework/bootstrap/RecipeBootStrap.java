package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeBootStrap {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public RecipeBootStrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    private List<Recipe> getRecipies() {
        List<Recipe> recipies = new ArrayList<>(2);

        //get UOMs
        Optional<UnitOfMeasure> eachUOMOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUOMOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> dashUOMOptional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUOMOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> tableSpoonUOMOptional = unitOfMeasureRepository.findByDescription("TableSpoon");
        if(!tableSpoonUOMOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> pintUOMOptional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUOMOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> teaSpoonUOMOptional = unitOfMeasureRepository.findByDescription("TeaSpoon");
        if(!teaSpoonUOMOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> pinchUOMOptional = unitOfMeasureRepository.findByDescription("Pinch");
        if(!pinchUOMOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        Optional<UnitOfMeasure> cupsUOMOptional = unitOfMeasureRepository.findByDescription("Cups");
        if(!cupsUOMOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found");
        }

        UnitOfMeasure eachUom = eachUOMOptional.get();
        UnitOfMeasure pintUom = pintUOMOptional.get();
        UnitOfMeasure pinchUom = pinchUOMOptional.get();
        UnitOfMeasure cupsUom = cupsUOMOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUOMOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUOMOptional.get();
        UnitOfMeasure dasUom = dashUOMOptional.get();

        //get Categories
        Optional<Category> americanCatOptional = categoryRepository.findByDescription("AMERICAN");
        Optional<Category> indianCatOptional = categoryRepository.findByDescription("INDIAN");
        Optional<Category> mexicanCatOptional = categoryRepository.findByDescription("MEXICAN");
        Optional<Category> italianCatOptional = categoryRepository.findByDescription("ITALIAN");
        Optional<Category> fastFoodCatOptional = categoryRepository.findByDescription("FAST FOOD");
        Optional<Category> chineseCatOptional = categoryRepository.findByDescription("CHINESE");

        if(!americanCatOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        if(!mexicanCatOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        if(!indianCatOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        if(!italianCatOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        if(!fastFoodCatOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        if(!chineseCatOptional.isPresent()) {
            throw new RuntimeException("Category not found");
        }

        Category americanCat = americanCatOptional.get();
        Category indianCat = indianCatOptional.get();
        Category italianCat = italianCatOptional.get();
        Category mexicanCat = mexicanCatOptional.get();
        Category fastFoodCat = fastFoodCatOptional.get();
        Category chineseCat = chineseCatOptional.get();

        //Prepare the recipe
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacmole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(5);
        guacRecipe.setDifficulty(Difficulty.EASTY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4vPzZF9G5" +
               "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "Variations\n"
        );

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4vQ08IdSC");

        guacRecipe.setNotes(guacNotes);
        guacRecipe.getIngredients().add(new Ingredient("ripe avadocos", new BigDecimal(2), eachUom));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(1), teaSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice", new BigDecimal(1), tableSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion", new BigDecimal(2), tableSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(.5), pinchUom));
        guacRecipe.getIngredients().add(new Ingredient("cilantro (leaves and tender stems)", new BigDecimal(2), tableSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("Chillies", new BigDecimal(.1), teaSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("Chillies", new BigDecimal(.1), dasUom));

        guacRecipe.getCategories().add(americanCat);
        guacRecipe.getCategories().add(mexicanCat);

        recipies.add(guacRecipe);


        //Prepate Tacos recipe
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4vQ4vpelx");
        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("If you make this recipe, snap a pic and hashtag it #simplyrecipes — We love to see your creations");
        tacosRecipe.setNotes(tacosNotes);
        tacosRecipe.getIngredients().add(new Ingredient("ancho chili powder", new BigDecimal(2), tableSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("dried oregano", new BigDecimal(1), tableSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("dried cumin", new BigDecimal(2), teaSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal(.5), teaSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("garlic", new BigDecimal(2), dasUom));
        tacosRecipe.getIngredients().add(new Ingredient("packed baby arugula", new BigDecimal(3), cupsUom));
        tacosRecipe.getIngredients().add(new Ingredient("skinless, boneless chicken", new BigDecimal(6), eachUom));
        tacosRecipe.getIngredients().add(new Ingredient("radishes", new BigDecimal(4), eachUom));

        tacosRecipe.getCategories().add(indianCat);
        tacosRecipe.getCategories().add(fastFoodCat);
        tacosRecipe.getCategories().add(chineseCat);
        tacosRecipe.getCategories().add(indianCat);

        recipies.add(tacosRecipe);

        return recipies;
    }

}
