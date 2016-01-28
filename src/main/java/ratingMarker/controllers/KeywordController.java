package ratingMarker.controllers;
/*
 * Created by postiaddGilga on 27.01.2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ratingMarker.models.Keyword;
import ratingMarker.services.KeywordService;

import java.util.List;

@RestController()
@RequestMapping("/keywords")
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    @RequestMapping(method = RequestMethod.GET)
    public List get() {
        return keywordService.GetAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Keyword getId(@PathVariable int id){
        return keywordService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST,consumes="application/json")
    public void post(@RequestBody Keyword keyword) {
        keywordService.add(keyword);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void put(@PathVariable int id, @RequestBody Keyword keyword) {
        keyword.setId(id);
        keywordService.update(keyword);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        Keyword keyword = new Keyword();
        keyword.setId(id);
        keywordService.remove(keyword);
    }
}
