package com.nyfaria.upgradedchests.block.api;

public enum UpgradedChestType {
    OAK("oak"),
    SPRUCE("spruce"),
    BIRCH("birch"),
    JUNGLE("jungle"),
    ACACIA("acacia"),
    DARK_OAK("dark_oak"),
    CRIMSON("crimson"),
    WARPED("warped");

    private final String loc;

    UpgradedChestType(String loc) {
        this.loc = loc;
    }
    public String getLoc() {
        return loc;
    }
}
