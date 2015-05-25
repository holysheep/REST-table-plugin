package ut.com.atlassian.test.testplugin;

import org.junit.Test;
import com.atlassian.test.testplugin.MyPluginComponent;
import com.atlassian.test.testplugin.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}