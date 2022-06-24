package com.flywheel.choo1.data;

import com.flywheel.choo1.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author yekw
 * @date 2022/6/17/14:47
 * @description:
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
