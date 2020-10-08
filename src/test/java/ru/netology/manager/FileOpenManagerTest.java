package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    FileOpenManager manager = new FileOpenManager();
    Collection<String> testSet = new TreeSet<>();
    String firstExt = ".iml";
    String firstApp = "IDEA";
    String secondExt = ".Md";
    String secondApp = "Atom";
    String thirdExt = ".TXT";
    String thirdApp = "Notepad";

    /* Регистрировать новое приложение для открытия файлов с определённым расширением */
    @BeforeEach
    void setUp() {
        manager.register(firstExt, firstApp);
        manager.register(secondExt, secondApp);
        manager.register(thirdExt, thirdApp);
        testSet.add(firstExt.toLowerCase());
        testSet.add(secondExt.toLowerCase());
        testSet.add(thirdExt.toLowerCase());
    }

    /* Получать название приложения, предназначенного для открытия файла с определённым расширением */
    @Test
    public void shouldSearchApplication() {
        assertEquals(secondApp, manager.getAppTitle(secondExt));
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
        assertEquals(testSet, manager.allExtensions());
    }

    /* Получать список всех приложений, которые привязаны к каким-либо расширениям */
    @Test
    public void shouldGetAllApplications() {
        assertEquals(List.of(thirdApp, secondApp, firstApp), manager.allApps());
    }
}