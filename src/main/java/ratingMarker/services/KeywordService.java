package ratingMarker.services;

/*
 * Created by iGilga on 28.01.2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratingMarker.models.Keyword;
import ratingMarker.repositories.KeywordRepository;

import java.util.List;

@Service
public class KeywordService {

    private KeywordRepository keywordRepository;

    @Autowired
    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public List GetAll() {
        return keywordRepository.getAll();
    }

    public Keyword getById(int id) {
        return keywordRepository.getById(id);
    }

    public void add(Keyword keyword) {
        keywordRepository.save(keyword);
    }

    public void update(Keyword keyword) {
        keywordRepository.update(keyword);
    }

    public void remove(Keyword keyword) {
        keywordRepository.delete(keyword);
    }
}
