package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.dtos.requests.AddViewRequest;
import org.springframework.stereotype.Service;

@Service
public interface ViewServices {

    void addView(AddViewRequest viewRequest);
}
