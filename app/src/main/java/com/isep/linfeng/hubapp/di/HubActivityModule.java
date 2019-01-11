package com.isep.linfeng.hubapp.di;
import android.arch.lifecycle.ViewModelProviders;

import com.isep.linfeng.hubapp.HubActivity;
import com.isep.linfeng.hubapp.ViewModels.HubViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class HubActivityModule {
    @Provides
    static HubViewModel hubViewModel(HubActivity hubActivity){
        return ViewModelProviders.of(hubActivity,null).get(HubViewModel.class);
    }
}
