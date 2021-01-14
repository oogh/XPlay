package xplay.xplay;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

/**
 * Created by Administrator on 2018-03-11.
 */

public class OpenUrl extends AppCompatActivity {
    private Button btfile;
    private Button btrtmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.openurl);
        btfile = findViewById(R.id.playvideo);
        final String path = getPrivateExternalFilesDir(this, "") + "jieqian_720x1280.mp4";
        btfile.setOnClickListener(view -> {
                    EditText t = findViewById(R.id.fileurl);
                    //用户输入的URL，打开视频
                    Open(path);

                    //关闭当前窗口
                    finish();
                }
        );


        btrtmp = findViewById(R.id.playrtmp);
        btrtmp.setOnClickListener(view -> {
            EditText t = findViewById(R.id.rtmpurl);
            //用户输入的URL，打开视频
            Open(t.getText().toString());

            //关闭当前窗口
            finish();
        });
    }

    private static String getPrivateExternalFilesDir(Context context, String dirName) {
        try {
            String cachePath = null;
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                cachePath = context.getExternalFilesDir("").getAbsolutePath();
            } else {
                File cacheDir = context.getCacheDir();
                if (cacheDir != null && cacheDir.exists()) {
                    cachePath = cacheDir.getPath();
                }
            }
            return cachePath + File.separator + dirName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public native void Open(String url);

}
