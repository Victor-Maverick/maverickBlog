package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.View;
import africa.semicolon.maverickblog.data.repository.Views;
import africa.semicolon.maverickblog.dtos.requests.AddViewRequest;
import africa.semicolon.maverickblog.dtos.responses.ViewResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ViewServicesImpl implements ViewServices{
    private final Views views;
    @Override
    public ViewResponse addView(AddViewRequest viewRequest) {
        View view = new View();
        view.setViewer(viewRequest.getViewerName());
        view.setDateViewed(LocalDateTime.now());
        views.save(view);
        ViewResponse response =new ViewResponse();
        response.setId(view.getId());
        return response;
    }

    @Override
    public View findBy(String id) {
        return views.findViewById(id);
    }
}
