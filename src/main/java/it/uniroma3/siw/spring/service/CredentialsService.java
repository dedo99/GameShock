package it.uniroma3.siw.spring.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.repository.CredentialsRepository;

@Service
public class CredentialsService {
	
	@Autowired
    protected PasswordEncoder passwordEncoder;

	@Autowired
	protected CredentialsRepository credenzialiRepository;
	
	@Transactional
	public Credentials getCredentials(Long id) {
		Optional<Credentials> result = this.credenzialiRepository.findById(id);
		return result.orElse(null);
	}

	@Transactional
	public Credentials getCredentials(String username) {
		Optional<Credentials> result = this.credenzialiRepository.findByUsername(username);
		return result.orElse(null);
	} 
	
	@Transactional
	public boolean alreadyExistsByUsername(Credentials credenziali) {
		Optional<Credentials> opt = this.credenzialiRepository.findByUsername(credenziali.getUsername());
		return opt.isPresent();
	}
	
	@Transactional
    public Credentials saveCredentials(Credentials credentials) {
        credentials.setRole(Credentials.ADMIN_ROLE);
        credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
        return this.credenzialiRepository.save(credentials);
    }
}
