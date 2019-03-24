package saigontourist.pm1.vnpt.com.saigontourist.domain.repository.api;

import retrofit2.http.Body;

import retrofit2.http.POST;

import rx.Observable;

import saigontourist.pm1.vnpt.com.saigontourist.domain.model.user.GetTokenDevRequest;
import saigontourist.pm1.vnpt.com.saigontourist.domain.model.user.GetTokenDevResult;


/**
 * Created by MinhDN on 4/13/2018.
 */

public interface UserApi {
    /*@FormUrlEncoded
    @POST("/apiLogin/GetTokenNhaPhatTrien")
    Observable<GetTokenDevResult> getTokenDev(@Field("Para1") String param1, @Field("Para2") String param2);*/
    @POST("/apiLogin/GetTokenNhaPhatTrien")
    Observable<GetTokenDevResult> getTokenDev(@Body GetTokenDevRequest request);

}
