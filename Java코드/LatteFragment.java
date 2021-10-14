package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//
public class LatteFragment extends Fragment {
    private Activity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_latte, container, false);

        activity = getActivity();

        GridView gv = (GridView) view.findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(view.getContext());
        gv.setAdapter(gAdapter);

        return view;
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        Integer[] posterID = {R.drawable.strawberrylatte, R.drawable.chamomile,R.drawable.pomegranateaid,
                R.drawable.lemonade, R.drawable.blueberryade,R.drawable.mangoade,
                R.drawable.mugwortlatte,R.drawable.strawberryade, R.drawable.greentealatte,
                };

        String[] posterTitle = {"딸기라떼", "국화차", "석류에이드",
                "레몬에이드", "블루베리에이드", "망고에이드",
                "말차라떼", "딸기에이드","쑥라떼"};

        String[] postertext = {"1. 딸기청을 1/4정도 넣는다. \n 2. 얼음을 넣는다. \n 3. 우유를 넣어준다. \n 4. 마지막으로 딸기를 올려준다.",
                "1. 유리컵에 뜨거운 물을 넣어준다. \n 2. 국화를 넣어준다.",
                "1. 석류청을 1/4정도 넣는다. \n 2. 얼음을 넣는다. \n 3. 탄산수 혹은 사이다를 넣어준다. \n 4. 잘 섞어서 마시면 완성",
                "1. 레몬청을 1/4정도 넣는다. \n 2. 얼음을 넣는다. \n 3. 탄산수 혹은 사이다를 넣어준다.",
                "1. 블루베리청을 1/4정도 넣는다. \n 2. 얼음을 넣는다. \n 3. 탄산수 혹은 사이다를 넣어준다. \n 4. 위에 블루베리를 올려준다.",
                "1. 망고청을 1/4정도 넣는다. \n 2. 얼음을 넣는다. \n 3. 탄산수 혹은 사이다를 넣어준다. \n 4. 위에 망고를 올려준다.",
                "1. 얼음을 넣는다. \n 2. 우유를 넣는다. \n 3.녹차가루3티스푼, 시럽3티스푼, 우유조금을 넣어 가루를 녹여준다. \n 4. 녹인 녹차가루를 올려준다.",
                "1. 딸기청을 1/4정도 넣는다. \n 2. 얼음을 넣는다. \n 3. 탄산수 혹은 사이다를 넣어준다. \n 4. 위에 딸기를 올려준다.",
                "1. 얼음을 넣는다. \n 2. 우유를 넣는다. \n 3.쑥가루3티스푼, 시럽3티스푼, 우유조금을 넣어 가루를 녹여준다. \n 4. 녹인 쑥가루를 올려준다."};

        public MyGridAdapter(Context c) {
            context = c;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return position;
        }

        public int getCount(){
            return  posterID.length;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(500, 550));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(
                            activity, R.layout.coffee_americano, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(
                            activity);
                    ImageView ivPoster = (ImageView) dialogView
                            .findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setView(dialogView);
                    dlg.setMessage(postertext[pos]);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });


            return imageview;
        }

    }

}
