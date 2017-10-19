package edu.temple.lab6final;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by nick on 10/2/2017.
 */

public class PaletteAdapter extends ArrayAdapter<String>{

    String[] colors;

    public PaletteAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        this.colors = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView myView = (TextView) super.getView(position, convertView, parent);

        myView.setText(this.colors[position]);
        switch (position) {
            case 0:
                myView.setBackgroundColor(Color.BLUE);
                break;
            case 1:
                myView.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                myView.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                myView.setBackgroundColor(Color.RED);
                break;
            case 4:
                myView.setBackgroundColor(Color.MAGENTA);
                break;
            case 5:
                myView.setBackgroundColor(Color.WHITE);
                break;
            case 6:
                myView.setTextColor(Color.WHITE);
                myView.setBackgroundColor(Color.BLACK);
                break;
            case 7:
                myView.setBackgroundColor(Color.GRAY);
                break;
            case 8:
                myView.setBackgroundColor(Color.LTGRAY);
                break;
            case 9:
                myView.setBackgroundColor(Color.DKGRAY);
                break;
        }

        return myView;
    }
}
