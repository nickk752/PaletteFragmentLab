package edu.temple.lab6final;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;



public class PaletteFragment extends Fragment {



    private String[] colors;
    CanLaunchCanvasFragment parent;


    public PaletteFragment() {
        // Required empty public constructor
    }


    public static PaletteFragment newInstance(String[] colors) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putSerializable("colors", colors);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colors = (String[]) getArguments().getSerializable("colors");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palette, container, false);

        GridView colorGridView = view.findViewById(R.id.colorGridView);
        colorGridView.setAdapter(new PaletteAdapter(view.getContext(), android.R.layout.simple_list_item_1, colors));
        colorGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                parent.launchCanvasFragment(getColor(i));
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        parent = (CanLaunchCanvasFragment) activity;
    }

    private int getColor(int position){
        switch (position) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.RED;
            case 4:
                return Color.MAGENTA;
            case 5:
                return Color.WHITE;
            case 6:
                return Color.BLACK;
            case 7:
                return Color.GRAY;
            case 8:
                return Color.LTGRAY;
            case 9:
                return Color.DKGRAY;
        }
        return Color.WHITE;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface CanLaunchCanvasFragment {
        // TODO: Update argument type and name
        void launchCanvasFragment(int color);
    }
}
