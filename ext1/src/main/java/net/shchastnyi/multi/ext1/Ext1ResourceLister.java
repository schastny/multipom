package net.shchastnyi.multi.ext1;

import net.shchastnyi.multi.base.BaseResourceLister;

public class Ext1ResourceLister extends BaseResourceLister {

    public String getResourceDir() {
        String MODULE_NAME = "ext1";
        return String.format("%1$s/src/main/resources/%1$s/", MODULE_NAME);
    }

}
