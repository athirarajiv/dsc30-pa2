import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebBrowserTest {


    @Test
    public void testGetCurrentPage() {
        WebBrowser webBrowser = new WebBrowser();
        assertEquals("google.com", webBrowser.getCurrentPage());
    }

    @Test
    public void testOpenNewPage() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.openNewPage("example.com");
        assertEquals("example.com", webBrowser.getCurrentPage());
        assertTrue(webBrowser.getHistory().contains("example.com"));
    }

    @Test
    public void testPreviousPage() {
        WebBrowser webBrowser = new WebBrowser();
        assertThrows(IllegalStateException.class, webBrowser::previousPage);

        webBrowser.openNewPage("example.com");
        webBrowser.openNewPage("another.com");
        webBrowser.previousPage();
        assertEquals("example.com", webBrowser.getCurrentPage());
    }

    @Test
    public void testNextPage() {
        WebBrowser webBrowser = new WebBrowser();
        assertThrows(IllegalStateException.class, webBrowser::nextPage);

        webBrowser.openNewPage("example.com");
        webBrowser.openNewPage("another.com");
        webBrowser.previousPage();
        webBrowser.nextPage();
        assertEquals("another.com", webBrowser.getCurrentPage());
    }

    @Test
    public void testNewTab() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.openNewPage("example.com");
        webBrowser.newTab();
        assertEquals("google.com", webBrowser.getCurrentPage());
        assertTrue(webBrowser.getHistory().isEmpty());
    }

    @Test
    public void testGetHistory() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.openNewPage("example.com");
        webBrowser.openNewPage("another.com");
        webBrowser.previousPage();

        assertTrue(webBrowser.getHistory().contains("example.com"));
        assertTrue(webBrowser.getHistory().contains("another.com"));
    }

    @Test
    public void testClearHistory() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.openNewPage("example.com");
        webBrowser.clearHistory();
        assertTrue(webBrowser.getHistory().isEmpty());
    }

    @Test
    public void testFindLink() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.openNewPage("example.com");
        webBrowser.openNewPage("another.com");
        webBrowser.previousPage();

        assertTrue(webBrowser.findLink("example.com"));
        assertEquals("example.com", webBrowser.getCurrentPage());

        assertFalse(webBrowser.findLink("nonexistent.com"));
    }
}
