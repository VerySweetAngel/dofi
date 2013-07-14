/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.util;

/**
 *
 * @author Marta
 */
public enum Bundles {

    I18N_INDEX("I18N/index");
    private String path;

    Bundles(String path) {
        this.path = path;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }
}