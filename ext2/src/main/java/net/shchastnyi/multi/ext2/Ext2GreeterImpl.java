package net.shchastnyi.multi.ext2;

import net.shchastnyi.multi.Greeter;

public class Ext2GreeterImpl implements Greeter {

    @Override
    public String sayHello(String text) {
        return text + text;
    }
}
