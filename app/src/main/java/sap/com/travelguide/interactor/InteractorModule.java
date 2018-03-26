package sap.com.travelguide.interactor;

import dagger.Module;
import dagger.Provides;
import sap.com.travelguide.interactor.detail.DetailInteractor;
import sap.com.travelguide.interactor.main.MainInteractor;

/**
 * Created by I344065 on 2018. 01. 18..
 */

@Module
public class InteractorModule {

    @Provides
    public MainInteractor provideMainInteractor() {
        return new MainInteractor();
    }

    @Provides
    public DetailInteractor provideDetailInteractor() {
        return new DetailInteractor();
    }

}
