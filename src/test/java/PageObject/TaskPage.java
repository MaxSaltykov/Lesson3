package PageObject;

public class TaskPage {

    public static String find_link = "//a[@id='find_link']";
    public static String navigation_bar = "//li[contains(@id, 'jira.top.navigation.bar:issues_drop_current')]";
    public static String showing_bar = "//div[@class='showing']";
    public static String pagination = "//div[@class='pagination']";
    public static String createLink = "//a[@id='create_link']";
    public static String summary = "//input[@id='summary']";
    public static String createIssueSubmit = "//input[@id='create-issue-submit']";
    public static String findLink = "//a[@id='find_link']";
    public static String topNavigationBar = "//a[@id='jira.top.navigation.bar:issues_drop_current_lnk']";
    public static String searcherQuery = "//input[@id='searcher-query']";
    public static String searchTasks = "//button[@original-title='Поиск задач']";
    public static String assignToMeLink = "//span[@class='assign-to-me-link']";
    public static String businessProsess = "//span[contains(text(),'Бизнес-процесс')]";
    public static String done = "//span[contains(text(),'Выполнено')]";
    public static String statusVal = "//span[@id='status-val']/span";
}
