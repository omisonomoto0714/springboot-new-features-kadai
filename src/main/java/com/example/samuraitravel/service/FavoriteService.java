package com.example.samuraitravel.service;

import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.repository.FavoriteRepository;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.repository.UserRepository;

@Service
public class FavoriteService {
	private final FavoriteRepository favoriteRepository;
	private final HouseRepository houseRepository;
	private final UserRepository userRepository;

	public FavoriteService(FavoriteRepository favoriteRepository, HouseRepository houseRepository,
			UserRepository userRepository) {

		this.favoriteRepository = favoriteRepository;
		this.houseRepository = houseRepository;
		this.userRepository = userRepository;
	}

	//お気に入り追加
//	@Transactional
//	public void
//	Favorite favorite=new Favorite();
//	}

	public boolean keep(House house, User user) {

		return favoriteRepository.findByHouseAndUser(house, user) != null;

	}

	//	@Transactional
	//	public void keep (FavoriteKeepForm favoriteKeepForm) {
	//		
	//		
	//	}
	//	favorite.setHouse(favoriteKeepForm.getHaouse)

}
