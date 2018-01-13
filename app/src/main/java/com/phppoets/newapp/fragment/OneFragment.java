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
import android.widget.EditText;
import android.widget.ImageView;

import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class OneFragment extends Fragment {
    private static final int GET_FROM_GALLERY = 1;
    private static final int RESULT_OK = -1;
    Button btn;
    CircleImageView imgPerson;
    EditText editName, editMobile, editEmail, editAdd, editIdCard, editGrade, editCatagory, editClassification, editYear;

    ImageView imageButton;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_one, container, false);

        // Inflate the layout for this fragment
        return myView;


    }

    @Override
    public void onViewCreated(View myView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(myView, savedInstanceState);
        btn = (Button) myView.findViewById(R.id.btnSave);
        imgPerson = (CircleImageView) myView.findViewById(R.id.imgPersonProfile);
        editName = (EditText) myView.findViewById(R.id.editName);
        editMobile = (EditText) myView.findViewById(R.id.editMobile);
        editEmail = (EditText) myView.findViewById(R.id.editEmail);
        editAdd = (EditText) myView.findViewById(R.id.editAddress);
        editIdCard = (EditText) myView.findViewById(R.id.editIdCard);
        editGrade = (EditText) myView.findViewById(R.id.editGrade);
        editCatagory = (EditText) myView.findViewById(R.id.editCategory);
        editClassification = (EditText) myView.findViewById(R.id.editClassification);
        editYear = (EditText) myView.findViewById(R.id.editYoJ);
        imageButton = (ImageView) myView.findViewById(R.id.btnImgProfile);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageChooser();
            }
        });
    }

    private void openImageChooser() {
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
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode == RESULT_OK) {
            if (requestCode == GET_FROM_GALLERY) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    String path = getPathFromURI(selectedImageUri);

                    // Set the image in ImageView
                    //imgPerson.setImageURI(selectedImageUri);
                    Picasso.with(getActivity()).load(new File(path)).into(imgPerson);
                }
            }
        }
    }
}
