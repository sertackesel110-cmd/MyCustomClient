package com.kendiadin.client.modules;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final List<Module> modules = new ArrayList<>();

    public static void init() {
        // Hileleri buraya tek tek ekleyeceğiz (Birazdan FullBright'ı buraya yazacağız)
    }

    public static List<Module> getModules() {
        return modules;
    }
}

