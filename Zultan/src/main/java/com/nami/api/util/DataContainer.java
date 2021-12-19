package com.nami.api.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataContainer<K, V> {

	private File file;
	private Map<K, V> data = new HashMap<K, V>();
	private ObjectMapper mapper = new ObjectMapper();

	public DataContainer(File file) {
		this.file = file;
	}

	public DataContainer(String path) {
		this.file = new File(path);
	}

	public void load() throws IOException {
		if (!file.exists())
			return;

		data = mapper.readValue(Files.readAllBytes(file.toPath()), new TypeReference<Map<K, V>>() {
		});
	}

	public void save() throws IOException {
		if (!file.exists())
			file.createNewFile();

		mapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
	}

	public File getFile() {
		return file;
	}

	public Map<K, V> getData() {
		return data;
	}

}
