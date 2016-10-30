package io.blackbricks.bricktemplate.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import io.blackbricks.bricktemplate.BR;
import io.blackbricks.bricktemplate.R;
import io.blackbricks.bricktemplate.databinding.ActivityMainBinding;
import io.blackbricks.bricktemplate.ui.sample.SampleFragment;

public class MainActivity extends ViewModelActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public ViewModelBindingConfig<MainViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.activity_main, MainViewModel.class, BR.viewModel);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SampleFragment sampleFragment = SampleFragment.newInstance();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(getBinding().content.getId(), sampleFragment);
        fragmentTransaction.commit();
    }
}
