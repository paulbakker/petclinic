package example.interceptors;

import example.jmx.JMXBean;
import example.jmx.UsageLogMBean;

import javax.inject.Singleton;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
@Interceptor
@CountUsage
@Singleton
@JMXBean(objectName = "UsageLog")
public class UsageLogInterceptor implements UsageLogMBean {
    private int historySize = 100;

    private List<String> namesRequested = new ArrayList<String>(this.historySize);

    public synchronized void setHistorySize(int historySize) {
        this.historySize = historySize;
        this.namesRequested = new ArrayList<String>(historySize);
    }

    @AroundInvoke
    public synchronized Object logNameRequest(InvocationContext ctx) throws Exception {
        if (this.namesRequested.size() > this.historySize) {
            this.namesRequested.remove(0);
        }

        Object[] parameters = ctx.getParameters();
        if(parameters.length > 0 && parameters[0] instanceof String) {
            this.namesRequested.add((String)parameters[0]);
        }

        System.out.println("Now we have " + namesRequested.size() + " names stored");

        return ctx.proceed();
    }

    public synchronized String[] getNames() {
        String[] newArray = new String[namesRequested.size()];
        return namesRequested.toArray(newArray);
    }
}
