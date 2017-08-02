package io.blackbricks.bricktemplate.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import io.blackbricks.bricktemplate.R;
import io.blackbricks.bricktemplate.databinding.ActivityMainBinding;
import io.blackbricks.bricktemplate.ui.sample.SampleFragment;

public class MainActivity extends ViewModelActivity<ActivityMainBinding, MainViewModel> {

    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setupViewModel(R.layout.activity_main, MainViewModel.class);
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        SampleFragment sampleFragment = SampleFragment.newInstance();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(getBinding().content.getId(), sampleFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onViewModelInitialized(MainViewModel viewModel) {
        super.onViewModelInitialized(viewModel);
        initMenu(viewModel);
    }

    private void initMenu(MainViewModel viewModel) {
        menuAdapter = new MenuAdapter(getActivity(), viewModel);
        getBinding().recyclerViewMenu.setLayoutManager(new LinearLayoutManager(getActivity()));
        getBinding().recyclerViewMenu.setAdapter(menuAdapter);
    }
}
