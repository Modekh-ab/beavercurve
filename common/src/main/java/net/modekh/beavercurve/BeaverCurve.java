package net.modekh.beavercurve;

public class BeaverCurve {
    public static void init() {
        System.out.println(ModExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
