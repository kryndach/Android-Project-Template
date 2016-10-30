package io.blackbricks.bricktemplate.ui.sample;

import io.blackbricks.bricktemplate.databinding.FragmentSampleBinding;
import io.blackbricks.bricktemplate.ui.base.BaseViewModel;

public class SampleViewModel extends BaseViewModel<FragmentSampleBinding> {


    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        viewModelComponent().inject(this);
    }
}
