package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.repository.Views;
import africa.semicolon.maverickblog.dtos.requests.AddViewRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ViewServicesTest {
    @Autowired
    ViewServices viewServices;
    @Autowired
    Views views;

    @Test
    public void addViewTest(){
        AddViewRequest viewRequest = new AddViewRequest();
        viewServices.addView(viewRequest);
        assertEquals(1, views.count());

    }
}