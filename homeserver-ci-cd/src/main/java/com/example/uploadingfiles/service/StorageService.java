package com.example.uploadingfiles.service;

import com.example.uploadingfiles.model.StorageProperties;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

	void setStorageProperties(StorageProperties properties);

	void store(MultipartFile file);

	void unzip(String filename);

	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

	void deleteAll();

}
