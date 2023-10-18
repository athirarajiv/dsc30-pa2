import java.util.ArrayList;
import utilities.FullStackException;


/*
 * NAME: Athira Rajiv
 * PID: A16317648
 */

/**
 * This class represents a simple web browser with navigation history. It allows you to
 * open, navigate between pages, and maintain a history of visited links.
 *
 * @author Athira Rajiv
 * @since 2023-10-16
 */
public class WebBrowser {

    private String currentPage;
    private ArrayList<String> history;
    private MyStack prev;
    private MyStack next;

    private static final String DEFAULT_PAGE = "google.com";

    /**
     * Initializes a new web browser instance with the default page.
     */

    public WebBrowser() {
        currentPage = DEFAULT_PAGE;
        history = new ArrayList<>();
        prev = new MyStack();
        next = new MyStack();
    }

    /**
     * Gets the current page that the browser is displaying.
     *
     * @return The current page URL.
     */
    public String getCurrentPage() {
        return currentPage;
    }

    /**
     * Opens a new page and update the browser's state.
     *
     * @param newLink the URL of the page to open.
     */
    public void openNewPage(String newLink) {
        prev.push(currentPage);
        currentPage = newLink;
        history.add(newLink);
        next.clear();
    }

    /**
     * Navigates to the previous page in the browser's history.
     *
     * @throws IllegalStateException if there is no previous page.
     */
    public void previousPage() {
        if (prev.isEmpty()) {
            throw new IllegalStateException("No previous page available");
        }
        next.push(currentPage);
        currentPage = prev.pop();
        history.add(currentPage);
    }

    /**
     * Navigates to the next page in the browser's history.
     *
     * @throws IllegalStateException if there is no next page.
     */
      public void nextPage() {
          if (next.isEmpty()) {
              throw new IllegalStateException("No next page available");
          }
          prev.push(currentPage);
          currentPage = next.pop();
          history.add(currentPage);
    }

    /**
     * Open a new tab, resetting the browser to the default page.
     * This action does not clear the history.
     */
    public void newTab() {
        currentPage = DEFAULT_PAGE;
        next.clear();
        prev.clear();
    }

    /**
     * Gets the history of visited pages.
     *
     * @return an ArrayList containing the history of visited pages.
     */
    public ArrayList getHistory() {
        return history;
    }

    /**
     * Clears the browser's history.
     */
    public void clearHistory() {
        history.clear();
    }

    /**
     * Find and navigate to a specific link in the browser's history if it exists.
     *
     * @param link The URL to search for in the history.
     * @return true if the link was found and navigated to, false otherwise.
     */
    public boolean findLink(String link) {
        if (history.contains(link)) {
            openNewPage(link);
            return true;
        }
        return false;
    }
    }

}
