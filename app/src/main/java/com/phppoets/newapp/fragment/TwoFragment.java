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
import android.widget.Button;
import android.widget.ImageView;

import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;


public class TwoFragment extends Fragment {
    private static final int GET_FROM_GALLERY = 1;
    private static final int RESULT_OK = -1;
    Button btn;
    CircleImageView imgPerson;

    ImageView imgCompanyLogo, imageUpload;

    public TwoFragment() {
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
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgCompanyLogo = (ImageView) view.findViewById(R.id.imgCompanyLogo);
        imageUpload = (ImageView) view.findViewById(R.id.btnImgLogo);
        imageUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoUpload();
            }
        });
    }

    private void logoUpload() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select picture"), GET_FROM_GALLERY);
    }
    /* Get the real path from the URI */
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == GET_FROM_GALLERY) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if ( selectedImageUri!= null) {
                    // Get the path from the Uri
                    String path = getPathFromURI(selectedImageUri);

                    // Set the image in ImageView
                    //imgPerson.setImageURI(selectedImageUri);
                    Picasso.with(getActivity()).load(new File(path)).into(imgCompanyLogo);
                }
            }
        }

    }
}
