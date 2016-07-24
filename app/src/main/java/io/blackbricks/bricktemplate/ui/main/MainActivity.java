package io.blackbricks.bricktemplate.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Inject;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import io.blackbricks.bricktemplate.BR;
import io.blackbricks.bricktemplate.R;
import io.blackbricks.bricktemplate.databinding.ActivityMainBinding;
import io.blackbricks.bricktemplate.ui.base.BaseViewModelActivity;

public class MainActivity extends BaseViewModelActivity<ActivityMainBinding, MainViewModel> {

    @Inject
    StorIOSQLite storIOSQLite;

    @Override
    public ViewModelBindingConfig<MainViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.activity_main, MainViewModel.class, BR.viewModel);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
    }
}
