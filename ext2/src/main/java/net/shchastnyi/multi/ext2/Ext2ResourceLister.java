package net.shchastnyi.multi.ext2;

import net.shchastnyi.multi.base.BaseResourceLister;

public class Ext2ResourceLister extends BaseResourceLister {

    public String getResourceDir() {
        String MODULE_NAME = "ext2";
        return String.format("%1$s/src/main/resources/%1$s/", MODULE_NAME);
    }

}
