package com.topcollegue.tocollegue.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcollegue.tocollegue.entity.Collegue;
import com.topcollegue.tocollegue.repository.CollegueRepository;
import com.topcollegue.tocollegue.service.model.Avis;
import com.topcollegue.tocollegue.service.model.LightCollegue;

@RestController
@RequestMapping("/api/top/collegues")
@CrossOrigin("*")
public class ApiController {

	@Autowired
	CollegueRepository cRepo;

	// retourne la liste de collègue partiel
	@GetMapping()
	public List<LightCollegue> searchAll() {
		return cRepo.findAll().stream().map(c -> c.getLightCollegue()).collect(Collectors.toList());
	}

	// retourne un collègue complet
	@GetMapping("/{pseudo}")
	public ResponseEntity<?> search(@PathVariable String pseudo) {
		Optional<Collegue> collegue = cRepo.findByLightColleguePseudo(pseudo);

		if (collegue.isPresent()) {
			return ResponseEntity.ok(collegue.get());
		} else {
			// ResponseEntity.status(HttpStatus.CREATED)
			return ResponseEntity.badRequest().body("Pas de collègue trouvé pour le pseudo :" + pseudo + "!");
		}
	}

	// met à jour le scrore d'un collègue
	@PatchMapping("/{pseudo}")
	public ResponseEntity<?> updateScore(@PathVariable String pseudo, @RequestBody Avis avis) {

		Optional<Collegue> collegue = cRepo.findByLightColleguePseudo(pseudo);

		if (collegue.isPresent()) {
			if (avis.getAction().equals(com.topcollegue.tocollegue.entity.Avis.AIMER)) {
				Integer newScore = collegue.get().getLightCollegue().getScore() + 10;
				collegue.get().getLightCollegue().setScore(newScore);
			} else {
				Integer newScore = collegue.get().getLightCollegue().getScore() > 0
						? collegue.get().getLightCollegue().getScore() - 5
						: 0;
				collegue.get().getLightCollegue().setScore(newScore);
			}
			return ResponseEntity.ok(cRepo.save(collegue.get()).getLightCollegue());
		} else {
			// ResponseEntity.status(HttpStatus.CREATED)
			return ResponseEntity.badRequest().body("Pas de collègue trouvé pour le pseudo :" + pseudo + "!");
		}
	}

}
