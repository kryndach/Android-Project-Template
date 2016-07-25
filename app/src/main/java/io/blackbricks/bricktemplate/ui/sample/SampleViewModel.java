package io.blackbricks.bricktemplate.ui.sample;

import io.blackbricks.bricktemplate.databinding.ActivitySampleBinding;
import io.blackbricks.bricktemplate.ui.base.BaseViewModel;

public class SampleViewModel extends BaseViewModel<ActivitySampleBinding> {


    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        viewModelComponent().inject(this);
    }
}
