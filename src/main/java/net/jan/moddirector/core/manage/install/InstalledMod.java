package net.jan.moddirector.core.manage.install;

import java.nio.file.Path;
import java.util.Map;

public class InstalledMod {
    private final Path file;
    private final boolean inject;
    private final Map<String, Object> options;

    public InstalledMod(Path file, Map<String, Object> options, boolean inject) {
        this.file = file;
        this.inject = inject;
        this.options = options;
    }

    public Path getFile() {
        return file;
    }

    public boolean shouldInject() {
        return inject;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public boolean getOptionBoolean(String key, boolean defaultValue) {
        if (!options.containsKey(key)) {
            return defaultValue;
        }

        Object v = options.get(key);
        if (v instanceof Boolean) {
            return ((Boolean) v);
        }

        throw new IllegalArgumentException("Option " + key + " for mod file " + file.toString() + " should have been " +
            "a boolean, but found " + v.getClass().getName());
    }
}
