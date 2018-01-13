package com.phppoets.newapp.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.io.File;


public class ThreeFragment extends Fragment {
    private static final int GET_FROM_GALLERY = 1;
    private static final int RESULT_OK = -1;
    ImageView imgNominee1, imageNominee2;
    ImageView btnNom1, btnNom2;
    String path, path1, path2;
    boolean isFirst;

    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgNominee1 = (ImageView) view.findViewById(R.id.imgNominee1);
        imageNominee2 = (ImageView) view.findViewById(R.id.imgNominee2);
        btnNom1 = (ImageView) view.findViewById(R.id.btnImgNom1);
        btnNom2 = (ImageView) view.findViewById(R.id.btnImgNom2);
        btnNom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1Upload();
                isFirst = true;
            }
        });
        btnNom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1Upload();
                isFirst = false;

            }
        });
    }

    private void image2Upload() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select picture"), GET_FROM_GALLERY);
    }

    private void image1Upload() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select picture"), GET_FROM_GALLERY);
    }

    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == GET_FROM_GALLERY) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    // Get the path from the Uri
                    path = getPathFromURI(selectedImageUri);
                    if (isFirst) {
                        Picasso.with(getActivity()).load(new File(path)).into(imgNominee1);

                    } else {
                        Picasso.with(getActivity()).load(new File(path)).into(imageNominee2);

                    }
                    // Set the image in ImageView
                    //imgPerson.setImageURI(selectedImageUri);
                }
            }
        }

    }
}
