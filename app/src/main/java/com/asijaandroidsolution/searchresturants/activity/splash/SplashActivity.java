package com.asijaandroidsolution.searchresturants.activity.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.asijaandroidsolution.searchresturants.R;
import com.asijaandroidsolution.searchresturants.activity.BaseActivity;
import com.asijaandroidsolution.searchresturants.activity.search.SearchActivity;
import com.asijaandroidsolution.searchresturants.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity {

    private Animation logoAnim;
    private Animation titleAnim;
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySplashBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_anim);
        titleAnim = AnimationUtils.loadAnimation(this, R.anim.title_anim);

        logoAnim.setDuration(2000);
        titleAnim.setDuration(2000);
        binding.imageLogo.startAnimation(logoAnim);
        binding.tvTitle.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.tvTitle.startAnimation(titleAnim);
                binding.tvTitle.setVisibility(View.VISIBLE);
                binding.tvTitle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent= new Intent(SplashActivity.this, SearchActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },3000);
            }
        },2000);

    }
}