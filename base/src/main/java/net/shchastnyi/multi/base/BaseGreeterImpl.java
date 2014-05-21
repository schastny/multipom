package net.shchastnyi.multi.base;

import net.shchastnyi.multi.Greeter;

public class BaseGreeterImpl implements Greeter {

    @Override
    public String sayHello(String text) {
        return text;
    }
}
