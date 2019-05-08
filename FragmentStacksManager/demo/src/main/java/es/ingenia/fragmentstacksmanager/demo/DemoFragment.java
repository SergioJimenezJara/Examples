package es.ingenia.fragmentstacksmanager.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


public class DemoFragment extends Fragment {

    int level = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            level = getArguments().getInt("level", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        view.setBackgroundColor(color);

        ((TextView)view.findViewById(R.id.textView)).setText("Nivel " + level);
        view.findViewById(R.id.nextLevel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DemoActivity)DemoFragment.this.getActivity()).pushNewFragmentOnStack(level + 1);
            }
        });

        return view;
    }

}
