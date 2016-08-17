package com.cinchapi.concourse.lang;

import org.junit.Test;

/**
 * Unit test for {@link Sort} building operation.
 *
 * @author ahmetkucuk
 */
public class SortTest {

    @Test(expected = IllegalStateException.class)
    public void testWrongOrderOfSort() {
        Sort.by("name").asc().and("age").and("gender").desc().asc();
    }
}
