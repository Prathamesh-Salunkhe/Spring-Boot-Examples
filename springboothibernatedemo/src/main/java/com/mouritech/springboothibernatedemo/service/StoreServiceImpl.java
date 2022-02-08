package com.mouritech.springboothibernatedemo.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.springboothibernatedemo.entity.Store;
import com.mouritech.springboothibernatedemo.exception.StoreNotFoundException;
import com.mouritech.springboothibernatedemo.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Store insertProduct(Store newStore) {
	
		newStore.setStoreId(generateStoreId());
		return storeRepository.save(newStore);
	}
	
	
	public String generateStoreId() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 255;
	        //generate random values from 0-254
	      Long sId = (long) rand.nextInt(upperbound);
		return "P00" + sId; 
	
	}


	@Override
	public Store showStoreById(String storeId) throws StoreNotFoundException {
		// TODO Auto-generated method stub
		return storeRepository.findByStoreId(storeId).orElseThrow(() -> new StoreNotFoundException("store not found with id " + storeId));
	}


	@Override
	public List<Store> showAllStores() {
		// TODO Auto-generated method stub
		return storeRepository.findAll();
	}


	@Override
	public Store updateStoreById(String storeId,Store store) throws StoreNotFoundException {
		Store existingStore = storeRepository.findByStoreId(storeId).orElseThrow(() -> new StoreNotFoundException("Store not found with id " + storeId));
		existingStore.setStoreCity(store.getStoreCity());
		existingStore.setStoreCountry(store.getStoreCountry());
		storeRepository.save(existingStore);
		return existingStore;
	}


	@Override
	public void deleteStoreById(String storeId) throws StoreNotFoundException {
		Store existingStore = storeRepository.findByStoreId(storeId).orElseThrow(() -> new StoreNotFoundException("Store not found with id " + storeId));
		storeRepository.delete(existingStore);
	}

}



