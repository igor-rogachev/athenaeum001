package com.igorrogachev.athenaeum.data.entity;

        import org.springframework.format.annotation.DateTimeFormat;

        import javax.persistence.*;
        import javax.validation.constraints.NotEmpty;
        import javax.validation.constraints.NotNull;
        import java.util.Date;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"title", "year"})})
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull(message = "Title may not be null")
    @NotEmpty(message = "Title may not be empty")
    private String title;

    @NotNull(message = "Year may not be null")
    // @DateTimeFormat(pattern = "dd.mm.yyyy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date year;

    @NotNull(message = "Genre may not be null")
    @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn("genre_id")
    // @MapsId
    private Genre genre;

    @Transient
    @NotEmpty(message = "TempGenreIdInput may not be empty")
    private String tempGenreIdInput;

    public Book() {
    }

    public Book(
            @NotNull(message = "Title may not be null")
            @NotEmpty(message = "Title may not be empty") String title,
            @NotNull(message = "Year may not be null") Date year,
            @NotNull(message = "Genre may not be null") Genre genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Book(
            @NotNull(message = "Title may not be null")
            @NotEmpty(message = "Title may not be empty") String title,
            @NotNull(message = "Year may not be null") Date year,
            @NotEmpty(message = "TempGenreIdInput may not be empty") String tempGenreIdInput) {
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
