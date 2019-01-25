package com.liugeng.liugengaliclouddemo.utils;

import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class JsonUtil {

	private static final Gson gson = new Gson();

	public static <T> T jsonToObject(String jsonStr, Class<T> clazz) {
		JsonReader jsonReader = new JsonReader(new StringReader(jsonStr));
		jsonReader.setLenient(true);
		return gson.fromJson(jsonReader, clazz);
	}

	public static JsonObject jsonToJsonObject(String jsonStr) {
		return gson.fromJson(jsonStr, JsonObject.class);
	}

}
