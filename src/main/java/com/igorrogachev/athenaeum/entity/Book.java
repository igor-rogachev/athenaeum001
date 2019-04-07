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
@Table(uniqueConstraints={@UniqueConstraint(columnNames={ColumnNameConstants.TITLE, ColumnNameConstants.YEAR})})
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull(message = ConstrainsErrorConstants.TITLE_MAY_NOT_BE_NULL)
    @NotEmpty(message = ConstrainsErrorConstants.TITLE_MAY_NOT_BE_EMPTY)
    private String title;

    @NotNull(message = ConstrainsErrorConstants.YEAR_MAY_NOT_BE_NULL)
    @DateTimeFormat(pattern = FormatConstants.COMMON_DATE_FORMAT_YYYY_MM_DD)
    private Date year;

    @NotNull(message = ConstrainsErrorConstants.GENRE_MAY_NOT_BE_NULL)
    @ManyToOne(fetch = FetchType.EAGER)
    private Genre genre;

    @Transient
    @NotEmpty(message = ConstrainsErrorConstants.TEMP_GENRE_ID_INPUT_MAY_NOT_BE_EMPTY)
    private String tempGenreIdInput;

    public Book() {
    }

    public Book(
            @NotNull(message = ConstrainsErrorConstants.TITLE_MAY_NOT_BE_NULL)
            @NotEmpty(message = ConstrainsErrorConstants.TITLE_MAY_NOT_BE_EMPTY) String title,
            @NotNull(message = ConstrainsErrorConstants.YEAR_MAY_NOT_BE_NULL) Date year,
            @NotNull(message = ConstrainsErrorConstants.GENRE_MAY_NOT_BE_NULL) Genre genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Book(
            @NotNull(message = ConstrainsErrorConstants.TITLE_MAY_NOT_BE_NULL)
            @NotEmpty(message = ConstrainsErrorConstants.TITLE_MAY_NOT_BE_EMPTY) String title,
            @NotNull(message = ConstrainsErrorConstants.YEAR_MAY_NOT_BE_NULL) Date year,
            @NotEmpty(message = ConstrainsErrorConstants.TEMP_GENRE_ID_INPUT_MAY_NOT_BE_EMPTY) String tempGenreIdInput) {
        this.title = title;
        this.year = year;
        this.tempGenreIdInput = tempGenreIdInput;
    }

    public String getTempGenreIdInput() {
        return tempGenreIdInput;
    }

    public void setTempGenreIdInput(String tempGenreIdInput) {
        this.tempGenreIdInput = tempGenreIdInput;
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

    public long getId() {
        return id;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
