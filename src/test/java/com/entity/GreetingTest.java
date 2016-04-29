package com.entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;


/**
 * @autor A_Nakonechnyi
 * @date 26.04.2016.
 */
public class GreetingTest {

    @Mock
    Greeting greeting2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetContent() throws Exception{
        //Greeting greeting2 = Mockito.mock(Greeting.class);
        Mockito.when(greeting2.getContent()).thenReturn("User");
        //Greeting greeting = new Greeting(2,"User");
        assertEquals("User", greeting2.getContent());

    }

    @Test
    public void testWithProgress() {

        Mockito.when(greeting2.getId()).thenAnswer(new Answer() {
            public int idCounter = 0;

            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return ++idCounter;
            }
        });

        assertEquals(1, greeting2.getId());
        assertEquals(2, greeting2.getId());
        assertEquals(3, greeting2.getId());

    }


}