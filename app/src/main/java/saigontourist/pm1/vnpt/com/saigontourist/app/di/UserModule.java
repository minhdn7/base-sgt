package saigontourist.pm1.vnpt.com.saigontourist.app.di;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import saigontourist.pm1.vnpt.com.saigontourist.domain.interactor.user.UserInteractor;
import saigontourist.pm1.vnpt.com.saigontourist.domain.interactor.user.UserInteractorImpl;
import saigontourist.pm1.vnpt.com.saigontourist.domain.repository.api.UserApi;
import saigontourist.pm1.vnpt.com.saigontourist.ui.presenter.user.GetTokenDevPresenter;
import saigontourist.pm1.vnpt.com.saigontourist.ui.presenter.user.GetTokenDevPresenterImpl;


/**
 * Created by MinhDN on 18/4/2018.
 */
@Module(complete = false, library = true)
public class UserModule {
    private String svSaiGonT = "server_saigon";
    private String svVpoint = "server_vpoint";
    @Provides
    UserInteractor provideUserInteractor(UserInteractorImpl userInteractor) {
        return userInteractor;
    }


    @Provides
    UserApi provideRegisterApi(@Named("server_saigon") Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.build().create(UserApi.class);
    }

    @Provides
    GetTokenDevPresenter faqPresenter(GetTokenDevPresenterImpl tokenDevPresenter) {
        return tokenDevPresenter;
    }

}
