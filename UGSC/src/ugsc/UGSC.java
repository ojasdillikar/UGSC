/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugsc;

import java.io.File;

/**
 *
 * @author ojasd
 */

public class UGSC {

    /**
     * @param args the command line arguments
     */
    static File[] oldListRoot = File.listRoots();
    public static void main(String[] args) {
        authdrive s = new authdrive();
        s.setVisible(true);
    }
}
