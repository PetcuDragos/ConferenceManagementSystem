package ro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.converter.PaperConverter;
import ro.converter.PublishedPaperConverter;
import ro.dto.PaperDto;
import ro.dto.PublishedPaperDto;
import ro.service.PaperService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private PublishedPaperConverter publishedPaperConverter;

    @RequestMapping(value = "/papers", method = RequestMethod.GET)
    public List<PublishedPaperDto> getPapers() {
        return new ArrayList<PublishedPaperDto>(this.publishedPaperConverter.convertModelsToDtos(paperService.getPapers()));
    }
}
