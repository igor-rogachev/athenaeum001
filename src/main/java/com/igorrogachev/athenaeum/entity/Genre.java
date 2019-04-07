package com.igorrogachev.athenaeum.entity;

import com.igorrogachev.athenaeum.utils.constants.ConstrainsErrorConstants;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Genre {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotNull(message = ConstrainsErrorConstants.NAME_MAY_NOT_BE_NULL)
    @NotEmpty(message = ConstrainsErrorConstants.NAME_MAY_NOT_BE_EMPTY)
    private String name;

    public Genre() {
    }

    public Genre(@NotNull(message = ConstrainsErrorConstants.NAME_MAY_NOT_BE_NULL)
                 @NotEmpty(message = ConstrainsErrorConstants.NAME_MAY_NOT_BE_EMPTY) String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
