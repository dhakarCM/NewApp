package com.phppoets.newapp.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phppoets.newapp.R;
import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {

    private static final int GET_FROM_GALLERY = 1;
    private static final String TAG = "SignUpActivity";

    @BindView(R.id.imgPerson)
    CircleImageView imgPerson;
    @BindView(R.id.btnImgPerson)
    ImageView btnImgPerson;
    @BindView(R.id.layoutImgUpload)
    RelativeLayout layoutImgUpload;
    @BindView(R.id.editName)
    EditText editName;
    @BindView(R.id.editCompanyName)
    EditText editCompanyName;
    @BindView(R.id.editMobile)
    EditText editMobile;
    @BindView(R.id.editEmailId)
    EditText editEmailId;
    @BindView(R.id.editPassword)
    EditText editPassword;
    @BindView(R.id.imgShowPassword1)
    ImageView imgShowPassword1;
    @BindView(R.id.editRetypePassword)
    EditText editRetypePassword;
    @BindView(R.id.imgShowRetypePassword)
    ImageView imgShowRetypePassword;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.textSignIn)
    TextView textSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        textSignIn = (TextView) findViewById(R.id.textSignIn);
        btnImgPerson = (ImageView) findViewById(R.id.btnImgPerson);
        imgPerson = (CircleImageView) findViewById(R.id.imgPerson);

        textSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                finish();
            }
        });

        btnImgPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageChooser();

            }
        });

    }

    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GET_FROM_GALLERY);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == GET_FROM_GALLERY) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    String path = getPathFromURI(selectedImageUri);
                    Log.i(TAG, "Image Path : " + path);
                    // Set the image in ImageView
                    //imgPerson.setImageURI(selectedImageUri);
                    Picasso.with(this).load(new File(path)).into(imgPerson);
                }
            }
        }
    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }


}

