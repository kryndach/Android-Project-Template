package io.blackbricks.bricktemplate.ui.main;

import android.support.v7.widget.LinearLayoutManager;

import io.blackbricks.bricktemplate.databinding.ActivityMainBinding;
import io.blackbricks.bricktemplate.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel<ActivityMainBinding> implements MenuAdapter.MenuClickListener {

    private MenuAdapter menuAdapter;

    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        viewModelComponent().inject(this);

        initMenu();
    }

    private void initMenu() {
        menuAdapter = new MenuAdapter(getActivity(), this);
        getBinding().recyclerViewMenu.setLayoutManager(new LinearLayoutManager(getActivity()));
        getBinding().recyclerViewMenu.setAdapter(menuAdapter);
    }

    @Override
    public void onMenuHelpClicked() {

    }

    @Override
    public void onMenuContactClicked() {

    }
}