package com.cyrleb.sudoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterViewAnimator;
import android.widget.ImageView;

import com.cyrleb.sudoku.databinding.ActivitySettingsMenuBinding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class SettingsMenu extends AppCompatActivity {

    private ActivitySettingsMenuBinding mBinding;
    private static final int PICK_IMAGE = 100;
    private Bitmap avatarBitmap = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySettingsMenuBinding.inflate(getLayoutInflater());
        View v = mBinding.getRoot();

        mBinding.inputUsername.setText(Singleton.getInstance().getUser().getName());
        mBinding.avatar.setImageBitmap(Singleton.getInstance().getUser().getAvatar());
        this.avatarBitmap = Singleton.getInstance().getUser().getAvatar();

        mBinding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setUserImage(avatarBitmap);
                Singleton.getInstance().setUserName(mBinding.inputUsername.getText().toString());
                finish();
            }
        });

        mBinding.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });

        setContentView(v);
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == Activity.RESULT_OK) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                mBinding.avatar.setImageBitmap(bitmap);
                this.avatarBitmap = bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}