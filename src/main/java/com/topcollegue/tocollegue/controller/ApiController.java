package com.topcollegue.tocollegue.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcollegue.tocollegue.entity.Collegue;
import com.topcollegue.tocollegue.repository.CollegueRepository;
import com.topcollegue.tocollegue.service.model.Avis;

@RestController
@RequestMapping("/api/top/collegues")
public class ApiController {

	@Autowired
	CollegueRepository cRepo;

	@GetMapping()
	public List<Collegue> searchAll() {
		return cRepo.findAll();
	}

	@PatchMapping("/{pseudo}")
	public ResponseEntity<?> updateScore(@PathVariable String pseudo, @RequestBody Avis avis) {

		Optional<Collegue> collegue = cRepo.findByName(pseudo);

		if (collegue.isPresent()) {
			if (avis.getAction().equals(com.topcollegue.tocollegue.entity.Avis.AIMER)) {
				Integer newScore = collegue.get().getScore() + 10;
				collegue.get().setScore(newScore);
			} else {
				Integer newScore = collegue.get().getScore() - 5;
				collegue.get().setScore(newScore);
			}
		    return ResponseEntity.ok(cRepo.save(collegue.get()));
		} else {
			// ResponseEntity.status(HttpStatus.CREATED)
			return ResponseEntity.badRequest().body("Pas de collègue trouvé pour le pseudo :" + pseudo + "!");
		}
	}

}
