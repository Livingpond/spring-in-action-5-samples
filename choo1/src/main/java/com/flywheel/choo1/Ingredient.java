package com.flywheel.choo1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author yekw
 * @date 2022/6/17/10:28
 * @description:
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
