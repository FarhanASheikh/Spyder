package Utilities;

import java.util.HashMap;

public class ThreadStorage {

    private static HashMap<String, String> storage;

    static {
        storage = new HashMap<>();
    }

    public static void put(String key, String value) {
        storage.put(Thread.currentThread().getId() + key, value);
    }

    public static String get(String key) {
        return storage.get(Thread.currentThread().getId() + key);
    }
}
