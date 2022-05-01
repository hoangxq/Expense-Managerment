package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Wallet;
import com.demo.repository.WalletRepository;
import com.demo.service.impl.WalletServiceImpl;

@Service
public class WalletService implements WalletServiceImpl{
	
	@Autowired
	private WalletRepository walletRepository;

	@Override
	public List<Wallet> getAllWallet() {
		return walletRepository.findAll();
	}

	@Override
	public Wallet getWalletById(Long id) {
		return walletRepository.findById(id).get();
	}

	@Override
	public Wallet createWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	@Override
	public Wallet editWallet(Wallet wallet, Long id) {
		
		Wallet walletInDB = walletRepository.findById(id).get();
		
		walletInDB.setBalance(wallet.getBalance());
		walletInDB.setName(wallet.getName());
		walletInDB.setUser(wallet.getUser());
		
		return walletRepository.save(walletInDB);
		
	}

	@Override
	public void deleteWallet(Wallet wallet) {
		walletRepository.delete(wallet);
	}

}
