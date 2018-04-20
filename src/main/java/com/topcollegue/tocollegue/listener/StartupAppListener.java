package com.topcollegue.tocollegue.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.topcollegue.tocollegue.entity.Collegue;
import com.topcollegue.tocollegue.repository.CollegueRepository;

@Component
public class StartupAppListener {

	@Autowired
	CollegueRepository cRepo;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {

		final String DEFAULT_IMG = "https://www.secretaire-inc.com/wp-content/uploads/2017/03/top_colleague.jpg";
		final String HUGO_IMG = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Victor_Hugo_001.jpg/220px-Victor_Hugo_001.jpg";
		final String CHARLES_IMG = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/%C3%89tienne_Carjat%2C_Portrait_of_Charles_Baudelaire%2C_circa_1862.jpg/1200px-%C3%89tienne_Carjat%2C_Portrait_of_Charles_Baudelaire%2C_circa_1862.jpg";
		final String ARTHUR_IMG = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Rimbaud.PNG/220px-Rimbaud.PNG";
		final String GUSTAVE_IMG = "http://i-exc.ccm2.net/iex/1280/1250563238/740865.jpg";
		final String JEAN_IMG = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_bI64BsB5JDAjc0bW-BlwECK2uWin7TR1zPKC5b0WQ3BCn10yeSJ4PzdgVJob0jJgmmE";
		final String MARCEL_IMG = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcgNZpOWBn2O-qcr-nPiOqylc2d7hJPu7iQk9vtncxtlWGmles-apW-2iEj7qM8HOt5ZQ";
		final String ALBERT_IMG = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTte4uyTtq8Oeok3uR-DW3TnDRM01-Tam_8h9K_DZ8i_p_hWoPvOv8UDGSlMeHMtAC62V8";

		cRepo.save(new Collegue(0, "Hugo", HUGO_IMG, 0, "Victor", "vivigo", "victor@domain.com", "Besançon"));
		cRepo.save(new Collegue(0, "Baudelaire", CHARLES_IMG, 0, "Charles", "charly", "charles@domain.com", "Paris"));
		cRepo.save(new Collegue(0, "Flaubert", GUSTAVE_IMG, 0, "Gustave", "gugus", "gustave@domain.com", "Rouen"));
		cRepo.save(new Collegue(0, "Rimbaud", ARTHUR_IMG, 0, "Arthur", "tutur", "arthur@domain.com", "Charleville"));
		cRepo.save(new Collegue(0, "Rousseau", JEAN_IMG, 0, "Jean-Jacques", "jeanj", "jacques@domain.com", "Genève"));
		cRepo.save(new Collegue(0, "Proust", MARCEL_IMG, 0, "Marcel", "marcelp", "marcel@domain.com", "Paris"));
		cRepo.save(new Collegue(0, "Camus", ALBERT_IMG, 0, "Albert", "abbert", "albert@domain.com", "Mondovi"));
	}

}
