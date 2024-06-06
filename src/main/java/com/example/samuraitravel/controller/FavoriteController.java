package com.example.samuraitravel.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.samuraitravel.entity.Favorite;
import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.repository.FavoriteRepository;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.repository.UserRepository;

@Controller
public class FavoriteController {

	private final FavoriteRepository favoriteRepository;
	private final HouseRepository houseRepository;
	private final UserRepository userRepository;

	public FavoriteController(FavoriteRepository favoriteRepository, HouseRepository houseRepository,
			UserRepository userRepository) {
		this.favoriteRepository = favoriteRepository;
		this.houseRepository = houseRepository;
		this.userRepository = userRepository;
	}

	@GetMapping("/favorites")
	public String index(@PathVariable(name = "houseId") Integer houseId,
//			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable, Model model) {

		House house = houseRepository.getReferenceById(houseId);
//		User user = userDetailsImpl.getUser();
		Page<Favorite> favoritePage = favoriteRepository.findByHouse(house, pageable);

		model.addAttribute("house", house);
		model.addAttribute("favoritePage", favoritePage);

		return "favorites/index";
	}
}
