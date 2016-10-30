package io.blackbricks.bricktemplate.ui.sample;

import android.os.Bundle;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import cz.kinst.jakub.viewmodelbinding.ViewModelFragment;
import io.blackbricks.bricktemplate.BR;
import io.blackbricks.bricktemplate.R;
import io.blackbricks.bricktemplate.databinding.FragmentSampleBinding;

public class SampleFragment extends ViewModelFragment<FragmentSampleBinding, SampleViewModel> {

    public static SampleFragment newInstance() {
        Bundle bundle = new Bundle();
        // set arguments
        SampleFragment fragment = new SampleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public ViewModelBindingConfig<SampleViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.fragment_sample, SampleViewModel.class, BR.viewModel);
    }
}
