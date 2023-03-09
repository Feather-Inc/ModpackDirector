package net.jan.moddirector.core.configuration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InstallationPolicy {
    private final boolean continueOnFailedDownload;
    private final String optionalKey;
    private final boolean selectedByDefault;
    private final String name;
    private final String description;
    private final boolean extract;
    private final boolean downloadAlways;
    private final String supersede;

    @JsonCreator
    public InstallationPolicy(
            @JsonProperty(value = "continueOnFailedDownload") boolean continueOnFailedDownload,
            @JsonProperty(value = "optionalKey") String optionalKey,
            @JsonProperty(value = "selectedByDefault") Boolean selectedByDefault,
            @JsonProperty(value = "name") String name,
            @JsonProperty(value = "description") String description,
            @JsonProperty(value = "extract") boolean extract,
            @JsonProperty(value = "downloadAlways") boolean downloadAlways,
            @JsonProperty(value = "supersede") String supersede
    ) {
        this.continueOnFailedDownload = continueOnFailedDownload;
        this.optionalKey = optionalKey;
        this.selectedByDefault = selectedByDefault != null ? selectedByDefault : optionalKey != null;
        this.name = name;
        this.description = description;
        this.extract = extract;
        this.downloadAlways = downloadAlways;
        this.supersede = supersede;
    }

    public boolean shouldContinueOnFailedDownload() {
        return continueOnFailedDownload;
    }

    public String getOptionalKey() {
        return optionalKey;
    }

    public boolean isSelectedByDefault() {
        return selectedByDefault;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean shouldExtract() {
        return extract;
    }

    public boolean shouldDownloadAlways() {
        return downloadAlways;
    }

    public String getSupersededFileName() {
        return supersede;
    }
}
