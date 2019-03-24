package saigontourist.pm1.vnpt.com.saigontourist.app.di;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import saigontourist.pm1.vnpt.com.saigontourist.app.BaseActivity;
import saigontourist.pm1.vnpt.com.saigontourist.app.BaseFragment;
import saigontourist.pm1.vnpt.com.saigontourist.app.SaiGonTouristApplication;
import saigontourist.pm1.vnpt.com.saigontourist.app.http.interceptor.AddCookieInterceptor;
import saigontourist.pm1.vnpt.com.saigontourist.app.http.interceptor.ReceiveCookieInterceptor;
import saigontourist.pm1.vnpt.com.saigontourist.domain.repository.LoginUserCookies;

import saigontourist.pm1.vnpt.com.saigontourist.ui.activity.FAQActivity;

/**
 * Created by linhl on 4/13/2018.
 */

@Module(
        //Module
        includes = {
                UserModule.class,
                RepositoryModule.class,
                RestAdapterProviderModule.class,
                PolicyModule.class

        },
        injects = {
                // app
                SaiGonTouristApplication.class,
                // - view
                BaseActivity.class,
                BaseFragment.class,


                // -- activity
                FAQActivity.class,
        },
        library = true
)
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.context;
    }

    @Provides
    public AddCookieInterceptor provideAddCookieInterceptor(LoginUserCookies loginUserCookies) {
        return new AddCookieInterceptor(loginUserCookies);
    }

    @Provides
    public ReceiveCookieInterceptor provideReceiveCookieInterceptor(LoginUserCookies loginUserCookies) {
        return new ReceiveCookieInterceptor(loginUserCookies);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(AddCookieInterceptor addCookieInterceptor,
                                            ReceiveCookieInterceptor receiveCookieInterceptor) {

        return new OkHttpClient.Builder()
                .connectTimeout(TimeUnit.MINUTES.toMillis(5L), TimeUnit.MILLISECONDS)
                .readTimeout(TimeUnit.MINUTES.toMillis(10L), TimeUnit.MILLISECONDS)
                .addInterceptor(addCookieInterceptor)
                .addInterceptor(receiveCookieInterceptor)
                .build();
    }

}
