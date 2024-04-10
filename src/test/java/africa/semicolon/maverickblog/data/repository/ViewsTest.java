package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.View;
import africa.semicolon.maverickblog.dtos.CreateViewRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ViewsTest {
    @Autowired
    Views views;

    @Test
    public void addViewTest(){
        View view = new View();
        views.save(view);
        assertEquals(1, views.count());
    }
    @Test
    public void deleteViewTest(){
        View view = new View();
        views.save(view);
        assertEquals(1, views.count());
        views.delete(view);
        assertEquals(0, views.count());
    }

}