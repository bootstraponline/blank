package com.bootstraponline.blank;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import static android.graphics.Bitmap.createBitmap;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // must call super.onCreate
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
}