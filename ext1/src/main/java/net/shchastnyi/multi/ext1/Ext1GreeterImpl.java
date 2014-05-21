package net.shchastnyi.multi.ext1;

import net.shchastnyi.multi.Greeter;

public class Ext1GreeterImpl implements Greeter {

    @Override
    public String sayHello(String text) {
        return text.toUpperCase();
    }
}
