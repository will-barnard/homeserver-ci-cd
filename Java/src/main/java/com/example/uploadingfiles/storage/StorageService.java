package com.example.uploadingfiles.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

	void setStorageProperties(StorageProperties properties);

	void store(MultipartFile file);

	void unzipDist();

	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

	void deleteAll();

}
