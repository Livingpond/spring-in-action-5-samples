package com.flywheel.choo1.web;

import com.flywheel.choo1.Ingredient;
import com.flywheel.choo1.Ingredient.Type;
import com.flywheel.choo1.Order;
import com.flywheel.choo1.Taco;
import com.flywheel.choo1.data.IngredientRepository;
import com.flywheel.choo1.data.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yekw
 * @date 2022/6/17/10:34
 * @description:
 */
@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    @Resource
    IngredientRepository ingredientRepository;

    @Resource
    TacoRepository tacoRepository;

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredientList = new ArrayList<>();

        ingredientRepository.findAll().forEach(i -> ingredientList.add(i));

//        List<Ingredient> ingredientList = Arrays.asList(
//                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
//                new Ingredient("GRBF", "Ground Beef",
//                        Type.PROTEIN),
//                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//                new Ingredient("TMTO",
//                        "Diced Tomatoes", Type.VEGGIES),
//                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//                new Ingredient("CHED", "Cheddar", Type.CHEESE),
//                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE)
//                , new Ingredient("SLSA", "Salsa", Type.SAUCE),
//                new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

        Type[] types = Ingredient.Type.values();
        for (Type type: types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredientList,type));
        }

        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@Valid  Taco taco, Errors error, @ModelAttribute Order order){
        if(error.hasErrors()){
            return "design";
        }
        Taco save = tacoRepository.save(taco);
//        log.info("Process design: " + taco);
        return "redirect:/orders/current";
    }


}
