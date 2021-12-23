package com.nami.api.plugin.module;

import java.util.ArrayList;
import java.util.List;

public interface APIComponentLoader {

	public List<APIComponent> list = new ArrayList<>();

	public void add();

	public void load();

	public void enable();

}
