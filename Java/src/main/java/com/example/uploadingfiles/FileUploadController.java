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
	private VolumeData volumeData = new VolumeData();

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@PostMapping("/will-barnard")
	@ResponseBody
	public void willBarnardUpload(@RequestParam("file") MultipartFile file) {
		StorageProperties properties = new StorageProperties(volumeData.getWillBarnard() + "/foo");
		FileSystemStorageService service = new FileSystemStorageService();
		service.setStorageProperties(properties);
		service.deleteAll();

		StorageProperties properties2 = new StorageProperties(volumeData.getWillBarnard());
		service.setStorageProperties(properties2);
		service.store(file);
		service.unzip(file.getOriginalFilename());
		System.out.println("updated kitchen jam frontend");
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
		service.unzip(file.getOriginalFilename());
		System.out.println("updated kitchen jam frontend");
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
		service.unzip(file.getOriginalFilename());
		System.out.println("updated train tracker frontend");

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
		service.unzip(file.getOriginalFilename());
		System.out.println("updated virtual vibes frontend");

	}

	@PostMapping("/kitchen-jam-backend")
	@ResponseBody
	public void kitchenJamJarUpload(@RequestParam("file") MultipartFile file) {

		FileSystemStorageService service = new FileSystemStorageService();
		StorageProperties properties = new StorageProperties(volumeData.getKitchenJamJar());
		service.setStorageProperties(properties);
		service.store(file);
		System.out.println("updated kitchen jam jar");

	}

	@PostMapping("/train-tracker-backend")
	@ResponseBody
	public void trainTrackerBackendUpload(@RequestParam("file") MultipartFile file) {

		FileSystemStorageService service = new FileSystemStorageService();
		StorageProperties properties = new StorageProperties(volumeData.getTrainTrackerBackend());
		service.setStorageProperties(properties);
		service.store(file);
		System.out.println("updated train tracker backend jar");

	}

	@PostMapping("/train-tracker-ls")
	@ResponseBody
	public void trainTrackerLsUpload(@RequestParam("file") MultipartFile file) {

		FileSystemStorageService service = new FileSystemStorageService();
		StorageProperties properties = new StorageProperties(volumeData.getTrainTrackerLsService());
		service.setStorageProperties(properties);
		service.store(file);
		System.out.println("updated train tracker ls jar");

	}

	@PostMapping("/train-tracker-run")
	@ResponseBody
	public void trainTrackerRunUpload(@RequestParam("file") MultipartFile file) {

		FileSystemStorageService service = new FileSystemStorageService();
		StorageProperties properties = new StorageProperties(volumeData.getTrainTrackerRunService());
		service.setStorageProperties(properties);
		service.store(file);
		System.out.println("updated train tracker rs jar");

	}

	@PostMapping("/virtual-vibes-backend")
	@ResponseBody
	public void virtualVibesBackendUpload(@RequestParam("file") MultipartFile file) {

		FileSystemStorageService service = new FileSystemStorageService();
		StorageProperties properties = new StorageProperties(volumeData.getVirtualVibesJar());
		service.setStorageProperties(properties);
		service.store(file);
		System.out.println("updated virtual vibes jar");

	}

	@PostMapping("/cash-critters")
	@ResponseBody
	public void cashCrittersDistUpload(@RequestParam("file") MultipartFile file) {
		StorageProperties properties = new StorageProperties(volumeData.getCashCrittersDist() + "/foo");
		FileSystemStorageService service = new FileSystemStorageService();
		service.setStorageProperties(properties);
		service.deleteAll();

		StorageProperties properties2 = new StorageProperties(volumeData.getCashCrittersDist());
		service.setStorageProperties(properties2);
		service.store(file);
		service.unzip(file.getOriginalFilename());
		System.out.println("updated cash critters frontend");

	}

	@PostMapping("/bttb-frontend")
	@ResponseBody
	public void bttbDistUpload(@RequestParam("file") MultipartFile file) {
		StorageProperties properties = new StorageProperties(volumeData.getBttbDist() + "/foo");
		FileSystemStorageService service = new FileSystemStorageService();
		service.setStorageProperties(properties);
		service.deleteAll();

		StorageProperties properties2 = new StorageProperties(volumeData.getBttbDist());
		service.setStorageProperties(properties2);
		service.store(file);
		service.unzip(file.getOriginalFilename());
		System.out.println("updated bttb frontend");

	}

	@PostMapping("/bttb-backend")
	@ResponseBody
	public void bttbBackendUpload(@RequestParam("file") MultipartFile file) {

		FileSystemStorageService service = new FileSystemStorageService();
		StorageProperties properties = new StorageProperties(volumeData.getBttbJar());
		service.setStorageProperties(properties);
		service.store(file);
		System.out.println("updated bttb jar");

	}

	@PostMapping("/antonio")
	@ResponseBody
	public void antonioUpload(@RequestParam("file") MultipartFile file) {
		StorageProperties properties = new StorageProperties(volumeData.getAntonio() + "/foo");
		FileSystemStorageService service = new FileSystemStorageService();
		service.setStorageProperties(properties);
		service.deleteAll();

		StorageProperties properties2 = new StorageProperties(volumeData.getAntonio());
		service.setStorageProperties(properties2);
		service.store(file);
		service.unzip(file.getOriginalFilename());
		System.out.println("updated antonio");

	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
