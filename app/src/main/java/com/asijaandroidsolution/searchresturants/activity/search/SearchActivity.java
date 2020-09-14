package com.asijaandroidsolution.searchresturants.activity.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.asijaandroidsolution.searchresturants.R;
import com.asijaandroidsolution.searchresturants.activity.search.adapter.ResturantsAdapter;
import com.asijaandroidsolution.searchresturants.databinding.ActivitySearchBinding;
import com.asijaandroidsolution.searchresturants.model.CollectionModel;
import com.asijaandroidsolution.searchresturants.model.DataModel;
import com.asijaandroidsolution.searchresturants.web.WebServices;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivitySearchBinding binding;
    private ResturantsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySearchBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.btnSearch.setOnClickListener(this);
        binding.rvResturantList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvResturantList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSearch:
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(binding.getRoot().getWindowToken(), 0);
                binding.progressBar.setVisibility(View.VISIBLE);
                getResturantsList();
                break;
        }
    }

    private void getResturantsList() {
        WebServices.getInstance().getResturantsList(this,binding.edSearch.getText().toString());
    }

    public void onResponse(CollectionModel body) {
        hideProgressbar();
        adapter=new ResturantsAdapter(body.getRestaurants());
        binding.rvResturantList.setAdapter(adapter);
    }

    public void hideProgressbar() {
        binding.progressBar.setVisibility(View.GONE);
    }
}