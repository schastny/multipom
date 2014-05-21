package net.shchastnyi.multi;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.shchastnyi.multi.base.BaseResourceLister;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Launcher
{

    private static Iterable<String> getModules()
    {
        Properties properties = new Properties();
        try ( InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("app/app.properties") ) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String moduleList = properties.getProperty("modules");
        if ( moduleList == null ) {
            throw new RuntimeException("No modules specified");
        }
        Iterable<String> modules = Splitter.on(",")
                .omitEmptyStrings()
                .split(moduleList);

        return modules;
    }

    public static void main( String[] args )
    {
        System.out.println( "Started Launcher." );

        List<String> contexts = Lists.newArrayList();
        for ( String module : Launcher.getModules() ) {
            contexts.add(module + ".spring.xml");
        }
        String[] ctxArr = Iterables.toArray(contexts, String.class);
        System.out.println( "Modules included: " + contexts);

        // Constructing the Application Context
        ApplicationContext ctxParent = new ClassPathXmlApplicationContext("app.spring.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext(ctxArr, ctxParent);


        // Working with lister beans
        Set<String> mods = Sets.newHashSet("base", "ext1", "ext2");
        for ( String module : Launcher.getModules() ) {
            if ( !mods.contains(module) ) continue;
            BaseResourceLister lister = ctx.getBean(module+"Lister", BaseResourceLister.class);
            System.out.println( lister.readResourcesNames() );
        }

        Greeter greeter = ctx.getBean("greeter", Greeter.class);
        System.out.println( greeter.sayHello("Good Day") );

        System.out.println( "Stopped Launcher." );
    }
}