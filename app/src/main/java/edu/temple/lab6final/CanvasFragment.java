package edu.temple.lab6final;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class CanvasFragment extends Fragment {

    int color;
    FrameLayout canvasFrameLayout;

    public CanvasFragment() {
        // Required empty public constructor
    }


    public static CanvasFragment newInstance(int color) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putInt("color", color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

        canvasFrameLayout = v.findViewById(R.id.canvasFrameLayout);
        if (getArguments() != null) {
            color = getArguments().getInt("color");
            canvasFrameLayout.setBackgroundColor(color);
        } else {
            canvasFrameLayout.setBackgroundColor(Color.BLUE);
        }
        return v;
    }


}
