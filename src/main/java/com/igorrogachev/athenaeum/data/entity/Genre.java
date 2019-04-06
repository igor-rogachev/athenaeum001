package com.igorrogachev.athenaeum.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Genre {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    /*
    @Column(nullable=false)
    это как бы работает (кривовато: пустое поле в строку все же пишется, но ошибка так же стартует :-) ),
    но почему-то в DDL для поля NorNull не подоставляет
    Отсюда
    https://www.baeldung.com/java-bean-validation-not-null-empty-blank
    берем конструкцию
    @NotNull(message = "Name may not be null")
    эта конструкция ведет себя аналогичным образом
    пока оставим это
    Похоже, что эта конструкция работает только при создании таблицы
     */
    // @Column(nullable=false)
    @NotNull(message = "Name may not be null")
    @NotEmpty(message = "Name may not be empty")
    private String name;

    public Genre() {
    }

    public Genre(@NotNull(message = "Name may not be null")
                 @NotEmpty(message = "Name may not be empty") String name) {
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
