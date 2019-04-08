package com.igorrogachev.athenaeum.businessDomain;

import com.igorrogachev.athenaeum.utils.constants.FormatConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthorTrans {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;

    @DateTimeFormat(pattern = FormatConstants.COMMON_DATE_FORMAT_YYYY_MM_DD)
    private Date year;

    private String biography;

    public AuthorTrans() {
        firstName = new String();
        middleName = new String();
        lastName = new String();
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
    }

    public AuthorTrans(String firstName, String middleName, String lastName, Date year, String biography) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.year = year;
        this.biography = biography;
    }

    public String getFullName() {
        String fullNameOut = new StringBuffer(firstName).append(" ").append(middleName).append(" ").append(lastName).toString();
        return fullNameOut;
    }

    public String getYearForDisplay() {
        return new SimpleDateFormat(FormatConstants.COMMON_DATE_FORMAT_YYYY_MM_DD).format(year);
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

//        <p>Отчество: <input type="text" th:field="*{middleName}" /></p>


}
