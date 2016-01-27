package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/*
 * Created by iGilga on 27.01.2016.
 */
@Entity
public class Keyword {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "keyword")
    private Set<Word> words = new HashSet<Word>();

    public Keyword() {
        //jpa only
    }

    public Keyword(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Word> getWords() {
        return words;
    }
}
