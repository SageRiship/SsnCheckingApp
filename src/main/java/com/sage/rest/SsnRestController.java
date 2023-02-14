package com.sage.rest;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SsnRestController {

	@GetMapping("/ssn/{ssn}")
	public ResponseEntity<String> checkSsn(@PathVariable String ssn) {
		if (ssn.length() != 9) {
			return new ResponseEntity<>("SSN should be of 9 digits", HttpStatus.BAD_REQUEST);
		} else {
			String generatedPwd = generatePwd();
			return new ResponseEntity<>(generatedPwd, HttpStatus.OK);
		}
	}

	public String generatePwd() {
		String[] arr = { "New Jersey", "Ohio", "Hawaii", "Florida", "California", "Texas", "New Jersey", "New Jersey",
				"New Jersey" };

		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int index = random.nextInt(arr.length);
		String randomChar = arr[index];
		sb.append(randomChar);

		return sb.toString();
	}

}
