package ratingMarker.controllers;

/*
 * Created by iGilga on 28.01.2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ratingMarker.models.Subword;
import ratingMarker.services.SubwordService;

import java.util.List;

@RestController()
@RequestMapping("/subwords")
public class SubwordController {
    @Autowired
    private SubwordService subwordService;

    @RequestMapping(method = RequestMethod.GET)
    public List get() {
        return subwordService.GetAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Subword getById(@PathVariable int id){
        return subwordService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void post(@RequestBody Subword keyword) {
        subwordService.add(keyword);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void put(@PathVariable int id, @RequestBody Subword keyword) {
        keyword.setId(id);
        subwordService.update(keyword);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        Subword subword = new Subword();
        subword.setId(id);
        subwordService.remove(subword);
    }
}
