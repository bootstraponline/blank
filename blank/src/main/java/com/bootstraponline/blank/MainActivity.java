package com.bootstraponline.blank;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.service.wallpaper.WallpaperService;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;

import static android.graphics.Bitmap.createBitmap;

@TargetApi(17) // required so Android Studio's Lint doesn't complain
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WallpaperManager wall = WallpaperManager.getInstance(getApplicationContext());
        final Display display = getWindowManager().getDefaultDisplay();

        // Works on API 17. Older Androids don't have .getSize()
        final Point size = new Point();
        display.getSize(size);
        Bitmap image = createBitmap(size.x, size.y, Bitmap.Config.RGB_565);
        image.eraseColor(Color.BLACK);

        try {
            wall.setBitmap(image);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finish(); // we're done
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}