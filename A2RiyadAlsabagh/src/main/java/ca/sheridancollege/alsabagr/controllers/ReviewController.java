package ca.sheridancollege.alsabagr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.alsabagr.beans.Review;
import ca.sheridancollege.alsabagr.databases.DatabaseAccess;

@Controller
public class ReviewController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("review", new Review());

		return "index";
	}


	@PostMapping("/inputReview")
	public String inputReview(Model model, @ModelAttribute Review review) {

		da.inputReview(review);
		model.addAttribute("review", new Review());
		model.addAttribute("reviewList", da.viewReviews());

		return "index";
	}

}
