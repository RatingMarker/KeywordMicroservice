package models;

/*
 * Created by iGilga on 27.01.2016.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Word {
    @Id
    @GeneratedValue
    private int id;

    private String Name;

    @JsonIgnore
    @ManyToOne
    private Keyword keyword;

    Word() {
        //jpa only
    }

    public Word(int id, String name, Keyword keyword) {
        this.id = id;
        Name = name;
        this.keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public Keyword getKeyword() {
        return keyword;
    }
}
