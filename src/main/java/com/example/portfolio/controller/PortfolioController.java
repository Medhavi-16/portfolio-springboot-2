package com.example.portfolio.controller;

import java.util.List;

import com.example.portfolio.model.Socials;
import com.example.portfolio.service.SocialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

	@Autowired
	private SocialsService socialsService;

	/**
	 * This is the landing page
	 * @return
	 */
	@GetMapping("/home")
	public String home() {
		return "Home Page";
	}

	/**
	 * Get all social media handles
	 * @return list of all social handle
	 */
	@GetMapping("/socials")
	public List<Socials> getSocials() {
		return this.socialsService.getSocials();
	}

	/**
	 * @param socialId Name for the desired social media
	 * @return handle details for the required social media
	 */
	@GetMapping("/socials/{socialId}")
	public Socials getSocials(@PathVariable String socialId) {
		return this.socialsService.getSocials(socialId);
	}

	/**
	 * can also use , (path = "/socials", consumes = "application/json") in mapping
	 * @param socials new social media handle
	 * @return social media handle that is created
	 */
	@PostMapping(path = "/socials")
	public Socials addSocials(@RequestBody Socials socials) {
		return this.socialsService.addSocials(socials);
	}

	/**
	 *
	 * @param socials update to social handle
	 * @return updated social handle
	 */
	@PutMapping(path = "/socials")
	public Socials updateSocials(@RequestBody Socials socials) {
		return this.socialsService.updateSocials(socials);
	}

	/**
	 *
	 * @param socialId key to social handle to be deleted
	 * @return deleted social handle
	 */
	@DeleteMapping("/socials/{socialId}")
	public ResponseEntity<HttpStatus> deleteSocials(@PathVariable String socialId) {
		try {
			this.socialsService.deleteSocials(socialId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
