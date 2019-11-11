import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity {
    public static void main(String[] args) {
        initData();
    }

    private static void initData() {
        String jarPath = System.getProperty("user.dir");
        String targetApkPath = "";
        try {
            targetApkPath = jarPath+ResourceUtil.readResource(jarPath+"\\apk_name");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String outputApkPath = jarPath+"\\kydd";
        String channelFilePath = "";
        String channelFile = "";
        String channelJarFilePath = "";
        try {
            channelFile = MainActivity.class.getClassLoader().getResource("umeng-channel").getFile();
            channelFilePath = MainActivity.class.getClassLoader().getResource("umeng-channel").getPath();
            channelJarFilePath = MainActivity.class.getClassLoader().getResource("walle-cli-all.jar").getPath();
            String ChannelTxt = ResourceUtil.readResource(channelFile);
            String[] separated = ChannelTxt.split("\n");
            for (int i = 0; i < separated.length; i++) {
                Process proc = null;
                try {
                    String command = "java -jar " + channelJarFilePath.replaceFirst("/","") + " batch -f  " + channelFilePath.replaceFirst("/","")  + " " + targetApkPath + " " + outputApkPath;
                    System.out.println(command);
                    proc = Runtime.getRuntime().exec(command);
                    InputStream in = proc.getInputStream();
                    InputStream err = proc.getErrorStream();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
