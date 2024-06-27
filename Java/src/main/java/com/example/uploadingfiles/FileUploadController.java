package com.example.uploadingfiles;

import java.io.IOException;
import java.util.stream.Collectors;

import com.example.uploadingfiles.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.exceptions.TemplateInputException;

@Controller
public class FileUploadController {

	private final StorageService storageService;
	private VolumeData volumeData;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@PostMapping("/kitchen-jam-frontend")
	@ResponseBody
	public void kitchenJamDistUpload(@RequestParam("file") MultipartFile file) {
		StorageProperties properties = new StorageProperties(volumeData.getKitchenJamDist() + "/foo");
		FileSystemStorageService service = new FileSystemStorageService();
		service.setStorageProperties(properties);
		service.deleteAll();

		StorageProperties properties2 = new StorageProperties(volumeData.getKitchenJamDist());
		service.setStorageProperties(properties2);
		service.store(file);
		service.unzipDist();
	}

	@PostMapping("/train-tracker-frontend")
	@ResponseBody
	public void trainTrackerDistUpload(@RequestParam("file") MultipartFile file) {
		StorageProperties properties = new StorageProperties(volumeData.getTrainTrackerDist() + "/foo");
		FileSystemStorageService service = new FileSystemStorageService();
		service.setStorageProperties(properties);
		service.deleteAll();

		StorageProperties properties2 = new StorageProperties(volumeData.getTrainTrackerDist());
		service.setStorageProperties(properties2);
		service.store(file);
		service.unzipDist();
	}

	@PostMapping("/virtual-vibes-frontend")
	@ResponseBody
	public void virtualVibesDistUpload(@RequestParam("file") MultipartFile file) {
		StorageProperties properties = new StorageProperties(volumeData.getVirtualVibesDist() + "/foo");
		FileSystemStorageService service = new FileSystemStorageService();
		service.setStorageProperties(properties);
		service.deleteAll();

		StorageProperties properties2 = new StorageProperties(volumeData.getVirtualVibesDist());
		service.setStorageProperties(properties2);
		service.store(file);
		service.unzipDist();
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
