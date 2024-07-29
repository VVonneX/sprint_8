import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
 public class AccountTest {

    private String name;
    private boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Виктория Ещенко", true},
                {"Виктория  Ещенко", false},
                {" Виктория Ещенко", false},
                {"Виктория Ещенко ", false},
                {"Вик тория Ещенко", false},
                {"Виктория Ещен ко", false},
                {"Викт ория Ещен ко", false}
        };
    }

    @Test
    @DisplayName("account test")
    @Description("Check work method checkNameToEmboss")
    public void AccountTest() {
        Account account = new Account(name);
        Assert.assertEquals(expected, account.checkNameToEmboss());
    }
}