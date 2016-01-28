package ratingMarker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratingMarker.models.Subword;
import ratingMarker.repositories.SubwordRepository;

import java.util.List;

/*
 * Created by iGilga on 28.01.2016.
 */
@Service
public class SubwordService {
    private SubwordRepository subwordRepository;

    @Autowired
    public SubwordService(SubwordRepository subwordRepository) {
        this.subwordRepository = subwordRepository;
    }

    public List GetAll() {
        return subwordRepository.getAll();
    }

    public Subword getById(int id) {
        return subwordRepository.getById(id);
    }

    public void add(Subword subword) {
        subwordRepository.save(subword);
    }

    public void update(Subword subword) {
        subwordRepository.update(subword);
    }

    public void remove(Subword subword) {
        subwordRepository.delete(subword);
    }
}
