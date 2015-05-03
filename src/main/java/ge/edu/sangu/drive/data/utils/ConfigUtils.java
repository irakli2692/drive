package ge.edu.sangu.drive.data.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class ConfigUtils {

	private ConfigUtils() {}

	private static final String CONFIG_FILE_NAME = "drive.yml";

	private static final String[] LOCATIONS = {"user.home", "catalina.home"};

	private static Map<String, Object> CONFIGS = null;

	static {
		loadConfigs();
	}

	@SuppressWarnings("unchecked")
	private static void loadFile(File file) {
		try {
			CONFIGS = (Map<String, Object>) new Yaml().load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void loadDefaultFile() {

		File configFile = new File(ConfigUtils.class.getClassLoader().getResource(CONFIG_FILE_NAME).getFile());
		loadFile(configFile);
	}

	private static void loadConfigs() {

		boolean loaded = false;
		for (String location : LOCATIONS) {
			String filePath = location + System.getProperty("file.separator") + CONFIG_FILE_NAME;
			File configFile = new File(filePath);

			if (configFile.exists()) {
				loadFile(configFile);
				loaded = true;
				break;
			}
		}

		if (!loaded) {
			loadDefaultFile();
		}
	}

	public static <T> T getConfig(String key, Class<T> type) {
		Object obj = CONFIGS.get(key);
		return type.cast(obj);
	}
}
