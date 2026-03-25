package com.kendiadin.client.modules;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final List<Module> modules = new ArrayList<>();

    public static void init() {
        // Yazdığımız modülü listeye ekliyoruz
        modules.add(new FullBright());
    }

    public static List<Module> getModules() {
        return modules;
    }
}
