package main.java.com.example;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class AppTest {

    @Test
    void testMain() throws Exception {
        try (MockedConstruction<UserService> mockedUserService = Mockito.mockConstruction(UserService.class)) {
            App.main(new String[]{});

            // Verify that UserService methods were called on the mocked instance
            UserService mockService = mockedUserService.constructed().get(0);
            verify(mockService).findUser("admin");
            verify(mockService).deleteUser("admin");
        }
    }
}
