package io.blackbricks.bricktemplate.ui.sample;

import io.blackbricks.bricktemplate.databinding.ActivitySampleBinding;
import io.blackbricks.bricktemplate.ui.base.BaseSessionViewModel;

public class SampleViewModel extends BaseSessionViewModel<ActivitySampleBinding> {


    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        vmSessionComponent().inject(this);
    }
}
