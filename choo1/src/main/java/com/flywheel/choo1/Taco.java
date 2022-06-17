package com.flywheel.choo1;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yekw
 * @date 2022/6/17/10:45
 * @description:
 */
@Data
public class Taco {

    private long id;
    private Date createdAt;

    // end::allButValidation[]
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    // tag::allButValidation[]
    private String name;
    // end::allButValidation[]
    @Size(min=1, message="You must choose at least 1 ingredient")
    // tag::allButValidation[]
    private List<String> ingredients;
}
