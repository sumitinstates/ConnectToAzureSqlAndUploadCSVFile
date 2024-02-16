package com.example.sqldemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

		// Save the file to a temporary location
		File tempFile = File.createTempFile("csv-file", ".csv");
		file.transferTo(tempFile);

		// Parse the file to extract the data
		List<User> users = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				User user = new User(fields[1], fields[2]);
				/*System.out.println(fields[0]);
				System.out.println(fields[1]);
				System.out.println(fields[2]);*/
				
				// user.setName(fields[0]);
				// user.setEmail(fields[1]);
				users.add(user);
			}
		}

		// Save the data to the database
		userRepository.saveAll(users);

		// Delete the temporary file
		tempFile.delete();

		return ResponseEntity.ok("File uploaded successfully!");

	}
}
