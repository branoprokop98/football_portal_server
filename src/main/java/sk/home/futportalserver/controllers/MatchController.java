package sk.home.futportalserver.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("match")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MatchController {
}
