package com.igorrogachev.athenaeum.domain;

import javax.persistence.*;

@Entity
// @Table
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Genre {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    // @Column(unique = true)
    @Column(nullable=false)
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
