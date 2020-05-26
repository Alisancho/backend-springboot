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
public class TaskSearchValues {
    private String title;
    private Integer completed;
    private Long priorityId;
    private Long categoryId;

    // постраничность
    private Integer pageNumber;
    private Integer pageSize;

    // сортировка
    private String sortColumn;
    private String sortDirection;
}
