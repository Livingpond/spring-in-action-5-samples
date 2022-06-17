package com.flywheel.choo1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

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
    private Date createdAt;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
