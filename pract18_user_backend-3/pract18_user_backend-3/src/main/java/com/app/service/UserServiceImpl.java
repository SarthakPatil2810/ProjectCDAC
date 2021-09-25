package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome_exception.UserHandlingException;
import com.app.dao.UserRepository;
import com.app.dto.LoginRequestDTO;
import com.app.pojos.User;

@Service
@Transactional

public class UserServiceImpl implements IUserService{
	@Autowired(required = true)
	private JavaMailSender mailSend;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUserDetails(User transientUser) {
		return userRepo.save(transientUser);
	}

	@Override
	public List<User> fetchAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password).orElseThrow(() -> new UserHandlingException("Invalid User details"));
	}

	@Override
	public User updateUserDetails(User detachUser) {
		// TODO Auto-generated method stub
		return userRepo.save(detachUser);
	}

	@Override
	public String forgotPassword(LoginRequestDTO req) {
		// TODO Auto-generated method stub
		User u = userRepo.findByEmail(req.getEmail());
		SimpleMailMessage msg = new SimpleMailMessage();
		System.out.println(req.getEmail());
		Random random = new Random();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomString = sb.toString();
		String pass = randomString + "#$" + random.nextInt(1000);
		System.out.println(pass);
		if (u != null) {

			msg.setTo(u.getEmail());
			msg.setSubject("Password forgot mail");
			msg.setText("hey " + u.getFirstName() + " ur password is " + pass + "set successfully");
			u.setPassword(pass);
			userRepo.save(u);
			mailSend.send(msg);
			return "password send to ur mail "+pass;
		}
		return "Sorry,Your Email Id is Not Exist!!..";
	}

}
