package saigontourist.pm1.vnpt.com.saigontourist.domain.interactor.user;

import rx.Observable;
import saigontourist.pm1.vnpt.com.saigontourist.domain.model.user.GetTokenDevResult;


/**
 * Created by minhdn on 4/13/2018.
 */

public interface UserInteractor {

    Observable<GetTokenDevResult> executeGetTokenDev(String param1, String param2);
}
