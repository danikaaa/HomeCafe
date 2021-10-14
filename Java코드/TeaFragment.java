package com.example.mycafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TeaFragment extends Fragment {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v =inflater.inflate(R.layout.fragment_tea, container, false);

        btn1 = (Button) v.findViewById(R.id.btn1);
        btn2 = (Button) v.findViewById(R.id.btn2);
        btn3 = (Button) v.findViewById(R.id.btn3);
        btn4 = (Button) v.findViewById(R.id.btn4);
        btn5 = (Button) v.findViewById(R.id.btn5);
        btn6 = (Button) v.findViewById(R.id.btn6);
        btn7 = (Button) v.findViewById(R.id.btn7);
        btn8 = (Button) v.findViewById(R.id.btn8);

        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coffeecg.com/product/list.html?cate_no=158"));
                startActivity(mIntent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.shopping.naver.com/search/all?query=%EC%BB%A4%ED%94%BC%EB%A8%B8%EC%8B%A0&bt=0&frm=NVSCPRO"));
                startActivity(mIntent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafetera.co.kr/shop/shopbrand.html?type=X&xcode=006"));
                startActivity(mIntent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafetera.co.kr/shop/shopbrand.html?type=M&xcode=008&mcode=001&scode=001"));
                startActivity(mIntent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafetera.co.kr/shop/shopbrand.html?type=M&xcode=011&mcode=001"));
                startActivity(mIntent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafetera.co.kr/shop/shopbrand.html?type=M&xcode=014&mcode=001"));
                startActivity(mIntent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafetera.co.kr/shop/shopbrand.html?type=X&xcode=004"));
                startActivity(mIntent);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cafetera.co.kr/shop/shopbrand.html?xcode=001&type=M&mcode=004"));
                startActivity(mIntent);
            }
        });

        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
