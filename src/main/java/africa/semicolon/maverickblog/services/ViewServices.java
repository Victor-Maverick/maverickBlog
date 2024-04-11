package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.View;
import africa.semicolon.maverickblog.dtos.requests.AddViewRequest;
import org.springframework.stereotype.Service;

@Service
public interface ViewServices {

    View addView(AddViewRequest viewRequest);
}
