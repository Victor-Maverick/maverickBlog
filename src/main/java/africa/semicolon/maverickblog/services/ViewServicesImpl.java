package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.View;
import africa.semicolon.maverickblog.data.repository.Views;
import africa.semicolon.maverickblog.dtos.requests.AddViewRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    }
}
