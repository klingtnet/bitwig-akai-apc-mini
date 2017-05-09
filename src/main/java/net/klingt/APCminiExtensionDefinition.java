package net.klingt;

import java.util.UUID;

import com.bitwig.extension.api.PlatformType;
import com.bitwig.extension.controller.AutoDetectionMidiPortNamesList;
import com.bitwig.extension.controller.ControllerExtensionDefinition;
import com.bitwig.extension.controller.api.ControllerHost;

public class APCminiExtensionDefinition extends ControllerExtensionDefinition {
    private static final UUID DRIVER_ID = UUID.fromString("76514ff0-f4e4-4bc0-b4e0-f7b00f0af0fc");

    public APCminiExtensionDefinition() {
    }

    @Override
    public String getName() {
        return "APCmini";
    }

    @Override
    public String getAuthor() {
        return "klingtnet";
    }

    @Override
    public String getVersion() {
        return "0.1";
    }

    @Override
    public UUID getId() {
        return DRIVER_ID;
    }

    @Override
    public String getHardwareVendor() {
        return "AKAI";
    }

    @Override
    public String getHardwareModel() {
        return "APCmini";
    }

    @Override
    public int getRequiredAPIVersion() {
        return 3;
    }

    @Override
    public int getNumMidiInPorts() {
        return 1;
    }

    @Override
    public int getNumMidiOutPorts() {
        return 1;
    }

    private static final String[] DISCOVERY_NAME = new String[]{"APC MINI MIDI 1"};

    @Override
    public void listAutoDetectionMidiPortNames(final AutoDetectionMidiPortNamesList list, final PlatformType platformType) {
        if (platformType == PlatformType.WINDOWS) {
            list.add(DISCOVERY_NAME, DISCOVERY_NAME);
            } else if (platformType == PlatformType.MAC) {
            list.add(DISCOVERY_NAME, DISCOVERY_NAME);
        } else if (platformType == PlatformType.LINUX) {
            list.add(DISCOVERY_NAME, DISCOVERY_NAME);
        }
    }

    @Override
    public APCminiExtension createInstance(final ControllerHost host) {
        return new APCminiExtension(this, host);
    }
}
