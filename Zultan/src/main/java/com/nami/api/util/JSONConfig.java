package com.nami.api.util;

import java.io.File;
import java.util.Map;

public class JSONConfig<K, V> {

	private Map<K, V> defaults;
	private DataContainer<K, V> data;

	public JSONConfig(String path) {
		data = new DataContainer<>(new File(path));
	}

	public JSONConfig(File file) {
		data = new DataContainer<>(file);
	}

	public Map<K, V> getDefaults() {
		return defaults;
	}

	public DataContainer<K, V> getDataContainer() {
		return data;
	}

}
