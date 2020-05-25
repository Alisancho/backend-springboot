package com.javabegin.backendspringboot.search;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ApiModel(value = "class search")
public class CategorySearchValues {
    private String text;
}
