package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.View;
import africa.semicolon.maverickblog.dtos.requests.AddViewRequest;
import africa.semicolon.maverickblog.dtos.responses.ViewResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ViewServices {

    ViewResponse addView(AddViewRequest viewRequest);

    View findBy(String id);
}
