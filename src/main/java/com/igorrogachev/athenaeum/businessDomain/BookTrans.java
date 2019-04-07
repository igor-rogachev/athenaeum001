package com.igorrogachev.athenaeum.businessDomain;

import com.igorrogachev.athenaeum.utils.constants.FormatConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookTrans {
    private long id;
    private String title;

    @DateTimeFormat(pattern = FormatConstants.COMMON_DATE_FORMAT_YYYY_MM_DD)
    private Date year;

    private String yearStringInOut;
    private String genreStringIntInOut;
    private int genreIntIn;
    private String genreStringOut;

    public BookTrans(long id, String title, Date year, String yearStringInOut, String genreStringIntInOut, int genreIntIn, String genreStringOut) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.yearStringInOut = yearStringInOut;
        this.genreStringIntInOut = genreStringIntInOut;
        this.genreIntIn = genreIntIn;
        this.genreStringOut = genreStringOut;
    }

    public BookTrans() {
        title = new String();
        year = new Date();
        yearStringInOut = new String();
        genreStringIntInOut = new String();
        genreStringOut = new String();
    }

    public String getGenreStringOut() {
        return genreStringOut;
    }

    public void setGenreStringOut(String genreStringOut) {
        this.genreStringOut = genreStringOut;
    }

    public BookTrans(String title, String yearStringInOut, String genreStringIntInOut) {
        this.title = title;
        this.yearStringInOut = yearStringInOut;
        this.genreStringIntInOut = genreStringIntInOut;
        SimpleDateFormat sdf = new SimpleDateFormat(FormatConstants.COMMON_DATE_FORMAT_YYYY_MM_DD);
        try {
            this.year = sdf.parse(this.yearStringInOut);
        } catch (ParseException e) {
            this.year = new Date();
        }
        this.genreIntIn = Integer.parseUnsignedInt(genreStringIntInOut);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getYearStringInOut() {
        return yearStringInOut;
    }

    public void setYearStringInOut(String yearStringInOut) {
        this.yearStringInOut = yearStringInOut;
    }

    public String getGenreStringIntInOut() {
        return genreStringIntInOut;
    }

    public void setGenreStringIntInOut(String genreStringIntInOut) {
        this.genreStringIntInOut = genreStringIntInOut;
    }

    public int getGenreIntIn() {
        return genreIntIn;
    }

    public void setGenreIntIn(int genreIntIn) {
        this.genreIntIn = genreIntIn;
    }
}
