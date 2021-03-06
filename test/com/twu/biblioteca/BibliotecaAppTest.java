package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("5".getBytes());

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
    }

    @Test
    public void shouldStartAndEndAppropriately() {
        exit.expectSystemExit();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setIn(System.in);
    }
}
