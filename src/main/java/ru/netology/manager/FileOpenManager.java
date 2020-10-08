package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    Map<String, String> fileOpenManager = new HashMap<>();

    /* Регистрировать новое приложение для открытия файлов с определённым расширением */
    public void register(String key, String value) {
        fileOpenManager.put(key.toLowerCase(), value);
    }

    /* Получать название приложения, предназначенного для открытия файла с определённым расширением */
    public String getAppTitle(String key) {
        return fileOpenManager.get(key.toLowerCase());
    }

    /* Удалять привязку приложения к определённому расширению */
    public void disableAssociation(String key) {
        fileOpenManager.remove(key.toLowerCase());
    }

    /* Получать список всех зарегистрированных расширений, к которым привязаны приложения для открытия */
    public Collection<String> allExtensions() {
        return new TreeSet<>(fileOpenManager.keySet());
    }

    /* Получать список всех приложений, которые привязаны к каким-либо расширениям */
    public Collection<String> allApps() {
        return new ArrayList<>(fileOpenManager.values());
    }
}