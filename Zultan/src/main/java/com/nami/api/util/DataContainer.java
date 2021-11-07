package com.nami.api.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

		BufferedReader br = new BufferedReader(new FileReader(file));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null)
			sb.append(line);
		br.close();

		String json = sb.toString();
		data = mapper.readValue(json, new TypeReference<Map<K, V>>() {
		});
	}

	public void save() throws IOException {
		if (!file.exists())
			file.createNewFile();

		BufferedWriter bw = new BufferedWriter(new FileWriter(file));

		String json = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(data);
		bw.write(json);
		bw.flush();
		bw.close();
	}

	public File getFile() {
		return file;
	}

	public Map<K, V> getData() {
		return data;
	}

}
