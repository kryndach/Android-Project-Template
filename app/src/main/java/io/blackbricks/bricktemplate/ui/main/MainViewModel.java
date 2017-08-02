package io.blackbricks.bricktemplate.ui.main;

import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;

import io.blackbricks.bricktemplate.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel implements MenuAdapter.MenuClickListener {

    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        viewModelComponent().inject(this);

    }

    @Override
    public void onMenuHelpClicked() {

    }

    @Override
    public void onMenuContactClicked() {

    }
}