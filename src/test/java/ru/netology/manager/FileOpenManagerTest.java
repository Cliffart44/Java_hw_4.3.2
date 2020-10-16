package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    FileOpenManager manager = new FileOpenManager();
    Collection<String> testExtSet = new TreeSet<>();
    Collection<String> testAppSet = new TreeSet<>();
    String firstApp = "IDEA";
    String firstExt = ".iml";
    String secondApp = "Atom";
    String secondExt = ".Md";
    String thirdApp = "Notepad";
    String thirdExt = ".TXT";

    /* Регистрировать новое приложение для открытия файлов с определённым расширением */
    @BeforeEach
    void setUp() {
        manager.register(firstExt, firstApp);
        manager.register(secondExt, secondApp);
        manager.register(thirdExt, thirdApp);
        testExtSet.add(firstExt.toLowerCase());
        testExtSet.add(thirdExt.toLowerCase());
        testExtSet.add(secondExt.toLowerCase());
        testAppSet.add(secondApp.toLowerCase());
        testAppSet.add(firstApp.toLowerCase());
        testAppSet.add(thirdApp.toLowerCase());
    }

    /* Получать название приложения, предназначенного для открытия файла с определённым расширением */
    @Test
    public void shouldSearchApplication() {
        assertEquals(secondApp.toLowerCase(), manager.getAppTitle(secondExt));
    }

    /* Удалять привязку приложения к определённому расширению */
    @Test
    public void shouldRemoveAssociation() {
        manager.disableAssociation(secondExt);
        assertNull(manager.getAppTitle(secondExt));
    }

    /* Получать список всех зарегистрированных расширений, к которым привязаны приложения для открытия */
    @Test
    public void shouldGetAllExtensions() {
        assertEquals(testExtSet, manager.allExtensions());
    }

    /* Получать список всех приложений, которые привязаны к каким-либо расширениям */
    @Test
    public void shouldGetAllApplications() {
        assertEquals(testAppSet, manager.allApps());
    }
}