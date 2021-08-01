package com.example.portfolio.controller;

import java.util.List;

import com.example.portfolio.model.Profile;
import com.example.portfolio.model.Projects;
import com.example.portfolio.model.Socials;
import com.example.portfolio.service.ProfileService;
import com.example.portfolio.service.ProjectsService;
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

	@Autowired
	private ProfileService profileService;

	@Autowired
	private ProjectsService projectsService;

	/**
	 * This is the landing page
	 * @return
	 */
	@GetMapping("/home")
	public Profile home() {
		return profileService.getProfile();
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

	@GetMapping("/projects")
	public List<Projects> getProjects() {
		return this.projectsService.getProjects();
	}

	@GetMapping("/projects/{projectId}")
	public Projects getProject(@PathVariable String projectId) {
		return this.projectsService.getProject(projectId);
	}

	@PostMapping("/projects")
	public Projects addProject(@RequestBody Projects project) {
		return  this.projectsService.addProject(project);
	}

	@PutMapping("/projects")
	public Projects updateProject(@RequestBody Projects project) {
		return  this.projectsService.updateProject(project);
	}

	@DeleteMapping("/projects/{projectId}")
	public ResponseEntity<HttpStatus> deleteProject(@PathVariable String projectId) {
		try {
			this.projectsService.deleteProject(projectId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/about")
	public Profile addProfile(@RequestBody Profile profile) {
		return profileService.addProfile(profile);
	}

	@PutMapping("/about")
	public Profile updateProfile(@RequestBody Profile profile) {
		return profileService.updateProfile(profile);
	}

	@PutMapping("/about/description={description}")
	public Profile updateDescription(@PathVariable String description) {
		return profileService.updateProfile("description", description);
	}
}
