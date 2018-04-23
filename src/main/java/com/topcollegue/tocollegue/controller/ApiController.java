package com.topcollegue.tocollegue.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.topcollegue.tocollegue.entity.Collegue;
import com.topcollegue.tocollegue.repository.CollegueRepository;
import com.topcollegue.tocollegue.service.model.ApiCollegue;
import com.topcollegue.tocollegue.service.model.Avis;
import com.topcollegue.tocollegue.service.model.LightCollegue;
import com.topcollegue.tocollegue.service.model.NewCollegue;

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

	// rechercher un collègue par matricule et l'ajouter à la base de données s'il
	// est trouvé
	@PostMapping("/nouveau")
	public ResponseEntity<?> ajouterCollegue(@RequestBody NewCollegue newCollegue) {

		RestTemplate restTemplate = new RestTemplate();

		ApiCollegue[] gotCollegues = restTemplate
				.getForObject("http://collegues-api.cleverapps.io/collegues?matricule=" + newCollegue.getMatricule(),
						ApiCollegue[].class);

		Optional<ApiCollegue> apiCollegue = Stream.of(gotCollegues)
				.filter(c -> c != null && c.getMatricule().equals(newCollegue.getMatricule())).findFirst();

		if (apiCollegue.isPresent()) {
			String name = apiCollegue.get().getName();
			String urlImage = newCollegue.getUrlImage().isEmpty() ? apiCollegue.get().getPhoto()
					: newCollegue.getUrlImage();
			Integer score = LightCollegue.SCORE_INITIAL;
			String prenom = apiCollegue.get().getPrenom();
			String pseudo = newCollegue.getPseudo();
			String email = apiCollegue.get().getEmail();
			String adresse = apiCollegue.get().getAdresse();

			Collegue col;
			Optional<Collegue> existingCollegue = cRepo.findByLightColleguePseudo(pseudo);
			if (existingCollegue.isPresent()) {
				col = existingCollegue.get();
			} else {
				col = new Collegue();
			}

			col.setAdresse(adresse);
			col.setEmail(email);
			col.setLightCollegue(new LightCollegue(pseudo, score, urlImage));
			col.setName(name);
			col.setPrenom(prenom);

			return ResponseEntity.ok(cRepo.save(col));
		}

		return ResponseEntity.badRequest()
				.body("Pas de collègue trouvé pour le matricule :" + newCollegue.getMatricule() + "!");
	}

}
