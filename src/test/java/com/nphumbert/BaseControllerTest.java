package com.nphumbert;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BaseControllerTest {

    private class TestableBaseController extends BaseController {

    }

    @Test
    public void should_hash_text() {
        // given
        BaseController controller = new TestableBaseController();

        // when
        String hash = controller.hash("text");

        // then
        assertThat(hash, is("[-104, 45, -98, 62, -71, -106, -11, 89, -26, 51, -12, -47, -108, -34, -13, 118, 29, -112, -97, 90, 59, 100, 125, 26, -123, 31, -22, -42, 124, 50, -55, -47]"));
    }
}