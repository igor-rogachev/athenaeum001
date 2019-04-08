package com.igorrogachev.athenaeum.businessDomain;

import com.igorrogachev.athenaeum.utils.constants.FormatConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AuthorTrans {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullNameOut;

    @DateTimeFormat(pattern = FormatConstants.COMMON_DATE_FORMAT_YYYY_MM_DD)
    private Date year;

    private String biography;

    public AuthorTrans() {
        firstName = new String();
        middleName = new String();
        lastName = new String();
        fullNameOut = new String();
        year = new Date();
        biography = new String();
    }

    public AuthorTrans(long id, String firstName, String middleName, String lastName, Date year, String biography) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.year = year;
        this.biography = biography;
        fullNameOut = new StringBuffer(firstName).append(" ").append(middleName).append(" ").append(lastName).toString();
    }

    public long getId() {
        return id;
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

    public String getFullNameOut() {
        return fullNameOut;
    }

    public void setFullNameOut(String fullNameOut) {
        this.fullNameOut = fullNameOut;
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
}
