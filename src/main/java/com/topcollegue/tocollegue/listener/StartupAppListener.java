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

		String urlImage = "https://www.secretaire-inc.com/wp-content/uploads/2017/03/top_colleague.jpg";

		cRepo.save(new Collegue(0, "Guillaume", urlImage, 0));
		cRepo.save(new Collegue(0, "Valentin", urlImage, 0));
		cRepo.save(new Collegue(0, "Victor", urlImage, 0));
		cRepo.save(new Collegue(0, "Emmanuelle", urlImage, 0));
		cRepo.save(new Collegue(0, "Alexis", urlImage, 0));
		cRepo.save(new Collegue(0, "Axel", urlImage, 0));
		cRepo.save(new Collegue(0, "Kevin", urlImage, 0));
	}

}
