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
public class CoffeeFragment extends Fragment {
    private Activity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_coffee, container, false);

        activity = getActivity();

        GridView gv = (GridView) view.findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(view.getContext());
        gv.setAdapter(gAdapter);

        return view;
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        Integer[] posterID = {R.drawable.americano, R.drawable.coffeelattee,R.drawable.condensedmilklatte,
                R.drawable.einspanner,R.drawable.caramel,R.drawable.cafemocha};

        String[] posterTitle = {"아메리카노", "카페라떼", "연유라떼", "아인슈페너", "카라멜마끼아또", "카페모카"};
        String[] postertext = {"1. 유리컵에 얼음을 넣는다.\n 2. 물을 2/3 만큼 넣는다 \n 3. 샷을 넣어준다",
                "1. 유리컵에 얼음을 넣는다.\n 2. 우유를 2/3 만큼 넣는다. \n 3. 샷을 넣어준다",
                "1. 유리컵에 얼음을 넣는다.\n 2. 우유를 2/3 만큼 넣는다. \n 4.연유를 조금 넣어 준다. \n3. 샷을 넣어준다",
                "1. 유리컵에 얼음을 넣는다. \n 2. 샷을 넣어준다. \n 3. 생크림100ml에 설탕을 조금 넣고 거품을 낸다. \n 4. 크림을 위에 올려준다.",
                "1. 유리컵에 얼음을 넣는다.\n 2. 우유를 2/3 만큼 넣는다. \n 3. 샷에 초코시럽을 섞어준다. \n 4. 컵에 샷을 넣어준다. \n 5. 생크림을 올리고 초코시럽을 뿌려준다.",};

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
