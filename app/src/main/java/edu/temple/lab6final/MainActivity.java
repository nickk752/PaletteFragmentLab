package edu.temple.lab6final;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;


public class MainActivity extends Activity implements PaletteFragment.CanLaunchCanvasFragment {

    PaletteFragment paletteFragment;
    String[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = this.getResources();

        colors = res.getStringArray(R.array.colors);

        FragmentManager fm = getFragmentManager();

        paletteFragment = PaletteFragment.newInstance(colors);



        fm.beginTransaction().addToBackStack(null).replace(R.id.fragmentFrameLayout, paletteFragment).commit();


    }

    @Override
    public void launchCanvasFragment(int color){
        CanvasFragment canvasFragment = CanvasFragment.newInstance(color);
        getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragmentFrameLayout, canvasFragment).commit();
    }

}
