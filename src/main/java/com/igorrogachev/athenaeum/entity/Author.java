package com.igorrogachev.athenaeum.entity;

import com.igorrogachev.athenaeum.utils.constants.ColumnNameConstants;
import com.igorrogachev.athenaeum.utils.constants.ConstrainsErrorConstants;
import com.igorrogachev.athenaeum.utils.constants.FormatConstants;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table (uniqueConstraints = {@UniqueConstraint(columnNames = {ColumnNameConstants.FIRST_NAME, ColumnNameConstants.MIDDLE_NAME, ColumnNameConstants.LAST_NAME, ColumnNameConstants.YEAR})})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = ConstrainsErrorConstants.FIRST_NAME_MAY_NOT_BE_NULL)
    @NotEmpty(message = ConstrainsErrorConstants.FIRST_NAME_MAY_NOT_BE_EMPTY)
    private String firstName;

    private String middleName;

    private String lastName;

    @NotNull(message = ConstrainsErrorConstants.YEAR_MAY_NOT_BE_NULL)
    @DateTimeFormat(pattern = FormatConstants.COMMON_DATE_FORMAT_YYYY_MM_DD)
    private Date year;

    @Lob
    private String biography;

    public Author() {
    }

    public Author(@NotNull(message = ConstrainsErrorConstants.FIRST_NAME_MAY_NOT_BE_NULL) @NotEmpty(message = ConstrainsErrorConstants.FIRST_NAME_MAY_NOT_BE_EMPTY) String firstName, String middleName, String lastName, @NotNull(message = ConstrainsErrorConstants.YEAR_MAY_NOT_BE_NULL) Date year, String biography) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.year = year;
        this.biography = biography;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public long getId() {
        return id;
    }
}
