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
public class AdeFragment extends Fragment {
    private Activity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_ade, container, false);

        activity = getActivity();

        GridView gv = (GridView) view.findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(view.getContext());
        gv.setAdapter(gAdapter);

        return view;
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        Integer[] posterID = {R.drawable.strawberryccc, R.drawable.blueberryccc,R.drawable.lemonccc,
                R.drawable.mangoccc};

        String[] posterTitle = {"딸기청", "블루베리청", "레몬청", "망고청", "바닐라라떼", "달고나라떼"};
        String[] postertext = {"1.유리병을 소독해준다. \n 2. 딸기 꼭지를 따고 씻어준다.\n 3. 딸기 물기를 제거해준다.\n 4. 딸기를 잘게자른다. " +
                "\n 5. 딸기와 설탕의 비율 1:1로 넣어준다. \n 6. 잘 저어주면서 설탕이 녹을때 까지 저어준다 \n 7. 소독한 유리병에 넣어준다.",
                "1.유리병을 소독해준다. \n 2. 블루베리를 씻어준다.\n 3. 블루베리 물기를 제거해준다.\n 4. 블루베리와 설탕의 비율 1:1로 넣어준다. \n " +
                        "6. 잘 저어주면서 설탕이 녹을때 까지 저어준다 \n 7. 소독한 유리병에 넣어준다.",
                "1.유리병을 소독해준다. \n 2. 레몬을 베이킹소다로 빡빡 씻어준다.\n 3.레몬의 물기 제거해준다.\n 4. 레몬을 얇게 잘게자른다. " +
                        "\n 5. 레몬과 설탕의 비율을 1:1로 하여 소독한 유리병에 넣어준다.",
                "1.유리병을 소독해준다. \n 2. 망고의 껍질을 벗겨준다. \n 3. 망고를 잘게 자른다." +
                        "\n 4. 딸기와 설탕의 비율 1:1로 넣어준다. \n 5. 잘 저어주면서 설탕이 녹을때 까지 저어준다 \n 6. 소독한 유리병에 넣어준다.",
               };

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
