package ro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.converter.PaperConverter;
import ro.dto.PaperDto;
import ro.service.PaperService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperConverter paperConverter;

    @RequestMapping(value = "/papers", method = RequestMethod.GET)
    public List<PaperDto> getPapers() {
        return new ArrayList<PaperDto>(this.paperConverter.convertModelsToDtos(paperService.getPapers()));
    }
}
